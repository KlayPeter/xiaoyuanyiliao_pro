<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header">修改体测档案</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="档案id">
                    <el-input v-model="jiankangdangan.id" />
                </el-form-item>
                        <el-form-item label="测试时间">
                            <el-input placeholder="请输入测试时间" v-model="jiankangdangan.shijian" clearable />
                        </el-form-item>
                        <el-form-item label="身高(cm)">
                            <el-input placeholder="请输入身高(cm)" v-model="jiankangdangan.height" clearable />
                        </el-form-item>
                        <el-form-item label="体重(kg)">
                            <el-input placeholder="请输入体重(kg)" v-model="jiankangdangan.weight" clearable />
                        </el-form-item>
                        <el-form-item label="bmi数值">
                            <el-input placeholder="请输入bmi数值" v-model="jiankangdangan.bmi" clearable />
                        </el-form-item>
                        <el-form-item label="50m成绩(s)">
                            <el-input placeholder="请输入左眼视力" v-model="jiankangdangan.wushimichengji" clearable />
                        </el-form-item>
                        <el-form-item label="800m成绩(s)">
                            <el-input placeholder="请输入右眼视力" v-model="jiankangdangan.babaimichengji" clearable />
                        </el-form-item>
                        <el-form-item label="肺活量(ml)">
                            <el-input placeholder="请输入肺活量" v-model="jiankangdangan.feihuoliang" clearable />
                        </el-form-item>
                        <el-form-item label="立定跳远成绩">
                            <el-input placeholder="请输入立定跳远成绩" v-model="jiankangdangan.lidingtiaoyuan" clearable />
                        </el-form-item>
                        <el-form-item label="一百米 成绩">
                            <el-input placeholder="请输入一百米 成绩" v-model="jiankangdangan.yangwoqizuo" clearable />
                        </el-form-item>
                        <el-form-item label="校园医疗用户">
                            <el-input placeholder="请输入校园医疗用户" v-model="jiankangdangan.xyyiliaoyh" clearable />
                        </el-form-item>
                        <el-form-item label="校园医疗用户id">
                            <el-input placeholder="请输入校园医疗用户id" v-model="jiankangdangan.xyyiliaoyhid" clearable />
                        </el-form-item>
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="xyyiliaoyhUpdateJiankangdanganactJson()">
                        ✨ 修改
                    </el-button>
                    <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const xyyiliaoyhUpdateJiankangdangan = {
    components: {
    },
    data() {
      return {
        jiankangdangan:{},
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
      xyyiliaoyhUpdateJiankangdanganactJson() {
        var _this = this

        this.axios.post("/xyyiliaoyhUpdateJiankangdanganactJson", _this.jiankangdangan).then(res => {
          if (res.data.message == '修改体测档案成功') {
            _this.$toast.success("修改体测档案成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xyyiliaoyhJiankangdanganList"})
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
      this.axios.post("/xyyiliaoyhUpdateJiankangdanganJson?id="+this.$route.query.id,).then(res=>{
        _this.jiankangdangan = res.data.jiankangdangan
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xyyiliaoyhUpdateJiankangdangan
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


