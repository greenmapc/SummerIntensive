package com.simbirsoft.taxi_service.service.impl;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import com.simbirsoft.taxi_service.service.impl.pdf_creator.PdfActCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PdfActCreationServiceImpl implements PdfActCreatorService {
    // How to inject?
    private final PdfActCreator pdfActCreator;

    @Override
    public String createPdfActFromCompanyToDriver(CompanyToDriverActForm form) throws IOException, DocumentException {
        return pdfActCreator.createActPdf(form);
    }

    @Override
    public String createPdfActFromDriverToDriver(DriverToDriverActForm form) throws IOException, DocumentException {
        return pdfActCreator.createActPdf(form);
    }

    @Override
    public void createPdfActFromDriverToCompany(ActForm form) {

    }
}
