package com.payroll.gatosrest.controller;

import com.payroll.gatosrest.configuration.GatoNotFoundException;
import com.payroll.gatosrest.entity.Gato;
import com.payroll.gatosrest.repository.GatosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gatos")
public class GatoController
{
    private final GatosRepository repository;

    public GatoController(GatosRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Gato> all() {
        return repository.findAll();
    }

    @PostMapping("/new")
    public Gato newGato(@RequestBody Gato newGato) {
        return repository.save(newGato);
    }

    @GetMapping("/one/{id}")
    public Gato one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new GatoNotFoundException(id));
    }

    @PutMapping("/edit/{id}")
    public Gato replaceGato(@RequestBody Gato newGato, @PathVariable Long id) {

        return repository.findById(id).map(gato -> {
            gato.setName(newGato.getName());
            gato.setFluffy(newGato.getFluffy());
            return repository.save(gato);
        }).orElseGet(() -> {
            newGato.setId(id);
            return repository.save(newGato);
        });
    }

    @DeleteMapping("/delete/{id}")
    void deleteGato(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
