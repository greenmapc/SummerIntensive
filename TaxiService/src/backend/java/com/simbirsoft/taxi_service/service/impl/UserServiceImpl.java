package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.model.OperatorAction;
import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.model.Roles;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.OperatorActionRepository;
import com.simbirsoft.taxi_service.repository.UserRepository;
import com.simbirsoft.taxi_service.service.EmailService;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;
import com.simbirsoft.taxi_service.util.PasswordGeneration;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final OperatorActionRepository operatorActionRepository;

    @Override
    public User createOperator(UserForm form) {
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
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addAction(User user, OperatorActionEnum action) {
        OperatorAction operatorAction = new OperatorAction();
        operatorAction.setAction(action.toString());
        operatorAction.setDate(LocalDateTime.now());
        operatorAction.setOperator(user);

        operatorActionRepository.save(operatorAction);
    }

    public User updateInfo(User user, UserForm form) {
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPatronymic(form.getPatronymic());
        user.setPassword(passwordEncoder.encode(form.getNewPassword()));
        return repository.save(user);
    }

    @Override
    public List<OperatorAction> getAllActionsSortedByDateDesc() {
        return operatorActionRepository.findAll(
                new Sort(Sort.Direction.DESC, "date")
        );
    }
}
