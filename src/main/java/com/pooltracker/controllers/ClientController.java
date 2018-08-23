package com.pooltracker.controllers;


import com.pooltracker.models.*;
import com.pooltracker.models.data.AddressDao;
import com.pooltracker.models.data.ClientDao;
import com.pooltracker.models.data.PoolDao;
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

    @Autowired
    private PoolDao poolDao;

    // Request path: /clients
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "My Clients");

        return "clients/index";
    }

    // Adds client and associated classes. Displays add form.
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddClientForm(Model model) {

        model.addAttribute("title", "Add Client");
        model.addAttribute(new Client());
        model.addAttribute("states", State.values());
        model.addAttribute("filterTypes", FilterType.values());
        model.addAttribute("pumpHps", PumpHp.values());
        model.addAttribute("pumpPhs", PumpPh.values());
        return "clients/add";
    }

    //Add feature. checks validation and persists client.
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddClientForm(@ModelAttribute @Valid Client newClient,
                                       Errors errors, Model model) {


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Client");
            model.addAttribute("client", newClient);
            model.addAttribute("states", State.values());
            model.addAttribute("filterTypes", FilterType.values());
            model.addAttribute("pumpHps", PumpHp.values());
            model.addAttribute("pumpPhs", PumpPh.values());
            return "clients/add";
        }


        clientDao.save(newClient);
        return "redirect:";
    }

    //Remove feature. displays all clients that are persisted.
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveClientForm(Model model) {
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "Remove Client");
        return "clients/remove";
    }

    //Remove feature. Allows a single deletion or multiple.
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveClientForm(@RequestParam int[] clientIds) {

        for (int clientId : clientIds) {
            clientDao.delete(clientId);
        }

        return "redirect:";
    }


    // Does NOT function at this time. need to work out update to the database.
    @RequestMapping(value = "edit/{clientId}")
    public String displayEditForm(Model model, @PathVariable int clientId, State state) {
        model.addAttribute("title", "Edit Client");
        Client c = clientDao.findOne(clientId);
        Address a = addressDao.findOne(clientId);
        model.addAttribute("client", c);
        model.addAttribute("states", state.values());
        model.addAttribute("filterTypes", FilterType.values());
        model.addAttribute("pumpHps", PumpHp.values());
        model.addAttribute("pumpPhs", PumpPh.values());

        return "clients/edit";

    }
    // Does NOT function at this time. need to work out update to the database.
    @RequestMapping(value = "edit/{clientId}", method = RequestMethod.POST)
    public String processEditForm( @PathVariable int clientId, State state,
                                   @ModelAttribute @Valid Client editClient,
                                   Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Client");
            model.addAttribute("client", editClient);
            model.addAttribute("state", state.values());
            model.addAttribute("filterTypes", FilterType.values());
            model.addAttribute("pumpHps", PumpHp.values());
            model.addAttribute("pumpPhs", PumpPh.values());
            return "clients/edit";
        }

        Client updateClient = clientDao.findOne(clientId);
        updateClient.setFirstName(editClient.getFirstName());
        updateClient.setLastName(editClient.getLastName());
        clientDao.save(updateClient);

        return "redirect:";

    }

    //Displays the personal info of a added client by its id.
    @RequestMapping(value = "client-info/{id}", method = RequestMethod.GET)
    public String displayClientInfo(Model model, @PathVariable int id) {

        model.addAttribute("title", "Client Information");
        Client c = clientDao.findOne(id);
        model.addAttribute("client", c);
        Address a = addressDao.findOne(id);
        model.addAttribute("address", a);


        return "clients/client-info";

    }

    //Displays the pool info of a added client by its id.
    @RequestMapping(value = "pool-info/{id}", method = RequestMethod.GET)
    public String displayPoolInfo(Model model, @PathVariable int id) {

        model.addAttribute("title", "Pool Information");
        Client c = clientDao.findOne(id);
        model.addAttribute("client", c);
        Pool p = poolDao.findOne(id);
        model.addAttribute("pool", p);


        return "clients/pool-info";

    }

    //Displays the dosage view of a added client by its id.
    @RequestMapping(value = "dosage-view/{id}", method = RequestMethod.GET)
    public String displayDosageInfo(Model model, @PathVariable int id) {

        Client c = clientDao.findOne(id);
        Pool p = poolDao.findOne(id);
        float gallons = p.getGallons();
        Dosage d = new Dosage(gallons);

        //System.out.println(d.toString());

        model.addAttribute("title", "Dosage Information");
        model.addAttribute("client", c);
        model.addAttribute("dosage", d);

        return "dosage/dosage-view";

    }

}
