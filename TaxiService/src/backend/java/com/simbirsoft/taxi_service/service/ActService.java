package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.ActForm;

public interface ActService {
    void createActFromCompanyToDriver(ActForm form);

    void createActFromDriverToDriver(ActForm form);

    void createActFromDriverToCompany(ActForm form);
}
