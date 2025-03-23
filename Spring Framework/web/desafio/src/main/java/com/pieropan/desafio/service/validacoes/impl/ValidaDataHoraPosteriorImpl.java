package com.pieropan.desafio.service.validacoes.impl;

import com.pieropan.desafio.dto.TransacaoRequest;
import com.pieropan.desafio.exception.DataHoraFuturoException;
import com.pieropan.desafio.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ValidaDataHoraPosteriorImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        boolean ehDepois = request.dataHora().isAfter(OffsetDateTime.now());

        if (ehDepois) {
            throw new DataHoraFuturoException("Valor do campo dataHora está no futuro!");
        }
    }
}