package com.pieropan.exceptionhandler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NaoExistemUsuarios.class)
    public ResponseEntity<ErroResponse> naoExistemUsuarios(NaoExistemUsuarios ex) {
        ErroResponse erroResponse = new ErroResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(erroResponse);
    }
}