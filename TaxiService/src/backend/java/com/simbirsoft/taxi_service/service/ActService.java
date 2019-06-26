package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.model.Act;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;

public interface ActService {
    Act createActFromCompanyToDriver(CompanyToDriverActForm form, User user);
    Act createActFromDriverToDriver(DriverToDriverActForm form, User user);
    Act createActFromDriverToCompany(DriverToCompanyActForm form, User user);

    void rentEnd(Driver driver);
}
