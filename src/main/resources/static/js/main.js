import Vue from '/js/web_modules/vue/dist/vue.esm.browser.js'
import FilterCreationStarter from "/js/components/FilterCreationStarter.js";

Vue.config.productionTip = false

new Vue({
    render: h => h(FilterCreationStarter),
}).$mount('#app')
