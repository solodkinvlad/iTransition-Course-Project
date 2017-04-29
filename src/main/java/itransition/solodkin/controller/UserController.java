package itransition.solodkin.controller;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by Влад on 19.04.2017.
 */
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private SecurityService securityService;

    private UserService userService;

    @Autowired
    public UserController(SecurityService securityService, UserService userService) {
        this.securityService = securityService;
        this.userService = userService;
    }

    @GetMapping("/registration")
    private String newUser(Model model) {
        User user = new User();
        user.setUserRole(UserRole.ROLE_USER);
        model.addAttribute("user", user);
        return "users/registration";
    }

    @PostMapping("/registration")
    private String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/registration";
        }
        if(this.userService.findByEmail(user.getEmail()) == null) {
            user.setProfile(new Profile());
            this.userService.create(user);
            this.securityService.autoLogin(user.getEmail(),user.getPassword());
            return "redirect:/users/profile_settings" + securityService.getUserId();
        } else {
            return "users/registration";
        }
    }
}
