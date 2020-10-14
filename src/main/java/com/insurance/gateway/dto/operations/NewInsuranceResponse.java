package com.insurance.gateway.dto.operations;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewInsuranceResponse {

    @NonNull private String  contractIdentification;
             private boolean contractWasSent;

    public NewInsuranceResponse(@NonNull String contractIdentification, boolean contractWasSent) {
        this.contractIdentification = contractIdentification;
        this.contractWasSent = contractWasSent;
    }
}
