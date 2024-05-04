package com.pieropan.clean.infra.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UsuarioEntity {

    @Id
    private Long id;

    private String nome;

    private String email;

    private String senha;
}