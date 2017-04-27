package itransition.solodkin.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * Created by User on 15.04.2017.
 */

@Service
public class CloudService {

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @Autowired
    private Cloudinary cloudinary;

    public String fileUpload(MultipartFile toUpload) {
        Map uploadResult = Collections.emptyMap();
        try {
            uploadResult = cloudinary.uploader().upload(toUpload.getBytes(), ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) uploadResult.get("url");
    }

    @Bean
    public Cloudinary createCloud() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "mremil6",
                "api_key", "914886547763236",
                "api_secret", "7uRCqk5H0NJHoNQdsQ0oPhDsm1o"));
    }

    public void saveNewPhotos(List<String> urls, Long userId) {
        User user = this.userService.findOne(userId);
        Profile profile = user.getProfile();
        List<CloudPhoto> photos = profile.getCloudPhoto();
        for (String url : urls) {
            CloudPhoto cloudPhoto = new CloudPhoto();
            cloudPhoto.setUrl(url);
            photos.add(cloudPhoto);
        }
        profile.setCloudPhoto(photos);
        user.setProfile(profile);
        this.userService.save(user);
    }
}