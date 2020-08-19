import InputEmissionMixin from "/js/mixins/InputEmissionMixin.js"
import TranslationMixin from "/js/mixins/TranslationMixin.js"
import lodash from '/js/web_modules/lodash.js';

export default {
    name: 'dated-predicate-operand',
    template: `
        <div class="row-container" @change="emitValidatedUpdate" role="group">
            <select v-model="date.year" required>
                <option :value="undefined" disabled selected hidden>
                    {{ getTranslation("calendar.year") }}
                </option>                
                <option v-for="year in yearOptions" :key="year" :value="year">
                    {{ year }}
                </option>
            </select>
            <select v-model="date.month" required>
                <option :value="undefined" disabled selected hidden>
                    {{ getTranslation("calendar.month") }}
                </option>
                <option v-for="month in monthOptions" :key="month.index" :value="month.index">
                    {{ month.name }}
                </option>
            </select>
            <select v-model="date.day" required>
                <option :value="undefined" disabled selected hidden>
                    {{ getTranslation("calendar.day") }}
                </option>
                <option v-for="day in dayOptions" :key="day" :value="day">
                    {{ day }}
                </option>
            </select>
        </div>
    `,
    mixins: [InputEmissionMixin, TranslationMixin],
    props: {
        value: String
    },
    data() {
        return {
            date: this.parseDateFromProps()
        };
    },
    methods: {
        emitValidatedUpdate() {
            if (this.isSelectedDateValid) {
                const selectedDate = this.constructJsDateFromSelection();
                const dateStringWithoutTimezone = selectedDate.toISOString().substring(0, 10)
                this.emitInputEvent(dateStringWithoutTimezone);
            } else {
                this.emitInputEvent(null);
            }
        },
        isJsDateValid(jsDate) {
            return !isNaN(jsDate);
        },
        constructJsDateFromSelection() {
            return new Date(this.date.year, this.date.month, this.date.day);
        },
        parseDateFromProps() {
            const jsDate = new Date(Date.parse(this.value));
            if (this.isJsDateValid(jsDate)) {
                return {
                    year: jsDate.getFullYear(),
                    month: jsDate.getMonth(),
                    day: jsDate.getDate()
                };
            } else {
                return {};
            }
        }
    },
    computed: {
        isSelectedDateValid() {
            return this.isYearAndMonthSelected
                && this.date.day !== undefined
                && this.date.day > -1
                && this.date.day <= this.nDaysInSelectedMonthAndYear
                && this.isJsDateValid(this.constructJsDateFromSelection());

        },
        isYearAndMonthSelected() {
            return this.date.year !== undefined
                && this.date.month !== undefined
                && this.date.month < 12
                && this.date.month > -1;
        },
        nDaysInSelectedMonthAndYear() {
            return new Date(this.date.year, this.date.month, 0).getDate();
        },
        dayOptions() {
            if (this.isYearAndMonthSelected) {
                return lodash.range(1, this.nDaysInSelectedMonthAndYear + 1);
            } else {
                return [];
            }
        },
        monthOptions() {
            const getMonthName = function(monthIndex) {
                const dummyDate = new Date();
                dummyDate.setDate(1);
                dummyDate.setMonth(monthIndex);
                return dummyDate.toLocaleString(
                    document.documentElement.lang,
                    { month: "long" }
                    );
            };
            return lodash.range(12).map(index => ({
                index: index,
                name: getMonthName(index)
            }));
        },
        yearOptions() {
            const currentYear = new Date().getFullYear();
            return lodash.range(currentYear - 100, currentYear + 2);
        }
    }

};
