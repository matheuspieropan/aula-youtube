package com.pieropan.desafio.service.validacoes.impl;

import com.pieropan.desafio.dto.TransacaoRequest;
import com.pieropan.desafio.exception.ValorNegativoException;
import com.pieropan.desafio.service.validacoes.Validacao;
import org.springframework.stereotype.Component;

@Component
public class ValidaValorNegativoImpl implements Validacao {

    @Override
    public void validar(TransacaoRequest request) {
        boolean ehNumeroNegativo = request.valor() < 0;

        if (ehNumeroNegativo) {
            throw new ValorNegativoException("Não é permitido valor negativo!");
        }
    }
}