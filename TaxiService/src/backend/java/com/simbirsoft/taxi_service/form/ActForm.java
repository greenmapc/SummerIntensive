package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public abstract class ActForm {
    private Auto auto;
    private Driver renter;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime leaseStartDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime leaseEndDate;
    private String conditions;
    private String drafter;
}
