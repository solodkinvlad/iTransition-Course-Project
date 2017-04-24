package itransition.solodkin.controller;

import itransition.solodkin.model.*;
import itransition.solodkin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;

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

    @GetMapping("/profile_settings{userId}")
    private String setProfile(Model model, @PathVariable Long userId) {
        Profile profile = this.userService.findOne(userId).getProfile();
        model.addAttribute("profile", profile);
        model.addAttribute("genders", Arrays.asList(Gender.values()));
        model.addAttribute("filmingTypes", Arrays.asList(FilmingType.values()));
        model.addAttribute("numberOfModels", Arrays.asList(NumberOfModels.values()));
        return "/users/profile_settings";
    }

    @PostMapping("/profile_settings{userId}")
    private String saveProfile(@Valid Profile profile, BindingResult result, Model model, @PathVariable Long userId) {
        if (result.hasErrors()) {
            return "users/profile_settings";
        }
        User user = this.userService.findOne(userId);
        user.setProfile(profile);
        this.userService.create(user);
        return "redirect:/id"+userId;
    }
}
