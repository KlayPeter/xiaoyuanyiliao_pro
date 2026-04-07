<template>
	<view class="page-container">
		<view class="t-b">
			<text class="title-main">您好，</text>
			<text class="title-sub">欢迎使用校园医疗健康服务</text>
		</view>
		<view class="login-view">
			<view class="t-login">
				<form class="cl">
					<view class="t-a">
						<text class="txt">账号</text>
						<input type="text" name="phone" placeholder="请输入您的账号" 
							v-model="loginForm.username" />
					</view>
					<view class="t-a">
						<text class="txt">密码</text>
						<input type="password" name="code" placeholder="请输入您的密码"
							v-model="loginForm.password" />
					</view>
					
					<view class="t-a" v-if="!isLoginMode">
						<text class="txt">再次输入密码</text>
						<input type="password" name="code2" placeholder="请再次输入您的密码"
							v-model="loginForm.repassword" />
					</view>

					<view class="t-a">
						<text class="txt">{{ isLoginMode ? '选择登录角色' : '选择注册角色' }}</text>
						<picker class="input picker-container" :range="roleArr" @change="changeRole">
							<view class="picker-text">{{loginForm.role}}</view>
						</picker>
					</view>
					
					<button @tap="submitactJson()">{{ isLoginMode ? '登 录' : '注 册' }}</button>
					<view class="reg" @tap="toggleMode">{{ isLoginMode ? '没 有 账 号 ？ 前 往 注 册' : '已 有 账 号 ？ 前 往 登 录' }}</view>
				</form>
			</view>
		</view>
		<pretty-toast ref="toast"></pretty-toast>
	</view>
</template>



<script>
	import PrettyToast from '@/components/pretty-toast/pretty-toast.vue';

	export default {
		components: {
			PrettyToast
		},
		data() {
			return {
				isLoginMode: true,
				loginForm: {
					username: "",
					password: "",
					repassword: "",
					role: "校园用户"
				},
				roleArr: [
					"校园用户",
				]
			}
		},
		methods: {
			toggleMode() {
				this.isLoginMode = !this.isLoginMode;
				// Reset form on toggle
				this.loginForm.username = "";
				this.loginForm.password = "";
				this.loginForm.repassword = "";
			},
			urlto(url) {
				uni.navigateTo({
					url: url
				})
			},
			changeRole(e) {
				this.loginForm.role = this.roleArr[e.detail.value];
			},
			submitactJson(e) {
				if (this.isLoginMode) {
					this.loginactJson();
				} else {
					this.registeractJson();
				}
			},
			loginactJson(e) {
				let _this = this
				uni.request({
					url: "loginactJson",
					method: "POST",
					data: JSON.stringify(_this.loginForm),
					success(res) {
						// console.log(res)
						let message = res.data.message;
						if (message == '登录成功') {
							//将当前登录用户的具体信息保存到Storage中
							uni.setStorage({
								key: 'userinfo',
								data: res.data.userinfo
							})
							//将当前登录用户的身份保存到Storage中
							uni.setStorage({
								key: 'role',
								data: res.data.role
							})
							//根据登录用户权限跳转到对应的页面
							uni.switchTab({
								url: 'htMenu'
							});
						} else {
							_this.$refs.toast.show({
								type: 'error',
								message: res.data.message || '登录失败'
							});
						}
					}
				})
			},
			registeractJson() {
				let _this = this;
				uni.request({
					url: "registeractJson",
					method: "POST",
					data: _this.loginForm,
					success(res) {
						let message = res.data.message;
						if (message == '注册成功，请登录') {
							_this.$refs.toast.show({ type: 'success', message: '注册成功，请登录' });
							setTimeout(() => {
								_this.toggleMode();
							}, 1500)
						} else {
							_this.$refs.toast.show({
								type: 'error',
								message: message || '注册失败'
							});
						}
					}
				})
			},
		},
		onLoad(e) {

		},
	}
</script>

<style>
	page {
		height: 100%;
		overflow: hidden;
		background-color: #f8fafc;
	}

	.page-container {
		height: 100vh;
		width: 100vw;
		background: #f8fafc url('/static/real_medical_bg.png') center/cover fixed no-repeat;
		position: fixed;
		top: 0;
		left: 0;
		overflow: hidden;
		display: flex;
		flex-direction: column;
		justify-content: flex-end;
		box-sizing: border-box;
	}

	.t-b {
		position: absolute;
		top: 15vh;
		left: 60rpx;
		display: flex;
		flex-direction: column;
	}

	.title-main {
		font-size: 68rpx;
		color: #0f172a;
		font-weight: 800;
		margin-bottom: 16rpx;
	}

	.title-sub {
		font-size: 32rpx;
		color: #64748b;
		font-weight: 500;
	}

	.login-view {
		width: 100%;
		background: rgba(255, 255, 255, 0.85);
		backdrop-filter: blur(20px);
		-webkit-backdrop-filter: blur(20px);
		border-radius: 80rpx 80rpx 0 0;
		box-shadow: 0 -24rpx 80rpx rgba(15, 23, 42, 0.08);
		border-top: 2rpx solid rgba(255, 255, 255, 0.9);
		padding-bottom: env(safe-area-inset-bottom);
		height: 65vh;
		box-sizing: border-box;
		display: flex;
		flex-direction: column;
		align-items: center;
		transition: height 0.3s ease;
	}

	.t-login {
		width: 600rpx;
		margin: 0 auto;
		padding-top: 50rpx;
	}

	.t-a {
		margin-bottom: 30rpx;
	}

	.txt {
		font-size: 30rpx;
		font-weight: 600;
		color: #334155;
		margin-left: 20rpx;
		margin-bottom: 16rpx;
		display: block;
		letter-spacing: 1rpx;
	}

	/* 表单输入框统一风格 */
	.t-login input, .input {
		height: 100rpx;
		line-height: 100rpx;
		background: rgba(255, 255, 255, 0.9);
		border: 2rpx solid #e2e8f0;
		border-radius: 32rpx;
		padding: 0 40rpx;
		font-size: 32rpx;
		color: #0f172a;
		box-shadow: inset 0 4rpx 8rpx rgba(0,0,0,0.02);
		margin: 0;
		font-weight: 500;
		box-sizing: border-box;
	}

	.picker-container {
		display: flex;
		align-items: center;
	}

	.picker-text {
		width: 100%;
		height: 100%;
	}

	.t-login .uni-input-placeholder {
		color: #cbd5e1;
		font-weight: 400;
	}

	.t-login button {
		margin-top: 50rpx;
		font-size: 32rpx;
		background: #2563eb !important;
		color: #fff;
		height: 100rpx;
		line-height: 100rpx;
		border-radius: 50rpx;
		font-weight: 600;
		border: none;
		box-shadow: 0 16rpx 32rpx rgba(37, 99, 235, 0.25);
		letter-spacing: 4rpx;
	}

	.reg {
		font-size: 28rpx;
		height: 96rpx;
		line-height: 96rpx;
		border-radius: 48rpx;
		font-weight: 600;
		background: transparent;
		color: #64748b;
		text-align: center;
		margin-top: 20rpx;
	}

	.cl { clear: both; }
</style>