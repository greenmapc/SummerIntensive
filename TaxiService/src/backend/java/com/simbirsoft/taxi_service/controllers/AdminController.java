package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.forms.OperatorForm;
import com.simbirsoft.taxi_service.models.Roles;
import com.simbirsoft.taxi_service.models.User;
import com.simbirsoft.taxi_service.services.UserService;
import com.simbirsoft.taxi_service.validators.OperatorFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @InitBinder("form")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(new OperatorFormValidator());
    }

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create_operator")
    public String createOperatorPage(Model model) {
        model.addAttribute("form", new OperatorForm());
        return "admin/create_operator";
    }

    @PostMapping("/create_operator")
    public String createOperator(@Validated @ModelAttribute("form") OperatorForm form,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            //TODO: обработка ошибок
            return "admin/create_operator";
        }
        try {
            userService.createOperator(form);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("form", form);
            return "admin/create_operator";
        }
        return "admin/create_operator";
    }

    @GetMapping("/panel")
    public String adminPage(@AuthenticationPrincipal User user,
                            Model model) {
        model.addAttribute("user", user);

        if (user.getAuthorities().contains(Roles.ADMIN)) {
            return "admin/admin";
        } else {
            // return redirect to operator panel
            return null;
        }
    }
}
