package com.wisercat.testassigment.domain.models.evaluation;

import com.wisercat.testassigment.domain.models.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Collection;

@Embeddable
@MappedSuperclass
@NoArgsConstructor
public abstract class EvaluationStrategy extends BaseEntity {
    public abstract boolean evaluate(Collection<Boolean> predicateResults);
}
