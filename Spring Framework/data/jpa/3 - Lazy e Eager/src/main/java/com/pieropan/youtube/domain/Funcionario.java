package com.pieropan.youtube.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Funcionario {

    @Id
    private Long id;

    private String nome;

    private String cpf;

    @JsonBackReference
    @ManyToMany(mappedBy = "funcionarios")
    private List<Empresa> empresas;
}