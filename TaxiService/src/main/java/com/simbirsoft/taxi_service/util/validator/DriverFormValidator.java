package com.simbirsoft.taxi_service.util.validator;

import com.simbirsoft.taxi_service.form.DriverForm;
import com.simbirsoft.taxi_service.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class DriverFormValidator implements Validator {
    private final Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    private final DriverRepository driverRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return DriverForm.class.equals(aClass);
    }

    @Override
    public void validate(Object driverForm, Errors errors) {
        DriverForm form = (DriverForm) driverForm;
        if (form.getFirstName().isEmpty() ||
                form.getFirstName().length() > ValidatorConstraints.MAX_FIELD_LENGTH) {
            errors.rejectValue("firstName", "error.field.empty");
        }
        if (form.getLastName().isEmpty() ||
                form.getLastName().length() > ValidatorConstraints.MAX_FIELD_LENGTH) {
            errors.rejectValue("lastName", "error.field.empty");
        }
        if (form.getPatronymic().isEmpty() ||
                form.getPatronymic().length() > ValidatorConstraints.MAX_FIELD_LENGTH) {
            errors.rejectValue("patronymic", "error.field.empty");
        }
        if (LocalDate.now().getYear() - form.getBirthDate().getYear() < ValidatorConstraints.MIN_AGE_OF_DRIVER) {
            errors.rejectValue("birthDate", "driverform.birthday");
        }
        if (form.getDriversLicenseSeries() < ValidatorConstraints.MIN_DOCUMENT_SERIES_VALUE ||
                form.getDriversLicenseSeries() > ValidatorConstraints.MAX_DOCUMENT_SERIES_VALUE) {
            errors.rejectValue("driversLicenseSeries", "driverform.license.series");
        }
        if (form.getDriversLicenseNumber() < ValidatorConstraints.MIN_DOCUMENT_NUMBER_VALUE ||
                form.getDriversLicenseNumber() > ValidatorConstraints.MAX_DOCUMENT_NUMBER_VALUE) {
            errors.rejectValue("driversLicenseNumber", "driverform.license.number");
        }
        if (form.getDateOfDriverLicenseIssue().isAfter(LocalDate.now())) {
            errors.rejectValue("dateOаDriverLicenseIssue", "driverform.date.license.issue");
        }
        if (form.getDateOfDriverLicenseExpiry().isBefore(LocalDate.now())) {
            errors.rejectValue("dateOаDriverLicenseExpiry", "driverform.date.license.expiry");
        }
        if (form.getDateOfPassportIssue().isAfter(LocalDate.now())) {
            errors.rejectValue("dateOfPassportIssue", "driverform.date.passport.issue");
        }
        if (form.getPassportSeries() < ValidatorConstraints.MIN_DOCUMENT_SERIES_VALUE ||
                form.getPassportSeries() > ValidatorConstraints.MAX_DOCUMENT_SERIES_VALUE) {
            errors.rejectValue("passportSeries", "driverform.passport.series");
        }
        if (form.getPassportNumber() < ValidatorConstraints.MIN_DOCUMENT_NUMBER_VALUE ||
                form.getPassportNumber() > ValidatorConstraints.MAX_DOCUMENT_NUMBER_VALUE) {
            errors.rejectValue("passportNumber", "driverform.passport.number");
        }
        if (form.getResidenceAddress().isEmpty() ||
                form.getResidenceAddress().length() > ValidatorConstraints.MAX_FIELD_LENGTH) {
            errors.rejectValue("residenceAddress", "error.field.empty");
        }
        if (form.getActualAddress().isEmpty() ||
                form.getActualAddress().length() > ValidatorConstraints.MAX_FIELD_LENGTH) {
            errors.rejectValue("actualAddress", "error.field.empty");
        }
        if (!checkPhoneNumber(form.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", "driverform.phonenumber");
        }
        if (!form.getTelegramLogin().equals(form.getTelegramLoginOld())) {
            if (!form.getTelegramLogin().isEmpty() && checkDuplicateTelegramLogin(form.getTelegramLogin())) {
                errors.rejectValue("telegramLogin", "driverform.telegram.login");
            }
        }
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        return pattern.matcher(phoneNumber).lookingAt();
    }

    private boolean checkDuplicateTelegramLogin(String telegramLogin) {
        return driverRepository.existsDriverByTelegramLogin(telegramLogin);
    }
}
