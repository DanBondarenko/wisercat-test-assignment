import axios from "/js/web_modules/axios/dist/axios.js";

export function getDefaultFilterPromise() {
    return axios.get("/api/filters/default");
}
export function postNewFilterAndReturnPromise(filter) {
    return axios.post("/api/filters/", filter);
}