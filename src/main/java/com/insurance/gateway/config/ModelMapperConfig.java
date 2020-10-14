package com.insurance.gateway.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

//        modelMapper.createTypeMap(Person.class, CitizenshipEntity.class)
//                .addMapping(Person::getCitizenshipCountryCode, CitizenshipEntity::setCountryCode)
//                .addMapping(Person::getPin, CitizenshipEntity::setPin);

        return modelMapper;
    }

}
