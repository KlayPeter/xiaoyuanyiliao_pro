<template>
	<view class="container">

		<uni-search-bar @confirm="searchXyyiliaopaibanyuyue" @cancel="cancelSearch()" :focus="true" v-model="search" placeholder="请输入搜索内容(按下回车键搜索)"></uni-search-bar>
		<view class="liebiao">

			<view class="liebiao-item" v-for="(item,index) in xyyiliaopaibanyuyues" :key="item.id">
				<view class="liebiao-item-com1">
					<image :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.img" class="img"></image>
				</view>
				<view class="liebiao-item-com2">
					<view class="title">xxxx</view>
					<view class="xiaowenzi">xxxx:<view class="pingfen">xxxxxxx</view>
					</view>
					<view class="xiaowenzi">xxxxx：xxxxx</view>
				</view>
				<view class="liebiao-item-com3">
					<view class="btn" @click="xiaoyuanyishengUpdateXyyiliaopaibanyuyue(item.id)">修改</view>
					<view class="btn" @click="xiaoyuanyishengDeleteXyyiliaopaibanyuyue(item.id)">删除</view>
				</view>
			</view>

		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				xyyiliaopaibanyuyues: [],
				search: "",
			}
		},
		methods: {
			xiaoyuanyishengUpdateXyyiliaopaibanyuyue(id){
				uni.redirectTo({
					url:"xiaoyuanyishengUpdateXyyiliaopaibanyuyue?id="+id
				})
			},
			xiaoyuanyishengDeleteXyyiliaopaibanyuyue(id) {

				let _this = this;
				uni.request({
					url: "xiaoyuanyishengDeleteXyyiliaopaibanyuyueJson?id=" + id,
					success: res => {
						if(res.data.message == "删除校园医疗排班预约成功"){
							_this.xyyiliaopaibanyuyues = _this.xyyiliaopaibanyuyues.filter(item =>{
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
			searchXyyiliaopaibanyuyue(event) {
				var _this = this
				uni.request({
					url:"xiaoyuanyishengXyyiliaopaibanyuyueListJson?search=" + event.value,
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
						_this.xyyiliaopaibanyuyues = res.data.xyyiliaopaibanyuyues
					},
					fail(res) {
					}
				})
			},
			cancelSearch(){
				var _this = this
				this.searchXyyiliaopaibanyuyue({value:""})
			},
		},
		onLoad(e) {
			let _this = this;
			uni.request({
				url: "xiaoyuanyishengXyyiliaopaibanyuyueListJson",
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
					_this.xyyiliaopaibanyuyues = res.data.xyyiliaopaibanyuyues;
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