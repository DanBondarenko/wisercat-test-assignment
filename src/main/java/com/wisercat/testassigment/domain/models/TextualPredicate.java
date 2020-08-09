package com.wisercat.testassigment.domain.models;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.wisercat.testassigment.domain.models.conditions.TextualCondition;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@JsonTypeName("text")
public class TextualPredicate extends Predicate {
    @NotBlank
    @Column(nullable = false)
    private String fixedOperand;
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TextualCondition condition;

    @Override
    boolean evaluate(Evaluatable evaluableObject) {
        return condition.evaluate(fixedOperand, evaluableObject.getString());
    }
}
