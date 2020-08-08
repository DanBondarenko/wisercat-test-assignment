package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class DateBeforeCondition extends DatedCondition {
    @Override
    public boolean test(LocalDate fixedOperand, LocalDate variableOperand) {
        return fixedOperand.isBefore(variableOperand);
    }
}
