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
  @import url('https://fonts.googleapis.com/css2?family=ZCOOL+KuaiLe&display=swap');
  .anime-home {
    min-height: 100vh;
    background: linear-gradient(135deg, #f5e6ff 0%, #d0e6ff 100%);
    padding: 30px 0 60px 0;
    font-family: 'ZCOOL KuaiLe', 'Smiley Sans', '微软雅黑', sans-serif;
    position: relative;
    overflow: hidden;
  }
  .anime-banner {
    margin: 0 auto 40px auto;
    max-width: 1100px;
    border-radius: 24px;
    overflow: hidden;
    box-shadow: 0 8px 32px rgba(107, 115, 255, 0.12);
    .banner-item {
      position: relative;
      height: 380px;
      .banner-image {
        width: 100%;
        height: 100%;
        border-radius: 24px;
        box-shadow: 0 2px 12px rgba(255, 182, 185, 0.10);
      }
      .banner-info {
        position: absolute;
        left: 40px;
        bottom: 40px;
        background: rgba(255,255,255,0.85);
        border-radius: 16px;
        padding: 18px 28px;
        box-shadow: 0 2px 12px rgba(107, 115, 255, 0.10);
        h2 {
          font-size: 30px;
          color: #6B73FF;
          margin-bottom: 8px;
          font-family: 'ZCOOL KuaiLe', cursive;
        }
        p {
          font-size: 16px;
          color: #333;
          opacity: 0.85;
        }
      }
    }
  }
  .section-block {
    margin: 40px auto 0 auto;
    max-width: 1100px;
  }
  .section-title {
    font-size: 26px;
    color: #ff6f91;
    margin-bottom: 24px;
    font-family: 'ZCOOL KuaiLe', cursive;
    letter-spacing: 2px;
    position: relative;
    padding-left: 18px;
    &::before {
      content: '';
      position: absolute;
      left: 0; top: 8px;
      width: 8px; height: 24px;
      background: linear-gradient(180deg, #6B73FF 0%, #ffb6b9 100%);
      border-radius: 4px;
    }
  }
  .notice-card {
    border-radius: 18px;
    overflow: hidden;
    margin-bottom: 24px;
    background: rgba(255,255,255,0.96);
    box-shadow: 0 2px 12px rgba(255, 182, 185, 0.10);
    display: flex;
    flex-direction: column;
    align-items: center;
    .notice-img {
      width: 100%;
      height: 140px;
      object-fit: cover;
      border-radius: 18px 18px 0 0;
      margin-bottom: 10px;
    }
    .notice-content {
      padding: 10px 12px 16px 12px;
      width: 100%;
      h3 {
        font-size: 18px;
        color: #6B73FF;
        margin-bottom: 6px;
        font-family: 'ZCOOL KuaiLe', cursive;
      }
      .notice-desc {
        font-size: 14px;
        color: #333;
        margin-bottom: 8px;
        opacity: 0.85;
      }
      .notice-time {
        font-size: 12px;
        color: #aaa;
      }
    }
  }
  .post-card {
    border-radius: 18px;
    overflow: hidden;
    margin-bottom: 24px;
    background: rgba(255,255,255,0.96);
    box-shadow: 0 2px 12px rgba(107, 115, 255, 0.10);
    display: flex;
    flex-direction: column;
    .post-header {
      display: flex;
      align-items: center;
      padding: 16px 16px 0 16px;
      .el-avatar {
        margin-right: 12px;
        border: 2px solid #ffb6b9;
        box-shadow: 0 2px 8px #ffb6b933;
      }
      .post-user {
        display: flex;
        flex-direction: column;
        .nickname {
          font-size: 15px;
          color: #6B73FF;
          font-family: 'ZCOOL KuaiLe', cursive;
        }
        .post-time {
          font-size: 12px;
          color: #aaa;
        }
      }
    }
    .post-content {
      padding: 10px 16px 18px 16px;
      h3 {
        font-size: 17px;
        color: #ff6f91;
        margin-bottom: 6px;
        font-family: 'ZCOOL KuaiLe', cursive;
      }
      p {
        font-size: 14px;
        color: #333;
        opacity: 0.85;
        margin: 0;
      }
    }
  }
</style>
