<template>

	<view>
		<form @submit="xyyiliaoyhAddGuahaozixunjieguoactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">开方时间:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.kaifangtime" class="input" placeholder="请输入开方时间" />
						<view style="margin: 10px;">用户症状描述:</view>
						<textarea class="input" v-model="guahaozixunjieguo.zhusu" style="width: auto;min-height: 100px;"
								  placeholder="请输入用户症状描述">
						</textarea>
						<view style="margin: 10px;">用户体温:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.yonghutiwen" class="input" placeholder="请输入用户体温" />
						<view style="margin: 10px;">心率:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.xinlv" class="input" placeholder="请输入心率" />
						<view style="margin: 10px;">诊断结果:</view>
						<textarea class="input" v-model="guahaozixunjieguo.zhenduan" style="width: auto;min-height: 100px;"
								  placeholder="请输入诊断结果">
						</textarea>
						<view style="margin: 10px;">休息建议:</view>
						<textarea class="input" v-model="guahaozixunjieguo.xiuxijiany" style="width: auto;min-height: 100px;"
								  placeholder="请输入休息建议">
						</textarea>
						<view style="margin: 10px;">用药:</view>
						<textarea class="input" v-model="guahaozixunjieguo.yongyao" style="width: auto;min-height: 100px;"
								  placeholder="请输入用药">
						</textarea>
						<view style="margin: 10px;">校园医生:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.xiaoyuanyisheng" class="input" placeholder="请输入校园医生" />
						<view style="margin: 10px;">校园医生id:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.xiaoyuanyishengid" class="input" placeholder="请输入校园医生id" />
						<view style="margin: 10px;">校园医疗用户:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.xyyiliaoyh" class="input" placeholder="请输入校园医疗用户" />
						<view style="margin: 10px;">校园医疗用户id:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.xyyiliaoyhid" class="input" placeholder="请输入校园医疗用户id" />
						<view style="margin: 10px;">排班预约:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.xyyiliaopaibanyuyue" class="input" placeholder="请输入排班预约" />
						<view style="margin: 10px;">排班预约id:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.xyyiliaopaibanyuyueid" class="input" placeholder="请输入排班预约id" />
						<view style="margin: 10px;">药品价格:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.price" class="input" placeholder="请输入药品价格" />
						<view style="margin: 10px;">状态:</view>
						<input maxlength="-1" v-model="guahaozixunjieguo.state" class="input" placeholder="请输入状态" />
			</view>

			<button class="btn biaodanbtn" form-type="submit">添加</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
				guahaozixunjieguo: {
								kaifangtime:"",
								zhusu:"",
								yonghutiwen:"",
								xinlv:"",
								zhenduan:"",
								xiuxijiany:"",
								yongyao:"",
								xiaoyuanyisheng:"",
								xiaoyuanyishengid:null,
								xyyiliaoyh:"",
								xyyiliaoyhid:null,
								xyyiliaopaibanyuyue:"",
								xyyiliaopaibanyuyueid:null,
								price:"",
								state:"",
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
			xyyiliaoyhAddGuahaozixunjieguoactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhAddGuahaozixunjieguoactJson",
					method: "POST",
					data: _this.guahaozixunjieguo,
					success(res) {
						if (res.data.message == "添加挂号咨询结果成功") {
							uni.showToast({
								icon: "success",
								title: "添加挂号咨询结果成功",
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
				url:"xyyiliaoyhAddGuahaozixunjieguoJson",
				method:"POST",
				success(res) {
				}
			})
			var userinfo = uni.getStorageSync("userinfo")
			_this.guahaozixunjieguo.xyyiliaoyhid =  userinfo.id
			_this.guahaozixunjieguo.xyyiliaoyh = userinfo.username

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