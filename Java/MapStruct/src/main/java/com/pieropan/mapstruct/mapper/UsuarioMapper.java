package com.pieropan.mapstruct.mapper;

import com.pieropan.mapstruct.dto.UsuarioRequest;
import com.pieropan.mapstruct.dto.UsuarioResponse;
import com.pieropan.mapstruct.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    UsuarioEntity map(UsuarioRequest usuarioRequest);

    @Mapping(target = "name", source = "nome")
    UsuarioResponse map(UsuarioEntity usuarioEntity);
}