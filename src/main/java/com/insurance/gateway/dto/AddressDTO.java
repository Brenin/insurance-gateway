package com.insurance.gateway.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class AddressDTO {

    @NonNull private String streetName;
    @NonNull private String number;
             private String entrance;
             private String apartment;
             private String floor;
    @NonNull private String postalCode;
    @NonNull private String city;
    @NonNull private String countryThreeLetterCode;

}
