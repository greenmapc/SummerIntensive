package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.model.Roles;
import com.simbirsoft.taxi_service.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "redirect:/panel";
    }

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request,
                            Model model) {
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", "Некорректные данные");
        }
        return "login";
    }

    @GetMapping("/panel")
    public String adminPage(@AuthenticationPrincipal User user,
                            Model model) {
        model.addAttribute("user", user);
        return user.getRoles().contains(Roles.ADMIN) ? "admin/panel" : "operator/panel";
    }
}