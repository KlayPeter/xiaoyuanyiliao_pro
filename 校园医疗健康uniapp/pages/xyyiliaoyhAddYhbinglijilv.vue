<template>

	<view>
		<form @submit="xyyiliaoyhAddYhbinglijilvactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">记录时间:</view>
						<input maxlength="-1" v-model="yhbinglijilv.jilvtime" class="input" placeholder="请输入记录时间" />
						<view style="margin: 10px;">用户症状描述:</view>
						<textarea class="input" v-model="yhbinglijilv.zhusu" style="width: auto;min-height: 100px;"
								  placeholder="请输入用户症状描述">
						</textarea>
						<view style="margin: 10px;">用户体温:</view>
						<input maxlength="-1" v-model="yhbinglijilv.yonghutiwen" class="input" placeholder="请输入用户体温" />
						<view style="margin: 10px;">心率:</view>
						<input maxlength="-1" v-model="yhbinglijilv.xinlv" class="input" placeholder="请输入心率" />
						<view style="margin: 10px;">诊断:</view>
						<textarea class="input" v-model="yhbinglijilv.zhenduan" style="width: auto;min-height: 100px;"
								  placeholder="请输入诊断">
						</textarea>
						<view style="margin: 10px;">休息建议:</view>
						<textarea class="input" v-model="yhbinglijilv.xiuxijiany" style="width: auto;min-height: 100px;"
								  placeholder="请输入休息建议">
						</textarea>
						<view style="margin: 10px;">用药:</view>
						<textarea class="input" v-model="yhbinglijilv.yongyao" style="width: auto;min-height: 100px;"
								  placeholder="请输入用药">
						</textarea>
						<view style="margin: 10px;">校园医生:</view>
						<input maxlength="-1" v-model="yhbinglijilv.xiaoyuanyisheng" class="input" placeholder="请输入校园医生" />
						<view style="margin: 10px;">校园医生id:</view>
						<input maxlength="-1" v-model="yhbinglijilv.xiaoyuanyishengid" class="input" placeholder="请输入校园医生id" />
						<view style="margin: 10px;">校园用户:</view>
						<input maxlength="-1" v-model="yhbinglijilv.xyyiliaoyh" class="input" placeholder="请输入校园用户" />
						<view style="margin: 10px;">校园用户id:</view>
						<input maxlength="-1" v-model="yhbinglijilv.xyyiliaoyhid" class="input" placeholder="请输入校园用户id" />
			</view>

			<button class="btn biaodanbtn" form-type="submit">添加</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
				yhbinglijilv: {
								jilvtime:"",
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
			xyyiliaoyhAddYhbinglijilvactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhAddYhbinglijilvactJson",
					method: "POST",
					data: _this.yhbinglijilv,
					success(res) {
						if (res.data.message == "添加用户病例记录成功") {
							uni.showToast({
								icon: "success",
								title: "添加用户病例记录成功",
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
				url:"xyyiliaoyhAddYhbinglijilvJson",
				method:"POST",
				success(res) {
				}
			})
			var userinfo = uni.getStorageSync("userinfo")
			_this.yhbinglijilv.xyyiliaoyhid =  userinfo.id
			_this.yhbinglijilv.xyyiliaoyh = userinfo.username

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