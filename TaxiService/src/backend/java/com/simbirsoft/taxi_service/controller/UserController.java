package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.util.SelectCreator;
import com.simbirsoft.taxi_service.util.validator.AutoFormValidator;
import com.simbirsoft.taxi_service.util.validator.DriverFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String actsPage(@AuthenticationPrincipal User user,
                           Model model) {
        model.addAttribute("user", user);
        return "acts/list";
    }

    @GetMapping("/create_act_from_company_to_driver")
    public String actFromCompanyToDriverPage(@AuthenticationPrincipal User user,
                                             Model model) {
        model.addAttribute("formCD", new CompanyToDriverActForm());
        model.addAttribute("drivers", fillDriverSelectFields(driverService.getAllSorted()));
        model.addAttribute("autos", fillAutoSelectFields(autoService.getAll()));
        model.addAttribute("user", user);

        return "acts/company_to_driver";
    }

    @PostMapping("/create_act_from_company_to_driver")
    public String createActFromCompanyToDriver(
            @ModelAttribute("formCD") CompanyToDriverActForm form,
            @RequestParam("leaseStartDate1")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime leaseStartDate,
            @RequestParam("leaseEndDate1")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime leaseEndDate,
            @AuthenticationPrincipal User user,
            Model model) {

        form.setLeaseStartDate(leaseStartDate);
        form.setLeaseEndDate(leaseEndDate);
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
        return "redirect:operator/acts";
    }

    @GetMapping("/create_act_from_driver_to_driver")
    public String actFromDriverToDriverPage(@AuthenticationPrincipal User user,
                                            Model model) {
        model.addAttribute("user", user);

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

    private Map<String, String> fillDriverSelectFields(List<Driver> drivers) {
        Map<String, String> map = new HashMap<>();
        for (Driver driver : drivers) {
            map.put(driver.getId().toString(), driver.getLastName() + " " +
                    driver.getFirstName() + " " +
                    driver.getPatronymic() + ", " +
                    driver.getBirthDate());
        }
        return map;
    }

    private Map<String, String> fillAutoSelectFields(List<Auto> autos) {
        Map<String, String> map = new HashMap<>();
        for (Auto auto : autos) {
            map.put(auto.getId().toString(), auto.getBrand() + ", " +
                    auto.getModel() + ", " +
                    auto.getYear() + ", " +
                    auto.getGosNumber());
        }
        return map;
    }
}
