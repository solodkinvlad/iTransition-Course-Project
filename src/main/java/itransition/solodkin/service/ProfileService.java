package itransition.solodkin.service;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import itransition.solodkin.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by eabil on 28.04.2017.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProfileService {
    private ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile findOne(Long userId) {
        return this.profileRepository.findOne(userId);
    }

    public List<Profile> findAll() {
        return this.profileRepository.findAll();
    }

    @Transactional
    public void save(Profile profile) {
        this.profileRepository.save(profile);
    }
}
