<template>
  <div class="anime-search-container">
    <!-- 搜索区域 -->
    <div class="search-section">
      <div class="search-box">
        <el-input
                v-model="search"
                placeholder="请输入关键词"
                class="search-input"
                @keyup.enter="searchXytijianshixiangJson()"
        >
          <template #prefix>
            <i class="el-icon-search"></i>
          </template>
        </el-input>
        <el-button type="primary" size="large" @click="searchXytijianshixiangJson()">搜索</el-button>
      </div>
    </div>

    <div class="anime-list-section">
      <div class="section-header">
        <h3 class="section-title">校园体检事项列表</h3>
      </div>
      <div class="anime-grid">
        <div v-for="(xytijianshixiang,index) in showXytijianshixiangArr" :key="xytijianshixiang.id" class="anime-card">
          <router-link :to="'/qtMenu/xytijianshixiangDetails?id='+xytijianshixiang.id" style="text-decoration: none;">
            <div class="gonggao-image">
              <el-image :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xytijianshixiang.img" fit="cover" />
            </div>
            <div class="gonggao-content">
              <h4 class="gonggao-title">{{xytijianshixiang.tijiant}}</h4>
              <span class="gonggao-time">xxxxxxx</span>
            </div>
          </router-link>
        </div>
      </div>
    </div>

    <!-- 分页 -->
    <div class="pagination-section">
      <el-button-group>
        <el-button @click="pre_page" type="primary" icon="el-icon-arrow-left">上一页</el-button>
        <el-button type="primary" disabled>第{{ pageIndex + 1 }}页</el-button>
        <el-button @click="next_page" type="primary" icon="el-icon-arrow-right">下一页</el-button>
      </el-button-group>
    </div>
  </div>
</template>

<script>
  const searchXytijianshixiang = {
    components:{
    },
    data(){
      return{
        search:"",
        pageIndex: 0,
        pageSize:10,
        pageNum: 0,
        xytijianshixiangs:[],
        showXytijianshixiangArr:[]
      }
    },
    methods:{
      searchXytijianshixiangJson(){
        var _this = this
        this.axios.post("/searchXytijianshixiangJson?search=" + _this.search,{}).then(res=>{
          _this.xytijianshixiangs = res.data.xytijianshixiangs
          _this.goPage(0)
        })

      },
      goPage(pageIndex){
        this.pageNum = Math.ceil(this.xytijianshixiangs.length / this.pageSize)
        //最少都有一页
        if (this.pageNum == 0){
          this.pageNum = 1
        }
        this.showXytijianshixiangArr = this.xytijianshixiangs.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
        if (this.pageIndex > 0 && this.showXytijianshixiangArr.length == 0){
          pageIndex = --this.pageIndex
          this.showXytijianshixiangArr = this.xytijianshixiangs.slice(pageIndex*this.pageSize,(pageIndex+1)*this.pageSize)
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
    //可以操作data和methods
    created() {
      var _this = this
      this.searchXytijianshixiangJson()
    },
    //可以操作dom
    mounted() {

    }
  }
  export default searchXytijianshixiang
</script>

<style scoped lang="scss">
  @import url('https://fonts.googleapis.com/css2?family=ZCOOL+KuaiLe&display=swap');
  .anime-search-container {
    padding: 20px;
    max-width: 1200px;
    margin: 0 auto;
    min-height: 100vh;
    background: linear-gradient(135deg, #f5e6ff 0%, #d0e6ff 100%);
    font-family: 'ZCOOL KuaiLe', 'Smiley Sans', '微软雅黑', sans-serif;
  }

  .search-section {
    margin-bottom: 40px;
    .search-box {
      display: flex;
      gap: 20px;
      max-width: 800px;
      margin: 0 auto;
      background: rgba(255, 255, 255, 0.95);
      padding: 20px;
      border-radius: 16px;
      box-shadow: 0 4px 20px rgba(107, 115, 255, 0.10);
      .search-input {
        flex: 1;
        font-size: 18px;
        font-family: 'ZCOOL KuaiLe', cursive;
      }
      .el-button {
        border-radius: 20px;
        font-size: 16px;
        font-family: 'ZCOOL KuaiLe', cursive;
      }
    }
  }

  .section-title {
    font-size: 24px;
    color: #6B73FF;
    margin-bottom: 20px;
    font-family: 'ZCOOL KuaiLe', cursive;
    letter-spacing: 2px;
  }

  .anime-list-section {
    margin-bottom: 40px;
    .section-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 20px;
      background: rgba(255, 255, 255, 0.95);
      padding: 20px;
      border-radius: 16px;
      box-shadow: 0 4px 20px rgba(107, 115, 255, 0.10);
    }
    .anime-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
      gap: 24px;
      padding: 20px;
      background: rgba(255, 255, 255, 0.95);
      border-radius: 16px;
      box-shadow: 0 4px 20px rgba(107, 115, 255, 0.10);
    }
    .anime-card {
      background: #fff;
      border-radius: 16px;
      box-shadow: 0 2px 8px #ffb6b933;
      overflow: hidden;
      transition: transform 0.2s;
      &:hover {
        transform: translateY(-6px) scale(1.03);
        box-shadow: 0 8px 24px #6B73FF33;
      }
      .gonggao-image {
        width: 100%;
        height: 140px;
        .el-image {
          width: 100%;
          height: 100%;
          border-radius: 16px 16px 0 0;
        }
      }
      .gonggao-content {
        padding: 16px;
        .gonggao-title {
          font-size: 20px;
          color: #ff6f91;
          font-family: 'ZCOOL KuaiLe', cursive;
          margin-bottom: 8px;
        }
        .gonggao-desc {
          font-size: 15px;
          color: #333;
          opacity: 0.85;
          margin-bottom: 10px;
        }
        .gonggao-time {
          font-size: 13px;
          color: #6B73FF;
        }
      }
    }
  }

  .pagination-section {
    display: flex;
    justify-content: center;
    margin-top: 40px;
    padding: 20px;

    .el-button-group {
      display: flex;
      gap: 12px;
    }

    .el-button {
      position: relative;
      border-radius: 50px;
      font-weight: bold;
      padding: 0 20px;
      min-width: 90px;
      height: 42px;
      background: linear-gradient(135deg, #ff9ebc, #6b73ff);
      color: #fff;
      font-family: 'ZCOOL KuaiLe', cursive;
      border: none;
      cursor: pointer;
      overflow: hidden;
      transition: all 0.3s ease, transform 0.2s ease;
      box-shadow: 0 4px 12px rgba(107, 115, 255, 0.2);

      &:hover {
        transform: translateY(-4px) scale(1.05);
        box-shadow: 0 6px 16px rgba(107, 115, 255, 0.35);
      }

      &.is-disabled {
        background: #ffe5e9;
        color: #aaa;
        cursor: not-allowed;
        box-shadow: none;
        transform: none;
      }

      /* 星光和气泡动画 */
      &::before, &::after {
        content: '';
        position: absolute;
        border-radius: 50%;
        pointer-events: none;
      }

      &::before {
        width: 12px;
        height: 12px;
        background: radial-gradient(circle, #fff9, #fff0);
        top: -6px;
        left: 10%;
        animation: sparkle 1.5s infinite;
      }

      &::after {
        width: 8px;
        height: 8px;
        background: radial-gradient(circle, #fff9, #fff0);
        bottom: -4px;
        right: 15%;
        animation: sparkle 1.8s infinite;
      }
    }

    @keyframes sparkle {
      0%, 100% { transform: scale(1) translateY(0); opacity: 0.6; }
      50% { transform: scale(1.5) translateY(-6px); opacity: 1; }
    }
  }
</style>
