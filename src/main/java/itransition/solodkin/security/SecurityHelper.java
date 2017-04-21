package itransition.solodkin.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Влад on 21.04.2017.
 */
public final class SecurityHelper {

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
}
