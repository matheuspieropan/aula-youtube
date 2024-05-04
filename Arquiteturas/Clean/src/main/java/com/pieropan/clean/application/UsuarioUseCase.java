package com.pieropan.clean.application;

import com.pieropan.clean.domain.Usuario;
import com.pieropan.clean.gateway.UsuarioRepositoryGateway;

import java.util.List;

public class UsuarioUseCase {

    private final UsuarioRepositoryGateway usuarioGateway;

    public UsuarioUseCase(UsuarioRepositoryGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public List<Usuario> findAll() {
        return usuarioGateway.findAll();
    }
}