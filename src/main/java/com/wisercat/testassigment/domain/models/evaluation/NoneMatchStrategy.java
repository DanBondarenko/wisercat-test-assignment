package com.wisercat.testassigment.domain.models.evaluation;

import java.util.Collection;

public class NoneMatchStrategy extends EvaluationStrategy {
    @Override
    public boolean evaluate(Collection<Boolean> predicateResults) {
        return predicateResults.stream().noneMatch(Boolean::booleanValue);
    }
}
