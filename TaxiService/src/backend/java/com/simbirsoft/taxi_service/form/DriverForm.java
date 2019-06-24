package com.simbirsoft.taxi_service.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfDriverLicenseIssue;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfDriverLicenseExpiry;
    private Integer passportSeries;
    private Integer passportNumber;
    private String placeOfPassportIssue;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfPassportIssue;
    private String residenceAddress;
    private String actualAddress;
    private String phoneNumber;
    private String telegramLogin;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
}
