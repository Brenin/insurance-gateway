package com.insurance.gateway.dto.exceptions;

public class ContractNotCreatedException extends RuntimeException {

    public ContractNotCreatedException(String message) {
        super(message);
    }

    public ContractNotCreatedException(Throwable cause) {
        super(cause);
    }
}
