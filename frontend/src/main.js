import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.min.js";
import "bootstrap-icons/font/bootstrap-icons.css";
import store from "./store/store";

const app = createApp(App);
app.use(Vue3FormWizard);
app.use(router);
app.mount("#app");
