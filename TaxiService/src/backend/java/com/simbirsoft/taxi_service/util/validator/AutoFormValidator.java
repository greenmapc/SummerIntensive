package com.simbirsoft.taxi_service.util.validator;


import com.simbirsoft.taxi_service.form.AutoForm;
import com.simbirsoft.taxi_service.repository.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class AutoFormValidator implements Validator {
    private final Pattern pattern = Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}");
    private final AutoRepository autoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutoForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AutoForm form = (AutoForm) o;
        if (form.getBrand().isEmpty() || form.getBrand().length() > ValidatorConstraints.MAX_FIELD_LENGTH) {
            errors.rejectValue("brand", "error.field.empty");
        }
        if (form.getModel().isEmpty() ||
                form.getModel().length() > ValidatorConstraints.MAX_FIELD_LENGTH) {
            errors.rejectValue("model", "error.field.empty");
        }
        if (!form.getGosNumber().equals(form.getGosNumberOld())) {
            if (!checkGosNumber(form.getGosNumber()) ||
                    checkDuplicateGosNumber(form.getGosNumber())) {
                errors.rejectValue("gosNumber", "autoform.gosnumber");
            }
        }
        if (!form.getVinNumber().equals(form.getVinNumberOld())) {
            if (form.getVinNumber().length() != ValidatorConstraints.VIN_NUMBER_LENGTH ||
                    checkDuplicateVinNumber(form.getVinNumber())) {
                errors.rejectValue("vinNumber", "autoform.vinnumber");
            }
        }
        if (form.getYear() > LocalDateTime.now().getYear() ||
                form.getYear() < ValidatorConstraints.MIN_YEAR_OF_CAR_ISSUE) {
            errors.rejectValue("year", "autoform.year");
        }
        if (form.getVolume() < ValidatorConstraints.MIN_CHARACTERISTIC_VALUE ||
                form.getVolume() > ValidatorConstraints.MAX_VOLUME) {
            errors.rejectValue("volume", "autoform.volume");
        }
        if (form.getEnginePower() < ValidatorConstraints.MIN_CHARACTERISTIC_VALUE ||
                form.getEnginePower() > ValidatorConstraints.MAX_ENGINE_POWER) {
            errors.rejectValue("enginePower", "autoform.enginepower");
        }
        if (form.getTransmissionType().isEmpty()) {
            errors.rejectValue("transmissionType", "error.field.empty");
        }
        if (form.getDrive().isEmpty()) {
            errors.rejectValue("drive", "error.field.empty");
        }
        if (form.getBodyType().isEmpty()) {
            errors.rejectValue("bodyType", "error.field.empty");
        }
        if (form.getColor().isEmpty()) {
            errors.rejectValue("color", "error.field.empty");
        }
        if (form.getKilometrage() < ValidatorConstraints.MIN_CHARACTERISTIC_VALUE ||
                form.getKilometrage() > ValidatorConstraints.MAX_KILOMETRAGE) {
            errors.rejectValue("kilometrage", "autoform.kilometrage");
        }
    }

    private boolean checkGosNumber(String gosNumber) {
        Matcher matcher = pattern.matcher(gosNumber);
        return matcher.lookingAt();
    }

    private boolean checkDuplicateGosNumber(String gosNumber) {
        return autoRepository.existsAutoByGosNumber(gosNumber);
    }

    private boolean checkDuplicateVinNumber(String vinNumber) {
        return autoRepository.existsAutoByVinNumber(vinNumber);
    }
}
