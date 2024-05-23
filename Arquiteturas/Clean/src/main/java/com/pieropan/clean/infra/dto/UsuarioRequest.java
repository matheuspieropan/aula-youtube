package com.pieropan.clean.infra.dto;

import com.pieropan.clean.domain.Usuario;

public record UsuarioRequest(String nome, String email, String senha) {

    public static Usuario toUsuario(UsuarioRequest usuarioRequest) {
        return new Usuario(null, usuarioRequest.nome, usuarioRequest.email, usuarioRequest.senha);
    }
}