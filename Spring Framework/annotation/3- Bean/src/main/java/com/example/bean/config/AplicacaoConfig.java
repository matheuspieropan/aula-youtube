package com.example.bean.config;

import com.example.bean.domain.Carro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AplicacaoConfig {

    @Bean
    @Primary
    public Carro onix() {
        Carro carro = new Carro();
        carro.setAno(2024);
        carro.setCor("Preto");
        carro.setModelo("Onix");

        return carro;
    }

    @Bean("gol")
    public Carro gol() {
        Carro carro = new Carro();
        carro.setAno(2023);
        carro.setCor("Branco");
        carro.setModelo("Gol");

        return carro;
    }
}