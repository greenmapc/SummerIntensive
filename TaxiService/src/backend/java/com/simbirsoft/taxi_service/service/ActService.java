package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;

public interface ActService {

    void createActFromCompanyToDriver(CompanyToDriverActForm form);
    void createActFromDriverToDriver(ActForm form);
    void createActFromDriverToCompany(ActForm form);

}
