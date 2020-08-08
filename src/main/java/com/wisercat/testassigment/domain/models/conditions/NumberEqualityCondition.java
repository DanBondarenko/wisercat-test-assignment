package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;

@Embeddable
public class NumberEqualityCondition extends NumericalCondition {
    @Override
    public boolean test(Float fixedOperand, Float variableOperand) {
        return fixedOperand.equals(variableOperand);
    }
}
