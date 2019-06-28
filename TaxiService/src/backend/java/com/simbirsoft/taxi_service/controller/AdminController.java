package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.model.OperatorAction;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.validator.UserFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final UserFormValidator userFormValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(userFormValidator);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/create_operator")
    public String createOperatorPage(@AuthenticationPrincipal User user,
                                     Model model) {
        model.addAttribute("user", user);
        model.addAttribute("form", new UserForm());
        return "admin/create_operator";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create_operator")
    public String createOperator(@Validated @ModelAttribute("form") UserForm form,
                                 BindingResult bindingResult,
                                 Model model,
                                 @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            return "admin/create_operator";
        }
        try {
            userService.createOperator(form);
        } catch (IllegalArgumentException ex) {
            model.addAttribute("form", form);
            return "admin/create_operator";
        }

        model.addAttribute("success", "Оператор успешно добавлен в систему!");
        model.addAttribute("user", user);

        return "admin/create_operator";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/operator_actions")
    public String operatorActionsPage(@AuthenticationPrincipal User user,
                                      Model model) {
        model.addAttribute("user", user);
        List<OperatorAction> operatorActions = userService.getAllActionsSortedByDateDesc();
        model.addAttribute("actions", operatorActions);
        return "admin/operator_actions";
    }
}
