<template>

	<view>
		<form @submit="xyyiliaoyhAddJiankangdanganactJson">
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
						<view style="margin: 10px;">校园医疗用户:</view>
						<input maxlength="-1" v-model="jiankangdangan.xyyiliaoyh" class="input" placeholder="请输入校园医疗用户" />
						<view style="margin: 10px;">校园医疗用户id:</view>
						<input maxlength="-1" v-model="jiankangdangan.xyyiliaoyhid" class="input" placeholder="请输入校园医疗用户id" />
			</view>

			<button class="btn biaodanbtn" form-type="submit">添加</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
				jiankangdangan: {
								shijian:"",
								height:"",
								weight:"",
								bmi:"",
								zuoyanshili:"",
								youyanshili:"",
								feihuoliang:"",
								lidingtiaoyuan:"",
								yibaimi:"",
								xyyiliaoyh:"",
								xyyiliaoyhid:null,
				}
			}
		},
		methods: {
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
			xyyiliaoyhAddJiankangdanganactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhAddJiankangdanganactJson",
					method: "POST",
					data: _this.jiankangdangan,
					success(res) {
						if (res.data.message == "添加体测档案成功") {
							uni.showToast({
								icon: "success",
								title: "添加体测档案成功",
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
				url:"xyyiliaoyhAddJiankangdanganJson",
				method:"POST",
				success(res) {
				}
			})
			var userinfo = uni.getStorageSync("userinfo")
			_this.jiankangdangan.xyyiliaoyhid =  userinfo.id
			_this.jiankangdangan.xyyiliaoyh = userinfo.username

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