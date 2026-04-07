<template>
  <div class="anime-page">
    <h2 class="anime-card-title">校园医疗排班管理</h2>

    <div class="search-area">
      <el-date-picker
        v-model="filterMonth"
        type="month"
        placeholder="请选择排班月份"
        format="YYYY-MM"
        value-format="YYYY-MM"
        clearable
        @change="filterByMonth"
      />
    </div>

    <el-table :data="showXyyiliaopaibanArr" stripe style="width: 100%;" height="600px" class="anime-table">
          <el-table-column prop="yuefen" label="排班月份" min-width="100" />
          <el-table-column prop="xiaoyuanyisheng" label="校园医生" min-width="100" />
<!--          <el-table-column prop="xiaoyuanyishengid" label="校园医生id" min-width="100" />-->
          <el-table-column prop="remark" label="备注" min-width="100" />
          <el-table-column prop="chuangjiantime" label="创建时间" min-width="100" />
<!--      <el-table-column fixed="right" label="操作" min-width="180">-->
<!--        <template #default="scope">-->
<!--          <el-button type="primary" plain size="small" @click.prevent="toXiaoyuanyishengUpdateXyyiliaopaiban(scope.row.id)"-->
<!--          >修改</el-button>-->
<!--          <el-button type="danger" plain size="small"-->
<!--                     @click.prevent="xiaoyuanyishengDeleteXyyiliaopaibanJson(scope.row.id)"-->
<!--          >删除</el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
    </el-table>

    <div class="pagination-area">
      <el-button-group>
        <el-button icon="el-icon-arrow-left" @click="pre_page">上一页</el-button>
        <el-button type="primary" disabled>第 {{ pageIndex + 1 }} 页</el-button>
        <el-button icon="el-icon-arrow-right" @click="next_page">下一页</el-button>
      </el-button-group>
    </div>
  </div>
</template>

<script>
  const xiaoyuanyishengXyyiliaopaibanList = {
    components: {
    },
    data() {
      return {
        pageIndex: 0,
        pageSize:10,
        pageNum: 1,
        allXyyiliaopaibanList:[],
        xyyiliaopaibanListAll:[],
        showXyyiliaopaibanArr:[],
        filterMonth:""
      }
    },
    methods: {
      getCurrentMonth() {
        const now = new Date()
        const year = now.getFullYear()
        const month = String(now.getMonth() + 1).padStart(2, '0')
        return year + '-' + month
      },
      xiaoyuanyishengDeleteXyyiliaopaibanJson(id) {
        var _this = this
        console.log(id)
        this.axios.post("/xiaoyuanyishengDeleteXyyiliaopaibanJson?id=" + id, {}).then(res => {
          if (res.data.message == '删除校园医疗排班成功') {
            _this.$toast.success("删除校园医疗排班成功", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.allXyyiliaopaibanList = _this.allXyyiliaopaibanList.filter(item =>{
              return item.id != id
            })
            _this.xyyiliaopaibanListAll = _this.xyyiliaopaibanListAll.filter(item =>{
              return item.id != id
            })
            _this.goPage(_this.pageIndex)
            return
          } else {
            _this.$toast.error(res.data.message, {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            return;
          }
        })
      },
      toXiaoyuanyishengUpdateXyyiliaopaiban(id) {
        this.$router.push({path:"/htMenu/xiaoyuanyishengUpdateXyyiliaopaiban",query:{id:id}})
      },
      xiaoyuanyishengXyyiliaopaibanListJson() {
        var _this = this
        this.axios.post("/xiaoyuanyishengXyyiliaopaibanListJson",{}).then(res => {
          _this.allXyyiliaopaibanList  = res.data.xyyiliaopaibans
          _this.filterMonth = _this.getCurrentMonth()
          _this.filterByMonth()
        })
      },
      filterByMonth() {
        if (!this.filterMonth) {
          this.xyyiliaopaibanListAll = this.allXyyiliaopaibanList
        } else {
          this.xyyiliaopaibanListAll = this.allXyyiliaopaibanList.filter(item => {
            return item.yuefen && item.yuefen.startsWith(this.filterMonth)
          })
        }
        this.pageIndex = 0
        this.goPage(0)
      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.xyyiliaopaibanListAll.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showXyyiliaopaibanArr = this.xyyiliaopaibanListAll.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showXyyiliaopaibanArr.length == 0){
          pageIndex = --this.pageIndex
          this.showXyyiliaopaibanArr = this.xyyiliaopaibanListAll.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        }
      },
      pre_page(){
        if (this.pageIndex <= 0){
          this.$toast.info("当前已经是第一页",{
            duration:2000,
            position:'top',
            pauseOnHover:false
          })
          return
        }
        this.pageIndex--
        this.goPage(this.pageIndex)
      },
      next_page(){
        if (this.pageIndex >= this.pageNum -1){
          this.$toast.info("当前已经是最后一页",{
            duration:2000,
            position:'top',
            pauseOnHover:false
          })
          return
        }
        this.pageIndex++
        this.goPage(this.pageIndex)
      },
    },
    //data初始化完成
    created() {
      var _this = this
      this.xiaoyuanyishengXyyiliaopaibanListJson()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengXyyiliaopaibanList
</script>


<style scoped lang="scss">
  .anime-page {
    padding: 24px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 2px 12px 0 rgba(0,0,0,0.05);
    margin: 20px;
  }
  .anime-card-title {
    font-size: 20px;
    font-weight: 500;
    color: #303133;
    margin-bottom: 24px;
    text-align: left;
    border-bottom: 1px solid #ebeef5;
    padding-bottom: 15px;
  }
  .search-area {
    display: flex;
    margin-bottom: 20px;
    gap: 10px;
  }
  .search-area .el-input {
    width: 240px;
  }
  .anime-table {
    border: 1px solid #ebeef5;
    border-bottom: none;
  }
  .avatar-frame img {
    width: 40px;
    height: 40px;
    border-radius: 4px;
    border: 1px solid #ebeef5;
    object-fit: cover;
  }
  .pagination-area {
    margin-top: 24px;
    display: flex;
    justify-content: flex-end;
  }
</style>

