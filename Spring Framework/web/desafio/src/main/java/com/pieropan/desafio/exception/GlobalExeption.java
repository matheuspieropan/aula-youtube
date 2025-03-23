package com.pieropan.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeption {

    @ExceptionHandler(FormularioInvalidadoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void formularioInvalidadoException(FormularioInvalidadoException ex) {
        System.out.println(ex);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public void httpMessageNotReadableException() {
    }

    @ExceptionHandler(ValorNegativoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public String valorNegativoException(ValorNegativoException ex) {
        return ex.getMessage();
    } // apenas um exemplo de como poderia retornar algo no body. Porém no desafio o certo é um void mesmo
}