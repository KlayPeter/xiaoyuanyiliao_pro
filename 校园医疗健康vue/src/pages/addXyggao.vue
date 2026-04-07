<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">添加校园公告</h2>
      <el-form label-width="100px" class="form">

        <el-form-item style="display: none" label="公告id">
          <el-input v-model="xyggao.id" />
        </el-form-item>
            <el-form-item label="公告标题">
              <el-input placeholder="请输入公告标题" v-model="xyggao.xytitle" clearable />
            </el-form-item>
            <el-form-item label="公告内容">
              <el-input placeholder="请输入公告内容" v-model="xyggao.xycontent" type="textarea" clearable />
            </el-form-item>
            <el-form-item label="封面">
              <div class="avatar-frame">
                <el-upload
                  ref="xyimgUpload"
                  class="img-uploader"
                  action=""
                  :limit="1"
                  :auto-upload="false"
                  :show-file-list="false"
                  :on-change="changeXyimgFile"
                >
                  <div class="img-uploader-content">
                    <template v-if="!xyggao.xyimg">
                      <div class="avatar-uploader-icon">
                        <span>点击上传封面</span>
                      </div>
                    </template>
                    <template v-else>
                      <img :src="xyggao.xyimg && xyggao.xyimg.includes('http') ? xyggao.xyimg : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + xyggao.xyimg" alt="封面"
                        class="preview-img"
                      />
                    </template>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
            <el-form-item label="发布时间">
              <el-input readonly  v-model="xyggao.xyaddtime"/>
            </el-form-item>
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="addXyggaoactJson()">
            ✨ 添加
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const addXyggao = {
    components: {
    },
    data() {
      return {
        xyggao:{

          xytitle:"",


          xycontent:"",


          xyimg:"",


          xyaddtime:"",

        },
      }
    },
    methods: {
      async changeXyimgFile(event) {
        this.$refs.xyimgUpload.clearFiles()
        this.xyggao.xyimg = await this.uploadFile(event.raw)
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
      addXyggaoactJson() {
        var _this = this
        this.axios.post("/addXyggaoactJson", _this.xyggao).then(res => {
          if (res.data.message == '添加校园公告成功') {
            _this.$toast.success("添加校园公告成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xyggaoList"})
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
      this.axios.post("/addXyggaoJson").then(res=>{
      })
      this.xyggao.xyaddtime = this.getNowTime()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default addXyggao
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


