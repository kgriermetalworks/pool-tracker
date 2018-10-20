package com.pooltracker.controllers;


import com.pooltracker.models.Appointment;
import com.pooltracker.models.User;
import com.pooltracker.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


/**
 * Created by Kevin Grier
 */


@Controller
@RequestMapping("appointments")
public class AppointmentController {
    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private PoolDao poolDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AppointmentDao appointmentDao;

    @RequestMapping(value = "")
    public String index(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {

        if(email.equals("none")) {
            return "redirect:/login";
        }

        User user = userDao.findByEmail(email).get(0);

        model.addAttribute("user", user.getBusiness());
        model.addAttribute("appointments", user.getAppointments());
        model.addAttribute("title", "My Appointments");

        return "appointments/index";
    }

    // Schedule an appointment. Associated with logged in user.
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddAppointmentForm(Model model, @CookieValue(value = "user", defaultValue = "none") String email) {

        if (email.equals("none")) {
            return "redirect:/login";
        }

        User user = userDao.findByEmail(email).get(0);

        model.addAttribute("user", user.getBusiness());
        model.addAttribute(new Appointment());
        model.addAttribute("title", "Schedule Appointment");

        return "appointments/add";
    }



    // Schedule feature. checks validation and persists appointment.
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAppointmentForm(@ModelAttribute @Valid Appointment newAppointment,
                                            Errors errors, Model model,
                                            @CookieValue(value = "user", defaultValue = "none") String email) {

        if(email.equals("none")) {
            return "redirect:/login";
        }
        User user = userDao.findByEmail(email).get(0);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Schedule Appointment");
            model.addAttribute("appointment", newAppointment);

            return "appointments/add";
        }

        newAppointment.setUser(user);  //adds user reference to appointment

        appointmentDao.save(newAppointment);
        return "redirect:";

    }




}
