package itransition.solodkin.controller;

import itransition.solodkin.model.*;
import itransition.solodkin.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eabil on 02.05.2017.
 */
@Controller
@RequestMapping("/")
public class SearchByNicknameController {

    private ProfileService profileService;

    public SearchByNicknameController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/search_by_nickname")
    public String searchByNickname (String nickname, Model model) {
        List<Profile> result = new ArrayList<>();
//        List<Profile> profiles = this.profileService.findAll();
//        for (Profile profile : profiles){
//            if (profile.getNickname().equals(nickname)){
//                result.add(profile);
//            }
//        }
        List<Profile> profiles = this.profileService.findByNickname(nickname);
        model.addAttribute("profiles", profiles);
        ProfileSearch profileSearch = new ProfileSearch();
        model.addAttribute("profile", profileSearch);
        model.addAttribute("genders", Arrays.asList(Gender.values()));
        model.addAttribute("filmingTypes", Arrays.asList(FilmingType.values()));
        model.addAttribute("numberOfModels", Arrays.asList(NumberOfModels.values()));
        return "/search_profile_by_categories";
    }
}
