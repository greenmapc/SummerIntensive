package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.Driver;
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
    private LocalDate birthday;
    private boolean blackList;
    private Integer rating;

    public static DriverForm createFromDriver(Driver driver) {
        DriverForm form = new DriverForm();
        form.setFirstName(driver.getFirstName());
        form.setLastName(driver.getLastName());
        form.setPatronymic(driver.getPatronymic());
        form.setDriversLicenseSeries(driver.getDriversLicenseSeries());
        form.setDriversLicenseNumber(driver.getDriversLicenseNumber());
        form.setDateOfDriverLicenseIssue(driver.getDateOfLicenseIssue());
        form.setDateOfDriverLicenseExpiry(driver.getDateOfLicenseExpiry());
        form.setPassportSeries(driver.getPassportSeries());
        form.setPassportNumber(driver.getPassportNumber());
        form.setPlaceOfPassportIssue(driver.getPlaceOfPassportIssue());
        form.setDateOfPassportIssue(driver.getDateOfPassportIssue());
        form.setResidenceAddress(driver.getResidenceAddress());
        form.setActualAddress(driver.getActualAddress());
        form.setPhoneNumber(driver.getPhoneNumber());
        form.setTelegramLogin(driver.getTelegramLogin());
        form.setBirthday(driver.getBirthDate());
        form.setBlackList(driver.getBlackList());
        form.setRating(driver.getRating());
        return form;
    }
}
