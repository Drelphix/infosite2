package by.infosite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorizationController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage(Model model){
        char[] password = new char[40];
        model.addAttribute("username", "");
        model.addAttribute("password", password);
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public String showRegistrationPage(Model model){
        char[] password = new char[40];
        model.addAttribute("username", "");
        model.addAttribute("password", password);
        model.addAttribute("email", "");
        return "registration";
    }
}
