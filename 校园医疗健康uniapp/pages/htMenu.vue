<template>
	<view class="page-container">
		<!-- 顶部沉浸式 Glassmorphism Banner -->
		<view class="home-hero">
			<view class="greeting-card">
				<image class="avatar" v-if="userinfo != undefined" :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+userinfo.xyyiliaoyhimg"></image>
				<image class="avatar" v-else src="../static/medical_doctor.png"></image>
				<view class="g-text">
					<view class="h2">Hi, {{ userinfo ? (userinfo.xyyiliaoyhname || '神秘用户') : '神秘用户' }}</view>
					<view class="p">联系电话: {{ userinfo ? (userinfo.xyyiliaoyhphone || '未知') : '未知' }}</view>
				</view>
			</view>

			<view class="focus-banner">
				<view class="banner-left">
					<view class="h3">24H 校园急诊援助</view>
					<view class="p">突发疾病或意外伤害立刻一键求助</view>
				</view>
				<view class="banner-btn" @click="callEmergency">
					<view class="text">呼叫援助</view>
				</view>
			</view>
		</view>

		<!-- 现代卡片风列表菜单 -->
		<view class="home-content">
			<view class="menu-list" v-if="role == '校园用户'">
				
				<view class="menu-item" @click="urlto('xyyiliaoyhIndex')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_user_active.png"></image></view>
					<text class="menu-text">个人中心</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item" @click="urlto('xyyiliaoyhXyyiliaopaibanyuyueList')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_checkup_active.png"></image></view>
					<text class="menu-text">我的校园医疗排班预约</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item" @click="urlto('xyyiliaoyhGuahaozixunjieguoList')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_checkup_active.png"></image></view>
					<text class="menu-text">我的挂号咨询结果</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item" @click="urlto('xyyiliaoyhYhbinglijilvList')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_doctor_active.png"></image></view>
					<text class="menu-text">我的用户病例记录</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item" @click="urlto('xyyiliaoyhYuyuepingjiaList')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_announce_active.png"></image></view>
					<text class="menu-text">我的预约评价</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item" @click="urlto('xyyiliaoyhTijianyhyuyueList')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_checkup_active.png"></image></view>
					<text class="menu-text">我的体检用户预约</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item" @click="urlto('xyyiliaoyhJiankangdanganList')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_doctor_active.png"></image></view>
					<text class="menu-text">我的体测档案</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item" @click="urlto('aiduihua')">
					<view class="menu-icon-wrap"><image class="menu-icon-img" src="../static/ic_announce_active.png"></image></view>
					<text class="menu-text">AI智能对话</text>
					<text class="menu-arrow">></text>
				</view>

				<view class="menu-item logout" @click="logout">
					<view class="menu-icon-wrap quit"><image class="menu-icon-img" src="../static/应用管理.png"></image></view>
					<text class="menu-text" style="color: #ef4444;">安全退出系统</text>
					<text class="menu-arrow">></text>
				</view>

			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				role: '',
				userinfo: null
			}
		},
		methods: {
			urlto(url) {
				uni.navigateTo({
					url: url
				})
			},
			logout() {
				uni.clearStorage();
				uni.request({
					url: "logoutJson",
				})
				uni.navigateTo({
					url: '/pages/login'
				})
			},
			callEmergency() {
				uni.showModal({
					title: '紧急救援',
					content: '是否立即拨通校医处24小时热线并将您的定位发送至值班室？',
					confirmColor: '#ef4444',
					success: (res) => {
						if(res.confirm) {
							uni.showToast({ title: '已发送紧急求导', icon: 'success' })
						}
					}
				})
			}
		},
		onLoad(e) {

		},
		onShow() {
			let _this = this;
			this.userinfo = uni.getStorageSync("userinfo")
			uni.getStorage({
				key: 'role',
				success(res) {
					_this.role = res.data;
				},
				fail(res) {
					uni.redirectTo({
						url: "/pages/login"
					})
				}
			})
		}
	}
</script>

<style>
	.page-container {
		background: #f8fafc url('/static/real_medical_bg.png') center/cover fixed no-repeat;
		min-height: 100vh;
	}

	/* ======== 顶部沉浸背景区 ======== */
	.home-hero {
		position: relative;
		width: 100%;
		height: 460rpx;
		background: url('https://images.unsplash.com/photo-1541339907198-e08756dedf3f?auto=format&fit=crop&w=800&q=80') center top/cover;
		padding: 100rpx 40rpx 40rpx 40rpx;
		box-sizing: border-box;
	}
	.home-hero::before {
		content: '';
		position: absolute;
		top: 0; left: 0; width: 100%; height: 100%;
		background: linear-gradient(135deg, rgba(20, 184, 166, 0.85) 0%, rgba(56, 189, 248, 0.6) 100%);
		mix-blend-mode: multiply;
	}

	.greeting-card {
		position: relative;
		z-index: 2;
		display: flex;
		align-items: center;
		margin-bottom: 40rpx;
	}
	.avatar { 
		width: 112rpx; height: 112rpx; border-radius: 50%; 
		border: 4rpx solid rgba(255,255,255,0.8); margin-right: 32rpx; 
		background-color: #e2e8f0; 
	}
	.g-text .h2 { font-size: 44rpx; margin-bottom: 8rpx; font-weight: 700; color: white; }
	.g-text .p { font-size: 26rpx; color: rgba(255,255,255,0.85); }

	.focus-banner {
		position: relative;
		z-index: 2;
		background: rgba(255, 255, 255, 0.2);
		backdrop-filter: blur(24px);
		border: 2rpx solid rgba(255,255,255,0.4);
		border-radius: 48rpx;
		padding: 40rpx;
		display: flex;
		align-items: center;
		justify-content: space-between;
		box-shadow: 0 20rpx 60rpx rgba(0,0,0,0.1);
	}
	.banner-left .h3 { font-size: 36rpx; margin-bottom: 8rpx; font-weight: 700; color: white; }
	.banner-left .p { font-size: 24rpx; color: white; opacity: 0.9; }
	.banner-btn {
		background: white; padding: 20rpx 32rpx; border-radius: 40rpx; box-shadow: 0 8rpx 20rpx rgba(0,0,0,0.1);
	}
	.banner-btn .text { color: #0284c7; font-weight: 700; font-size: 26rpx; }

	/* ======== 菜单列表区 ======== */
	.home-content {
		background-color: transparent;
		padding: 20rpx 40rpx;
		margin-top: -60rpx;
		position: relative;
		z-index: 5;
		padding-bottom: 60rpx;
	}

	.menu-list {
		display: flex;
		flex-direction: column;
		gap: 24rpx;
	}

	.menu-item {
		display: flex;
		align-items: center;
		background: rgba(255, 255, 255, 0.85);
		backdrop-filter: blur(20px);
		padding: 28rpx 32rpx;
		border-radius: 36rpx;
		box-shadow: 0 8rpx 32rpx rgba(0,0,0,0.03);
		border: 2rpx solid #ffffff;
		transition: transform 0.2s;
	}
	.menu-item:active {
		transform: scale(0.98);
		background: #f1f5f9;
	}
	.menu-item.logout {
		margin-top: 20rpx;
		border: 2rpx solid #fee2e2;
		background: #fef2f2;
	}

	.menu-icon-wrap {
		width: 72rpx;
		height: 72rpx;
		border-radius: 20rpx;
		background: rgba(37,99,235, 0.1);
		display: flex;
		align-items: center;
		justify-content: center;
		margin-right: 28rpx;
	}
	.menu-icon-wrap.quit { background: rgba(239, 68, 68, 0.1); }
	.menu-icon-img {
		width: 36rpx;
		height: 36rpx;
		opacity: 0.9;
	}

	.menu-text {
		flex: 1;
		font-size: 30rpx;
		color: #0f172a;
		font-weight: 700;
	}
	.menu-arrow {
		color: #94a3b8;
		font-size: 32rpx;
		font-weight: 700;
		font-family: monospace;
	}
</style>