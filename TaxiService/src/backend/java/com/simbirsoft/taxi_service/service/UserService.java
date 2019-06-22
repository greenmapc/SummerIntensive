package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.OperatorForm;
import com.simbirsoft.taxi_service.model.User;

public interface UserService {
    User createOperator(OperatorForm form);
}
