package com.pieropan.circuitbreaker.exception;

public class MicroServicoOffException extends RuntimeException {

    public MicroServicoOffException(String message) {
        super(message);
    }
}