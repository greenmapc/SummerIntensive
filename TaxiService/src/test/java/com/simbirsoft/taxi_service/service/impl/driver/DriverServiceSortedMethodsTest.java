package com.simbirsoft.taxi_service.service.impl.driver;

import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.model.User;
import com.simbirsoft.taxi_service.repository.DriverRepository;
import com.simbirsoft.taxi_service.repository.UserRepository;
import com.simbirsoft.taxi_service.service.DriverService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class DriverServiceSortedMethodsTest {
    @Autowired
    private DriverService driverService;
    @Autowired
    private UserRepository userRepository;

    @MockBean
    private DriverRepository driverRepository;

    private User user;

    @Before
    public void setUp() {
        user = userRepository.findById(1L).get();
    }

    @Test
    public void getAllSorted() {
        Driver driverTest1 = new Driver();
        driverTest1.setFirstName("A");
        driverTest1.setLastName("A");
        driverTest1.setPatronymic("B");

        Driver driverTest2 = new Driver();
        driverTest2.setFirstName("A");
        driverTest2.setLastName("A");
        driverTest2.setPatronymic("A");

        List<Driver> mockResultList = new ArrayList<>();
        mockResultList.add(driverTest1);
        mockResultList.add(driverTest2);

        when(driverRepository.findAll()).thenReturn(mockResultList);

        Driver[] drivers = {driverTest2, driverTest1};


        Assert.assertArrayEquals(drivers, driverService.getAllSorted().toArray());
    }
}
