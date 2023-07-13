import axios from 'axios';
import './assets/main.css';

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

axios.defaults.withCredentials = true;

const app = createApp(App);

app.use(router);

app.mount('#app');
