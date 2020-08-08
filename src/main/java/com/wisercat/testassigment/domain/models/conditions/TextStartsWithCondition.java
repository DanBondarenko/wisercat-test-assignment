package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;

@Embeddable
public class TextStartsWithCondition extends TextualCondition {
    @Override
    public boolean test(String fixedOperand, String variableOperand) {
        return fixedOperand.startsWith(variableOperand);
    }
}
