package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.ActForm;

public interface PdfActCreatorService {

    void createPdfActFromCompanyToDriver(ActForm form);
    void createPdfActFromDriverToDriver(ActForm form);
    void createPdfActFromDriverToCompany(ActForm form);

}
