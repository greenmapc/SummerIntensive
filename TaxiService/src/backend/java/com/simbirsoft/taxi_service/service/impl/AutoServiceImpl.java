package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.AutoRepository;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository repository;
    private final UserService userService;

    @Override
    public List<Auto> getAll() {
        return repository.findAll();
    }

    @Override
    public Auto findOneById(Long id) throws EntityNotFoundException {
        Optional<Auto> candidate = repository.findById(id);
        return candidate.orElseThrow(
                () -> new EntityNotFoundException("Auto with id = " + id + " not found")
        );
    }

    @Override
    public Auto createAuto(AutoForm form, User user) {
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
                .state(true)
                .build();

        userService.addAction(user, OperatorActionEnum.CREATE_AUTO);

        return repository.save(auto);
    }

    @Override
    public List<Auto> findAllFree() {
        return repository.findAllFree();
    }

    @Override
    public Auto updateInfo(Auto auto, AutoForm form) {
        auto.setBodyType(form.getBodyType());
        auto.setBrand(form.getBrand());
        auto.setColor(form.getColor());
        auto.setDescription(form.getDescription());
        auto.setDrive(form.getDrive());
        auto.setEnginePower(form.getEnginePower());
        auto.setGosNumber(form.getGosNumber());
        auto.setVinNumber(form.getVinNumber());
        auto.setYear(form.getYear());
        auto.setVolume(form.getVolume());
        auto.setTransmission(form.getTransmissionType());
        auto.setModel(form.getModel());
        auto.setKilometrage(form.getKilometrage());
        auto.setState(form.getState());
        return repository.save(auto);
    }
}
