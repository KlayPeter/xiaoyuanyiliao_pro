<template>

	<view>
		<form @submit="xyyiliaoyhAddXyyiliaopaibanyuyueactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">简要问题描述:</view>
						<input maxlength="-1" v-model="xyyiliaopaibanyuyue.jianyaowenti" class="input" placeholder="请输入简要问题描述" />
							<view style="margin: 10px;">校园医生:</view>
							<picker disabled="" :range="xiaoyuanyishengs" range-key="username" @change="changeXiaoyuanyisheng">
								<view class="input">{{xyyiliaopaibanyuyue.xiaoyuanyisheng}}</view>
							</picker>
						<!-- <view style="margin: 10px;">选择校园医生照片:</view>
						<view @click="changeXiaoyuanyishengimgFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xyyiliaopaibanyuyue.xiaoyuanyishengimg"></image>
							</view>
						</view>
						<view style="margin: 10px;">选择校园用户照片:</view>
						<view @click="changeXyyiliaoyhimgFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xyyiliaopaibanyuyue.xyyiliaoyhimg"></image>
							</view>
						</view> -->
						<view style="margin: 10px;">预约日期:</view>
						<picker mode="date" :start="dateStart" :end="dateEnd" @change="onDateChange">
							<view class="input">
								{{ xyyiliaopaibanyuyue.yuyuetime || '请选择本月未过日期' }}
							</view>
						</picker>
							<view style="margin: 10px;">选择类型:</view>
							<picker :range="typeas" @change="changeTypea">
								<view class="input">{{xyyiliaopaibanyuyue.typea}}</view>
							</picker>
						<!-- <view style="margin: 10px;">状态:</view>
						<input maxlength="-1" v-model="xyyiliaopaibanyuyue.state" class="input" placeholder="请输入状态" /> -->
						<!-- <view style="margin: 10px;">创建时间:</view>
						<input maxlength="-1" v-model="xyyiliaopaibanyuyue.addtime" class="input" placeholder="请输入创建时间" /> -->
			</view>

			<button class="btn biaodanbtn" form-type="submit">添加</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
							xiaoyuanyishengs:[],
							xyyiliaoyhs:[],
							typeas:[
											"线上",
											"线下"
							],
							// 预约日期可选范围：本月当前日期到本月最后一天
							dateStart: '',
							dateEnd: '',
				xyyiliaopaibanyuyue: {
								jianyaowenti:"",
								xiaoyuanyisheng:"",
								xiaoyuanyishengid:null,
								xiaoyuanyishengimg:"",
								xyyiliaoyh:"",
								xyyiliaoyhid:null,
								xyyiliaoyhimg:"",
								yuyuetime:"",
								typea:"",
								state:"",
								addtime:"",
				}
			}
		},
		methods: {
						changeXiaoyuanyisheng(event) {
							this.xyyiliaopaibanyuyue.xiaoyuanyishengid = this.xiaoyuanyishengs[event.detail.value].id
							this.xyyiliaopaibanyuyue.xiaoyuanyisheng = this.xiaoyuanyishengs[event.detail.value].username
						},
						changeTypea(event) {
							this.xyyiliaopaibanyuyue.typea = this.typeas[event.detail.value]
						},
						onDateChange(e) {
							// 只允许选择本月且未过的日期，start/end 已经限制为当前月未过日期
							this.xyyiliaopaibanyuyue.yuyuetime = e.detail.value
						},
					changeXiaoyuanyishengimgFile() {
						let _this = this;
						uni.chooseImage({
							count: 1,
							success(res) {
								uni.uploadFile({
									url: "uploadFile",
									filePath: res.tempFilePaths[0],
									name: "file",
									success(res) {
										_this.xyyiliaopaibanyuyue.xiaoyuanyishengimg = JSON.parse(res.data).fileUrl
									}
								})
							}
						})
					},
					changeXyyiliaoyhimgFile() {
						let _this = this;
						uni.chooseImage({
							count: 1,
							success(res) {
								uni.uploadFile({
									url: "uploadFile",
									filePath: res.tempFilePaths[0],
									name: "file",
									success(res) {
										_this.xyyiliaopaibanyuyue.xyyiliaoyhimg = JSON.parse(res.data).fileUrl
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
			xyyiliaoyhAddXyyiliaopaibanyuyueactJson(e) {
				let _this = this
				if(this.xyyiliaopaibanyuyue.typea == '线上'){
					this.xyyiliaopaibanyuyue.state = '待对话'
				}else{
					this.xyyiliaopaibanyuyue.state = '待前往'
				}
				uni.request({
					url: "xyyiliaoyhAddXyyiliaopaibanyuyueactJson",
					method: "POST",
					data: _this.xyyiliaopaibanyuyue,
					success(res) {
						if (res.data.message == "添加校园医疗排班预约成功") {
							uni.showToast({
								icon: "success",
								title: "添加校园医疗排班预约成功",
								duration: 2000,
							})
							uni.switchTab({
								url:"/pages/htMenu"
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
			
			// 预约日期限制：只能预约本月且未过的日期
			const now = new Date()
			const year = now.getFullYear()
			const month = now.getMonth() + 1
			const day = now.getDate()
			const mm = month < 10 ? ('0' + month) : month
			const dd = day < 10 ? ('0' + day) : day
			// 本月第一天和最后一天
			const firstDay = '01'
			const lastDayDate = new Date(year, month, 0).getDate() // 当月最后一天
			const lastDay = lastDayDate < 10 ? ('0' + lastDayDate) : lastDayDate
			// 只允许选择今天到本月最后一天
			this.dateStart = year + '-' + mm + '-' + dd
			this.dateEnd = year + '-' + mm + '-' + lastDay

			uni.request({
				url:"xyyiliaoyhAddXyyiliaopaibanyuyueJson",
				method:"POST",
				success(res) {
							_this.xiaoyuanyishengs = res.data.xiaoyuanyishengs
							_this.xyyiliaoyhs = res.data.xyyiliaoyhs
				}
			})
			
			var userinfo = uni.getStorageSync("userinfo")
			_this.xyyiliaopaibanyuyue.xyyiliaoyhid =  userinfo.id
			_this.xyyiliaopaibanyuyue.xyyiliaoyh = userinfo.username
			_this.xyyiliaopaibanyuyue.xyyiliaoyhimg = userinfo.xyyiliaoyhimg
			
			let xiaoyuanyisheng = uni.getStorageSync("xiaoyuanyisheng")
			this.xyyiliaopaibanyuyue.xiaoyuanyisheng = xiaoyuanyisheng.username
			this.xyyiliaopaibanyuyue.xiaoyuanyishengid = xiaoyuanyisheng.id 
			this.xyyiliaopaibanyuyue.xiaoyuanyishengimg = xiaoyuanyisheng.schoolysavaator
			this.xyyiliaopaibanyuyue.addtime = this.getNowTime()

			//格式  yyyy-MM
			let paibanyue = uni.getStorageSync("paibanyue")
		},
	}
</script>

<style>
	page {
		background-color: #f8f8f8;
	}

	.input {
		border-bottom: 1px solid #d6d6d6;
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
		background-color: #55aa7f;
		margin: 15px;
	}
</style>