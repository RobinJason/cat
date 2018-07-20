<template>
  <div id="app">
    <div class="layout">
      <!--头部-->
      <v-header></v-header>
      <!--路由出口-->
      <div class="layout-content">
        <keep-alive>
          <router-view/>
        </keep-alive>
      </div>
      <!--脚部-->
      <v-footer></v-footer>
    </div>
  </div>
</template>

<script>
import vHeader from './components/header/header.vue'
import vFooter from './components/footer/footer.vue'
export default {
  name: 'App',
  components: {
    vHeader,
    vFooter
  }
}
</script>

<style>
@import "assets/css/reset.css";
#app {
  /*font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;*/
  height: 100%;
}
.layout{
  display: flex;
  flex-direction: column;
  height: 100%;
}
.layout-content {
  width: 1140px;
  padding: 30px 60px;
  margin: 0 auto;
  box-sizing: border-box;
  flex:1 1 100%;
}
</style>
