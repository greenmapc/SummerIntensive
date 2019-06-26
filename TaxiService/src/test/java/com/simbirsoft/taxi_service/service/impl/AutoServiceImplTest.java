package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.UserRepository;
import com.simbirsoft.taxi_service.service.AutoService;
import com.simbirsoft.taxi_service.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoServiceImplTest {
    @Autowired
    private AutoService autoService;
    @Autowired
    private UserService userService;

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
        AutoForm auto = createAuto('1', '1');

        Assert.assertNotNull(autoService.createAuto(auto, user).getId());
    }

    @Test
    public void getAllTest() {
        AutoForm autoForm1 = createAuto('3', '3');
        AutoForm autoForm2 = createAuto('2', '2');

        int countBefore = autoService.getAll().size();

        autoService.createAuto(autoForm1, user);
        autoService.createAuto(autoForm2, user);

        Assert.assertEquals(countBefore + 2, autoService.getAll().size());

    }

    @Test
    public void findOneByIdTest() {
        AutoForm autoForm = createAuto('4', '4');

        Long id = autoService.createAuto(autoForm, user).getId();

        Assert.assertEquals(id, autoService.findOneById(id).getId());
    }

    @Test
    public void findAllFree() {
    }

    @Test
    public void findAllRented() {
    }

    @Test
    public void findAllRentedByUser() {
    }

    @Test
    public void updateInfo() {
    }

    private AutoForm createAuto(char lastGosNumberChar, char lastNumberChar) {
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

        return AutoForm.createFromAuto(auto);
    }
}