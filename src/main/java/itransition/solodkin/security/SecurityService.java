package itransition.solodkin.security;

import org.springframework.stereotype.Service;

/**
 * Created by Влад on 25.04.2017.
 */
@Service
public interface SecurityService {
    Long getUserId();
    CrmUserDetails loggedUser();
    void autoLogin(String username, String password);
}
