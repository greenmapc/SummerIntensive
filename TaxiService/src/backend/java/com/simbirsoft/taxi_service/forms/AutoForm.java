package com.simbirsoft.taxi_service.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutoForm {
    private String brand;
    private String model;
    private String gosNumber;
    private String vinNumber;
    private String year;
    private Double volume;
    private Integer enginePower;
    private String transmissionType;
    private String drive;
    private String bodyType;
    private String color;
    private String kilometrage;
    private String description;
}
