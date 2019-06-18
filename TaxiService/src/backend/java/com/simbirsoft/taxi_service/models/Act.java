package com.simbirsoft.taxi_service.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "acts")
@Data
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
