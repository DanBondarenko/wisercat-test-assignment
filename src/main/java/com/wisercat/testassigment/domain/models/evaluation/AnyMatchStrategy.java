package com.wisercat.testassigment.domain.models.evaluation;

import java.util.Collection;

public class AnyMatchStrategy extends EvaluationStrategy {
    @Override
    public boolean evaluate(Collection<Boolean> predicateResults) {
        return predicateResults.stream().anyMatch(Boolean::booleanValue);
    }
}
