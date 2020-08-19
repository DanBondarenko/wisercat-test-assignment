import InputEmissionMixin from "/js/mixins/InputEmissionMixin.js"
import TranslationMixin from "/js/mixins/TranslationMixin.js"

export default {
    name: 'textual-predicate-operand',
    template: `
        <input type="text" v-model.lazy="operand" @change="emitPropertyUpdate('operand')"
               :placeholder="getTranslation('predicates.operand.textual')" required>
    `,
    mixins: [InputEmissionMixin, TranslationMixin],
    props: {
        value: String
    },
    data() {
        return {
            operand: this.value
        }
    }
};