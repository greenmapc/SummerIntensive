package com.simbirsoft.taxi_service.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Data
public class DriverToCompanyActForm extends ActForm {
    public Long getType() {
        return 3L;
    }
}
