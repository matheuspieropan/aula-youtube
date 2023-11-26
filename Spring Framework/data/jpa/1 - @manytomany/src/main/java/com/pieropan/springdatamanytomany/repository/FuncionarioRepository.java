package com.pieropan.springdatamanytomany.repository;

import com.pieropan.springdatamanytomany.entity.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}