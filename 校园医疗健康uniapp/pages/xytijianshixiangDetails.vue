<template>
	<view class="container">

		<!-- 商品图片轮播 -->
		<swiper class="swiper" indicator-dots autoplay circular>
			<swiper-item>
				<image :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+xytijianshixiang.tijianimg"
					mode="aspectFill" class="swiper-img"></image>
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
			<button @click="jinxingtijianyuyue" class="buy-btn" size="mini">进行体检预约</button>
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
		background: #f8f8f8;
		min-height: 100vh;
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
		padding: 20rpx;
		background: #fff;
	}

	.name {
		font-size: 36rpx;
		font-weight: bold;
	}

	.price {
		color: red;
		font-size: 30rpx;
		margin-top: 10rpx;
	}

	.xytijianshixiangtype {
		color: #666;
		font-size: 24rpx;
		margin-top: 10rpx;
	}

	.description,
	.notice {
		background: #fff;
		padding: 20rpx;
		margin-top: 10rpx;
	}

	.title {
		font-size: 28rpx;
		font-weight: bold;
	}

	.content {
		color: #666;
		font-size: 24rpx;
		margin-top: 10rpx;
	}

	.bottom-bar {
		position: fixed;
		bottom: 0;
		width: 100%;
		padding: 5rpx;
		background: #fff;
		text-align: center;
	}

	.buy-btn {
		width: 80%;
		background: #007aff;
		color: white;
		font-size: 20rpx;
		padding: 16rpx;
		border-radius: 50rpx;
	}
</style>