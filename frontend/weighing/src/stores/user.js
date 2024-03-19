import { defineStore } from 'pinia'

export const useCounterStore = defineStore('user', {
  state: () => {
    return { 
      user: null
    }
  },
  actions: {
    increment(user) {
      this.user=user
    },
  },
})