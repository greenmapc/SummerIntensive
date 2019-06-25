package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.model.User;

public interface UserService {
    User createOperator(UserForm form);

    User updateInfo(User user, UserForm form);
}
