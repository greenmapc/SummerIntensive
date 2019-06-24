package com.simbirsoft.taxi_service.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CompanyToDriverActForm extends ActForm {
    public Long getType() {
        return 1L;
    }
}
