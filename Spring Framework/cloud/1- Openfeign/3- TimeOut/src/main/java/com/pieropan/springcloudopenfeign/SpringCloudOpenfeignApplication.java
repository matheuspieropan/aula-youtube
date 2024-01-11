package com.pieropan.springcloudopenfeign;

import com.pieropan.springcloudopenfeign.client.ExemploClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudOpenfeignApplication implements CommandLineRunner {

    @Autowired
    private ExemploClient exemploClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOpenfeignApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String exemplo = exemploClient.exemplo();
        System.out.println(exemplo);
    }
}