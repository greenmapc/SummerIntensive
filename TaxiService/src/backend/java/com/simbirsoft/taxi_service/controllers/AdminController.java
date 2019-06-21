package com.simbirsoft.taxi_service.controllers;

import com.simbirsoft.taxi_service.forms.OperatorForm;
import com.simbirsoft.taxi_service.models.Roles;
import com.simbirsoft.taxi_service.models.User;
import com.simbirsoft.taxi_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

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
    public String createOperator(@ModelAttribute("form") OperatorForm form,
                                 Model model,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //TODO: обработка ошибок
        }
        try {
            userService.createOperator(form);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("form", form);
            return "admin/create_operator";
        }
        model.addAttribute("success", "Оператор успешно добавлен в систему!");
        return "admin/create_operator";
    }

    @GetMapping("/panel")
    public String adminPage(@AuthenticationPrincipal User user,
                            Model model) {
        model.addAttribute("user", user);

        if(user.getAuthorities().contains(Roles.ADMIN)) {
            return "admin/admin";
        } else  {
            // return redirect to operator panel
            return null;
        }
    }
}
