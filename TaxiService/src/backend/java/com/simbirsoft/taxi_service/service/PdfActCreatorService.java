package com.simbirsoft.taxi_service.service;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;

import java.io.IOException;

public interface PdfActCreatorService {

    String createPdfActFromCompanyToDriver(CompanyToDriverActForm form) throws IOException, DocumentException;
    String createPdfActFromDriverToDriver(DriverToDriverActForm form) throws IOException, DocumentException;
    void createPdfActFromDriverToCompany(ActForm form);

}
