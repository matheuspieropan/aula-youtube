package com.example.bean;

import com.example.bean.domain.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanApplication {

    private Carro carro;

    public BeanApplication(@Qualifier("gol") Carro carro) {
        this.carro = carro;
    }

    public static void main(String[] args) {
        SpringApplication.run(BeanApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println(carro);
    }
}