package com.pieropan.spring.service;

import org.springframework.stereotype.Service;

@Service("jad_log")
public class JadLogTransportadoraImpl implements Transportadora{

    @Override
    public double calcularFrete() {
        return 10;
    }
}