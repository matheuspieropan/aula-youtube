package com.pieropan.circuitbreaker.controller;

import com.pieropan.circuitbreaker.service.ExemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit-breaker")
public class ExemploController {

    @Autowired
    private ExemploService exemploService;

    @GetMapping
    public ResponseEntity<String> exemplo() {
        return ResponseEntity.ok(exemploService.exemplo());
    }
}