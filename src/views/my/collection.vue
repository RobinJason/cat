<template>
  <div class="collection">
    <h2 class="custom-my-title">我的收藏</h2>
    <ul class="collection-list" ref="collectionList">
      <li v-for="(list,index) in collectionList" :key="index">
        <div class="collection-list-portrait">
          <img :src="list.catPortrait" alt="">
          <span :class="[list.collection?'el-icon-star-on':'el-icon-star-off']" @click="collection(index)"></span>
        </div>
        <div class="collection-list-footer">
          <div>
            <img :src="list.userPortrait" alt="">
            <p>{{list.name}}</p>
          </div>
          <div>
            <span class=""></span>
            <span class="el-icon-warning"></span>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'collection',
  data () {
    return {
      collectionList: [
        {
          userPortrait: require('../../assets/logo.png'),
          name: '昵称',
          catPortrait: require('../../assets/logo.png'),
          collection: false,
          like: true
        }
      ]
    }
  },
  methods: {
    collection (index) {
      this.collectionList[index].collection = !this.collectionList[index].collection
    }
  }
}
</script>

<style>
@import "custom.css";
.collection-list{
  display: flex;
  flex-wrap: wrap;
  margin: 0;
  padding: 0;
}
.collection-list li{
  flex: 32%;
  max-width: 32%;
  padding-right: 2%;
  padding-bottom: 3em;
}
.collection-list li:nth-child(3n){
  padding-right: 0;
}
.collection-list-portrait{
  position: relative;
}
.collection-list-portrait img{
  width: 100%;
  background: #ccc;
}
.collection-list-portrait span{
  position: absolute;
  top: 9px;
  right: 9px;
  font-size: 26px;
  cursor: pointer;
}
.collection-list-footer{
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-top: 8px;
}
.collection-list-footer>div:first-child{
  display: flex;
  align-items: center;
  padding-left: 10px;
}
.collection-list-footer>div:first-child img{
  width: 40px;
  background: aquamarine;
  border-radius: 50%;
}
.collection-list-footer>div:first-child p{
  margin: 0 0 0 8px;
  font-size: 14px;
  color: #555;
}
.collection-list-footer>div:last-child span{
  font-size: 20px;
  color: #757575;
  margin-left: 10px;
}
</style>
