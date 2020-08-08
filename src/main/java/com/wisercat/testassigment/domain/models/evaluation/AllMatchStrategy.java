package com.wisercat.testassigment.domain.models.evaluation;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.Collection;

@Embeddable
public class AllMatchStrategy extends EvaluationStrategy {
    @Override
    public boolean evaluate(Collection<Boolean> predicateResults) {
        return predicateResults.stream().allMatch(Boolean::booleanValue);
    }
}
