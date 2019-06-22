package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompanyToDriverActForm extends ActForm {
    private Auto auto;
    private Driver driver;
    private LocalDateTime leaseStartDate;
    private LocalDateTime leaseEndDate;
    private String conditions;
}
