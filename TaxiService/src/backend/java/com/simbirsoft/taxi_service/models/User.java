package com.simbirsoft.taxi_service.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", unique = true, nullable = false, length = 256)
    private String email;

    @Column(name = "hash_password", nullable = false, length = 256)
    private String password;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Column(name = "patronymic", nullable = false, length = 64)
    private String patronymic;
}
