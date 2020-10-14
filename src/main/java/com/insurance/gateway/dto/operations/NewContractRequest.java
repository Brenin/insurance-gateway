package com.insurance.gateway.dto.operations;

import com.insurance.gateway.dto.external.InsuranceType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewContractRequest {

    @NonNull private String        customerIdentification;
    @NonNull private InsuranceType insuranceType;
    @NonNull private BigDecimal    insuredAmount;
    @NonNull private String        insuredAmountCurrency; // 3 letter currency code, ex NOK, RON, EUR
    @NonNull private String        startDateInUtcFormat;  // ISO_INSTANT
    @NonNull private String        endDateInUtcFormat;    // ISO_INSTANT

}
