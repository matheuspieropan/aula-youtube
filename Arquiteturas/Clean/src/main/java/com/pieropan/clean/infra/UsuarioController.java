package com.pieropan.clean.infra;

import com.pieropan.clean.infra.dto.UsuarioResponse;
import com.pieropan.clean.infra.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    private ResponseEntity<List<UsuarioResponse>> findAll(@RequestParam("tipo") String tipo) {
        return ResponseEntity.ok(usuarioService.findAll(tipo));
    }
}