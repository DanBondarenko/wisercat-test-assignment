package com.wisercat.testassigment.domain.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.wisercat.testassigment.domain.models.evaluation.Evaluatable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = DatedPredicate.class),
    @JsonSubTypes.Type(value = TextualPredicate.class),
    @JsonSubTypes.Type(value = NumericalPredicate.class)
})
public abstract class Predicate extends BaseEntity {
    abstract boolean evaluate(Evaluatable evaluableObject);
}
