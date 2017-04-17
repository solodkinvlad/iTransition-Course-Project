package itransition.solodkin.security;

import itransition.solodkin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ikatlinsky
 * @since 3/29/17
 */
@Service
@RequiredArgsConstructor
public class CrmUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CrmUserDetails(this.userRepository.findByEmail(username));
    }
}