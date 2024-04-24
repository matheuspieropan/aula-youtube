package com.pieropan.integracao.controller;

import com.pieropan.integracao.dto.UsuarioRequest;
import com.pieropan.integracao.dto.UsuarioResponse;
import com.pieropan.integracao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> salvar(@RequestBody UsuarioRequest usuario) {
        UsuarioResponse response = usuarioService.salvar(usuario);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(response.id())
                        .toUri())
                .body(response);
    }
}