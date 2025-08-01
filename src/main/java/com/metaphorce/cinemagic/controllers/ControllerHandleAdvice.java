package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.exceptions.DatosNoValidosException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandleAdvice {

    @ExceptionHandler(DatosNoValidosException.class)
    public ResponseEntity<?> validacionEntradaDatos(DatosNoValidosException datosNoValidosException){
        Map<String, String> errores =new HashMap<>();
        datosNoValidosException.getBindingResult().getFieldErrors().forEach(fieldError -> errores.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errores);
    }
}
