package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAll();
    Auto findOneById(Long id);
    void createAuto(AutoForm form);
    List<Auto> findAllFree();
}
