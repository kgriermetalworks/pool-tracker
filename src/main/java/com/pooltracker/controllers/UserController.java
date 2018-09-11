package com.pooltracker.controllers;


import com.pooltracker.models.User;
import com.pooltracker.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserDao userDao;


    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model) {

        model.addAttribute("title", "Register");
        User user = new User();
        model.addAttribute("user", user);


        return "user/register";
    }
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {


        List<User> sameName = userDao.findByEmail(user.getEmail());
        if(!errors.hasErrors() && user.getPassword().equals(verify) && sameName.isEmpty()) {
            model.addAttribute("user", user);
            userDao.save(user);
            return "user/registered";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("title", "Register");
            if(!user.getPassword().equals(verify)) {
                model.addAttribute("message", "Passwords must match");
                user.setPassword("");
            }

            if(!sameName.isEmpty()) {
                model.addAttribute("message", "Email is already associated with a User");
            }
            return "user/register";
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginForm(Model model) {

        model.addAttribute("title", "Login");
        model.addAttribute(new User());

        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLoginForm(Model model, @ModelAttribute User user, HttpServletResponse response) {

        List<User> userList = userDao.findByEmail(user.getEmail());

        if (userList.isEmpty()) {
            model.addAttribute("title","Login");
            model.addAttribute("message", "Invalid User Email");

            return "user/login";
        }

        User loggedin = userList.get(0);

        if (loggedin.getPassword().equals(user.getPassword())) {
            Cookie c = new Cookie("user", user.getEmail());
            c.setPath("/");
            response.addCookie(c);

            return "redirect:/clients/";

        }else {
            model.addAttribute("title", "Login");
            model.addAttribute("message", "Invalid Password");
            return "user/login";
        }

    }

    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }

        }
        return "pooltracker/index";
    }


}
