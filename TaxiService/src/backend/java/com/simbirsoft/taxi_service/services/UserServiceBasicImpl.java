package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.OperatorForm;
import com.simbirsoft.taxi_service.models.User;
import com.simbirsoft.taxi_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceBasicImpl implements UserService {
    private UserRepository repository;
    @Autowired
    public UserServiceBasicImpl(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public void registrateOperator(OperatorForm form) {
        if (!form.getPassword().equals(form.getRepeatPassword())) {
            throw new IllegalArgumentException("passwords are not equal");
        }
        User user = User.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .patronymic(form.getPatronymic())
                .password(form.getPassword()) //todo encode
                .build();
        repository.save(user);
    }
}
