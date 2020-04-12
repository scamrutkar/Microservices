package com.javacase.sagar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DeviceNotFound extends RuntimeException {
    public DeviceNotFound(String msg) {
        super(msg);
    }
}
