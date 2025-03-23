package com.pieropan.desafio.service;

import com.pieropan.desafio.domain.Transacao;
import com.pieropan.desafio.dto.TransacaoRequest;
import com.pieropan.desafio.service.validacoes.Validacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    private final List<Validacao> validacoes;

    public TransacaoService(List<Validacao> validacoes) {
        this.validacoes = validacoes;
    }

    public void salvar(TransacaoRequest request) {
        validacoes.forEach(v -> v.validar(request));
        transacoes.add(new Transacao(request.valor(), request.dataHora()));
    }

    public void deletar() {
        transacoes.clear();
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}