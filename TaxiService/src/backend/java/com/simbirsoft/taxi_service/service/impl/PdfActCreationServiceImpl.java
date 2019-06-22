package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PdfActCreationServiceImpl implements PdfActCreatorService {

    @Override
    public void createPdfActFromCompanyToDriver(ActForm form) {

    }

    @Override
    public void createPdfActFromDriverToDriver(ActForm form) {

    }

    @Override
    public void createPdfActFromDriverToCompany(ActForm form) {

    }
}
