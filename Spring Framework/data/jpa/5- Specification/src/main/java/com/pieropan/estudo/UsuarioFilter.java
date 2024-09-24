package com.pieropan.estudo;

import com.pieropan.estudo.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UsuarioFilter {

    private String nome;

    private StatusEnum status;

    private LocalDate dataNascimento;
}