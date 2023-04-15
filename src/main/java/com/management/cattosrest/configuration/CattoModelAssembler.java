package com.management.cattosrest.configuration;

import com.management.cattosrest.controller.CattoController;
import com.management.cattosrest.entity.Catto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CattoModelAssembler implements RepresentationModelAssembler<Catto, EntityModel<Catto>> {

    /**
     * toModel
     * Add ref link to obj Catto
     * @param catto
     * @return EntityModel<Catto>
     */
    @Override
    public EntityModel<Catto> toModel(Catto catto) {
        return EntityModel.of(catto,
                WebMvcLinkBuilder.linkTo(methodOn(CattoController.class).one(catto.getId())).withSelfRel(),
                linkTo(methodOn(CattoController.class).all()).withRel("all"));
    }

    /**
     * toCollectionModel
     * Add ref links to each obj Catto on the list and the list
     * @param list
     * @return CollectionModel<EntityModel<Catto>>
     */
    public CollectionModel<EntityModel<Catto>> toCollectionModel(List<Catto> list) {

        List<EntityModel<Catto>> cattos = list.stream()
                .map(catto -> EntityModel.of(catto,
                        linkTo(methodOn(CattoController.class).one(catto.getId())).withSelfRel(),
                        linkTo(methodOn(CattoController.class).all()).withRel("all"))
        ).collect(Collectors.toList());

        return CollectionModel.of(cattos, linkTo(methodOn(CattoController.class).all()).withSelfRel());
    }
}
