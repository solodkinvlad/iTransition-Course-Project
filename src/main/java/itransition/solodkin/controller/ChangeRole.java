package itransition.solodkin.controller;

import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.security.SecurityService;
import itransition.solodkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChangeRole {
    private UserService userService;
    private SecurityService securityService;

    @Autowired
    public ChangeRole(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping(value = "/changeRole")
    @PreAuthorize("hasRole('ADMIN')")
    public
    @ResponseBody
    String addComment(@RequestParam String userId) {
        User user = this.userService.findOne(Long.parseLong(userId));
        if (user.getUserRole() == UserRole.ROLE_ADMIN) {
            user.setUserRole(UserRole.ROLE_USER);
        } else {
            user.setUserRole(UserRole.ROLE_ADMIN);
        }
        this.userService.save(user);
        return user.getUserRole().getLabel();
    }
}
