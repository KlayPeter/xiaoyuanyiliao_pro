<template>
    <div class="anime-home">
        <!-- 顶部动漫轮播 -->
        <el-carousel height="380px" class="anime-banner" :interval="4000" type="card">
            <el-carousel-item >
                <div class="banner-item">
                    <el-image
                            src="/src/assets/qt/images/动漫1.png"
                            fit="cover"
                            class="banner-image"
                    />
                    <div class="banner-info">
                        <h2>xxxxxx</h2>
                    </div>
                </div>
            </el-carousel-item>
            <el-carousel-item >
                <div class="banner-item">
                    <el-image
                            src="/src/assets/qt/images/动漫2.png"
                            fit="cover"
                            class="banner-image"
                    />
                    <div class="banner-info">
                        <h2>xxxxxx</h2>
                    </div>
                </div>
            </el-carousel-item>
            <el-carousel-item >
                <div class="banner-item">
                    <el-image
                            src="/src/assets/qt/images/动漫3.png"
                            fit="cover"
                            class="banner-image"
                    />
                    <div class="banner-info">
                        <h2>xxxxxx</h2>
                    </div>
                </div>
            </el-carousel-item>
        </el-carousel>
                        <!-- 公告区 -->
                <div class="section-block">
                    <h2 class="section-title">最新校园医生</h2>
                    <el-row :gutter="24">
                        <el-col :span="8" v-for="(xiaoyuanyisheng,index) in xiaoyuanyishengs" :key="xiaoyuanyisheng.id">
                            <router-link :to="'/qtMenu/xiaoyuanyishengDetails?id=' + xiaoyuanyisheng.id" style="text-decoration: none;">
                                <el-card class="notice-card" shadow="hover">
                                    <el-image
                                            :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xiaoyuanyisheng.img"
                                            fit="cover"
                                            class="notice-img"
                                    />
                                    <div class="notice-content">
                                        <h3>{{xiaoyuanyisheng.username}}</h3>
                                        <p class="notice-desc">xxxxxxx</p>
                                        <span class="notice-time">xxxxxx</span>
                                    </div>
                                </el-card>
                            </router-link>
                        </el-col>
                    </el-row>
                </div>
                <!-- 公告区 -->
                <div class="section-block">
                    <h2 class="section-title">最新校园体检事项</h2>
                    <el-row :gutter="24">
                        <el-col :span="8" v-for="(xytijianshixiang,index) in xytijianshixiangs" :key="xytijianshixiang.id">
                            <router-link :to="'/qtMenu/xytijianshixiangDetails?id=' + xytijianshixiang.id" style="text-decoration: none;">
                                <el-card class="notice-card" shadow="hover">
                                    <el-image
                                            :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xytijianshixiang.img"
                                            fit="cover"
                                            class="notice-img"
                                    />
                                    <div class="notice-content">
                                        <h3>{{xytijianshixiang.tijiant}}</h3>
                                        <p class="notice-desc">xxxxxxx</p>
                                        <span class="notice-time">xxxxxx</span>
                                    </div>
                                </el-card>
                            </router-link>
                        </el-col>
                    </el-row>
                </div>
                <!-- 公告区 -->
                <div class="section-block">
                    <h2 class="section-title">最新校园公告</h2>
                    <el-row :gutter="24">
                        <el-col :span="8" v-for="(xyggao,index) in xyggaos" :key="xyggao.id">
                            <router-link :to="'/qtMenu/xyggaoDetails?id=' + xyggao.id" style="text-decoration: none;">
                                <el-card class="notice-card" shadow="hover">
                                    <el-image
                                            :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xyggao.img"
                                            fit="cover"
                                            class="notice-img"
                                    />
                                    <div class="notice-content">
                                        <h3>{{xyggao.xytitle}}</h3>
                                        <p class="notice-desc">xxxxxxx</p>
                                        <span class="notice-time">xxxxxx</span>
                                    </div>
                                </el-card>
                            </router-link>
                        </el-col>
                    </el-row>
                </div>
    </div>
</template>

<script>


  const index = {
    components: {

    },
    data() {
      return {
        xiaoyuanyishengs: [],
        xytijianshixiangs: [],
        xyggaos: [],

      }
    },
    methods: {},
    //可以操作data和methods
    created() {
      var _this = this
      this.axios.post('/indexJson', {}).then(res => {
        _this.xiaoyuanyishengs = res.data.xiaoyuanyishengs.slice(0,6)
        _this.xytijianshixiangs = res.data.xytijianshixiangs.slice(0,6)
        _this.xyggaos = res.data.xyggaos.slice(0,6)
      })
    },
    //可以操作dom
    mounted() {

    }
  }
  export default index
</script>

<style scoped lang="scss">
  .anime-home {
    min-height: 100vh;
    background-color: #f5f7fa;
    padding: 30px 0 60px 0;
  }
  .anime-banner {
    margin: 0 auto 40px auto;
    max-width: 1200px;
    border-radius: 8px;
    overflow: hidden;
    .banner-item {
      position: relative;
      height: 380px;
      .banner-image {
        width: 100%;
        height: 100%;
        border-radius: 8px;
      }
      .banner-info {
        position: absolute;
        left: 30px;
        bottom: 30px;
        background: rgba(255,255,255,0.9);
        border-radius: 4px;
        padding: 16px 24px;
        box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
        h2 {
          font-size: 24px;
          color: #303133;
          margin-bottom: 8px;
        }
      }
    }
  }
  .section-block {
    margin: 40px auto 0 auto;
    max-width: 1200px;
    padding: 0 20px;
  }
  .section-title {
    font-size: 24px;
    color: #303133;
    margin-bottom: 24px;
    font-weight: 600;
    position: relative;
    padding-left: 14px;
    &::before {
      content: '';
      position: absolute;
      left: 0; top: 4px;
      width: 4px; height: 24px;
      background-color: #409EFF;
      border-radius: 2px;
    }
  }
  .notice-card {
    border-radius: 8px;
    margin-bottom: 24px;
    border: none;
    .notice-img {
      width: 100%;
      height: 160px;
      object-fit: cover;
      display: block;
    }
    .notice-content {
      padding: 16px;
      h3 {
        font-size: 16px;
        color: #303133;
        margin-bottom: 8px;
        font-weight: 600;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
      }
      .notice-desc {
        font-size: 14px;
        color: #606266;
        margin-bottom: 12px;
        line-height: 1.5;
        height: 42px;
        overflow: hidden;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
      }
      .notice-time {
        font-size: 12px;
        color: #909399;
      }
    }
  }
</style>
