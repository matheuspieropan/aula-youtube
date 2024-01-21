package com.pieropan.springwebexemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServicoPrecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicoPrecoApplication.class, args);
	}
}