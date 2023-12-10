package com.pieropan.youtube.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Regiao {

    private int id;

    private String sigla;

    private String nome;
}