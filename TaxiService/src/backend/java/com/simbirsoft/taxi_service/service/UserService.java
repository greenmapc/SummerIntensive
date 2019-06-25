package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.OperatorForm;
import com.simbirsoft.taxi_service.model.OperatorAction;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;

public interface UserService {
    User createOperator(OperatorForm form);
    void addAction(User user, OperatorActionEnum action);
}
