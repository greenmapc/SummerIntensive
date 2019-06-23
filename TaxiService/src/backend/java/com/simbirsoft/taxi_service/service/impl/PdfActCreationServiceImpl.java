package com.simbirsoft.taxi_service.service.impl;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import com.simbirsoft.taxi_service.util.document.PDFDocumentCreator;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@NoArgsConstructor
public class PdfActCreationServiceImpl implements PdfActCreatorService {
    /**
     * @return created pdf filename
     * */
    @Override
    public String createPdfActFromCompanyToDriver(CompanyToDriverActForm form) throws IOException, DocumentException {
        return PDFDocumentCreator.saveDocumentFromCompanyToDriver(form);
    }

    @Override
    public void createPdfActFromDriverToDriver(ActForm form) {

    }

    @Override
    public void createPdfActFromDriverToCompany(ActForm form) {

    }
}
