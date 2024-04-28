package com.pieropan.unitario.dto;

import com.pieropan.unitario.entity.Usuario;

import java.util.List;

public record UsuarioResponse(Long id, String nome, String email) {

    public static List<UsuarioResponse> toUsuarioResponse(List<Usuario> usuarios) {
        return usuarios.stream().map(u -> new UsuarioResponse(u.getId(), u.getNome(), u.getEmail())).toList();
    }
}