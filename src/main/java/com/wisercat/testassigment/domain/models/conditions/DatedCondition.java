package com.wisercat.testassigment.domain.models.conditions;

import java.time.LocalDate;

public enum DatedCondition {
    AFTER {
        @Override
        public boolean evaluate(LocalDate fixedOperand, LocalDate variableOperand) {
            return fixedOperand.isAfter(variableOperand);
        }
    },
    BEFORE {
        @Override
        public boolean evaluate(LocalDate fixedOperand, LocalDate variableOperand) {
            return fixedOperand.isBefore(variableOperand);
        }
    },
    EQUAL {
        @Override
        public boolean evaluate(LocalDate fixedOperand, LocalDate variableOperand) {
            return fixedOperand.isEqual(variableOperand);
        }
    };

    public abstract boolean evaluate(LocalDate fixedOperand, LocalDate variableOperand);
}
