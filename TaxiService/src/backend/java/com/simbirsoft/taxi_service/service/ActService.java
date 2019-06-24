package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;

public interface ActService {

    void createActFromCompanyToDriver(CompanyToDriverActForm form);
    void createActFromDriverToDriver(DriverToDriverActForm form);
    void createActFromDriverToCompany(DriverToCompanyActForm form);

}
