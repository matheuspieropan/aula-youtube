package com.pieropan.springdatamanytomany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaResponse {

    private Long id;

    private String nome;

    private String cnpj;
}