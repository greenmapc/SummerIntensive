package com.simbirsoft.taxi_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acts")
@Data
@NoArgsConstructor
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "auto", referencedColumnName = "id", nullable = false)
    private Auto auto;

    @Column(name = "lease_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaseStartDate;

    @Column(name = "lease_end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date leaseEndDate;

    @Column(name = "drafter", nullable = false, length = 192)
    private String drafter;

    @Column(name = "conditions", length = 512)
    private String conditions;

    @ManyToOne
    @JoinColumn(name = "driver_renter", referencedColumnName = "id")
    private Driver driverRenter;

    @ManyToOne
    @JoinColumn(name = "driver_recipient", referencedColumnName = "id")
    private Driver driverRecipient;

}
