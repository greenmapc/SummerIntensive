package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.AutoForm;
import com.simbirsoft.taxi_service.models.Auto;
import com.simbirsoft.taxi_service.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
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

    @Override
    public Auto getOne(Long id) {
        Auto auto = repository.getOne(id);
        try{
            auto.getBodyType();
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("not found");
        }
        return auto;
    }

    @Override
    public void registrateAuto(AutoForm form) {
        Auto auto = Auto.builder()
                .bodyType(form.getBodyType())
                .brand(form.getBrand())
                .color(form.getColor())
                .description(form.getDescription())
                .drive(form.getDrive())
                .enginePower(form.getEnginePower())
                .gosNumber(form.getGosNumber())
                .vinNumber(form.getVinNumber())
                .year(form.getYear())
                .volume(form.getVolume())
                .transmissionType(form.getTransmissionType())
                .model(form.getModel())
                .kilometrage(form.getKilometrage())
                .build();
        repository.save(auto);
    }
}
