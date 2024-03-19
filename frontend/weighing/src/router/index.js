import { createRouter, createWebHashHistory } from 'vue-router'
import { inject } from "vue"

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/Info.vue'),
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/Login.vue'),
  },
  {
    path: '/mes',
    name: 'message',
    component: () => import('@/views/Message.vue'),
  },
  {
    path: '/weight',
    name: 'weight',
    component: () => import('@/views/Weight.vue'),
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach((to,from,next)=>{
  if(to.path=='/login') return next();
  if(to.path=='/register') return next();
   if(!inject("user").user) return next('/login')
   next()
})

export default router