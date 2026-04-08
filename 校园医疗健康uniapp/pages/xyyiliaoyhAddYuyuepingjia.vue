<template>

	<view>
		<form @submit="xyyiliaoyhAddYuyuepingjiaactJson">
			<view class="form biaodan">
						<!-- <view style="margin: 10px;">医疗排班预约:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaopaibanyuyue" class="input" placeholder="请输入医疗排班预约" />
						<view style="margin: 10px;">医疗排班预约id:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaopaibanyuyueid" class="input" placeholder="请输入医疗排班预约id" />
						 --><view style="margin: 10px;">评价内容:</view>
						<textarea class="input" v-model="yuyuepingjia.pingcontent" style="width: auto;min-height: 100px;"
								  placeholder="请输入评价内容">
						</textarea>
							<view style="margin: 10px;">选择评价类型:</view>
							<picker :range="types" @change="changeType">
								<view class="input">{{yuyuepingjia.type || '请选择评价级别'}}</view>
							</picker>
                            <view style="margin: 10px;">给医生打分 (满分5分):</view>
							<picker :range="scores" @change="changeScore">
								<view class="input" style="color: #f5a623; font-weight:bold;">★ {{yuyuepingjia.pingjiafenshu || '请选择打分'}}</view>
							</picker>
						<!-- <view style="margin: 10px;">校园用户:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaoyh" class="input" placeholder="请输入校园用户" />
						<view style="margin: 10px;">校园用户id:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xyyiliaoyhid" class="input" placeholder="请输入校园用户id" />
						<view style="margin: 10px;">评价时间:</view>
						<input maxlength="-1" v-model="yuyuepingjia.pingjiashijian" class="input" placeholder="请输入评价时间" />
						<view style="margin: 10px;">校园医生:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xiaoyuanyisheng" class="input" placeholder="请输入校园医生" />
						<view style="margin: 10px;">校园医生id:</view>
						<input maxlength="-1" v-model="yuyuepingjia.xiaoyuanyishengid" class="input" placeholder="请输入校园医生id" /> -->
			</view>

			<button class="btn biaodanbtn" form-type="submit">添加</button>
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
                            scores:[
                                            "5",
                                            "4.5",
                                            "4",
                                            "3.5",
                                            "3",
                                            "2",
                                            "1"
                            ],
				yuyuepingjia: {
								xyyiliaopaibanyuyue:"",
								xyyiliaopaibanyuyueid:null,
								pingcontent:"",
								type:"好评",
                                pingjiafenshu: "5",
								xyyiliaoyh:"",
								xyyiliaoyhid:null,
								pingjiashijian:"",
								xiaoyuanyisheng:"",
								xiaoyuanyishengid:null,
				}
			}
		},
		methods: {
						changeType(event) {
							this.yuyuepingjia.type = this.types[event.detail.value]
						},
                        changeScore(event) {
                            this.yuyuepingjia.pingjiafenshu = this.scores[event.detail.value]
                        },
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
			xyyiliaoyhAddYuyuepingjiaactJson(e) {
				let _this = this
				uni.request({
					url: "xyyiliaoyhAddYuyuepingjiaactJson",
					method: "POST",
					data: _this.yuyuepingjia,
					success(res) {
						if (res.data.message == "添加预约评价成功") {
							uni.showToast({
								icon: "success",
								title: "添加预约评价成功",
								duration: 2000,
							})
							uni.navigateTo({
								url:"/pages/htMenu"
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
				url:"xyyiliaoyhAddYuyuepingjiaJson",
				method:"POST",
				success(res) {
				}
			})
			var userinfo = uni.getStorageSync("userinfo")
			_this.yuyuepingjia.xyyiliaoyhid =  userinfo.id
			_this.yuyuepingjia.xyyiliaoyh = userinfo.username
			
			let yuyuepaiban = uni.getStorageSync("yuyuepaiban")
			this.yuyuepingjia.xyyiliaopaibanyuyue = yuyuepaiban.jianyaowenti
			this.yuyuepingjia.xyyiliaopaibanyuyueid = yuyuepaiban.id
			this.yuyuepingjia.xiaoyuanyisheng = yuyuepaiban.xiaoyuanyisheng
			this.yuyuepingjia.xiaoyuanyishengid = yuyuepaiban.xiaoyuanyishengid
			
			this.yuyuepingjia.pingjiashijian = this.getNowTime()
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