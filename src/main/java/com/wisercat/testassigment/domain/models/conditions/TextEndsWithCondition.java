package com.wisercat.testassigment.domain.models.conditions;

public class TextEndsWithCondition extends TextualCondition {
    @Override
    public boolean test(String fixedOperand, String variableOperand) {
        return fixedOperand.endsWith(variableOperand);
    }
}
