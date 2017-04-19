package itransition.solodkin.service;

import itransition.solodkin.model.Profile;
import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

/**
 * Created by eabil on 19.04.2017.
 */
@Service
public class FacebookConnectionSignUp implements ConnectionSignUp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        User user = new User("", "", UserRole.ROLE_USER, new Profile());
        user.setUsername(connection.getDisplayName());
        //user.setPassword(randomAlphabetic(8));
        userRepository.save(user);
        return user.getUsername();
    }
}
