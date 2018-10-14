package com.pooltracker.controllers;


import com.pooltracker.models.Dosage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


    //Displays the dosage calculator.
    @RequestMapping(value = "dosage-calculator", method = RequestMethod.GET)
    public String dosageCalc(Model model) {


        model.addAttribute("title", "Dosage Calculator");
        model.addAttribute(new Dosage());
        return "dosage/dosage-calculator";

    }

    //Displays the dosage calculator results.
    @RequestMapping(value = "dosage-calculator", method = RequestMethod.POST)
    public String dosageCalcResults(@ModelAttribute Dosage newDosage, Model model) {

        Dosage d = new Dosage(newDosage.getGallons());

        model.addAttribute("title", "Dosage Calculator");
        model.addAttribute("dosage", d);


        return "dosage/dosage-calculator";

    }

}
