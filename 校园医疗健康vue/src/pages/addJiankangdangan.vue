<template>
  <div class="anime-page">
    <div class="anime-card">
      <h2 class="page-header">添加体测档案</h2>
      <el-form label-width="100px" class="form">

        <el-form-item style="display: none" label="档案id">
          <el-input v-model="jiankangdangan.id" />
        </el-form-item>
        <el-form-item label="测试学年">
          <el-col :span="11">
            <el-select v-model="jiankangdangan.shijian" placeholder="请选择学年">
                <el-option label="一年级" value="一年级"></el-option>
                <el-option label="二年级" value="二年级"></el-option>
                <el-option label="三年级" value="三年级"></el-option>
                <el-option label="四年级" value="四年级"></el-option>
            </el-select>
          </el-col>
        </el-form-item>
        <el-form-item label="总分">
          <el-input type="number" placeholder="请输入总分" v-model="jiankangdangan.zongfen" clearable />
        </el-form-item>
        <el-form-item label="身高(cm)">
          <el-input type="number" placeholder="请输入身高" v-model="jiankangdangan.height" @change="calcBmi" clearable />
        </el-form-item>
        <el-form-item label="体重(kg)">
          <el-input type="number" placeholder="请输入体重" v-model="jiankangdangan.weight" @change="calcBmi" clearable />
        </el-form-item>
        <el-form-item label="肺活量(ml)">
          <el-input type="number" placeholder="请输入肺活量" v-model="jiankangdangan.feihuoliang" clearable />
        </el-form-item>
        <el-form-item label="坐位体前屈(cm)">
          <el-input placeholder="请输入坐位体前屈" v-model="jiankangdangan.zuoweitiqianqu" clearable />
        </el-form-item>
        <el-form-item label="立定跳远(cm)">
          <el-input type="number" placeholder="请输入立定跳远" v-model="jiankangdangan.lidingtiaoyuan" clearable />
        </el-form-item>
        <el-form-item label="引体向上(个)">
          <el-input type="number" placeholder="请输入引体向上(男)/仰卧起坐(女)" v-model="jiankangdangan.yintixiangshang" clearable />
        </el-form-item>
        <el-form-item label="50米跑(s)">
          <el-input type="number" placeholder="请输入50米成绩" v-model="jiankangdangan.wushimi" clearable />
        </el-form-item>
        <el-form-item label="1000米跑(s)">
          <el-input type="number" placeholder="请输入800m(女)/1000m(男)" v-model="jiankangdangan.yiqianmi" clearable />
        </el-form-item>
<!--            <el-form-item label="校园医疗用户">-->
<!--              <el-input placeholder="请输入校园医疗用户" v-model="jiankangdangan.xyyiliaoyh" clearable />-->
<!--            </el-form-item>-->
<!--            <el-form-item label="校园医疗用户id">-->
<!--              <el-input placeholder="请输入校园医疗用户id" v-model="jiankangdangan.xyyiliaoyhid" clearable />-->
<!--            </el-form-item>-->
        <el-form-item class="form-footer">
          <el-button type="primary" size="large" class="anime-btn" @click="addJiankangdanganactJson()">
            ✨ 添加/导入
          </el-button>
          <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  const addJiankangdangan = {
    components: {
    },
    data() {
      return {
        jiankangdangan:{
          shijian:"",
          zongfen:"",
          height:"",
          weight:"",
          feihuoliang:"",
          zuoweitiqianqu:"",
          lidingtiaoyuan:"",
          yintixiangshang:"",
          wushimi:"",
          yiqianmi:"",
          xyyiliaoyh:"",
          xyyiliaoyhid:null,

        },
        tijianyuyue:{}
      }
    },
    methods: {
      calcBmi() {
        const h = parseFloat(this.jiankangdangan.height || '')
        const w = parseFloat(this.jiankangdangan.weight || '')
        if (!h || !w || h <= 0 || w <= 0) {
          this.jiankangdangan.bmi = ''
          return
        }
        const meterHeight = h / 100
        const bmi = w / (meterHeight * meterHeight)
        this.jiankangdangan.bmi = bmi ? bmi.toFixed(1) : ''
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
      addJiankangdanganactJson() {
        var _this = this
        this.axios.post("/addJiankangdanganactJson?yuyueid="+this.tijianyuyue.id, _this.jiankangdangan).then(res => {
          if (res.data.message == '添加体测档案成功') {
            _this.$toast.success("添加体测档案成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/tijianyhyuyueList",query:{id:this.tijianyuyue.xytijianshixiangid}})
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
      this.axios.post("/addJiankangdanganJson").then(res=>{

      })
      this.tijianyuyue = JSON.parse(localStorage.getItem("tijianyuyue"))
      this.jiankangdangan.shijian = this.getNowTime()
      this.jiankangdangan.xyyiliaoyh = this.tijianyuyue.xyyiliaoyh
      this.jiankangdangan.xyyiliaoyhid = this.tijianyuyue.xyyiliaoyhid
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default addJiankangdangan
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


