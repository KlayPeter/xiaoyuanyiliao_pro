<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">修改预约对话</h2>
      <el-form label-width="100px" class="form">

        <el-form-item style="display: none" label="预约对话id">
          <el-input v-model="yuyueduihua.id" />
        </el-form-item>
            <el-form-item label="排班预约">
              <el-input placeholder="请输入排班预约" v-model="yuyueduihua.xyyiliaopaibanyuyue" clearable />
            </el-form-item>
            <el-form-item label="排班预约id">
              <el-input placeholder="请输入排班预约id" v-model="yuyueduihua.xyyiliaopaibanyuyueid" clearable />
            </el-form-item>
            <el-form-item label="消息">
              <el-input placeholder="请输入消息" v-model="yuyueduihua.message" clearable />
            </el-form-item>
            <el-form-item label="对话用户">
              <el-input placeholder="请输入对话用户" v-model="yuyueduihua.duihuauser" clearable />
            </el-form-item>
            <el-form-item label="对话用户id">
              <el-input placeholder="请输入对话用户id" v-model="yuyueduihua.duihuauserid" clearable />
            </el-form-item>
            <el-form-item label="对话角色">
              <el-input placeholder="请输入对话角色" v-model="yuyueduihua.duihuauserrole" clearable />
            </el-form-item>
            <el-form-item label="对话用户照片">
              <div class="avatar-frame">
                <el-upload
                        ref="duihuauserimgUpload"
                        class="img-uploader"
                        action=""
                        :limit="1"
                        :auto-upload="false"
                        :show-file-list="false"
                        :on-change="changeDuihuauserimgFile"
                >
                  <div class="img-uploader-content">
                    <template v-if="!yuyueduihua.duihuauserimg">
                      <Plus style="margin-right: 5px;" />
                      <span>点击上传图片</span>
                    </template>

                    <template v-else>
                      <img :src="yuyueduihua.duihuauserimg && yuyueduihua.duihuauserimg.includes('http') ? yuyueduihua.duihuauserimg : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + yuyueduihua.duihuauserimg" alt="上传图片"
                              class="preview-img"
                      />
                    </template>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
            <el-form-item label="发布时间">
              <el-input placeholder="请输入发布时间" v-model="yuyueduihua.duihuauseraddtime" clearable />
            </el-form-item>
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="updateYuyueduihuaactJson()">
            ✨ 修改
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const updateYuyueduihua = {
    components: {
    },
    data() {
      return {
        yuyueduihua:{},
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
      async changeDuihuauserimgFile(event) {
        // 清空文件选择器，防止连续选择相同文件不触发
        this.$refs.duihuauserimgUpload.clearFiles();
        // 上传文件
        this.yuyueduihua.duihuauserimg = await this.uploadFile(event.raw);
      },
      updateYuyueduihuaactJson() {
        var _this = this
        this.axios.post("/updateYuyueduihuaactJson", _this.yuyueduihua).then(res => {
          if (res.data.message == '修改预约对话成功') {
            _this.$toast.success("修改预约对话成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/yuyueduihuaList"})
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
      this.axios.post("/updateYuyueduihuaJson?id="+_this.$route.query.id).then(res=>{
        _this.yuyueduihua = res.data.yuyueduihua
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default updateYuyueduihua
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


