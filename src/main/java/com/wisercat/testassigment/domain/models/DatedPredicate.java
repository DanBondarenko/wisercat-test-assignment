package com.wisercat.testassigment.domain.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.wisercat.testassigment.domain.models.conditions.DatedCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@JsonTypeName("date")
public class DatedPredicate extends Predicate {
    @NotNull
    @Column(nullable = false)
    private LocalDate fixedOperand;
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DatedCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluableObject) {
        return condition.evaluate(fixedOperand, evaluableObject.getDate());
    }
}
