<template>
	<view class="container">
		<view class="detail-card">
			<view class="header">
				<text class="title">病历详情单</text>
				<text class="status" :class="'s-' + order.state">{{ order.state || '待支付' }}</text>
			</view>
			
			<view class="info-group">
				<view class="info-item"><text class="label">记录时间：</text><text>{{ order.jilvtime }}</text></view>
				<view class="info-item"><text class="label">主治医生：</text><text>{{ order.xiaoyuanyisheng }}</text></view>
				<view class="info-item"><text class="label">患者姓名：</text><text>{{ order.xyyiliaoyh }}</text></view>
				<view class="info-item"><text class="label">学号：</text><text>{{ order.xuehao }}</text></view>
				<view class="info-item"><text class="label">症状描述：</text><text>{{ order.zhusu }}</text></view>
				<view class="info-item"><text class="label">初步诊断：</text><text style="color:#f00;font-weight:bold;">{{ order.zhenduan }}</text></view>
				<view class="info-item"><text class="label">医嘱建议：</text><text>{{ order.xiuxijiany }}</text></view>
				<view class="info-item"><text class="label">用药指导：</text><text>{{ order.yongyao }}</text></view>
			</view>
			
			<view class="payment-section">
				<view class="price-row">
					<text>支付金额：</text>
					<text class="price">¥ {{ order.zhifujine || '0.00' }}</text>
				</view>
				
				<view v-if="order.state == '已支付' && order.zhifupingzheng" class="voucher-box">
					<text style="margin-bottom: 5px; display: block;">支付凭证：</text>
					<image :src="host + order.zhifupingzheng" mode="aspectFit" style="width: 100%; height: 200px; background: #eee;"></image>
				</view>
				
				<view v-if="order.state != '已支付'" class="action-box">
					<button class="btn-upload" @click="uploadVoucher">上传支付凭证</button>
					<button class="btn-pay" :disabled="!tempVoucher" @click="confirmPay">确认支付</button>
					
					<image v-if="tempVoucher" :src="host + tempVoucher" mode="aspectFit" style="width: 100%; height: 150px; margin-top: 10px;"></image>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				order: {},
				host: this.$host,
				tempVoucher: ''
			}
		},
		onLoad(options) {
			if (options.id) {
				let userinfo = uni.getStorageSync("userinfo")
				uni.request({
					url: "yhbinglijilvListJson",
					success: (res) => {
						let found = res.data.yhbinglijilvs.find(t => t.id == options.id);
						if(found) {
							this.order = found;
							if(!this.order.state) this.order.state = '待支付';
						}
					}
				})
			}
		},
		methods: {
			uploadVoucher() {
				uni.chooseImage({
					count: 1,
					success: (res) => {
						const tempFilePaths = res.tempFilePaths;
						uni.uploadFile({
							url: "uploadFile",
							filePath: tempFilePaths[0],
							name: 'file',
							success: (uploadFileRes) => {
								let path = uploadFileRes.data
								if (path.includes('{"fileUrl"')) {
									path = JSON.parse(path).fileUrl;
								}
								this.tempVoucher = path;
								uni.showToast({title: "凭证已上传，请确认支付", icon: "none"});
							}
						});
					}
				});
			},
			confirmPay() {
				if(!this.tempVoucher) return;
				this.order.state = '已支付';
				this.order.zhifupingzheng = this.tempVoucher;
				
				// Using the backend update API - usually requires form-encoded OR json
				uni.request({
					url: "updateYhbinglijilvactJson",
					method: "POST",
					data: this.order,
					success: () => {
						uni.showToast({ title: "支付成功" });
						setTimeout(() => { uni.navigateBack(); }, 1500);
					}
				})
			}
		}
	}
</script>

<style scoped>
	.container { padding: 15px; background: #f8fafc; min-height: 100vh; }
	.detail-card { background: #fff; border-radius: 10px; padding: 20px; box-shadow: 0 4px 6px rgba(0,0,0,0.05); }
	.header { display: flex; justify-content: space-between; border-bottom: 1px solid #eee; padding-bottom: 15px; margin-bottom: 15px; }
	.title { font-size: 18px; font-weight: bold; }
	.status { font-weight: bold; }
	.s-待支付 { color: #f56c6c; }
	.s-已支付 { color: #67c23a; }
	.info-group { margin-bottom: 20px; }
	.info-item { margin-bottom: 10px; font-size: 15px; line-height: 1.5; }
	.label { color: #666; width: 80px; display: inline-block; }
	.payment-section { border-top: 1px dashed #ccc; padding-top: 15px; }
	.price-row { display: flex; justify-content: space-between; font-size: 16px; margin-bottom: 15px; }
	.price { color: #ff5722; font-size: 20px; font-weight: bold; }
	.btn-upload { background: #e6f7ff; color: #1890ff; border: 1px solid #91d5ff; margin-bottom: 10px; }
	.btn-pay { background: #1890ff; color: #fff; }
</style>
