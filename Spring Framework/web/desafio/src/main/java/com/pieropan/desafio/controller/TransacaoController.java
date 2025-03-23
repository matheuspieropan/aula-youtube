package com.pieropan.desafio.controller;

import com.pieropan.desafio.dto.TransacaoRequest;
import com.pieropan.desafio.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transacao")
@RestController
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody TransacaoRequest request) {
        service.salvar(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletar() {
        service.deletar();
    }
}