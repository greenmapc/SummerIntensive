package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface AutoService {
    List<Auto> getAll();
    Auto findOneById(Long id);
    Auto createAuto(AutoForm form);
    List<Auto> findAllFree();
    List<Auto> getPage(Integer number, String[] conditions);
    List<Auto> search(String searchString);
}
