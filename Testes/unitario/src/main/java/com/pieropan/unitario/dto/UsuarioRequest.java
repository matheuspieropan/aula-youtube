package com.pieropan.unitario.dto;

import com.pieropan.unitario.entity.Usuario;

public record UsuarioRequest(String nome, String email, String senha, int idade) {

    public static Usuario toUsuario(UsuarioRequest usuario) {
        return new Usuario(null, usuario.nome, usuario.email, usuario.senha, usuario.idade);
    }

    public static UsuarioResponse toUsuarioRequest(Usuario usuario) {
        return new UsuarioResponse(null, usuario.getNome(), usuario.getEmail());
    }
}