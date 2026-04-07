<template>
	<view class="container">
		<!-- 订单状态筛选 -->
		<view class="tab-bar">
			<view v-for="(item, index) in statusList" :key="index"
				:class="['tab-item', activeStatus === item.value ? 'active' : '']" @click="changeStatus(item.value)">
				<view style="width: 100rpx">{{ item.label }}</view>
			</view>
		</view>

		<!-- 订单列表 -->
		<scroll-view class="order-list" scroll-y>
			<view v-if="orderList.length === 0" class="empty">暂无预约</view>
			<view v-else v-for="(order, index) in orderList" :key="index" class="order-card">
				<view  style="padding: 15px;">
					<view class="order-header">
						<text class="order-id">预约ID: {{ order.id }}</text>
						<text class="order-status">{{ order.state }}</text>
					</view>
					<view class="order-content">
						<view>简要问题: {{ order.jianyaowenti }}</view>
						<view>校园医生: {{ order.xiaoyuanyisheng }}</view>
						<view>预约时间: {{ order.yuyuetime}}</view>
						<view  class="order-price" style="display: flex;align-items: center;">
							<button @click="duihua(index)" v-if="order.state == '待对话'" type="primary" size="mini">进行对话</button>
							<button @click="jinxingpingjia(index)" v-if="order.state == '已开方'" type="primary" size="mini">进行评价</button>
							<button @click="qianwang(index)" v-if="order.state == '待前往'" type="primary" size="mini">前往</button>
							<button @click="shanchu(index)" v-if="order.state == '已评价'" type="primary" size="mini">进行删除</button>
						</view>
					</view>
				</view>				
			</view>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				activeStatus: '', // 当前选中的状态
				statusList: [{
						label: '全部',
						value: ''
					},
					{
						label: '待对话',
						value: '待对话'
					},
					{
						label: '待前往',
						value: '待前往'
					},
					{
						label: '已前往',
						value: '已前往'
					}, {
						label: '已开方',
						value: '已开方'
					},
					{
						label: '已过期',
						value: '已过期'
					},
					{
						label: '已评价',
						value: '已评价'
					},
				],
				orderList: [], // 订单数据
				quanbu: []
			}
		},
		onLoad() {
			uni.request({
				url: "xyyiliaopaibanyuyueListJson",
				success: (res) => {
					let userinfo = uni.getStorageSync("userinfo")
					this.orderList = res.data.xyyiliaopaibanyuyues.filter(t=>{
						return t.xyyiliaoyhid == userinfo.id
					})
					this.quanbu = JSON.parse(JSON.stringify(this.orderList))
				}
			})
		},
		methods: {
			qianwang(index){
				let item = this.orderList[index]
				item.state = '已前往'
				uni.request({
					url:"updateXyyiliaopaibanyuyueactJson",
					method:"POST",
					data:item,
					success: () => {
						uni.request({
							url: "xyyiliaopaibanyuyueListJson",
							success: (res) => {
								let userinfo = uni.getStorageSync("userinfo")
								this.orderList = res.data.xyyiliaopaibanyuyues.filter(t=>{
									return t.xyyiliaoyhid == userinfo.id
								})
								this.quanbu = JSON.parse(JSON.stringify(this.orderList))
							}
						})
					}
				})
			},
			shanchu(index){
			  let item = this.orderList[index]
			  uni.request({
			  	url:"deleteXyyiliaopaibanyuyueJson?id="+item.id,
				success: () => {
					uni.request({
						url: "xyyiliaopaibanyuyueListJson",
						success: (res) => {
							let userinfo = uni.getStorageSync("userinfo")
							this.orderList = res.data.xyyiliaopaibanyuyues.filter(t=>{
								return t.xyyiliaoyhid == userinfo.id
							})
							this.quanbu = JSON.parse(JSON.stringify(this.orderList))
						}
					})
				}
			  })
			  uni.showToast({
			  	title:"操作成功",
				icon:'success'
			  })
			  
			},
			jinxingpingjia(index){
				let item = this.orderList[index]
				uni.setStorageSync("yuyuepaiban",item)
				uni.navigateTo({
					url:"/pages/xyyiliaoyhAddYuyuepingjia"
				})
			},
			getNowTime() {
				var now = new Date();
				var year = now.getFullYear(); // 获取年份
				var month = now.getMonth() + 1; // 获取月份，月份是从0开始的
				var day = now.getDate(); // 获取日期
				var hour = now.getHours(); // 获取小时
				var minute = now.getMinutes(); // 获取分钟
				var second = now.getSeconds(); // 获取秒
				// 对月、日、时、分、秒进行补0处理
				month = month < 10 ? '0' + month : month;
				day = day < 10 ? '0' + day : day;
				hour = hour < 10 ? '0' + hour : hour;
				minute = minute < 10 ? '0' + minute : minute;
				second = second < 10 ? '0' + second : second;
				return year + '-' + month + '-' + day
			},			duihua(index){
			   let item = this.orderList[index]
			   if(item.yuyuetime > this.getNowTime()){
				   uni.showToast({
				   	icon:"error",
					title:"时间未到"
				   })
				   return
			   }
			   if(item.yuyuetime < this.getNowTime()){
				   uni.showToast({
				   	icon:"error",
					title:"已过期"
				   })
				   item.state ='已过期'
				   uni.request({
				   	 url:"updateXyyiliaopaibanyuyueactJson",
					 method:"POST",
					 data:item,
					 success: () => {
					 	uni.request({
					 		url: "xyyiliaopaibanyuyueListJson",
					 		success: (res) => {
					 			let userinfo = uni.getStorageSync("userinfo")
					 			this.orderList = res.data.xyyiliaopaibanyuyues.filter(t=>{
					 				return t.xyyiliaoyhid == userinfo.id
					 			})
					 			this.quanbu = JSON.parse(JSON.stringify(this.orderList))
					 		}
					 	})
					 }
				   })
				   return
			   }
			   if(item.yuyuetime == this.getNowTime()){
				   uni.navigateTo({
				   	  url:'/pages/duihua?duihuaid='+item.id
				   })
			   }
			},
			// 切换订单状态
			changeStatus(status) {
				this.activeStatus = status
				if (status == "") {
					this.orderList = JSON.parse(JSON.stringify(this.quanbu))
					return
				}

				this.orderList = this.quanbu.filter(t => {
					return t.state == status
				})

			}
		}
	}
</script>

<style scoped>
	.container {
		display: flex;
		flex-direction: column;
		height: 100vh;
	}

	/* 状态栏 */
	.tab-bar {
		display: flex;
		background-color: #fff;
		overflow-x: scroll;
		flex-wrap: nowrap;
		padding: 10px 0;
		border-bottom: 1px solid #eee;
	}

	.tab-item {
		flex: 1;
		text-align: center;
		font-size: 16px;
		padding: 10px;
		color: #333;
		width: 100rpx;
	}

	.tab-item.active {
		color: #007aff;
		font-weight: bold;
		width: 100rpx;
		border-bottom: 2px solid #007aff;
	}

	/* 订单列表 */
	.order-list {
		flex: 1;
		overflow: auto;
		padding: 10px;
	}

	.order-card {
		background: #fff;
		margin-bottom: 10px;

		border-radius: 5px;
		box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	}

	.order-header {
		display: flex;
		justify-content: space-between;
		font-size: 14px;
		color: #666;
	}

	.order-status {
		color: #f56c6c;
	}

	.order-content {
		margin-top: 5px;
		font-size: 14px;
	}

	.order-price {
		font-size: 16px;
		color: #ff5722;
		font-weight: bold;
		margin-top: 5px;
	}

	.empty {
		text-align: center;
		margin-top: 20px;
		color: #999;
	}
</style>