package com.pooltracker.pooltracker;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pooltracker")
public class PoolTrackerController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("title", "PoolTracker" );
        return "pooltracker/index";

    }

}
