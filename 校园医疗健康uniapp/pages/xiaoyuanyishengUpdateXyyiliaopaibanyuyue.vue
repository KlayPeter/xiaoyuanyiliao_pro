<template>

	<view>
		<form @submit="xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson">
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


			<button class="btn biaodanbtn" form-type="submit">修改</button>
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
				xyyiliaopaibanyuyue:{}
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
			xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson(e) {
				let _this = this
				uni.request({
					url: "xiaoyuanyishengUpdateXyyiliaopaibanyuyueactJson",
					method: "POST",
					data: _this.xyyiliaopaibanyuyue,
					success(res) {
						console.log(res)
						if (res.data.message == "修改校园医疗排班预约成功") {
							uni.showToast({
								icon: "success",
								title: "修改校园医疗排班预约成功",
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
			},

		},
		onLoad(e) {

			let _this = this;
			console.log(e)
			uni.request({
				url: "xiaoyuanyishengUpdateXyyiliaopaibanyuyueJson?id=" + e.id,
				success: res => {
					console.log(res.data)
					_this.xyyiliaopaibanyuyue = res.data.xyyiliaopaibanyuyue
							_this.xiaoyuanyishengs = res.data.usernames
							_this.xyyiliaoyhs = res.data.usernames
				}
			})
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

	.kefu {
		color: #df2d2d;
		text-align: center;
		font-size: 14px;
		margin-top: 10px;
	}
</style>