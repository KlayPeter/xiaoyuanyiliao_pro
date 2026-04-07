<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header">修改校园医疗排班</h2>
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
                    <el-button type="primary" size="large" class="anime-btn" @click="xiaoyuanyishengUpdateXyyiliaopaibanactJson()">
                        ✨ 修改
                    </el-button>
                    <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const xiaoyuanyishengUpdateXyyiliaopaiban = {
    components: {
    },
    data() {
      return {
        xyyiliaopaiban:{},
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
      xiaoyuanyishengUpdateXyyiliaopaibanactJson() {
        var _this = this

        this.axios.post("/xiaoyuanyishengUpdateXyyiliaopaibanactJson", _this.xyyiliaopaiban).then(res => {
          if (res.data.message == '修改校园医疗排班成功') {
            _this.$toast.success("修改校园医疗排班成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xiaoyuanyishengXyyiliaopaibanList"})
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
      this.axios.post("/xiaoyuanyishengUpdateXyyiliaopaibanJson?id="+this.$route.query.id,).then(res=>{
        _this.xyyiliaopaiban = res.data.xyyiliaopaiban
        _this.xiaoyuanyishengs = res.data.xiaoyuanyishengs
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengUpdateXyyiliaopaiban
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


