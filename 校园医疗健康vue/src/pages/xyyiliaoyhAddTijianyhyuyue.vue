<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header">添加体检用户预约</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="体检预约id">
                    <el-input v-model="tijianyhyuyue.id" />
                </el-form-item>
                        <el-form-item label="校园体检事项">
                            <el-input placeholder="请输入校园体检事项" v-model="tijianyhyuyue.xytijianshixiang" clearable />
                        </el-form-item>
                        <el-form-item label="校园体检事项id">
                            <el-input placeholder="请输入校园体检事项id" v-model="tijianyhyuyue.xytijianshixiangid" clearable />
                        </el-form-item>

                        <el-form-item label="体检位置">
                            <el-input placeholder="请输入体检位置" v-model="tijianyhyuyue.address" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="体检时间">
                            <el-input placeholder="请输入体检时间" v-model="tijianyhyuyue.shijian" clearable />
                        </el-form-item>
                        <el-form-item label="体检封面">
                            <div class="avatar-frame">
                                <el-upload
                                        ref="imgUpload"
                                        class="img-uploader"
                                        action=""
                                        :limit="1"
                                        :auto-upload="false"
                                        :show-file-list="false"
                                        :on-change="changeImgFile"
                                >
                                    <div class="img-uploader-content">
                                        <template v-if="!tijianyhyuyue.img">
                                            <Plus style="margin-right: 5px;" />
                                            <span>点击上传图片</span>
                                        </template>

                                        <template v-else>
                                            <img :src="tijianyhyuyue.img && tijianyhyuyue.img.includes('http') ? tijianyhyuyue.img : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + tijianyhyuyue.img" alt="上传图片"
                                                    class="preview-img"
                                            />
                                        </template>
                                    </div>
                                </el-upload>
                            </div>
                        </el-form-item>
                        <el-form-item label="状态">
                            <el-input placeholder="请输入状态" v-model="tijianyhyuyue.state" clearable />
                        </el-form-item>
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="xyyiliaoyhAddTijianyhyuyueactJson">
                        ✨ 添加
                    </el-button>
                    <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const xyyiliaoyhAddTijianyhyuyue = {
    components: {

    },
    data() {
      return {
        tijianyhyuyue:{
          xytijianshixiang:"",
          xytijianshixiangid:null,
          xyyiliaoyh:"",
          xyyiliaoyhid:null,
          address:"",
          shijian:"",
          img:"",
          state:"",
        },
        xyyiliaoyhs:[],
      }
    },
    methods: {
      changeXyyiliaoyh(event){
        var _this = this
        this.tijianyhyuyue.xyyiliaoyh = this.xyyiliaoyhs.filter(item =>{
          return item.id == _this.tijianyhyuyue.xyyiliaoyhid
        })[0].username
      },
      uploadFile(file) {
        return this.axios.post("/uploadFile", {"file":file},{
          headers:{
            "Content-Type":"multipart/form-data"
          }
        }).then(res => {
          if (res.data.fileUrl == null || res.data.fileUrl == "") {
            this.$toast.error("上传失败", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            return ""
          }
          this.$toast.success("上传成功", {
            position: "top",
            pauseOnHover: false,
            duration: 2000
          })
          return  res.data.fileUrl
        })
      },
      async changeImgFile(event) {
        // 清空文件选择器，防止连续选择相同文件不触发
        this.$refs.imgUpload.clearFiles();
        // 上传文件
        this.tijianyhyuyue.img = await this.uploadFile(event.raw);

      },
      getNowTime(){
        var now = new Date();
        var year = now.getFullYear(); // 获取年份
        var month = now.getMonth() + 1; // 获取月份，月份是从0开始的
        var day = now.getDate(); // 获取日期
        var hour = now.getHours(); // 获取小时
        var minute = now.getMinutes(); // 获取分钟
        var second = now.getSeconds(); // 获取秒
        // 对月、日、时、分、秒进行补0处理
        month = month < 10 ? '0' + month : month;
        day = day < 10 ? '0' + day : day;
        hour = hour < 10 ? '0' + hour : hour;
        minute = minute < 10 ? '0' + minute : minute;
        second = second < 10 ? '0' + second : second;
        return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second
      },
      xyyiliaoyhAddTijianyhyuyueactJson() {
        var _this = this
        this.axios.post("/xyyiliaoyhAddTijianyhyuyueactJson", _this.tijianyhyuyue).then(res => {
          if (res.data.message == '添加体检用户预约成功') {
            _this.$toast.success("添加体检用户预约成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xyyiliaoyhtijianyhyuyueList"})
            return
          }else {
            _this.$toast.error(res.data.message,{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            return;
          }
        })
      }
    },
    //data初始化完成
    created() {
      var _this = this
      var userinfo = JSON.parse(localStorage.getItem("userinfo"))

      this.tijianyhyuyue.xyyiliaoyhid = userinfo.id
      this.tijianyhyuyue.xyyiliaoyh = userinfo.username
      this.axios.post("/xyyiliaoyhAddTijianyhyuyueJson").then(res=>{
        _this.xyyiliaoyhs = res.data.xyyiliaoyhs
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xyyiliaoyhAddTijianyhyuyue
</script>
<style scoped>

  .anime-page {
    padding: 20px;
  }
  .anime-card {
    background: #fff;
    padding: 40px;
    border-radius: 8px;
    box-shadow: 0 2px 12px 0 rgba(0,0,0,0.05);
    max-width: 600px;
    margin: 0 auto;
  }
  .form {
    max-width: 600px;
    margin: 0 auto;
  }
  .page-header {
    font-size: 20px;
    font-weight: 500;
    margin-bottom: 30px;
    color: #303133;
    border-bottom: 1px solid #ebeef5;
    padding-bottom: 15px;
  }
  .form-footer {
    margin-top: 30px;
    text-align: right;
  }
  .anime-btn {
    width: 120px;
  }
  .avatar-uploader .el-upload {
    border: 1px dashed #dcdfe6;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }

</style>


