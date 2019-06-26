package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverToCompanyActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PdfActCreationServiceImplTest_TestSavingPdfToDisk {
    @Autowired
    private PdfActCreatorService pdfActCreatorService;
    @Autowired
    private AutoService autoService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin@admin.com", password = "123456", roles = "ADMIN")
    public void TestCompanyToDriverPdfCreation() throws Exception {
        CompanyToDriverActForm actForm = new CompanyToDriverActForm();
        fillForm(actForm);
        actForm.setRenter(driverService.getAll().get(0));
        actForm.setLeaseStartDate(LocalDateTime.now());

        String resultPdfName = pdfActCreatorService.createPdfActFromCompanyToDriver(actForm);
        this.mockMvc.perform(get("/download/pdf/" + resultPdfName + ".pdf"))
                .andExpect(status().isOk());

    }

    @Test
    @WithMockUser(username = "admin@admin.com", password = "123456", roles = "ADMIN")
    public void createPdfFromDriverToDriver() throws Exception {
        DriverToDriverActForm actForm = new DriverToDriverActForm();

        fillForm(actForm);
        actForm.setLessor(driverService.getAll().get(0));
        actForm.setLeaseStartDate(LocalDateTime.now());
        actForm.setRenter(driverService.getAllWithoutRentSorted().get(0));

        String resultPdfName = pdfActCreatorService.createPdfActFromDriverToDriver(actForm);
        this.mockMvc.perform(get("/download/pdf/" + resultPdfName + ".pdf"))
                .andExpect(status().isOk());

    }

    @Test
    @WithMockUser(username = "admin@admin.com", password = "123456", roles = "ADMIN")
    public void createPdfFromDriverToCompany() throws Exception {
        DriverToCompanyActForm actForm = new DriverToCompanyActForm();

        fillForm(actForm);
        actForm.setRenter(driverService.getAll().get(0));
        String resultPdfName = pdfActCreatorService.createPdfActFromDriverToCompany(actForm);
        this.mockMvc.perform(get("/download/pdf/" + resultPdfName + ".pdf"))
                .andExpect(status().isOk());

    }

    private void fillForm(ActForm actForm) {
        actForm.setDrafter("Анна Кузьменко");
        actForm.setConditions("Не указано");
        actForm.setAuto(autoService.findAllFree().get(0));
        actForm.setLeaseEndDate(LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0)));
    }
}