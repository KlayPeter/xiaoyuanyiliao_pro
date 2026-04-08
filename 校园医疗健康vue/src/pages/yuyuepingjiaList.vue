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
                    <el-table-column prop="id" label="ID" min-width="60" />
                    <el-table-column prop="xyyiliaoyh" label="学生姓名" min-width="100" />
                    <el-table-column prop="xyyiliaoyhid" label="学生ID" min-width="80" />
                    <el-table-column prop="xiaoyuanyisheng" label="评价医生" min-width="100" />
                    <el-table-column prop="pingjiafenshu" label="评分" min-width="80">
                        <template #default="scope">
                            <span style="color:#f59e0b; font-weight:bold;">★ {{ scope.row.pingjiafenshu || '-' }}</span>
                        </template>
                    </el-table-column>
                    <el-table-column prop="type" label="评价类型" min-width="90" />
                    <el-table-column prop="pingcontent" label="评价内容" min-width="160" />
                    <el-table-column prop="pingjiashijian" label="评价时间" min-width="120" />
            <el-table-column fixed="right" label="操作" min-width="180">
                <template #default="scope">
                    <el-button type="primary" plain size="small"
                               @click.prevent="toUpdateYuyuepingjia(scope.row.id)"
                    >修改</el-button>
                    <el-button type="danger" plain size="small"
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

