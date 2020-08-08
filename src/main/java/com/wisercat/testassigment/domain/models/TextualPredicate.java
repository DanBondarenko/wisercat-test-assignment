package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.conditions.TextualCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class TextualPredicate extends Predicate {
    private String fixedOperand;
    @Enumerated(EnumType.STRING)
    private TextualCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluatableObject) {
        return condition.evaluate(fixedOperand, evaluatableObject.getString());
    }
}
