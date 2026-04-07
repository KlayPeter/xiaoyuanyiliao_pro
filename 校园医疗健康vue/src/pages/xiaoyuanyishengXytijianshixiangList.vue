<template>
  <div class="anime-page">
    <h2 class="anime-card-title">校园体检事项管理</h2>

    <div class="search-area">
      <el-input placeholder="请输入体检标题" v-model="search" clearable></el-input>
      <el-button type="primary" @click="xiaoyuanyishengXytijianshixiangListJson()">搜索</el-button>
    </div>

    <el-table :data="showXytijianshixiangArr" stripe style="width: 100%;" height="600px" class="anime-table">
          <el-table-column prop="tijiant" label="体检标题" min-width="100" />
          <el-table-column prop="tijiancontent" label="体检内容" min-width="100" />
          <el-table-column prop="tijianzhuyi" label="体检注意事项" min-width="100" />
          <el-table-column prop="tijianadress" label="体检位置" min-width="100" />
          <el-table-column prop="tijiantime" label="体检时间" min-width="100" />
          <el-table-column prop="tijianimg" label="封面" min-width="100">
            <template #default="scope">
              <div class="avatar-frame">
                <img :src="scope.row.tijianimg && scope.row.tijianimg.includes('http') ? scope.row.tijianimg : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + scope.row.tijianimg" alt="封面" />
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="xiaoyuanyisheng" label="负责医生" min-width="100" />
      <el-table-column fixed="right" label="操作" min-width="180">
        <template #default="scope">
          <el-button type="primary" plain size="small" @click.prevent="chakanjutiyuyue(scope.row.id)"
          >查看具体预约</el-button>
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
  const xiaoyuanyishengXytijianshixiangList = {
    components: {
    },
    data() {
      return {
        pageIndex: 0,
        pageSize:10,
        pageNum: 1,
        xytijianshixiangListAll:[],
        showXytijianshixiangArr:[],
        search:""
      }
    },
    methods: {
      chakanjutiyuyue(id){
        this.$router.push({path:"/htmenu/tijianyhyuyueList",query:{id:id}})
      },
      xiaoyuanyishengDeleteXytijianshixiangJson(id) {
        var _this = this
        console.log(id)
        this.axios.post("/xiaoyuanyishengDeleteXytijianshixiangJson?id=" + id, {}).then(res => {
          if (res.data.message == '删除校园体检事项成功') {
            _this.$toast.success("删除校园体检事项成功", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.xytijianshixiangListAll = _this.xytijianshixiangListAll.filter(item =>{
              return item.id != id
            })
            _this.goPage(this.pageIndex)
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
      toXiaoyuanyishengUpdateXytijianshixiang(id) {
        this.$router.push({path:"/htMenu/xiaoyuanyishengUpdateXytijianshixiang",query:{id:id}})
      },
      xiaoyuanyishengXytijianshixiangListJson() {
        var _this = this
        this.axios.post("/xiaoyuanyishengXytijianshixiangListJson?search="+this.search,{}).then(res => {
          _this.xytijianshixiangListAll  = res.data.xytijianshixiangs
          _this.goPage(0)
        })
      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.xytijianshixiangListAll.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showXytijianshixiangArr = this.xytijianshixiangListAll.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showXytijianshixiangArr.length == 0){
          pageIndex = --this.pageIndex
          this.showXytijianshixiangArr = this.xytijianshixiangListAll.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
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
      this.xiaoyuanyishengXytijianshixiangListJson()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengXytijianshixiangList
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

