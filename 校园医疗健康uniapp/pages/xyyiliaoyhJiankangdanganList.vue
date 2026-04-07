<template>
	<view class="container">

		<uni-search-bar @confirm="searchJiankangdangan" @cancel="cancelSearch()" :focus="true" v-model="search" placeholder="请输入搜索内容(按下回车键搜索)"></uni-search-bar>
		<view class="liebiao">

			<view class="liebiao-item" v-for="(item,index) in jiankangdangans" :key="item.id">
				<view class="liebiao-item-com2">
					<view class="title">{{item.shijian}}</view>
					<view class="xiaowenzi">肺活量(ml):<view class="pingfen">{{item.feihuoliang}}</view>
					</view>
					<view class="xiaowenzi">bmi：{{item.bmi}}</view>
				</view>
				<view class="liebiao-item-com3">
					<view class="btn" @click="xyyiliaoyhUpdateJiankangdangan(item.id)">详细</view>
					<view class="btn" @click="xyyiliaoyhDeleteJiankangdangan(item.id)">删除</view>
				</view>
			</view>

		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				jiankangdangans: [],
				search: "",
			}
		},
		methods: {
			xyyiliaoyhUpdateJiankangdangan(id){
				uni.redirectTo({
					url:"xyyiliaoyhUpdateJiankangdangan?id="+id
				})
			},
			xyyiliaoyhDeleteJiankangdangan(id) {

				let _this = this;
				uni.request({
					url: "xyyiliaoyhDeleteJiankangdanganJson?id=" + id,
					success: res => {
						if(res.data.message == "删除体测档案成功"){
							_this.jiankangdangans = _this.jiankangdangans.filter(item =>{
								return item.id != id
							})
							uni.showToast({
								title: '删除成功',
								icon: 'none',
								duration: 2000
							})
							return
						}else{
							uni.showToast({
								title: res.data.message,
								icon: 'none',
								duration: 2000
							})
							return
						}
						
						
					}
				})
			},
			searchJiankangdangan(event) {
				var _this = this
				uni.request({
					url:"xyyiliaoyhJiankangdanganListJson?search=" + event.value,
					method:"POST",
					success(res) {
						if(res.statusCode != 200 ){
							uni.redirectTo({
								url:"/pages/login",
								success() {
									uni.clearStorage();
									setTimeout(function(){
										uni.showToast({
											title:"登录过期",
											icon:"error",
											duration:2000,
										})
									},100)
								}
							})
						}
						_this.jiankangdangans = res.data.jiankangdangans
					},
					fail(res) {
					}
				})
			},
			cancelSearch(){
				var _this = this
				this.searchJiankangdangan({value:""})
			},
		},
		onLoad(e) {
			let _this = this;
			uni.request({
				url: "xyyiliaoyhJiankangdanganListJson",
				success: res => {
					if(res.statusCode != 200 ){
						uni.redirectTo({
							url:"/pages/login",
							success() {
								uni.clearStorage();
								setTimeout(function(){
									uni.showToast({
										title:"登录过期",
										icon:"error",
										duration:2000,
									})
								},100)
							}
						})
					}
					_this.jiankangdangans = res.data.jiankangdangans;
				},
				fail(res) {
				
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
		background-color: #f8fafc;
	}

	.liebiao .liebiao-item {
		border-bottom: 1px solid #e2e8f0;
		padding: 10px;
		height: 110px;
	}

	.liebiao .liebiao-item .liebiao-item-com1 {
		float: left;
		width: 20%;
	}

	.liebiao .liebiao-item .liebiao-item-com2 {
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
		display: grid;
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
		background: linear-gradient(135deg, #0e7490, #0284c7);
		color: #fff;
		border-radius: 100rpx;
		white-space: nowrap;
		font-size: 12px;
		cursor: pointer;
		display: inline-block;
	}

	.liebiao .liebiao-item .liebiao-item-com1 .img {
		width: 100%;
		height: 100px;
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
		color: #faaf00;
		font-size: 15px;
		display: inline-block;
	}
</style>