package itransition.solodkin.controller;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.Provider;
import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.ProviderService;
import itransition.solodkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/social")
public class SocialAuthentificationController {
    private Facebook facebook;
    private Twitter twitter;
    private UserService userService;
    private ProviderService providerService;

    @Autowired
    private SecurityService securityService;

    public SocialAuthentificationController(Facebook facebook, Twitter twitter, UserService userService, ProviderService providerService) {
        this.facebook = facebook;
        this.twitter = twitter;
        this.userService = userService;
        this.providerService = providerService;
    }

    @GetMapping("/facebook")
    public String saveFacebookUser() {
        org.springframework.social.facebook.api.User fb_user =
                facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, "id");

        User user = new User();
        Long providedId = Long.parseLong(fb_user.getId());
        user.setProvider(new Provider());
        user.getProvider().setProvidedId(providedId);
        user.getProvider().setProvider("facebook");
        user.setEmail(providedId + ".facebook@portfl.by");
        user.setPassword(providedId + "facebook");
        user.setUserRole(UserRole.ROLE_USER);
        user.setProfile(new Profile());
        boolean newUser = this.providerService.findByProvidedId(providedId) == null;
        if (newUser) {
            this.userService.create(user);
        }

        this.securityService.autoLogin(user.getEmail(), user.getPassword());

        if (newUser) {
            Long userId = this.userService.findByEmail(user.getEmail()).getId();
            return "redirect:/users/profile_settings" + userId;
        }

        return "redirect:/";
    }

    @GetMapping("/twitter")
    public String saveTwitterUser() {
        Long providedId = twitter.userOperations().getUserProfile().getId();

        User user = new User();
        user.setProvider(new Provider());
        user.getProvider().setProvidedId(providedId);
        user.getProvider().setProvider("twitter");
        user.setEmail(providedId + ".twitter@portfl.by");
        user.setPassword(providedId + "twitter");
        user.setProfile(new Profile());
        user.setUserRole(UserRole.ROLE_USER);

        boolean newUser = this.providerService.findByProvidedId(providedId) == null;
        if (newUser) {
            this.userService.create(user);
        }

        this.securityService.autoLogin(user.getEmail(), user.getPassword());

        if (newUser) {
            Long userId = this.userService.findByEmail(user.getEmail()).getId();
            return "redirect:/users/profile_settings" + userId;
        }
        return "redirect:/";
    }
}
