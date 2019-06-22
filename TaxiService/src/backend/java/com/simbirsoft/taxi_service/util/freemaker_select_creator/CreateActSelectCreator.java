package com.simbirsoft.taxi_service.util.freemaker_select_creator;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreateActSelectCreator {

    public static Map<String, String> fillDriverSelectFields(List<Driver> drivers) {
        Map<String, String> map = new LinkedHashMap<>();
        for (Driver driver : drivers) {
            map.put(driver.getId().toString(), driver.getLastName() + " " +
                    driver.getFirstName() + " " +
                    driver.getPatronymic() + ", " +
                    driver.getBirthDate());
        }
        return map;
    }

    public static Map<String, String> fillAutoSelectFields(List<Auto> autos) {
        Map<String, String> map = new LinkedHashMap<>();
        for (Auto auto : autos) {
            map.put(auto.getId().toString(), auto.getBrand() + ", " +
                    auto.getModel() + ", " +
                    auto.getYear() + ", " +
                    auto.getGosNumber());
        }
        return map;
    }
}
