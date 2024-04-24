package com.pieropan.integracao.repository;

import com.pieropan.integracao.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}