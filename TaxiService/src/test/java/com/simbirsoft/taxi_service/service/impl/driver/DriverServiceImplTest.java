package com.simbirsoft.taxi_service.service.impl.driver;

import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.model.Act;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.ActRepository;
import com.simbirsoft.taxi_service.repository.DriverRepository;
import com.simbirsoft.taxi_service.repository.UserRepository;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.DriverService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class DriverServiceImplTest {
    @Autowired
    private DriverService driverService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActService actService;
    @Autowired
    private AutoService autoService;
    @Autowired
    private ActRepository actRepository;

    private User user;

    @Before
    public void setUp() {
        user = userRepository.findById(1L).get();
    }

    @Test
    public void createDriver() {
        Driver driver = driverService.createDriver(DriverForm.createFromDriver(createTestDriver()), user);

        Assert.assertNotNull(driver.getId());
    }

    @Test
    public void getAll() {
        int countBeforeAdd = driverService.getAll().size();
        driverService.createDriver(DriverForm.createFromDriver(createTestDriver()), user);

        int countAfterAdd = driverService.getAll().size();

        Assert.assertEquals(countBeforeAdd + 1, countAfterAdd);
    }

    @Test
    public void getAllWithoutRentSorted_RentTest() {
        actRepository.deleteAll();
        int countBeforeRent = driverService.getAll().size();
        Act act = actService.createActFromCompanyToDriver(createAct(), user);

        int countAfterOneRent = driverService.getAllWithoutRentSorted().size();

        Assert.assertEquals(countBeforeRent - 1, countAfterOneRent);
        actRepository.deleteAll();
    }

    @Test
    public void getAllWithRentSorted_RentCheck() {
        actRepository.deleteAll();
        actService.createActFromCompanyToDriver(createAct(), user);

        int countAfterOneRent = driverService.getAllWithRentSorted().size();

        Assert.assertEquals(1, countAfterOneRent);
        actRepository.deleteAll();
    }

    @Test
    public void findOneById() {
        Driver driver = createTestDriver();
        driver = driverService.createDriver(DriverForm.createFromDriver(driver), user);

        Assert.assertEquals(driver, driverService.findOneById(driver.getId()));
    }


    @Test
    public void updateInfo() {
        Driver updateDriver = driverService.findOneById(1L);
        DriverForm driverForm = DriverForm.createFromDriver(updateDriver);

        driverForm.setActualAddress("Test1");
        driverForm.setBirthDate(LocalDate.of(1993, 1, 1));
        driverForm.setBlackList(true);
        driverForm.setFirstName("Test1");
        driverForm.setLastName("Test1");
        driverForm.setPatronymic("Test1");
        driverForm.setDateOfDriverLicenseExpiry(LocalDate.of(2021, 1, 1));
        driverForm.setDateOfDriverLicenseIssue(LocalDate.of(2016, 1, 1));
        driverForm.setDateOfPassportIssue(LocalDate.of(2011, 1, 1));
        driverForm.setDriversLicenseNumber(123457);
        driverForm.setDriversLicenseSeries(1237);
        driverForm.setPassportSeries(1237);
        driverForm.setPassportNumber(123457);
        driverForm.setPhoneNumber("9111111112");
        driverForm.setPlaceOfPassportIssue("Test1");
        driverForm.setResidenceAddress("Test1");

        Driver driverAfterUpdate = driverService.updateInfo(updateDriver, driverForm);

        Assert.assertEquals(updateDriver, driverAfterUpdate);
    }

    private Driver createTestDriver() {
        Driver driver = new Driver();
        driver.setActualAddress("Address");
        driver.setBirthDate(LocalDate.of(1992, 1, 1));
        driver.setBlackList(false);
        driver.setFirstName("Test");
        driver.setLastName("Test");
        driver.setPatronymic("Test");
        driver.setDateOfLicenseExpiry(LocalDate.of(2020, 1, 1));
        driver.setDateOfLicenseIssue(LocalDate.of(2015, 1, 1));
        driver.setDateOfPassportIssue(LocalDate.of(2010, 1, 1));
        driver.setDriversLicenseNumber(123456);
        driver.setDriversLicenseSeries(1234);
        driver.setPassportSeries(1234);
        driver.setPassportNumber(123456);
        driver.setPhoneNumber("9111111111");
        driver.setPlaceOfPassportIssue("Test");
        driver.setResidenceAddress("Test");

        return driver;
    }

    private CompanyToDriverActForm createAct() {
        CompanyToDriverActForm actForm = new CompanyToDriverActForm();
        actForm.setDrafter("Анна Кузьменко");
        actForm.setConditions("Не указано");
        actForm.setAuto(autoService.getAll().get(0));
        actForm.setLeaseEndDate(LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0)));
        actForm.setRenter(driverService.getAllWithoutRentSorted().get(0));
        actForm.setLeaseStartDate(LocalDateTime.now());

        return actForm;
    }
}