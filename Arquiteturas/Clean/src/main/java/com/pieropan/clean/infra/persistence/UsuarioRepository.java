package com.pieropan.clean.infra.persistence;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
}