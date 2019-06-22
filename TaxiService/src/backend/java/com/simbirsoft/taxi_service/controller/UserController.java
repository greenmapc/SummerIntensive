package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.util.SelectCreator;
import com.simbirsoft.taxi_service.util.validator.AutoFormValidator;
import com.simbirsoft.taxi_service.util.validator.DriverFormValidator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operator")
public class UserController {
    @InitBinder("form")
    public void initAutoFormBinder(WebDataBinder binder) {
        binder.addValidators(new AutoFormValidator());
    }

    @InitBinder("driverForm")
    public void initDriverFormBinder(WebDataBinder binder) {
        binder.addValidators(new DriverFormValidator());
    }


    @GetMapping("/create_auto")
    public String createAutoPage(@AuthenticationPrincipal User user,
                                 Model model) {
        model.addAttribute("form", new AutoForm());
        model.addAttribute("user", user);
        fillAutoSelectFields(model);

        return "operator/create_auto";
    }

    @PostMapping("/create_auto")
    public String createAuto(@Validated @ModelAttribute("form") AutoForm form,
                             BindingResult bindingResult,
                             @AuthenticationPrincipal User user,
                             Model model) {
        if (bindingResult.hasErrors()) {
            fillAutoSelectFields(model);

            return "operator/create_auto";
        }
        // ToDo AutoService.create

        model.addAttribute("user", user);

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
                               Model model,
                               @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            return "operator/create_driver";
        }

        //ToDo driverService.create

        model.addAttribute("user", user);
        return "redirect:/drivers";
    }

    @GetMapping("/acts")
    public String actsPage(Model model) {
        return "acts/list";
    }

    @GetMapping("/create_act_from_company_to_driver")
    public String actFromCompanyToDriverPage(Model model) {
        return "acts/company_to_driver";
    }

    @PostMapping("/create_act_from_company_to_driver")
    public String createActFromCompanyToDriver(Model model) {
        return "redirect:operator/acts";
    }

    @GetMapping("/create_act_from_driver_to_company")
    public String actFromDriverToCompanyPage(Model model) {
        return "acts/driver_to_company";
    }

    @PostMapping("/create_act_from_driver_to_company")
    public String createActFromDriverToCompany(Model model) {
        return "redirect:operator/acts";
    }

    @GetMapping("/create_act_from_driver_to_driver")
    public String actFromDriverToDriverPage(Model model) {
        return "acts/driver_to_driver";
    }

    @PostMapping("/create_act_from_driver_to_driver")
    public String createActFromDriverToDriver(Model model) {
        return "redirect:operator/acts";
    }


    private void fillAutoSelectFields(Model model) {
        model.addAttribute("bodyType", SelectCreator.bodyTypeCreate());
        model.addAttribute("driveType", SelectCreator.driveTypeCreate());
        model.addAttribute("transmissionType", SelectCreator.transmissionType());
    }
}
