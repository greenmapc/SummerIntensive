package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.model.User;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface EmailService {
    void sendPasswordToEmail(User user, String generatePassword) throws IOException, TemplateException;
}
