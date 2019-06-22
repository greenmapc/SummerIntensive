package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
public class CompanyToDriverActForm extends ActForm {
    private Auto auto;
    private Driver driver;
    private LocalDateTime leaseStartDate;
    private LocalDateTime leaseEndDate;
    private String conditions;
    private String drafter;

    private final Long type = 1L;
}
