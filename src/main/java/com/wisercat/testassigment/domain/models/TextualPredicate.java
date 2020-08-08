package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.conditions.TextualCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class TextualPredicate extends Predicate {
    private String fixedOperand;
    @Embedded
    private TextualCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluatableObject) {
        return condition.test(fixedOperand, evaluatableObject.getString());
    }
}
