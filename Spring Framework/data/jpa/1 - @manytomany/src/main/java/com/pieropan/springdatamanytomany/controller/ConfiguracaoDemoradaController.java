package com.pieropan.springdatamanytomany.controller;

import com.pieropan.springdatamanytomany.config.ConfiguracaoDemoradaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demorada")
public class ConfiguracaoDemoradaController {

    @Autowired
    @Lazy
    ConfiguracaoDemoradaConfig.ConfiguracaoDemorada configuracaoDemorada;

    @GetMapping
    public String demorarada() {
        return "Bean: " + configuracaoDemorada;
    }
}