package com.insurance.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.gateway.dto.external.AddressDTO;
import com.insurance.gateway.dto.external.InsuranceType;
import com.insurance.gateway.dto.operations.NewInsuranceRequest;
import com.insurance.gateway.dto.external.PersonDataDTO;

import java.math.BigDecimal;

public class CreateJsonSoWeDoNotHaveToBeACodeMonkey {

    public static void main(String[] args) throws JsonProcessingException {
        AddressDTO address = new AddressDTO(
                "streetName",
                "number",
                "entrance",
                "apartment",
                "floor",
                "postalCode",
                "city",
                "ROU"
        );

        PersonDataDTO personData = new PersonDataDTO(
                "lastName",
                "firstName",
                "eirikur.lundin@outlook.com",
                "pin",
                "ROU"
        );

        NewInsuranceRequest request = new NewInsuranceRequest(
                personData,
                address,
                InsuranceType.CAR_INSURANCE,
                BigDecimal.TEN,
                "RON",
                "2011-12-03T10:15:30Z",
                "2011-12-03T10:15:30Z"
        );

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

    }

}
