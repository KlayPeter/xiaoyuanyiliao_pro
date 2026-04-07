<template>
    <div class="anime-page">
        <h2 class="anime-card-title">健康档案管理</h2>

        <div class="search-area">
            <el-input placeholder="请输入测试时间" v-model="search" clearable></el-input>
            <el-button type="primary" @click="jiankangdanganListJson()">搜索</el-button>
        </div>

        <el-table :data="showJiankangdanganArr" stripe style="width: 100%;" height="600px" class="anime-table">
                    <el-table-column prop="shijian" label="测试时间" min-width="100" />
                    <el-table-column prop="height" label="身高" min-width="100" />
                    <el-table-column prop="weight" label="体重" min-width="100" />
                    <el-table-column prop="bmi" label="bmi数值" min-width="100" />
                    <el-table-column prop="zuoyanshili" label="左眼视力" min-width="100" />
                    <el-table-column prop="youyanshili" label="右眼视力" min-width="100" />
                    <el-table-column prop="feihuoliang" label="肺活量" min-width="100" />
                    <el-table-column prop="lidingtiaoyuan" label="立定跳远成绩" min-width="100" />
                    <el-table-column prop="yibaimi" label="一百米 成绩" min-width="100" />
                    <el-table-column prop="xyyiliaoyh" label="校园医疗用户" min-width="100" />
                    <el-table-column prop="xyyiliaoyhid" label="校园医疗用户id" min-width="100" />
            <el-table-column fixed="right" label="操作" min-width="120">
                <template #default="scope">
                    <el-button class="anime-btn" size="small"
                               @click.prevent="toUpdateJiankangdangan(scope.row.id)"
                    >修改</el-button>
                    <el-button class="anime-btn-cancel" size="small"
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
          if (res.data.message == '删除健康档案成功') {
            _this.$toast.success("删除健康档案成功", {
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

      .el-input {
        border-radius: 25px;

        .el-input__inner {
          border: 2px solid #ffe0c2;
          height: 40px;
          transition: all 0.3s ease;
        }
        .el-input__inner:focus {
          border-color: #ffb38a;
          background-color: #fff9f5;
          box-shadow: 0 0 6px rgba(255, 160, 122, 0.3);
        }
      }

      .el-button {
        margin-left: 10px;
        border-radius: 25px;
        background-color: #ffb38a;
        border-color: #ffb38a;
        color: #fff;
        font-weight: bold;

        &:hover {
          background-color: #ff9e6e;
          border-color: #ff9e6e;
        }
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
