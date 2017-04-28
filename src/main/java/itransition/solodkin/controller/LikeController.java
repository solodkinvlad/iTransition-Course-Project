package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.security.SecurityServiceImpl;
import itransition.solodkin.service.CloudphotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class LikeController {
    private CloudphotoService cloudphotoService;

    public LikeController(CloudphotoService cloudphotoService) {
        this.cloudphotoService = cloudphotoService;
    }

    @GetMapping(value = "/like")
    public
    @ResponseBody
    String addLike(@RequestParam String photoId) {
        CloudPhoto photo = this.cloudphotoService.findOne(Long.parseLong(photoId));
        Long currentId = SecurityServiceImpl.getUserId();
        Set<Long> likedUsers = photo.getUserSet();
        if (!likedUsers.remove(currentId)) {
            likedUsers.add(currentId);
        }
        photo.setUserSet(likedUsers);
        this.cloudphotoService.save(photo);
        return String.valueOf(likedUsers.size());
    }
}
