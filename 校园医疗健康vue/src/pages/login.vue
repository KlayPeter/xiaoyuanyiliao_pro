<template>
  <div class="login-container">
    <div class="login-box">
      <div class="login-header">
        <h1>校园医疗健康平台</h1>
        <p>欢迎登录</p>
      </div>
      <div class="login-form">
        <el-form ref="loginForm">
          <el-form-item prop="username">
            <el-input
                v-model="loginForm.username"
                placeholder="请输入用户名"
                prefix-icon="User"
            >
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
                v-model="loginForm.password"
                type="password"
                placeholder="请输入密码"
                prefix-icon="Lock"
                show-password
            >
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-radio-group v-model="loginForm.role">
              <el-radio label="管理员">管理员</el-radio>
              <el-radio label="校园医生">校园医生</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button
                type="primary"
                class="login-btn"
                @click="loginJson()"
                :loading="loading"
            >
              登 录
            </el-button>
          </el-form-item>
          <div class="register-link">
            还没有账号？<router-link to="/register">立即注册</router-link>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  const login = {
    data() {
      return {
        username:"",
        loginForm:{
          username:"",
          password:"",
          role:"管理员"
        }
      };
    },
    methods:{
      loginJson(){
        var _this = this
        console.log(this.loginForm)
        this.axios.post("/loginactJson",this.loginForm).then(res=>{
          console.log(res.data)
          if (res.data.message == '登录成功'){
            _this.$toast.success("登录成功",{
              position:"top",
              pauseOnHover:false,
              duration:2000
            })
            localStorage.setItem("userinfo",JSON.stringify(res.data.userinfo))
            localStorage.setItem("role",res.data.role)
            if (res.data.role == '管理员'){
              console.log(res.data.role)
              _this.$router.push({path:"/htMenu/adminIndex"})
              return
            }
            if (res.data.role == '校园医生'){
              console.log(res.data.role)
              _this.$router.push({path:"/htMenu/xiaoyuanyishengIndex"})
              return
            }
            if (res.data.role == '校园用户'){
              console.log(res.data.role)
              _this.$router.push({path:"/htMenu/xyyiliaoyhIndex"})
              return
            }
          }else {
            //返回不会登录成功时，提示对应错误
            _this.$toast.error(res.data.message,{
              position:"top",
              pauseOnHover:false,
              duration:2000
            })
          }

        })
      }
    },
    created() {},
    mounted() {}
  }
  export default login
</script>

<style scoped lang="scss">
  .login-container {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #f0f2f5;
    background-image: url('https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?auto=format&fit=crop&w=1920&q=80');
    background-size: cover;
    background-position: center;
  }
  
  .login-box {
    width: 400px;
    background: rgba(255, 255, 255, 0.85);
    backdrop-filter: blur(8px);
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    padding: 40px;
    text-align: center;
  }

  .login-header {
    margin-bottom: 30px;
    h1 {
      font-size: 24px;
      color: #333;
      margin: 0;
      font-weight: 600;
    }
    p {
      color: #909399;
      margin-top: 10px;
      font-size: 14px;
    }
  }

  .login-form {
    .el-form-item {
      margin-bottom: 22px;
    }
    
    .el-input {
      :deep(.el-input__inner) {
        height: 40px;
      }
    }
    
    .el-radio-group {
      width: 100%;
      display: flex;
      justify-content: center;
      margin-bottom: 10px;
      .el-radio {
        margin-right: 15px;
        &:last-child {
          margin-right: 0;
        }
      }
    }
    
    .login-btn {
      width: 100%;
      height: 40px;
      font-size: 16px;
      margin-top: 10px;
    }
    
    .register-link {
      text-align: center;
      margin-top: 16px;
      font-size: 14px;
      color: #606266;
      a {
        color: #409EFF;
        text-decoration: none;
        &:hover {
          text-decoration: underline;
        }
      }
    }
  }
</style>
