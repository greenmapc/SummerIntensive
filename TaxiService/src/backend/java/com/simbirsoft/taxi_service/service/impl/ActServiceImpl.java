package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActServiceImpl implements ActService {
    private final PdfActCreatorService pdfActCreatorService;

    @Override
    public void createActFromCompanyToDriver(ActForm form) {
        // parse form, save to db
        pdfActCreatorService.createPdfActFromCompanyToDriver(form);
    }

    @Override
    public void createActFromDriverToDriver(ActForm form) {
        // parse form, save to db
        pdfActCreatorService.createPdfActFromDriverToDriver(form);
    }

    @Override
    public void createActFromDriverToCompany(ActForm form) {
        // parse form, save to db
        pdfActCreatorService.createPdfActFromDriverToCompany(form);
    }
}
