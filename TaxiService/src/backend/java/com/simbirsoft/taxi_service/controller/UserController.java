package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.model.Roles;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.util.freemaker_select_creator.CreateActSelectCreator;
import com.simbirsoft.taxi_service.util.freemaker_select_creator.CreateAutoSelectCreator;
import com.simbirsoft.taxi_service.util.validator.AutoFormValidator;
import com.simbirsoft.taxi_service.util.validator.DriverFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/operator")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final AutoService autoService;
    private final DriverService driverService;
    private final ActService actService;

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

        return "user/create_auto";
    }

    @PostMapping("/create_auto")
    public String createAuto(@Validated @ModelAttribute("form") AutoForm form,
                             BindingResult bindingResult,
                             @AuthenticationPrincipal User user,
                             Model model) {
        if (bindingResult.hasErrors()) {
            fillAutoSelectFields(model);
            return "user/create_auto";
        }
        autoService.createAuto(form);
        model.addAttribute("user", user);
        return "redirect:/autos";
    }

    @GetMapping("/create_driver")
    public String createDriverPage(@AuthenticationPrincipal User user,
                                   Model model) {
        model.addAttribute("driverForm", new DriverForm());
        model.addAttribute("user", user);

        return "user/create_driver";
    }

    @PostMapping("/create_driver")
    public String createDriver(@Validated @ModelAttribute("driverForm") DriverForm form,
                               BindingResult bindingResult,
                               Model model,
                               @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            return "user/create_driver";
        }
        driverService.createDriver(form);
        model.addAttribute("user", user);
        return "redirect:/drivers";
    }

    @GetMapping("/acts")
    public String actsPage(@AuthenticationPrincipal User user,
                           Model model) {
        model.addAttribute("user", user);
        return "acts/list";
    }

    @GetMapping("/create_act_from_company_to_driver")
    public String actFromCompanyToDriverPage(@AuthenticationPrincipal User user,
                                             Model model) {
        model.addAttribute("formCD", new CompanyToDriverActForm());
        model.addAttribute("drivers",
                CreateActSelectCreator.fillDriverSelectFields(driverService.getAllWithoutRentSorted()));
        model.addAttribute("autos",
                CreateActSelectCreator.fillAutoSelectFields(autoService.findAllFree()));
        model.addAttribute("user", user);

        return "acts/company_to_driver";
    }

    @PostMapping("/create_act_from_company_to_driver")
    public String createActFromCompanyToDriver(
            @ModelAttribute("formCD") CompanyToDriverActForm form,
            @AuthenticationPrincipal User user,
            Model model) {
        form.setDrafter(user.getLastName() + " " + user.getFirstName() + " " + user.getPatronymic());
        actService.createActFromCompanyToDriver(form);
        return "redirect:/operator/acts";
    }

    @GetMapping("/create_act_from_driver_to_company")
    public String actFromDriverToCompanyPage(@AuthenticationPrincipal User user,
                                             Model model) {
        model.addAttribute("user", user);

        return "acts/driver_to_company";
    }

    @PostMapping("/create_act_from_driver_to_company")
    public String createActFromDriverToCompany(Model model) {
        // ToDo: creation act
        return "redirect:/operator/acts";
    }

    @GetMapping("/create_act_from_driver_to_driver")
    public String actFromDriverToDriverPage(@AuthenticationPrincipal User user,
                                            Model model) {
        model.addAttribute("formDD", new DriverToDriverActForm());
        model.addAttribute("drivers",
                CreateActSelectCreator.fillDriverSelectFields(driverService.getAllWithoutRentSorted()));
        model.addAttribute("autos",
                CreateActSelectCreator.fillAutoSelectFields(autoService.findAllFree()));
        model.addAttribute("user", user);
        return "acts/driver_to_driver";
    }

    @PostMapping("/create_act_from_driver_to_driver")
    public String createActFromDriverToDriver(@ModelAttribute("formDD") DriverToDriverActForm form,
                                              @AuthenticationPrincipal User user,
                                              Model model) {
        form.setDrafter(user.getLastName() + " " + user.getFirstName() + " " + user.getPatronymic());
        actService.createActFromDriverToDriver(form);
        return "redirect:/operator/acts";
    }

    private void fillAutoSelectFields(Model model) {
        model.addAttribute("bodyType", CreateAutoSelectCreator.bodyTypeCreate());
        model.addAttribute("driveType", CreateAutoSelectCreator.driveTypeCreate());
        model.addAttribute("transmissionType", CreateAutoSelectCreator.transmissionType());
    }
}
