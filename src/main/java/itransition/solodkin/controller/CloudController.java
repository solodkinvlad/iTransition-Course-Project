package itransition.solodkin.controller;

import itransition.solodkin.service.CloudService;
import itransition.solodkin.service.NudeDetector;
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
    private NudeDetector nudeDetector;

    public CloudController(CloudService cloudService, NudeDetector nudeDetector) {
        this.cloudService = cloudService;
        this.nudeDetector = nudeDetector;
    }

    @PostMapping("/upload{thisId}")
    public String upload(@RequestParam("photo") List<MultipartFile> photosToUpload, @PathVariable Long thisId) {
        List<String> urls = new ArrayList<>();
        for (MultipartFile photo : photosToUpload) {
            String url = cloudService.fileUpload(photo);
            if(!nudeDetector.check(url)) {
                return "porn_content";
            }
            urls.add(url);
        }
        this.cloudService.saveNewPhotos(urls, thisId);
        return "redirect:/id" + thisId;
    }

}
