<template>
	<view class="page-container">
		<view class="t-b">
			<text class="title-main">您好，</text>
			<text class="title-sub">欢迎加入校园医疗健康</text>
		</view>
		<view class="login-view">
			<view class="t-login">
				<form class="cl">
					<view class="t-a">
						<text class="txt">账号</text>
						<input type="text" name="phone" placeholder="请输入您的账号" 
							v-model="registerForm.username" />
					</view>
					<view class="t-a">
						<text class="txt">密码</text>
						<input type="password" name="code"  placeholder="请输入您的密码"
							v-model="registerForm.password" />
					</view>
					<view class="t-a">
						<text class="txt">再次输入密码</text>
						<input type="password" name="code" placeholder="请再次输入您的密码"
							v-model="registerForm.repassword" />
					</view>
					<view class="t-a">
						<text class="txt">选择注册角色</text>
						<picker class="input picker-container" :range="roleArr" @change="changeRole">
							<view class="picker-text">{{registerForm.role}}</view>
						</picker>
					</view>
					<button @tap="registeractJson()">注 册</button>
					<view class="reg" @tap="urlto('/pages/login')">前 往 登 录</view>
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
				registerForm: {
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
			urlto(url) {
				uni.navigateTo({
					url: url
				})
			},
			changeRole(e) {
				this.registerForm.role = this.roleArr[e.detail.value];
			},
			registeractJson(e) {
				let _this = this

				uni.request({
					url: "registeractJson",
					method: "POST",
					data: _this.registerForm,
					success(res) {
						console.log(res)
						let message = res.data.message;

						console.log(message);

						if (message == '注册成功，请登录') {
							_this.$refs.toast.show({ type: 'success', message: '注册成功，即将跳转...' });
							setTimeout(() => {
								_this.urlto('login')
							}, 1500)
						} else {
							_this.$refs.toast.show({
								type: 'error',
								message: res.data.message
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
		background-color: #f8fafc;
		background-image: 
			radial-gradient(at 0% 0%, hsla(210, 100%, 93%, 1) 0px, transparent 50%),
			radial-gradient(at 100% 0%, hsla(204, 100%, 86%, 1) 0px, transparent 50%),
			radial-gradient(at 100% 100%, hsla(217, 100%, 91%, 1) 0px, transparent 50%),
			radial-gradient(at 0% 100%, hsla(213, 100%, 88%, 1) 0px, transparent 50%);
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
		font-size: 64rpx;
		color: #0f172a;
		font-weight: 800;
		margin-bottom: 16rpx;
	}

	.title-sub {
		font-size: 30rpx;
		color: #64748b;
		font-weight: 500;
	}

	.login-view {
		width: 100%;
		background: #ffffff;
		border-radius: 80rpx 80rpx 0 0;
		box-shadow: 0 -24rpx 80rpx rgba(15, 23, 42, 0.06);
		padding-bottom: env(safe-area-inset-bottom);
		height: 70vh;
		box-sizing: border-box;
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.t-login {
		width: 600rpx;
		margin: 0 auto;
		padding-top: 40rpx;
	}

	.t-a {
		margin-bottom: 24rpx;
	}

	.txt {
		font-size: 26rpx;
		font-weight: 600;
		color: #334155;
		margin-left: 20rpx;
		margin-bottom: 16rpx;
		display: block;
		letter-spacing: 1rpx;
	}

	/* 表单输入框统一风格 */
	.t-login input, .input {
		height: 96rpx;
		line-height: 96rpx;
		background: #f8fafc;
		border: 2rpx solid #f1f5f9;
		border-radius: 32rpx;
		padding: 0 40rpx;
		font-size: 28rpx;
		color: #0f172a;
		box-shadow: inset 0 4rpx 12rpx rgba(0,0,0,0.015);
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
		margin-top: 40rpx;
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
		margin-top: 10rpx;
	}

	.cl { clear: both; }
</style>