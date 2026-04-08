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
                :default-active="$route.path"
                class="admin-menu"
                active-text-color="#409EFF"
                @select="handleSelect"
        >
          <template v-for="item in adminMenu" :key="item.index">
            <el-sub-menu :index="item.index">
              <template #title>
                <el-icon><component :is="item.icon" /></el-icon>
                <span>{{ item.title }}</span>
              </template>
              <el-menu-item v-for="sub in item.children" :key="sub.to || sub.index" :index="sub.to || sub.index" @click="sub.logout ? logout() : (sub.to ? $router.push(sub.to) : null)">
                <el-icon><component :is="sub.icon" /></el-icon>
                <span>{{ sub.title }}</span>
              </el-menu-item>
            </el-sub-menu>
          </template>
        </el-menu>
                    <el-menu
                    v-else-if="role === '校园医生'"
                    :default-active="$route.path"
                    class="admin-menu"
                    active-text-color="#409EFF"
            >
              <template v-for="item in xiaoyuanyishengMenu" :key="item.index">
                <el-sub-menu :index="item.index">
                  <template #title>
                    <el-icon><component :is="item.icon" /></el-icon>
                    <span>{{ item.title }}</span>
                  </template>
                  <el-menu-item v-for="sub in item.children" :key="sub.to || sub.index" :index="sub.to || sub.index" @click="sub.logout ? logout() : (sub.to ? $router.push(sub.to) : null)">
                    <el-icon><component :is="sub.icon" /></el-icon>
                    <span>{{ sub.title }}</span>
                  </el-menu-item>
                </el-sub-menu>
              </template>
            </el-menu>
            <el-menu
                    v-else-if="role === '校园用户'"
                    :default-active="$route.path"
                    class="admin-menu"
                    active-text-color="#409EFF"
            >
              <template v-for="item in xyyiliaoyhMenu" :key="item.index">
                <el-sub-menu :index="item.index">
                  <template #title>
                    <el-icon><component :is="item.icon" /></el-icon>
                    <span>{{ item.title }}</span>
                  </template>
                  <el-menu-item v-for="sub in item.children" :key="sub.to || sub.index" :index="sub.to || sub.index" @click="sub.logout ? logout() : (sub.to ? $router.push(sub.to) : null)">
                    <el-icon><component :is="sub.icon" /></el-icon>
                    <span>{{ sub.title }}</span>
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
            icon: 'UserFilled',
            title: '个人中心',
            children: [
              { index: '0-1', icon: 'UserFilled', title: '个人中心', to: '/htMenu/adminIndex' }
            ]
          },
              {
                index: '2',
                icon: 'Avatar',
                title: '校园医生管理',
                children: [
                  { index: '2-1', icon: 'Plus', title: '添加校园医生', to: '/htMenu/addXiaoyuanyisheng' },
                  { index: '2-2', icon: 'List', title: '校园医生列表', to: '/htMenu/xiaoyuanyishengList' }
                ]
              },
              {
                index: '3',
                icon: 'User',
                title: '校园用户管理',
                children: [
                  { index: '3-1', icon: 'Plus', title: '添加校园用户', to: '/htMenu/addXyyiliaoyh' },
                  { index: '3-2', icon: 'List', title: '校园用户列表', to: '/htMenu/xyyiliaoyhList' }
                ]
              },
              {
                index: '4',
                icon: 'Calendar',
                title: '校园医疗排班管理',
                children: [
                  { index: '4-1', icon: 'Plus', title: '添加校园医疗排班', to: '/htMenu/addXyyiliaopaiban' },
                  { index: '4-2', icon: 'List', title: '校园医疗排班列表', to: '/htMenu/xyyiliaopaibanList' }
                ]
              },
              // {
              //   index: '5',
              //   icon: 'User',
              //   title: '校园医疗排班预约管理',
              //   children: [
              //     { index: '5-1', icon: 'Plus', title: '添加校园医疗排班预约', to: '/htMenu/addXyyiliaopaibanyuyue' },
              //     { index: '5-2', icon: 'List', title: '校园医疗排班预约列表', to: '/htMenu/xyyiliaopaibanyuyueList' }
              //   ]
              // },
              // {
              //   index: '6',
              //   icon: 'User',
              //   title: '挂号咨询结果管理',
              //   children: [
              //     { index: '6-1', icon: 'Plus', title: '添加挂号咨询结果', to: '/htMenu/addGuahaozixunjieguo' },
              //     { index: '6-2', icon: 'List', title: '挂号咨询结果列表', to: '/htMenu/guahaozixunjieguoList' }
              //   ]
              // },
              {
                index: '7',
                icon: 'Notebook',
                title: '用户病例记录管理',
                children: [
                  // { index: '7-1', icon: 'Plus', title: '添加用户病例记录', to: '/htMenu/addYhbinglijilv' },
                  { index: '7-2', icon: 'List', title: '用户病例记录列表', to: '/htMenu/yhbinglijilvList' }
                ]
              },
              // {
              //   index: '8',
              //   icon: 'User',
              //   title: '预约对话管理',
              //   children: [
              //     { index: '8-1', icon: 'Plus', title: '添加预约对话', to: '/htMenu/addYuyueduihua' },
              //     { index: '8-2', icon: 'List', title: '预约对话列表', to: '/htMenu/yuyueduihuaList' }
              //   ]
              // },
              {
                index: '9',
                icon: 'ChatLineSquare',
                title: '预约评价管理',
                children: [
                  // { index: '9-1', icon: 'Plus', title: '添加预约评价', to: '/htMenu/addYuyuepingjia' },
                  { index: '9-2', icon: 'List', title: '预约评价列表', to: '/htMenu/yuyuepingjiaList' }
                ]
              },
              {
                index: '10',
                icon: 'FirstAidKit',
                title: '校园医疗药品管理',
                children: [
                  { index: '10-1', icon: 'Plus', title: '添加校园医疗药品', to: '/htMenu/addXyyiliaoyaoping' },
                  { index: '10-2', icon: 'List', title: '校园医疗药品列表', to: '/htMenu/xyyiliaoyaopingList' }
                ]
              },
              {
                index: '11',
                icon: 'DocumentChecked',
                title: '校园体检事项管理',
                children: [
                  { index: '11-1', icon: 'Plus', title: '添加校园体检事项', to: '/htMenu/addXytijianshixiang' },
                  { index: '11-2', icon: 'List', title: '校园体检事项列表', to: '/htMenu/xytijianshixiangList' }
                ]
              },
              // {
              //   index: '12',
              //   icon: 'User',
              //   title: '体检用户预约管理',
              //   children: [
              //     { index: '12-1', icon: 'Plus', title: '添加体检用户预约', to: '/htMenu/addTijianyhyuyue' },
              //     { index: '12-2', icon: 'List', title: '体检用户预约列表', to: '/htMenu/tijianyhyuyueList' }
              //   ]
              // },
              {
                index: '13',
                icon: 'Files',
                title: '体测档案管理',
                children: [
                  // { index: '13-1', icon: 'Plus', title: '添加体测档案', to: '/htMenu/addJiankangdangan' },
                  { index: '13-2', icon: 'List', title: '体测档案列表', to: '/htMenu/jiankangdanganList' }
                ]
              },
              {
                index: '14',
                icon: 'Bell',
                title: '校园公告管理',
                children: [
                  { index: '14-1', icon: 'Plus', title: '添加校园公告', to: '/htMenu/addXyggao' },
                  { index: '14-2', icon: 'List', title: '校园公告列表', to: '/htMenu/xyggaoList' }
                ]
              },
              {
                index: '15',
                icon: 'Warning',
                title: '药品采购提醒管理',
                children: [
                  // { index: '15-1', icon: 'Plus', title: '添加药品采购提醒', to: '/htMenu/addYiliaoyaopingtixing' },
                  { index: '15-2', icon: 'List', title: '药品采购提醒列表', to: '/htMenu/yiliaoyaopingtixingList' }
                ]
              },
          {
            index: '999999999',
            icon: 'SwitchButton',
            title: '退出系统',
            children: [
              { index: '999999999-1', icon: 'SwitchButton', title: '退出系统', to: '', logout: true }
            ]
          }
        ],
        xiaoyuanyishengMenu: [
          {
            index: '0',
            icon: 'UserFilled',
            title: '个人中心',
            children: [
              { index: '0-1', icon: 'UserFilled', title: '个人中心', to: '/htMenu/xiaoyuanyishengIndex' }
            ]
          },
              {
                index: '4',
                icon: 'Calendar',
                title: '校园医疗排班管理',
                children: [
                  // { index: '4-1', icon: 'Plus', title: '添加校园医疗排班', to: '/htMenu/xiaoyuanyishengAddXyyiliaopaiban' },
                  { index: '4-2', icon: 'List', title: '校园医疗排班列表', to: '/htMenu/xiaoyuanyishengXyyiliaopaibanList' }              ]
              },
              {
                index: '5',
                icon: 'Message',
                title: '校园医疗排班预约管理',
                children: [
                  // { index: '5-1', icon: 'Plus', title: '添加校园医疗排班预约', to: '/htMenu/xiaoyuanyishengAddXyyiliaopaibanyuyue' },
                  { index: '5-2', icon: 'List', title: '校园医疗排班预约列表', to: '/htMenu/xiaoyuanyishengXyyiliaopaibanyuyueList' }              ]
              },
              {
                index: '6',
                icon: 'ChatDotRound',
                title: '挂号咨询结果管理',
                children: [
                  // { index: '6-1', icon: 'Plus', title: '添加挂号咨询结果', to: '/htMenu/xiaoyuanyishengAddGuahaozixunjieguo' },
                  { index: '6-2', icon: 'List', title: '挂号咨询结果列表', to: '/htMenu/xiaoyuanyishengGuahaozixunjieguoList' }              ]
              },
			  {
                index: '7',
                icon: 'Files',
                title: '体测档案管理',
                children: [
                  { index: '7-1', icon: 'Plus', title: '添加体测记录', to: '/htMenu/addJiankangdangan' },
                  { index: '7-2', icon: 'List', title: '体测记录列表', to: '/htMenu/jiankangdanganList' }
                ]
              },

              {
                index: '9',
                icon: 'ChatLineSquare',
                title: '预约评价管理',
                children: [
                  { index: '9-2', icon: 'List', title: '预约评价列表', to: '/htMenu/yuyuepingjiaList' }
                ]
              },
          {
            index: '999999999',
            icon: 'SwitchButton',
            title: '退出系统',
            children: [
              { index: '999999999-1', icon: 'SwitchButton', title: '退出系统', to: '', logout: true }
            ]
          }
        ],
        xyyiliaoyhMenu: [
          {
            index: '0',
            icon: 'UserFilled',
            title: '个人中心',
            children: [
              { index: '0-1', icon: 'UserFilled', title: '个人中心', to: '/htMenu/xyyiliaoyhIndex' }
            ]
          },
              {
                index: '5',
                icon: 'Message',
                title: '校园医疗排班预约管理',
                children: [
                  { index: '5-1', icon: 'Plus', title: '添加校园医疗排班预约', to: '/htMenu/xyyiliaoyhAddXyyiliaopaibanyuyue' },
                  { index: '5-2', icon: 'List', title: '校园医疗排班预约列表', to: '/htMenu/xyyiliaoyhXyyiliaopaibanyuyueList' }              ]
              },
              {
                index: '6',
                icon: 'ChatDotRound',
                title: '挂号咨询结果管理',
                children: [
                  { index: '6-1', icon: 'Plus', title: '添加挂号咨询结果', to: '/htMenu/xyyiliaoyhAddGuahaozixunjieguo' },
                  { index: '6-2', icon: 'List', title: '挂号咨询结果列表', to: '/htMenu/xyyiliaoyhGuahaozixunjieguoList' }              ]
              },
              {
                index: '7',
                icon: 'Notebook',
                title: '用户病例记录管理',
                children: [
                  { index: '7-1', icon: 'Plus', title: '添加用户病例记录', to: '/htMenu/xyyiliaoyhAddYhbinglijilv' },
                  { index: '7-2', icon: 'List', title: '用户病例记录列表', to: '/htMenu/xyyiliaoyhYhbinglijilvList' }              ]
              },
              {
                index: '9',
                icon: 'ChatLineSquare',
                title: '预约评价管理',
                children: [
                  { index: '9-1', icon: 'Plus', title: '添加预约评价', to: '/htMenu/xyyiliaoyhAddYuyuepingjia' },
                  { index: '9-2', icon: 'List', title: '预约评价列表', to: '/htMenu/xyyiliaoyhYuyuepingjiaList' }              ]
              },
              {
                index: '12',
                icon: 'Tickets',
                title: '体检用户预约管理',
                children: [
                  { index: '12-1', icon: 'Plus', title: '添加体检用户预约', to: '/htMenu/xyyiliaoyhAddTijianyhyuyue' },
                  { index: '12-2', icon: 'List', title: '体检用户预约列表', to: '/htMenu/xyyiliaoyhTijianyhyuyueList' }              ]
              },
              {
                index: '13',
                icon: 'Files',
                title: '体测档案管理',
                children: [
                  { index: '13-1', icon: 'Plus', title: '添加体测档案', to: '/htMenu/xyyiliaoyhAddJiankangdangan' },
                  { index: '13-2', icon: 'List', title: '体测档案列表', to: '/htMenu/xyyiliaoyhJiankangdanganList' }              ]
              },
          {
            index: '999999999',
            icon: 'SwitchButton',
            title: '退出系统',
            children: [
              { index: '999999999-1', icon: 'SwitchButton', title: '退出系统', to: '', logout: true }
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
  .admin-container {
    min-height: 100vh;
    background-color: #f0f2f5;
    position: relative;
    width: 100%;
    overflow-x: hidden;
  }
  
  .anime-sidebar {
    width: 250px;
    background-color: #ffffff;
    color: #303133;
    position: fixed;
    height: 100vh;
    left: 0;
    top: 0;
    z-index: 1000;
    display: flex;
    flex-direction: column;
    box-shadow: 2px 0 8px 0 rgba(29,35,41,.05);
    transition: width 0.3s;
    border-right: 1px solid #e6e6e6;
    
      .anime-logo {
      height: 64px;
      width: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
      background-color: #ffffff;
      border-bottom: 1px solid #e6e6e6;
      overflow: hidden;
      
      img {
        width: 36px;
        height: 36px;
        object-fit: contain;
      }
      
      span {
        font-size: 18px;
        font-weight: 600;
        color: #303133;
        margin-left: 10px;
      }
      
      .logo-link {
        color: #303133;
        text-decoration: none;
      }
    }
    
    nav {
      flex: 1;
      width: 100%;
      overflow-y: auto;
      overflow-x: hidden;
    }
  }
  
  .admin-menu {
    border-right: none;
    background: transparent;
    
    .el-menu-item, :deep(.el-sub-menu__title) {
      color: #303133 !important;
      
      i, .el-icon {
        color: #909399 !important;
      }
      
      &:hover {
        color: #409EFF !important;
        background-color: #ecf5ff !important;
        i, .el-icon {
          color: #409EFF !important;
        }
      }
    }
    
    .el-menu-item.is-active {
      background-color: #ecf5ff !important;
      color: #409EFF !important;
      font-weight: bold;
      border-right: 3px solid #409EFF;
      i, .el-icon {
        color: #409EFF !important;
      }
    }
  }
  
  .menu-link {
    color: inherit;
    text-decoration: none;
    display: block;
    width: 100%;
  }
  
  .anime-main-content {
    margin-left: 250px;
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    background-color: #f0f2f5;
    transition: margin-left 0.3s;
    width: calc(100% - 250px);
    overflow-x: hidden;
  }
  
  .content {
    flex: 1;
    padding: 24px;
    background: transparent;
    overflow-y: auto;
  }
  
  @media screen and (max-width: 768px) {
    .anime-sidebar {
      width: 64px;
      .anime-logo span {
        display: none;
      }
      :deep(.el-menu-item span),
      :deep(.el-sub-menu__title span) {
        display: none;
      }
    }
    .anime-main-content {
      margin-left: 64px;
    }
  }
</style>
