package com.pieropan.springdatamanytomany.dto;

import com.pieropan.springdatamanytomany.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class EmpresaComFuncionarioResponse extends EmpresaResponse {

    private List<Funcionario> funcionarios;
}