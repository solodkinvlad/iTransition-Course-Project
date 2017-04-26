package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.User;
import itransition.solodkin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eabil on 26.04.2017.
 */

@Controller
public class LikeController {
    private UserService userService;

    public LikeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/like{thisId}")
    public String addLike(CloudPhoto photo, @PathVariable Long thisId) {
        User user = this.userService.findOne(thisId);
        List<CloudPhoto> cloudPhotos = user.getProfile().getCloudPhoto();
        int index = cloudPhotos.indexOf(photo);
        if (!cloudPhotos.get(index).getUserSet().contains(thisId)){
            cloudPhotos.get(index).getUserSet().add(thisId);
            this.userService.save(user);
        }
        return "redirect:/id" + thisId;
    }
}
