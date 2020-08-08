package com.wisercat.testassigment.domain.models.conditions;

public class NumberGreaterThanCondition extends NumericalCondition {
    @Override
    public boolean test(Float fixedOperand, Float variableOperand) {
        return fixedOperand > variableOperand;
    }
}
