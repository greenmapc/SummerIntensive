package com.simbirsoft.taxi_service.services;

import com.simbirsoft.taxi_service.forms.ActForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActServiceImpl implements ActService {

    private PdfActCreatorService pdfActCreatorService;

    @Autowired
    public ActServiceImpl(PdfActCreatorService pdfActCreatorService) {
        this.pdfActCreatorService = pdfActCreatorService;
    }


    @Override
    public void createActFromCompanyToDriver(ActForm form) {
        // parse form, save to db
        pdfActCreatorService.createPdfActFromCompanyToDriver(form);
    }

    @Override
    public void createActFromDriverToDriver(ActForm form) {
        // parse form, save to db
        pdfActCreatorService.createPdfActFromCompanyToDriver(form);
    }

    @Override
    public void createActFromDriverToCompany(ActForm form) {
        // parse form, save to db
        pdfActCreatorService.createPdfActFromDriverToCompany(form);
    }
}
