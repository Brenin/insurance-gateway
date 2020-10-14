package com.insurance.gateway.dto.exceptions;

public class ContractNotActivatedException extends RuntimeException {

    public ContractNotActivatedException(String message) {
        super(message);
    }

}
