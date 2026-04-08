<template>
	<view>
		<view class="hero-section">
			<swiper :indicator-dots="true" :autoplay="true" :interval="4000" :duration="800" class="lunbo" indicator-active-color="#0e7490" indicator-color="rgba(14, 116, 144, 0.3)">
				<swiper-item>
					<view class="swiper-item">
						<image src="../static/campus_hero.png" mode="aspectFill" class="hero-img"></image>
						<view class="hero-overlay">
							<text class="hero-title">校园医疗健康</text>
							<text class="hero-subtitle">守护您的每一天</text>
						</view>
					</view>
				</swiper-item>
				<swiper-item>
					<view class="swiper-item">
						<image src="../static/医疗.jpg" mode="aspectFill" class="hero-img"></image>
					</view>
				</swiper-item>
				<swiper-item>
					<view class="swiper-item">
						<image src="../static/医疗2.jpg" mode="aspectFill" class="hero-img"></image>
					</view>
				</swiper-item>
			</swiper>
		</view>

		<!-- AI Entrance Banner -->
		<view class="ai-banner-wrapper" @click="navigateTo('/pages/aiduihua')">
			<view class="ai-banner">
				<view class="ai-banner-left">
					<view class="ai-icon-box">
						<uni-icons type="chatboxes" size="28" color="#ffffff"></uni-icons>
					</view>
					<view class="ai-info">
						<text class="ai-title">AI 智能问诊中心</text>
						<text class="ai-desc">身体不适？全天候免费智能健康咨询</text>
					</view>
				</view>
				<view class="ai-banner-right">即刻咨询 ></view>
			</view>
		</view>

		<!-- 快捷功能九宫格 (Quick Nav) -->
		<view class="quick-nav">
			<view class="quick-nav-item" @click="switchTab('/pages/searchXiaoyuanyisheng')">
				<view class="nav-icon-wrap" style="background: #e0f2fe;"><image src="../static/ic_doctor_active.png" class="nav-icon"></image></view>
				<text class="nav-text">预约医生</text>
			</view>
			<view class="quick-nav-item" @click="switchTab('/pages/searchXytijianshixiang')">
				<view class="nav-icon-wrap" style="background: #dcfce7;"><image src="../static/ic_checkup_active.png" class="nav-icon"></image></view>
				<text class="nav-text">校园体检</text>
			</view>
			<view class="quick-nav-item" @click="navigateTo('/pages/xyyiliaoyhJiankangdanganList')">
				<view class="nav-icon-wrap" style="background: #fef9c3;"><image src="../static/ic_announce_active.png" class="nav-icon"></image></view>
				<text class="nav-text">校园体测</text>
			</view>
			<view class="quick-nav-item" @click="navigateTo('/pages/xyyiliaoyhYhbinglijilvList')">
				<view class="nav-icon-wrap" style="background: #fce7f3;"><image src="../static/ic_user_active.png" class="nav-icon"></image></view>
				<text class="nav-text">我的病例</text>
			</view>
		</view>

		<view>
			<view class="fenlei" style="display:flex; justify-content:space-between; align-items:center;">
				<view class="fenlei-item active">校园公告最新推荐</view>
				<text style="font-size:12px; color:#94a3b8; margin-right:20rpx;" @click="switchTab('/pages/searchXyggao')">查看更多 ></text>
			</view>
			<view class="liebiao">
				<view class="liebiao-item" v-for="item in xyggaos.slice(0, 3)" @click="xyggaoDetails(item.id)" :key="item.id">
					<view class="liebiao-item-com1">
						<image :src="item.xyimg ? 'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.xyimg : '../static/medical_announce.png'" @error="item.xyimg = null" class="img"></image>
					</view>
					<view class="liebiao-item-com2">
						<view class="title">{{item.xytitle}}</view>
						<view class="xiaowenzi">发布时间:<view class="pingfen">{{item.xyaddtime}}</view>
						</view>
						<view class="xiaowenzi">内容：{{item.xycontent}}</view>
					</view>
					<view class="liebiao-item-com3">
						<view class="btn">详细</view>
					</view>
				</view>
			</view>
		</view>

		<view>
			<view class="fenlei" style="display:flex; justify-content:space-between; align-items:center;">
				<view class="fenlei-item active">校园体检事项最新推荐</view>
				<text style="font-size:12px; color:#94a3b8; margin-right:20rpx;" @click="switchTab('/pages/searchXytijianshixiang')">查看更多 ></text>
			</view>
			<view class="liebiao">
				<view class="liebiao-item" v-for="item in xytijianshixiangs.slice(0, 3)" @click="xytijianshixiangDetails(item.id)"
					:key="item.id">
					<view class="liebiao-item-com1">
						<image :src="item.tijianimg ? 'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.tijianimg : '../static/medical_checkup.png'" @error="item.tijianimg = null" class="img"></image>
					</view>
					<view class="liebiao-item-com2">
						<view class="title">{{item.tijiant}}</view>
						<view class="xiaowenzi">时间:<view class="pingfen">{{item.tijiantime}}</view>
						</view>
						<view class="xiaowenzi">位置：{{item.tijianadress}}</view>
					</view>
					<view class="liebiao-item-com3">
						<view class="btn">详细</view>
					</view>
				</view>
			</view>
		</view>






	</view>
</template>

<script>
	export default {
		data() {
			return {
				xiaoyuanyishengs: [],
				xytijianshixiangs: [],
				xyggaos: [],

			}
		},
		methods: {
			xiaoyuanyishengDetails(id) {
				uni.navigateTo({
					url: "/pages/xiaoyuanyishengDetails?id=" + id
				})
			},
			xytijianshixiangDetails(id) {
				uni.navigateTo({
					url: "/pages/xytijianshixiangDetails?id=" + id
				})
			},
			xyggaoDetails(id) {
				uni.navigateTo({
					url: "/pages/xyggaoDetails?id=" + id
				})
			},
			switchTab(url) {
				uni.switchTab({
					url: url
				})
			},
			navigateTo(url) {
				uni.navigateTo({
					url: url
				})
			}
		},
		onReady() {
			let _this = this;
			uni.request({
				url: "indexJson",
				success: res => {
					console.log(res.data)
					_this.xiaoyuanyishengs = res.data.xiaoyuanyishengs;
					_this.xytijianshixiangs = res.data.xytijianshixiangs;
					_this.xyggaos = res.data.xyggaos;
				}
			})
		}
	}
</script>

<style>
	.view-more-container {
		text-align: center;
		padding: 20rpx 0 30rpx 0;
	}
	.view-more-text {
		color: #2563eb;
		font-size: 26rpx;
		background: #eff6ff;
		padding: 12rpx 40rpx;
		border-radius: 100rpx;
		font-weight: 600;
	}

	.hero-section {
		padding: 20rpx;
		background-color: #f8fafc;
	}

	.ai-banner-wrapper {
		padding: 0 20rpx;
		margin-bottom: 20rpx;
	}

	.ai-banner {
		background: linear-gradient(135deg, #0e7490, #0284c7);
		border-radius: 24rpx;
		padding: 24rpx 32rpx;
		display: flex;
		align-items: center;
		justify-content: space-between;
		box-shadow: 0 8rpx 24rpx rgba(2, 132, 199, 0.25);
	}

	.ai-banner-left {
		display: flex;
		align-items: center;
	}

	.ai-icon-box {
		width: 72rpx;
		height: 72rpx;
		background: rgba(255, 255, 255, 0.2);
		border-radius: 50%;
		display: flex;
		align-items: center;
		justify-content: center;
		margin-right: 24rpx;
	}

	.ai-icon {
		font-size: 36rpx;
	}

	.ai-info {
		display: flex;
		flex-direction: column;
	}

	.ai-title {
		color: #ffffff;
		font-size: 32rpx;
		font-weight: bold;
		margin-bottom: 4rpx;
	}

	.ai-desc {
		color: rgba(255, 255, 255, 0.8);
		font-size: 22rpx;
	}

	.ai-banner-right {
		color: #ffffff;
		font-size: 24rpx;
		font-weight: 600;
		background: rgba(255, 255, 255, 0.15);
		padding: 10rpx 24rpx;
		border-radius: 100rpx;
	}

	.quick-nav {
		display: flex;
		justify-content: space-around;
		padding: 20rpx;
		background: #ffffff;
		border-radius: 24rpx;
		margin: 0 20rpx 20rpx;
		box-shadow: 0 4rpx 16rpx rgba(0,0,0,0.03);
	}

	.quick-nav-item {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.nav-icon-wrap {
		width: 96rpx;
		height: 96rpx;
		border-radius: 32rpx;
		display: flex;
		align-items: center;
		justify-content: center;
		margin-bottom: 12rpx;
	}

	.nav-icon {
		width: 48rpx;
		height: 48rpx;
	}

	.nav-text {
		font-size: 24rpx;
		color: #334155;
		font-weight: 600;
	}

	.lunbo {
		height: 360rpx;
		border-radius: 32rpx;
		overflow: hidden;
		box-shadow: 0 12rpx 32rpx rgba(14, 116, 144, 0.15);
		transform: translateY(0);
	}

	.hero-img {
		width: 100%;
		height: 360rpx;
		border-radius: 32rpx;
	}

	.swiper-item {
		position: relative;
		width: 100%;
		height: 100%;
	}

	.hero-overlay {
		position: absolute;
		bottom: 0;
		left: 0;
		right: 0;
		padding: 60rpx 40rpx 30rpx;
		background: linear-gradient(to top, rgba(15, 23, 42, 0.8), transparent);
		border-radius: 0 0 32rpx 32rpx;
		display: flex;
		flex-direction: column;
	}

	.hero-title {
		color: #ffffff;
		font-size: 40rpx;
		font-weight: 800;
		text-shadow: 0 2rpx 8rpx rgba(0,0,0,0.3);
	}

	.hero-subtitle {
		color: rgba(255,255,255,0.9);
		font-size: 26rpx;
		margin-top: 8rpx;
	}

	#top {
		background: linear-gradient(135deg, #0e7490, #0284c7);
		color: white;
		height: 50px;
		text-align: center;
		line-height: 50px;
		font-size: 18px;
	}

	.tuijian {
		padding: 20rpx;
	}

	.show-item {
		width: 85px;
		display: inline-block;
		margin-right: 15px;
	}

	.show-item .pic {
		width: 85px;
		height: 115px;
		border-radius: 16rpx;
	}

	.show-item .wenzi {
		margin: 0;
		font-size: 13px;
		color: #0f172a;
		margin-bottom: 3px;
		text-align: center;
		text-overflow: ellipsis;
		overflow: hidden;
		white-space: nowrap;
		font-weight: bold;
	}

	.title {
		margin: 0;
		font-size: 14px;
		color: #0f172a;
		margin-bottom: 12px;
	}

	.fenlei {
		border-bottom: none;
		border-top: none;
		height: 56px;
		line-height: 56px;
		padding: 0 20rpx;
		margin-top: 16rpx;
	}

	.fenlei-item.active {
		color: #ffffff;
		border-bottom: none;
		background: #2563eb;
		border-radius: 100rpx;
		padding: 0 24rpx;
		font-size: 28rpx;
		line-height: 56rpx;
		height: 56rpx;
		display: inline-flex;
		align-items: center;
		box-shadow: 0 6rpx 20rpx rgba(37, 99, 235, 0.25);
	}

	.fenlei-item {
		padding: 0 10px;
		font-weight: bold;
		color: #64748b;
		display: inline-block;
	}

	.leftscore {
		background-color: #0284c7;
	}

	.scroll-view_H {
		white-space: nowrap;
		width: 100%;
		display: none;
	}

	.scroll-view_H.active {
		display: block;
	}

	.liebiao .liebiao-item {
		border-bottom: none;
		padding: 20rpx;
		height: auto;
		min-height: 100px;
		background: #ffffff;
		border-radius: 24rpx;
		margin: 0 20rpx 16rpx 20rpx;
		box-shadow: 0 4rpx 16rpx rgba(0,0,0,0.03);
		border: 1px solid #f1f5f9;
		display: flex;
		align-items: center;
	}

	.liebiao .liebiao-item .liebiao-item-com1 {
		float: left;
		width: 20%;
	}

	.liebiao .liebiao-item .liebiao-item-com2 {
		float: left;
		width: 45%;
		margin-left: 5%;
	}

	.liebiao .liebiao-item .liebiao-item-com4 {
		float: left;
		width: 65%;
		margin-left: 5%;
	}

	.liebiao .xiaowenzi {
		font-size: 13px;
		color: #64748b;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}

	.liebiao .liebiao-item .liebiao-item-com3 {
		float: left;
		width: 25%;
		margin-left: 5%;
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100px;
	}

	.liebiao .btn {
		width: auto;
		padding: 6rpx 24rpx;
		height: 56rpx;
		line-height: 56rpx;
		text-align: center;
		box-sizing: border-box;
		background: #2563eb;
		color: #fff;
		border-radius: 100rpx;
		white-space: nowrap;
		font-size: 24rpx;
		font-weight: 600;
		box-shadow: 0 4rpx 12rpx rgba(37, 99, 235, 0.2);
	}

	.liebiao .liebiao-item .liebiao-item-com1 .img {
		width: 100%;
		height: 100px;
		border-radius: 16rpx;
		object-fit: cover;
	}

	.liebiao .liebiao-item .title {
		font-size: 17px;
		color: #0f172a;
		font-weight: 700;
		padding-right: 5px;
		flex-shrink: 1;
	}

	.liebiao .pingfen {
		font-weight: 700;
		color: #d97706;
		font-size: 15px;
		display: inline-block;
	}
</style>