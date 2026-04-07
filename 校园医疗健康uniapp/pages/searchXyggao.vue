
<template>
	<view class="container">
		<!-- 搜索框 -->
		<uni-search-bar 
			@confirm="searchXyggao" 
			@cancel="cancelSearch()" 
			:focus="true" 
			v-model="search"
			placeholder="请输入搜索内容(按下回车键搜索)" 
			class="search-bar">
		</uni-search-bar>

		<!-- 公告内容 -->
		<view class="gonggao-list">
			<view v-for="(gonggao, index) in xyggaos" :key="index" class="gonggao-item" @click="gonggaoDetails(gonggao.id)">
				<image :src="gonggao.xyimg ? 'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+gonggao.xyimg : '../static/medical_announce.png'" @error="gonggao.xyimg = null" class="gonggao-img" mode="aspectFill" />
				<view class="gonggao-title">{{gonggao.xytitle}}</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				xyggaos: [],
				search: "",
			}
		},
		methods: {
			gonggaoDetails(id) {
				uni.navigateTo({
					url: "xyggaoDetails?id=" + id
				})
			},
			searchXyggao(event) {
				var _this = this
				uni.request({
					url:"searchXyggaoJson?search=" + event.value,
					method:"POST",
					success(res) {
						_this.xyggaos = res.data.xyggaos
					}
				})
			},
			cancelSearch() {
				var _this = this
				this.searchXyggao({ value: "" })
			}
		},
		onShow() {
			let _this = this;
			uni.request({
				url: "searchXyggaoJson",
				success(res) {
					_this.xyggaos = res.data.xyggaos
				}
			})
		},
		onReachBottom() {
			uni.showToast({
				title: '到底了',
				icon: 'none',
				duration: 1000
			})
		},
	}
</script>

<style>
	/* 页面背景色 */
	page {
		background: #f8fafc url('/static/real_medical_bg.png') center/cover fixed no-repeat;
		min-height: 100vh;
	}

	/* 搜索框样式 */
	.search-bar {
		margin: 20rpx;
		border-radius: 50rpx;
		background-color: #ffffff;
		box-shadow: 0 4rpx 16rpx rgba(0, 0, 0, 0.04);
		padding: 0 20rpx;
		border: 1px solid #f1f5f9;
	}

	/* 公告列表样式 */
	.gonggao-list {
		padding: 20rpx;
	}

	.gonggao-item {
		background-color: #ffffff;
		border-radius: 24rpx;
		overflow: hidden;
		margin-bottom: 20rpx;
		box-shadow: 0 4rpx 16rpx rgba(0, 0, 0, 0.04);
		border: 1px solid #f1f5f9;
	}

	.gonggao-img {
		width: 100%;
		height: 250rpx;
		border-radius: 24rpx 24rpx 0rpx 0rpx;
	}

	.gonggao-title {
		text-align: center;
		font-size: 32rpx;
		font-weight: 600;
		color: #0f172a;
		padding: 16rpx;
	}

</style>