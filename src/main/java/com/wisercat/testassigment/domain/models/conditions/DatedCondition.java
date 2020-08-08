package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.util.Date;
import java.util.function.BiPredicate;

@Embeddable
public abstract class DatedCondition implements BiPredicate<LocalDate, LocalDate> {}
