package com.simbirsoft.taxi_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "document")
@Data
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "generated_name", nullable = false, unique = true, length = 128)
    private String generatedName;

    @Column(name = "extension", nullable = false)
    private String extension;

    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "auto", referencedColumnName = "id")
    private Auto auto;
}
