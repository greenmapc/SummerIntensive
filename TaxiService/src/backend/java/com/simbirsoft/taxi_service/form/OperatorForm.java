package com.simbirsoft.taxi_service.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OperatorForm {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
}
