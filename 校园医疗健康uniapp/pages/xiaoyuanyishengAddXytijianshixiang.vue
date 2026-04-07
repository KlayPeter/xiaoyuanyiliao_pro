<template>

	<view>
		<form @submit="xiaoyuanyishengAddXytijianshixiangactJson">
			<view class="form biaodan">
						<view style="margin: 10px;">体检标题:</view>
						<input maxlength="-1" v-model="xytijianshixiang.tijiant" class="input" placeholder="请输入体检标题" />
						<view style="margin: 10px;">体检内容:</view>
						<textarea class="input" v-model="xytijianshixiang.tijiancontent" style="width: auto;min-height: 100px;"
								  placeholder="请输入体检内容">
						</textarea>
						<view style="margin: 10px;">体检注意事项:</view>
						<textarea class="input" v-model="xytijianshixiang.tijianzhuyi" style="width: auto;min-height: 100px;"
								  placeholder="请输入体检注意事项">
						</textarea>
						<view style="margin: 10px;">体检位置:</view>
						<textarea class="input" v-model="xytijianshixiang.tijianadress" style="width: auto;min-height: 100px;"
								  placeholder="请输入体检位置">
						</textarea>
						<view style="margin: 10px;">选择体检时间:</view>
						<picker mode="date" @change="changeTijiantime">
							<view class="input">{{xytijianshixiang.tijiantime}}</view>
						</picker>
						<view style="margin: 10px;">选择封面:</view>
						<view @click="changeTijianimgFile">
							<view>
								<image class="input" :src="'http://localhost:8080/xiaoyuanyiliaojiankang/static/upload/'+xytijianshixiang.tijianimg"></image>
							</view>
						</view>
						<view style="margin: 10px;">负责医生:</view>
						<input maxlength="-1" v-model="xytijianshixiang.xiaoyuanyisheng" class="input" placeholder="请输入负责医生" />
			</view>

			<button class="btn biaodanbtn" form-type="submit">添加</button>
		</form>


	</view>

</template>

<script>
	export default {
		data() {
			return {
				xytijianshixiang: {
								tijiant:"",
								tijiancontent:"",
								tijianzhuyi:"",
								tijianadress:"",
								tijiantime:"",
								tijianimg:"",
								xiaoyuanyisheng:"",
								xiaoyuanyishengid:null,
				}
			}
		},
		methods: {
					changeTijiantime(event) {
						this.xytijianshixiang.tijiantime = event.detail.value
					},
					changeTijianimgFile() {
						let _this = this;
						uni.chooseImage({
							count: 1,
							success(res) {
								uni.uploadFile({
									url: "uploadFile",
									filePath: res.tempFilePaths[0],
									name: "file",
									success(res) {
										_this.xytijianshixiang.tijianimg = JSON.parse(res.data).fileUrl
									}
								})
							}
						})
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
			xiaoyuanyishengAddXytijianshixiangactJson(e) {
				let _this = this
				uni.request({
					url: "xiaoyuanyishengAddXytijianshixiangactJson",
					method: "POST",
					data: _this.xytijianshixiang,
					success(res) {
						if (res.data.message == "添加校园体检事项成功") {
							uni.showToast({
								icon: "success",
								title: "添加校园体检事项成功",
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
				url:"xiaoyuanyishengAddXytijianshixiangJson",
				method:"POST",
				success(res) {
				}
			})
			var userinfo = uni.getStorageSync("userinfo")
			_this.xytijianshixiang.xiaoyuanyishengid =  userinfo.id
			_this.xytijianshixiang.xiaoyuanyisheng = userinfo.username

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
</style>