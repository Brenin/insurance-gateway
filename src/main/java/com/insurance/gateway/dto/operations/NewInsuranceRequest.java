package com.insurance.gateway.dto.operations;

import com.insurance.gateway.dto.external.AddressDTO;
import com.insurance.gateway.dto.external.InsuranceType;
import com.insurance.gateway.dto.external.PersonDataDTO;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewInsuranceRequest {

    // For creating new customer
    @NonNull private PersonDataDTO personData;
    @NonNull private AddressDTO    address;

    // For creating new contract
    @NonNull private InsuranceType insuranceType;
    @NonNull private BigDecimal    insuredAmount;
    @NonNull private String        insuredAmountCurrency; // 3 letter currency code, ex NOK, RON, EUR
    @NonNull private String        startDateInUtcFormat;  // ISO_INSTANT
    @NonNull private String        endDateInUtcFormat;    // ISO_INSTANT

}
