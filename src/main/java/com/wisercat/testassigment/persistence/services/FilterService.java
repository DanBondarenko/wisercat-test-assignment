package com.wisercat.testassigment.persistence.services;

import com.wisercat.testassigment.domain.models.Filter;
import com.wisercat.testassigment.persistence.exceptions.FilterNotFoundException;
import com.wisercat.testassigment.persistence.repositories.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterService {
    private final String DEFAULT_NAME = "default";
    private final FilterRepository repository;

    @Autowired
    public FilterService(FilterRepository repository) {
        this.repository = repository;
    }

    public Filter getDefault() throws FilterNotFoundException {
        return repository.findById(0L)
            .filter(filter -> filter.getName().equals(DEFAULT_NAME))
            .orElseThrow(FilterNotFoundException::new);
    }
}
