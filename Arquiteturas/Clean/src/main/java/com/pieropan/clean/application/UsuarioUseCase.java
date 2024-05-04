package com.pieropan.clean.application;

import com.pieropan.clean.domain.Usuario;
import com.pieropan.clean.gateway.UsuarioGateway;

import java.util.List;

public class UsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public UsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public List<Usuario> findAll() {
        return usuarioGateway.findAll();
    }
}