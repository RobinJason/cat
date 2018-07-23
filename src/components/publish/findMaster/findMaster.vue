<template>
  <div class="find-master">
    <div class="user-photo">
      <img src="" alt="">
    </div>
    <div class="text">
      <textarea name="" id=""></textarea>
    </div>
    <div class="upload-wrap">
      <el-upload
        class="upload-demo"
        action="https://jsonplaceholder.typicode.com/posts/"
        :limit = "9"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :on-success = "handleSuccess"
        :file-list="fileList"
        list-type="picture-card">
        <el-button size="small" type="primary">点击添加图片</el-button>
      </el-upload>
      <div class="cat-pic">
        <img :src="uploadPic" alt="">
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      fileList: [
        {
          name: 'food.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        },
        {
          name: 'food2.jpeg',
          url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
        }
      ]
    }
  },
  computed: {
    uploadPic () {
      let firstItem = this.fileList[0]
      return firstItem ? firstItem.url : ''
    }
  },
  methods: {
    handleRemove (file, fileList) {
      this.fileList = fileList
      console.log(file, fileList)
    },
    handlePreview (file) {
      console.log(file)
    },
    handleSuccess (response, file, fileList) {
      this.fileList = fileList
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
  .find-master
    padding-left 120px
    position relative
    .user-photo
      background #ccc
      border-radius 50%
      position absolute
      left 0
      top 0
      height 80px
      width 80px
      img
        height 100%
        width 100%
    .text
      width 100%
      textarea
        border 1px solid #ccc
        border-radius 5px
        box-sizing border-box
        font-size 14px
        min-height 188px
        padding 20px 10px
        resize none
        width 100%
        &:focus
          -webkit-box-shadow: 0px 0px 5px #ddd
          -moz-box-shadow: 0px 0px 5px #ddd
          box-shadow: 0px 0px 5px #ddd
          -webkit-transition: all .2s
          -moz-transition: all .2s
          -ms-transition: all .2s
          -o-transition: all .2s
          transition: all .2s
    .upload-wrap
      margin-top 20px
      overflow hidden
      position relative
      padding-top 60px
      .upload-demo
        float left
        margin-left 90px
        margin-right 400px
        div.el-upload.el-upload--picture-card
          height auto
          width auto
          border none
          line-height normal
          position absolute
          top 0
          left 0
          .el-button
            padding 8px 23px
        ul
          li
            margin 0 30px 30px 0
            height 80px
            width 80px
      .cat-pic
        float right
        margin-left -100%
        height 400px
        width 400px
</style>
