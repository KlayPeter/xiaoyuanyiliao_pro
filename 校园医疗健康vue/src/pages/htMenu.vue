<template>
  <div class="admin-container">
    <!-- 侧边栏 -->
    <aside class="anime-sidebar">
      <div class="logo anime-logo">
        <img src="../assets/ht/images/logo.png" alt="动漫logo" />
        <span>
           <router-link class="logo-link" to="/qtmenu/index">校园医疗健康平台</router-link>
        </span>
      </div>
      <nav>
        <el-menu
                v-if="role === '管理员'"
                :default-active="activeIndex"
                class="admin-menu"
                background-color="transparent"
                text-color="#fff"
                active-text-color="#6B73FF"
                @select="handleSelect"
        >
          <template v-for="item in adminMenu" :key="item.index">
            <el-sub-menu :index="item.index">
              <template #title>
                <i :class="item.icon"></i>
                <span>{{ item.title }}</span>
              </template>
              <el-menu-item v-for="sub in item.children" :key="sub.index" :index="sub.index">
                <i :class="sub.icon"></i>
                <span>
                    <router-link class="menu-link" :to="sub.to" @click="sub.logout ? logout() : null">{{ sub.title }}</router-link>
                </span>
              </el-menu-item>
            </el-sub-menu>
          </template>
        </el-menu>
                    <el-menu
                    v-else-if="role === '校园医生'"
                    :default-active="activeIndex"
                    class="admin-menu"
                    background-color="transparent"
                    text-color="#fff"
                    active-text-color="#6B73FF"
            >
              <template v-for="item in xiaoyuanyishengMenu" :key="item.index">
                <el-sub-menu :index="item.index">
                  <template #title>
                    <i :class="item.icon"></i>
                    <span>{{ item.title }}</span>
                  </template>
                  <el-menu-item v-for="sub in item.children" :key="sub.index" :index="sub.index">
                    <i :class="sub.icon"></i>
                    <span>
                        <router-link class="menu-link" :to="sub.to" @click="sub.logout ? logout() : null">{{ sub.title }}</router-link>
                    </span>
                  </el-menu-item>
                </el-sub-menu>
              </template>
            </el-menu>
            <el-menu
                    v-else-if="role === '校园用户'"
                    :default-active="activeIndex"
                    class="admin-menu"
                    background-color="transparent"
                    text-color="#fff"
                    active-text-color="#6B73FF"
            >
              <template v-for="item in xyyiliaoyhMenu" :key="item.index">
                <el-sub-menu :index="item.index">
                  <template #title>
                    <i :class="item.icon"></i>
                    <span>{{ item.title }}</span>
                  </template>
                  <el-menu-item v-for="sub in item.children" :key="sub.index" :index="sub.index">
                    <i :class="sub.icon"></i>
                    <span>
                        <router-link class="menu-link" :to="sub.to" @click="sub.logout ? logout() : null">{{ sub.title }}</router-link>
                    </span>
                  </el-menu-item>
                </el-sub-menu>
              </template>
            </el-menu>
      </nav>
    </aside>
    <!-- 主内容区 -->
    <main class="anime-main-content">
      <div class="content">
        <router-view></router-view>
      </div>
    </main>
  </div>
</template>

<script>
  export default {
    name: 'htMenu',
    data() {
      return {
        role: '',
        activeIndex: '',
        adminMenu: [
          {
            index: '0',
            icon: 'el-icon-user',
            title: '个人中心',
            children: [
              { index: '0-1', icon: 'el-icon-user', title: '个人中心', to: '/htMenu/adminIndex' }
            ]
          },
              {
                index: '2',
                icon: 'el-icon-user',
                title: '校园医生管理',
                children: [
                  { index: '2-1', icon: 'el-icon-plus', title: '添加校园医生', to: '/htMenu/addXiaoyuanyisheng' },
                  { index: '2-2', icon: 'el-icon-s-management', title: '校园医生列表', to: '/htMenu/xiaoyuanyishengList' }
                ]
              },
              {
                index: '3',
                icon: 'el-icon-user',
                title: '校园用户管理',
                children: [
                  { index: '3-1', icon: 'el-icon-plus', title: '添加校园用户', to: '/htMenu/addXyyiliaoyh' },
                  { index: '3-2', icon: 'el-icon-s-management', title: '校园用户列表', to: '/htMenu/xyyiliaoyhList' }
                ]
              },
              {
                index: '4',
                icon: 'el-icon-user',
                title: '校园医疗排班管理',
                children: [
                  { index: '4-1', icon: 'el-icon-plus', title: '添加校园医疗排班', to: '/htMenu/addXyyiliaopaiban' },
                  { index: '4-2', icon: 'el-icon-s-management', title: '校园医疗排班列表', to: '/htMenu/xyyiliaopaibanList' }
                ]
              },
              // {
              //   index: '5',
              //   icon: 'el-icon-user',
              //   title: '校园医疗排班预约管理',
              //   children: [
              //     { index: '5-1', icon: 'el-icon-plus', title: '添加校园医疗排班预约', to: '/htMenu/addXyyiliaopaibanyuyue' },
              //     { index: '5-2', icon: 'el-icon-s-management', title: '校园医疗排班预约列表', to: '/htMenu/xyyiliaopaibanyuyueList' }
              //   ]
              // },
              // {
              //   index: '6',
              //   icon: 'el-icon-user',
              //   title: '挂号咨询结果管理',
              //   children: [
              //     { index: '6-1', icon: 'el-icon-plus', title: '添加挂号咨询结果', to: '/htMenu/addGuahaozixunjieguo' },
              //     { index: '6-2', icon: 'el-icon-s-management', title: '挂号咨询结果列表', to: '/htMenu/guahaozixunjieguoList' }
              //   ]
              // },
              {
                index: '7',
                icon: 'el-icon-user',
                title: '用户病例记录管理',
                children: [
                  // { index: '7-1', icon: 'el-icon-plus', title: '添加用户病例记录', to: '/htMenu/addYhbinglijilv' },
                  { index: '7-2', icon: 'el-icon-s-management', title: '用户病例记录列表', to: '/htMenu/yhbinglijilvList' }
                ]
              },
              // {
              //   index: '8',
              //   icon: 'el-icon-user',
              //   title: '预约对话管理',
              //   children: [
              //     { index: '8-1', icon: 'el-icon-plus', title: '添加预约对话', to: '/htMenu/addYuyueduihua' },
              //     { index: '8-2', icon: 'el-icon-s-management', title: '预约对话列表', to: '/htMenu/yuyueduihuaList' }
              //   ]
              // },
              {
                index: '9',
                icon: 'el-icon-user',
                title: '预约评价管理',
                children: [
                  // { index: '9-1', icon: 'el-icon-plus', title: '添加预约评价', to: '/htMenu/addYuyuepingjia' },
                  { index: '9-2', icon: 'el-icon-s-management', title: '预约评价列表', to: '/htMenu/yuyuepingjiaList' }
                ]
              },
              {
                index: '10',
                icon: 'el-icon-user',
                title: '校园医疗药品管理',
                children: [
                  { index: '10-1', icon: 'el-icon-plus', title: '添加校园医疗药品', to: '/htMenu/addXyyiliaoyaoping' },
                  { index: '10-2', icon: 'el-icon-s-management', title: '校园医疗药品列表', to: '/htMenu/xyyiliaoyaopingList' }
                ]
              },
              {
                index: '11',
                icon: 'el-icon-user',
                title: '校园体检事项管理',
                children: [
                  { index: '11-1', icon: 'el-icon-plus', title: '添加校园体检事项', to: '/htMenu/addXytijianshixiang' },
                  { index: '11-2', icon: 'el-icon-s-management', title: '校园体检事项列表', to: '/htMenu/xytijianshixiangList' }
                ]
              },
              // {
              //   index: '12',
              //   icon: 'el-icon-user',
              //   title: '体检用户预约管理',
              //   children: [
              //     { index: '12-1', icon: 'el-icon-plus', title: '添加体检用户预约', to: '/htMenu/addTijianyhyuyue' },
              //     { index: '12-2', icon: 'el-icon-s-management', title: '体检用户预约列表', to: '/htMenu/tijianyhyuyueList' }
              //   ]
              // },
              {
                index: '13',
                icon: 'el-icon-user',
                title: '健康档案管理',
                children: [
                  // { index: '13-1', icon: 'el-icon-plus', title: '添加健康档案', to: '/htMenu/addJiankangdangan' },
                  { index: '13-2', icon: 'el-icon-s-management', title: '健康档案列表', to: '/htMenu/jiankangdanganList' }
                ]
              },
              {
                index: '14',
                icon: 'el-icon-user',
                title: '校园公告管理',
                children: [
                  { index: '14-1', icon: 'el-icon-plus', title: '添加校园公告', to: '/htMenu/addXyggao' },
                  { index: '14-2', icon: 'el-icon-s-management', title: '校园公告列表', to: '/htMenu/xyggaoList' }
                ]
              },
              {
                index: '15',
                icon: 'el-icon-user',
                title: '药品采购提醒管理',
                children: [
                  // { index: '15-1', icon: 'el-icon-plus', title: '添加药品采购提醒', to: '/htMenu/addYiliaoyaopingtixing' },
                  { index: '15-2', icon: 'el-icon-s-management', title: '药品采购提醒列表', to: '/htMenu/yiliaoyaopingtixingList' }
                ]
              },
          {
            index: '999999999',
            icon: 'el-icon-user',
            title: '退出系统',
            children: [
              { index: '999999999-1', icon: 'el-icon-plus', title: '退出系统', to: '', logout: true }
            ]
          }
        ],
        xiaoyuanyishengMenu: [
          {
            index: '0',
            icon: 'el-icon-user',
            title: '个人中心',
            children: [
              { index: '0-1', icon: 'el-icon-user', title: '个人中心', to: '/htMenu/xiaoyuanyishengIndex' }
            ]
          },
              {
                index: '4',
                icon: 'el-icon-user',
                title: '校园医疗排班管理',
                children: [
                  // { index: '4-1', icon: 'el-icon-plus', title: '添加校园医疗排班', to: '/htMenu/xiaoyuanyishengAddXyyiliaopaiban' },
                  { index: '4-2', icon: 'el-icon-s-management', title: '校园医疗排班列表', to: '/htMenu/xiaoyuanyishengXyyiliaopaibanList' }              ]
              },
              {
                index: '5',
                icon: 'el-icon-user',
                title: '校园医疗排班预约管理',
                children: [
                  // { index: '5-1', icon: 'el-icon-plus', title: '添加校园医疗排班预约', to: '/htMenu/xiaoyuanyishengAddXyyiliaopaibanyuyue' },
                  { index: '5-2', icon: 'el-icon-s-management', title: '校园医疗排班预约列表', to: '/htMenu/xiaoyuanyishengXyyiliaopaibanyuyueList' }              ]
              },
              {
                index: '6',
                icon: 'el-icon-user',
                title: '挂号咨询结果管理',
                children: [
                  // { index: '6-1', icon: 'el-icon-plus', title: '添加挂号咨询结果', to: '/htMenu/xiaoyuanyishengAddGuahaozixunjieguo' },
                  { index: '6-2', icon: 'el-icon-s-management', title: '挂号咨询结果列表', to: '/htMenu/xiaoyuanyishengGuahaozixunjieguoList' }              ]
              },
              {
                index: '11',
                icon: 'el-icon-user',
                title: '校园体检事项管理',
                children: [
                  // { index: '11-1', icon: 'el-icon-plus', title: '添加校园体检事项', to: '/htMenu/xiaoyuanyishengAddXytijianshixiang' },
                  { index: '11-2', icon: 'el-icon-s-management', title: '校园体检事项列表', to: '/htMenu/xiaoyuanyishengXytijianshixiangList' }              ]
              },
          {
            index: '999999999',
            icon: 'el-icon-user',
            title: '退出系统',
            children: [
              { index: '999999999-1', icon: 'el-icon-plus', title: '退出系统', to: '', logout: true }
            ]
          }
        ],
        xyyiliaoyhMenu: [
          {
            index: '0',
            icon: 'el-icon-user',
            title: '个人中心',
            children: [
              { index: '0-1', icon: 'el-icon-user', title: '个人中心', to: '/htMenu/xyyiliaoyhIndex' }
            ]
          },
              {
                index: '5',
                icon: 'el-icon-user',
                title: '校园医疗排班预约管理',
                children: [
                  { index: '5-1', icon: 'el-icon-plus', title: '添加校园医疗排班预约', to: '/htMenu/xyyiliaoyhAddXyyiliaopaibanyuyue' },
                  { index: '5-2', icon: 'el-icon-s-management', title: '校园医疗排班预约列表', to: '/htMenu/xyyiliaoyhXyyiliaopaibanyuyueList' }              ]
              },
              {
                index: '6',
                icon: 'el-icon-user',
                title: '挂号咨询结果管理',
                children: [
                  { index: '6-1', icon: 'el-icon-plus', title: '添加挂号咨询结果', to: '/htMenu/xyyiliaoyhAddGuahaozixunjieguo' },
                  { index: '6-2', icon: 'el-icon-s-management', title: '挂号咨询结果列表', to: '/htMenu/xyyiliaoyhGuahaozixunjieguoList' }              ]
              },
              {
                index: '7',
                icon: 'el-icon-user',
                title: '用户病例记录管理',
                children: [
                  { index: '7-1', icon: 'el-icon-plus', title: '添加用户病例记录', to: '/htMenu/xyyiliaoyhAddYhbinglijilv' },
                  { index: '7-2', icon: 'el-icon-s-management', title: '用户病例记录列表', to: '/htMenu/xyyiliaoyhYhbinglijilvList' }              ]
              },
              {
                index: '9',
                icon: 'el-icon-user',
                title: '预约评价管理',
                children: [
                  { index: '9-1', icon: 'el-icon-plus', title: '添加预约评价', to: '/htMenu/xyyiliaoyhAddYuyuepingjia' },
                  { index: '9-2', icon: 'el-icon-s-management', title: '预约评价列表', to: '/htMenu/xyyiliaoyhYuyuepingjiaList' }              ]
              },
              {
                index: '12',
                icon: 'el-icon-user',
                title: '体检用户预约管理',
                children: [
                  { index: '12-1', icon: 'el-icon-plus', title: '添加体检用户预约', to: '/htMenu/xyyiliaoyhAddTijianyhyuyue' },
                  { index: '12-2', icon: 'el-icon-s-management', title: '体检用户预约列表', to: '/htMenu/xyyiliaoyhTijianyhyuyueList' }              ]
              },
              {
                index: '13',
                icon: 'el-icon-user',
                title: '健康档案管理',
                children: [
                  { index: '13-1', icon: 'el-icon-plus', title: '添加健康档案', to: '/htMenu/xyyiliaoyhAddJiankangdangan' },
                  { index: '13-2', icon: 'el-icon-s-management', title: '健康档案列表', to: '/htMenu/xyyiliaoyhJiankangdanganList' }              ]
              },
          {
            index: '999999999',
            icon: 'el-icon-user',
            title: '退出系统',
            children: [
              { index: '999999999-1', icon: 'el-icon-plus', title: '退出系统', to: '', logout: true }
            ]
          }
        ],
      }
    },
    methods: {
      logout() {
        localStorage.removeItem('userinfo');
        localStorage.removeItem('role');
        this.axios.post('/logoutJson', {});
        this.$router.push('/login');
      },
      handleSelect(index) {
        this.activeIndex = index;
      }
    },
    created() {
      this.role = localStorage.getItem('role');
      this.activeIndex = this.$route.meta && this.$route.meta.menuIndex ? this.$route.meta.menuIndex : '';
    }
  }
</script>

<style scoped lang="scss">
  @import url('https://fonts.googleapis.com/css2?family=ZCOOL+KuaiLe&display=swap');
  .admin-container {
    display: flex;
    min-height: 100vh;
    background: linear-gradient(135deg, #f5e6ff 0%, #d0e6ff 100%);
  }
  .anime-sidebar {
    width: 240px;
    background: linear-gradient(135deg, #6B73FF 0%, #ffb6b9 100%);
    color: #fff;
    position: fixed;
    height: 100vh;
    left: 0;
    top: 0;
    z-index: 1000;
    box-shadow: 2px 0 16px #6B73FF33;
    border-top-right-radius: 32px;
    border-bottom-right-radius: 32px;
    display: flex;
    flex-direction: column;
    align-items: center;
    .anime-logo {
      height: 80px;
      width: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
      background: rgba(255,255,255,0.10);
      border-top-right-radius: 32px;
      img {
        width: 48px;
        height: 48px;
        margin-right: 14px;
        border-radius: 50%;
        background: #fff;
        box-shadow: 0 2px 8px #ffb6b9;
      }
      span {
        font-size: 24px;
        font-weight: bold;
        font-family: 'ZCOOL KuaiLe', cursive;
        color: #fff;
        letter-spacing: 2px;
        text-shadow: 0 2px 8px #6B73FF44;
      }
      .logo-link {
        color: #fff;
        text-decoration: none;
        transition: color 0.2s;
        &:hover {
          color: #ffe066;
        }
      }
    }
    nav {
      flex: 1;
      width: 100%;
      overflow-y: auto;
      margin-top: 10px;
    }
    .sidebar-decor {
      width: 120px;
      margin: 24px auto 0 auto;
      opacity: 0.7;
      filter: drop-shadow(0 4px 16px #ffb6b9);
      pointer-events: none;
    }
  }
  .admin-menu {
    border-right: none;
    background: transparent;
    .el-menu-item, .el-submenu__title {
      height: 48px;
      line-height: 48px;
      border-radius: 16px;
      margin: 4px 16px;
      font-size: 17px;
      font-family: 'ZCOOL KuaiLe', cursive;
      color: #fff !important;
      transition: background 0.2s, color 0.2s;
      i {
        margin-right: 10px;
        font-size: 20px;
        color: #fff !important;
        transition: color 0.2s;
      }
      &:hover {
        background: #6B73FF !important;
        color: #fff !important;
      }
      &:hover i {
        color: #ffe066 !important;
      }
    }
    .el-menu-item.is-active, .el-submenu__title.is-active {
      background: #22223b !important;
      color: #ffe066 !important;
      font-weight: bold;
      box-shadow: 0 2px 8px #6B73FF33;
    }
    .el-menu-item.is-active i, .el-submenu__title.is-active i {
      color: #ffe066 !important;
    }
  }
  .menu-link {
    color: inherit;
    text-decoration: none;
    transition: color 0.2s;
    &:hover {
      color: #ffe066;
    }
  }
  .anime-main-content {
    flex: 1;
    margin-left: 240px;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    background: linear-gradient(135deg, #f5e6ff 0%, #d0e6ff 100%);
    border-top-left-radius: 32px;
    box-shadow: 0 0 32px #6B73FF11;
    position: relative;
    z-index: 1;
  }
  .content {
    flex: 1;
    padding: 32px 24px;
    background: transparent;
    overflow-y: auto;
    border-radius: 24px;
    min-height: 100vh;
  }
  @media screen and (max-width: 768px) {
    .anime-sidebar {
      width: 60px;
      .anime-logo span {
        display: none;
      }
      .el-menu-item span,
      .el-submenu__title span {
        display: none;
      }
      .sidebar-decor {
        display: none;
      }
    }
    .anime-main-content {
      margin-left: 60px;
    }
  }
</style>
