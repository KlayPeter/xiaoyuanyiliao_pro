<template>

	<view>
		<form @submit="xyyiliaoyhUpdateTijianyhyuyueactJson">
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


			<button class="btn biaodanbtn" form-type="submit">修改</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
							xyyiliaoyhs:[],
				tijianyhyuyue:{}
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
			xyyiliaoyhUpdateTijianyhyuyueactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhUpdateTijianyhyuyueactJson",
					method: "POST",
					data: _this.tijianyhyuyue,
					success(res) {
						console.log(res)
						if (res.data.message == "修改体检用户预约成功") {
							uni.showToast({
								icon: "success",
								title: "修改体检用户预约成功",
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
				url: "xyyiliaoyhUpdateTijianyhyuyueJson?id=" + e.id,
				success: res => {
					console.log(res.data)
					_this.tijianyhyuyue = res.data.tijianyhyuyue
							_this.xyyiliaoyhs = res.data.usernames
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

	.kefu {
		color: #df2d2d;
		text-align: center;
		font-size: 14px;
		margin-top: 10px;
	}
</style>