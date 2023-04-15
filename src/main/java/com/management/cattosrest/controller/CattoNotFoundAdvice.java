package com.management.cattosrest.controller;

import com.management.cattosrest.configuration.CattoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CattoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CattoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String gatoNotFoundHandler(CattoNotFoundException ex) {
        return ex.getMessage();
    }
}
