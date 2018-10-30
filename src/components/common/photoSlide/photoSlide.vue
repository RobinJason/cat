<template>
  <div>
    <el-carousel trigger="click" :interval=inter indicator-position="outside" height="400px" style="width: 600px; margin: 0 auto">
      <el-carousel-item v-for="(item,index) in picArr" :key="index">
        <img :src="item"/>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  props: {
    picArr: Array
  },
  data () {
    return {
      inter: 8000
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  .el-carousel__item
    img
      height 400px
      width 100%
    &:nth-child(2n)
      background-color #99a9bf
    &:nth-child(2n+1)
      background-color #d3dce6
</style>
