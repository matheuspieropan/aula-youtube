package com.pieropan.integracao.service;

import com.pieropan.integracao.dto.UsuarioRequest;
import com.pieropan.integracao.dto.UsuarioResponse;
import com.pieropan.integracao.entity.Usuario;
import com.pieropan.integracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> buscarTodos() {
        return UsuarioResponse.toUsuarioResponse((List<Usuario>) usuarioRepository.findAll());
    }

    public UsuarioResponse salvar(UsuarioRequest usuario){
        Usuario entity = usuarioRepository.save(UsuarioRequest.toUsuario(usuario));
        return UsuarioRequest.toUsuarioRequest(entity);
    }
}