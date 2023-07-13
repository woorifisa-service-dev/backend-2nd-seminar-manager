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
          path: '',
          name: 'ResultHome',
          component: () => import('../views/nested/ResultHomeView.vue')
        },
        {
          path: 'fe',
          name: 'FeResult',
          component: () => import('../views/nested/FeResultView.vue')
        },
        {
          path: 'be',
          name: 'BeResult',
          component: () => import('../views/nested/BeResultView.vue')
        },
        {
          path: 'cloud',
          name: 'CloudResult',
          component: () => import('../views/nested/CloudResultView.vue')
        }
      ]
    },
    {
      path: '/estimation',
      name: 'estimation',
      component: () => import('../views/EstimationView.vue')
    },
    {
      path: '/estimation/list',
      name: 'estimation list',
      component: () => import('../views/EstimationTeamListView.vue')
    },
    {
      path: '/detail',
      name: 'DetailResult',
      component: () => import('../views/nested/DetailResultView.vue')
    }
  ]
});

export default router;
