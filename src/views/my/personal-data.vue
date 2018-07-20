<template>
  <div class="personal-data">
    <h2 class="custom-my-title">个人资料</h2>
    <form>
      <div class="my-row">
        <label class="asterisk">头像：</label>
        <div class="input-row upload-header">
          <cropper v-if="showCropper"
                   ref="cropper"
                   :img="src"
                   :autoCrop="options.autoCrop"
                   :autoCropWidth="options.autoCropWidth"
                   :autoCropHeight="options.autoCropHeight"
                   :fixedBox="options.fixedBox"
                   @clickConfirm="confirmUpload()"
                   @close="closeUpload()"
          ></cropper>
          <div>
            <input type="file" class="custom-file" @change="onFileChange($event)">
            <span v-if="!clippedPictures">点击上传</span>
            <img :src="clippedPictures" v-if="clippedPictures">
          </div>
          <p>请选择jpg、gif格式，小于2M的图片（使用高质量图片，可生成高清头像）</p>
        </div>
      </div>
      <!--<div class="upload-header">
        <div class="upload-header-img">
          <img src="https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=24250912d458ccbf1bbcb23c21e3db03/908fa0ec08fa513db16ccc7e386d55fbb3fbd948.jpg" alt="">
        </div>
        <div class="upload-header-input">
          <div>
            <input type="text">
            <span>浏览 <input type="file" class="custom-file"></span>
          </div>
          <p>请选择jpg、gif格式，小于2M的图片（使用高质量图片，可生成高清头像）</p>
        </div>
      </div>-->
      <div class="my-row">
        <label class="asterisk">昵称：</label>
        <div class="input-row">
          <input type="text" placeholder="请输入昵称">
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">性别：</label>
        <div class="input-row">
          <label class="custom-radio">
            <span class="custom-radio-input">
              <input type="radio" class="custom-radio-original" name="sex" value="boy" v-model="sex">
              <span class="custom-radio-inner"></span>
            </span>
            <span class="custom-radio-label">男</span>
          </label>
          <label class="custom-radio">
            <span class="custom-radio-input">
              <input type="radio" class="custom-radio-original" name="sex" value="girl" v-model="sex">
              <span class="custom-radio-inner"></span>
            </span>
            <span class="custom-radio-label">女</span>
          </label>
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">生日：</label>
        <div class="input-row">
          <el-date-picker
            class="custom-date"
            v-model="birthday"
            type="date"
            placeholder="请选择">
          </el-date-picker>
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">手机号：</label>
        <div class="input-row">
          <input type="text" placeholder="请输入手机号码">
        </div>
      </div>
      <div class="my-row">
        <label class="asterisk">现居地址：</label>
        <div class="input-row">
          <input type="text" placeholder="请输入您所在的地址">
        </div>
      </div>
      <div class="my-submit-btn">
        <button type="button">提交</button>
      </div>
    </form>
  </div>
</template>

<script>
/* eslint-disable */
import Cropper from '../../components/my/cropper.vue'
export default {
  name: 'personal-data',
  data () {
    return {
      sex: 'boy',
      birthday: '',
      clippedPictures: '',
      showCropper: false,
      src: '',
      imgData: {
        accept: 'image/gif, image/jpeg , image/jpg'
      },
      options:{
        autoCrop: true,
        autoCropWidth: 200,
        autoCropHeight: 200,
        fixedBox: true
      }
    }
  },
  methods: {
    onFileChange (event) {
      let file = event.target.files[0]
      let fileSize = file.size
      let reader = new FileReader()
      let self = this
      let data
      console.log(file.size)
      if (!/\.(gif|jpg|jpeg|png|bmp|GIF|JPG|PNG)$/.test(event.target.value)) {
        self.$message('图片类型必须是.gif,jpeg,jpg,png,bmp中的一种')
        return false
      }
//      reader.readAsDataURL(file)
      reader.onloadend = function (e) {
        if(fileSize > 2*1024*1024){
          self.$message("头像大小不能超过2MB")
          return false
        }else {
          if(typeof e.target === 'object'){
            data = window.URL.createObjectURL(new Blob([e.target.result]))
          }else {
            data = e.target.result
          }
          self.src = data
          self.showCropper = true
        }
      }
      reader.readAsArrayBuffer(file)
    },
    confirmUpload () {
      this.$refs.cropper.getCropData((data) => {
        this.clippedPictures = data
        this.closeUpload()
      })
    },
    closeUpload () {
      this.showCropper = false
    }
  },
  components: {
    Cropper
  }
}
</script>

<style>
@import "custom.css";
.personal-data{
  width: 100%;
}
.upload-header{
  display: flex;
  align-items: center;
}
.upload-header>div {
  position: relative;
  width: 100px;
  height: 100px;
  flex: none;
  background: #eee;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #555;
}
.upload-header>div img{
  width: 100%;
  height: 100%;
}
.upload-header p{
  margin: 0;
  color: #555;
  font-size: 14px;
  margin-left: 10px;
}
.my-row{
  display: flex;
  align-items: center;
  margin-bottom: 1em;
}
.my-row>label{
  font-size: 14px;
  color: #757575;
  width: 5rem;
  text-align: left;
}
.my-row input[type='text']{
  border: 1px solid #999;
  border-radius: 4px;
  padding: 6px 10px;
  width: 200px;
}
.my-submit-btn{
  margin-top: 3.5em;
  margin-left: 2em;
}
.my-submit-btn button{
  background: #fd7031;
  border: 1px solid #fd7031;
  color: #fff;
  padding: 4px 12px;
  border-radius: 4px;
  cursor: pointer;
}
.asterisk:before{
  content: '*';
  color: red;
  vertical-align: sub;
}
</style>
