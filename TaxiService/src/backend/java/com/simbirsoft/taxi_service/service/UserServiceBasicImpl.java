package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.OperatorForm;
import com.simbirsoft.taxi_service.model.Roles;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.UserRepository;
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
    public void createOperator(OperatorForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPatronymic(form.getPatronymic());
        user.setPassword(form.getPhoneNumber());
        user.setRoles(Collections.singleton(Roles.OPERATOR));
        user.setPassword(passwordEncoder.encode("qwerty"));
        repository.save(user);
    }
}
