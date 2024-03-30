package com.pieropan.paginacao.service;

import com.pieropan.paginacao.entity.Pessoa;
import com.pieropan.paginacao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Page<Pessoa> findAll(int pagina, int itens) {
        return pessoaRepository.findAll(PageRequest.of(pagina, itens));
    }
}