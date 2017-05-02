package itransition.solodkin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Влад on 02.05.2017.
 */
@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String getSettings() {

        return "settings";
    }
}
