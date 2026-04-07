<template>
    <view class="container">
        <!-- 订单状态筛选 -->
		<view class="tabs-container">
			<scroll-view class="tab-bar-scroll" scroll-x :show-scrollbar="false">
				<view class="tab-bar-wrapper">
					<view v-for="(item, index) in statusList" :key="index"
						:class="['tab-item', activeStatus === item.value ? 'active' : '']" @click="changeStatus(item.value)">
						<text>{{ item.label }}</text>
					</view>
				</view>
			</scroll-view>
		</view>
		
        <!-- 订单列表 -->
        <scroll-view class="order-list" scroll-y>
            <view v-if="orderList.length === 0" class="empty">
				<image class="empty-img" src="../static/medical_checkup.png" mode="widthFix" style="width: 300rpx; opacity: 0.5; margin-bottom: 20rpx;"></image>
				<view>暂无体检预约</view>
			</view>
			
            <view v-else class="list-wrapper">
				<view v-for="(order, index) in orderList" :key="index" class="order-card">
					<view class="order-header">
						<text class="order-id">体检项: {{ order.xytijianshixiang }}</text>
						<text :class="['order-status', 's-' + order.state]">{{ order.state }}</text>
					</view>
					<view class="order-content">
						<view class="r-row"><text class="r-label">位置</text><text class="r-val">{{ order.address }}</text></view>
						<view class="r-row"><text class="r-label">时间</text><text class="r-val">{{ order.shijian }}</text></view>
						<view class="order-price">
							<button class="btn-primary" v-if="order.state == '待前往'" @click="qianwang(index)">确认前往</button>
							<button class="btn-danger" v-if="order.state == '已出成绩'" @click="shanchu(index)">删除记录</button>
						</view>
					</view>
				</view>
				<view style="height: 60rpx;"></view>
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
                        label: '待前往',
                        value: '待前往'
                    },
                    {
                        label: '待出成绩',
                        value: '待出成绩'
                    },
                    {
                        label: '已出成绩',
                        value: '已出成绩'
                    },
					{
					    label: '已过期',
					    value: '已过期'
					},
                ],
                orderList: [], // 订单数据
                quanbu: []
            }
        },
        onLoad() {
			
            uni.request({
                url: "tijianyhyuyueListJson",
                success: (res) => {
					let userinfo = uni.getStorageSync("userinfo")
                    this.orderList = res.data.tijianyhyuyues.filter(t=>{
						return t.xyyiliaoyhid == userinfo.id
					})
                    this.quanbu = JSON.parse(JSON.stringify(this.orderList))
                }
            })
        },
        methods: {
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
			},
            qianwang(index){
				let item = this.orderList[index]
				if(item.shijian > this.getNowTime()){
					uni.showToast({
						title:"测试时间未到",
						icon:"none"
					})
					return
				}
				if(item.shijian < this.getNowTime()){
					uni.showToast({
						title:"已过期",
						icon:"none"
					})
					item.state = '已过期'
					uni.request({
						url:"updateTijianyhyuyueactJson",
						method:"POST",
						data:item,
						success: () => {
							let userinfo = uni.getStorageSync("userinfo")
							this.orderList = res.data.tijianyhyuyues.filter(t=>{
								return t.xyyiliaoyhid == userinfo.id
							})
							this.quanbu = JSON.parse(JSON.stringify(this.orderList))
						}
					})
					return
				}
				
				item.state = '待出成绩'
				uni.request({
					url:"updateTijianyhyuyueactJson",
					method:'POST',
					data:item,
					success: (res) => {
						let userinfo = uni.getStorageSync("userinfo")
						uni.request({
						    url: "tijianyhyuyueListJson",
						    success: (res) => {
						        this.orderList = res.data.tijianyhyuyues.filter(t=>{
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
					url:"deleteTijianyhyuyueJson?id="+item.id,
					success: (res) => {
						let userinfo = uni.getStorageSync("userinfo")
						uni.request({
						    url: "tijianyhyuyueListJson",
						    success: (res) => {
						        this.orderList = res.data.tijianyhyuyues.filter(t=>{
									return t.xyyiliaoyhid == userinfo.id
								})
						        this.quanbu = JSON.parse(JSON.stringify(this.orderList))
						    }
						})
					}
				})
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
		background: #f8fafc url('/static/real_medical_bg.png') center/cover fixed no-repeat;
	}

	/* ======== 状态栏优化 ======== */
	.tabs-container {
		background: rgba(255, 255, 255, 0.95);
		backdrop-filter: blur(20px);
		border-bottom: 2rpx solid rgba(0,0,0,0.05);
		box-shadow: 0 4rpx 12rpx rgba(0,0,0,0.02);
		z-index: 10;
	}
	.tab-bar-scroll {
		width: 100%;
		white-space: nowrap;
	}
	::v-deep .tab-bar-scroll ::-webkit-scrollbar {
		display: none;
		width: 0 !important;
		height: 0 !important;
		-webkit-appearance: none;
		background: transparent;
	}
	.tab-bar-wrapper {
		display: inline-flex;
		padding: 0 10rpx;
	}
	.tab-item {
		display: inline-block;
		padding: 24rpx 32rpx;
		font-size: 28rpx;
		color: #64748b;
		position: relative;
		font-weight: 500;
		transition: all 0.2s;
	}
	.tab-item.active {
		color: #2563eb;
		font-weight: 700;
	}
	.tab-item.active::after {
		content: '';
		position: absolute;
		bottom: 4rpx;
		left: 32rpx;
		right: 32rpx;
		height: 6rpx;
		background: #2563eb;
		border-radius: 6rpx;
	}

	/* ======== 订单列表优化 ======== */
	.order-list {
		flex: 1;
		overflow: auto;
	}
	.list-wrapper {
		padding: 24rpx;
	}

	.order-card {
		background: rgba(255, 255, 255, 0.9);
		backdrop-filter: blur(24px);
		margin-bottom: 24rpx;
		border-radius: 32rpx;
		box-shadow: 0 8rpx 32rpx rgba(0, 0, 0, 0.04);
		border: 2rpx solid #ffffff;
		overflow: hidden;
	}

	.order-header {
		display: flex;
		justify-content: space-between;
		padding: 24rpx 32rpx;
		background: rgba(248, 250, 252, 0.5);
		border-bottom: 2rpx dashed #e2e8f0;
	}
	.order-id { font-size: 28rpx; color: #0f172a; font-weight: 700; }
	.order-status { font-size: 26rpx; color: #f59e0b; font-weight: 700; }
	.order-status.s-已出成绩 { color: #10b981; }
	.order-status.s-待前往 { color: #3b82f6; }

	.order-content {
		padding: 32rpx;
	}
	.r-row { display: flex; margin-bottom: 12rpx; font-size: 28rpx; line-height: 1.6; }
	.r-label { width: 140rpx; color: #94a3b8; }
	.r-val { flex: 1; color: #0f172a; font-weight: 500; }

	.order-price {
		margin-top: 32rpx;
		display: flex;
		justify-content: flex-end;
		gap: 16rpx;
	}
	
	.btn-primary { 
		background: #2563eb; color: #fff; 
		border-radius: 100rpx; padding: 0 32rpx; 
		height: 60rpx; line-height: 60rpx; font-size: 26rpx; margin: 0; font-weight: 600;
	}
	.btn-danger {
		background: #fef2f2; color: #ef4444; border: 2rpx solid #fee2e2;
		border-radius: 100rpx; padding: 0 32rpx; 
		height: 60rpx; line-height: 56rpx; font-size: 26rpx; margin: 0; font-weight: 600;
	}

	.empty {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		margin-top: 160rpx;
		color: #94a3b8;
		font-weight: 500;
	}
</style>