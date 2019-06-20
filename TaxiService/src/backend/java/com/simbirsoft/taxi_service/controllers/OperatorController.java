package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.forms.AutoForm;
import com.simbirsoft.taxi_service.forms.DriverForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @GetMapping("/create_auto")
    public String createAutoPage(Model model) {
        model.addAttribute("form", new AutoForm());
        return "operator/create_auto";
    }

    @PostMapping("/create_auto")
    public String createAuto(@ModelAttribute("form") AutoForm form,
                             Model model,
                             BindingResult bindingResult) {

        return "redirect:/autos";
    }

    @GetMapping("/create_driver")
    public String createDriverPage(Model model) {
        model.addAttribute("form", new DriverForm());
        return "operator/create_driver";
    }

    @PostMapping("/create_driver")
    public String createDriver(@ModelAttribute("form") AutoForm form,
                               Model model,
                               BindingResult bindingResult) {

        return "redirect:/drivers";
    }
}
