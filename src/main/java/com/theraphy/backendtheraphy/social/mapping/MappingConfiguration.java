package com.theraphy.backendtheraphy.social.mapping;

import com.theraphy.backendtheraphy.appointments.mapping.AppointmentMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reviewsMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ReviewMapper reviewMapper() { return new ReviewMapper();}
}
