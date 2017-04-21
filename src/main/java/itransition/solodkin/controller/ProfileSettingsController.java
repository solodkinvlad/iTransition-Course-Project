package itransition.solodkin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by eabil on 21.04.2017.
 */
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class ProfileSettingsController {

    @GetMapping("/profile_settings")
    private String newUser(Model model) {
        User user = new User();
        user.setUserRole(UserRole.ROLE_USER);
        model.addAttribute("user", user);
        return "users/registration";
    }

    @PostMapping("/profile_settings")
    private String saveUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/registration";
        }
        this.userService.create(user);
        return "redirect:/home";
    }
}
