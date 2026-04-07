<template>
    <div class="anime-detail-container">
        <el-image
                v-if="xiaoyuanyisheng.img"
                class="gonggao-image"
                :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xiaoyuanyisheng.img"
                fit="cover"
        />
        <!-- 公告头部信息 -->
        <div class="gonggao-header">
                    <div class="detail-title">账号：{{xiaoyuanyisheng.username}}</div>
                        <span class="detail-title">密码：{{ xiaoyuanyisheng.password }}</span>
                        <span class="detail-title">医生姓名：{{ xiaoyuanyisheng.schoolyishengname }}</span>
                        <span class="detail-title">医生性别：{{ xiaoyuanyisheng.schoolyssex }}</span>
                        <span class="detail-title">医生年龄：{{ xiaoyuanyisheng.schoolysage }}</span>
                        <span class="detail-title">医生联系电话：{{ xiaoyuanyisheng.schoolysphone }}</span>
                        <div class="gonggao-content" >
                            医生简介： {{ xiaoyuanyisheng.schoolysjianjie }}
                        </div>
        </div>
    </div>
</template>
<script>

  const xiaoyuanyishengDetails = {
    components: {
    },
    data() {
      return {
        xiaoyuanyisheng: {}
      }
    },
    methods: {},
    //可以操作data和methods
    created() {
      var _this = this
      this.axios.post("xiaoyuanyishengDetailsJson?id=" + _this.$route.query.id, {}).then(res => {
        _this.xiaoyuanyisheng = res.data.xiaoyuanyisheng
      })
    },
    //可以操作dom
    mounted() {

    }
  }
  export default xiaoyuanyishengDetails
</script>
<style scoped lang="scss">
  
  .anime-detail-container {
    max-width: 800px;
    margin: 40px auto 0 auto;
    background: rgba(255,255,255,0.98);
    border-radius: 24px;
    box-shadow: 0 8px 32px rgba(107, 115, 255, 0.10);
    padding: 40px 32px 32px 32px;
    
  }
  .gonggao-header {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 18px;
    .gonggao-title {
      font-size: 28px;
      color: #409EFF;
      
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
