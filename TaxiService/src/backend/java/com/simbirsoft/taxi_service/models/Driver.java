package com.simbirsoft.taxi_service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "driver")
@Data
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Column(name = "patronymic", nullable = false, length = 64)
    private String patronymic;

    @Column(name = "drivers_license_series", nullable = false, length = 4)
    private Integer driversLicenseSeries;

    @Column(name = "drivers_license_number", nullable = false, length = 6)
    private Integer driversLicenseNumber;

    @Column(name = "date_of_license_issue", nullable = false)
    private Date dateOfLicenseIssue;

    @Column(name = "date_of_license_expiry", nullable = false)
    private Date dateOfLicenseExpiry;

    @Column(name = "passport_series", nullable = false)
    private Integer passportSeries;

    @Column(name = "passport_number", nullable = false)
    private Integer passportNumber;

    @Column(name = "place_of_passport_issue", nullable = false, length = 128)
    private String placeOfPassportIssue;

    @Column(name = "date_of_passport_issue", nullable = false)
    private Date dateOfPassportIssue;

    @Column(name = "residence_address", nullable = false, length = 256)
    private String residenceAddress;

    @Column(name = "actual_address", nullable = false, length = 256)
    private String actualAddress;

    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "black_list")
    private Boolean blackList;

    @Column(name = "telegram_login", unique = true, length = 32)
    private String telegramLogin;

    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy = "driver_renter")
    private List<Act> rentList;

    @OneToMany(mappedBy = "driver")
    private List<Document> documents;

}
