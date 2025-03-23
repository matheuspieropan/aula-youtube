package com.pieropan.desafio.service.validacoes;

import com.pieropan.desafio.dto.TransacaoRequest;

public interface Validacao {

    void validar(TransacaoRequest request);
}