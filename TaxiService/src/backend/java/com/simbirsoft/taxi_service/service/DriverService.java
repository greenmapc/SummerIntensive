package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getAll();
    Driver findOneById(Long id);
    void createDriver(DriverForm form);
}
