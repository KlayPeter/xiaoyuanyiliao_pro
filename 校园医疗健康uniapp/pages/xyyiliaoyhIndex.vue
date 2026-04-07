<template>

	<view>
		<form @submit="xyyiliaoyhUpdateIndexJson">
			<view class="form biaodan">
						<view style="margin: 10px;">账号:</view>
						<input maxlength="-1" v-model="xyyiliaoyh.username" class="input" placeholder="请输入账号" />
						<view style="margin: 10px;">密码:</view>
						<input maxlength="-1" v-model="xyyiliaoyh.password" class="input" placeholder="请输入密码" />
						<view style="margin: 10px;">校园用户昵称:</view>
						<input maxlength="-1" v-model="xyyiliaoyh.xyyiliaoyhname" class="input" placeholder="请输入校园用户昵称" />
							<view style="margin: 10px;">选择用户性别:</view>
							<picker :range="xyyiliaoyhsexs" @change="changeXyyiliaoyhsex">
								<view class="input">{{xyyiliaoyh.xyyiliaoyhsex}}</view>
							</picker>
						<view style="margin: 10px;">用户年龄:</view>
						<input maxlength="-1" v-model="xyyiliaoyh.xyyiliaoyhage" class="input" placeholder="请输入用户年龄" />
						<view style="margin: 10px;">用户电话:</view>
						<input maxlength="-1" v-model="xyyiliaoyh.xyyiliaoyhphone" class="input" placeholder="请输入用户电话" />
						<view style="margin: 10px;">选择用户照片:</view>
						<view @click="changeXyyiliaoyhimgFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xyyiliaoyh.xyyiliaoyhimg"></image>
							</view>
						</view>
						<view style="margin: 10px;">学院:</view>
						<input maxlength="-1" v-model="xyyiliaoyh.college" class="input" placeholder="请输入学院" />
			</view>

			<button class="btn biaodanbtn" form-type="submit">修改</button>
		</form>
	</view>

</template>

<script>
	export default {
		data() {
			return {
							xyyiliaoyhsexs:[
										"男",
										"女"
							],
				xyyiliaoyh:{}
			}
		},
		methods: {
					changeXyyiliaoyhsex(event) {
						this.xyyiliaoyh.xyyiliaoyhsex = this.xyyiliaoyhsexs[event.detail.value]
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
										_this.xyyiliaoyh.xyyiliaoyhimg = JSON.parse(res.data).fileUrl
									}
								})
							}
						})
					},
			xyyiliaoyhUpdateIndexJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhUpdateIndexJson",
					method: "POST",
					data: _this.xyyiliaoyh,
					success(res) {
						console.log(res)
						uni.setStorageSync("userinfo",_this.xyyiliaoyh)
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
			this.xyyiliaoyh = uni.getStorageSync("userinfo")
			uni.request({
				url:"xyyiliaoyhIndexJson",
				method:"POST",
				success(res) {
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

</style>