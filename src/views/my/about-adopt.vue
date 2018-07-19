<template>
  <div class="about-adopt">
    <ul class="custom-tabs-item" ref="tabsItem">
      <li @click="tabClick(index)" v-for="(item,index) in ['我的领养','领养我的']" :key="index" :class="[index==idx?'active': '']">
        {{item}}
      </li>
    </ul>
    <div class="custom-tabs-content">
      <ul class="custom-tabs" v-if="idx == 0">
        <li v-for="(list,index) in adoptList" :key="index">
          <div class="adopt-list-warp">
            <div class="portrait">
              <img :src="list.portrait" alt="">
            </div>
            <div class="adopt-list-info">
              <div>
                <label>猫猫</label>
                <p>{{list.catName}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>主人</label>
                <p>{{list.master}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>领养日</label>
                <p>{{list.adoptTime}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>健康状况</label>
                <p>{{list.health}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>领养地址</label>
                <p>{{list.adoptPlace}}</p>
                <button type="button">修改</button>
              </div>
            </div>
          </div>
        </li>
      </ul>
      <ul class="custom-tabs" v-if="idx == 1">
        <li v-for="(list,index) in adoptedList" :key="index">
          <div class="adopt-list-warp">
            <div class="portrait">
              <img :src="list.portrait" alt="">
            </div>
            <div class="adopt-list-info">
              <div>
                <label>猫猫</label>
                <p>{{list.catName}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>主人</label>
                <p>{{list.master}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>领养日</label>
                <p>{{list.adoptTime}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>健康状况</label>
                <p>{{list.health}}</p>
                <button type="button">修改</button>
              </div>
              <div>
                <label>领养地址</label>
                <p>{{list.adoptPlace}}</p>
                <button type="button">修改</button>
              </div>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'about-adopt',
  data () {
    return {
      idx: 0,
      adoptList: [
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        },
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        }
      ],
      adoptedList: [
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        },
        {
          portrait: require('../../assets/logo.png'),
          catName: 'xx',
          master: 'xx',
          adoptTime: '2018-05-05',
          health: '健康',
          adoptPlace: 'xxxxxxxxxxxx'
        }
      ]
    }
  },
  methods: {
    tabClick (index) {
      this.idx = index
    }
  }
}
</script>

<style>
@import "custom.css";
.about-adopt .custom-tabs{
  margin: 0;
  padding: 20px 40px;
}
.about-adopt .custom-tabs li{
  border-bottom: 1px solid #ccc;
  padding: 10px 5px;
}
.adopt-list-warp{
  display: flex;
  align-items: flex-start;
}
.adopt-list-warp .portrait{
  background: #ccc;
  margin-right: 2em;
  border-radius: 6px;
  overflow: hidden;
  flex: none;
}
.adopt-list-info{
  width: 100%;
}
.adopt-list-info>div{
  display: flex;
  align-items: center;
  line-height: 40px;
}
.adopt-list-info label{
  width: 5em;
  flex: none;
  font-weight: 800;
  color: #555;
  font-size: 14px;
}
.adopt-list-info p{
  margin: 0;
  width: 100%;
  font-size: 14px;
  color: #777;
}
.adopt-list-info button{
  flex: none;
  background: none;
  border: 0;
  cursor: pointer;
  line-height: 38px;
  width: 100px;
  text-align: left;
  color: #777;
}
</style>
