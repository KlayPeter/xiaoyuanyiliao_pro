<template>
  <div class="chat-container">
    <!-- 聊天消息显示区 -->
    <div class="chat-messages" ref="messagesContainer">
      <div
          v-for="(message, index) in messages"
          :key="index"
          class="message"
          :class="{'message-right': message.isCurrentUser, 'message-left': !message.isCurrentUser}"
      >
        <div class="message-header">
          <img :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+message.duihuauserimg" alt="头像" class="message-avatar"/>
          <div class="message-author">
            <strong>{{ message.duihuauser }}</strong>
            <span class="message-time">{{ message.duihuauseraddtime }}</span>
          </div>
        </div>
        <div class="message-content">{{ message.message }}</div>
      </div>
    </div>

    <!-- 聊天输入框 -->
    <div class="chat-input-container">
      <el-input
          v-model="messageInput"
          placeholder="请输入消息"
          @keyup.enter="sendMessage"
          class="chat-input"
      />
      <el-button type="primary" @click="sendMessage" class="send-button">发送</el-button>
    </div>
  </div>
</template>

<script>
import { ElInput, ElButton } from 'element-plus';

export default {
  name: 'ChatApp',
  components: {
    ElInput,
    ElButton,
  },
  data() {
    return {
      // 消息输入框的绑定数据
      messageInput: '',

      // 存储消息列表
      messages: [

      ],
    };
  },
  methods: {
    getNowTime(){
      var now = new Date();
      var year = now.getFullYear(); // 获取年份
      var month = now.getMonth() + 1; // 获取月份，月份是从0开始的
      var day = now.getDate(); // 获取日期
      var hour = now.getHours(); // 获取小时
      var minute = now.getMinutes(); // 获取分钟
      var second = now.getSeconds(); // 获取秒
      // 对月、日、时、分、秒进行补0处理
      month = month < 10 ? '0' + month : month;
      day = day < 10 ? '0' + day : day;
      hour = hour < 10 ? '0' + hour : hour;
      minute = minute < 10 ? '0' + minute : minute;
      second = second < 10 ? '0' + second : second;
      return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second
    },
    // 发送消息
    sendMessage() {
      let userinfo = JSON.parse(localStorage.getItem("userinfo"))
      if (this.messageInput.trim()) {
        const newMessage = {
          xyyiliaopaibanyuyue: "1",
          xyyiliaopaibanyuyueid: this.$route.query.duihuaid,
          message: this.messageInput.trim(),
          duihuauser: userinfo.username,
          duihuauserid: userinfo.id,
          duihuauserrole:"校园医生",
          duihuauserimg:userinfo.schoolysavaator,
          duihuauseraddtime:new Date().toLocaleString(),
          isCurrentUser:true
        };
        this.axios.post("addYuyueduihuaactJson",newMessage)
        this.messages.push(newMessage); // 将新消息添加到消息列表
        this.messageInput = ''; // 清空输入框
      }
    },
  },
  created() {

    let timmer = localStorage.getItem("timmer")
    if (timmer != null && timmer != undefined && timmer != "") {
      clearInterval(timmer)
    }
    timmer = setInterval(() => {
      this.axios.post("yuyueduihuaListJson?duihuaid=" + this.$route.query.duihuaid).then(res=>{
        this.messages = res.data.yuyueduihuas.filter(t=>{
          return t.xyyiliaopaibanyuyueid == this.$route.query.duihuaid
        }).map(t=>{
          if (t.duihuauserrole == '校园医生'){
            t.isCurrentUser = true
          }else {
            t.isCurrentUser = false
          }
          return t
        })
      })
    }, 2000)
    localStorage.setItem("timmer", timmer)
  },
  unmounted() {
    clearInterval(localStorage.getItem("timmer"))
  }
};
</script>

<style scoped>
/* 聊天容器样式 */
.chat-container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  height: 80vh;
}

/* 消息显示区 */
.chat-messages {
  flex: 1;
  overflow-y: auto;
  margin-bottom: 20px;
}

.message {
  display: flex;
  flex-direction: column;
  margin-bottom: 10px;
}

/* 右侧消息（当前用户的消息） */
.message-right {
  align-items: flex-end;
}

.message-left {
  align-items: flex-start;
}

.message-header {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

.message-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
  margin-right: 10px;
}

.message-author {
  display: flex;
  flex-direction: column;
}

.message-author strong {
  font-size: 1rem;
  color: #333;
}

.message-time {
  font-size: 0.8rem;
  color: #888;
}

.message-content {
  padding: 10px;
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  font-size: 1rem;
  color: #444;
}

/* 输入框和按钮 */
.chat-input-container {
  display: flex;
  align-items: center;
  gap: 10px;
}

.chat-input {
  flex: 1;
}

.send-button {
  padding: 10px 20px;
  background-color: #409EFF;
  border-color: #409EFF;
}
</style>
