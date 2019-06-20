package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.models.Auto;
import com.simbirsoft.taxi_service.models.Driver;
import com.simbirsoft.taxi_service.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DriverServiceBasicImpl implements DriverService {
    private DriverRepository repository;

    @Autowired
    public DriverServiceBasicImpl(DriverRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Driver> getAll() {
        return repository.findAll();
    }

    @Override
    public Driver getOne(Long id) {
        Driver driver = repository.getOne(id);
        try{
            driver.getFirstName();
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("not found");
        }
        return driver;
    }
}
