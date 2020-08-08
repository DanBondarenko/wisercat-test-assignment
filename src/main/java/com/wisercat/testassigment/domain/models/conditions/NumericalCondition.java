package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.function.BiPredicate;

public enum NumericalCondition {
    EQUAL {
        @Override
        public boolean evaluate(Float fixedOperand, Float variableOperand) {
            return fixedOperand.equals(variableOperand);
        }
    },
    GREATER_THAN {
        @Override
        public boolean evaluate(Float fixedOperand, Float variableOperand) {
            return fixedOperand > variableOperand;
        }
    },
    LESS_THAN {
        @Override
        public boolean evaluate(Float fixedOperand, Float variableOperand) {
            return fixedOperand < variableOperand;
        }
    };

    public abstract boolean evaluate(Float fixedOperand, Float variableOperand);
}
