<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header"> 校园医生个人中心</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="校园医生id">
                    <el-input v-model="xiaoyuanyisheng.id" />
                </el-form-item>
                        <el-form-item label="账号">
                            <el-input placeholder="请输入账号" v-model="xiaoyuanyisheng.username" clearable />
                        </el-form-item>
                        <el-form-item label="密码">
                            <el-input placeholder="请输入密码" v-model="xiaoyuanyisheng.password" clearable />
                        </el-form-item>
                        <el-form-item label="医生姓名">
                            <el-input placeholder="请输入医生姓名" v-model="xiaoyuanyisheng.schoolyishengname" clearable />
                        </el-form-item>
                            <el-form-item label="医生性别">
                                <el-select v-model="xiaoyuanyisheng.schoolyssex" >
                                        <el-option label="男" value="男" />
                                        <el-option label="女" value="女" />
                                </el-select>
                            </el-form-item>
                        <el-form-item label="医生年龄">
                            <el-input placeholder="请输入医生年龄" v-model="xiaoyuanyisheng.schoolysage" clearable />
                        </el-form-item>
                        <el-form-item label="医生联系电话">
                            <el-input placeholder="请输入医生联系电话" v-model="xiaoyuanyisheng.schoolysphone" clearable />
                        </el-form-item>
                        <el-form-item label="医生头像">
                            <div class="avatar-frame">
                                <el-upload
                                        ref="schoolysavaatorUpload"
                                        class="img-uploader"
                                        action=""
                                        :limit="1"
                                        :auto-upload="false"
                                        :show-file-list="false"
                                        :on-change="changeSchoolysavaatorFile"
                                >
                                    <div class="img-uploader-content">
                                        <template v-if="!xiaoyuanyisheng.schoolysavaator">
                                            <Plus style="margin-right: 5px;" />
                                            <span>点击上传图片</span>
                                        </template>

                                        <template v-else>
                                            <img :src="xiaoyuanyisheng.schoolysavaator && xiaoyuanyisheng.schoolysavaator.includes('http') ? xiaoyuanyisheng.schoolysavaator : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + xiaoyuanyisheng.schoolysavaator" alt="上传图片"
                                                    class="preview-img"
                                            />
                                        </template>
                                    </div>
                                </el-upload>
                            </div>
                        </el-form-item>
                        <el-form-item label="医生简介">
                          <wang-editor v-model="xiaoyuanyisheng.schoolysjianjie"></wang-editor>
<!--                            <el-input placeholder="请输入医生简介" v-model="xiaoyuanyisheng.schoolysjianjie" type="textarea" clearable />-->
                        </el-form-item>
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="xiaoyuanyishengUpdateIndexJson">
                        ✨ 修改
                    </el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  import WangEditor from "@/component/WangEditor.vue";

  const xiaoyuanyishengIndex = {
    components: {
      WangEditor

    },
    data() {
      return {
        xiaoyuanyisheng: {},
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
      async changeSchoolysavaatorFile(event) {
        // 清空文件选择器，防止连续选择相同文件不触发
        this.$refs.schoolysavaatorUpload.clearFiles();
        // 上传文件
        this.xiaoyuanyisheng.schoolysavaator = await this.uploadFile(event.raw);
      },
      xiaoyuanyishengUpdateIndexJson() {
        var _this = this
        this.axios.post("/xiaoyuanyishengUpdateIndexJson", _this.xiaoyuanyisheng).then(res => {
          if (res.data.message == '更新成功') {
            localStorage.setItem("userinfo",JSON.stringify(_this.xiaoyuanyisheng))
            _this.$toast.success("更新成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
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
      let _this = this
      this.xiaoyuanyisheng = JSON.parse(localStorage.getItem("userinfo"))
      this.axios.post("/xiaoyuanyishengIndexJson").then(res=>{
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengIndex
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


