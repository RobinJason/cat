import Vue from 'vue'
import Vuex from 'vuex'
import publishTab from './modules/publishTab'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0
  },
  mutations: {
    increment (state) {
      state.count++
    }
  },
  modules: {
    publishTab: publishTab
  }
})
