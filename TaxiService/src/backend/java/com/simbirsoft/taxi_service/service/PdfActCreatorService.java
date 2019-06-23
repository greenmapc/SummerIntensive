package com.simbirsoft.taxi_service.service;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PdfActCreatorService {

    void createPdfActFromCompanyToDriver(ActForm form) throws IOException, DocumentException;
    void createPdfActFromDriverToDriver(ActForm form);
    void createPdfActFromDriverToCompany(ActForm form);

}
