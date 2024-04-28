package com.pieropan.unitario.repository;

import com.pieropan.unitario.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}