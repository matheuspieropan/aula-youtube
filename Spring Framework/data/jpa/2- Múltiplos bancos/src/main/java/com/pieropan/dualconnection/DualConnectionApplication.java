package com.pieropan.dualconnection;

import com.pieropan.dualconnection.primeirobanco.entity.Usuario;
import com.pieropan.dualconnection.primeirobanco.repository.UsuarioRepository;
import com.pieropan.dualconnection.segundobanco.entity.Pessoa;
import com.pieropan.dualconnection.segundobanco.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DualConnectionApplication implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public static void main(String[] args) {
        SpringApplication.run(DualConnectionApplication.class, args);
    }

    @Override
    public void run(String... args) {
        usuarioRepository.save(new Usuario());
        pessoaRepository.save(new Pessoa());
    }
}