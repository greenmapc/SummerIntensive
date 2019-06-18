package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.forms.OperatorForm;
import com.simbirsoft.taxi_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin")
@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;  //примитивно, Матвей, приди, порядок наведи
    }

    @GetMapping("/registrateOperator")
    public String getFormRegistrateOperator(ModelMap modelMap) {
        return "registrateOperator";
    }

    @PostMapping("/registrateOperator")
    public String registrateOperator(@ModelAttribute OperatorForm form, ModelMap model) {
        System.out.println(true);
        try {
            userService.registrateOperator(form);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("operatorForm", form);
            return "registrateOperator";
        }
        return "redirect:/drivers";
    }


}
