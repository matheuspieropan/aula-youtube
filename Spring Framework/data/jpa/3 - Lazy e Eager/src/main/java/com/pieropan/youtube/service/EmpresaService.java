package com.pieropan.youtube.service;

import com.pieropan.youtube.domain.Empresa;
import com.pieropan.youtube.repository.EmpresaRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

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