package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.conditions.DatedCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@DiscriminatorValue("dated")
public class DatedPredicate extends Predicate {
    private LocalDate fixedOperand;
    @Embedded
    private DatedCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluatableObject) {
        return condition.test(fixedOperand, evaluatableObject.getDate());
    }
}
