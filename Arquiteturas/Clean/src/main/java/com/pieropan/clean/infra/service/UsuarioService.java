package com.pieropan.clean.infra.service;

import com.pieropan.clean.application.UsuarioUseCase;
import com.pieropan.clean.infra.dto.UsuarioResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioService(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    public List<UsuarioResponse> findAll() {
        return UsuarioResponse.UsuarioResponse(usuarioUseCase.findAll());
    }
}