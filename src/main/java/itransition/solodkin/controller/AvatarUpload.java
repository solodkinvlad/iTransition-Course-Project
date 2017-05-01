package itransition.solodkin.controller;

import itransition.solodkin.model.Profile;
import itransition.solodkin.service.CloudService;
import itransition.solodkin.service.NudeDetector;
import itransition.solodkin.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by eabil on 01.05.2017.
 */
@Controller
public class AvatarUpload {
    private CloudService cloudService;
    private ProfileService profileService;
    private NudeDetector nudeDetector;

    public AvatarUpload(CloudService cloudService, ProfileService profileService, NudeDetector nudeDetector) {
        this.cloudService = cloudService;
        this.profileService = profileService;
        this.nudeDetector = nudeDetector;
    }

    @PostMapping("/avatar/upload{thisId}")
    public String upload(@RequestParam("photo") MultipartFile photoToUpload, @PathVariable Long thisId) {
        String url = cloudService.fileUpload(photoToUpload);
//            if(!nudeDetector.check(url)) {
//                return "porn_content";
//            }
        Profile profile = this.profileService.findOne(thisId);
        profile.setAvatar(url);
        this.profileService.save(profile);
        return "redirect:/id" + thisId;
    }


}
