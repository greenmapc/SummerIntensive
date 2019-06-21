package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.ActForm;

public interface ActService {

    void createActFromCompanyToDriver(ActForm form);
    void createActFromDriverToDriver(ActForm form);
    void createActFromDriverToCompany(ActForm form);

}
