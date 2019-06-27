package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getAll();
    List<Driver> getAllSorted();
    List<Driver> getAllWithoutRentSorted();
    Driver findOneById(Long id);
    Driver createDriver(DriverForm form);
    List<Driver> getPage(Integer number, String[] conditions);
    List<Driver> search(String searchString);
}
