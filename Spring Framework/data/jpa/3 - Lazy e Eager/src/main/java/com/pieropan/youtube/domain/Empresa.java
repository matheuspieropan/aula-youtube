package com.pieropan.youtube.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Empresa {

    @Id
    private Long id;

    private String razaoSocial;

    private String cnpj;

    @JsonIgnore
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EMPRESA_FUNCIONARIO",
            joinColumns = @JoinColumn(name = "EMPRESA_ID"),
            inverseJoinColumns = @JoinColumn(name = "FUNCIONARIO_ID"))
    private List<Funcionario> funcionarios;
}