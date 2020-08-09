package com.wisercat.testassigment.domain.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.wisercat.testassigment.domain.models.conditions.NumericalCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@JsonTypeName("number")
public class NumericalPredicate extends Predicate {
    @NotNull
    @Column(nullable = false)
    private Float fixedOperand;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NumericalCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluableObject) {
        return condition.evaluate(fixedOperand, evaluableObject.getNumber());
    }
}
