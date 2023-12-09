package com.pieropan.s3;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class S3Application {

    public static void main(String[] args) {
        SpringApplication.run(S3Application.class, args);
    }
}