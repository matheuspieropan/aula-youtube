package com.example.redis.repository;

import com.example.redis.domain.Empresa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    List<Empresa> findAll();
}