package com.insurance.gateway.dto.operations;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CancelContractRequest {

    @NonNull private String customerIdentification;
    @NonNull private String contractIdentification;

}
