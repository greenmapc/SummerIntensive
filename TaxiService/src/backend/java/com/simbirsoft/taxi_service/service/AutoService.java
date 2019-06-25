package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;

import java.util.List;

public interface AutoService {
    List<Auto> getAll();
    Auto findOneById(Long id);
    Auto createAuto(AutoForm form, User user);
    List<Auto> findAllFree();
}
