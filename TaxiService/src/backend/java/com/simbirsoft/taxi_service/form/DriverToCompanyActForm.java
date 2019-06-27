package com.simbirsoft.taxi_service.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DriverToCompanyActForm extends ActForm {
    public Long getType() {
        return 3L;
    }
}
