<template>

	<view>
		<form @submit="xyyiliaoyhUpdateJiankangdanganactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">测试时间:</view>
						<input maxlength="-1" v-model="jiankangdangan.shijian" class="input" placeholder="请输入测试时间" />
						<view style="margin: 10px;">身高:</view>
						<input maxlength="-1" v-model="jiankangdangan.height" class="input" placeholder="请输入身高" />
						<view style="margin: 10px;">体重:</view>
						<input maxlength="-1" v-model="jiankangdangan.weight" class="input" placeholder="请输入体重" />
						<view style="margin: 10px;">bmi数值:</view>
						<input maxlength="-1" v-model="jiankangdangan.bmi" class="input" placeholder="请输入bmi数值" />
						<view style="margin: 10px;">左眼视力:</view>
						<input maxlength="-1" v-model="jiankangdangan.zuoyanshili" class="input" placeholder="请输入左眼视力" />
						<view style="margin: 10px;">右眼视力:</view>
						<input maxlength="-1" v-model="jiankangdangan.youyanshili" class="input" placeholder="请输入右眼视力" />
						<view style="margin: 10px;">肺活量:</view>
						<input maxlength="-1" v-model="jiankangdangan.feihuoliang" class="input" placeholder="请输入肺活量" />
						<view style="margin: 10px;">立定跳远成绩:</view>
						<input maxlength="-1" v-model="jiankangdangan.lidingtiaoyuan" class="input" placeholder="请输入立定跳远成绩" />
						<view style="margin: 10px;">一百米 成绩:</view>
						<input maxlength="-1" v-model="jiankangdangan.yibaimi" class="input" placeholder="请输入一百米 成绩" />
			</view>


		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
				jiankangdangan:{}
			}
		},
		methods: {
			xyyiliaoyhUpdateJiankangdanganactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhUpdateJiankangdanganactJson",
					method: "POST",
					data: _this.jiankangdangan,
					success(res) {
						console.log(res)
						if (res.data.message == "修改健康档案成功") {
							uni.showToast({
								icon: "success",
								title: "修改健康档案成功",
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
				url: "xyyiliaoyhUpdateJiankangdanganJson?id=" + e.id,
				success: res => {
					console.log(res.data)
					_this.jiankangdangan = res.data.jiankangdangan
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