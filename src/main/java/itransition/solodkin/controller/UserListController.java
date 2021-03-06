package itransition.solodkin.controller;

import itransition.solodkin.model.User;
import itransition.solodkin.model.UserRole;
import itransition.solodkin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eabil on 01.05.2017.
 */
@Controller
public class UserListController {
    private UserService userService;

    public UserListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    private String getUserList (Model model){

        List<User> listOfUsers = this.userService.findAll();
        model.addAttribute("user_list", listOfUsers);
        model.addAttribute("user_roles", Arrays.asList(UserRole.values()));
        return "admins_panel";
    }

    @PostMapping("/admins_panel")
    private String setUserList(){
        return "";
    }

}
