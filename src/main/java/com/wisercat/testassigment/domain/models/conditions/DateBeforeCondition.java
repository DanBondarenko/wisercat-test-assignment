package com.wisercat.testassigment.domain.models.conditions;

import java.time.LocalDate;

public class DateBeforeCondition extends DatedCondition {
    @Override
    public boolean test(LocalDate fixedOperand, LocalDate variableOperand) {
        return fixedOperand.isBefore(variableOperand);
    }
}
