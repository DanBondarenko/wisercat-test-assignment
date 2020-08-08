package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.conditions.DatedCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class DatedPredicate extends Predicate {
    private LocalDate fixedOperand;
    @Enumerated(EnumType.STRING)
    private DatedCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluatableObject) {
        return condition.evaluate(fixedOperand, evaluatableObject.getDate());
    }
}
