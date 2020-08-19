export default {
    methods: {
        getTranslation(key) {
            if (messages.hasOwnProperty(key)) {
                return messages[key];
            } else {
                return "[ Translation missing ]";
            }
        }
    }
};