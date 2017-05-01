package itransition.solodkin.controller;

import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Objects;

@ControllerAdvice
@SessionAttributes({"principal", "currentId", "role"})
public class UserControllerAdvice {
    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public UserControllerAdvice(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @ModelAttribute("principal")
    public String getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            }
            return principal.toString();
        }
        return "";
    }

    @ModelAttribute("currentId")
    public String getCurrentId() {
        return String.valueOf(this.securityService.getUserId());
    }

    @ModelAttribute("role")
    public String getRole() {
        if (this.securityService.getUserId() == null) {
            return null;
        }
        return this.userService.findOne(this.securityService.getUserId()).getUserRole().getLabel();
    }
}
