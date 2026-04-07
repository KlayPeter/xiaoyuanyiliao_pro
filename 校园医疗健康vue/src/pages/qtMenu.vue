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
  .anime-layout {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    background-color: #f5f7fa;
  }

  .anime-header {
    background-color: #ffffff;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
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

      img {
        height: 40px;
        margin-right: 12px;
      }

      span {
        font-size: 22px;
        font-weight: 600;
        color: #303133;
      }
    }

    .nav-menu {
      border-bottom: none;
      margin: 0 20px;
      
      .el-menu-item {
        font-size: 16px;
        color: #606266;
        
        &:hover, &.is-active {
          color: #409EFF;
          background-color: transparent;
        }
      }
    }

    .user-actions {
      display: flex;
      align-items: center;
      gap: 12px;

      a {
        color: #409EFF;
        font-weight: 500;
        text-decoration: none;

        &:hover {
          color: #66b1ff;
        }
      }
    }
  }

  .main-content {
    flex: 1;
    margin-top: 60px;
    padding: 24px 0 0 0;
    min-height: 80vh;
  }

  .copyright {
    text-align: center;
    padding: 24px 0;
    color: #909399;
    font-size: 14px;
    background-color: #ffffff;
    margin-top: 40px;
  }
</style>
