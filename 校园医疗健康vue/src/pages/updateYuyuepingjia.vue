<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">修改预约评价</h2>
      <el-form label-width="100px" class="form">

        <el-form-item style="display: none" label="预约评价id">
          <el-input v-model="yuyuepingjia.id" />
        </el-form-item>
            <el-form-item label="医疗排班预约">
              <el-input placeholder="请输入医疗排班预约" v-model="yuyuepingjia.xyyiliaopaibanyuyue" clearable />
            </el-form-item>
            <el-form-item label="医疗排班预约id">
              <el-input placeholder="请输入医疗排班预约id" v-model="yuyuepingjia.xyyiliaopaibanyuyueid" clearable />
            </el-form-item>
            <el-form-item label="评价内容">
              <el-input placeholder="请输入评价内容" v-model="yuyuepingjia.pingcontent" type="textarea" clearable />
            </el-form-item>
              <el-form-item label="评价类型">
                <el-select v-model="yuyuepingjia.type" >
                    <el-option label="好评" value="好评" />
                    <el-option label="中评" value="中评" />
                    <el-option label="差评" value="差评" />
                </el-select>
              </el-form-item>
            <el-form-item label="校园用户">
              <el-input placeholder="请输入校园用户" v-model="yuyuepingjia.xyyiliaoyh" clearable />
            </el-form-item>
            <el-form-item label="校园用户id">
              <el-input placeholder="请输入校园用户id" v-model="yuyuepingjia.xyyiliaoyhid" clearable />
            </el-form-item>
            <el-form-item label="评价时间">
              <el-input placeholder="请输入评价时间" v-model="yuyuepingjia.pingjiashijian" clearable />
            </el-form-item>
            <el-form-item label="校园医生">
              <el-input placeholder="请输入校园医生" v-model="yuyuepingjia.xiaoyuanyisheng" clearable />
            </el-form-item>
            <el-form-item label="校园医生id">
              <el-input placeholder="请输入校园医生id" v-model="yuyuepingjia.xiaoyuanyishengid" clearable />
            </el-form-item>
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="updateYuyuepingjiaactJson()">
            ✨ 修改
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const updateYuyuepingjia = {
    components: {
    },
    data() {
      return {
        yuyuepingjia:{},
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
      updateYuyuepingjiaactJson() {
        var _this = this
        this.axios.post("/updateYuyuepingjiaactJson", _this.yuyuepingjia).then(res => {
          if (res.data.message == '修改预约评价成功') {
            _this.$toast.success("修改预约评价成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/yuyuepingjiaList"})
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
      this.axios.post("/updateYuyuepingjiaJson?id="+_this.$route.query.id).then(res=>{
        _this.yuyuepingjia = res.data.yuyuepingjia
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default updateYuyuepingjia
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


