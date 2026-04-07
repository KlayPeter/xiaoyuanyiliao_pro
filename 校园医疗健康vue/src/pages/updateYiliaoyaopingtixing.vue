<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">修改药品采购提醒</h2>
      <el-form label-width="100px" class="form">

        <el-form-item style="display: none" label="药品采购提醒id">
          <el-input v-model="yiliaoyaopingtixing.id" />
        </el-form-item>
            <el-form-item label="提醒标题">
              <el-input placeholder="请输入提醒标题" v-model="yiliaoyaopingtixing.caigout" clearable />
            </el-form-item>
            <el-form-item label="采购提醒内容">
              <el-input placeholder="请输入采购提醒内容" v-model="yiliaoyaopingtixing.caigoucontent" clearable />
            </el-form-item>
            <el-form-item label="发布时间">
              <el-input placeholder="请输入发布时间" v-model="yiliaoyaopingtixing.addtime" clearable />
            </el-form-item>
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="updateYiliaoyaopingtixingactJson()">
            ✨ 修改
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const updateYiliaoyaopingtixing = {
    components: {
    },
    data() {
      return {
        yiliaoyaopingtixing:{},
      }
    },
    methods: {
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
      updateYiliaoyaopingtixingactJson() {
        var _this = this
        this.axios.post("/updateYiliaoyaopingtixingactJson", _this.yiliaoyaopingtixing).then(res => {
          if (res.data.message == '修改药品采购提醒成功') {
            _this.$toast.success("修改药品采购提醒成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/yiliaoyaopingtixingList"})
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
      },
    },
    //data初始化完成
    created() {
      var _this = this
      this.axios.post("/updateYiliaoyaopingtixingJson?id="+_this.$route.query.id).then(res=>{
        _this.yiliaoyaopingtixing = res.data.yiliaoyaopingtixing
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default updateYiliaoyaopingtixing
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


