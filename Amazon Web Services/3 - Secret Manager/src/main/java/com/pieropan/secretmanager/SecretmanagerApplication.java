package com.pieropan.secretmanager;

import com.pieropan.secretmanager.entity.Pessoa;
import com.pieropan.secretmanager.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class SecretmanagerApplication implements CommandLineRunner {

    private final PessoaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SecretmanagerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        repository.save(new Pessoa(null, "Pedro", 30));
    }
}