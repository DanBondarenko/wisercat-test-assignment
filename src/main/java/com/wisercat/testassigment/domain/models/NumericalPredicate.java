package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.conditions.NumericalCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@DiscriminatorValue("numerical")
public class NumericalPredicate extends Predicate {
    private float fixedOperand;
    @Embedded
    private NumericalCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluatableObject) {
        return condition.test(fixedOperand, evaluatableObject.getNumber());
    }
}
