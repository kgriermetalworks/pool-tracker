package com.pooltracker.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kevin Grier
 */

@Controller
@RequestMapping("pooltracker")
public class PoolTrackerController {

    //Request path: /pooltracker
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "Welcome to PoolTracker" );
        return "pooltracker/index";

    }

}
