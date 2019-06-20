package com.simbirsoft.taxi_service.validation;


import com.simbirsoft.taxi_service.forms.AutoForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AutoFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AutoForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AutoForm form = (AutoForm) o;
        if (form.getBrand().isEmpty() || form.getBrand().length() > 64) {
            errors.rejectValue("brand", "autoform.field.empty");
        }
        if (form.getModel().isEmpty() || form.getModel().length() > 64) {
            errors.rejectValue("model", "autoform.field.empty");
        }
        if (!checkGosNumber(form.getGosNumber())) {
            errors.reject("gosNumber", "autoform.gosnumber");
        }
        if (form.getVinNumber().length() != 17) {
            errors.reject("vinNumber", "autoform.vinnumber");
        }
        if (form.getYear() > LocalDateTime.now().getYear() || form.getYear() < 1960) {
            errors.rejectValue("year", "autoform.year");
        }
        if (form.getVolume() < 0 || form.getVolume() > 5) {
            errors.rejectValue("volume", "autoform.volume");
        }
        if (form.getEnginePower() < 0 || form.getEnginePower() > 600) {
            errors.rejectValue("enginePower", "autoform.enginepower");
        }
        if (form.getTransmissionType().isEmpty()) {
            errors.rejectValue("transmissionType", "autoform.field.empty");
        }
        if (form.getDrive().isEmpty()) {
            errors.rejectValue("drive", "autoform.field.empty");
        }
        if (form.getBodyType().isEmpty()) {
            errors.rejectValue("bodyType", "autoform.field.empty");
        }
        if (form.getColor().isEmpty()) {
            errors.rejectValue("color", "autoform.field.empty");
        }
        if (form.getKilometrage() < 0 || form.getKilometrage() > 500000) {
            errors.rejectValue("kilometrage", "autoform.kilometrage");
        }
    }

    private boolean checkGosNumber(String gosNumber) {
        Pattern patternTaxi = Pattern.compile("[АВЕКМНОРСТУХ]{2}\\d{3}(?<!000)\\d{2,3}");
        Matcher matcherTaxi = patternTaxi.matcher(gosNumber);
        Pattern patternAuto = Pattern.compile("[АВЕКМНОРСТУХ]\\d{3}(?<!000)[АВЕКМНОРСТУХ]{2}\\d{2,3}");
        Matcher matcherAuto = patternAuto.matcher(gosNumber);
        return matcherTaxi.lookingAt() || matcherAuto.lookingAt();
    }
}
