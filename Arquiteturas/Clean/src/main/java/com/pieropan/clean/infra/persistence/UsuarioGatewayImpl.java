package com.pieropan.clean.infra.persistence;

import com.pieropan.clean.domain.Usuario;
import com.pieropan.clean.gateway.UsuarioGateway;

import java.util.List;

public class UsuarioGatewayImpl implements UsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    public UsuarioGatewayImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        return Usuario.toUsuario((List<UsuarioEntity>) usuarioRepository.findAll());
    }
}