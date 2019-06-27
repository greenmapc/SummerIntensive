package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.form.*;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.service.ImageUploadService;
import com.simbirsoft.taxi_service.util.select.ActSelectCreator;
import com.simbirsoft.taxi_service.util.select.AutoSelectCreator;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.validator.AutoFormValidator;
import com.simbirsoft.taxi_service.util.validator.DriverFormValidator;
import com.simbirsoft.taxi_service.util.validator.UserFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final AutoService autoService;
    private final DriverService driverService;
    private final ActService actService;
    private final UserDetailsService userDetailsService;
    private final UserService userService;
    private final ImageUploadService imageUploadService;

    @InitBinder("form")
    public void initAutoFormBinder(WebDataBinder binder) {
        binder.addValidators(new AutoFormValidator());
    }

    @InitBinder("driverForm")
    public void initDriverFormBinder(WebDataBinder binder) {
        binder.addValidators(new DriverFormValidator());
    }

    @InitBinder("userForm")
    public void initUserFormBinder(WebDataBinder binder) {
        binder.addValidators(new UserFormValidator());
    }

    @GetMapping("/choose_act")
    public String choosingActsPage(@AuthenticationPrincipal User user,
                                   Model model) {
        model.addAttribute("user", user);
        return "acts/choosing_acts";
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
    @Transactional
    public String createAuto(@Validated @ModelAttribute("form") AutoForm form,
                             BindingResult bindingResult,
                             @AuthenticationPrincipal User user,
                             Model model,
                             @RequestParam(value = "docs", required = false) List<MultipartFile> docs) {
        if (bindingResult.hasErrors()) {
            fillAutoSelectFields(model);
            return "user/create_auto";
        }
        Auto auto = autoService.createAuto(form, user);

        try {
            for (MultipartFile doc : docs) {
                imageUploadService.saveAutoDocument(auto, doc);
            }
        } catch (IOException e) {
            // ToDo: handle
            e.printStackTrace();
        }
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
    @Transactional
    public String createDriver(@Validated @ModelAttribute("driverForm") DriverForm form,
                               BindingResult bindingResult,
                               Model model,
                               @AuthenticationPrincipal User user,
                               @RequestParam("docs") List<MultipartFile> docs) {
        if (bindingResult.hasErrors()) {
            return "user/create_driver";
        }
        driverService.createDriver(form, user);
        Driver driver = driverService.createDriver(form, user);

        try {
            for (MultipartFile doc : docs) {
                imageUploadService.saveDriverDocument(driver, doc);
            }
        } catch (IOException e) {
            // ToDo: handle
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        return "redirect:/drivers";
    }

    @GetMapping("/create_act_from_company_to_driver")
    public String actFromCompanyToDriverPage(@AuthenticationPrincipal User user,
                                             Model model) {
        model.addAttribute("formCD", new CompanyToDriverActForm());
        model.addAttribute("drivers",
                ActSelectCreator.fillDriverSelectFields(driverService.getAllWithoutRentSorted()));
        model.addAttribute("autos",
                ActSelectCreator.fillAutoSelectFields(autoService.findAllFree()));
        model.addAttribute("user", user);

        return "acts/company_to_driver";
    }

    @PostMapping("/create_act_from_company_to_driver")
    public String createActFromCompanyToDriver(
            @ModelAttribute("formCD") CompanyToDriverActForm form,
            @AuthenticationPrincipal User user,
            Model model) {
        form.setDrafter(user.getLastName() + " " + user.getFirstName() + " " + user.getPatronymic());

        actService.createActFromCompanyToDriver(form, user);
        return "redirect:/user/acts";
    }

    @GetMapping("/create_act_from_driver_to_company")
    public String actFromDriverToCompanyPage(@AuthenticationPrincipal User user,
                                             Model model) {
        model.addAttribute("user", user);
        model.addAttribute("formDC", new DriverToCompanyActForm());

        List<Driver> drivers = driverService.getAllWithRentSorted();
        model.addAttribute("drivers",
                ActSelectCreator.fillDriverSelectFields(drivers));
        model.addAttribute("autos",
                ActSelectCreator.fillAutoSelectFields(listDriversWithRent(drivers)));
        return "acts/driver_to_company";
    }

    @PostMapping("/create_act_from_driver_to_company")
    public String createActFromDriverToCompany(@ModelAttribute("formDC") DriverToCompanyActForm form,
                                               @AuthenticationPrincipal User user,
                                               Model model) {
        form.setDrafter(user.getLastName() + " " + user.getFirstName() + " " + user.getPatronymic());
        actService.createActFromDriverToCompany(form, user);
        return "redirect:/user/acts";
    }

    @GetMapping("/create_act_from_driver_to_driver")
    public String actFromDriverToDriverPage(@AuthenticationPrincipal User user,
                                            Model model) {
        model.addAttribute("formDD", new DriverToDriverActForm());
        model.addAttribute("user", user);

        List<Driver> driversWithRent = driverService.getAllWithRentSorted();
        model.addAttribute("lessor",
                ActSelectCreator.fillDriverSelectFields(driversWithRent));
        model.addAttribute("renter",
                ActSelectCreator.fillDriverSelectFields(driverService.getAllWithoutRentSorted()));
        model.addAttribute("autos",
                ActSelectCreator.fillAutoSelectFields(listDriversWithRent(driversWithRent)));
        return "acts/driver_to_driver";
    }

    @PostMapping("/create_act_from_driver_to_driver")
    public String createActFromDriverToDriver(@ModelAttribute("formDD") DriverToDriverActForm form,
                                              @AuthenticationPrincipal User user,
                                              Model model) {
        form.setDrafter(user.getLastName() + " " + user.getFirstName() + " " + user.getPatronymic());

        actService.createActFromDriverToDriver(form, user);
        return "redirect:/user/acts";
    }

    @GetMapping("/acts")
    public String allActsPage(@AuthenticationPrincipal User user,
                              Model model) {
        model.addAttribute("user", user);
        model.addAttribute("acts", actService.getAll());
        model.addAttribute("parser", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "acts/list";
    }

    @GetMapping("/update")
    public String updateInfoPage(@AuthenticationPrincipal User user,
                                 Model model) {
        User userFromDb = (User) userDetailsService.loadUserByUsername(user.getEmail());
        model.addAttribute("user", userFromDb);
        model.addAttribute("userForm", UserForm.createFromUser(userFromDb));
        return "user/update";
    }

    @PostMapping("/update")
    public String updateInfo(@AuthenticationPrincipal User user,
                             @Validated @ModelAttribute("userForm") UserForm userForm,
                             BindingResult bindingResult,
                             Model model) {
        User userFromDb = (User) userDetailsService.loadUserByUsername(user.getEmail());
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userFromDb);
            return "user/update";
        }
        userService.updateInfo(userFromDb, userForm);
        return "redirect:/panel";
    }

    private void fillAutoSelectFields(Model model) {
        model.addAttribute("bodyType", AutoSelectCreator.bodyTypeCreate());
        model.addAttribute("driveType", AutoSelectCreator.driveTypeCreate());
        model.addAttribute("transmissionType", AutoSelectCreator.transmissionType());
    }
    
    private List<Auto> listDriversWithRent(List<Driver> driversWithRent) {
        List<Auto> autosByUser = new ArrayList<>();
        if(!driversWithRent.isEmpty()) {
            autosByUser.add(autoService.findAllRentedByUser(driversWithRent.get(0).getId()));
            
        }
        return autosByUser;
    }
}
