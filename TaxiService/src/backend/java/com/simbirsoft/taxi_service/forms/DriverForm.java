package com.simbirsoft.taxi_service.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class DriverForm {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Integer driversLicenseSeries;
    private Integer driversLicenseNumber;
    private Date dateOfDriverLicenseIssue;
    private Date dateOfDriverLicenseExpiry;
    private Integer passportSeries;
    private Integer passportNumber;
    private String placeOfPassportIssue;
    private Date dateOfPassportIssue;
    private String residenceAddress;
    private String actualAddress;
    private String phoneNumber;
    private String telegramLogin;
    private LocalDate birthday;
}
