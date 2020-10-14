package com.insurance.gateway.dto.exceptions;

public class CustomerNotCreatedException extends RuntimeException {

    public CustomerNotCreatedException(String message) {
        super(message);
    }

    public CustomerNotCreatedException(Throwable cause) {
        super(cause);
    }
}
