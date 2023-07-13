import axios from 'axios';
import './assets/main.css';

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import axios from 'axios';

axios.defaults.withCredentials = true;
const app = createApp(App);
axios.defaults.withCredentials = true;

app.use(router);

app.mount('#app');
