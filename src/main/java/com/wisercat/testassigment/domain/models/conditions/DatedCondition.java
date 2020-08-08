package com.wisercat.testassigment.domain.models.conditions;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.function.BiPredicate;

@Embeddable
@MappedSuperclass
public abstract class DatedCondition implements BiPredicate<LocalDate, LocalDate> {}
