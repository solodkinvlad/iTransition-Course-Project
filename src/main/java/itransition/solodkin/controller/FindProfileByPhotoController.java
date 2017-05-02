package itransition.solodkin.controller;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.Profile;
import itransition.solodkin.service.CloudphotoService;
import itransition.solodkin.service.ProfileService;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by eabil on 02.05.2017.
 */
@Controller
@RequestMapping("/")
public class FindProfileByPhotoController {
    private CloudphotoService cloudphotoService;
    private ProfileService profileService;

    public FindProfileByPhotoController(CloudphotoService cloudphotoService, ProfileService profileService) {
        this.cloudphotoService = cloudphotoService;
        this.profileService = profileService;
    }

    @PostMapping("/imgToProfile")
    public @ResponseBody
    String findProfile(@RequestParam Long photoId) {
        CloudPhoto photo = this.cloudphotoService.findOne(photoId);
        List<Profile> profiles = this.profileService.findAll();
        Long profileId = 0L;
        for (Profile prof : profiles) {
            if (prof.getCloudPhoto().contains(photo)) {
                profileId = prof.getId();
                break;
            }
        }
        return String.valueOf(profileId);
    }
}
