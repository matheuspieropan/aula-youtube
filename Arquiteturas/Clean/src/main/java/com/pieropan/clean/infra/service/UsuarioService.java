package com.pieropan.clean.infra.service;

import com.pieropan.clean.application.UsuarioUseCase;
import com.pieropan.clean.domain.Usuario;
import com.pieropan.clean.infra.dto.UsuarioRequest;
import com.pieropan.clean.infra.dto.UsuarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    private final Map<String, UsuarioUseCase> usuarioUseCaseMap;

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioService(Map<String, UsuarioUseCase> usuarioUseCaseMap, UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCaseMap = usuarioUseCaseMap;
        this.usuarioUseCase = usuarioUseCase;
    }

    public List<UsuarioResponse> findAll(String tipo) {
        return UsuarioResponse.toUsuarioResponseList(usuarioUseCaseMap.get(tipo).findAll());
    }

    public UsuarioResponse save(UsuarioRequest usuarioRequest){
        Usuario usuario = usuarioUseCase.save(UsuarioRequest.toUsuario(usuarioRequest));
        return UsuarioResponse.toUsuarioResponse(usuario);
    }
}