package itransition.solodkin.controller;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.security.CrmUserDetails;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {

    private UserService userService;

    private SecurityService securityService;

    @Autowired
    public ProfileController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping("/id{userId}")
    public String getUserProfile(@PathVariable Long userId, Model model) {
        Profile profile = this.userService.findOne(userId).getProfile();
        CrmUserDetails loggedUser = securityService.loggedUser();

        boolean ableToEdit = ((loggedUser != null)
                && (securityService.loggedUser().getAuthorities().contains( new SimpleGrantedAuthority(UserRole.ROLE_ADMIN.name()))
                || userId.equals(securityService.getUserId())));
        model.addAttribute("ableToEdit", ableToEdit);
        model.addAttribute("profile", profile);
        model.addAttribute("thisId", userId);
        return "profile";
    }

    @GetMapping("/profile")
    public String checkYourProfile() {
        return "redirect:/id" + securityService.getUserId();
    }
}
