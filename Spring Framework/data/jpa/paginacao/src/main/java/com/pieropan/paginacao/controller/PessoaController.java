package com.pieropan.paginacao.controller;

import com.pieropan.paginacao.entity.Pessoa;
import com.pieropan.paginacao.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(@RequestParam int pagina,
                                                @RequestParam int itens) {
        return ResponseEntity.ok(pessoaService.findAll(pagina, itens));
    }
}