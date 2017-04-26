package itransition.solodkin.controller;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.security.SecurityServiceImpl;
import itransition.solodkin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    private UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id{userId}")
    public String getUserProfile(@PathVariable Long userId, Model model) {
        Profile profile = this.userService.findOne(userId).getProfile();
        boolean ableToEdit = SecurityServiceImpl.loggedUser().getAuthorities().contains(UserRole.ROLE_ADMIN)
                || userId.equals(SecurityServiceImpl.getUserId());
        model.addAttribute("ableToEdit", ableToEdit);
        model.addAttribute("profile", profile);
        model.addAttribute("thisId", userId);
        model.addAttribute("photos", profile.getCloudPhoto());
        return "profile";
    }

    @GetMapping("/profile")
    public String checkYourProfile() {
        return "redirect:/id"+ SecurityServiceImpl.getUserId();
    }
}
