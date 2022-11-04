package com.theraphy.backendtheraphy.treatments.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("treatmentsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TreatmentMapper treatmentMapper() { return new TreatmentMapper();}
}