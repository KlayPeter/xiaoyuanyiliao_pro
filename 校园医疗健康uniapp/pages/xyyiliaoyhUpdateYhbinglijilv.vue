<template>

	<view>
		<form @submit="xyyiliaoyhUpdateYhbinglijilvactJson">
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


			<button class="btn biaodanbtn" form-type="submit">修改</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
				yhbinglijilv:{}
			}
		},
		methods: {
			xyyiliaoyhUpdateYhbinglijilvactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhUpdateYhbinglijilvactJson",
					method: "POST",
					data: _this.yhbinglijilv,
					success(res) {
						console.log(res)
						if (res.data.message == "修改用户病例记录成功") {
							uni.showToast({
								icon: "success",
								title: "修改用户病例记录成功",
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
				url: "xyyiliaoyhUpdateYhbinglijilvJson?id=" + e.id,
				success: res => {
					console.log(res.data)
					_this.yhbinglijilv = res.data.yhbinglijilv
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