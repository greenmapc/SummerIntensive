package com.simbirsoft.taxi_service.service.impl;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.model.Act;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.service.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActServiceImplTest_CreationIntoDB {
    @Autowired
    private ActServiceImpl actService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AutoServiceImpl autoService;
    @Autowired
    private DriverServiceImpl driverService;

    @MockBean
    private PdfActCreatorService pdfActCreatorService;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void databaseCreatingCompanyToDriverActTest() throws IOException, DocumentException {
        User user = userService.findOneById(1L);

        CompanyToDriverActForm actForm = new CompanyToDriverActForm();
        fillForm(actForm);
        actForm.setRenter(driverService.getAllWithoutRentSorted().get(0));
        actForm.setLeaseStartDate(LocalDateTime.now());

        when(pdfActCreatorService.createPdfActFromCompanyToDriver(actForm)).thenReturn("newPdf");
        Act resultAct = actService.createActFromCompanyToDriver(actForm, user);

        Assert.assertNotNull(resultAct);
    }

    @Test
    public void databaseCreatingDriverToDriverActTest() throws IOException, DocumentException {
        User user = userService.findOneById(1L);

        DriverToDriverActForm actForm = new DriverToDriverActForm();
        fillForm(actForm);
        actForm.setLessor(driverService.getAllWithRentSorted().get(0));
        actForm.setLeaseStartDate(LocalDateTime.now());
        actForm.setRenter(driverService.getAllWithoutRentSorted().get(0));

        when(pdfActCreatorService.createPdfActFromDriverToDriver(actForm)).thenReturn("newPdf");
        Act resultAct = actService.createActFromDriverToDriver(actForm, user);

        Assert.assertNotNull(resultAct.getId());
    }

    @Test
    public void  databaseCreatingDriverToCompanyActTest() throws IOException, DocumentException {
        User user = userService.findOneById(1L);

        DriverToCompanyActForm actForm = new DriverToCompanyActForm();
        fillForm(actForm);
        actForm.setRenter(driverService.getAllWithRentSorted().get(0));

        when(pdfActCreatorService.createPdfActFromDriverToCompany(actForm)).thenReturn("newPdf");
        Act resultAct = actService.createActFromDriverToCompany(actForm, user);

        Assert.assertNotNull(resultAct.getId());
    }

    private void fillForm(ActForm actForm) {
        actForm.setDrafter("Анна Кузьменко");
        actForm.setConditions("Не указано");
        actForm.setAuto(autoService.findAllFree().get(0));
        actForm.setLeaseEndDate(LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0)));
    }

}
