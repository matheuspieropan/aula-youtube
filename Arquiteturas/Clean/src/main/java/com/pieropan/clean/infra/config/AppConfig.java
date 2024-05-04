package com.pieropan.clean.infra.config;

import com.pieropan.clean.application.UsuarioUseCase;
import com.pieropan.clean.infra.persistence.UsuarioGatewayImpl;
import com.pieropan.clean.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UsuarioUseCase usuarioUseCase(UsuarioGatewayImpl usuarioGateway){
        return new UsuarioUseCase(usuarioGateway);
    }

    @Bean
    public UsuarioGatewayImpl usuarioGateway(UsuarioRepository usuarioRepository){
        return new UsuarioGatewayImpl(usuarioRepository);
    }
}