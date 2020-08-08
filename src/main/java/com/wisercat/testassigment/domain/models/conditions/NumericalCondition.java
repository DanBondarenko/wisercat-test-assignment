package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.util.function.BiPredicate;

@Embeddable
@MappedSuperclass
public abstract class NumericalCondition implements BiPredicate<Float, Float> {}
