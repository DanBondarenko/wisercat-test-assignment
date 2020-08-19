import {getConditionTranslationKey, getPredicateTypeByCode, getValidPredicateTypes} from "/js/models/Predicates.js";
import TranslationMixin from "/js/mixins/TranslationMixin.js";
import InputEmissionMixin from "/js/mixins/InputEmissionMixin.js"
import NumericalPredicateOperand from "/js/components/NumericalPredicateOperand.js";
import TextualPredicateOperand from "/js/components/TextualPredicateOperand.js";
import DatedPredicateOperand from "/js/components/DatedPredicateOperand.js";

export default {
    name: 'predicate-row',
    template: `
        <div @change="emitClonedUpdate" class="row-container" role="group">
            <select v-model="predicateTypeCode" 
                    @change.stop="reinitializePredicate"
                    class="row-item">
                <option :value="undefined" disabled selected hidden>
                    {{ getTranslation("predicates.placeholder") }}
                </option>
                <option v-for="type in validTypes" :key="type.getTypeCode()" :value="type.getTypeCode()">
                    {{ getPredicateTranslation(type) }}
                </option>
            </select>
            
            <select v-model="predicate.condition" class="row-item">
                <option :value="undefined" disabled selected hidden>
                    {{ getTranslation("conditions.placeholder") }}
                </option>
                <option v-for="condition in predicate.constructor.getAvailableConditions()" 
                        :key="condition" :value="condition">
                    {{ getConditionTranslation(condition) }}
                </option>
            </select>
            
            <component :is="predicate.constructor.getComponentName()" 
                       v-model="predicate.fixedOperand" 
                       class="row-item"/>

            <div class="row-item row-controls">
                <button type="button"
                        @click="$emit('add')"
                        class="add-row-button" :class="{invisible: !showAdditionButton}"
                        :title="getTranslation('predicates.add')">
    
                    <span class="icon fas fa-plus-square"/>
                </button>
                
                <button type="button"
                        @click="$emit('remove')"
                        v-if="showRemovalButton"
                        class="remove-row-button"
                        :title="getTranslation('predicates.remove')">
    
                    <span class="icon fas fa-minus-square"/>
                </button>
            </div>
        </div>
    `,
    mixins: [TranslationMixin, InputEmissionMixin],
    components: {
        'numerical-predicate-operand': NumericalPredicateOperand,
        'textual-predicate-operand': TextualPredicateOperand,
        'dated-predicate-operand': DatedPredicateOperand
    },
    props: {
        showAdditionButton: Boolean,
        showRemovalButton: Boolean,
        value: Object
    },
    data() {
        return {
            predicateTypeCode: this.getPredicateTypeCodeFromProps(),
            predicate: this.constructPredicateFromProps(),
        };
    },
    methods: {
        emitClonedUpdate() {
            this.emitInputEvent(this.constructPredicateFromSelection());
        },
        getConditionTranslation(condition) {
            return this.getTranslation(getConditionTranslationKey(condition));
        },
        getPredicateTranslation(predicateType) {
            return this.getTranslation(predicateType.getPredicateTypeTranslationKey())
        },
        constructPredicateFromSelection() {
            const predicateType = this.getPredicateType();
            return new predicateType(this.predicate.condition, this.predicate.fixedOperand);
        },
        constructPredicateFromProps() {
            const predicateType = this.getPredicateTypeFromProps();
            return new predicateType(this.value.condition, this.value.fixedOperand);
        },
        getPredicateTypeCodeFromProps() {
            return this.value.constructor.getTypeCode();
        },
        getPredicateType() {
            return getPredicateTypeByCode(this.predicateTypeCode);
        },
        getPredicateTypeFromProps() {
            return getPredicateTypeByCode(this.getPredicateTypeCodeFromProps());
        },
        reinitializePredicate() {
            const predicateType = this.getPredicateType();
            this.predicate = new predicateType();
            this.emitClonedUpdate();
        }
    },
    computed: {
        validTypes: getValidPredicateTypes,
    }
}
