package com.simbirsoft.taxi_service.service.impl;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.model.Act;
import com.simbirsoft.taxi_service.repository.ActRepository;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ActServiceImpl implements ActService {
    private final PdfActCreatorService pdfActCreatorService;
    private final ActRepository actRepository;

    @Override
    public void createActFromCompanyToDriver(CompanyToDriverActForm form) {
        Act act = new Act();
        act.setAuto(form.getAuto());
        act.setConditions(form.getConditions());
        act.setDrafter(form.getDrafter());
        act.setDriverRecipient(form.getRenter());
        act.setLeaseStartDate(form.getLeaseStartDate());
        act.setLeaseEndDate(form.getLeaseEndDate());
        act.setType(form.getType());

        // ToDo: exceptions
        try {
            pdfActCreatorService.createPdfActFromCompanyToDriver(form);
            actRepository.save(act);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createActFromDriverToDriver(DriverToDriverActForm form) {
        // parse form, save to db
        // ToDo: exceptions
        try {
            pdfActCreatorService.createPdfActFromDriverToDriver(form);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createActFromDriverToCompany(DriverToCompanyActForm form) {
        // parse form, save to db
        // ToDo: exceptions
        try {
            pdfActCreatorService.createPdfActFromDriverToCompany(form);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
