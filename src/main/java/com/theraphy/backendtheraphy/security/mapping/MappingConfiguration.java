package com.theraphy.backendtheraphy.security.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public UserMapper userMapper() { return new UserMapper();}

    @Bean
    public PatientMapper patientMapper() { return new PatientMapper();}
    @Bean
    public PhysiotherapistMapper physiotherapistMapper() { return new PhysiotherapistMapper();}
}