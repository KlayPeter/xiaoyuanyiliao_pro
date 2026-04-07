<template>
	<view class="container">

		<uni-search-bar @confirm="searchXytijianshixiang" @cancel="cancelSearch()" :focus="true" v-model="search"
			placeholder="请输入搜索内容(按下回车键搜索)"></uni-search-bar>


		<view class="liebiao">
			<view class="liebiao-item" v-for="item in xytijianshixiangs" :key="item.id"
				@click="xytijianshixiangDetails(item.id)">
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
</template>

<script>
	export default {
		data() {
			return {
				xytijianshixiangs: [],
				search: "",
			}
		},
		methods: {
			xytijianshixiangDetails(id) {
				uni.navigateTo({
					url: "xytijianshixiangDetails?id=" + id
				})
			},
			searchXytijianshixiang() {
				var _this = this
				uni.request({
					url:"searchXytijianshixiangJson?search=" + this.search,
					method:"POST",
					success(res) {
						_this.xytijianshixiangs = res.data.xytijianshixiangs
					}
				})
			},
			cancelSearch(){
				var _this = this
				this.search =  ""
				this.searchXytijianshixiang()
			}
		},
		onShow(e) {
			let _this = this;
			uni.request({
				url: "searchXytijianshixiangJson",
				success(res){
					_this.xytijianshixiangs = res.data.xytijianshixiangs
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
	page {
		background: #f8fafc url('/static/real_medical_bg.png') center/cover fixed no-repeat;
		min-height: 100vh;
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