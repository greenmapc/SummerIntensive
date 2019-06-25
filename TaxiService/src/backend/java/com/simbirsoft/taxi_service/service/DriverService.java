package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface DriverService {
    List<Driver> getAll();
    List<Driver> getAllSorted();
    List<Driver> getAllWithoutRentSorted();

    Driver createDriver(DriverForm form, User user);
    Driver findOneById(@NotNull Long id);
    Driver updateInfo(Driver driver, DriverForm form);
}
