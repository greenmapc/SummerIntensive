package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.OperatorForm;
import com.simbirsoft.taxi_service.models.Roles;
import com.simbirsoft.taxi_service.models.User;
import com.simbirsoft.taxi_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceBasicImpl implements UserService {
    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceBasicImpl(UserRepository repository,
                                PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registrateOperator(OperatorForm form) {
        if (!form.getPassword().equals(form.getRepeatPassword())) {
            throw new IllegalArgumentException("Passwords are not equal");
        }
        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPatronymic(form.getPatronymic());
        user.setRoles(Collections.singleton(form.isOperator() ? Roles.OPERATOR : Roles.ADMIN));
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        repository.save(user);
    }
}
