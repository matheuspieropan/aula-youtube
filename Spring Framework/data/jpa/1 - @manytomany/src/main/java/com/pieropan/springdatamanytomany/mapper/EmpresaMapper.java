package com.pieropan.springdatamanytomany.mapper;

import com.pieropan.springdatamanytomany.dto.EmpresaComFuncionarioResponse;
import com.pieropan.springdatamanytomany.dto.EmpresaResponse;
import com.pieropan.springdatamanytomany.entity.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmpresaMapper {

    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    List<EmpresaResponse> listEmpresaResponse(List<Empresa> empresas);

    List<EmpresaComFuncionarioResponse> listEmpresaComFuncionarioResponse(List<Empresa> empresas);
}