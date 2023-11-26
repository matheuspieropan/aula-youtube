package com.pieropan.springdatamanytomany.repository;

import com.pieropan.springdatamanytomany.entity.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta,Long> {
}