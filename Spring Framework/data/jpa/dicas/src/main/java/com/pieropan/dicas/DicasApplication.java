package com.pieropan.dicas;

import com.pieropan.dicas.entity.Endereco;
import com.pieropan.dicas.entity.Usuario;
import com.pieropan.dicas.repository.EnderecoRepository;
import com.pieropan.dicas.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
public class DicasApplication {

    public static void main(String[] args) {
        SpringApplication.run(DicasApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UsuarioRepository repository,
                                               EnderecoRepository enderecoRepository) {
        return args -> {
            Usuario usuario = new Usuario();
            usuario.setNome("Matheussss");
            usuario.setEmail("matheus@dev.com.br");

            Endereco endereco = new Endereco();
            endereco.setLogradouro("Rua dos desenvolvedores");
            endereco.setBairro("Bairro JAVA");
            endereco.setNumero(101);
            endereco.setUsuario(usuario);

            usuario.setEnderecos(Collections.singletonList(endereco));
            repository.save(usuario);

            Optional<Usuario> usuarioRecuperado = repository.findById(usuario.getId());
            usuarioRecuperado.ifPresent(u -> System.out.printf("%s encontrado! Logradouro %s", u.getNome(), u.getEnderecos().get(0).getLogradouro()));
            Optional<Endereco> enderecoRecuperado = enderecoRepository.findById(endereco.getId());
            enderecoRecuperado.ifPresent(e -> System.out.printf("%s, %s", e.getLogradouro(), e.getUsuario().getNome()));
        };
    }
}