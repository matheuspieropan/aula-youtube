package com.pieropan.spring.service;

import org.springframework.stereotype.Service;

@Service("camilo_dos_santos")
public class CamiloDosSantosTransportadoraImpl implements Transportadora{

    @Override
    public double calcularFrete() {
        return 20;
    }
}