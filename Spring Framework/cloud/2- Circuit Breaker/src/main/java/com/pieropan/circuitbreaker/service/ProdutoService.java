package com.pieropan.circuitbreaker.service;

import com.pieropan.circuitbreaker.domain.Produto;
import com.pieropan.circuitbreaker.exception.MicroServicoOffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    private final RestTemplate restTemplate = new RestTemplate();

    public Produto obterProduto() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        String url = "http://localhost:8081/preco";

        List<Double> historicoPrecos = (List<Double>) circuitBreaker.run(() ->
                restTemplate.getForObject(url, List.class), throwable -> fallBack());

        return new Produto("iPhone 15 Pro", "SmartPhone", historicoPrecos);
    }

    private String fallBack() {
        throw new MicroServicoOffException("Micro serviço 'preco' está OFF");
    }
}