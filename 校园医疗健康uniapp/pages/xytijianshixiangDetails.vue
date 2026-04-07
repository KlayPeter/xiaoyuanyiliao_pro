<template>
	<view class="container">

		<!-- 商品图片轮播 -->
		<swiper class="swiper" indicator-dots autoplay circular>
			<swiper-item>
				<image :src="xytijianshixiang.tijianimg ? 'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+xytijianshixiang.tijianimg : '../static/medical_checkup.png'"
					mode="aspectFill" @error="xytijianshixiang.tijianimg = null" class="swiper-img"></image>
			</swiper-item>
		</swiper>

		<!-- 商品信息 -->
		<view class="info">
			<view class="name">{{ xytijianshixiang.tijiant }}</view>
			<view class="price">时间：{{ xytijianshixiang.tijiantime }}</view>
		</view>

		<!-- 商品详情 -->
		<view class="description">
			<view class="title">内容</view>
			<view class="content">{{ xytijianshixiang.tijiancontent }}</view>
		</view>
		<view class="description">
			<view class="title">注意内容</view>
			<view class="content">{{ xytijianshixiang.tijianzhuyi }}</view>
		</view>
		<!-- 注意事项 -->
		<view class="notice">
			<view class="title">位置</view>
			<view class="content">{{ xytijianshixiang.tijianadress }}</view>
		</view>

		<!-- 底部购买按钮 -->
		<view class="bottom-bar">
			<button @click="jinxingtijianyuyue" class="buy-btn">进行体检预约</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				xytijianshixiang: {}, // 套餐详情
			};
		},
		methods: {
			jinxingtijianyuyue() {
				let userinfo = uni.getStorageSync("userinfo")
				if(userinfo == null || userinfo == undefined || userinfo == ""){
					uni.showToast({
						title:"请先登录",
						icon:"error"
					})
					return
				}
				let tijianyuyue = {
					xytijianshixiang:this.xytijianshixiang.tijiant,
					xytijianshixiangid:this.xytijianshixiang.id,
					xyyiliaoyh:userinfo.username,
					xyyiliaoyhid:userinfo.id,
					address:this.xytijianshixiang.tijianadress,
					shijian:this.xytijianshixiang.tijiantime,
					img:this.xytijianshixiang.tijianimg,
					state:"待前往"
				}
				uni.request({
					url:"xyyiliaoyhAddTijianyhyuyueactJson",
					method:"POST",
					data:tijianyuyue,
					success: (res) => {
						uni.showToast({
							title:res.data.message,
							icon:'none'
						})
					}
				})
			}
		},
		onLoad(e) {

			let _this = this;
			uni.request({
				url: "xytijianshixiangDetailsJson?id=" + e.id,
				success(res) {
					_this.xytijianshixiang = res.data.xytijianshixiang;
				}
			})
		},
	};
</script>

<style scoped>
	.container {
		background: #f8fafc url('/static/real_medical_bg.png') center/cover fixed no-repeat;
		min-height: 100vh;
		padding-bottom: 140rpx; /* Leave space for bottom bar */
	}

	.nav {
		display: flex;
		align-items: center;
		padding: 20rpx;
		background: #fff;
		font-size: 30rpx;
		border-bottom: 1px solid #eee;
	}

	.back {
		flex: 1;
		color: #007aff;
	}

	.title {
		flex: 2;
		text-align: center;
		font-weight: bold;
	}

	.swiper {
		width: 100%;
		height: 400rpx;
	}

	.swiper-img {
		width: 100%;
		height: 100%;
	}

	.info {
		padding: 30rpx;
		background: #fff;
		margin: 20rpx;
		border-radius: 32rpx;
		box-shadow: 0 4rpx 20rpx rgba(0,0,0,0.04);
	}

	.name {
		font-size: 40rpx;
		font-weight: 800;
		color: #0f172a;
	}

	.price {
		color: #ef4444;
		font-size: 28rpx;
		margin-top: 16rpx;
		font-weight: 600;
	}

	.xytijianshixiangtype {
		color: #64748b;
		font-size: 24rpx;
		margin-top: 10rpx;
	}

	.description,
	.notice {
		background: #fff;
		padding: 30rpx;
		margin: 20rpx;
		border-radius: 32rpx;
		box-shadow: 0 4rpx 20rpx rgba(0,0,0,0.04);
	}

	.title {
		font-size: 28rpx;
		font-weight: bold;
	}

	.content {
		color: #64748b;
		font-size: 24rpx;
		margin-top: 10rpx;
	}

	.bottom-bar {
		position: fixed;
		bottom: 0;
		width: 100%;
		padding: 20rpx 40rpx calc(20rpx + env(safe-area-inset-bottom));
		background: rgba(255, 255, 255, 0.9);
		backdrop-filter: blur(20px);
		text-align: center;
		box-sizing: border-box;
		border-top: 2rpx solid #f1f5f9;
		z-index: 99;
	}

	.buy-btn {
		width: 100%;
		background: #2563eb;
		color: white;
		font-size: 32rpx;
		font-weight: 600;
		height: 88rpx;
		line-height: 88rpx;
		border-radius: 100rpx;
		box-shadow: 0 8rpx 24rpx rgba(37, 99, 235, 0.3);
		border: none;
	}
</style>