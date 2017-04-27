package itransition.solodkin.controller;

import itransition.solodkin.service.CloudService;
import itransition.solodkin.service.NudeDetector;
import itransition.solodkin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eabil on 24.04.2017.
 */
@Controller
@RequestMapping("/photo")
public class CloudController {
    private CloudService cloudService;

    private UserService userService;

    private NudeDetector nudeDetector;

    public CloudController(CloudService cloudService, UserService userService, NudeDetector nudeDetector) {
        this.cloudService = cloudService;
        this.userService = userService;
        this.nudeDetector = nudeDetector;
    }

    @PostMapping("/upload{thisId}")
    public String upload(@RequestParam("photo") List<MultipartFile> photosToUpload, @PathVariable Long thisId) {
        List<String> urls = new ArrayList<>();
        for (MultipartFile photo : photosToUpload) {
            String url = cloudService.fileUpload(photo);
//            if(!nudeDetector.check(url)) {
//                return "porn_content";
//            }
            urls.add(url);
        }
        this.cloudService.savePhoto(urls, thisId);
        return "redirect:/id" + thisId;
    }

}
