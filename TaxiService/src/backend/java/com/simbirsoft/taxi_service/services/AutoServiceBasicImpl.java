package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.models.Auto;
import com.simbirsoft.taxi_service.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AutoServiceBasicImpl implements AutoService {
    private AutoRepository repository;
    @Autowired
    public AutoServiceBasicImpl(AutoRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Auto> getAll() {
        return repository.findAll();
    }
}
