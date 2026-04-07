<template>

	<view>
		<form @submit="xyyiliaoyhAddTijianyhyuyueactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">校园体检事项:</view>
						<input maxlength="-1" v-model="tijianyhyuyue.xytijianshixiang" class="input" placeholder="请输入校园体检事项" />
						<view style="margin: 10px;">校园体检事项id:</view>
						<input maxlength="-1" v-model="tijianyhyuyue.xytijianshixiangid" class="input" placeholder="请输入校园体检事项id" />
						<view style="margin: 10px;">体检位置:</view>
						<textarea class="input" v-model="tijianyhyuyue.address" style="width: auto;min-height: 100px;"
								  placeholder="请输入体检位置">
						</textarea>
						<view style="margin: 10px;">体检时间:</view>
						<input maxlength="-1" v-model="tijianyhyuyue.shijian" class="input" placeholder="请输入体检时间" />
						<view style="margin: 10px;">选择体检封面:</view>
						<view @click="changeImgFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+tijianyhyuyue.img"></image>
							</view>
						</view>
						<view style="margin: 10px;">状态:</view>
						<input maxlength="-1" v-model="tijianyhyuyue.state" class="input" placeholder="请输入状态" />
			</view>

			<button class="btn biaodanbtn" form-type="submit">添加</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
							xyyiliaoyhs:[],
				tijianyhyuyue: {
								xytijianshixiang:"",
								xytijianshixiangid:null,
								xyyiliaoyh:"",
								xyyiliaoyhid:null,
								address:"",
								shijian:"",
								img:"",
								state:"",
				}
			}
		},
		methods: {
					changeImgFile() {
						let _this = this;
						uni.chooseImage({
							count: 1,
							success(res) {
								uni.uploadFile({
									url: "uploadFile",
									filePath: res.tempFilePaths[0],
									name: "file",
									success(res) {
										_this.tijianyhyuyue.img = JSON.parse(res.data).fileUrl
									}
								})
							}
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
				return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second
			},
			xyyiliaoyhAddTijianyhyuyueactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhAddTijianyhyuyueactJson",
					method: "POST",
					data: _this.tijianyhyuyue,
					success(res) {
						if (res.data.message == "添加体检用户预约成功") {
							uni.showToast({
								icon: "success",
								title: "添加体检用户预约成功",
								duration: 2000,
							})
							return
						} else {
							uni.showToast({
								icon: "error",
								title: res.data.message,
								duration: 2000
							})
						}

					}
				})
			}
		},
		onLoad(e) {
			let _this = this;
			
			uni.request({
				url:"xyyiliaoyhAddTijianyhyuyueJson",
				method:"POST",
				success(res) {
							_this.xyyiliaoyhs = res.data.xyyiliaoyhs
				}
			})
			var userinfo = uni.getStorageSync("userinfo")
			_this.tijianyhyuyue.xyyiliaoyhid =  userinfo.id
			_this.tijianyhyuyue.xyyiliaoyh = userinfo.username

			let item = uni.getStorageSync("tijianshixiang")
			this.tijianyhyuyue.xytijianshixiang = item.tijiant
			this.tijianyhyuyue.xytijianshixiangid = item.id
			this.tijianyhyuyue.adress = item.tijianadress
			this.tijianyhyuyue.shijian = item.tijiantime 
			this.tijianyhyuyue.img = item.tijianimg
			this.tijianyhyuyue.state = '待前往'
		},
	}
</script>

<style>
	page {
		background-color: #f8fafc;
	}

	.input {
		border-bottom: 1px solid #e2e8f0;
		padding: 10px;
		margin: 5px 10px;
	}

	.form {
		background-color: #FFFFFF;
		margin-top: 15px;
		padding: 0 0px 15px 0px;
	}

	.biaodanbtn {
		color: #FFFFFF;
		background: linear-gradient(135deg, #0e7490, #0284c7);
		margin: 15px;
	}
</style>