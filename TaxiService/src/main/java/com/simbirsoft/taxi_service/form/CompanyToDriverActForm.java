package com.simbirsoft.taxi_service.form;

import lombok.*;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Getter
@Setter
public class CompanyToDriverActForm extends ActForm{
    public Long getType() {
        return 1L;
    }
}
