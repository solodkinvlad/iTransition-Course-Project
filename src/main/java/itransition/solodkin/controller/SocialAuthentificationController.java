package itransition.solodkin.controller;

import itransition.solodkin.model.Provider;
import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Влад on 20.04.2017.
 */
@Controller
@RequestMapping("/social")
public class SocialAuthentificationController {
    private Facebook facebook;
    private Twitter twitter;
    private UserService userService;

    public SocialAuthentificationController(Facebook facebook, UserService userService) {
        this.facebook = facebook;
        this.userService = userService;
    }

    @GetMapping("/facebook")
    public String saveFacebookUser() {
        User user = new User();

        org.springframework.social.facebook.api.User fb_user =
                facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, "id");

        Long providedId = Long.parseLong(fb_user.getId());
        user.setProvider(new Provider());
        user.getProvider().setProvidedId(providedId);
        user.getProvider().setProvider("facebook");

        user.setUserRole(UserRole.ROLE_USER);
        user.setPassword(RandomStringUtils.random(8));



        return "home";
    }

    @GetMapping("/twitter")
    public String saveTwitterUser() {
        User user = new User();

        twitter.userOperations().getUserProfile().getId();
    }
}
