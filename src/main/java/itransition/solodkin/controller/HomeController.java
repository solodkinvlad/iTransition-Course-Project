package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.CloudPhotoComparator;
import itransition.solodkin.service.CloudphotoService;
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

    private CloudphotoService cloudphotoService;

    @Autowired
    public HomeController(CloudphotoService cloudphotoService) {
        this.cloudphotoService = cloudphotoService;
    }

    @GetMapping("/")
    private String getHomePage(Model model) {
        List<CloudPhoto> photos  = this.cloudphotoService.findAll();
        photos.sort(new CloudPhotoComparator());
        if (photos.size() > 10) {
            model.addAttribute("photos", photos.subList(0, 10));
        } else {
            model.addAttribute("photos", photos);
        }
        return "home";
    }
}
