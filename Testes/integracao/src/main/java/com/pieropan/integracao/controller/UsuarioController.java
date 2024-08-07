package com.pieropan.integracao.controller;

import com.pieropan.integracao.entity.Usuario;
import com.pieropan.integracao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }
}