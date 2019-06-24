package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DriverToDriverActForm extends ActForm {
    protected Driver lessor;
    public Long getType() {
        return 2L;
    }
}
