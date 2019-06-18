package com.simbirsoft.taxi_service.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "document")
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //auto id or driver id or something else

    @Column(name = "generated_name", nullable = false, unique = true, length = 128)
    private String generatedName;

    @Column(name = "extension", nullable = false)
    private String extension;
}
