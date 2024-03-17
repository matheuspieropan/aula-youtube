package com.example.redis.service;

import com.example.redis.domain.Empresa;
import com.example.redis.repository.EmpresaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Cacheable("empresas")
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Setter
    @Getter
    public static class EmpresaDto {

        private Long id;

        private String razaoSocial;
    }
}