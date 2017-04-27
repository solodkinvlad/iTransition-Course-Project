package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.User;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.security.SecurityServiceImpl;
import itransition.solodkin.service.CloudphotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by eabil on 26.04.2017.
 */

@RestController
public class LikeController {
    private CloudphotoService cloudphotoService;

    public LikeController(CloudphotoService cloudphotoService) {
        this.cloudphotoService = cloudphotoService;
    }

    @PostMapping("/like")
    public @ResponseBody
    CloudPhoto addLike(CloudPhoto photo) {
        Long currentId = SecurityServiceImpl.getUserId();
        if (!photo.getUserSet().contains(currentId)) {
            photo.getUserSet().add(currentId);
        } else {
            photo.getUserSet().remove(currentId);
        }
        this.cloudphotoService.save(photo);
        return photo;
    }
}
