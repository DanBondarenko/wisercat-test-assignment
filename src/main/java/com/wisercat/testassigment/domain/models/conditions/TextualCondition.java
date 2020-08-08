package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;
import java.util.function.BiPredicate;

@Embeddable
public abstract class TextualCondition implements BiPredicate<String, String> {}
