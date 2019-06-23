package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
public class CompanyToDriverActForm extends ActForm{
    public Long getType() {
        return 1L;
    }
}
