package com.wisercat.testassigment.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.wisercat.testassigment.domain.models.Filter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class FilterModelAssembler implements RepresentationModelAssembler<Filter, EntityModel<Filter>> {
    @Override
    public EntityModel<Filter> toModel(Filter filter) {
        return EntityModel.of(
            filter,
            linkTo(methodOn(FilterRestController.class).one(filter.getId())).withSelfRel(),
            linkTo(methodOn(FilterRestController.class).all()).withRel("filters")
        );
    }
}