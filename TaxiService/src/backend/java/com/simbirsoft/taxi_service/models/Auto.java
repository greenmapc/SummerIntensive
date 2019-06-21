package com.simbirsoft.taxi_service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(name = "gos_number", nullable = false, length = 10, unique = true)
    private String gosNumber;

    @Column(name = "vin_number", nullable = false, length = 17, unique = true)
    private String vinNumber;

    @Column(name = "year", nullable = false, length = 4)
    private Integer year;

    @Column(name = "volume", nullable = false)
    private Double volume;

    @Column(name = "engine_power", nullable = false)
    private Integer enginePower;

    @Column(name = "transmission", nullable = false, length = 8)
    private String transmission;

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


    @OneToMany(mappedBy = "auto")
    private List<Act> actList;

    @OneToMany(mappedBy = "auto")
    private List<Document> documents;

}
