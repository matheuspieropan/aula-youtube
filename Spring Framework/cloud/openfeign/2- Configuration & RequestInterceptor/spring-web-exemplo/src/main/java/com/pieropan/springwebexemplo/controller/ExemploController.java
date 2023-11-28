package com.pieropan.springwebexemplo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exemplo")
public class ExemploController {

    @GetMapping
    public String exemplo() {
        return "Deu tudo certo!!!";
    }
}