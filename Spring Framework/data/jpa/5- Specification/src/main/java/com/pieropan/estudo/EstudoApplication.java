package com.pieropan.estudo;

import com.pieropan.estudo.entity.Usuario;
import com.pieropan.estudo.enums.StatusEnum;
import com.pieropan.estudo.repository.UsuarioRepository;
import com.pieropan.estudo.repository.UsuarioSpec;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class EstudoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UsuarioRepository repository) {
        return args -> {
            popularDB(repository);
            UsuarioFilter filter = UsuarioFilter.builder().nome("Matheus").build();
            repository.findAll(UsuarioSpec.porFiltros(filter)).forEach(System.out::println);
        };
    }

    private void popularDB(UsuarioRepository repository) {
        List<Usuario> usuarios = repository.findAll();

        if (Objects.isNull(usuarios) || usuarios.isEmpty()) {
            Usuario matheus = Usuario.builder()
                    .nome("Matheus")
                    .idade(27)
                    .dataNascimento(LocalDate.of(1997, 11, 12))
                    .status(StatusEnum.ATIVO).build();

            Usuario marcos = Usuario.builder()
                    .nome("Marcos")
                    .idade(33)
                    .dataNascimento(LocalDate.of(1991, 7, 23))
                    .status(StatusEnum.ATIVO).build();

            Usuario lucas = Usuario.builder()
                    .nome("Lucas")
                    .idade(17)
                    .dataNascimento(LocalDate.of(2007, 3, 2))
                    .status(StatusEnum.DESATIVADO).build();

            Usuario joao = Usuario.builder()
                    .nome("João")
                    .idade(54)
                    .dataNascimento(LocalDate.of(1970, 5, 27))
                    .status(StatusEnum.EXCLUIDO).build();

            repository.saveAll(Arrays.asList(matheus, marcos, lucas, joao));
        }
    }
}