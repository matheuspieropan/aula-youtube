package com.pieropan.desafio.service.validacoes.impl;

import com.pieropan.desafio.dto.TransacaoRequest;
import com.pieropan.desafio.exception.FormularioInvalidadoException;
import com.pieropan.desafio.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidaCamposPreenchidosImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        if (request.valor() == null || request.dataHora() == null) {
            throw new FormularioInvalidadoException("Campo valor ou dataHora não foram preenchidos!");
        }
    }
}