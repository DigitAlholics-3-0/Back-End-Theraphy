package com.theraphy.backendtheraphy.profiles.mapping;

import com.theraphy.backendtheraphy.security.mapping.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public EducationMapper educationMapper() { return new EducationMapper();}

    @Bean
    public UniversityMapper universityMapper() { return new UniversityMapper();}
}
