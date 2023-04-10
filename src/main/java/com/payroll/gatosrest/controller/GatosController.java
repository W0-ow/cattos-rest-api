package com.payroll.gatosrest.controller;

import com.payroll.gatosrest.entity.Gato;
import com.payroll.gatosrest.repository.GatosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GatosController
{
    private final GatosRepository repository;

    public GatosController(GatosRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/gatos")
    List<Gato> all() {
        return repository.findAll();
    }
}
