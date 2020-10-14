package com.insurance.gateway.controller;

import com.insurance.gateway.dto.operations.CancelContractResponse;
import com.insurance.gateway.dto.operations.NewInsuranceRequest;
import com.insurance.gateway.dto.operations.NewInsuranceResponse;
import com.insurance.gateway.service.*;
import com.insurance.gateway.util.DateUtil;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("api")
@Component
public class CreateContractController {

    private final CreateNewCustomerService    createNewCustomerService;
    private final CreateNewContractService    createNewContractService;
    private final ActivateNewContractService  activateNewContractService;
    private final WorkflowCancellationService workflowCancellationService;
    private final MailService                 mailService;

    @Autowired
    public CreateContractController(CreateNewCustomerService createNewCustomerService, CreateNewContractService createNewContractService,
                                    ActivateNewContractService activateNewContractService, WorkflowCancellationService workflowCancellationService,
                                    MailService mailService
    ) {
        this.createNewCustomerService = createNewCustomerService;
        this.createNewContractService = createNewContractService;
        this.activateNewContractService = activateNewContractService;
        this.workflowCancellationService = workflowCancellationService;
        this.mailService = mailService;
    }

    @POST
    @Path("/createContract")
    @Consumes({ MediaType.APPLICATION_JSON})
    @Produces({ MediaType.APPLICATION_JSON})
    public Response createContract(@NonNull NewInsuranceRequest request) {

        LocalDate startDate = DateUtil.createLocalDateFromIncomingParameter(request.getStartDate());
        LocalDate endDate   = DateUtil.createLocalDateFromIncomingParameter(request.getEndDate());

        // Sanity check
        if (startDate.isAfter(endDate)) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("StartDate [" + startDate.toString() + "] must be before endDate [" + endDate.toString() + "]")
                    .build();
        }

        String  customerIdentification = null;
        String  contractIdentification = null;
        boolean contractWasSetToActive;
        try {
            // Crete new customer
            customerIdentification = createNewCustomerService.createNewCustomer(request.getPersonData(), request.getAddress());

            // Create new contract
            contractIdentification = createNewContractService.createNewContract(customerIdentification, request);

            // Send email with contract. Should also contain the PDFs for the contract but we don't have those
            mailService.sendEmailToCustomer(request.getPersonData()); // Async, so fire and forget

            // Set status as active (sent)
            contractWasSetToActive = activateNewContractService.activateContract(contractIdentification);
        } catch (Exception e) {
            workflowCancellationService.tryToRollbackWorkflowInOtherSystem(customerIdentification, contractIdentification);

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }

        NewInsuranceResponse response = new NewInsuranceResponse(contractIdentification, contractWasSetToActive);
        return Response.ok().entity(response).build();
    }
}
