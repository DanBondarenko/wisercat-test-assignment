package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.conditions.NumericalCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class NumericalPredicate extends Predicate {
    private float fixedOperand;
    @Enumerated(EnumType.STRING)
    private NumericalCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluatableObject) {
        return condition.evaluate(fixedOperand, evaluatableObject.getNumber());
    }
}
