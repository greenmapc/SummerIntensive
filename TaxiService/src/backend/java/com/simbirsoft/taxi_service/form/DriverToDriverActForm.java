package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class DriverToDriverActForm extends ActForm {
    private Driver recipient;

    public Long geType() {
        return 2L;
    }
}
