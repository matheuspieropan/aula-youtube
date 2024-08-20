package com.pieropan.mapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    private int id;

    private String nome;

    private String email;

    private String senha;

    private LocalDateTime dataCriacao;
}