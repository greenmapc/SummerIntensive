package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Driver;
import lombok.*;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Getter
@Setter
public class DriverToDriverActForm extends ActForm {
    private Driver lessor;

    public Long getType() {
        return 2L;
    }
}
