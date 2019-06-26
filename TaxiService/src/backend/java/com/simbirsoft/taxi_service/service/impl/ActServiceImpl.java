package com.simbirsoft.taxi_service.service.impl;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.model.Act;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.ActRepository;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import com.simbirsoft.taxi_service.service.UserService;
import com.simbirsoft.taxi_service.util.OperatorActionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ActServiceImpl implements ActService {
    private final PdfActCreatorService pdfActCreatorService;
    private final ActRepository actRepository;
    private final UserService userService;

    //ToDo: moved general part to method

    @Override
    public Act createActFromCompanyToDriver(CompanyToDriverActForm form, User user) {
        Act act = fillBasicData(form);
        act.setDriverRenter(form.getRenter());
        // ToDo: exceptions
        try {
            pdfActCreatorService.createPdfActFromCompanyToDriver(form);
            actRepository.save(act);
            userService.addAction(user, OperatorActionEnum.CREATE_ACT);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        return act;
    }

    @Override
    public Act createActFromDriverToDriver(DriverToDriverActForm actForm, User user) {
        Act act = fillBasicData(actForm);

        act.setDriverRenter(actForm.getRenter());
        act.setDriverLessor(actForm.getLessor());

        // ToDo: exceptions
        try {
            pdfActCreatorService.createPdfActFromDriverToDriver(actForm);
            actRepository.save(act);
            userService.addAction(user, OperatorActionEnum.CREATE_ACT);
            rentEnd(actForm.getLessor());
        } catch (
                IOException | DocumentException e) {
            e.printStackTrace();
        }

        return act;
    }

    @Override
    public Act createActFromDriverToCompany(DriverToCompanyActForm form, User user) {
        Act act = fillBasicData(form);
        act.setDriverRenter(form.getRenter());

        // ToDo: exceptions
        try {
            pdfActCreatorService.createPdfActFromDriverToCompany(form);
            actRepository.save(act);
            userService.addAction(user, OperatorActionEnum.CREATE_ACT);
            rentEnd(form.getRenter());
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        return act;
    }

    @Override
    public void rentEnd(Driver driver) {
        actRepository.setRentEnd(driver);
    }

    private Act fillBasicData(ActForm form) {
        Act act = new Act();
        act.setAuto(form.getAuto());
        act.setConditions(form.getConditions());
        act.setDrafter(form.getDrafter());
        act.setLeaseStartDate(form.getLeaseStartDate());
        act.setLeaseEndDate(form.getLeaseEndDate());
        act.setType(form.getType());
        return act;
    }
}