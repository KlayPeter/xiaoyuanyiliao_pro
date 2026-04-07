<template>
    <div class="anime-page">
        <div class="anime-card">
            <h2 class="page-header">添加挂号咨询结果</h2>
            <el-form label-width="100px" class="form">

                <el-form-item style="display: none" label="挂号咨询结果id">
                    <el-input v-model="guahaozixunjieguo.id" />
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
                          <el-select
                            v-model="selectedDrugIds"
                            multiple
                            filterable
                            placeholder="请选择开方药品"
                            style="width: 100%; margin-bottom: 10px;"
                            @change="onDrugsChange"
                          >
                            <el-option
                              v-for="drug in xyyiliaoyaopings"
                              :key="drug.id"
                              :label="`${drug.drugname}（${drug.price}元/${drug.danwei}）`"
                              :value="drug.id"
                            />
                          </el-select>
                          <div v-if="selectedDrugsDetails.length" class="drug-detail-list">
                            <div
                              v-for="drug in selectedDrugsDetails"
                              :key="drug.id"
                              class="drug-detail-item"
                            >
                              <span class="drug-info">
                                {{ drug.drugname }}（{{ drug.price }}元/{{ drug.danwei }}）
                              </span>
                              <el-input-number
                                v-model="drugQuantities[drug.id]"
                                :min="0"
                                :max="getDrugMax(drug)"
                                size="small"
                                @change="onDrugsChange"
                              />
                            </div>
                          </div>
                          <div class="selected-drugs-preview">
                            已选用药：{{ guahaozixunjieguo.yongyao || '暂无' }}
                          </div>
                        </el-form-item>
                        <el-form-item label="药品价格">
                            <el-input placeholder="系统根据用药自动计算" v-model="guahaozixunjieguo.price" readonly />
                        </el-form-item>
                <el-form-item class="form-footer">
                    <el-button type="primary" size="large" class="anime-btn" @click="xiaoyuanyishengAddGuahaozixunjieguoactJson">
                        ✨ 添加
                    </el-button>
                    <el-button size="large" class="anime-btn-cancel" @click="$router.back()">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
  const xiaoyuanyishengAddGuahaozixunjieguo = {
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
        xyyiliaoyaopings:[],
        selectedDrugIds:[],
        drugQuantities:{}
      }
    },
    computed: {
      selectedDrugsDetails() {
        const ids = this.selectedDrugIds || []
        return this.xyyiliaoyaopings.filter(drug => ids.includes(drug.id))
      }
    },
    methods: {
      getDrugMax(drug) {
        const stock = parseFloat(drug.kucun || 0)
        return isNaN(stock) || stock < 0 ? 0 : stock
      },
      onDrugsChange() {
        const ids = this.selectedDrugIds || []
        const selected = this.xyyiliaoyaopings.filter(drug => ids.includes(drug.id))

        // 初始化和清理数量
        selected.forEach(drug => {
          if (!this.drugQuantities[drug.id]) {
            const max = this.getDrugMax(drug)
            if (this.$set) {
              this.$set(this.drugQuantities, drug.id, max > 0 ? 1 : 0)
            } else {
              this.drugQuantities[drug.id] = max > 0 ? 1 : 0
            }
          }
        })
        Object.keys(this.drugQuantities).forEach(id => {
          const numericId = isNaN(Number(id)) ? id : Number(id)
          if (!ids.includes(numericId)) {
            delete this.drugQuantities[id]
          }
        })

        // 组装用药说明和总价
        let summaryList = []
        let totalPrice = 0
        selected.forEach(drug => {
          let qty = this.drugQuantities[drug.id]
          const max = this.getDrugMax(drug)
          if (qty == null || isNaN(qty)) {
            qty = max > 0 ? 1 : 0
          }
          if (qty > max) {
            qty = max
            if (this.$set) {
              this.$set(this.drugQuantities, drug.id, qty)
            } else {
              this.drugQuantities[drug.id] = qty
            }
          }
          if (qty <= 0) {
            return
          }
          const unitPrice = parseFloat(drug.price) || 0
          totalPrice += unitPrice * qty
          const unit = drug.danwei || ""
          summaryList.push(`${drug.drugname}×${qty}${unit} 单价${drug.price || ''}`)
        })

        this.guahaozixunjieguo.yongyao = summaryList.join('；')
        this.guahaozixunjieguo.price = totalPrice ? totalPrice.toFixed(2) : ""
      },
      handleDrugInventory() {
        const ids = this.selectedDrugIds || []
        if (!ids.length) {
          return
        }

        ids.forEach(id => {
          const drug = this.xyyiliaoyaopings.find(d => d.id === id)
          if (!drug) {
            return
          }
          const qty = this.drugQuantities[id] || 1
          const oldStock = parseFloat(drug.kucun || 0)
          const newStock = oldStock - qty
          const safeNewStock = newStock < 0 ? 0 : newStock

          const updatedDrug = Object.assign({}, drug, {
            kucun: String(safeNewStock)
          })

          this.axios.post("/updateXyyiliaoyaopingactJson", updatedDrug).then(() => {
            const remindStock = parseFloat(drug.tixingkucun || 0)
            if (safeNewStock < remindStock) {
              const tixing = {
                caigout: `药品库存预警：${drug.drugname}`,
                caigoucontent: `${drug.drugname}当前库存${safeNewStock}${drug.danwei || ''}，低于提醒库存${drug.tixingkucun}`,
                addtime: this.getNowTime()
              }
              this.axios.post("/addYiliaoyaopingtixingactJson", tixing)
            }
          }).catch(() => {
            // 忽略单个药品库存更新失败，避免影响开方流程
          })
        })
      },
      addBingliJilv() {
        const data = {
          jilvtime: this.getNowTime(),
          zhusu: this.guahaozixunjieguo.zhusu,
          yonghutiwen: this.guahaozixunjieguo.yonghutiwen,
          xinlv: this.guahaozixunjieguo.xinlv,
          zhenduan: this.guahaozixunjieguo.zhenduan,
          xiuxijiany: this.guahaozixunjieguo.xiuxijiany,
          yongyao: this.guahaozixunjieguo.yongyao,
          xiaoyuanyisheng: this.guahaozixunjieguo.xiaoyuanyisheng,
          xiaoyuanyishengid: this.guahaozixunjieguo.xiaoyuanyishengid,
          xyyiliaoyh: this.guahaozixunjieguo.xyyiliaoyh,
          xyyiliaoyhid: this.guahaozixunjieguo.xyyiliaoyhid
        }
        this.axios.post("/addYhbinglijilvactJson", data).catch(() => {
          // 病例记录失败不影响开方主流程
        })
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
      xiaoyuanyishengAddGuahaozixunjieguoactJson() {
        var _this = this
        this.guahaozixunjieguo.kaifangtime = this.getNowTime() + "开方"
        this.axios.post("/xiaoyuanyishengAddGuahaozixunjieguoactJson", _this.guahaozixunjieguo).then(res => {
          if (res.data.message == '添加挂号咨询结果成功') {
            _this.handleDrugInventory()
            _this.addBingliJilv()
            _this.$toast.success("添加挂号咨询结果成功",{
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path:"/htMenu/xiaoyuanyishengguahaozixunjieguoList"})
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

      this.guahaozixunjieguo.xiaoyuanyishengid = userinfo.id
      this.guahaozixunjieguo.xiaoyuanyisheng = userinfo.username

      let item = JSON.parse(localStorage.getItem("xyyiliaopaibanyuyue"))
      this.guahaozixunjieguo.xyyiliaopaibanyuyue = item.jianyaowenti
      this.guahaozixunjieguo.xyyiliaopaibanyuyueid = item.id
      this.guahaozixunjieguo.xyyiliaoyh = item.xyyiliaoyh
      this.guahaozixunjieguo.xyyiliaoyhid = item.xyyiliaoyhid
      this.guahaozixunjieguo.state = '待支付'
      this.axios.post("/xiaoyuanyishengAddGuahaozixunjieguoJson").then(res=>{
        this.xyyiliaoyaopings = res.data.xyyiliaoyaopings
      })
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengAddGuahaozixunjieguo
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


