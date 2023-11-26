package com.pieropan.springdatamanytomany.service;

import com.pieropan.springdatamanytomany.dto.EmpresaComFuncionarioResponse;
import com.pieropan.springdatamanytomany.dto.EmpresaResponse;
import com.pieropan.springdatamanytomany.entity.Empresa;
import com.pieropan.springdatamanytomany.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pieropan.springdatamanytomany.mapper.EmpresaMapper.INSTANCE;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaComFuncionarioResponse> listarEmpresasComFuncionarios() {
        return INSTANCE.listEmpresaComFuncionarioResponse(empresaRepository.listarEmpresasComFuncionarios());
    }

    public List<EmpresaResponse> listarTodos() {
        return INSTANCE.listEmpresaResponse((List<Empresa>) empresaRepository.findAll());
    }
}