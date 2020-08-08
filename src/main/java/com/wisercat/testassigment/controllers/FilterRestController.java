package com.wisercat.testassigment.controllers;

import com.wisercat.testassigment.domain.models.Filter;
import com.wisercat.testassigment.persistence.repositories.FilterRepository;
import com.wisercat.testassigment.persistence.services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/filters")
public class FilterRestController {
    private final FilterService service;
    private final FilterRepository repository;
    private final FilterModelAssembler assembler;

    @Autowired
    public FilterRestController(FilterService service, FilterRepository repository, FilterModelAssembler assembler) {
        this.service = service;
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/default")
    public EntityModel<Filter> defaultController() {
        final Filter defaultFilter = service.getDefault();
        return EntityModel.of(
            defaultFilter,
            linkTo(methodOn(FilterRestController.class).defaultController()).withSelfRel(),
            linkTo(methodOn(FilterRestController.class).one(defaultFilter.getId())).withSelfRel(),
            linkTo(methodOn(FilterRestController.class).all()).withRel("filters")
        );
    }

    @PostMapping("/")
    public ResponseEntity<?> saveFilter(@RequestBody Filter newFilter) {
        EntityModel<Filter> entityModel = assembler.toModel(repository.save(newFilter));

        return ResponseEntity
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(entityModel);
    }

    @GetMapping("/{id}")
    EntityModel<Filter> one(@PathVariable Long id) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/")
    public CollectionModel<EntityModel<Filter>> all() {
        throw new UnsupportedOperationException();
    }
}
