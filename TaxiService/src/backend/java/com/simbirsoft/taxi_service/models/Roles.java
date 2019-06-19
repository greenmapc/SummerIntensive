package com.simbirsoft.taxi_service.models;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
    ADMIN, OPERATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
