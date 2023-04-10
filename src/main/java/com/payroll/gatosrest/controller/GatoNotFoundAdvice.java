package com.payroll.gatosrest.controller;

import com.payroll.gatosrest.configuration.GatoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GatoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(GatoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String gatoNotFoundHandler(GatoNotFoundException ex) {
        return ex.getMessage();
    }
}
