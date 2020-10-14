package com.insurance.gateway.dto.external;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataDTO {

    @NonNull private String lastName;
    @NonNull private String firstName;
    @NonNull private String email;
    @NonNull private String pin;
    @NonNull private String citizenshipCountryCode; // 3 letter country code

}
