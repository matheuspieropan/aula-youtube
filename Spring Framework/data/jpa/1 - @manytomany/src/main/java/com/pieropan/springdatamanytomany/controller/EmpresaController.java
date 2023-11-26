package com.pieropan.springdatamanytomany.controller;

import com.pieropan.springdatamanytomany.dto.EmpresaComFuncionarioResponse;
import com.pieropan.springdatamanytomany.dto.EmpresaResponse;
import com.pieropan.springdatamanytomany.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/com-funcionarios")
    public ResponseEntity<List<EmpresaComFuncionarioResponse>> listarEmpresasComFuncionarios() {
        return ResponseEntity.ok(empresaService.listarEmpresasComFuncionarios());
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> listarTodos() {
        return ResponseEntity.ok(empresaService.listarTodos());
    }
}