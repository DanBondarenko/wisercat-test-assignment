import InputEmissionMixin from "/js/mixins/InputEmissionMixin.js"
import TranslationMixin from "/js/mixins/TranslationMixin.js"

export default {
    name: 'numerical-predicate-operand',
    template: `
        <input type="number" v-model.lazy.number="operand" @change="emitPropertyUpdate('operand')"
               :placeholder="getTranslation('predicates.operand.numerical')" required>
    `,
    data() {
        return {
            operand: this.value
        }
    },
    mixins: [InputEmissionMixin, TranslationMixin],
    props: {
        value: Number
    }
};