package com.pieropan.springdatamanytomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpj;

    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    @ManyToMany
    @JoinTable(
            name = "EMPRESA_FUNCIONARIO",
            joinColumns = @JoinColumn(name = "EMPRESA_ID"),
            inverseJoinColumns = @JoinColumn(name = "FUNCIONARIO_ID")
    )
    private List<Funcionario> funcionarios;
}