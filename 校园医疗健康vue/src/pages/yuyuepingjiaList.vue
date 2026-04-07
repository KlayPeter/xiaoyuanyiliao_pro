<template>
    <div class="anime-page">
        <h2 class="anime-card-title">预约评价管理</h2>

        <div class="search-area">
            <el-input placeholder="请输入医疗排班预约" v-model="search" clearable></el-input>
            <el-button type="primary" @click="yuyuepingjiaListJson()">搜索</el-button>
        </div>

        <div class="chart-area">
          <div ref="typeChart" class="chart-box"></div>
        </div>

        <el-table :data="showYuyuepingjiaArr" stripe style="width: 100%;" height="600px" class="anime-table">
                    <el-table-column prop="xyyiliaopaibanyuyue" label="医疗排班预约" min-width="100" />
                    <el-table-column prop="xyyiliaopaibanyuyueid" label="医疗排班预约id" min-width="100" />
                    <el-table-column prop="pingcontent" label="评价内容" min-width="100" />
                    <el-table-column prop="type" label="评价类型" min-width="100" />
                    <el-table-column prop="xyyiliaoyh" label="校园用户" min-width="100" />
                    <el-table-column prop="xyyiliaoyhid" label="校园用户id" min-width="100" />
                    <el-table-column prop="pingjiashijian" label="评价时间" min-width="100" />
                    <el-table-column prop="xiaoyuanyisheng" label="校园医生" min-width="100" />
                    <el-table-column prop="xiaoyuanyishengid" label="校园医生id" min-width="100" />
            <el-table-column fixed="right" label="操作" min-width="120">
                <template #default="scope">
                    <el-button class="anime-btn" size="small"
                               @click.prevent="toUpdateYuyuepingjia(scope.row.id)"
                    >修改</el-button>
                    <el-button class="anime-btn-cancel" size="small"
                               @click.prevent="deleteYuyuepingjiaJson(scope.row.id)"
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
  import * as echarts from 'echarts'

  const yuyuepingjiaList = {
    components: {
    },
    data() {
      return {
        pageIndex: 0,
        pageSize:10,
        pageNum: 0,
        yuyuepingjias:[],
        showYuyuepingjiaArr:[],
        search:"",
        typeChart: null
      }
    },
    methods: {
      initTypeChart() {
        this.$nextTick(() => {
          const dom = this.$refs.typeChart
          if (!dom) return
          if (!this.typeChart) {
            this.typeChart = echarts.init(dom)
          }
          this.updateTypeChart()
        })
      },
      updateTypeChart() {
        if (!this.typeChart) return
        const stats = {}
        this.yuyuepingjias.forEach(item => {
          const key = item.type || '未标注'
          stats[key] = (stats[key] || 0) + 1
        })
        const seriesData = Object.keys(stats).map(name => ({
          name,
          value: stats[name]
        }))

        const option = {
          title: {
            text: '评价类型分布',
            left: 'center',
            textStyle: {
              fontSize: 16
            }
          },
          tooltip: {
            trigger: 'item'
          },
          legend: {
            bottom: 0
          },
          series: [
            {
              name: '评价类型',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              itemStyle: {
                borderRadius: 8,
                borderColor: '#fff',
                borderWidth: 2
              },
              label: {
                show: true,
                formatter: '{b}: {c} ({d}%)'
              },
              data: seriesData
            }
          ]
        }

        this.typeChart.setOption(option, true)
      },
      deleteYuyuepingjiaJson(id) {
        var _this = this
        console.log(id)
        this.axios.post("/deleteYuyuepingjiaJson?id=" + id, {}).then(res => {
          if (res.data.message == '删除预约评价成功') {
            _this.$toast.success("删除预约评价成功", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.yuyuepingjias = _this.yuyuepingjias.filter(item =>{
              return item.id != id
            })
            _this.goPage(_this.pageIndex)
            _this.updateTypeChart()
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
      toUpdateYuyuepingjia(id) {
        this.$router.push({path:"/htMenu/updateYuyuepingjia",query:{id:id}})
      },
      yuyuepingjiaListJson() {
        var _this = this
        this.axios.post("/yuyuepingjiaListJson?search="+this.search,{}).then(res => {
          _this.yuyuepingjias  = res.data.yuyuepingjias
          _this.goPage(0)
          _this.initTypeChart()
        })
      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.yuyuepingjias.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showYuyuepingjiaArr = this.yuyuepingjias.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showYuyuepingjiaArr.length == 0){
          pageIndex = --this.pageIndex
          this.showYuyuepingjiaArr = this.yuyuepingjias.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
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
      this.yuyuepingjiaListJson()
    },
    //可以操作dom了
    mounted() {
      this.initTypeChart()
    }
  }
  export default yuyuepingjiaList
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

    .chart-area {
      margin-bottom: 20px;

      .chart-box {
        width: 100%;
        height: 320px;
        background: #fffaf5;
        border-radius: 24px;
        box-shadow: 0 6px 20px rgba(255, 160, 122, 0.15);
        border: 1px solid #ffe5d0;
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
