package com.insurance.gateway.service;

import com.insurance.gateway.dto.exceptions.CustomerNotCreatedException;
import com.insurance.gateway.dto.external.AddressDTO;
import com.insurance.gateway.dto.external.PersonDataDTO;
import com.insurance.gateway.dto.operations.NewCustomerRequest;
import com.insurance.gateway.dto.operations.NewCustomerResponse;
import com.insurance.gateway.util.ExternalServiceUtil;
import com.insurance.gateway.util.StringUtils;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreateNewCustomerService {

    @Value("${api.customer.create}")
    private String requestUrl;

    public String createNewCustomer(@NonNull PersonDataDTO personData, @NonNull AddressDTO address) {

        // Should in theory validate the fields of the incoming objects.
        // For the moment we only have a NonNull requirement which is taken care of by the annotations.

        NewCustomerRequest  request  = new NewCustomerRequest(personData, address);
        NewCustomerResponse response = null;
        try {
            response = ExternalServiceUtil.callExternalResourceAndReturnResponse(requestUrl, request, NewCustomerResponse.class);
        } catch (IOException e) {
            throw new CustomerNotCreatedException(e);
        }

        if (!StringUtils.checkIfStringIsNullOrEmpty(response.getErrorMessage())) {
            throw new CustomerNotCreatedException(response.getErrorMessage());
        }

        if (StringUtils.checkIfStringIsNullOrEmpty(response.getCustomerIdentification())) {
            throw new CustomerNotCreatedException("No customer identification returned when creating the customer. Please contact the System Administrators!");
        }

        return response.getCustomerIdentification();
    }
}
