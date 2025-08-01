package com.metaphorce.cinemagic.exceptions;

import org.springframework.validation.BindingResult;

public class DatosNoValidosException extends RuntimeException{

    BindingResult bindingResult;

    public DatosNoValidosException(String mensaje, BindingResult bindingResult) {
        super(mensaje);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
