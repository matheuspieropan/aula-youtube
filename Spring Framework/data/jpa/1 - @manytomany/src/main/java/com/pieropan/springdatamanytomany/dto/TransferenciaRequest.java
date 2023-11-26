package com.pieropan.springdatamanytomany.dto;

import lombok.Data;

@Data
public class TransferenciaRequest {

    private Long origem;

    private Long destino;

    private Double saldo;
}