<template>
    <div class="anime-detail-container">
        <el-image
                v-if="xytijianshixiang.img"
                class="gonggao-image"
                :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xytijianshixiang.img"
                fit="cover"
        />
        <!-- 公告头部信息 -->
        <div class="gonggao-header">
                    <div class="detail-title">体检标题：{{xytijianshixiang.tijiant}}</div>
                        <div class="gonggao-content" >
                            体检内容： {{ xytijianshixiang.tijiancontent }}
                        </div>
                        <div class="gonggao-content" >
                            体检注意事项： {{ xytijianshixiang.tijianzhuyi }}
                        </div>
                        <div class="gonggao-content" >
                            体检位置： {{ xytijianshixiang.tijianadress }}
                        </div>
                        <span class="detail-title">体检时间：{{ xytijianshixiang.tijiantime }}</span>
                        <span class="detail-title">负责医生：{{ xytijianshixiang.xiaoyuanyisheng }}</span>
                        <span class="detail-title">负责医生id：{{ xytijianshixiang.xiaoyuanyishengid }}</span>
        </div>
    </div>
</template>
<script>

  const xytijianshixiangDetails = {
    components: {
    },
    data() {
      return {
        xytijianshixiang: {}
      }
    },
    methods: {},
    //可以操作data和methods
    created() {
      var _this = this
      this.axios.post("xytijianshixiangDetailsJson?id=" + _this.$route.query.id, {}).then(res => {
        _this.xytijianshixiang = res.data.xytijianshixiang
      })
    },
    //可以操作dom
    mounted() {

    }
  }
  export default xytijianshixiangDetails
</script>
<style scoped lang="scss">
  @import url('https://fonts.googleapis.com/css2?family=ZCOOL+KuaiLe&display=swap');
  .anime-detail-container {
    max-width: 800px;
    margin: 40px auto 0 auto;
    background: rgba(255,255,255,0.98);
    border-radius: 24px;
    box-shadow: 0 8px 32px rgba(107, 115, 255, 0.10);
    padding: 40px 32px 32px 32px;
    font-family: 'ZCOOL KuaiLe', 'Smiley Sans', '微软雅黑', sans-serif;
  }
  .gonggao-header {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 18px;
    .gonggao-title {
      font-size: 28px;
      color: #6B73FF;
      font-family: 'ZCOOL KuaiLe', cursive;
      margin-bottom: 8px;
      letter-spacing: 2px;
    }
    .gonggao-time {
      font-size: 14px;
      color: #aaa;
    }
  }
  .gonggao-image {
    width: 100%;
    max-width: 600px;
    height: 240px;
    object-fit: cover;
    border-radius: 16px;
    margin-bottom: 24px;
    box-shadow: 0 2px 8px #ffb6b933;
  }
  .gonggao-content {
    font-size: 17px;
    color: #333;
    line-height: 2;
    min-height: 120px;
    word-break: break-all;
    background: rgba(245, 230, 255, 0.15);
    border-radius: 16px;
    padding: 24px 18px;
    box-shadow: 0 2px 8px #6B73FF11;
  }
</style>
