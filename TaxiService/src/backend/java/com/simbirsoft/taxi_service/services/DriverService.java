package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.models.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getAll();
    Driver getOne(Long id);
}
