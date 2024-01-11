package com.pieropan.circuitbreaker.controller;

import com.pieropan.circuitbreaker.domain.Produto;
import com.pieropan.circuitbreaker.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Produto> obterProduto() {
        return ResponseEntity.ok(produtoService.obterProduto());
    }
}