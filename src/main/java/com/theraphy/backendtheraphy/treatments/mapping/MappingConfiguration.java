package com.theraphy.backendtheraphy.treatments.mapping;

import com.theraphy.backendtheraphy.treatments.domain.model.entity.TreatmentPatient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("treatmentsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TreatmentMapper treatmentMapper() { return new TreatmentMapper();}

    @Bean
    public TreatmentPatientMapper treatmentPatientMapper() { return new TreatmentPatientMapper();}
}