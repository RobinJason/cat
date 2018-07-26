<template>
  <div class="city-select">
    <el-cascader
      :options="options"
      change-on-select
      placeholder="所在位置"
      size="medium"
      @change="getChosenLocation"
    ></el-cascader>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  props: ['order'],
  data () {
    return {
      options: [],
      mapJson: '../static/json/map.json'
    }
  },
  methods: {
    getCityData () { // 使用axios获取数据
      let that = this
      axios.get(this.mapJson).then(function (res) {
        that.options = that.convertJsonKey(res.data)
      }).catch(function (error) {
        console.log(typeof +error)
      })
    },
    convertJsonKey (arr) { // 转换Json的key为需要的key值
      let option = this.recursionReplace(arr, this.order)
      return option
    },
    recursionReplace (arr, order, num = 1) { // 递归替换key函数
      let newArr
      let that = this
      newArr = arr.map(function (item, index) {
        let obj = {}
        for (let a in item) {
          if (a === 'code') {
            obj['value'] = item[a]
          } else if (a === 'name') {
            obj['label'] = item[a]
          } else {
            if (num !== order) {
              num++
              obj[a] = that.recursionReplace(item[a], order, num)
              num = 1 // 重置
            }
          }
        }
        return obj
      })
      return newArr
    },
    getChosenLocation (val) { // 选中后得到的数组值
      console.log(val)
      this.$store.commit('changeCity',val) // 触发vuex，citySelect.js中的mutation方法
    }
  },
  created () {
    this.getCityData()
  }
}
</script>
<style scoped>

</style>
