import TranslationMixin from "/js/mixins/TranslationMixin.js"
import {NumericalPredicate} from "/js/models/Predicates.js";
import PredicateRow from "/js/components/PredicateRow.js";
import Filter, {getEvaluationStrategyTranslationKey} from "/js/models/Filter.js";

export default {
    name: "filter-creation-form",
    template: `
        <form class="filter-creation-form" @submit="saveFilter" @reset="cancel">
            <h2>
                {{ getTranslation("filter.form.header") }}
            </h2>
            
            <fieldset class="form-section name-section">
                <legend class="form-section-header">
                    {{ getTranslation("filter.form.name.header") }}
                </legend>
                
                <input type="text" 
                       v-model="filter.name" 
                       :placeholder="getTranslation('filter.name')" 
                       required>
            </fieldset>
            
            <fieldset class="form-section predicates-section">
                <legend class="form-section-header">
                    {{ getTranslation("filter.form.predicates.header") }}
                </legend>

                <predicate-row v-for="(predicate, index) in filter.predicates" :key="predicate.constructor.getTypeCode()" 
                               v-model="filter.predicates[index]"
                               :show-removal-button="isThereMoreThanOnePredicate" 
                               @remove="removePredicate(index)" 
                               :show-addition-button="isLastPredicate(index)"
                               @add="addPredicate(index)"/>
            </fieldset>
            
            <fieldset class="form-section evaluation-radios-section">
                <legend class="form-section-header">
                    {{ getTranslation("filter.form.evaluation.header") }}
                </legend>
                
                <div class="evaluation-radios-group" role="group">
                    <div v-for="strategy in filter.constructor.validEvaluationStrategies()">
                        <input type="radio" 
                               v-model="filter.evaluationStrategy" 
                               :value="strategy" 
                               :id="getStrategyId(strategy)">
                        
                        <label :for="getStrategyId(strategy)">
                            {{ getStrategyTranslation(strategy) }}
                        </label>
                    </div>
                </div>
            </fieldset>
            
            <section class="form-section form-footer">
                <button class="form-button cancel-button" type="reset">
                    {{ getTranslation("cancel") }}
                </button>
                
                <button class="form-button apply-button" type="button" @click="applyFilter">
                    {{ getTranslation("filter.apply") }}
                </button>
                
                <button class="form-button save-button" type="submit">
                    {{ getTranslation("save") }}
                </button>
            </section>
        </form>
    `,
    components: {
        'predicate-row': PredicateRow,
    },
    mixins: [TranslationMixin],
    props: {
        value: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            filter: new Filter(
                this.value.name,
                this.value.enabled,
                this.value.predicates,
                this.value.evaluationStrategy
            )
        }
    },
    methods: {
        isLastPredicate(index) {
            return index === this.filter.predicates.length - 1
        },
        removePredicate(index) {
            this.filter.predicates.splice(index, 1);
        },
        createDefaultPredicate() {
            return new NumericalPredicate();
        },
        addPredicate() {
            this.filter.predicates.push(this.createDefaultPredicate());
        },
        saveFilter() {
            this.$emit("save-filter", this.filter)
        },
        cancel() {
            this.$emit("cancel", this.filter)
        },
        applyFilter() {
            this.filter.enabled = true;
            this.saveFilter();
        },
        getStrategyTranslation(strategy) {
            return this.getTranslation(getEvaluationStrategyTranslationKey(strategy));
        },
        getStrategyId(strategy) {
            return "strategy-" + strategy;
        }
    },
    computed: {
        isThereMoreThanOnePredicate() {
            return this.filter.predicates.length > 1;
        }
    }
}
