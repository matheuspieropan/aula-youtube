package com.pieropan.github;

import com.pieropan.github.client.GitHubClient;
import com.pieropan.github.domain.Repositorio;
import com.pieropan.github.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class GithubApplication {

    @Autowired
    private GitHubClient gitHubClient;

    public static void main(String[] args) {
        SpringApplication.run(GithubApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            String username = "matheuspieropan";
            Usuario usuario = gitHubClient.obterUsuario(username);
            System.out.println(usuario);

            List<Repositorio> repositorios = gitHubClient.obterRepositorios(username);
            System.out.println(repositorios);
        };
    }
}