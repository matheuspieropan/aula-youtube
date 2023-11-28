package com.pieropan.springcloudopenfeign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estado {

    private int id;

    private String sigla;

    private String nome;
}