package com.pieropan.exceptionhandler.service;

import com.pieropan.exceptionhandler.domain.Usuario;
import com.pieropan.exceptionhandler.exception.NaoExistemUsuarios;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = buscarUsuarios();

        if (usuarios.isEmpty()) {
            throw new NaoExistemUsuarios("Um erro inesperado aconteceu!!!");
        }

        return usuarios;
    }

    private List<Usuario> buscarUsuarios() {
        

        return new ArrayList<>();
    }
}