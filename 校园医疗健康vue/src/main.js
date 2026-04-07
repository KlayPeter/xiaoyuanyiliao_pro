import { createApp } from 'vue'

import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ToastPlugin from 'vue-toast-notification';
import 'vue-toast-notification/dist/theme-bootstrap.css';
// 如果您正在使用CDN引入，请删除下面一行。
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
axios.defaults.baseURL="http://localhost:8080/xiaoyuanyiliaojiankang"
axios.defaults.withCredentials = true;//携带cookie

app.use(router)
  app.use(VueAxios, axios)
  //消息提示组件
  app.use(ToastPlugin)
app.mount('#app')
