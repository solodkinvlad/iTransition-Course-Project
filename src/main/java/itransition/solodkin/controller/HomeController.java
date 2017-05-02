package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.CloudPhotoComparator;
import itransition.solodkin.model.Tag;
import itransition.solodkin.model.TagComparator;
import itransition.solodkin.service.CloudphotoService;
import itransition.solodkin.service.TagService;
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
    private TagService tagService;

    @Autowired
    public HomeController(CloudphotoService cloudphotoService, TagService tagService) {
        this.cloudphotoService = cloudphotoService;
        this.tagService = tagService;
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
        List<Tag> tags = this.tagService.findAll();
        tags.sort(new TagComparator());
        if (tags.size() > 20) {
            model.addAttribute("tags", tags.subList(0, 20));
        } else {
            model.addAttribute("tags", tags);
        }
        return "home";
    }
}
