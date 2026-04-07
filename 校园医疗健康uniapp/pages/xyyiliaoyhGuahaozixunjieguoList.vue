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
            <view v-if="orderList.length === 0" class="empty">暂无咨询结果</view>
            <view v-else v-for="(order, index) in orderList" :key="index" class="order-card">
                <view  style="padding: 15px;">
                    <view class="order-header">
                        <text class="order-id"> {{ order.kaifangtime }}</text>
                        <text class="order-status">{{ order.state }}</text>
                    </view>
                    <view class="order-content">
                        <view>医生: {{ order.xiaoyuanyisheng }}</view>
                        <view>描述: {{ order.zhusu }}</view>
                        <view>体温: {{ order.yonghutiwen }} 心率：{{order.xinlv}}</view>
                        <view>休息建议: {{ order.xiuxijiany }}</view>
						<view>诊断结果: {{ order.zhenduan }}</view>
						<view>用药: {{ order.yongyao }}</view>
                        <view class="order-price" style="display: flex;align-items: center;">
                            <text>总价: ¥{{ order.price }}</text>
                        </view>
                        <view class="order-price" style="display: flex;align-items: center;">
                            <button v-if="order.state == '待支付'" @click="lingyao(index)" type="primary" size="mini">进行支付，领药</button>
							<button v-if="order.state == '已支付'" @click="shanchu(index)" type="primary" size="mini">删除</button>
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