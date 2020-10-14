package com.insurance.gateway.dto.operations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewCustomerResponse extends AbstractResponse {

    private String customerIdentification;

}
