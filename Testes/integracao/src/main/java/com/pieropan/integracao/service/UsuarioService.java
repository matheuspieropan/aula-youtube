package com.pieropan.integracao.service;

import com.pieropan.integracao.entity.Usuario;
import com.pieropan.integracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
}