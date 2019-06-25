package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AutoService {
    List<Auto> getAll();

    Auto findOneById(@NotNull Long id);

    Auto createAuto(AutoForm form);

    List<Auto> findAllFree();

    Auto updateInfo(Auto auto, AutoForm newForm);
}
