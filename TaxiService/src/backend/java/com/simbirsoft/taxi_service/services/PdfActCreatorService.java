package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.ActForm;

public interface PdfActCreatorService {

    void createPdfActFromCompanyToDriver(ActForm form);
    void createPdfActFromDriverToDriver(ActForm form);
    void createPdfActFromDriverToCompany(ActForm form);

}
