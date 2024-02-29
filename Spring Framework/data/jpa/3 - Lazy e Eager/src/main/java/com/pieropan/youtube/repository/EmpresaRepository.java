package com.pieropan.youtube.repository;

import com.pieropan.youtube.domain.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    List<Empresa> findAll();
}