<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">添加校园医生</h2>
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
<!--              <el-input placeholder="请输入医生简介" v-model="xiaoyuanyisheng.schoolysjianjie" type="textarea" clearable />-->
            </el-form-item>
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="addXiaoyuanyishengactJson()">
            ✨ 添加
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import WangEditor from "@/component/WangEditor.vue";

  const addXiaoyuanyisheng = {
    components: {
      WangEditor
    },
    data() {
      return {
        xiaoyuanyisheng:{

          username:"",


          password:"",


          schoolyishengname:"",


          schoolyssex:"",


          schoolysage:"",


          schoolysphone:"",


          schoolysavaator:"",


          schoolysjianjie:"",

        },
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
      addXiaoyuanyishengactJson() {
        var _this = this
        this.axios.post("/addXiaoyuanyishengactJson", _this.xiaoyuanyisheng).then(res => {
          if (res.data.message == '添加校园医生成功') {
            _this.$toast.success("添加校园医生成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xiaoyuanyishengList"})
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
      this.axios.post("/addXiaoyuanyishengJson").then(res=>{
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default addXiaoyuanyisheng
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


