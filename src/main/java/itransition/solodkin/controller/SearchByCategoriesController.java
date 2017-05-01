package itransition.solodkin.controller;

import itransition.solodkin.model.*;
import itransition.solodkin.service.ProfileService;
import itransition.solodkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eabil on 28.04.2017.
 */
@Controller
public class SearchByCategoriesController {
    private ProfileService profileService;

    @Autowired
    public SearchByCategoriesController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/search_profile_by_categories")
    private String setSearch(Model model) {
        ProfileSearch profileSearch = new ProfileSearch();
        model.addAttribute("profile", profileSearch);
        model.addAttribute("genders", Arrays.asList(Gender.values()));
        model.addAttribute("filmingTypes", Arrays.asList(FilmingType.values()));
        model.addAttribute("numberOfModels", Arrays.asList(NumberOfModels.values()));
        return "/search_profile_by_categories";
    }

    @PostMapping("/search_by_categories")
    private String search(ProfileSearch profile, Model model) {
        List<Profile> result = new ArrayList<>();
        if (profile.getGenders().size() != 0
                && profile.getFilmingTypes().size() != 0
                && profile.getNumberOfModels().size() != 0) {
            List<Profile> profiles = this.profileService.findAll();
            for (Profile prof : profiles) {
                if ((prof.getFilmingTypes().containsAll(profile.getFilmingTypes())) &&
                        (profile.getGenders().contains(prof.getGender())) &&
                        (prof.getNumberOfModels().containsAll(profile.getNumberOfModels()))) {
                    result.add(prof);
                }
            }
        }
        model.addAttribute("profiles", result);
        ProfileSearch profileSearch = new ProfileSearch();
        model.addAttribute("profile", profileSearch);
        model.addAttribute("genders", Arrays.asList(Gender.values()));
        model.addAttribute("filmingTypes", Arrays.asList(FilmingType.values()));
        model.addAttribute("numberOfModels", Arrays.asList(NumberOfModels.values()));
        return "/search_profile_by_categories";
    }
}
