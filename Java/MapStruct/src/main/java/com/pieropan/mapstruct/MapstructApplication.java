package com.pieropan.mapstruct;

import com.pieropan.mapstruct.dto.UsuarioRequest;
import com.pieropan.mapstruct.dto.UsuarioResponse;
import com.pieropan.mapstruct.entity.UsuarioEntity;
import com.pieropan.mapstruct.mapper.UsuarioMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MapstructApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapstructApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UsuarioMapper usuarioMapper) {
        return args -> {
            UsuarioRequest usuarioRequest = UsuarioRequest.
                    builder().
                    nome("Matheus").
                    email("matheus@dev.com").
                    senha("123").
                    build();

            UsuarioEntity usuarioEntity = usuarioMapper.map(usuarioRequest);
            usuarioEntity.setId(1);
            usuarioEntity.setDataCriacao(LocalDateTime.now());

            UsuarioResponse usuarioResponse = usuarioMapper.map(usuarioEntity);
            System.out.println(usuarioResponse);
        };
    }
}