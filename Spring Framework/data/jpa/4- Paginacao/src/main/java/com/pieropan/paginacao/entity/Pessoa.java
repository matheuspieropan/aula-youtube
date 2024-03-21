package com.pieropan.paginacao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pessoa {

    @Id
    private Long id;

    private String nome;

    private int idade;
}