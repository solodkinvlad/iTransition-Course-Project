package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.Tag;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.CloudphotoService;
import itransition.solodkin.service.TagService;
import org.apache.commons.lang.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class TagController {
    private CloudphotoService cloudphotoService;
    private TagService tagService;

    @Autowired
    public TagController(CloudphotoService cloudphotoService, TagService tagService) {
        this.cloudphotoService = cloudphotoService;
        this.tagService = tagService;
    }

    @GetMapping(value = "/addTag")
    public
    @ResponseBody
    String addTag(@RequestParam String photoId, @RequestParam String text) {
        CloudPhoto photo = this.cloudphotoService.findOne(Long.parseLong(photoId));
        Tag tag = this.tagService.findByTag(text);
        if (tag == null) {
            tag = new Tag();
            tag.setTag(text);
        }
        photo.getTags().add(tag);
        cloudphotoService.save(photo);
        ArrayList<String> tagsArr = new ArrayList<>();
        for (Tag tag1 : photo.getTags()) {
            tagsArr.add(tag1.getTag());
        }
        return StringUtils.join(tagsArr, " ");
    }
}
