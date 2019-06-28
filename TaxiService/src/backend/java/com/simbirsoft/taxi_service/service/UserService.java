package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.model.OperatorAction;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    OperatorAction addAction(User user, OperatorActionEnum action);

    User createOperator(UserForm form);
    User updateInfo(User user, UserForm form);
    User findOneById(Long id);
    List<OperatorAction> getAllActionsSortedByDateDesc();
    Page<OperatorAction> getPageSortedByDateDesc(Integer pageNumber);

}
