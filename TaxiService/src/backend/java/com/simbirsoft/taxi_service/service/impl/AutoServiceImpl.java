package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.repository.AutoRepository;
import com.simbirsoft.taxi_service.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AutoServiceImpl implements AutoService {
    private final AutoRepository repository;

    @Override
    public List<Auto> getAll() {
        return repository.findAll();
    }

    @Override
    public Auto findOneById(Long id) throws EntityNotFoundException {
        Optional<Auto> candidate = repository.findById(id);
        return candidate.orElseThrow(
                () -> new EntityNotFoundException("Auto with id = " + id + " not found"));
    }

    @Override
    public void createAuto(AutoForm form) {
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
                .transmission(form.getTransmissionType())
                .model(form.getModel())
                .kilometrage(form.getKilometrage())
                .build();
        repository.save(auto);
    }

    @Override
    public List<Auto> findAllFree() {
        return repository.findAllFree();
    }
}
