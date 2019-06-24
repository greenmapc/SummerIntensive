package com.simbirsoft.taxi_service.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class CompanyToDriverActForm extends ActForm{
    public Long getType() {
        return 1L;
    }
}
