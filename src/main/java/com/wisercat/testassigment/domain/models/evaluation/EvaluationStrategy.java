package com.wisercat.testassigment.domain.models.evaluation;

import com.wisercat.testassigment.domain.models.BaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.Collection;
import java.util.stream.Stream;

public enum EvaluationStrategy {
    ALL_MATCH {
        @Override
        public boolean evaluate(Stream<Boolean> predicateResults) {
            return predicateResults.allMatch(Boolean::booleanValue);
        }
    },
    ANY_MATCH {
        @Override
        public boolean evaluate(Stream<Boolean> predicateResults) {
            return predicateResults.anyMatch(Boolean::booleanValue);
        }
    },
    NONE_MATCH {
        @Override
        public boolean evaluate(Stream<Boolean> predicateResults) {
            return predicateResults.noneMatch(Boolean::booleanValue);
        }
    };

    public abstract boolean evaluate(Stream<Boolean> predicateResults);
}
