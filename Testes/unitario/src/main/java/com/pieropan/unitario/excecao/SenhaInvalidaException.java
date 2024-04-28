package com.pieropan.unitario.excecao;

public class SenhaInvalidaException extends RuntimeException {

    public SenhaInvalidaException(String message) {
        super(message);
    }
}