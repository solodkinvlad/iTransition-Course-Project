package itransition.solodkin.controller;

import itransition.solodkin.repository.CloudphotoRepository;
import itransition.solodkin.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindByTagsController {

    private TagRepository tagRepository;

    private CloudphotoRepository cloudphotoRepository;

    @Autowired
    public FindByTagsController(TagRepository tagRepository, CloudphotoRepository cloudphotoRepository) {
        this.tagRepository = tagRepository;
        this.cloudphotoRepository = cloudphotoRepository;
    }

    @GetMapping("/find-by-tags")
    public String findByTags(@RequestParam Long tagId, Model model) {
        model.addAttribute("tag", this.tagRepository.findOne(tagId));

        return "photos_by_tags";
    }

}
