package com.simbirsoft.taxi_service.form;

import com.simbirsoft.taxi_service.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserForm {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private String emailOld;
    private String newPassword;
    private String newPassword2;

    public static UserForm createFromUser(User userFromDb) {
        return UserForm.builder()
                .email(userFromDb.getEmail())
                .emailOld(userFromDb.getEmail())
                .firstName(userFromDb.getFirstName())
                .lastName(userFromDb.getLastName())
                .patronymic(userFromDb.getPatronymic())
                .build();
    }
}
