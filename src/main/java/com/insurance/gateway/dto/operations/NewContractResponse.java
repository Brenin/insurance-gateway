package com.insurance.gateway.dto.operations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewContractResponse extends AbstractResponse {

    private String contractIdentification;

}
