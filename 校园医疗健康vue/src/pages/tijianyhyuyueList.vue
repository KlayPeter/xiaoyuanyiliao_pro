<template>
    <div class="anime-page">
        <h2 class="anime-card-title">体检用户预约管理</h2>

        <div class="search-area">
            <el-input placeholder="请输入校园体检事项" v-model="search" clearable></el-input>
            <el-button type="primary" @click="tijianyhyuyueListJson()">搜索</el-button>
        </div>

        <el-table :data="showTijianyhyuyueArr" stripe style="width: 100%;" height="600px" class="anime-table">
                    <el-table-column prop="xytijianshixiang" label="校园体检事项" min-width="100" />
<!--                    <el-table-column prop="xytijianshixiangid" label="校园体检事项id" min-width="100" />-->
                    <el-table-column prop="xyyiliaoyh" label="校园医疗用户" min-width="100" />
<!--                    <el-table-column prop="xyyiliaoyhid" label="校园医疗用户id" min-width="100" />-->
                    <el-table-column prop="address" label="体检位置" min-width="100" />
                    <el-table-column prop="shijian" label="体检时间" min-width="100" />
<!--                    <el-table-column prop="img" label="体检封面" min-width="100">-->
<!--                        <template #default="scope">-->
<!--                            <div class="avatar-frame">-->
<!--                                <img :src="scope.row.img && scope.row.img.includes('http') ? scope.row.img : 'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/' + scope.row.img" alt="体检封面" />-->
<!--                            </div>-->
<!--                        </template>-->
<!--                    </el-table-column>-->
                    <el-table-column prop="state" label="状态" min-width="100" />
            <el-table-column fixed="right" label="操作" min-width="180">
                <template #default="scope">
                    <el-button
                        v-if="scope.row.state == '待出成绩'"
                        type="primary" plain size="small"
                               @click.prevent="jilvchengji(scope.$index)"
                    >记录成绩</el-button>
<!--                    <el-button type="danger" plain size="small"-->
<!--                               @click.prevent="deleteTijianyhyuyueJson(scope.row.id)"-->
<!--                    >删除</el-button>-->
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
  const tijianyhyuyueList = {
    components: {
    },
    data() {
      return {
        pageIndex: 0,
        pageSize:10,
        pageNum: 0,
        tijianyhyuyues:[],
        showTijianyhyuyueArr:[],
        search:""
      }
    },
    methods: {
      jilvchengji(index){
        let item = this.showTijianyhyuyueArr[index]
        localStorage.setItem("tijianyuyue",JSON.stringify(item))
        this.$router.push({path:"/htmenu/addjiankangdangan"})
      },
      deleteTijianyhyuyueJson(id) {
        var _this = this
        console.log(id)
        this.axios.post("/deleteTijianyhyuyueJson?id=" + id, {}).then(res => {
          if (res.data.message == '删除体检用户预约成功') {
            _this.$toast.success("删除体检用户预约成功", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.tijianyhyuyues = _this.tijianyhyuyues.filter(item =>{
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
      toUpdateTijianyhyuyue(id) {
        this.$router.push({path:"/htMenu/updateTijianyhyuyue",query:{id:id}})
      },
      tijianyhyuyueListJson() {
        var _this = this
        this.axios.post("/tijianyhyuyueListJson?search="+this.search,{}).then(res => {
          _this.tijianyhyuyues  = res.data.tijianyhyuyues.filter(t=>{
            return t.xytijianshixiangid == this.$route.query.id
          })
          _this.goPage(0)
        })
      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.tijianyhyuyues.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showTijianyhyuyueArr = this.tijianyhyuyues.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showTijianyhyuyueArr.length == 0){
          pageIndex = --this.pageIndex
          this.showTijianyhyuyueArr = this.tijianyhyuyues.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
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
      this.tijianyhyuyueListJson()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default tijianyhyuyueList
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

