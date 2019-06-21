package com.simbirsoft.taxi_service.validators;

import com.simbirsoft.taxi_service.forms.DriverForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DriverFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return DriverForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        DriverForm form = (DriverForm) o;
        if (form.getFirstName().isEmpty() || form.getFirstName().length() > 64) {
            errors.rejectValue("firstName", "driverform.field.empty");
        }
        if (form.getLastName().isEmpty() || form.getLastName().length() > 64) {
            errors.rejectValue("lastName", "driverform.field.empty");
        }
        if (form.getPatronymic().isEmpty() || form.getPatronymic().length() > 64) {
            errors.rejectValue("patronymic", "driverform.field.empty");
        }
        if (form.getDriversLicenseSeries() < 1000 || form.getDriversLicenseSeries() > 10000) {
            errors.rejectValue("driversLicenseSeries", "driverform.license.series");
        }
        if (form.getDriversLicenseSeries() < 100000 || form.getDriversLicenseSeries() > 1000000) {
            errors.rejectValue("driversLicenseNumber", "driverform.license.number");
        }
        if (form.getDateOfDriverLicenseIssue().getTime() > System.currentTimeMillis()) {
            errors.rejectValue("dateOdDriverLicenseIssue", "driverform.date.license.issue");
        }
        if (form.getDateOfDriverLicenseExpiry().getTime() < System.currentTimeMillis()) {
            errors.rejectValue("dateOdDriverLicenseExpiry", "driverform.date.license.expiry");
        }
        if (form.getPassportSeries() < 1000 || form.getPassportSeries() > 10000) {
            errors.rejectValue("passportSeries", "driverform.passport.series");
        }
        if (form.getPassportNumber() < 100000 || form.getPassportNumber() > 1000000) {
            errors.rejectValue("passportNumber", "driverform.passport.number");
        }
        if (form.getResidenceAddress().isEmpty() || form.getResidenceAddress().length() > 64) {
            errors.rejectValue("residenceAddress", "driverform.field.empty");
        }
        if (form.getActualAddress().isEmpty() || form.getActualAddress().length() > 64) {
            errors.rejectValue("actualAddress", "driverform.field.empty");
        }
        if (!checkPhoneNumber(form.getPhoneNumber())) {
            errors.rejectValue("phoneNumber", "driverform.phonenumber");
        }
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.lookingAt();
    }
}
