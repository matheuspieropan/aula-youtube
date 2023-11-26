package com.pieropan.springcloudopenfeign;

import com.pieropan.springcloudopenfeign.client.IbgeClient;
import com.pieropan.springcloudopenfeign.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudOpenfeignApplication implements CommandLineRunner {

    @Autowired
    IbgeClient ibgeClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOpenfeignApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Estado> estados = ibgeClient.obterEstados();
        System.out.println(estados);
    }
}