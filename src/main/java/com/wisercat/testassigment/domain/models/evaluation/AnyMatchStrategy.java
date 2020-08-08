package com.wisercat.testassigment.domain.models.evaluation;

import javax.persistence.Embeddable;
import java.util.Collection;

@Embeddable
public class AnyMatchStrategy extends EvaluationStrategy {
    @Override
    public boolean evaluate(Collection<Boolean> predicateResults) {
        return predicateResults.stream().anyMatch(Boolean::booleanValue);
    }
}
