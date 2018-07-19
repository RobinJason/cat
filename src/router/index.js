import Vue from 'vue'
import Router from 'vue-router'
import publish from '@/components/publish/publish'
import diary from '@/components/diary/diary'

Vue.use(Router)

const routes = [
  { path: '/publish', component: publish },
  { path: '/diary', component: diary }
]

export default new Router({
  routes: routes
})
