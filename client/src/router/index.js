import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue')
    },
    {
      path: '/estimation/select',
      name: 'estimation select',
      component: () => import('../views/EstimationSelectView.vue')
    },
    {
      path: '/result',
      name: 'result',
      component: () => import('../views/ResultView.vue'),
      children: [
        {
          path: 'fe',
          component: () => import('../views/nested/FeResultView.vue')
        },
        {
          path: 'be',
          component: () => import('../views/nested/BeResultView.vue')
        },
        {
          path: 'cloud',
          component: () => import('../views/nested/CloudResultView.vue')
        }
      ]
    },
    {
      path: '/estimation',
      name: 'estimation',
      component: () => import('../views/EstimationView.vue')
    }
  ]
});

export default router;
