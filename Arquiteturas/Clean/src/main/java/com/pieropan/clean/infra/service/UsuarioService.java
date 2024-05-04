package com.pieropan.clean.infra.service;

import com.pieropan.clean.application.UsuarioUseCase;
import com.pieropan.clean.infra.dto.UsuarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    private final Map<String, UsuarioUseCase> usuarioUseCaseMap;

    public UsuarioService(Map<String, UsuarioUseCase> usuarioUseCaseMap) {
        this.usuarioUseCaseMap = usuarioUseCaseMap;
    }

    public List<UsuarioResponse> findAll(String tipo) {
        return UsuarioResponse.UsuarioResponse(usuarioUseCaseMap.get(tipo).findAll());
    }
}