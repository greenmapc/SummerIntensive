package com.simbirsoft.taxi_service.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "auto")
@Data
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false, length = 64)
    private String brand;

    @Column(name = "model", nullable = false, length = 128)
    private String model;

    @Column(name = "gos_number", nullable = false, length = 8)
    private String gosNumber;

    @Column(name = "vin_number", nullable = false, length = 17)
    private String vinNumber;

    @Column(name = "year", nullable = false, length = 4)
    private Integer year;

    @Column(name = "volume", nullable = false)
    private Double volume;

    @Column(name = "engine_power", nullable = false)
    private Integer enginePower;

    @Column(name = "transmission_type", nullable = false, length = 8)
    private String transmissionType;

    /**
     * Drive of the car. This field may be take a values like "front", "back" or "full"
     * */
    @Column(name = "drive", nullable = false, length = 32)
    private String drive;

    @Column(name = "body_type", nullable = false, length = 16)
    private String bodyType;

    @Column(name = "color", nullable = false, length = 32)
    private String color;

    @Column(name = "description", length = 512)
    private String description;

    @OneToOne
    private Driver driver;

    @Column(name = "kilometrage", nullable = false)
    private Integer kilometrage;

    @Column(name = "state", nullable = false)
    private Boolean state;
}
