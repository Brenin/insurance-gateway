package com.insurance.gateway.controller;

import com.insurance.gateway.dto.operations.NewInsuranceRequest;
import com.insurance.gateway.service.CreateNewContractService;
import com.insurance.gateway.service.CreateNewCustomerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("api")
@Component
public class CreateContractController {

    private final CreateNewCustomerService createNewCustomerService;
    private final CreateNewContractService createNewContractService;

    @Autowired
    public CreateContractController(CreateNewCustomerService createNewCustomerService, CreateNewContractService createNewContractService) {
        this.createNewCustomerService = createNewCustomerService;
        this.createNewContractService = createNewContractService;
    }

    @GET
    public String sayHello() {
        return "Hello World";
    }

    @POST
    @Path("/createContract")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public void createContract(@NonNull NewInsuranceRequest request) {
        // TODO - Verify internal fields of request

        String customerIdentification = createNewCustomerService.createNewCustomer(request.getPersonData(), request.getAddress());
        String contractIdentification = createNewContractService.createNewContract(customerIdentification, request);


    }
}
