package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.form.ActForm;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PdfActCreatorServiceImpl implements PdfActCreatorService {

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
