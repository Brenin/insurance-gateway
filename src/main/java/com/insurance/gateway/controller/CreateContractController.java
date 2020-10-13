package com.insurance.gateway.controller;

import com.insurance.gateway.dto.AddressDTO;
import com.insurance.gateway.dto.NewInsuranceRequest;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("api")
@Component
public class CreateContractController {

    @GET
    public String sayHello() {
        return "Hello World";
    }

    @POST
    @Path("/createContract")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void createContract(/*@NonNull*/ NewInsuranceRequest request) {
        // TODO - Verify internal fields of request

        AddressDTO address = request.getAddress();

    }
}
