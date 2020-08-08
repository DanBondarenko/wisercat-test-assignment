package com.wisercat.testassigment.persistence.repositories;

import com.wisercat.testassigment.domain.models.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredicateRepository extends JpaRepository<Predicate, Long> {
}
