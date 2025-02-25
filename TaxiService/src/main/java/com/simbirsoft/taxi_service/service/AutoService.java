package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public interface AutoService {
    List<Auto> getAll();
    List<Auto> findAllFree();
    List<Auto> search(String searchString);
    List<Auto> findAllRented();

    Auto findAutoRentedByDriver(Long id);
    Auto createAuto(AutoForm form, User user);
    Auto findOneById(@NotNull Long id);
    Auto updateInfo(Auto auto, AutoForm newForm);

    Page<Auto> getPage(Integer number, String[] conditions);
    Set<String> getAllBrands();
}
