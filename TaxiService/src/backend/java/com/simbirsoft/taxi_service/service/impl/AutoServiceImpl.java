package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.repository.AutoRepository;
import com.simbirsoft.taxi_service.repository.filters.AutoFilter;
import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.util.condition.ConditionParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoServiceImpl implements AutoService {
    private final AutoRepository repository;
    private final ConditionParser conditionParser;
    private static final int pageSize = 10;

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
    public Auto createAuto(AutoForm form) {
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
        return repository.save(auto);
    }

    @Override
    public List<Auto> findAllFree() {
        return repository.findAllFree();
    }



    @Override
    public List<Auto> getPage(Integer number,String[] conditionsList) {
        if (number == null || number < 1) {
            number = 1;
        }
        if (conditionsList==null || conditionsList.length == 0) {
            return repository.findAll(PageRequest.of(number - 1,pageSize)).getContent(); //-1 because start point for user is 1
        }
        List<Condition> conditions = conditionParser.getConditions(Arrays.asList(conditionsList));
        AutoFilter autoFilter = new AutoFilter(conditions);
        return repository.findAll(autoFilter.getComplexSpecification(),PageRequest.of(number - 1,pageSize)).getContent();
    }
}
