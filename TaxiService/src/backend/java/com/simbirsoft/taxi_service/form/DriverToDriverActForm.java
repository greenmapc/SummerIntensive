package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Driver;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class DriverToDriverActForm extends ActForm {
    private Driver recipient;

    public Long geType() {
        return 2L;
    }
}
