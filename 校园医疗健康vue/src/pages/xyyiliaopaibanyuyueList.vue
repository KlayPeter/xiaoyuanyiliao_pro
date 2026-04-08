<template>
    <div class="anime-page">
        <h2 class="anime-card-title">校园医疗排班预约管理</h2>

        <div class="search-area">
            <el-input placeholder="请输入简要问题描述" v-model="search" clearable></el-input>
            <el-button type="primary" @click="xyyiliaopaibanyuyueListJson()">搜索</el-button>
        </div>

        <el-table :data="showXyyiliaopaibanyuyueArr" stripe style="width: 100%;" height="600px" class="anime-table">
                    <el-table-column prop="id" label="ID" min-width="60" />
                    <el-table-column prop="xyyiliaoyh" label="学生姓名" min-width="100" />
                    <el-table-column prop="xyyiliaoyhid" label="学生ID" min-width="80" />
                    <el-table-column prop="xiaoyuanyisheng" label="就诊医生" min-width="100" />
                    <el-table-column prop="jianyaowenti" label="主诉症状" min-width="140" />
                    <el-table-column prop="yuyuetime" label="预约日期" min-width="100" />
                    <el-table-column prop="typea" label="类型" min-width="90" />
                    <el-table-column prop="state" label="状态" min-width="90" />
                    <el-table-column prop="addtime" label="创建时间" min-width="120" />
            <el-table-column fixed="right" label="操作" min-width="180">
                <template #default="scope">
                    <el-button type="primary" plain size="small"
                               @click.prevent="toUpdateXyyiliaopaibanyuyue(scope.row.id)"
                    >修改</el-button>
                    <el-button type="danger" plain size="small"
                               @click.prevent="deleteXyyiliaopaibanyuyueJson(scope.row.id)"
                    >删除</el-button>
                </template>
            </el-table-column>
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
  const xyyiliaopaibanyuyueList = {
    components: {
    },
    data() {
      return {
        pageIndex: 0,
        pageSize:10,
        pageNum: 0,
        xyyiliaopaibanyuyues:[],
        showXyyiliaopaibanyuyueArr:[],
        search:""
      }
    },
    methods: {
      deleteXyyiliaopaibanyuyueJson(id) {
        var _this = this
        console.log(id)
        this.axios.post("/deleteXyyiliaopaibanyuyueJson?id=" + id, {}).then(res => {
          if (res.data.message == '删除校园医疗排班预约成功') {
            _this.$toast.success("删除校园医疗排班预约成功", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.xyyiliaopaibanyuyues = _this.xyyiliaopaibanyuyues.filter(item =>{
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
      toUpdateXyyiliaopaibanyuyue(id) {
        this.$router.push({path:"/htMenu/updateXyyiliaopaibanyuyue",query:{id:id}})
      },
      xyyiliaopaibanyuyueListJson() {
        var _this = this
        this.axios.post("/xyyiliaopaibanyuyueListJson?search="+this.search,{}).then(res => {
          _this.xyyiliaopaibanyuyues  = res.data.xyyiliaopaibanyuyues
          _this.goPage(0)
        })
      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.xyyiliaopaibanyuyues.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showXyyiliaopaibanyuyueArr = this.xyyiliaopaibanyuyues.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showXyyiliaopaibanyuyueArr.length == 0){
          pageIndex = --this.pageIndex
          this.showXyyiliaopaibanyuyueArr = this.xyyiliaopaibanyuyues.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
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
      this.xyyiliaopaibanyuyueListJson()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xyyiliaopaibanyuyueList
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

