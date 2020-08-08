package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;
import java.util.function.BiPredicate;

@Embeddable
public abstract class NumericalCondition implements BiPredicate<Float, Float> {}
