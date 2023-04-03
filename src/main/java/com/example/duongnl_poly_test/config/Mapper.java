package com.example.duongnl_poly_test.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMapper() {
        org.modelmapper.ModelMapper modelMapper = new org.modelmapper.ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}
