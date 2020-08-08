package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import com.wisercat.testassigment.domain.models.evaluation.EvaluationStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@NoArgsConstructor
@Getter
public class Filter extends BaseEntity {
    private String name;
    private boolean enabled;
    @OneToMany
    private Set<Predicate> predicates;
    @Enumerated(EnumType.STRING)
    private EvaluationStrategy evaluationStrategy;

    public boolean evaluate(Evaluatable evaluatableObject) {
        return evaluationStrategy.evaluate(
            predicates.stream().map(predicate -> predicate.evaluate(evaluatableObject))
        );
    }
}
