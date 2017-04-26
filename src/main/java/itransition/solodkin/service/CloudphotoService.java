package itransition.solodkin.service;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.model.User;
import itransition.solodkin.repository.CloudphotoRepository;
import itransition.solodkin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by eabil on 26.04.2017.
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CloudphotoService {

    private CloudphotoRepository cloudRepository;

    public CloudphotoService(CloudphotoRepository cloudRepository) {
        this.cloudRepository = cloudRepository;
    }

    public CloudPhoto findOne(Long cloudPhotoId) {
        return this.cloudRepository.findOne(cloudPhotoId);
    }

    @Transactional
    public void save(CloudPhoto cloudPhoto) {
        this.cloudRepository.save(cloudPhoto);
    }

}
