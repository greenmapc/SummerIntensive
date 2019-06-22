package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.model.Act;
import com.simbirsoft.taxi_service.repository.ActRepository;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActServiceImpl implements ActService {
    private final PdfActCreatorService pdfActCreatorService;
    private final ActRepository actRepository;

    @Override
    public void createActFromCompanyToDriver(ActForm form) {
        CompanyToDriverActForm actForm = (CompanyToDriverActForm) form;

        Act act = new Act();
        act.setAuto(actForm.getAuto());
        act.setConditions(actForm.getConditions());
        act.setDrafter(actForm.getDrafter());
        act.setDriverRecipient(actForm.getDriver());
        act.setLeaseStartDate(actForm.getLeaseStartDate());
        act.setLeaseEndDate(actForm.getLeaseEndDate());
        act.setType(actForm.getType());

        actRepository.save(act);
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
