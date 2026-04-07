<template>

	<view>
		<form @submit="xyyiliaoyhUpdateYuyuepingjiaactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">医疗排班预约:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaopaibanyuyue" class="input" placeholder="请输入医疗排班预约" />
						<view style="margin: 10px;">医疗排班预约id:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaopaibanyuyueid" class="input" placeholder="请输入医疗排班预约id" />
						<view style="margin: 10px;">评价内容:</view>
						<textarea class="input" v-model="yuyuepingjia.pingcontent" style="width: auto;min-height: 100px;"
								  placeholder="请输入评价内容">
						</textarea>
							<view style="margin: 10px;">选择评价类型:</view>
							<picker :range="types" @change="changeType">
								<view class="input">{{yuyuepingjia.type}}</view>
							</picker>
						<view style="margin: 10px;">校园用户:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaoyh" class="input" placeholder="请输入校园用户" />
						<view style="margin: 10px;">校园用户id:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaoyhid" class="input" placeholder="请输入校园用户id" />
						<view style="margin: 10px;">评价时间:</view>
						<input maxlength="-1" v-model="yuyuepingjia.pingjiashijian" class="input" placeholder="请输入评价时间" />
						<view style="margin: 10px;">校园医生:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xiaoyuanyisheng" class="input" placeholder="请输入校园医生" />
						<view style="margin: 10px;">校园医生id:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xiaoyuanyishengid" class="input" placeholder="请输入校园医生id" />
			</view>


			<button class="btn biaodanbtn" form-type="submit">修改</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
							types:[
										"好评",
										"中评",
										"差评"
							],
				yuyuepingjia:{}
			}
		},
		methods: {
							changeType(event) {
								this.yuyuepingjia.type = this.types[event.detail.value]
							},
			xyyiliaoyhUpdateYuyuepingjiaactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhUpdateYuyuepingjiaactJson",
					method: "POST",
					data: _this.yuyuepingjia,
					success(res) {
						console.log(res)
						if (res.data.message == "修改预约评价成功") {
							uni.showToast({
								icon: "success",
								title: "修改预约评价成功",
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
				url: "xyyiliaoyhUpdateYuyuepingjiaJson?id=" + e.id,
				success: res => {
					console.log(res.data)
					_this.yuyuepingjia = res.data.yuyuepingjia
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