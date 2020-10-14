package com.insurance.gateway.dto.exceptions;

public class WorkflowRollbackFailedException extends RuntimeException {

    public WorkflowRollbackFailedException(String message) {
        super(message);
    }
}
