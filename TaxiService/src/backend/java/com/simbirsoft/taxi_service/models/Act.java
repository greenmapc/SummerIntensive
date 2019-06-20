package com.simbirsoft.taxi_service.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "acts")
@Data
@NoArgsConstructor
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Auto auto;

    @Column(name = "lease_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaseStartDate;

    @Column(name = "lease_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaseEndDate;


}
