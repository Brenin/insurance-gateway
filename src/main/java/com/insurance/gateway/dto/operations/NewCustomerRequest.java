package com.insurance.gateway.dto.operations;

import com.insurance.gateway.dto.external.AddressDTO;
import com.insurance.gateway.dto.external.PersonDataDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomerRequest {

    @NonNull private PersonDataDTO personData;
    @NonNull private AddressDTO    address;

}
