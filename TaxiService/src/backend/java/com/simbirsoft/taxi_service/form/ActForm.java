package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public abstract class ActForm {
    protected Auto auto;
    protected Driver renter;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected LocalDateTime leaseStartDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    protected LocalDateTime leaseEndDate;
    protected String conditions = "Не указано";
    protected String drafter;

    public abstract Long getType();
}
