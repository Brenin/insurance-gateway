package com.insurance.gateway.dto.operations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivateContractResponse extends AbstractResponse {

    private boolean contractWasActivated;

}
