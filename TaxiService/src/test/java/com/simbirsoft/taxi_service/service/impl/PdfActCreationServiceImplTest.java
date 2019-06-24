package com.simbirsoft.taxi_service.service.impl;

import com.itextpdf.text.DocumentException;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PdfActCreationServiceImplTest {

    @Autowired
    private PdfActCreatorService pdfActCreatorService;

    @Autowired
    private AutoService autoService;

    @Autowired
    private DriverService driverService;

    @Test
    public void createPdfFromCompanyToDriver() {
        CompanyToDriverActForm actForm = new CompanyToDriverActForm();
        actForm.setDrafter("Анна Кузьменко");
        actForm.setConditions("Не указано");
        actForm.setAuto(autoService.findAllFree().get(0));
        actForm.setRenter(driverService.getAllWithoutRentSorted().get(0));
        actForm.setLeaseStartDate(LocalDateTime.now());
        actForm.setLeaseEndDate(LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0)));

        try {
            pdfActCreatorService.createPdfActFromCompanyToDriver(actForm);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPdfFromDriverToDriver() {
        DriverToDriverActForm actForm = new DriverToDriverActForm();
        actForm.setDrafter("Анна Кузьменко");
        actForm.setConditions("Не указано");
        actForm.setAuto(autoService.getAll().get(0));
        actForm.setRenter(driverService.getAll().get(0));
        actForm.setRecipient(driverService.getAll().get(0));
        actForm.setLeaseStartDate(LocalDateTime.now());
        actForm.setLeaseEndDate(LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0)));

        try {
            pdfActCreatorService.createPdfActFromDriverToDriver(actForm);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPdfFromDriverToCompany() {
        DriverToCompanyActForm actForm = new DriverToCompanyActForm();
        actForm.setDrafter("Анна Кузьменко");
        actForm.setConditions("Не указано");
        actForm.setAuto(autoService.getAll().get(0));
        actForm.setRenter(driverService.getAll().get(0));
        actForm.setLeaseEndDate(LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0)));

        try {
            pdfActCreatorService.createPdfActFromDriverToCompany(actForm);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}