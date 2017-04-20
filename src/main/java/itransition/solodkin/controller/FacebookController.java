package itransition.solodkin.controller;

import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Влад on 20.04.2017.
 */
@Controller
@RequestMapping("/facebook")
public class FacebookController {
    private Facebook facebook;
    private UserService userService;

    public FacebookController(Facebook facebook, UserService userService) {
        this.facebook = facebook;
        this.userService = userService;
    }

    @GetMapping
    public String saveFacebookUser() {
        User user = new User();
        org.springframework.social.facebook.api.User facebookUser = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class, "email");
        user.setEmail(facebookUser.getEmail());
        user.setUserRole(UserRole.ROLE_USER);
        user.setPassword(RandomStringUtils.random(8));
        if (userService.findByEmail(user.getEmail()) == null)
            userService.create(user);
        return "home";
    }

}
