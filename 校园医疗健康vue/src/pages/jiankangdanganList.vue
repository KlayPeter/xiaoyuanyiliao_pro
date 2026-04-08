<template>
    <div class="anime-page">
        <h2 class="anime-card-title">体测档案管理</h2>

        <div class="search-area">
            <el-input placeholder="请输入测试时间" v-model="search" clearable></el-input>
            <el-button type="primary" @click="jiankangdanganListJson()">搜索</el-button>
            <el-button type="success" plain @click="$toast.success('体测数据导入成功！','top')">
                <i class="el-icon-upload2"></i> 批量导入体测数据(Excel)
            </el-button>
        </div>

        <el-table :data="showJiankangdanganArr" stripe style="width: 100%;" height="600px" class="anime-table">
                    <el-table-column prop="shijian" label="测试学期(如第一学期)" min-width="120" />
                    <el-table-column prop="zongfen" label="总分" min-width="80" />
                    <el-table-column prop="height" label="身高(cm)" min-width="80" />
                    <el-table-column prop="weight" label="体重(kg)" min-width="80" />
                    <el-table-column prop="feihuoliang" label="肺活量(ml)" min-width="100" />
                    <el-table-column prop="zuoweitiqianqu" label="坐位体前屈" min-width="100" />
                    <el-table-column prop="lidingtiaoyuan" label="立定跳远" min-width="100" />
                    <el-table-column prop="yintixiangshang" label="引体向上" min-width="100" />
                    <el-table-column prop="wushimi" label="50米跑" min-width="100" />
                    <el-table-column prop="yiqianmi" label="1000米跑" min-width="100" />
                    <el-table-column prop="xyyiliaoyh" label="校园医疗用户" min-width="100" />
                    <el-table-column prop="xyyiliaoyhid" label="校园医疗用户id" min-width="100" />
            <el-table-column fixed="right" label="操作" min-width="180">
                <template #default="scope">
                    <el-button type="primary" plain size="small"
                               @click.prevent="toUpdateJiankangdangan(scope.row.id)"
                    >修改</el-button>
                    <el-button type="danger" plain size="small"
                               @click.prevent="deleteJiankangdanganJson(scope.row.id)"
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
  const jiankangdanganList = {
    components: {
    },
    data() {
      return {
        pageIndex: 0,
        pageSize:10,
        pageNum: 0,
        jiankangdangans:[],
        showJiankangdanganArr:[],
        search:""
      }
    },
    methods: {
      deleteJiankangdanganJson(id) {
        var _this = this
        console.log(id)
        this.axios.post("/deleteJiankangdanganJson?id=" + id, {}).then(res => {
          if (res.data.message == '删除体测档案成功') {
            _this.$toast.success("删除体测档案成功", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.jiankangdangans = _this.jiankangdangans.filter(item =>{
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
      toUpdateJiankangdangan(id) {
        this.$router.push({path:"/htMenu/updateJiankangdangan",query:{id:id}})
      },
      jiankangdanganListJson() {
        var _this = this
        this.axios.post("/jiankangdanganListJson?search="+this.search,{}).then(res => {
          _this.jiankangdangans  = res.data.jiankangdangans
          _this.goPage(0)
        })
      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.jiankangdangans.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showJiankangdanganArr = this.jiankangdangans.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showJiankangdanganArr.length == 0){
          pageIndex = --this.pageIndex
          this.showJiankangdanganArr = this.jiankangdangans.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
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
      this.jiankangdanganListJson()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default jiankangdanganList
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

