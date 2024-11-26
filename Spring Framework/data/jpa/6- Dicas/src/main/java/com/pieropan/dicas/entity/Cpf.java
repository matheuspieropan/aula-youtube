package com.pieropan.dicas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cpf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idi;

    private String numero;

    @OneToOne(mappedBy = "cpf")
    private Pessoa pessoa;
}