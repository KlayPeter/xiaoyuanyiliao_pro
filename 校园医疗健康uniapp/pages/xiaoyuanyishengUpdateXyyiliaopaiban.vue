<template>

	<view>
		<form @submit="xiaoyuanyishengUpdateXyyiliaopaibanactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">排班月份:</view>
						<input maxlength="-1" v-model="xyyiliaopaiban.yuefen" class="input" placeholder="请输入排班月份" />
						<view style="margin: 10px;">备注:</view>
						<textarea class="input" v-model="xyyiliaopaiban.remark" style="width: auto;min-height: 100px;"
								  placeholder="请输入备注">
						</textarea>
						<view style="margin: 10px;">创建时间:</view>
						<input disabled="" class="input" v-model="xyyiliaopaiban.chuangjiantime" maxlength="-1" />
			</view>


			<button class="btn biaodanbtn" form-type="submit">修改</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
							xiaoyuanyishengs:[],
				xyyiliaopaiban:{}
			}
		},
		methods: {
			xiaoyuanyishengUpdateXyyiliaopaibanactJson(e) {
				let _this = this
				uni.request({
					url: "xiaoyuanyishengUpdateXyyiliaopaibanactJson",
					method: "POST",
					data: _this.xyyiliaopaiban,
					success(res) {
						console.log(res)
						if (res.data.message == "修改校园医疗排班成功") {
							uni.showToast({
								icon: "success",
								title: "修改校园医疗排班成功",
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
				url: "xiaoyuanyishengUpdateXyyiliaopaibanJson?id=" + e.id,
				success: res => {
					console.log(res.data)
					_this.xyyiliaopaiban = res.data.xyyiliaopaiban
							_this.xiaoyuanyishengs = res.data.usernames
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