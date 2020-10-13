package com.insurance.gateway.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataDTO {

    @NonNull private String lastName;
    @NonNull private String firstName;
    @NonNull private String pin;
    @NonNull private String citizenshipCountryCode; // 3 letter country code

}
