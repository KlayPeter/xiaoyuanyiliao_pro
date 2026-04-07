import { createWebHistory, createRouter } from 'vue-router'


import login from "@/pages/login.vue"
import register from "@/pages/register.vue"
  import qtMenu from '@/pages/qtMenu.vue'

import htMenu from '@/pages/htMenu.vue'
    import adminIndex from "@/pages/adminIndex.vue";
    import xiaoyuanyishengIndex from "@/pages/xiaoyuanyishengIndex.vue";
    import xyyiliaoyhIndex from "@/pages/xyyiliaoyhIndex.vue";
  import addAdmin from "@/pages/addAdmin.vue";
  import updateAdmin from "@/pages/updateAdmin.vue";
  import adminList from "@/pages/adminList.vue";
  import addXiaoyuanyisheng from "@/pages/addXiaoyuanyisheng.vue";
  import updateXiaoyuanyisheng from "@/pages/updateXiaoyuanyisheng.vue";
  import xiaoyuanyishengList from "@/pages/xiaoyuanyishengList.vue";
  import addXyyiliaoyh from "@/pages/addXyyiliaoyh.vue";
  import updateXyyiliaoyh from "@/pages/updateXyyiliaoyh.vue";
  import xyyiliaoyhList from "@/pages/xyyiliaoyhList.vue";
  import addXyyiliaopaiban from "@/pages/addXyyiliaopaiban.vue";
  import updateXyyiliaopaiban from "@/pages/updateXyyiliaopaiban.vue";
  import xyyiliaopaibanList from "@/pages/xyyiliaopaibanList.vue";
  import addXyyiliaopaibanyuyue from "@/pages/addXyyiliaopaibanyuyue.vue";
  import updateXyyiliaopaibanyuyue from "@/pages/updateXyyiliaopaibanyuyue.vue";
  import xyyiliaopaibanyuyueList from "@/pages/xyyiliaopaibanyuyueList.vue";
  import addGuahaozixunjieguo from "@/pages/addGuahaozixunjieguo.vue";
  import updateGuahaozixunjieguo from "@/pages/updateGuahaozixunjieguo.vue";
  import guahaozixunjieguoList from "@/pages/guahaozixunjieguoList.vue";
  import addYhbinglijilv from "@/pages/addYhbinglijilv.vue";
  import updateYhbinglijilv from "@/pages/updateYhbinglijilv.vue";
  import yhbinglijilvList from "@/pages/yhbinglijilvList.vue";
  import addYuyueduihua from "@/pages/addYuyueduihua.vue";
  import updateYuyueduihua from "@/pages/updateYuyueduihua.vue";
  import yuyueduihuaList from "@/pages/yuyueduihuaList.vue";
  import addYuyuepingjia from "@/pages/addYuyuepingjia.vue";
  import updateYuyuepingjia from "@/pages/updateYuyuepingjia.vue";
  import yuyuepingjiaList from "@/pages/yuyuepingjiaList.vue";
  import addXyyiliaoyaoping from "@/pages/addXyyiliaoyaoping.vue";
  import updateXyyiliaoyaoping from "@/pages/updateXyyiliaoyaoping.vue";
  import xyyiliaoyaopingList from "@/pages/xyyiliaoyaopingList.vue";
  import addXytijianshixiang from "@/pages/addXytijianshixiang.vue";
  import updateXytijianshixiang from "@/pages/updateXytijianshixiang.vue";
  import xytijianshixiangList from "@/pages/xytijianshixiangList.vue";
  import addTijianyhyuyue from "@/pages/addTijianyhyuyue.vue";
  import updateTijianyhyuyue from "@/pages/updateTijianyhyuyue.vue";
  import tijianyhyuyueList from "@/pages/tijianyhyuyueList.vue";
  import addJiankangdangan from "@/pages/addJiankangdangan.vue";
  import updateJiankangdangan from "@/pages/updateJiankangdangan.vue";
  import jiankangdanganList from "@/pages/jiankangdanganList.vue";
  import addXyggao from "@/pages/addXyggao.vue";
  import updateXyggao from "@/pages/updateXyggao.vue";
  import xyggaoList from "@/pages/xyggaoList.vue";
  import addYiliaoyaopingtixing from "@/pages/addYiliaoyaopingtixing.vue";
  import updateYiliaoyaopingtixing from "@/pages/updateYiliaoyaopingtixing.vue";
  import yiliaoyaopingtixingList from "@/pages/yiliaoyaopingtixingList.vue";
        import xiaoyuanyishengAddXyyiliaopaiban from "@/pages/xiaoyuanyishengAddXyyiliaopaiban.vue";
        import xiaoyuanyishengUpdateXyyiliaopaiban from "@/pages/xiaoyuanyishengUpdateXyyiliaopaiban.vue";
        import xiaoyuanyishengXyyiliaopaibanList from "@/pages/xiaoyuanyishengXyyiliaopaibanList.vue";
        import xiaoyuanyishengAddXyyiliaopaibanyuyue from "@/pages/xiaoyuanyishengAddXyyiliaopaibanyuyue.vue";
        import xiaoyuanyishengUpdateXyyiliaopaibanyuyue from "@/pages/xiaoyuanyishengUpdateXyyiliaopaibanyuyue.vue";
        import xiaoyuanyishengXyyiliaopaibanyuyueList from "@/pages/xiaoyuanyishengXyyiliaopaibanyuyueList.vue";
        import xyyiliaoyhAddXyyiliaopaibanyuyue from "@/pages/xyyiliaoyhAddXyyiliaopaibanyuyue.vue";
        import xyyiliaoyhUpdateXyyiliaopaibanyuyue from "@/pages/xyyiliaoyhUpdateXyyiliaopaibanyuyue.vue";
        import xyyiliaoyhXyyiliaopaibanyuyueList from "@/pages/xyyiliaoyhXyyiliaopaibanyuyueList.vue";
        import xiaoyuanyishengAddGuahaozixunjieguo from "@/pages/xiaoyuanyishengAddGuahaozixunjieguo.vue";
        import xiaoyuanyishengUpdateGuahaozixunjieguo from "@/pages/xiaoyuanyishengUpdateGuahaozixunjieguo.vue";
        import xiaoyuanyishengGuahaozixunjieguoList from "@/pages/xiaoyuanyishengGuahaozixunjieguoList.vue";
        import xyyiliaoyhAddGuahaozixunjieguo from "@/pages/xyyiliaoyhAddGuahaozixunjieguo.vue";
        import xyyiliaoyhUpdateGuahaozixunjieguo from "@/pages/xyyiliaoyhUpdateGuahaozixunjieguo.vue";
        import xyyiliaoyhGuahaozixunjieguoList from "@/pages/xyyiliaoyhGuahaozixunjieguoList.vue";
        import xyyiliaoyhAddYhbinglijilv from "@/pages/xyyiliaoyhAddYhbinglijilv.vue";
        import xyyiliaoyhUpdateYhbinglijilv from "@/pages/xyyiliaoyhUpdateYhbinglijilv.vue";
        import xyyiliaoyhYhbinglijilvList from "@/pages/xyyiliaoyhYhbinglijilvList.vue";
        import xyyiliaoyhAddYuyuepingjia from "@/pages/xyyiliaoyhAddYuyuepingjia.vue";
        import xyyiliaoyhUpdateYuyuepingjia from "@/pages/xyyiliaoyhUpdateYuyuepingjia.vue";
        import xyyiliaoyhYuyuepingjiaList from "@/pages/xyyiliaoyhYuyuepingjiaList.vue";
        import xiaoyuanyishengAddXytijianshixiang from "@/pages/xiaoyuanyishengAddXytijianshixiang.vue";
        import xiaoyuanyishengUpdateXytijianshixiang from "@/pages/xiaoyuanyishengUpdateXytijianshixiang.vue";
        import xiaoyuanyishengXytijianshixiangList from "@/pages/xiaoyuanyishengXytijianshixiangList.vue";
        import xyyiliaoyhAddTijianyhyuyue from "@/pages/xyyiliaoyhAddTijianyhyuyue.vue";
        import xyyiliaoyhUpdateTijianyhyuyue from "@/pages/xyyiliaoyhUpdateTijianyhyuyue.vue";
        import xyyiliaoyhTijianyhyuyueList from "@/pages/xyyiliaoyhTijianyhyuyueList.vue";
        import xyyiliaoyhAddJiankangdangan from "@/pages/xyyiliaoyhAddJiankangdangan.vue";
        import xyyiliaoyhUpdateJiankangdangan from "@/pages/xyyiliaoyhUpdateJiankangdangan.vue";
        import xyyiliaoyhJiankangdanganList from "@/pages/xyyiliaoyhJiankangdanganList.vue";

  import index from "@/pages/index.vue"
    import searchXiaoyuanyisheng from "@/pages/searchXiaoyuanyisheng.vue";
    import xiaoyuanyishengDetails from "@/pages/xiaoyuanyishengDetails.vue";
    import searchXytijianshixiang from "@/pages/searchXytijianshixiang.vue";
    import xytijianshixiangDetails from "@/pages/xytijianshixiangDetails.vue";
    import searchXyggao from "@/pages/searchXyggao.vue";
    import xyggaoDetails from "@/pages/xyggaoDetails.vue";
    import duihua from "@/pages/duihua.vue";


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path:"/",component: login},
    {path:"/login",component: login},
    {path: "/register",component: register},
    {
      path: '/htMenu',
      component: htMenu,
      children:[
          {path: "/htMenu/adminIndex",component: adminIndex},
          {path: "/htMenu/xiaoyuanyishengIndex",component: xiaoyuanyishengIndex},
          {path: "/htMenu/xyyiliaoyhIndex",component: xyyiliaoyhIndex},
          {path: "/htMenu/duihua",component: duihua},
          {
            path: '/htMenu/addAdmin',
            component: addAdmin
          },
          {
            path: '/htMenu/updateAdmin',
            component: updateAdmin
          },
          {
            path: '/htMenu/adminList',
            component: adminList
          },
          {
            path: '/htMenu/addXiaoyuanyisheng',
            component: addXiaoyuanyisheng
          },
          {
            path: '/htMenu/updateXiaoyuanyisheng',
            component: updateXiaoyuanyisheng
          },
          {
            path: '/htMenu/xiaoyuanyishengList',
            component: xiaoyuanyishengList
          },
          {
            path: '/htMenu/addXyyiliaoyh',
            component: addXyyiliaoyh
          },
          {
            path: '/htMenu/updateXyyiliaoyh',
            component: updateXyyiliaoyh
          },
          {
            path: '/htMenu/xyyiliaoyhList',
            component: xyyiliaoyhList
          },
          {
            path: '/htMenu/addXyyiliaopaiban',
            component: addXyyiliaopaiban
          },
          {
            path: '/htMenu/updateXyyiliaopaiban',
            component: updateXyyiliaopaiban
          },
          {
            path: '/htMenu/xyyiliaopaibanList',
            component: xyyiliaopaibanList
          },
          {
            path: '/htMenu/addXyyiliaopaibanyuyue',
            component: addXyyiliaopaibanyuyue
          },
          {
            path: '/htMenu/updateXyyiliaopaibanyuyue',
            component: updateXyyiliaopaibanyuyue
          },
          {
            path: '/htMenu/xyyiliaopaibanyuyueList',
            component: xyyiliaopaibanyuyueList
          },
          {
            path: '/htMenu/addGuahaozixunjieguo',
            component: addGuahaozixunjieguo
          },
          {
            path: '/htMenu/updateGuahaozixunjieguo',
            component: updateGuahaozixunjieguo
          },
          {
            path: '/htMenu/guahaozixunjieguoList',
            component: guahaozixunjieguoList
          },
          {
            path: '/htMenu/addYhbinglijilv',
            component: addYhbinglijilv
          },
          {
            path: '/htMenu/updateYhbinglijilv',
            component: updateYhbinglijilv
          },
          {
            path: '/htMenu/yhbinglijilvList',
            component: yhbinglijilvList
          },
          {
            path: '/htMenu/addYuyueduihua',
            component: addYuyueduihua
          },
          {
            path: '/htMenu/updateYuyueduihua',
            component: updateYuyueduihua
          },
          {
            path: '/htMenu/yuyueduihuaList',
            component: yuyueduihuaList
          },
          {
            path: '/htMenu/addYuyuepingjia',
            component: addYuyuepingjia
          },
          {
            path: '/htMenu/updateYuyuepingjia',
            component: updateYuyuepingjia
          },
          {
            path: '/htMenu/yuyuepingjiaList',
            component: yuyuepingjiaList
          },
          {
            path: '/htMenu/addXyyiliaoyaoping',
            component: addXyyiliaoyaoping
          },
          {
            path: '/htMenu/updateXyyiliaoyaoping',
            component: updateXyyiliaoyaoping
          },
          {
            path: '/htMenu/xyyiliaoyaopingList',
            component: xyyiliaoyaopingList
          },
          {
            path: '/htMenu/addXytijianshixiang',
            component: addXytijianshixiang
          },
          {
            path: '/htMenu/updateXytijianshixiang',
            component: updateXytijianshixiang
          },
          {
            path: '/htMenu/xytijianshixiangList',
            component: xytijianshixiangList
          },
          {
            path: '/htMenu/addTijianyhyuyue',
            component: addTijianyhyuyue
          },
          {
            path: '/htMenu/updateTijianyhyuyue',
            component: updateTijianyhyuyue
          },
          {
            path: '/htMenu/tijianyhyuyueList',
            component: tijianyhyuyueList
          },
          {
            path: '/htMenu/addJiankangdangan',
            component: addJiankangdangan
          },
          {
            path: '/htMenu/updateJiankangdangan',
            component: updateJiankangdangan
          },
          {
            path: '/htMenu/jiankangdanganList',
            component: jiankangdanganList
          },
          {
            path: '/htMenu/addXyggao',
            component: addXyggao
          },
          {
            path: '/htMenu/updateXyggao',
            component: updateXyggao
          },
          {
            path: '/htMenu/xyggaoList',
            component: xyggaoList
          },
          {
            path: '/htMenu/addYiliaoyaopingtixing',
            component: addYiliaoyaopingtixing
          },
          {
            path: '/htMenu/updateYiliaoyaopingtixing',
            component: updateYiliaoyaopingtixing
          },
          {
            path: '/htMenu/yiliaoyaopingtixingList',
            component: yiliaoyaopingtixingList
          },
                {path: "/htMenu/xiaoyuanyishengAddXyyiliaopaiban",component: xiaoyuanyishengAddXyyiliaopaiban},
                {path: "/htMenu/xiaoyuanyishengUpdateXyyiliaopaiban",component: xiaoyuanyishengUpdateXyyiliaopaiban},
                {path: "/htMenu/xiaoyuanyishengXyyiliaopaibanList",component: xiaoyuanyishengXyyiliaopaibanList},
                {path: "/htMenu/xiaoyuanyishengAddXyyiliaopaibanyuyue",component: xiaoyuanyishengAddXyyiliaopaibanyuyue},
                {path: "/htMenu/xiaoyuanyishengUpdateXyyiliaopaibanyuyue",component: xiaoyuanyishengUpdateXyyiliaopaibanyuyue},
                {path: "/htMenu/xiaoyuanyishengXyyiliaopaibanyuyueList",component: xiaoyuanyishengXyyiliaopaibanyuyueList},
                {path: "/htMenu/xyyiliaoyhAddXyyiliaopaibanyuyue",component: xyyiliaoyhAddXyyiliaopaibanyuyue},
                {path: "/htMenu/xyyiliaoyhUpdateXyyiliaopaibanyuyue",component: xyyiliaoyhUpdateXyyiliaopaibanyuyue},
                {path: "/htMenu/xyyiliaoyhXyyiliaopaibanyuyueList",component: xyyiliaoyhXyyiliaopaibanyuyueList},
                {path: "/htMenu/xiaoyuanyishengAddGuahaozixunjieguo",component: xiaoyuanyishengAddGuahaozixunjieguo},
                {path: "/htMenu/xiaoyuanyishengUpdateGuahaozixunjieguo",component: xiaoyuanyishengUpdateGuahaozixunjieguo},
                {path: "/htMenu/xiaoyuanyishengGuahaozixunjieguoList",component: xiaoyuanyishengGuahaozixunjieguoList},
                {path: "/htMenu/xyyiliaoyhAddGuahaozixunjieguo",component: xyyiliaoyhAddGuahaozixunjieguo},
                {path: "/htMenu/xyyiliaoyhUpdateGuahaozixunjieguo",component: xyyiliaoyhUpdateGuahaozixunjieguo},
                {path: "/htMenu/xyyiliaoyhGuahaozixunjieguoList",component: xyyiliaoyhGuahaozixunjieguoList},
                {path: "/htMenu/xyyiliaoyhAddYhbinglijilv",component: xyyiliaoyhAddYhbinglijilv},
                {path: "/htMenu/xyyiliaoyhUpdateYhbinglijilv",component: xyyiliaoyhUpdateYhbinglijilv},
                {path: "/htMenu/xyyiliaoyhYhbinglijilvList",component: xyyiliaoyhYhbinglijilvList},
                {path: "/htMenu/xyyiliaoyhAddYuyuepingjia",component: xyyiliaoyhAddYuyuepingjia},
                {path: "/htMenu/xyyiliaoyhUpdateYuyuepingjia",component: xyyiliaoyhUpdateYuyuepingjia},
                {path: "/htMenu/xyyiliaoyhYuyuepingjiaList",component: xyyiliaoyhYuyuepingjiaList},
                {path: "/htMenu/xiaoyuanyishengAddXytijianshixiang",component: xiaoyuanyishengAddXytijianshixiang},
                {path: "/htMenu/xiaoyuanyishengUpdateXytijianshixiang",component: xiaoyuanyishengUpdateXytijianshixiang},
                {path: "/htMenu/xiaoyuanyishengXytijianshixiangList",component: xiaoyuanyishengXytijianshixiangList},
                {path: "/htMenu/xyyiliaoyhAddTijianyhyuyue",component: xyyiliaoyhAddTijianyhyuyue},
                {path: "/htMenu/xyyiliaoyhUpdateTijianyhyuyue",component: xyyiliaoyhUpdateTijianyhyuyue},
                {path: "/htMenu/xyyiliaoyhTijianyhyuyueList",component: xyyiliaoyhTijianyhyuyueList},
                {path: "/htMenu/xyyiliaoyhAddJiankangdangan",component: xyyiliaoyhAddJiankangdangan},
                {path: "/htMenu/xyyiliaoyhUpdateJiankangdangan",component: xyyiliaoyhUpdateJiankangdangan},
                {path: "/htMenu/xyyiliaoyhJiankangdanganList",component: xyyiliaoyhJiankangdanganList},
      ]
    },
      {
        path: '/qtMenu',
        component: qtMenu,
        redirect:"/qtMenu/index",
        children: [
              {path: "/qtMenu/index",component: index},
              {path: "/qtMenu/searchXiaoyuanyisheng",component: searchXiaoyuanyisheng},
              {path: "/qtMenu/xiaoyuanyishengDetails",component: xiaoyuanyishengDetails},
              {path: "/qtMenu/index",component: index},
              {path: "/qtMenu/searchXytijianshixiang",component: searchXytijianshixiang},
              {path: "/qtMenu/xytijianshixiangDetails",component: xytijianshixiangDetails},
              {path: "/qtMenu/index",component: index},
              {path: "/qtMenu/searchXyggao",component: searchXyggao},
              {path: "/qtMenu/xyggaoDetails",component: xyggaoDetails},
        ]
      }

  ],
  // 路由切换时，页面回到顶部
  scrollBehavior() {
    return {
      top: 0
    }
  }
})

export default router
