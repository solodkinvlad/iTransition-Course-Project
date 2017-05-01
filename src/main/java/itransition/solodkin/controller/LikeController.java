package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.CloudphotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class LikeController {
    private CloudphotoService cloudphotoService;

    private SecurityService securityService;

    @Autowired
    public LikeController(CloudphotoService cloudphotoService, SecurityService securityService) {
        this.cloudphotoService = cloudphotoService;
        this.securityService = securityService;
    }

    @GetMapping(value = "/like")
    public
    @ResponseBody
    String addLike(@RequestParam String photoId) {
        CloudPhoto photo = this.cloudphotoService.findOne(Long.parseLong(photoId));
        Set<Long> likedUsers = photo.getUserSet();
        if (securityService.getUserId() != null){
            if (!likedUsers.remove(securityService.getUserId())) {
                likedUsers.add(securityService.getUserId());
            }
            photo.setUserSet(likedUsers);
            this.cloudphotoService.save(photo);
        }
        return String.valueOf(likedUsers.size());
    }
}
