package com.pieropan.springwebexemplo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    @GetMapping
    public List<Double> exemplo() {
        return List.of(Double.valueOf("10.0"), Double.valueOf("20.0"));
    }
}