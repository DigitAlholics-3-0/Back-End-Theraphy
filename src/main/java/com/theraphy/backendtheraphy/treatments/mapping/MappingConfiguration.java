package com.theraphy.backendtheraphy.treatments.mapping;

import com.theraphy.backendtheraphy.security.mapping.PatientMapper;
import com.theraphy.backendtheraphy.security.mapping.PhysiotherapistMapper;
import com.theraphy.backendtheraphy.security.mapping.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("treatmentsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TreatmentMapper treatmentMapper() { return new TreatmentMapper();}
}