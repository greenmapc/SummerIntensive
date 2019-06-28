package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.dao.AutoSearchDao;
import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.AutoRepository;
import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.repository.filters.SpecificationBuilder;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;
import com.simbirsoft.taxi_service.util.condition.ConditionParser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository repository;
    private final ConditionParser conditionParser;
    private final AutoSearchDao autoSearchDao;
    private final UserService userService;

    private static final int pageSize = 12;

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
    public Page<Auto> getPage(Integer number, String[] conditionsList) {
        if (number == null || number < 1) {
            number = 1;
        }
        if (conditionsList==null || conditionsList.length == 0) {
            return repository.findAll(PageRequest.of(number - 1,pageSize)); //-1 because start point for user is 1
        }
        List<Condition> conditions = conditionParser.getConditions(Arrays.asList(conditionsList));
        SpecificationBuilder<Auto> specificationBuilder = new SpecificationBuilder<>(conditions);
        return repository.findAll(specificationBuilder.getComplexSpecification(Auto.class),PageRequest.of(number - 1,pageSize, Sort.by("id")));
    }

    @Override
    public List<Auto> search(String searchString) {
        return autoSearchDao.fuzzySearch(searchString.toLowerCase());
    }

    @Override
    public List<Auto> findAllRented() {
        return repository.findAllRent();
    }

    @Override
    public Set<String> getAllBrands() {
        Set<String> brands = new HashSet<>();
        List<Auto> autos = repository.findAll();

        for(Auto auto : autos) {
            brands.add(auto.getBrand());
        }

        return brands;
    }

    @Override
    public Auto findAllRentedByUser(Long id) {
        return repository.findAllRentByUser(id);
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
