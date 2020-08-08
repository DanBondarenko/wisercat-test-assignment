package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;

@Embeddable
public class NumberGreaterThanCondition extends NumericalCondition {
    @Override
    public boolean test(Float fixedOperand, Float variableOperand) {
        return fixedOperand > variableOperand;
    }
}
