package com.insurance.gateway.dto;

import com.insurance.gateway.dto.operations.NewInsuranceRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Customer {

    private NewInsuranceRequest newInsuranceRequest;

    private UUID customerIdentification;
    private UUID contractIdentification;

}
