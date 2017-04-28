package itransition.solodkin.service;

import itransition.solodkin.model.CloudPhoto;
import itransition.solodkin.repository.CloudphotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CloudphotoService {

    private CloudphotoRepository cloudRepository;

    @Autowired
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
