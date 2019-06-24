package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.OperatorForm;
import com.simbirsoft.taxi_service.model.Roles;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.UserRepository;
import com.simbirsoft.taxi_service.service.EmailService;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.PasswordGeneration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    @Override
    public User createOperator(OperatorForm form) {
        String password = PasswordGeneration.generatePassword();

        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPatronymic(form.getPatronymic());
        user.setRoles(Collections.singleton(Roles.OPERATOR));
        user.setPassword(passwordEncoder.encode(password));

        repository.save(user);

        try {
            emailService.sendPasswordToEmail(user, password);
        } catch (TemplateException e) {
            // ToDo: handle exception
            e.printStackTrace();
        } catch (IOException e) {
            // ToDo: handle IO exception
            e.printStackTrace();
        }

        return user;
    }
}
