package com.pieropan.youtube.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Locale;

@Configuration
public class ObjectMapperConfiguration {

    @Bean(name = "objectMapperCanada")
    public ObjectMapper objectMapperCanada() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setLocale(Locale.CANADA);

        return objectMapper;
    }

    @Bean
    @Primary
    public ObjectMapper objectMapperFrance() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setLocale(Locale.FRANCE);

        return objectMapper;
    }
}