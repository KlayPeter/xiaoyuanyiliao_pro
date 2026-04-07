<template>
	<view style="height:100vh;background: #55aa7f;">
		<view class="img-a">
			<view class="t-b">
				您好，
				<br />
				欢迎使用，校园医疗健康服务平台
			</view>
		</view>
		<view class="login-view">
			<view class="t-login" style="min-height: 60vh;">
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
					<view class="t-a">
						<text class="txt">选择登录角色</text>
						<picker class="input" style="background-color: #eaeaea;border-radius: 30rpx;" :range="roleArr"
							@change="changeRole">
							<view>{{loginForm.role}}</view>
						</picker>
					</view>
					<button @tap="loginactJson()">登 录</button>
					<view class="reg" @tap="urlto('/pages/register')">前 往 注 册</view>
				</form>
			</view>
		</view>
	</view>
</template>



<script>
	export default {
		data() {
			return {
				loginForm: {
					username: "",
					password: "",
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
				this.loginForm.role = this.roleArr[e.detail.value];
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
							uni.showToast({
								icon: "none",
								title: res.data.message
							})
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
	    .input {
	        border-bottom: 1px solid #d6d6d6;
	        padding: 10px;
	        margin: 5px 10px;
	    }
	.txt {
		font-size: 32rpx;
		font-weight: bold;
		color: #333333;
	}

	.img-a {
		width: 100%;
		height: 450rpx;
		background-color: #55aa7f;
		background-size: 100%;
	}

	.reg {
		font-size: 28rpx;
		color: #fff;
		height: 90rpx;
		line-height: 90rpx;
		border-radius: 50rpx;
		font-weight: bold;
		background: #f5f6fa;
		color: #000000;
		text-align: center;
		margin-top: 30rpx;
	}

	.login-view {
		width: 100%;
		position: relative;
		margin-top: -120rpx;
		background-color: #ffffff;
		border-radius: 8% 8% 0% 0;
	}

	.t-login {
		width: 600rpx;
		margin: 0 auto;
		font-size: 28rpx;
		padding-top: 80rpx;
	}

	.t-login button {
		font-size: 28rpx;
		background: #2796f2;
		color: #fff;
		height: 90rpx;
		line-height: 90rpx;
		border-radius: 50rpx;
		font-weight: bold;
	}

	.t-login input {
		height: 90rpx;
		line-height: 90rpx;
		margin-bottom: 50rpx;
		border-bottom: 1px solid #e9e9e9;
		font-size: 28rpx;
	}

	.t-login .t-a {
		position: relative;
	}

	.t-b {
		text-align: left;
		font-size: 42rpx;
		color: #ffffff;
		padding: 130rpx 0 0 70rpx;
		font-weight: bold;
		line-height: 70rpx;
	}

	.t-login .t-c {
		position: absolute;
		right: 22rpx;
		top: 22rpx;
		background: #5677fc;
		color: #fff;
		font-size: 24rpx;
		border-radius: 50rpx;
		height: 50rpx;
		line-height: 50rpx;
		padding: 0 25rpx;
	}

	.t-login .t-d {
		text-align: center;
		color: #999;
		margin: 80rpx 0;
	}

	.t-login .t-e {
		text-align: center;
		width: 250rpx;
		margin: 80rpx auto 0;
	}

	.t-login .t-g {
		float: left;
		width: 50%;
	}

	.t-login .t-e image {
		width: 50rpx;
		height: 50rpx;
	}

	.t-login .t-f {
		text-align: center;
		margin: 150rpx 0 0 0;
		color: #666;
	}

	.t-login .t-f text {
		margin-left: 20rpx;
		color: #aaaaaa;
		font-size: 27rpx;
	}

	.t-login .uni-input-placeholder {
		color: #aeaeae;
	}

	.cl {
		zoom: 1;
	}

	.cl:after {
		clear: both;
		display: block;
		visibility: hidden;
		height: 0;
		content: '\20';
	}
</style>