package com.wisercat.testassigment.domain.models.conditions;

public enum TextualCondition {
    ENDS_WITH {
        @Override
        public boolean evaluate(String fixedOperand, String variableOperand) {
            return fixedOperand.endsWith(variableOperand);
        }
    },
    EQUAL {
        @Override
        public boolean evaluate(String fixedOperand, String variableOperand) {
            return fixedOperand.equals(variableOperand);
        }
    },
    STARTS_WITH {
        @Override
        public boolean evaluate(String fixedOperand, String variableOperand) {
            return fixedOperand.startsWith(variableOperand);
        }
    };

    public abstract boolean evaluate(String fixedOperand, String variableOperand);
}
