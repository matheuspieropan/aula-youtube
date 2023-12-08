package com.pieropan.youtube;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAulaApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("objectMapperCanada")
    public ObjectMapper objectMapperCanada;

    @Autowired
    public ObjectMapper objectMapperFrance;

    public static void main(String[] args) {
        SpringApplication.run(SpringAulaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(objectMapperCanada.getDeserializationConfig().getLocale().getCountry());
        System.out.println(objectMapperFrance.getDeserializationConfig().getLocale().getCountry());
    }
}