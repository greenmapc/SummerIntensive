package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.models.Driver;
import com.simbirsoft.taxi_service.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
