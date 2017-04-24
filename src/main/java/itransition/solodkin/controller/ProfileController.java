package itransition.solodkin.controller;

import itransition.solodkin.model.UserRole;
import itransition.solodkin.security.SecurityHelper;
import itransition.solodkin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Влад on 21.04.2017.
 */
@Controller
public class ProfileController {

    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id{userId}")
    public String getUserProfile(@PathVariable Long userId, Model model) {
        boolean ableToEdit = SecurityHelper.loggedUser().getAuthorities().contains(UserRole.ROLE_ADMIN)
                || userId.equals(SecurityHelper.getUserId());
        model.addAttribute("ableToEdit", ableToEdit);
        model.addAttribute("profile" ,this.userService.findOne(userId).getProfile());
        model.addAttribute("thisId", userId.toString());
        return "profile";
    }

    @GetMapping("/profile")
    public String checkYourProfile() {
        return "redirect:/id"+SecurityHelper.getUserId();
    }
}
