package com.pieropan.springdatamanytomany.config;

import com.pieropan.springdatamanytomany.entity.Empresa;
import com.pieropan.springdatamanytomany.entity.Funcionario;
import com.pieropan.springdatamanytomany.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class StarterConfig {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Bean
    public void start() {
        Iterable<Empresa> empresas = empresaRepository.findAll();

        if (!empresas.iterator().hasNext()) {
            empresaRepository.save(criarEmpresa());
        }
    }

    private Funcionario criarFuncionario() {
        return Funcionario.builder()
                .cpf("001.112.223-32")
                .nome("Matheus")
                .build();
    }

    private Empresa criarEmpresa() {
        return Empresa.builder()
                .nome("SPAL INDUSTRIA BRASILEIRA DE BEBIDAS S/A - COCA COLA FEMSA")
                .cnpj("61.186.888/0093-01")
                .funcionarios(Collections.singletonList(criarFuncionario()))
                .build();
    }
}