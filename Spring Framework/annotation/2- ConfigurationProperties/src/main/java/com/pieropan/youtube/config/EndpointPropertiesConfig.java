package com.pieropan.youtube.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "endpoint")
public class EndpointPropertiesConfig {

    private String viaCep;

    private String ibge;

    private String qualquer;
}