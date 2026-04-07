<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header">修改校园体检事项</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="校园体检事项id">
                    <el-input v-model="xytijianshixiang.id" />
                </el-form-item>
                        <el-form-item label="体检标题">
                            <el-input placeholder="请输入体检标题" v-model="xytijianshixiang.tijiant" clearable />
                        </el-form-item>
                        <el-form-item label="体检内容">
                            <el-input placeholder="请输入体检内容" v-model="xytijianshixiang.tijiancontent" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="体检注意事项">
                            <el-input placeholder="请输入体检注意事项" v-model="xytijianshixiang.tijianzhuyi" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="体检位置">
                            <el-input placeholder="请输入体检位置" v-model="xytijianshixiang.tijianadress" type="textarea" clearable />
                        </el-form-item>
                        <el-form-item label="体检时间">
                            <el-col :span="11">
                                <el-date-picker v-model="xytijianshixiang.tijiantime"
                                                type="date"
                                                placeholder="Pick a date"
                                                style="width: 100%"
                                                value-format="YYYY-MM-DD"
                                />
                            </el-col>
                        </el-form-item>
                        <el-form-item label="封面">
                            <div class="avatar-frame">
                                <el-upload
                                        ref="tijianimgUpload"
                                        class="img-uploader"
                                        action=""
                                        :limit="1"
                                        :auto-upload="false"
                                        :show-file-list="false"
                                        :on-change="changeTijianimgFile"
                                >
                                    <div class="img-uploader-content">
                                        <template v-if="!xytijianshixiang.tijianimg">
                                            <Plus style="margin-right: 5px;" />
                                            <span>点击上传图片</span>
                                        </template>

                                        <template v-else>
                                            <img :src="xytijianshixiang.tijianimg && xytijianshixiang.tijianimg.includes('http') ? xytijianshixiang.tijianimg : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + xytijianshixiang.tijianimg" alt="上传图片"
                                                    class="preview-img"
                                            />
                                        </template>
                                    </div>
                                </el-upload>
                            </div>
                        </el-form-item>
<!--                        <el-form-item label="负责医生">-->
<!--                            <el-input placeholder="请输入负责医生" v-model="xytijianshixiang.xiaoyuanyisheng" clearable />-->
<!--                        </el-form-item>-->
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="xiaoyuanyishengUpdateXytijianshixiangactJson()">
                        ✨ 修改
                    </el-button>
                    <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const xiaoyuanyishengUpdateXytijianshixiang = {
    components: {
    },
    data() {
      return {
        xytijianshixiang:{},
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
      async changeTijianimgFile(event) {
        // 清空文件选择器，防止连续选择相同文件不触发
        this.$refs.tijianimgUpload.clearFiles();
        // 上传文件
        this.xytijianshixiang.tijianimg = await this.uploadFile(event.raw);
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
      xiaoyuanyishengUpdateXytijianshixiangactJson() {
        var _this = this

        this.axios.post("/xiaoyuanyishengUpdateXytijianshixiangactJson", _this.xytijianshixiang).then(res => {
          if (res.data.message == '修改校园体检事项成功') {
            _this.$toast.success("修改校园体检事项成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xiaoyuanyishengXytijianshixiangList"})
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
      this.axios.post("/xiaoyuanyishengUpdateXytijianshixiangJson?id="+this.$route.query.id,).then(res=>{
        _this.xytijianshixiang = res.data.xytijianshixiang
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengUpdateXytijianshixiang
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


