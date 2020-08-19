export class Predicate {
    constructor(condition, fixedOperand, type, availableConditions){
        this.condition = condition;
        this.fixedOperand = fixedOperand;
        this.type = type;
        this.availableConditions = availableConditions;
    }

    isValid() {
        return this.fixedOperand !== undefined
            && this.fixedOperand !== null
            && this.availableConditions.includes(this.condition);
    }
}

export class NumericalPredicate extends Predicate {
    constructor(condition, fixecOperand) {
        super(
            condition,
            fixecOperand,
            NumericalPredicate.getTypeCode(),
            NumericalPredicate.getAvailableConditions()
        );
    }

    static getComponentName() {
        return "numerical-predicate-operand";
    }

    static getPredicateTypeTranslationKey() {
        return "predicates.numerical";
    }

    static getTypeCode() {
        return "number";
    }

    static getAvailableConditions() {
        return ["EQUAL", "GREATER_THAN", "LESS_THAN"]
    }
}

export class TextualPredicate extends Predicate {
    constructor(condition, fixecOperand) {
        super(
            condition,
            fixecOperand,
            TextualPredicate.getTypeCode(),
            TextualPredicate.getAvailableConditions()
        );

    }

    static getComponentName() {
        return "textual-predicate-operand";
    }

    static getPredicateTypeTranslationKey() {
        return "predicates.textual";
    }

    static getTypeCode() {
        return "text";
    }

    static getAvailableConditions() {
        return ["EQUAL", "STARTS_WITH", "ENDS_WITH"]
    }
}

export class DatedPredicate extends Predicate {
    constructor(condition, fixecOperand) {
        super(
            condition,
            fixecOperand,
            DatedPredicate.getTypeCode(),
            DatedPredicate.getAvailableConditions()
        );

    }

    static getComponentName() {
        return "dated-predicate-operand";
    }

    static getPredicateTypeTranslationKey() {
        return "predicates.dated";
    }

    static getTypeCode() {
        return "date";
    }

    static getAvailableConditions() {
        return ["EQUAL", "BEFORE", "AFTER"]
    }
}

export function getValidPredicateTypes() {
    return [
        NumericalPredicate,
        TextualPredicate,
        DatedPredicate
    ];
}

export function getConditionTranslationKey(condition) {
    return "conditions." + condition;
}

export function getPredicateTypeByCode(code) {
    return getValidPredicateTypes().find(type => type.getTypeCode() === code);
}