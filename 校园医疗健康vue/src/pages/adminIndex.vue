<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header"> 管理员个人中心</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="管理员id">
                    <el-input v-model="admin.id" />
                </el-form-item>
                        <el-form-item label="账号">
                            <el-input placeholder="请输入账号" v-model="admin.username" clearable />
                        </el-form-item>
                        <el-form-item label="密码">
                            <el-input placeholder="请输入密码" v-model="admin.password" clearable />
                        </el-form-item>
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="adminUpdateIndexJson">
                        ✨ 修改
                    </el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const adminIndex = {
    components: {

    },
    data() {
      return {
        admin: {},
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
      adminUpdateIndexJson() {
        var _this = this
        this.axios.post("/adminUpdateIndexJson", _this.admin).then(res => {
          if (res.data.message == '更新成功') {
            localStorage.setItem("userinfo",JSON.stringify(_this.admin))
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
      this.admin = JSON.parse(localStorage.getItem("userinfo"))
      this.axios.post("/adminIndexJson").then(res=>{
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default adminIndex
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
</style>


