package com.insurance.gateway.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewInsuranceRequest {

    @NonNull private PersonDataDTO personData;
    @NonNull private AddressDTO    address;
    @NonNull private InsuranceType insuranceType;
    @NonNull private BigDecimal    insuredAmount;
    @NonNull private String        insuredAmountCurrency; // 3 letter currency code, ex NOK, RON, EUR
    @NonNull private String        startDateInUtcFormat;  // ISO_INSTANT
    @NonNull private String        endDateInUtcFormat;    // ISO_INSTANT

}
