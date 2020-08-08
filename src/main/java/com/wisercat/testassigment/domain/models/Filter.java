package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import com.wisercat.testassigment.domain.models.evaluation.EvaluationStrategy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Filter extends BaseEntity {
    private String name;
    @OneToMany
    private Set<Predicate> predicates;
    @Embedded
    private EvaluationStrategy evaluationStrategy;

    public boolean evaluate(Evaluatable evaluatableObject) {
        final Set<Boolean> results = predicates.stream()
            .map(predicate -> predicate.evaluate(evaluatableObject))
            .collect(Collectors.toSet());
        return evaluationStrategy.evaluate(results);
    }
}
