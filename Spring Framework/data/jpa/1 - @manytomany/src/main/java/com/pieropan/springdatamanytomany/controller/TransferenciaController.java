package com.pieropan.springdatamanytomany.controller;

import com.pieropan.springdatamanytomany.dto.TransferenciaRequest;
import com.pieropan.springdatamanytomany.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<String> transferir(@RequestBody TransferenciaRequest transferenciaRequest) {
        return ResponseEntity.ok(transferenciaService.transferir(transferenciaRequest));
    }
}