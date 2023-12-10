package com.pieropan.exceptionhandler.exception;

public class NaoExistemUsuarios extends RuntimeException {

    public NaoExistemUsuarios(String message) {
        super(message);
    }
}