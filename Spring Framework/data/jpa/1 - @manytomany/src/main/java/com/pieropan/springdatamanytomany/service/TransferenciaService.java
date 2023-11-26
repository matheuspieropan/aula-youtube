package com.pieropan.springdatamanytomany.service;

import com.pieropan.springdatamanytomany.dto.TransferenciaRequest;
import com.pieropan.springdatamanytomany.entity.Conta;
import com.pieropan.springdatamanytomany.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    ContaRepository contaRepository;

    @Transactional
    public String transferir(TransferenciaRequest transferenciaRequest) {
        Optional<Conta> contaOrigem = contaRepository.findById(transferenciaRequest.getOrigem());
        Optional<Conta> contaDestino = contaRepository.findById(transferenciaRequest.getDestino());

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {

            removerSaldo(contaOrigem.get(), transferenciaRequest.getSaldo());
            adicionarSaldo(contaDestino.get(), transferenciaRequest.getSaldo());

            return "Transferência realizada com sucesso!";
        }
        throw new RuntimeException("Contas não encontradas!");
    }

    private void removerSaldo(Conta conta, Double valor) {
        conta.setSaldo(conta.getSaldo() - valor);
        contaRepository.save(conta);
    }

    private void adicionarSaldo(Conta conta, Double valor) {
        if(conta.getConta().equals("102030")){
            throw new RuntimeException("Conta com bloqueio judicial!");
        }
        conta.setSaldo(conta.getSaldo() + valor);
        contaRepository.save(conta);
    }
}