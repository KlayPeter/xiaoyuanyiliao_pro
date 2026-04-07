<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">添加校园医疗药品</h2>
      <el-form label-width="100px" class="form">

        <el-form-item style="display: none" label="药品id">
          <el-input v-model="xyyiliaoyaoping.id" />
        </el-form-item>
            <el-form-item label="药品名称">
              <el-input placeholder="请输入药品名称" v-model="xyyiliaoyaoping.drugname" clearable />
            </el-form-item>
            <el-form-item label="生产厂家">
              <el-input placeholder="请输入生产厂家" v-model="xyyiliaoyaoping.shengchanchangjia" clearable />
            </el-form-item>
              <el-form-item label="单位">
                <el-select v-model="xyyiliaoyaoping.danwei" >
                    <el-option label="片" value="片" />
                    <el-option label="瓶" value="瓶" />
                    <el-option label="袋" value="袋" />
                </el-select>
              </el-form-item>
              <el-form-item label="药品分类">
                <el-select v-model="xyyiliaoyaoping.yaopingfenlei" >
                    <el-option label="中药" value="中药" />
                    <el-option label="西药" value="西药" />
                    <el-option label="抗生素" value="抗生素" />
                </el-select>
              </el-form-item>
            <el-form-item label="库存">
              <el-input type="number" placeholder="请输入库存" v-model="xyyiliaoyaoping.kucun" clearable />
            </el-form-item>
            <el-form-item label="价格">
              <el-input type="number" placeholder="请输入价格" v-model="xyyiliaoyaoping.price" clearable />
            </el-form-item>
            <el-form-item label="提醒库存">
              <el-input type="number" placeholder="请输入提醒库存" v-model="xyyiliaoyaoping.tixingkucun" clearable />
            </el-form-item>
            <el-form-item label="说明">
              <el-input placeholder="请输入说明" v-model="xyyiliaoyaoping.shuoming" type="textarea" clearable />
            </el-form-item>
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="addXyyiliaoyaopingactJson()">
            ✨ 添加
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const addXyyiliaoyaoping = {
    components: {
    },
    data() {
      return {
        xyyiliaoyaoping:{

          drugname:"",


          shengchanchangjia:"",


          danwei:"",


          yaopingfenlei:"",


          kucun:"",


          price:"",


          tixingkucun:"",


          shuoming:"",

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
      addXyyiliaoyaopingactJson() {
        var _this = this
        this.axios.post("/addXyyiliaoyaopingactJson", _this.xyyiliaoyaoping).then(res => {
          if (res.data.message == '添加校园医疗药品成功') {
            _this.$toast.success("添加校园医疗药品成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xyyiliaoyaopingList"})
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
      this.axios.post("/addXyyiliaoyaopingJson").then(res=>{
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default addXyyiliaoyaoping
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


