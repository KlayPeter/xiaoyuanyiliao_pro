<template>
	<view class="container">

		<uni-search-bar @confirm="searchXytijianshixiang" @cancel="cancelSearch()" :focus="true" v-model="search"
			placeholder="请输入搜索内容(按下回车键搜索)"></uni-search-bar>


		<view class="liebiao">
			<view class="liebiao-item" v-for="item in xytijianshixiangs" :key="item.id"
				@click="xytijianshixiangDetails(item.id)">
				<view class="liebiao-item-com1">
					<image :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.tijianimg" class="img"></image>
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
		background-color: #f5f5f5;
	}

	.liebiao .liebiao-item {
		border-bottom: 1px solid #e6e6e6;
		padding: 10px;
		height: 100px;
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
		color: #666;
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
		width: 47px;
		height: 27px;
		line-height: 28px;
		text-align: center;
		box-sizing: border-box;
		background-color: #55aa7f;
		color: #fff;
		border-radius: 4px;
		white-space: nowrap;
		font-size: 12px;
		cursor: pointer;
	}

	.liebiao .liebiao-item .liebiao-item-com1 .img {
		width: 100%;
		height: 100px;
	}

	.liebiao .liebiao-item .title {
		font-size: 17px;
		color: #333;
		font-weight: 700;
		padding-right: 5px;
		flex-shrink: 1;
	}

	.liebiao .pingfen {
		font-weight: 700;
		color: #faaf00;
		font-size: 15px;
		display: inline-block;
	}
</style>