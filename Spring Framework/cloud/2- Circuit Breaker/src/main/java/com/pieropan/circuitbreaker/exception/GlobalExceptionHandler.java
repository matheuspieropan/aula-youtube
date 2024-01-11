package com.pieropan.circuitbreaker.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MicroServicoOffException.class})
    public ResponseEntity<MicroServicoOffDto> microServicoOffException(MicroServicoOffException ex) {
        MicroServicoOffDto microServicoOffDto = new MicroServicoOffDto(ex.getMessage(), INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(microServicoOffDto);
    }

    public record MicroServicoOffDto(String mensagem, int statusCode) {
    }
}