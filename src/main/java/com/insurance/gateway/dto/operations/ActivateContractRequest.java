package com.insurance.gateway.dto.operations;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivateContractRequest {

    @NonNull private String contractIdentification;

}
