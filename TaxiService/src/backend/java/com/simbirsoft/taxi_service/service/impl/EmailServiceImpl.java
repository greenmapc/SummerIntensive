package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.EmailSenderService;
import com.simbirsoft.taxi_service.service.EmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final EmailSenderService emailSenderService;
    private final Configuration freemarkerConfig;

    @Override
    public void sendPasswordToEmail(User user, String generatePassword) throws IOException, TemplateException {
        Map<String, Object> map = new HashMap<>();

        map.put("link", "http://localhost:8080/login");
        map.put("user", user);
        map.put("password", generatePassword);


        Template emailTemplate = freemarkerConfig.getTemplate("email/password_email.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(emailTemplate, map);

        emailSenderService.sendMessage("Успешная регистрация", html, user.getEmail());
    }
}
