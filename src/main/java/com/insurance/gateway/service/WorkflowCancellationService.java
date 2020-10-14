package com.insurance.gateway.service;

import com.insurance.gateway.dto.exceptions.WorkflowRollbackFailedException;
import com.insurance.gateway.dto.operations.CancelContractRequest;
import com.insurance.gateway.dto.operations.CancelContractResponse;
import com.insurance.gateway.util.ExternalServiceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WorkflowCancellationService {

    @Value("${api.contract.cancel}")
    private String requestUrl;

    public void tryToRollbackWorkflowInOtherSystem(String customerIdentification, String  contractIdentification) {

        CancelContractRequest request = new CancelContractRequest(customerIdentification, contractIdentification);

        try {
            ExternalServiceUtil.callExternalResourceAndReturnResponse(requestUrl, request, CancelContractResponse.class);
        } catch (IOException e) {
            String message = "Rollback failed because: [" + e.getMessage() + "]";
            throw new WorkflowRollbackFailedException(message);
        }
    }
}
