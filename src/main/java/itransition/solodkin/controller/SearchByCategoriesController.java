package itransition.solodkin.controller;

import itransition.solodkin.model.*;
import itransition.solodkin.service.UserService;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eabil on 28.04.2017.
 */
@Controller
public class SearchByCategoriesController {
    private UserService userService;

    public SearchByCategoriesController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search_profile_by_categories")
    private String setSearch(Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        model.addAttribute("genders", Arrays.asList(Gender.values()));
        model.addAttribute("filmingTypes", Arrays.asList(FilmingType.values()));
        model.addAttribute("numberOfModels", Arrays.asList(NumberOfModels.values()));
        return "/search_profile_by_categories";
    }

    @PostMapping("/search_by_categories")
    private List<User> search(Profile profile, Model model) {
        List<User> result = new ArrayList<>();
        List<User> users = this.userService.findAll();
        for (User user : users) {
            if ((user.getProfile().getFilmingTypes().equals(profile.getFilmingTypes())) &&
                    (user.getProfile().getGender().equals(profile.getGender())) &&
                    (user.getProfile().getNumberOfModels().equals(profile.getNumberOfModels()))){
                result.add(user);
            }

        }
        return result;
    }
}
