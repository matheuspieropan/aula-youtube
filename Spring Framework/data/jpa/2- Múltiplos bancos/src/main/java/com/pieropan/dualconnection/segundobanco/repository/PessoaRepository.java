package com.pieropan.dualconnection.segundobanco.repository;

import com.pieropan.dualconnection.segundobanco.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}