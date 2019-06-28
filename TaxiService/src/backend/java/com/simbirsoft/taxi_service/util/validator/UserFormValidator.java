package com.simbirsoft.taxi_service.util.validator;

import com.simbirsoft.taxi_service.form.UserForm;
import com.simbirsoft.taxi_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class UserFormValidator implements Validator {
    private Pattern pattern = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+");
    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object userForm, Errors errors) {
        UserForm form = (UserForm) userForm;
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
        if (!checkEmail(form.getEmail()) || checkDuplicateEmail(form.getEmail())) {
            errors.rejectValue("email", "userform.email");
        }
        if (!form.getNewPassword().isEmpty() && form.getNewPassword2().isEmpty()) {
            errors.rejectValue("newPassword2", "error.field.empty");
        }
        if (form.getNewPassword().isEmpty() && !form.getNewPassword2().isEmpty()) {
            errors.rejectValue("newPassword", "error.field.empty");
        }
        if (!form.getNewPassword().isEmpty() && !form.getNewPassword2().isEmpty()) {
            if (!form.getNewPassword2().equals(form.getNewPassword())) {
                errors.rejectValue("newPassword", "userform.password.incorrect");
                errors.rejectValue("newPassword2", "userform.password.incorrect");
            }
        }
    }

    private boolean checkEmail(String email) {
        return pattern.matcher(email).lookingAt();
    }

    private boolean checkDuplicateEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }
}
