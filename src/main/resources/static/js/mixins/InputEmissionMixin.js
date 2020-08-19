export default {
    methods: {
        emitPropertyUpdate(property) {
            this.emitInputEvent(this[property]);
        },
        emitInputEvent(valueToEmit) {
            this.$emit("input", valueToEmit);
        }
    }
};