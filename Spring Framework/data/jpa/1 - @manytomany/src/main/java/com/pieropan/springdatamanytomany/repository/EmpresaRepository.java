package com.pieropan.springdatamanytomany.repository;

import com.pieropan.springdatamanytomany.entity.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    @Query("SELECT e FROM Empresa e JOIN FETCH e.funcionarios ")
    List<Empresa> listarEmpresasComFuncionarios();
}