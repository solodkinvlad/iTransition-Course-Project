package itransition.solodkin.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;


/**
 * Created by User on 15.04.2017.
 */

@Service
public class CloudService {

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
}