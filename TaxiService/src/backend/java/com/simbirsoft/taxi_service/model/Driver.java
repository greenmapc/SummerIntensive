package com.simbirsoft.taxi_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "driver")
@Data
@Indexed
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Field
    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;
    @Field
    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;
    @Field
    @Column(name = "patronymic", nullable = false, length = 64)
    private String patronymic;

    @Column(name = "drivers_license_series", nullable = false, length = 4)
    private Integer driversLicenseSeries;

    @Column(name = "drivers_license_number", nullable = false, length = 6)
    private Integer driversLicenseNumber;

    @Column(name = "date_of_license_issue", nullable = false)
    private LocalDate dateOfLicenseIssue;

    @Column(name = "date_of_license_expiry", nullable = false)
    private LocalDate dateOfLicenseExpiry;

    @Column(name = "passport_series", nullable = false)
    private Integer passportSeries;

    @Column(name = "passport_number", nullable = false)
    private Integer passportNumber;
    @Column(name = "place_of_passport_issue", nullable = false, length = 128)
    private String placeOfPassportIssue;

    @Column(name = "date_of_passport_issue", nullable = false)
    private LocalDate dateOfPassportIssue;

    @Column(name = "residence_address", nullable = false, length = 256)
    private String residenceAddress;

    @Column(name = "actual_address", nullable = false, length = 256)
    private String actualAddress;
    @Field
    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "black_list")
    private Boolean blackList;

    @Column(name = "telegram_login", unique = true, length = 32)
    private String telegramLogin;

    @Column(name = "rating")
    private Integer rating;
    @Field
    @Column(name = "birth_date", nullable = false, columnDefinition = "date")
    private LocalDate birthDate;
    @IndexedEmbedded
    @OneToMany(mappedBy = "driverRenter")
    private List<Act> rentList;
    @IndexedEmbedded
    @OneToMany(mappedBy = "driver")
    private List<Document> documents;

}
