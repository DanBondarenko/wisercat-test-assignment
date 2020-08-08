package com.wisercat.testassigment.persistence.repositories;

import com.wisercat.testassigment.domain.models.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long> {
    List<Filter> findByName(String name);
}
