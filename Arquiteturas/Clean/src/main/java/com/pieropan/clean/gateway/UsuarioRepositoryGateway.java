package com.pieropan.clean.gateway;

import com.pieropan.clean.domain.Usuario;

import java.util.List;

public interface UsuarioRepositoryGateway {

    List<Usuario> findAll();
}