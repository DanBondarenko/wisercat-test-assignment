package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import com.wisercat.testassigment.domain.models.evaluation.EvaluationStrategy;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Filter extends BaseEntity {
    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(nullable = false)
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL)
    @NotEmpty
    private Set<Predicate> predicates;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private EvaluationStrategy evaluationStrategy;

    public boolean evaluate(Evaluatable evaluatableObject) {
        return evaluationStrategy.evaluate(
            predicates.stream().map(predicate -> predicate.evaluate(evaluatableObject))
        );
    }
}
