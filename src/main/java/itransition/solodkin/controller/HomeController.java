package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.CloudPhotoComparator;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.CloudphotoService;
import itransition.solodkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Влад on 24.04.2017.
 */
@Controller
public class HomeController {

    private SecurityService securityService;
    private UserService userService;
    private CloudphotoService cloudphotoService;

    @Autowired
    public HomeController(SecurityService securityService, UserService userService, CloudphotoService cloudphotoService) {
        this.securityService = securityService;
        this.userService = userService;
        this.cloudphotoService = cloudphotoService;
    }

    @GetMapping("/")
    private String getHomePage(Model model) {
        List<CloudPhoto> photos  = this.cloudphotoService.findAll();
        photos.sort(new CloudPhotoComparator());
        if (photos.size() > 8) {
            model.addAttribute("photos", photos.subList(0, 8));
        } else {
            model.addAttribute("photos", photos);
        }
        if (this.securityService.loggedUser() != null) {
            model.addAttribute("role", this.userService.findOne(this.securityService.getUserId()).getUserRole().getLabel());
        } else {
            model.addAttribute("role", "");
        }
        return "home";
    }
}
