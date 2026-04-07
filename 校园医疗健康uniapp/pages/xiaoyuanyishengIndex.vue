<template>

	<view>
		<form @submit="xiaoyuanyishengUpdateIndexJson">
			<view class="form biaodan">
						<view style="margin: 10px;">账号:</view>
						<input maxlength="-1" v-model="xiaoyuanyisheng.username" class="input" placeholder="请输入账号" />
						<view style="margin: 10px;">密码:</view>
						<input maxlength="-1" v-model="xiaoyuanyisheng.password" class="input" placeholder="请输入密码" />
						<view style="margin: 10px;">医生姓名:</view>
						<input maxlength="-1" v-model="xiaoyuanyisheng.schoolyishengname" class="input" placeholder="请输入医生姓名" />
							<view style="margin: 10px;">选择医生性别:</view>
							<picker :range="schoolyssexs" @change="changeSchoolyssex">
								<view class="input">{{xiaoyuanyisheng.schoolyssex}}</view>
							</picker>
						<view style="margin: 10px;">医生年龄:</view>
						<input maxlength="-1" v-model="xiaoyuanyisheng.schoolysage" class="input" placeholder="请输入医生年龄" />
						<view style="margin: 10px;">医生联系电话:</view>
						<input maxlength="-1" v-model="xiaoyuanyisheng.schoolysphone" class="input" placeholder="请输入医生联系电话" />
						<view style="margin: 10px;">选择医生头像:</view>
						<view @click="changeSchoolysavaatorFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xiaoyuanyisheng.schoolysavaator"></image>
							</view>
						</view>
						<view style="margin: 10px;">医生简介:</view>
						<textarea class="input" v-model="xiaoyuanyisheng.schoolysjianjie" style="width: auto;min-height: 100px;"
								  placeholder="请输入医生简介">
						</textarea>
			</view>

			<button class="btn biaodanbtn" form-type="submit">修改</button>
		</form>
	</view>

</template>

<script>
	export default {
		data() {
			return {
							schoolyssexs:[
										"男",
										"女"
							],
				xiaoyuanyisheng:{}
			}
		},
		methods: {
					changeSchoolyssex(event) {
						this.xiaoyuanyisheng.schoolyssex = this.schoolyssexs[event.detail.value]
					},
					changeSchoolysavaatorFile() {
						let _this = this;
						uni.chooseImage({
							count: 1,
							success(res) {
								uni.uploadFile({
									url: "uploadFile",
									filePath: res.tempFilePaths[0],
									name: "file",
									success(res) {
										_this.xiaoyuanyisheng.schoolysavaator = JSON.parse(res.data).fileUrl
									}
								})
							}
						})
					},
			xiaoyuanyishengUpdateIndexJson(e) {
				let _this = this
				uni.request({
					url: "xiaoyuanyishengUpdateIndexJson",
					method: "POST",
					data: _this.xiaoyuanyisheng,
					success(res) {
						console.log(res)
						uni.setStorageSync("userinfo",_this.xiaoyuanyisheng)
						uni.showToast({
							icon: "none",
							title: "修改个人信息成功"
						})
					}
				})
			},


		},
		onLoad(e) {

			let _this = this;
			this.xiaoyuanyisheng = uni.getStorageSync("userinfo")
			uni.request({
				url:"xiaoyuanyishengIndexJson",
				method:"POST",
				success(res) {
				}
			})
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