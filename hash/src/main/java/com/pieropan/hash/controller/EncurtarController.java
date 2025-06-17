package com.pieropan.hash.controller;

import com.pieropan.hash.controller.dto.EncurtarRequestDTO;
import com.pieropan.hash.service.EncurtarService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@EnableCaching
@RequiredArgsConstructor
@RestController
public class EncurtarController {

    private final EncurtarService service;

    @PostMapping
    public ResponseEntity<String> encurtar(@RequestBody EncurtarRequestDTO encurtarRequestDTO) {
        var response = service.encurtar(encurtarRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<Void> redirecionar(@PathVariable String hash) {
        String urlLonga = service.obterUrlLonga(hash);

        URI destino = URI.create(urlLonga);
        return ResponseEntity.status(HttpStatus.FOUND).location(destino).build();
    }
}