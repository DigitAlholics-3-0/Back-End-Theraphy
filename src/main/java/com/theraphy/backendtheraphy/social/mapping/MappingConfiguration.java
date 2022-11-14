package com.theraphy.backendtheraphy.social.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reviewsMappingConfiguration")
public class MappingConfiguration {
    //new change
    @Bean
    public ReviewMapper reviewMapper() { return new ReviewMapper();}
}
