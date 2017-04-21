package itransition.solodkin.controller;

import itransition.solodkin.model.Profile;
import itransition.solodkin.security.SecurityHelper;
import itransition.solodkin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by eabil on 21.04.2017.
 */
@Controller
@RequestMapping("/users")
public class ProfileSettingsController {
    private UserService userService;

    public ProfileSettingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile_settings")
    private String setProfile(Model model) {
        Profile profile = this.userService.findOne(SecurityHelper.getUserId()).getProfile();
        model.addAttribute("profile", profile);
        return "/users/profile_settings";
    }

    @PostMapping("/profile_settings")
    private String saveProfile(@Valid Profile profile, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/profile_settings";
        }
        return "redirect:/id"+SecurityHelper.getUserId();
    }
}
