package com.pieropan.youtube;

import com.pieropan.youtube.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class YoutubeAulaApplication implements CommandLineRunner {

    @Autowired
    private EstadoService estadoService;

    public static void main(String[] args) {
        SpringApplication.run(YoutubeAulaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        estadoService.obterEstados().forEach(System.out::println);
    }
}