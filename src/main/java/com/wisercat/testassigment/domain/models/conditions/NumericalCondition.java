package com.wisercat.testassigment.domain.models.conditions;

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
