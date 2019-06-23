package com.simbirsoft.taxi_service.service;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;

import java.io.IOException;

public interface PdfActCreatorService {

    String createPdfActFromCompanyToDriver(CompanyToDriverActForm form) throws IOException, DocumentException;
    void createPdfActFromDriverToDriver(ActForm form);
    void createPdfActFromDriverToCompany(ActForm form);

}
