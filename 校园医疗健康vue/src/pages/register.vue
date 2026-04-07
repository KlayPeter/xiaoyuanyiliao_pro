<template>
  <div class="register-container">
    <div class="register-box">
      <div class="register-header">
        <h1>校园医疗健康平台</h1>
        <p>欢迎注册</p>
      </div>
      <div class="register-form">
        <el-form ref="registerForm">
          <el-form-item prop="username">
            <el-input
                v-model="registerForm.username"
                placeholder="请输入用户名"
                prefix-icon="User"
            >
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
                v-model="registerForm.password"
                type="password"
                placeholder="请输入密码"
                prefix-icon="Lock"
                show-password
            >
            </el-input>
          </el-form-item>
          <el-form-item prop="confirmPassword">
            <el-input
                v-model="registerForm.repassword"
                type="password"
                placeholder="请确认密码"
                prefix-icon="Lock"
                show-password
            >
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-radio-group v-model="registerForm.role">
              <el-radio label="管理员">管理员</el-radio>
<!--              <el-radio label="校园医生">校园医生</el-radio>-->
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-button
                type="primary"
                class="register-btn"
                @click="registeractJson()"
                :loading="loading"
            >
              注 册
            </el-button>
          </el-form-item>
          <div class="login-link">
            已有账号？<router-link to="/login">立即登录</router-link>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
  const register = {
    data() {
      return {
        registerForm: {
          username: "",
          password: "",
          repassword: "",
          role: "管理员"
        }
      };
    },
    methods: {
      registeractJson() {
        var _this = this
        console.log(this.registerForm)
        this.axios.post("/registeractJson",this.registerForm).then(res => {
          if (res.data.message == "注册成功，请登录") {
            _this.$toast.success("注册成功，请登录", {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
            _this.$router.push({path: "/login"})
            return;
          } else {
            _this.$toast.error(res.data.message, {
              position: "top",
              pauseOnHover: false,
              duration: 2000
            })
          }
        })
      }
    },
    created() {
    },
    mounted() {
    }
  }
  export default register
</script>

<style scoped lang="scss">
  .register-container {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #f0f2f5;
  }
  
  .register-box {
    width: 400px;
    background: #ffffff;
    border-radius: 8px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    padding: 40px;
    text-align: center;
  }

  .register-header {
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

  .register-form {
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
    
    .register-btn {
      width: 100%;
      height: 40px;
      font-size: 16px;
      margin-top: 10px;
    }
    
    .login-link {
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

