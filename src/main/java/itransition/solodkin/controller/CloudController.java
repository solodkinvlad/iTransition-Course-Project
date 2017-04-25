package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import itransition.solodkin.service.CloudService;
import itransition.solodkin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by eabil on 24.04.2017.
 */
@Controller
@RequestMapping("/photo")
public class CloudController {
    private CloudService cloudService;

    private UserService userService;

    public CloudController(CloudService cloudService, UserService userService) {
        this.cloudService = cloudService;
        this.userService = userService;
    }

    @PostMapping("/upload{thisId}")
    public String upload(@RequestParam("photo") List<MultipartFile> photosToUpload, @PathVariable Long thisId) {
        List<String> urls = new ArrayList<>();
        for (MultipartFile photo : photosToUpload) {
            urls.add(cloudService.fileUpload(photo));
        }
        User user = this.userService.findOne(thisId);
        Profile profile = user.getProfile();
        Set<CloudPhoto> photos = profile.getCloudPhoto();
        for (String url : urls) {
            CloudPhoto cloudPhoto = new CloudPhoto();
            cloudPhoto.setUrl(url);
            photos.add(cloudPhoto);
        }
        profile.setCloudPhoto(photos);
        user.setProfile(profile);
        this.userService.save(user);
        return "redirect:/id" + thisId;
    }

}
