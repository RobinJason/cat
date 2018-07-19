<template>
  <div class="header">
    <nav>
      <!--路由-->
      <ul>
        <li>首页</li>
        <li>社区</li>
        <li>
          <router-link to="/publish">发布</router-link>
        </li>
        <li>
          <router-link to="/diary">日记</router-link>
        </li>
        <li>我的</li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .header
    nav
      ul
        li
          background: #b8fcc6;
          list-style none
          display inline-block
</style>
