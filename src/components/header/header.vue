<template>
  <header class="header">
    <div class="header-left">
      <div class="header-logo" style="width: 15rem;height: 3rem;background: red;">
        <img src="" alt="">
      </div>
      <nav>
        <router-link :to="list.src" v-for="(list,index) in nav" :key="index">{{list.text}}</router-link>
      </nav>
    </div>
    <div class="header-right">
      <button type="button">登录</button>
      <button type="button">注册</button>
    </div>
  </header>
</template>

<script>
export default {
  data () {
    return {
      nav: [
        {
          text: '首页',
          src: '/'
        },
        {
          text: '社区',
          src: '/'
        },
        {
          text: '日记',
          src: '/diary'
        },
        {
          text: '发布',
          src: '/publish'
        },
        {
          text: '我的',
          src: '/my/personal-data'
        }
      ]
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .header
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 1140px;
    margin: 0 auto;
    background: transparent;
    flex:none;
  .header-left
    display: flex;
    justify-content: center;
    align-items: center;
    a
      text-decoration: none;
      color: #555;
      display: inline-block;
      box-sizing: border-box;
      line-height: 3rem;
      width: 5rem;
      text-align: center;
      &.router-link-exact-active
        background: bisque;
        color: #fff;
  .header-right
    button
      border: 1px solid bisque;
      background: bisque;
      color: #fff;
      padding: 2px 8px;
      border-radius: 6px;
      margin-left: 1rem;
</style>
