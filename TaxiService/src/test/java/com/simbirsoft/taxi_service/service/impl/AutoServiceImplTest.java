package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.UserRepository;
import com.simbirsoft.taxi_service.service.ActService;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.DriverService;
import com.simbirsoft.taxi_service.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoServiceImplTest {
    @Autowired
    private AutoService autoService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActService actService;
    @Autowired
    private DriverService driverService;

    private final String DRIVE = "передний";
    private final String COLOR = "белый";
    private final String BRAND = "Lada";
    private final String MODEL = "Vesta";
    private final String BODY_TYPE = "седан";
    private final Integer POWER = 100;
    private final Integer KILOMETRAGE = 20;
    private final String GOS_NUMBER = "А111А12";
    private final String TRANSMISSION = "механика";
    private final String VIN = "1234567891234567";
    private final Double VOLUME = 1.6;
    private final Integer YEAR = 2018;

    private User user;

    @Before
    public void setUp() {
        user = userService.findOneById(1L);
    }


    @Test
    public void createAutoTest() {
        AutoForm auto = createAutoFormByAuto(createAuto('1', '1'));

        Assert.assertNotNull(autoService.createAuto(auto, user).getId());
    }

    @Test
    public void getAllTest() {
        AutoForm autoForm1 = createAutoFormByAuto(createAuto('3', '3'));
        AutoForm autoForm2 = createAutoFormByAuto(createAuto('2', '2'));

        int countBefore = autoService.getAll().size();

        autoService.createAuto(autoForm1, user);
        autoService.createAuto(autoForm2, user);

        Assert.assertEquals(countBefore + 2, autoService.getAll().size());

    }

    @Test
    public void findOneByIdTest() {
        AutoForm autoForm = createAutoFormByAuto(createAuto('4', '4'));

        Long id = autoService.createAuto(autoForm, user).getId();

        Assert.assertEquals(id, autoService.findOneById(id).getId());
    }

    @Test
    public void findAllFreeTest() {
        int countBeforeRent = autoService.getAll().size();

        actService.createActFromCompanyToDriver(createAct(), user);
        int countAfterRent = autoService.findAllFree().size();

        Assert.assertEquals(countBeforeRent - 1, countAfterRent);

    }

    @Test
    public void findAllRentedTest() {
        actService.createActFromCompanyToDriver(createAct(), user);
        int countBeforeRent = autoService.findAllRented().size();

        Assert.assertEquals(1, countBeforeRent);
    }

    @Test
    public void findAllRentedByDriverTest() {
        Driver driverRenter = driverService.getAllWithoutRentSorted().get(0);
        Auto rentedAuto = autoService.getAll().get(0);
        actService.createActFromCompanyToDriver(createAct(), user);

        Assert.assertEquals(rentedAuto.getId(), autoService.findAutoRentedByDriver(driverRenter.getId()).getId());
    }

    @Test
    public void updateInfo() {
        Auto updateAuto = autoService.findOneById(2L);
        AutoForm autoForm = AutoForm.createFromAuto(updateAuto);

        autoForm.setYear(1999);
        autoForm.setVolume(1.5);
        autoForm.setVinNumber("11111111111111111");
        autoForm.setModel("Astra");
        autoForm.setBrand("Opel");
        autoForm.setGosNumber("A111AA150");
        autoForm.setEnginePower(90);
        autoForm.setKilometrage(200);
        autoForm.setColor("Черный");
        autoForm.setDrive("полный");
        autoForm.setState(false);

        autoService.updateInfo(updateAuto, autoForm);
        Assert.assertEquals(updateAuto, autoService.findOneById(updateAuto.getId()));
    }

    private Auto createAuto(char lastGosNumberChar, char lastNumberChar) {
        Auto auto = new Auto();
        auto.setDrive(DRIVE);
        auto.setColor(COLOR);
        auto.setBrand(BRAND);
        auto.setBodyType(BODY_TYPE);
        auto.setEnginePower(POWER);
        auto.setKilometrage(KILOMETRAGE);
        auto.setGosNumber(GOS_NUMBER + lastGosNumberChar);
        auto.setTransmission(TRANSMISSION);
        auto.setModel(MODEL);
        auto.setVinNumber(VIN + lastNumberChar);
        auto.setVolume(VOLUME);
        auto.setYear(YEAR);

        return auto;
    }

    private AutoForm createAutoFormByAuto(Auto auto) {
        return AutoForm.createFromAuto(auto);
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