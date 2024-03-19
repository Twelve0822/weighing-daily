import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import VueRouter from '@/router/index.js'
import { createPinia } from 'pinia'

const pinia = createPinia()

const app = createApp(App)

app.use(pinia)
app.use(VueRouter)
app.use(ElementPlus)

import { useCounterStore } from '@/stores/user'
const user = useCounterStore()

app.provide("user", user)

app.mount('#app')
