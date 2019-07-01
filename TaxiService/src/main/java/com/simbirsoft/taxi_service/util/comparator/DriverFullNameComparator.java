package com.simbirsoft.taxi_service.util.comparator;

import com.simbirsoft.taxi_service.model.Driver;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class DriverFullNameComparator implements Comparator<Driver> {
    @Override
    public int compare(Driver driver1, Driver driver2) {
        if (!driver1.getLastName().equals(driver2.getLastName())) {
            return driver1.getLastName().compareTo(driver2.getLastName());
        }
        if (!driver1.getFirstName().equals(driver2.getFirstName())) {
            return driver1.getFirstName().compareTo(driver2.getFirstName());
        }
        if (!driver1.getPatronymic().equals(driver2.getPatronymic())) {
            return driver1.getPatronymic().compareTo(driver2.getPatronymic());
        }
        return 0;
    }
}
