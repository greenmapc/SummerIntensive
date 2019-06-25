package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;

public interface UserService {
    void addAction(User user, OperatorActionEnum action);
    User createOperator(UserForm form);
    User updateInfo(User user, UserForm form);
}
