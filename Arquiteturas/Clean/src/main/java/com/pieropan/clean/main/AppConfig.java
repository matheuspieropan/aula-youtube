package com.pieropan.clean.main;

import com.pieropan.clean.application.UsuarioUseCase;
import com.pieropan.clean.infra.persistence.jpa.UsuarioRepositoryJpaGateway;
import com.pieropan.clean.infra.persistence.txt.UsuarioRepositoryTxtGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public UsuarioUseCase usuarioUseCaseComTxt(UsuarioRepositoryTxtGateway usuarioRepositoryTxtGateway) {
        return new UsuarioUseCase(usuarioRepositoryTxtGateway);
    }

    @Bean
    public UsuarioUseCase usuarioUseCaseComJpa(UsuarioRepositoryJpaGateway usuarioGateway) {
        return new UsuarioUseCase(usuarioGateway);
    }
}