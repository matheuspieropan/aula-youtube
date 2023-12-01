package com.pieropan.dualconnection.primeirobanco.repository;

import com.pieropan.dualconnection.primeirobanco.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}