<template>

	<view>
		<form @submit="xyyiliaoyhUpdateJiankangdanganactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">测试时间:</view>
						<input maxlength="-1" v-model="jiankangdangan.shijian" class="input" placeholder="请输入测试时间" />
						<view style="margin: 10px;">身高(cm):</view>
						<input maxlength="-1" v-model="jiankangdangan.height" class="input" placeholder="请输入身高(cm)" />
						<view style="margin: 10px;">体重(kg):</view>
						<input maxlength="-1" v-model="jiankangdangan.weight" class="input" placeholder="请输入体重(kg)" />
						<view style="margin: 10px;">bmi数值:</view>
						<input maxlength="-1" v-model="jiankangdangan.bmi" class="input" placeholder="请输入bmi数值" />
						<view style="margin: 10px;">50m成绩(s):</view>
						<input maxlength="-1" v-model="jiankangdangan.wushimichengji" class="input" placeholder="请输入50m成绩(s)" />
						<view style="margin: 10px;">800m成绩(s):</view>
						<input maxlength="-1" v-model="jiankangdangan.babaimichengji" class="input" placeholder="请输入800m成绩(s)" />
						<view style="margin: 10px;">肺活量(ml):</view>
						<input maxlength="-1" v-model="jiankangdangan.feihuoliang" class="input" placeholder="请输入肺活量(ml)" />
						<view style="margin: 10px;">立定跳远成绩(m)成绩:</view>
						<input maxlength="-1" v-model="jiankangdangan.lidingtiaoyuan" class="input" placeholder="请输入立定跳远成绩(m)成绩" />
						<view style="margin: 10px;">一百米 成绩:</view>
						<input maxlength="-1" v-model="jiankangdangan.yangwoqizuo" class="input" placeholder="请输入一百米 成绩" />
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
						if (res.data.message == "修改体测档案成功") {
							uni.showToast({
								icon: "success",
								title: "修改体测档案成功",
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