package com.pieropan.clean.infra.dto;

import com.pieropan.clean.domain.Usuario;

import java.util.List;

public record UsuarioResponse(Long id, String nome, String email) {

    public static List<UsuarioResponse> toUsuarioResponseList(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioResponse::toUsuarioResponse).toList();
    }

    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(usuario.id(), usuario.nome(), usuario.email());
    }
}