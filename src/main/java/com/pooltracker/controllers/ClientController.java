package com.pooltracker.controllers;


import com.pooltracker.models.Address;
import com.pooltracker.models.Client;
import com.pooltracker.models.State;
import com.pooltracker.models.data.AddressDao;
import com.pooltracker.models.data.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Kevin Grier
 */

@Controller
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AddressDao addressDao;

    // Request path: /clients
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "My Clients");

        return "clients/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddClientForm(Model model) {

        model.addAttribute("title", "Add Client");
        model.addAttribute(new Client());
        model.addAttribute(new Address());
        model.addAttribute("states", State.values());

        return "clients/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddClientForm(@ModelAttribute @Valid Client newClient, @ModelAttribute @Valid Address newAddress,
                                       Errors errors, Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Client");
            model.addAttribute("states", State.values());
            return "clients/add";
        }

        System.out.print(newAddress);
        System.out.print(newClient);

        addressDao.save(newAddress);
        newClient.setAddress(newAddress);
        clientDao.save(newClient);
        return "redirect:";
    }


}
