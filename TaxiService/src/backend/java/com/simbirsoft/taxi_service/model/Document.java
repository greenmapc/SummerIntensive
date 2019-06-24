package com.simbirsoft.taxi_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pdf_act_part")
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

    @Column(name = "doc_type", nullable = false)
    private String docType;

    @ManyToOne
    @JoinColumn(name = "driver", referencedColumnName = "id", nullable = true)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "auto", referencedColumnName = "id", nullable = false)
    private Auto auto;
}
