package com.example.redis.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Empresa implements Serializable {

    @Id
    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;
}