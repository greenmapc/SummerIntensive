package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;

public interface ActService {
    void createActFromCompanyToDriver(CompanyToDriverActForm form, User user);
    void createActFromDriverToDriver(DriverToDriverActForm form, User user);
    void createActFromDriverToCompany(DriverToCompanyActForm form, User user);

    void rentEnd(Driver driver);
}
