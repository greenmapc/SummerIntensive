package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.model.OperatorAction;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;

import java.util.List;

public interface UserService {
    void addAction(User user, OperatorActionEnum action);

    User createOperator(UserForm form);

    User updateInfo(User user, UserForm form);

    List<OperatorAction> getAllActionsSortedByDateDesc();
}
