package com.pieropan.youtube;

import com.pieropan.youtube.config.EndpointPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAulaApplication {

    @Value("${endpoint.ibge}")
    private String endpointIbge;

    @Value("${endpoint.viaCep}")
    private String viaCep;

    @Autowired
    private EndpointPropertiesConfig endpointPropertiesConfig;

    public static void main(String[] args) {
        SpringApplication.run(SpringAulaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println(endpointPropertiesConfig.getIbge());
            System.out.println(endpointPropertiesConfig.getViaCep());
        };
    }
}