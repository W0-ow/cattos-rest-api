package com.management.cattosrest.controller;

import com.management.cattosrest.configuration.CattoNotFoundException;
import com.management.cattosrest.configuration.CattoModelAssembler;
import com.management.cattosrest.entity.Catto;
import com.management.cattosrest.repository.CattoRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CattoController {
    private final CattoRepository repository;
    private final CattoModelAssembler assembler;

    public CattoController(CattoRepository repository, CattoModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/all")
    public CollectionModel<EntityModel<Catto>> all() {

        List<Catto> cattos = repository.findAll();

        return assembler.toCollectionModel(cattos);
    }

    @PostMapping("/new")
    public ResponseEntity<EntityModel<Catto>> newCatto(@RequestBody Catto newCatto) {

        EntityModel<Catto> entityModel = assembler.toModel(repository.save(newCatto));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/one/{id}")
    public EntityModel<Catto> one(@PathVariable Long id) {

        Catto catto = repository.findById(id).orElseThrow(() -> new CattoNotFoundException(id));

        return assembler.toModel(catto);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<EntityModel<Catto>> replaceCatto(@RequestBody Catto newCatto, @PathVariable Long id) {

        Catto catto = repository.findById(id).map(item -> {
            item.setName(newCatto.getName());
            item.setFluffy(newCatto.getFluffy());
            return repository.save(item);
        }).orElseGet(() -> {
            newCatto.setId(id);
            return repository.save(newCatto);
        });

        EntityModel<Catto> entityModel = assembler.toModel(catto);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EntityModel<Catto>> deleteCatto(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
