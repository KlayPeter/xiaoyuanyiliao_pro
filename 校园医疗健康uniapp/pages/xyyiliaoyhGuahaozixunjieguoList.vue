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
				<image class="empty-img" src="../static/medical_list_default.png" mode="widthFix" style="width: 300rpx; opacity: 0.5; margin-bottom: 20rpx;"></image>
				<view>暂无咨询结果</view>
			</view>
            <view v-else class="list-wrapper">
				<view v-for="(order, index) in orderList" :key="index" class="order-card">
                    <view class="order-header">
                        <text class="order-id"> {{ order.kaifangtime }}</text>
                        <text :class="['order-status', 's-' + order.state]">{{ order.state }}</text>
                    </view>
                    <view class="order-content">
						<view class="r-row"><text class="r-label">医生</text><text class="r-val">{{ order.xiaoyuanyisheng }}</text></view>
						<view class="r-row"><text class="r-label">描述</text><text class="r-val">{{ order.zhusu }}</text></view>
						<view class="r-row"><text class="r-label">体征</text><text class="r-val">体温: {{ order.yonghutiwen }} | 心率: {{order.xinlv}}</text></view>
						<view class="r-row"><text class="r-label">建议</text><text class="r-val">{{ order.xiuxijiany }}</text></view>
						<view class="r-row"><text class="r-label">诊断结果</text><text class="r-val" style="color: #2563eb;">{{ order.zhenduan }}</text></view>
						<view class="r-row"><text class="r-label">用药</text><text class="r-val" style="color: #ef4444;">{{ order.yongyao }}</text></view>
                        
                        <view class="order-price" style="justify-content: space-between; align-items: center;">
							<text style="color: #ef4444; font-size: 32rpx;">¥{{ order.price }}</text>
							<view style="display: flex; gap: 16rpx;">
								<button class="btn-primary" v-if="order.state == '待支付'" @click="lingyao(index)">立即支付拿药</button>
								<button class="btn-danger" v-if="order.state == '已支付'" @click="shanchu(index)">移除记录</button>
							</view>
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
                        label: '待支付',
                        value: '待支付'
                    },
                    {
                        label: '已支付',
                        value: '已支付'
                    },
                ],
                orderList: [], // 订单数据
                quanbu: []
            }
        },
        onLoad() {
			let userinfo = uni.getStorageSync("userinfo")
            uni.request({
                url: "guahaozixunjieguoListJson",
                success: (res) => {
                    this.orderList = res.data.guahaozixunjieguos.filter(t=>{
						return t.xyyiliaoyhid == userinfo.id
					})
                    this.quanbu = JSON.parse(JSON.stringify(this.orderList))
                }
            })
        },
        methods: {
			shanchu(index){
				let item = this.orderList[index]
				uni.request({
					url:"deleteGuahaozixunjieguoJson?id="+item.id,
					success: () => {
						let userinfo = uni.getStorageSync("userinfo")
						uni.request({
						    url: "guahaozixunjieguoListJson",
						    success: (res) => {
						        this.orderList = res.data.guahaozixunjieguos.filter(t=>{
									return t.xyyiliaoyhid == userinfo.id
								})
						        this.quanbu = JSON.parse(JSON.stringify(this.orderList))
						    }
						})
					}
				})
				uni.showToast({
					title:"删除成功",
					icon:'success'
				})
				
			},            lingyao(index){
				let item = this.orderList[index]
				item.state = '已支付'
				uni.request({
					url:"updateGuahaozixunjieguoactJson",
					method:"POST",
					data:item,
					success: () => {
						let userinfo = uni.getStorageSync("userinfo")
						uni.request({
						    url: "guahaozixunjieguoListJson",
						    success: (res) => {
						        this.orderList = res.data.guahaozixunjieguos.filter(t=>{
									return t.xyyiliaoyhid == userinfo.id
								})
						        this.quanbu = JSON.parse(JSON.stringify(this.orderList))
						    }
						})
					}
				})
				uni.showToast({
					title:"支付成功",
					icon:"success"
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
	.order-id { font-size: 26rpx; color: #64748b; font-weight: 600; font-family: monospace; }
	.order-status { font-size: 26rpx; color: #f59e0b; font-weight: 700; }
	.order-status.s-已支付 { color: #10b981; }

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