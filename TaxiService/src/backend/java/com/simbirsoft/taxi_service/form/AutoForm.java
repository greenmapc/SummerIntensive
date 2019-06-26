package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Auto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutoForm {
    private String brand;
    private String model;
    private String gosNumber;
    private String vinNumber;
    private Integer year;
    private Double volume;
    private Integer enginePower;
    private String transmissionType;
    private String drive;
    private String bodyType;
    private String color;
    private Integer kilometrage;
    private String description;
    private Boolean state = true;


    public static AutoForm createFromAuto(Auto auto) {
        AutoForm form = new AutoForm();
        form.setBrand(auto.getBrand());
        form.setModel(auto.getModel());
        form.setGosNumber(auto.getGosNumber());
        form.setVinNumber(auto.getVinNumber());
        form.setYear(auto.getYear());
        form.setVolume(auto.getVolume());
        form.setEnginePower(auto.getEnginePower());
        form.setEnginePower(auto.getEnginePower());
        form.setTransmissionType(auto.getTransmission());
        form.setDrive(auto.getDrive());
        form.setBodyType(auto.getBodyType());
        form.setColor(auto.getColor());
        form.setKilometrage(auto.getKilometrage());
        form.setDescription(auto.getDescription());
        form.setState(true);
        return form;
    }
}
