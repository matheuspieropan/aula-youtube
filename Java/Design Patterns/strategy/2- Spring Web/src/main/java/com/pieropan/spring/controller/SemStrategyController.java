package com.pieropan.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transportadora")
public class SemStrategyController {

    @GetMapping("/frete")
    public Double obtemFrete(@RequestParam String transportadora) {
        if (transportadora.equalsIgnoreCase("Jadlog")) {
            return 10.00;
        } else if (transportadora.equalsIgnoreCase("Camillo dos Santos")) {
            return 20.00;
        } else if (transportadora.equalsIgnoreCase("DHL Express")) {
            return 30.00;
        } else if (transportadora.equalsIgnoreCase("TNT Express")) {
            return 40.00;
        }

        throw new RuntimeException("Transportadora não encontrada.");
    }
}