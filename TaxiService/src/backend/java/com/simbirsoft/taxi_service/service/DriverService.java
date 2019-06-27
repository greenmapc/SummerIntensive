package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface DriverService {
    List<Driver> getAll();
    List<Driver> getAllSorted();
    List<Driver> getAllWithoutRentSorted();
    Page<Driver> getPage(Integer number, String[] conditions);
    List<Driver> search(String searchString);
    List<Driver> getAllWithRentSorted();

    Driver createDriver(DriverForm form, User user);
    Driver findOneById(@NotNull Long id);
    Driver updateInfo(Driver driver, DriverForm form);
}
