package com.pieropan.dicas.repository;

import com.pieropan.dicas.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u join fetch u.enderecos WHERE u.id = :id")
    Optional<Usuario> usuarioComEnderecos(Long id);
}