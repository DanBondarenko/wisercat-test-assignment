export default class Filter {
    constructor(name, enabled, predicates, evaluationStrategy) {
        this.name = name;
        this.enabled = enabled;
        this.predicates = predicates;
        this.evaluationStrategy = evaluationStrategy;
    }

    isValid() {
        return this.name
            && this.enabled !== undefined
            && this.enabled !== null
            && this.predicates.every(predicate => predicate.isValid())
            && Filter.validEvaluationStrategies().includes(this.evaluationStrategy);
    }

    static validEvaluationStrategies() {
        return ["ALL_MATCH", "ANY_MATCH", "NONE_MATCH"];
    }
}

export function getEvaluationStrategyTranslationKey(strategy) {
    return "filter.strategy." + strategy;
}
