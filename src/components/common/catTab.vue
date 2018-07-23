<template>
  <div class="cat-tab-btn">
    <ul>
      <li v-for="(tab,index) in tabs" :key="index">
        <span :class="['tab-item', { 'active-tab' : currentTab === tab.name}]" @click=" valuesClass(tab.name) ">{{tab.text}}</span>
        <i class="tab-trans"></i>
      </li>
    </ul>
  </div>
</template>

<script>
// import { mapState } from 'vuex'
export default {
  data () {
    return {
      currentTab: 'find-master',
      tabs: [
        { name: 'find-master', text: '为喵星人寻找主人' },
        { name: 'cat-story', text: '我和喵星人的故事' }
      ]
    }
  },
  methods: {
    valuesClass (val) {
      this.currentTab = val
      this.$store.commit('changeItem', val)
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
  .cat-tab-btn
    width 1080px
    margin 0 auto
    ul
      font-size 0
      li
        display inline-block
        padding 40px 0 50px
        text-align center
        position relative
        width 50%
        span.tab-item
          color #666
          cursor pointer
          font-size 24px
          &.active-tab
            font-weight 600
            ~ i.tab-trans
              display block
        i.tab-trans
          display none
          position absolute
          bottom 5px
          left 50%
          margin-left -18px
          height 0
          width 0
          border-width 20px 18px // 36 * 40
          border-color orange transparent transparent transparent
          border-style solid
</style>
