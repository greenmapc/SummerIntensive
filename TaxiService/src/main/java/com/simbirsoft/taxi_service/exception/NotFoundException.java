package com.simbirsoft.taxi_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Page not found")
public class NotFoundException extends IllegalArgumentException {
}
