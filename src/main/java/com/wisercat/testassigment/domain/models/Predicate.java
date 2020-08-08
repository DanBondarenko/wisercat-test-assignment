package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Predicate extends BaseEntity {
    abstract boolean evaluate(Evaluatable evaluatableObject);
}
