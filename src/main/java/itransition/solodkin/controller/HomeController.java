package itransition.solodkin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Влад on 24.04.2017.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    private String getHomePage(Model model) {
        return "home";
    }
}
