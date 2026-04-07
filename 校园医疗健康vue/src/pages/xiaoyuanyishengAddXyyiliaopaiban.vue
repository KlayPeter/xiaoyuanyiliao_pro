<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header">添加校园医疗排班</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="校园医疗排班id">
                    <el-input v-model="xyyiliaopaiban.id" />
                </el-form-item>
                        <el-form-item label="排班月份">
                            <el-input placeholder="请输入排班月份" v-model="xyyiliaopaiban.yuefen" clearable />
                        </el-form-item>

                        <el-form-item label="备注">
                            <el-input placeholder="请输入备注" v-model="xyyiliaopaiban.remark" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="创建时间">
                            <el-input readonly  v-model="xyyiliaopaiban.chuangjiantime"/>
                        </el-form-item>
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="xiaoyuanyishengAddXyyiliaopaibanactJson">
                        ✨ 添加
                    </el-button>
                    <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const xiaoyuanyishengAddXyyiliaopaiban = {
    components: {

    },
    data() {
      return {
        xyyiliaopaiban:{
          yuefen:"",
          xiaoyuanyisheng:"",
          xiaoyuanyishengid:null,
          remark:"",
          chuangjiantime:"",
        },
        xiaoyuanyishengs:[],
      }
    },
    methods: {
      changeXiaoyuanyisheng(event){
        var _this = this
        this.xyyiliaopaiban.xiaoyuanyisheng = this.xiaoyuanyishengs.filter(item =>{
          return item.id == _this.xyyiliaopaiban.xiaoyuanyishengid
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
      xiaoyuanyishengAddXyyiliaopaibanactJson() {
        var _this = this
        this.axios.post("/xiaoyuanyishengAddXyyiliaopaibanactJson", _this.xyyiliaopaiban).then(res => {
          if (res.data.message == '添加校园医疗排班成功') {
            _this.$toast.success("添加校园医疗排班成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xiaoyuanyishengxyyiliaopaibanList"})
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

      this.xyyiliaopaiban.xiaoyuanyishengid = userinfo.id
      this.xyyiliaopaiban.xiaoyuanyisheng = userinfo.username
      this.axios.post("/xiaoyuanyishengAddXyyiliaopaibanJson").then(res=>{
        _this.xiaoyuanyishengs = res.data.xiaoyuanyishengs
      })
      this.xyyiliaopaiban.chuangjiantime = this.getNowTime()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengAddXyyiliaopaiban
</script>
<style scoped>
    /* 表单外观 - 椭圆背景 */
    .form {
        max-width: 600px;
        margin: 0 auto;
        background: #fffaf5;
        padding: 30px 40px;
        border-radius: 50px; /* 椭圆感 */
        box-shadow: 0 6px 20px rgba(255, 160, 122, 0.15);
        border: 1px solid #ffe5d0;
    }

    /* 标题 */
    .page-header {
        font-size: 22px;
        font-weight: bold;
        margin-bottom: 20px;
        text-align: center;
        color: #ff7f50;
        letter-spacing: 1px;
    }

    /* 圆润输入框 */
    .el-input {
        border-radius: 25px;
    }
    .el-input__inner {
        border: 2px solid #ffe0c2;
        height: 40px;
        transition: all 0.3s ease;
    }
    .el-input__inner:focus {
        border-color: #ffb38a;
        background-color: #fff9f5;
        box-shadow: 0 0 6px rgba(255, 160, 122, 0.3);
    }

    /* 头像上传区 */
    .avatar-uploader .avatar {
        width: 110px;
        height: 110px;
        border-radius: 50%;
        display: block;
    }
    .avatar-uploader .el-upload {
        border: 2px dashed #ffd6b0;
        border-radius: 50%;
        cursor: pointer;
        overflow: hidden;
        width: 110px;
        height: 110px;
        background-color: #fff9f5;
        transition: all 0.3s ease;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #ffb38a;
        background-color: #fff5ef;
    }

    /* 十字按钮换成动漫风圆形按钮 */
    .avatar-uploader-icon {
        width: 110px;
        height: 110px;
        font-size: 32px;
        background: #ffe7d4;
        color: #ff8c69;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        position: relative;
        transition: all 0.3s ease;
    }
    .avatar-uploader-icon:hover {
        background: #ffd6b0;
        color: #ff6f61;
        transform: scale(1.05);
    }
    .avatar-uploader-icon input {
        opacity: 0;
        position: absolute;
        width: 110px;
        height: 110px;
        cursor: pointer;
    }

    /* 按钮 */
    .el-button {
        border-radius: 25px;
        font-weight: bold;
        padding: 0 25px;
        transition: all 0.3s ease;
    }
    .el-button--primary {
        background-color: #ffb38a;
        border-color: #ffb38a;
    }
    .el-button--primary:hover {
        background-color: #ff9e6e;
        border-color: #ff9e6e;
    }
    .el-button--default {
        background-color: #fff0e6;
        border: none;
        color: #ff8c69;
    }
    .el-button--default:hover {
        background-color: #ffe2cf;
    }
    .file-uploader {
        border: 2px dashed #ffd6b0;
        border-radius: 12px;
        cursor: pointer;
        background: #fff9f5;
        transition: all 0.3s ease;
        width: 260px;
        height: 60px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .file-uploader:hover {
        border-color: #ffb38a;
        background-color: #fff5ef;
    }

    .file-uploader-placeholder {
        display: flex;
        align-items: center;
        justify-content: center;
        color: #ff8c69;
        font-size: 14px;
    }

    .file-link {
        color: #ff7f50;
        text-decoration: underline;
        font-size: 14px;
    }
    .file-link:hover {
        color: #ff6f61;
    }

    .change-hint {
        color: #aaa;
        font-size: 12px;
        margin-left: 5px;
    }
    .img-uploader {
        border: 2px dashed #ffd6b0;
        border-radius: 12px;
        cursor: pointer;
        background: #fff9f5;
        transition: all 0.3s ease;
        min-width: 200px;
        min-height: 130px;
        height: 100%;
        width: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .img-uploader:hover {
        border-color: #ffb38a;
        background-color: #fff5ef;
    }

    .img-uploader-content {
        display: flex;
        align-items: center;
        justify-content: center;
        color: #ff8c69;
        font-size: 14px;
        flex-direction: column;
    }

    .preview-img {
        max-width: 185px;
        max-height: 100px;
        border-radius: 8px;
        margin-bottom: 4px;
    }

    .change-hint {
        color: #aaa;
        font-size: 12px;
    }
</style>


