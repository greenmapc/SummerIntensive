package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Driver;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DriverToDriverActForm extends ActForm {
    private Driver lessor;

    public Long geType() {
        return 2L;
    }

    public Driver getLessor() {
        return this.lessor;
    }

    public void setLessor(Driver lessor) {
        this.lessor = lessor;
    }
}
