package com.simbirsoft.taxi_service.util.validator;

import com.simbirsoft.taxi_service.form.OperatorForm;
import com.simbirsoft.taxi_service.util.ValidatorConstraints;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class OperatorFormValidator implements Validator {
    private Pattern pattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+");

    @Override
    public boolean supports(Class<?> aClass) {
        return OperatorForm.class.equals(aClass);
    }

    @Override
    public void validate(Object operatorForm, Errors errors) {
        OperatorForm form = (OperatorForm) operatorForm;
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
        if (!checkEmail(form.getEmail())) {
            errors.rejectValue("email", "operatorform.email");
        }
    }

    private boolean checkEmail(String email) {
        return pattern.matcher(email).lookingAt();
    }
}
