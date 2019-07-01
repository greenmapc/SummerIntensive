package com.simbirsoft.taxi_service.service.impl;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import com.simbirsoft.taxi_service.service.PdfCreatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PdfActCreationServiceImpl implements PdfActCreatorService {
    private final PdfCreatorFactory pdfCreatorFactory;

    @Override
    public String createPdfActFromCompanyToDriver(CompanyToDriverActForm form) throws IOException, DocumentException {
        return pdfCreatorFactory.getCompanyToDriverCreator().createActPdf(form);
    }

    @Override
    public String createPdfActFromDriverToDriver(DriverToDriverActForm form) throws IOException, DocumentException {
        return pdfCreatorFactory.getDriverToDriverCreator().createActPdf(form);
    }

    @Override
    public String createPdfActFromDriverToCompany(DriverToCompanyActForm form) throws IOException, DocumentException {
        return pdfCreatorFactory.getDriverToCompanyCreator().createActPdf(form);
    }
}
