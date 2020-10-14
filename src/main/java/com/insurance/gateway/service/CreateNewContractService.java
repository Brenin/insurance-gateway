package com.insurance.gateway.service;

import com.insurance.gateway.dto.exceptions.ContractNotCreatedException;
import com.insurance.gateway.dto.exceptions.CustomerNotCreatedException;
import com.insurance.gateway.dto.operations.NewContractRequest;
import com.insurance.gateway.dto.operations.NewContractResponse;
import com.insurance.gateway.dto.operations.NewInsuranceRequest;
import com.insurance.gateway.util.ExternalServiceUtil;
import com.insurance.gateway.util.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreateNewContractService {

    @Value("${api.contract.create}")
    private String requestUrl;

    private final ModelMapper modelMapper;

    @Autowired
    public CreateNewContractService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public String createNewContract(String customerIdentification, NewInsuranceRequest newInsuranceRequest) {

        NewContractRequest request = modelMapper.map(newInsuranceRequest, NewContractRequest.class);
        request.setCustomerIdentification(customerIdentification);

        NewContractResponse response = null;
        try {
            response = ExternalServiceUtil.callExternalResourceAndReturnResponse(requestUrl, request, NewContractResponse.class);
        } catch (IOException e) {
            throw new ContractNotCreatedException(e);
        }

        if (!StringUtils.checkIfStringIsNullOrEmpty(response.getErrorMessage())) {
            throw new ContractNotCreatedException(response.getErrorMessage());
        }

        if (StringUtils.checkIfStringIsNullOrEmpty(response.getContractIdentification())) {
            throw new ContractNotCreatedException("No contract identification returned when creating the new contract. Please contact the System Administrators!");
        }

        return response.getContractIdentification();
    }

}