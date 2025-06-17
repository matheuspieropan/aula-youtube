package com.pieropan.hash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HashApplication {

    public static void main(String[] args) {
        SpringApplication.run(HashApplication.class, args);
    }
}