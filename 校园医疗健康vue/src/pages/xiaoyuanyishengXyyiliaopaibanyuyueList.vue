<template>
  <div class="anime-page">
    <h2 class="anime-card-title">校园医疗排班预约管理</h2>

    <div class="search-area">
      <el-select v-model="filterState" placeholder="选择状态" clearable style="margin-right: 10px;">
        <el-option label="待对话" value="待对话" />
        <el-option label="已开方" value="已开方" />
        <el-option label="已过期" value="已过期" />
        <el-option label="待前往" value="待前往" />
        <el-option label="已前往" value="已前往" />
      </el-select>
      <el-select v-model="filterType" placeholder="选择类型" clearable style="margin-right: 10px;">
        <el-option label="线上" value="线上" />
        <el-option label="线下" value="线下" />
      </el-select>
      <el-date-picker
        v-model="filterDate"
        type="date"
        placeholder="选择日期"
        format="YYYY-MM-DD"
        value-format="YYYY-MM-DD"
        clearable
      />
      <el-button type="primary" style="margin-left: 10px;" @click="applyFilters">筛选</el-button>
    </div>

    <el-table :data="showXyyiliaopaibanyuyueArr" stripe style="width: 100%;" height="600px" class="anime-table">
          <el-table-column prop="jianyaowenti" label="简要问题描述" min-width="100" />
          <el-table-column prop="xiaoyuanyisheng" label="校园医生" min-width="100" />
<!--          <el-table-column prop="xiaoyuanyishengid" label="校园医生id" min-width="100" />-->
          <el-table-column prop="xiaoyuanyishengimg" label="校园医生照片" min-width="100">
            <template #default="scope">
              <div class="avatar-frame">
                <img :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+scope.row.xiaoyuanyishengimg" alt="校园医生照片" />
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="xyyiliaoyh" label="校园用户" min-width="100" />
<!--          <el-table-column prop="xyyiliaoyhid" label="校园用户id" min-width="100" />-->
          <el-table-column prop="xyyiliaoyhimg" label="校园用户照片" min-width="100">
            <template #default="scope">
              <div class="avatar-frame">
                <img :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+scope.row.xyyiliaoyhimg" alt="校园用户照片" />
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="yuyuetime" label="预约日期" min-width="100" />
          <el-table-column prop="typea" label="类型" min-width="100" />
          <el-table-column prop="state" label="状态" min-width="100" />
          <el-table-column prop="addtime" label="创建时间" min-width="100" />
      <el-table-column fixed="right" label="操作" min-width="120">
        <template #default="scope">
          <el-button v-if="scope.row.state == '待对话'" class="anime-btn" size="small" @click.prevent="jinxduihua(scope.$index)"
          >对话</el-button>
          <el-button v-if="scope.row.state == '待对话'" class="anime-btn" size="small" @click.prevent="jinxingkaifang(scope.$index)"
          >进行开方</el-button>
          <el-button v-if="scope.row.state == '已前往'" class="anime-btn" size="small" @click.prevent="jinxingkaifang(scope.$index)"
          >进行开方</el-button>
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
  const xiaoyuanyishengXyyiliaopaibanyuyueList = {
    components: {
    },
    data() {
      return {
        pageIndex: 0,
        pageSize:10,
        pageNum: 1,
        allXyyiliaopaibanyuyueList:[],
        xyyiliaopaibanyuyueListAll:[],
        showXyyiliaopaibanyuyueArr:[],
        filterState: "",
        filterType: "",
        filterDate: ""
      }
    },
    methods: {
      jinxingkaifang(index){
        let item = this.showXyyiliaopaibanyuyueArr[index]
        localStorage.setItem("xyyiliaopaibanyuyue",JSON.stringify(item))
        this.$router.push({path:"/htmenu/xiaoyuanyishengAddGuahaozixunjieguo"})
      },
      jinxduihua(index){
        let item = this.showXyyiliaopaibanyuyueArr[index]
        this.$router.push({path:"/htmenu/duihua",query:{duihuaid:item.id}})
      },
      xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson(id) {
        var _this = this
        console.log(id)
        this.axios.post("/xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson?id=" + id, {}).then(res => {
          if (res.data.message == '删除校园医疗排班预约成功') {
            _this.$toast.success("删除校园医疗排班预约成功", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.allXyyiliaopaibanyuyueList = _this.allXyyiliaopaibanyuyueList.filter(item =>{
              return item.id != id
            })
            _this.xyyiliaopaibanyuyueListAll = _this.xyyiliaopaibanyuyueListAll.filter(item =>{
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
      toXiaoyuanyishengUpdateXyyiliaopaibanyuyue(id) {
        this.$router.push({path:"/htMenu/xiaoyuanyishengUpdateXyyiliaopaibanyuyue",query:{id:id}})
      },
      xiaoyuanyishengXyyiliaopaibanyuyueListJson() {
        var _this = this
        this.axios.post("/xiaoyuanyishengXyyiliaopaibanyuyueListJson",{}).then(res => {
          _this.allXyyiliaopaibanyuyueList  = res.data.xyyiliaopaibanyuyues
          _this.applyFilters()
        })
      },
      applyFilters() {
        let list = this.allXyyiliaopaibanyuyueList
        if (this.filterState) {
          list = list.filter(item => item.state === this.filterState)
        }
        if (this.filterType) {
          list = list.filter(item => item.typea === this.filterType)
        }
        if (this.filterDate) {
          list = list.filter(item => {
            return item.yuyuetime && item.yuyuetime.startsWith(this.filterDate)
          })
        }
        this.xyyiliaopaibanyuyueListAll = list
        this.pageIndex = 0
        this.goPage(0)
      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.xyyiliaopaibanyuyueListAll.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showXyyiliaopaibanyuyueArr = this.xyyiliaopaibanyuyueListAll.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showXyyiliaopaibanyuyueArr.length == 0){
          pageIndex = --this.pageIndex
          this.showXyyiliaopaibanyuyueArr = this.xyyiliaopaibanyuyueListAll.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
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
      this.xiaoyuanyishengXyyiliaopaibanyuyueListJson()
    },
    //可以操作dom了
    mounted() {

    }
  }
  export default xiaoyuanyishengXyyiliaopaibanyuyueList
</script>

<style scoped lang="scss">
  .anime-page {
    padding: 25px;

    .anime-card-title {
      font-size: 24px;
      font-weight: bold;
      color: #ff7f50;
      margin-bottom: 15px;
      text-align: center;
      letter-spacing: 1px;
    }

    .search-area {
      display: flex;
      margin-bottom: 15px;

      .el-select,
      .el-date-editor {
        border-radius: 25px;
        margin-right: 10px;
      }
    }

    .anime-table {
      border-radius: 25px;
      overflow: hidden;
      box-shadow: 0 6px 20px rgba(255, 160, 122, 0.15);
      background-color: #fffaf5;

      th {
        background-color: #ffe5d0;
        color: #ff7f50;
        font-weight: bold;
        text-align: center;
      }
      td {
        background-color: #fff9f5;
        color: #ff6f61;
        text-align: center;
      }

      .el-table__row {
        transition: transform 0.2s ease, box-shadow 0.2s ease;
        border-radius: 20px;
        &:hover {
          transform: translateY(-3px);
          box-shadow: 0 4px 12px rgba(255, 160, 122, 0.25);
        }
      }

      .avatar-frame img {
        width: 80px;
        height: 80px;
        border-radius: 50%;
        border: 2px solid #ffd6b0;
        box-shadow: 0 2px 6px rgba(255, 160, 122, 0.2);
        object-fit: cover;
      }
    }

    .anime-btn {
      border-radius: 20px;
      background-color: #fff0e6;
      color: #ff7f50;
      border: none;
      padding: 2px 12px;
      margin: 2px;

      &:hover {
        background-color: #ffe2cf;
        color: #ff6f61;
      }
    }

    .anime-btn-cancel {
      border-radius: 20px;
      background-color: #fffaf5;
      color: #ff7f50;
      border: 1px solid #ffe0c2;
      padding: 2px 12px;
      margin: 2px;

      &:hover {
        background-color: #fff5ef;
        border-color: #ffb38a;
        color: #ff6f61;
      }
    }

    .pagination-area {
      margin-top: 20px;
      display: flex;
      justify-content: center;

      .el-button {
        border-radius: 20px;
        font-weight: bold;
        background-color: #fffaf5;
        border: 1px solid #ffe0c2;
        color: #ff7f50;
        transition: all 0.3s ease;

        &:hover {
          background-color: #fff5ef;
          border-color: #ffb38a;
          color: #ff6f61;
        }

        &.is-disabled {
          color: #ccc;
          border-color: #ffe0c2;
          background-color: #fffaf5;
        }
      }
    }
  }
</style>
