package com.simbirsoft.taxi_service.dto;

import com.simbirsoft.taxi_service.model.Auto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AutoSelectDto {
    private String brand;
    private String model;
    private Integer year;
    private String gosNumber;
    private Long id;

    public AutoSelectDto createByAuto(Auto auto) {
        AutoSelectDto dto = new AutoSelectDto();
        dto.setBrand(auto.getBrand());
        dto.setModel(auto.getModel());
        dto.setYear(auto.getYear());
        dto.setGosNumber(auto.getGosNumber());
        dto.setId(auto.getId());

        return dto;
    }
}
