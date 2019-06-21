package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.forms.AutoForm;
import com.simbirsoft.taxi_service.forms.DriverForm;
import com.simbirsoft.taxi_service.models.User;
import com.simbirsoft.taxi_service.validators.AutoFormValidator;
import com.simbirsoft.taxi_service.validators.DriverFormValidator;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @GetMapping("/create_auto")
    public String createAutoPage(@AuthenticationPrincipal User user,
                                 Model model) {
        model.addAttribute("form", new AutoForm());
        model.addAttribute("user", user);

        return "operator/create_auto";
    }

    @PostMapping("/create_auto")
    public String createAuto(@Validated @ModelAttribute("form") AutoForm form,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "operator/create_auto";
        }
        return "redirect:/autos";
    }

    @GetMapping("/create_driver")
    public String createDriverPage(@AuthenticationPrincipal User user,
                                   Model model) {
        model.addAttribute("driverForm", new DriverForm());
        model.addAttribute("user", user);
        return "operator/create_driver";
    }

    @PostMapping("/create_driver")
    public String createDriver(@Validated @ModelAttribute("driverForm") AutoForm form,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "operator/create_driver";
        }
        return "redirect:/drivers";
    }

    @InitBinder("form")
    public void initAutoFormBinder(WebDataBinder binder) {
        binder.addValidators(new AutoFormValidator());
    }

    @InitBinder("driverForm")
    public void initDriverFormBinder(WebDataBinder binder) {
        binder.addValidators(new DriverFormValidator());
    }
}
