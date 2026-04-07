<template>
  <div class="register-container">
    <div class="register-box">
      <div class="left-section">
        <!--                <img class="anime-logo" src="@/assets/images/logo.png" alt="动漫logo" />-->
        <div class="welcome-text">
          <h1>欢迎注册</h1>
          <h2>校园医疗健康平台</h2>
        </div>
        <div class="features">
        </div>
        <div class="star-decor star1"></div>
        <div class="star-decor star2"></div>
      </div>
      <div class="right-section">
        <div class="register-form">
          <h3>注册</h3>
          <el-form ref="registerForm">
            <el-form-item prop="username">
              <el-input
                      v-model="registerForm.username"
                      placeholder="请输入用户名"
                      prefix-icon="el-icon-user"
              >
              </el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input
                      v-model="registerForm.password"
                      type="password"
                      placeholder="请输入密码"
                      prefix-icon="el-icon-lock"
                      show-password
              >
              </el-input>
            </el-form-item>
            <el-form-item prop="confirmPassword">
              <el-input
                      v-model="registerForm.repassword"
                      type="password"
                      placeholder="请确认密码"
                      prefix-icon="el-icon-lock"
                      show-password
              >
              </el-input>
            </el-form-item>
            <el-form-item>
              <el-radio-group v-model="registerForm.role">
                    <el-radio label="管理员">管理员</el-radio>
<!--                    <el-radio label="校园医生">校园医生</el-radio>-->
              </el-radio-group>
            </el-form-item>
            <el-form-item>
              <el-button
                      type="primary"
                      class="register-btn"
                      @click="registeractJson()"
                      :loading="loading"
              >
                注册
              </el-button>
            </el-form-item>
            <div class="login-link">
              已有账号？<router-link to="/login">立即登录</router-link>
            </div>
          </el-form>
        </div>
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
  @import url('https://fonts.googleapis.com/css2?family=ZCOOL+KuaiLe&display=swap');
  .register-container {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background: url('/src/assets/ht/images/医疗2.jpg') no-repeat center center;
    background-size: cover;
    position: relative;
    font-family: 'ZCOOL KuaiLe', 'Smiley Sans', '微软雅黑', sans-serif;
    &::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      background: rgba(255, 182, 185, 0.3);
      backdrop-filter: blur(2px);
    }
  }
  .register-box {
    width: 1000px;
    height: 700px;
    background: rgba(255, 255, 255, 0.95);
    border-radius: 30px;
    box-shadow: 0 10px 40px rgba(255, 182, 185, 0.25);
    display: flex;
    overflow: hidden;
    position: relative;
    z-index: 1;
    backdrop-filter: blur(10px);
  }
  .left-section {
    flex: 1;
    background: linear-gradient(135deg, rgba(255, 182, 185, 0.95) 0%, rgba(107, 115, 255, 0.9) 100%);
    color: white;
    padding: 40px 30px 40px 30px;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    position: relative;
    overflow: hidden;
    .anime-logo {
      width: 120px;
      margin-bottom: 20px;
      border-radius: 50%;
      box-shadow: 0 4px 20px rgba(0,0,0,0.15);
      background: #fff;
      padding: 10px;
      animation: float 3s ease-in-out infinite;
    }
    @keyframes float {
      0%, 100% { transform: translateY(0);}
      50% { transform: translateY(-10px);}
    }
    .welcome-text {
      position: relative;
      z-index: 1;
      h1 {
        font-size: 38px;
        margin-bottom: 10px;
        text-shadow: 2px 2px 8px rgba(255,255,255,0.3);
        font-family: 'ZCOOL KuaiLe', cursive;
      }
      h2 {
        font-size: 26px;
        margin-bottom: 20px;
        opacity: 0.95;
        text-shadow: 1px 1px 4px rgba(255,255,255,0.2);
        font-family: 'ZCOOL KuaiLe', cursive;
      }
    }
    .features {
      position: relative;
      z-index: 1;
      display: flex;
      flex-direction: column;
      gap: 20px;
      margin-top: 30px;
      .feature-item {
        display: flex;
        align-items: center;
        gap: 15px;
        background: rgba(255, 255, 255, 0.15);
        padding: 15px 20px;
        border-radius: 15px;
        transition: all 0.3s ease;
        box-shadow: 0 2px 8px rgba(255, 182, 185, 0.08);
        &:hover {
          background: rgba(255, 255, 255, 0.25);
          transform: translateX(10px) scale(1.05);
        }
        i {
          font-size: 28px;
          background: rgba(255, 255, 255, 0.2);
          padding: 10px;
          border-radius: 10px;
        }
        span {
          font-size: 18px;
          font-family: 'ZCOOL KuaiLe', cursive;
        }
      }
    }
    .star-decor {
      position: absolute;
      width: 36px; height: 36px;
      background: url('/src/assets/ht/images/none.png') no-repeat center/contain;
      opacity: 0.7;
      z-index: 2;
      &.star1 { top: 40px; left: 60px; }
      &.star2 { bottom: 80px; right: 100px; }
    }
  }
  .right-section {
    flex: 1;
    padding: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
    background: rgba(255, 255, 255, 0.98);
    .register-form {
      width: 100%;
      max-width: 400px;
      h3 {
        font-size: 28px;
        margin-bottom: 30px;
        text-align: center;
        color: #6B73FF;
        font-family: 'ZCOOL KuaiLe', cursive;
        position: relative;
        &::after {
          content: '';
          position: absolute;
          bottom: -10px;
          left: 50%;
          transform: translateX(-50%);
          width: 60px;
          height: 4px;
          background: #ffb6b9;
          border-radius: 3px;
        }
      }
      .el-form-item {
        margin-bottom: 20px;
      }
      .el-input {
        :deep(.el-input__inner) {
          height: 45px;
          border-radius: 20px;
          border: 1.5px solid #ffb6b9;
          padding-left: 40px;
          background: rgba(255, 255, 255, 0.95);
          font-size: 18px;
          font-family: 'ZCOOL KuaiLe', cursive;
          &:focus {
            border-color: #6B73FF;
            box-shadow: 0 0 0 2px rgba(107, 115, 255, 0.15);
          }
        }
        :deep(.el-input__prefix) {
          left: 10px;
          color: #ffb6b9;
        }
      }
      .el-radio-group {
        width: 100%;
        display: flex;
        justify-content: space-between;
        background: rgba(107, 115, 255, 0.08);
        padding: 10px;
        border-radius: 15px;
        .el-radio {
          margin-right: 0;
          font-family: 'ZCOOL KuaiLe', cursive;
        }
      }
      .register-btn {
        width: 100%;
        height: 45px;
        border-radius: 25px;
        font-size: 18px;
        margin-top: 10px;
        background: linear-gradient(90deg, #ffb6b9 0%, #6B73FF 100%);
        color: #fff;
        font-weight: bold;
        border: none;
        box-shadow: 0 2px 8px #ffb6b9;
        transition: all 0.3s;
        &:hover {
          transform: scale(1.05);
          box-shadow: 0 4px 16px #6B73FF;
        }
      }
      .login-link {
        text-align: center;
        margin-top: 20px;
        color: #606266;
        a {
          color: #6B73FF;
          text-decoration: none;
          font-weight: bold;
          &:hover {
            text-decoration: underline;
          }
        }
      }
    }
  }
  @media screen and (max-width: 768px) {
    .register-box {
      flex-direction: column;
      height: auto;
      width: 100%;
      margin: 20px;
    }
    .left-section {
      padding: 20px;
      .welcome-text {
        h1 { font-size: 24px; }
        h2 { font-size: 18px; }
      }
      .features { display: none; }
    }
    .right-section { padding: 20px; }
  }
</style>

