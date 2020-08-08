package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="predicate_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Predicate extends BaseEntity {
    abstract boolean evaluate(Evaluatable evaluatableObject);
}
