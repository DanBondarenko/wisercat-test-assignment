package com.wisercat.testassigment.domain.models.evaluation;

import com.wisercat.testassigment.domain.models.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Collection;

@Embeddable
@NoArgsConstructor
public abstract class EvaluationStrategy extends BaseEntity {
    public abstract boolean evaluate(Collection<Boolean> predicateResults);
}
