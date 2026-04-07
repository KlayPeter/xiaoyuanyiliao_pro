<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header">添加挂号咨询结果</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="挂号咨询结果id">
                    <el-input v-model="guahaozixunjieguo.id" />
                </el-form-item>
                        <el-form-item label="开方时间">
                            <el-input placeholder="请输入开方时间" v-model="guahaozixunjieguo.kaifangtime" clearable />
                        </el-form-item>
                        <el-form-item label="用户症状描述">
                            <el-input placeholder="请输入用户症状描述" v-model="guahaozixunjieguo.zhusu" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="用户体温">
                            <el-input placeholder="请输入用户体温" v-model="guahaozixunjieguo.yonghutiwen" clearable />
                        </el-form-item>
                        <el-form-item label="心率">
                            <el-input placeholder="请输入心率" v-model="guahaozixunjieguo.xinlv" clearable />
                        </el-form-item>
                        <el-form-item label="诊断结果">
                            <el-input placeholder="请输入诊断结果" v-model="guahaozixunjieguo.zhenduan" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="休息建议">
                            <el-input placeholder="请输入休息建议" v-model="guahaozixunjieguo.xiuxijiany" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="用药">
                            <el-input placeholder="请输入用药" v-model="guahaozixunjieguo.yongyao" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="校园医生">
                            <el-input placeholder="请输入校园医生" v-model="guahaozixunjieguo.xiaoyuanyisheng" clearable />
                        </el-form-item>
                        <el-form-item label="校园医生id">
                            <el-input placeholder="请输入校园医生id" v-model="guahaozixunjieguo.xiaoyuanyishengid" clearable />
                        </el-form-item>
                        <el-form-item label="校园医疗用户">
                            <el-input placeholder="请输入校园医疗用户" v-model="guahaozixunjieguo.xyyiliaoyh" clearable />
                        </el-form-item>
                        <el-form-item label="校园医疗用户id">
                            <el-input placeholder="请输入校园医疗用户id" v-model="guahaozixunjieguo.xyyiliaoyhid" clearable />
                        </el-form-item>
                        <el-form-item label="排班预约">
                            <el-input placeholder="请输入排班预约" v-model="guahaozixunjieguo.xyyiliaopaibanyuyue" clearable />
                        </el-form-item>
                        <el-form-item label="排班预约id">
                            <el-input placeholder="请输入排班预约id" v-model="guahaozixunjieguo.xyyiliaopaibanyuyueid" clearable />
                        </el-form-item>
                        <el-form-item label="药品价格">
                            <el-input placeholder="请输入药品价格" v-model="guahaozixunjieguo.price" clearable />
                        </el-form-item>
                        <el-form-item label="状态">
                            <el-input placeholder="请输入状态" v-model="guahaozixunjieguo.state" clearable />
                        </el-form-item>
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="xyyiliaoyhAddGuahaozixunjieguoactJson">
                        ✨ 添加
                    </el-button>
                    <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const xyyiliaoyhAddGuahaozixunjieguo = {
    components: {

    },
    data() {
      return {
        guahaozixunjieguo:{
          kaifangtime:"",
          zhusu:"",
          yonghutiwen:"",
          xinlv:"",
          zhenduan:"",
          xiuxijiany:"",
          yongyao:"",
          xiaoyuanyisheng:"",
          xiaoyuanyishengid:null,
          xyyiliaoyh:"",
          xyyiliaoyhid:null,
          xyyiliaopaibanyuyue:"",
          xyyiliaopaibanyuyueid:null,
          price:"",
          state:"",
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
      xyyiliaoyhAddGuahaozixunjieguoactJson() {
        var _this = this
        this.axios.post("/xyyiliaoyhAddGuahaozixunjieguoactJson", _this.guahaozixunjieguo).then(res => {
          if (res.data.message == '添加挂号咨询结果成功') {
            _this.$toast.success("添加挂号咨询结果成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xyyiliaoyhguahaozixunjieguoList"})
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

      this.guahaozixunjieguo.xyyiliaoyhid = userinfo.id
      this.guahaozixunjieguo.xyyiliaoyh = userinfo.username
      this.axios.post("/xyyiliaoyhAddGuahaozixunjieguoJson").then(res=>{
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xyyiliaoyhAddGuahaozixunjieguo
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


