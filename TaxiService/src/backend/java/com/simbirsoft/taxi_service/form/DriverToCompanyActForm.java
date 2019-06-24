package com.simbirsoft.taxi_service.form;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Getter
@Setter
public class DriverToCompanyActForm extends ActForm {
    public Long getType() {
        return 3L;
    }
}
