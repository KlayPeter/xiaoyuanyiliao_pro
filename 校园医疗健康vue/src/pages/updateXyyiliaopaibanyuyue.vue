<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">修改校园医疗排班预约</h2>
      <el-form label-width="100px" class="form">

        <el-form-item style="display: none" label="预约id">
          <el-input v-model="xyyiliaopaibanyuyue.id" />
        </el-form-item>
            <el-form-item label="简要问题描述">
              <el-input placeholder="请输入简要问题描述" v-model="xyyiliaopaibanyuyue.jianyaowenti" clearable />
            </el-form-item>
                <el-form-item label="校园医生">
                  <el-select  v-model="xyyiliaopaibanyuyue.xiaoyuanyishengid" @change="changeXiaoyuanyisheng($event)" >
                    <el-option v-for="(xiaoyuanyisheng,index) in xiaoyuanyishengs" :label="xiaoyuanyisheng.username"  :value="xiaoyuanyisheng.id" />
                  </el-select>
                </el-form-item>
            <el-form-item label="校园医生照片">
              <div class="avatar-frame">
                <el-upload
                        ref="xiaoyuanyishengimgUpload"
                        class="img-uploader"
                        action=""
                        :limit="1"
                        :auto-upload="false"
                        :show-file-list="false"
                        :on-change="changeXiaoyuanyishengimgFile"
                >
                  <div class="img-uploader-content">
                    <template v-if="!xyyiliaopaibanyuyue.xiaoyuanyishengimg">
                      <Plus style="margin-right: 5px;" />
                      <span>点击上传图片</span>
                    </template>

                    <template v-else>
                      <img :src="xyyiliaopaibanyuyue.xiaoyuanyishengimg && xyyiliaopaibanyuyue.xiaoyuanyishengimg.includes('http') ? xyyiliaopaibanyuyue.xiaoyuanyishengimg : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + xyyiliaopaibanyuyue.xiaoyuanyishengimg" alt="上传图片"
                              class="preview-img"
                      />
                    </template>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
                <el-form-item label="校园用户">
                  <el-select  v-model="xyyiliaopaibanyuyue.xyyiliaoyhid" @change="changeXyyiliaoyh($event)" >
                    <el-option v-for="(xyyiliaoyh,index) in xyyiliaoyhs" :label="xyyiliaoyh.username"  :value="xyyiliaoyh.id" />
                  </el-select>
                </el-form-item>
            <el-form-item label="校园用户照片">
              <div class="avatar-frame">
                <el-upload
                        ref="xyyiliaoyhimgUpload"
                        class="img-uploader"
                        action=""
                        :limit="1"
                        :auto-upload="false"
                        :show-file-list="false"
                        :on-change="changeXyyiliaoyhimgFile"
                >
                  <div class="img-uploader-content">
                    <template v-if="!xyyiliaopaibanyuyue.xyyiliaoyhimg">
                      <Plus style="margin-right: 5px;" />
                      <span>点击上传图片</span>
                    </template>

                    <template v-else>
                      <img :src="xyyiliaopaibanyuyue.xyyiliaoyhimg && xyyiliaopaibanyuyue.xyyiliaoyhimg.includes('http') ? xyyiliaopaibanyuyue.xyyiliaoyhimg : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + xyyiliaopaibanyuyue.xyyiliaoyhimg" alt="上传图片"
                              class="preview-img"
                      />
                    </template>
                  </div>
                </el-upload>
              </div>
            </el-form-item>
            <el-form-item label="预约日期">
              <el-input placeholder="请输入预约日期" v-model="xyyiliaopaibanyuyue.yuyuetime" clearable />
            </el-form-item>
              <el-form-item label="类型">
                <el-select v-model="xyyiliaopaibanyuyue.typea" >
                    <el-option label="线上" value="线上" />
                    <el-option label="线下" value="线下" />
                </el-select>
              </el-form-item>
            <el-form-item label="状态">
              <el-input placeholder="请输入状态" v-model="xyyiliaopaibanyuyue.state" clearable />
            </el-form-item>
            <el-form-item label="创建时间">
              <el-input placeholder="请输入创建时间" v-model="xyyiliaopaibanyuyue.addtime" clearable />
            </el-form-item>
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="updateXyyiliaopaibanyuyueactJson()">
            ✨ 修改
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const updateXyyiliaopaibanyuyue = {
    components: {
    },
    data() {
      return {
        xyyiliaopaibanyuyue:{},
        xiaoyuanyishengs:[],
        xyyiliaoyhs:[],
      }
    },
    methods: {
      changeXiaoyuanyisheng(event){
        var _this = this
        this.xyyiliaopaibanyuyue.xiaoyuanyisheng = this.xiaoyuanyishengs.filter(item =>{
          return item.id == _this.xyyiliaopaibanyuyue.xiaoyuanyishengid
        })[0].username
      },
      changeXyyiliaoyh(event){
        var _this = this
        this.xyyiliaopaibanyuyue.xyyiliaoyh = this.xyyiliaoyhs.filter(item =>{
          return item.id == _this.xyyiliaopaibanyuyue.xyyiliaoyhid
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
      async changeXiaoyuanyishengimgFile(event) {
        // 清空文件选择器，防止连续选择相同文件不触发
        this.$refs.xiaoyuanyishengimgUpload.clearFiles();
        // 上传文件
        this.xyyiliaopaibanyuyue.xiaoyuanyishengimg = await this.uploadFile(event.raw);
      },
      async changeXyyiliaoyhimgFile(event) {
        // 清空文件选择器，防止连续选择相同文件不触发
        this.$refs.xyyiliaoyhimgUpload.clearFiles();
        // 上传文件
        this.xyyiliaopaibanyuyue.xyyiliaoyhimg = await this.uploadFile(event.raw);
      },
      updateXyyiliaopaibanyuyueactJson() {
        var _this = this
        this.axios.post("/updateXyyiliaopaibanyuyueactJson", _this.xyyiliaopaibanyuyue).then(res => {
          if (res.data.message == '修改校园医疗排班预约成功') {
            _this.$toast.success("修改校园医疗排班预约成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xyyiliaopaibanyuyueList"})
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
      this.axios.post("/updateXyyiliaopaibanyuyueJson?id="+_this.$route.query.id).then(res=>{
        _this.xyyiliaopaibanyuyue = res.data.xyyiliaopaibanyuyue
        _this.xiaoyuanyishengs = res.data.xiaoyuanyishengs
        _this.xyyiliaoyhs = res.data.xyyiliaoyhs
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default updateXyyiliaopaibanyuyue
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


