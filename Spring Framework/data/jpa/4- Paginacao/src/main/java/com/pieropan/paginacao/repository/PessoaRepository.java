package com.pieropan.paginacao.repository;

import com.pieropan.paginacao.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    Page<Pessoa> findAll(Pageable pageable);
}