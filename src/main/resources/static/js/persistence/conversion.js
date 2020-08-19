import {getPredicateTypeByCode} from "/js/models/Predicates.js";
import Filter from "/js/models/Filter.js";

export default function convertToFilter(object) {
    return new Filter(
        object.name,
        object.enabled,
        object.predicates.map(predicate => convertToPredicate(predicate)),
        object.evaluationStrategy
    );
}

function convertToPredicate(object) {
    const predicateType = getPredicateTypeByCode(object.type);
    return new predicateType(object.condition, object.fixedOperand);
}
