package com.insurance.gateway.service;

import com.insurance.gateway.dto.exceptions.ContractNotActivatedException;
import com.insurance.gateway.dto.operations.ActivateContractRequest;
import com.insurance.gateway.dto.operations.ActivateContractResponse;
import com.insurance.gateway.util.ExternalServiceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ActivateNewContractService {

    @Value("${api.contract.activate}")
    private String requestUrl;

    public boolean activateContract(String contractIdentification) {

        ActivateContractRequest request = new ActivateContractRequest(contractIdentification);

        ActivateContractResponse response;
        try {
            response = ExternalServiceUtil.callExternalResourceAndReturnResponse(requestUrl, request, ActivateContractResponse.class);
        } catch (IOException e) {
            throw new ContractNotActivatedException(e.getMessage());
        }

        return response != null && response.isContractWasActivated();
    }

}
