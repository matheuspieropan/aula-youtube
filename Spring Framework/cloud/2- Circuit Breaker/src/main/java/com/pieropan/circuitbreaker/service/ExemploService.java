package com.pieropan.circuitbreaker.service;

import com.pieropan.circuitbreaker.exception.MicroServicoOffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExemploService {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private final RestTemplate restTemplate = new RestTemplate();

    public String exemplo() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:8081/exemplo";

        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class), throwable -> fallBack());
    }

    private String fallBack() {
        throw new MicroServicoOffException("Micro serviço 'exemplo' está OFF");
    }
}