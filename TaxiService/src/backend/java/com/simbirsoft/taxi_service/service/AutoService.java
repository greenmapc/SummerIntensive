package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AutoService {
    List<Auto> getAll();
    List<Auto> findAllFree();
    List<Auto> findAllRented();

    Auto createAuto(AutoForm form, User user);
    Auto findOneById(@NotNull Long id);
    Auto updateInfo(Auto auto, AutoForm newForm);
}
