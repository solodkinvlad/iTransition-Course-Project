package itransition.solodkin.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public final class SecurityServiceImpl implements SecurityService{

    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;

    public SecurityServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    public static Long getUserId() {
        return loggedUser().getId();
    }

    public static CrmUserDetails loggedUser() {
        return (CrmUserDetails) getAuthenticationWithCheck().getPrincipal();
    }

    public static Authentication getAuthenticationWithCheck() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean checkAuthenticationExists = authentication != null && authentication.isAuthenticated();
        if (checkAuthenticationExists) {
            return authentication;
        }

        throw new BadCredentialsException("Authentication failed.");
    }

    public void autoLogin(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }
}
