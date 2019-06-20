package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.AutoForm;
import com.simbirsoft.taxi_service.models.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAll();
    Auto getOne(Long id);
    void createAuto(AutoForm form);
}
