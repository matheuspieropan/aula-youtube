package com.pieropan.mapstruct.dto;

import com.pieropan.mapstruct.mapper.UsuarioMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioRequest {

    private String nome;

    private String email;

    private String senha;
}