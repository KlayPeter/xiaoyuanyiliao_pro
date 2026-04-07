<template>
  <div class="anime-layout">
    <!-- 顶部动漫风格导航栏 -->
    <el-header class="anime-header">
      <div class="header-content">
        <div class="logo">
          <img src="@/assets/qt/images/img.png"  />
          <span>校园医疗健康平台</span>
        </div>
        <el-menu
                mode="horizontal"
                :router="true"
                class="nav-menu"
                :default-active="$route.path"
                :ellipsis="false"
        >
          <el-menu-item index="/qtMenu/index">首页</el-menu-item>
                        <el-menu-item index="/qtMenu/searchXiaoyuanyisheng">校园医生</el-menu-item>
              <el-menu-item index="/qtMenu/searchXytijianshixiang">校园体检事项</el-menu-item>
              <el-menu-item index="/qtMenu/searchXyggao">校园公告</el-menu-item>
        </el-menu>
        <div class="user-actions">
          <router-link v-if="!role" to="/login"><el-button type="primary">登录</el-button></router-link>
          <router-link v-if="!role" to="/register"><el-button>注册</el-button></router-link>
              <router-link v-if="role === '管理员'" to="/htMenu/adminIndex">个人中心</router-link>
              <router-link v-if="role === '校园医生'" to="/htMenu/xiaoyuanyishengIndex">个人中心</router-link>
              <router-link v-if="role === '校园用户'" to="/htMenu/xyyiliaoyhIndex">个人中心</router-link>
        </div>
      </div>
    </el-header>

    <!-- 主要内容区 -->
    <div class="main-content">
      <router-view />
    </div>

    <div class="copyright">
      <p>© 校园医疗健康平台. All rights reserved.</p>
    </div>
  </div>
</template>

<script>
  // import { ref } from 'vue'

  import { useScroll } from '@vueuse/core'

  const qtMenu = {
    data(){
      return{
        role:null,
        y:0
      }
    },
    method:{

    },
    created(){
      //if no exit,return null
      this.role = localStorage.getItem("role")
    },
    mounted(){
      const { y } = useScroll(window)
      this.y = y
    }
  }
  export default qtMenu
</script>
<style scoped lang="scss">
  @import url('https://fonts.googleapis.com/css2?family=ZCOOL+KuaiLe&display=swap');
  .anime-layout {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    font-family: 'ZCOOL KuaiLe', 'Smiley Sans', '微软雅黑', sans-serif;
    background: linear-gradient(135deg, #f5e6ff 0%, #d0e6ff 100%);
  }

  .anime-header {
    background: linear-gradient(90deg, #ffb6b9 0%, #6B73FF 100%);
    box-shadow: 0 2px 12px 0 rgba(107, 115, 255, 0.08);
    position: fixed;
    width: 100%;
    top: 0;
    z-index: 1000;

    .header-content {
      max-width: 1200px;
      margin: 0 auto;
      display: flex;
      align-items: center;
      justify-content: space-between;
      height: 100%;
      padding: 0 20px;
    }

    .logo {
      display: flex;
      align-items: center;
      gap: 10px;

      img {
        height: 40px;
        border-radius: 50%;
        background: #fff;
        box-shadow: 0 2px 8px #ffb6b9;
        margin-right: 8px;
      }

      span {
        font-size: 26px;
        font-weight: bold;
        color: #fff;
        letter-spacing: 2px;
        font-family: 'ZCOOL KuaiLe', cursive;
        text-shadow: 0 2px 8px #6B73FF44;
      }
    }

    .nav-menu {
      border-bottom: none;
      margin: 0 20px;
      background: transparent;

      .el-menu-item {
        font-size: 18px;
        font-family: 'ZCOOL KuaiLe', cursive;
        color: #fff;
        border-radius: 16px;
        margin: 0 8px;
        transition: background 0.2s;

        &:hover, &.is-active {
          background: #fff;
          color: #6B73FF;
        }
      }
    }

    .user-actions {
      display: flex;
      align-items: center;
      gap: 10px;

      .el-button {
        border-radius: 20px;
        font-family: 'ZCOOL KuaiLe', cursive;
        font-size: 16px;
      }

      a {
        color: #fff;
        font-weight: bold;
        margin-left: 8px;

        &:hover {
          color: #ffb6b9;
        }
      }
    }
  }

  .main-content {
    flex: 1;
    margin-top: 70px;
    padding: 24px 0 0 0;
    min-height: 80vh;
    background: url('/src/assets/qt/images/200.png') no-repeat right bottom;
    background-size: 300px auto;
  }

  .copyright {
    text-align: center;
    margin-top: 40px;
    padding: 24px 0 12px 0;
    color: #6B73FF;
    font-size: 15px;
    letter-spacing: 1px;
    font-family: 'ZCOOL KuaiLe', cursive;
  }
</style>
