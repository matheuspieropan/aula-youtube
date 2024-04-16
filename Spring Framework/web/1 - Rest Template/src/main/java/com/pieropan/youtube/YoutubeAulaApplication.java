package com.pieropan.youtube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class YoutubeAulaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutubeAulaApplication.class, args);
    }
}