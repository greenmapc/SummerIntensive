package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.util.validator.DriverFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RequestMapping("/drivers")
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DriverController {
    private final DriverService driverService;

    @InitBinder("driverForm")
    public void initDriverFormBinder(WebDataBinder binder) {
        binder.addValidators(new DriverFormValidator());
    }

    @GetMapping
    public String getAll(@AuthenticationPrincipal User user,
                         Model model) {
        model.addAttribute("drivers", driverService.getAll());
        model.addAttribute("user", user);

        return "drivers/list";
    }

    @GetMapping("/{id}")
    public String getOne(@AuthenticationPrincipal User user,
                         @PathVariable Long id, Model model) {
        try {
            model.addAttribute("driver", driverService.findOneById(id));
        } catch (EntityNotFoundException e) {
            // ToDo: handle not found
        }
        model.addAttribute("user", user);

        return "drivers/card";
    }

    @GetMapping("/{id}/update")
    public String updateDriverPage(@PathVariable Long id,
                                   Model model) {
        Driver driver = driverService.findOneById(id);
        model.addAttribute("driver", driver);
        model.addAttribute("driverForm", DriverForm.createFromDriver(driver));
        return "drivers/update";
    }

    @PostMapping("/{id}/update")
    public String updateDriver(@PathVariable Long id,
                               @Validated @ModelAttribute("driverForm") DriverForm form,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("driver", driverService.findOneById(id));
            return "drivers/update";
        }
        driverService.updateInfo(driverService.findOneById(id), form);
        return "redirect:/drivers/" + id;
    }
}
