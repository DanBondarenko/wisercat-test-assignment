import TranslationMixin from "/js/mixins/TranslationMixin.js";
import {postNewFilterAndReturnPromise, getDefaultFilterPromise} from "/js/persistence/ajax.js";
import FilterCreationForm from "/js/components/FilterCreationForm.js";
import convertToFilter from "/js/persistence/conversion.js";

export default {
    name: 'filter-creation-starter',
    template: `
        <div v-if="filter">
            <div v-if="showModal" class="modal-mask"/>
            <div class="form-wrapper" :class="{modal: showModal}">
                <filter-creation-form
                        :value="filter"
                        @save-filter="saveFilter"
                        @cancel="closeForm"/>
            </div>
        </div>
        <div class="filter-creation-starter" v-else>
            <h1>
                {{ getTranslation("filter.creation.header") }}
            </h1>
            
            <button id="create-filter-button" @click="openForm">
                {{ getTranslation("filter.create") }}
            </button>
            
            <section class="modal-checkbox-prompt">
                <label for="modal-checkbox">
                    {{ getTranslation("openInModal") }}
                </label>
                
                <input type="checkbox" id="modal-checkbox" v-model="showModal">
            </section>
        </div>
    `,
    mixins: [TranslationMixin],
    components: {
        'filter-creation-form': FilterCreationForm
    },
    data() {
        return {
            showModal: true,
            filter: undefined
        }
    },
    methods: {
        openForm() {
            getDefaultFilterPromise()
                .then(value => {
                    value.data.name = undefined;
                    this.filter = convertToFilter(value.data);
                })
                .catch(() => alert("There was an unexpected error. The app can not be used at this time."));
        },
        closeForm() {
            this.filter = undefined;
        },
        saveFilter(data) {
            postNewFilterAndReturnPromise(data)
                .then(() => alert(this.getTranslation("filter.saved")))
                .catch(() => alert(this.getTranslation("filter.failed")))
                .finally(() => this.closeForm());
        }

    }
}