<template>

	<view>
		<form @submit="xiaoyuanyishengAddXyyiliaopaibanyuyueactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">简要问题描述:</view>
						<input maxlength="-1" v-model="xyyiliaopaibanyuyue.jianyaowenti" class="input" placeholder="请输入简要问题描述" />
						<view style="margin: 10px;">选择校园医生照片:</view>
						<view @click="changeXiaoyuanyishengimgFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xyyiliaopaibanyuyue.xiaoyuanyishengimg"></image>
							</view>
						</view>
							<view style="margin: 10px;">选择校园用户:</view>
							<picker :range="xyyiliaoyhs" range-key="username" @change="changeXyyiliaoyh">
								<view class="input">{{xyyiliaopaibanyuyue.xyyiliaoyh}}</view>
							</picker>
						<view style="margin: 10px;">选择校园用户照片:</view>
						<view @click="changeXyyiliaoyhimgFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xyyiliaopaibanyuyue.xyyiliaoyhimg"></image>
							</view>
						</view>
						<view style="margin: 10px;">预约日期:</view>
						<input maxlength="-1" v-model="xyyiliaopaibanyuyue.yuyuetime" class="input" placeholder="请输入预约日期" />
							<view style="margin: 10px;">选择类型:</view>
							<picker :range="typeas" @change="changeTypea">
								<view class="input">{{xyyiliaopaibanyuyue.typea}}</view>
							</picker>
						<view style="margin: 10px;">状态:</view>
						<input maxlength="-1" v-model="xyyiliaopaibanyuyue.state" class="input" placeholder="请输入状态" />
						<view style="margin: 10px;">创建时间:</view>
						<input maxlength="-1" v-model="xyyiliaopaibanyuyue.addtime" class="input" placeholder="请输入创建时间" />
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
						changeXyyiliaoyh(event) {
							this.xyyiliaopaibanyuyue.xyyiliaoyhid = this.xyyiliaoyhs[event.detail.value].id
							this.xyyiliaopaibanyuyue.xyyiliaoyh = this.xyyiliaoyhs[event.detail.value].username
						},
						changeTypea(event) {
							this.xyyiliaopaibanyuyue.typea = this.typeas[event.detail.value]
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
			xiaoyuanyishengAddXyyiliaopaibanyuyueactJson(e) {
				let _this = this
				uni.request({
					url: "xiaoyuanyishengAddXyyiliaopaibanyuyueactJson",
					method: "POST",
					data: _this.xyyiliaopaibanyuyue,
					success(res) {
						if (res.data.message == "添加校园医疗排班预约成功") {
							uni.showToast({
								icon: "success",
								title: "添加校园医疗排班预约成功",
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
				url:"xiaoyuanyishengAddXyyiliaopaibanyuyueJson",
				method:"POST",
				success(res) {
							_this.xiaoyuanyishengs = res.data.xiaoyuanyishengs
							_this.xyyiliaoyhs = res.data.xyyiliaoyhs
				}
			})
			var userinfo = uni.getStorageSync("userinfo")
			_this.xyyiliaopaibanyuyue.xiaoyuanyishengid =  userinfo.id
			_this.xyyiliaopaibanyuyue.xiaoyuanyisheng = userinfo.username

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