package com.wisercat.testassigment.domain.models;

import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Predicate extends BaseEntity {
    abstract boolean evaluate(Evaluatable evaluatableObject);
}
