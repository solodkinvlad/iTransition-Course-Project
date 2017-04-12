package itransition.solodkin.service;

import itransition.solodkin.model.User;
import itransition.solodkin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Влад on 12.04.2017.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void create(User user) {
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

}
