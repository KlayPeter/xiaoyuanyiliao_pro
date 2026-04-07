<template>
  <view class="page" style="min-height: 100vh; background-color: #f2f3f5; padding-bottom: 120rpx;">
    
    <!-- 聊天信息区域 -->
    <view v-for="item in jilvs">
      <!-- 左侧消息 -->
      <view v-if="item.duihuauserrole =='校园医生'" style="display: flex; margin: 20rpx 30rpx; align-items: flex-start;">
        <image style="width: 72rpx; height: 72rpx; border-radius: 50%; box-shadow: 0 1rpx 4rpx rgba(0,0,0,0.1);" :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.duihuauserimg"></image>
        <view style="margin-left: 20rpx; display: flex; flex-direction: column; max-width: 65vw;">
          <view style="font-size: 20rpx; color: #888; margin-bottom: 6rpx;">{{item.duihuauser}}</view>
          <view style="background-color: #ffffff; padding: 20rpx 25rpx; border-radius: 18rpx; font-size: 28rpx; color: #333; box-shadow: 0 2rpx 5rpx rgba(0,0,0,0.05);">
            {{item.message}}
          </view>
        </view>
      </view>

      <!-- 右侧消息 -->
      <view v-if="item.duihuauserrole =='校园用户'" style="display: flex; margin: 20rpx 30rpx; align-items: flex-start; justify-content: flex-end;">
        <view style="display: flex; flex-direction: column; align-items: flex-end; max-width: 65vw; margin-right: 20rpx;">
          <view style="font-size: 20rpx; color: #888; margin-bottom: 6rpx;">{{item.duihuauser}}</view>
          <view style="background-color: #a7e0b2; padding: 20rpx 25rpx; border-radius: 18rpx; font-size: 28rpx; color: #222; box-shadow: 0 2rpx 5rpx rgba(0,0,0,0.05);">
            {{item.message}}
          </view>
        </view>
        <image style="width: 72rpx; height: 72rpx; border-radius: 50%; box-shadow: 0 1rpx 4rpx rgba(0,0,0,0.1);" :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.duihuauserimg"></image>
      </view>
    </view>

    <!-- 底部间隔 -->
    <view style="height: 120rpx;"></view>

    <!-- 固定底部输入框 -->
    <view style="position: fixed; bottom: 0; width: 100vw; height: 100rpx; display: flex; align-items: center; background-color: #fff; padding: 0 20rpx; box-shadow: 0 -2rpx 6rpx rgba(0,0,0,0.08);">
      <input v-model="message" placeholder="写消息…" 
        style="flex: 1; padding: 20rpx 30rpx; background-color: #f0f0f0; border-radius: 50rpx; font-size: 26rpx; color: #333; border: none;" />
      <view @click="fasong()" 
        style="margin-left: 20rpx; padding: 0 35rpx; height: 64rpx; line-height: 64rpx; background: linear-gradient(to right, #66bb6a, #a5d6a7); color: #fff; border-radius: 30rpx; font-size: 28rpx; box-shadow: 0 2rpx 4rpx rgba(0,0,0,0.1);">
        发送
      </view>
    </view>
  </view>
</template>

<script>
	export default {
		data() {
			return {
				jilvs:[],
				duihuaid: null,
				message: "",
                userinfo:null
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
			fasong() {
				let _this = this
				if (this.message == "") {
					return
				}
				let userinfo = uni.getStorageSync("userinfo")
				
				let yuyueduihua = {
					xyyiliaopaibanyuyue:"1",
					xyyiliaopaibanyuyueid:this.duihuaid,
					message:this.message,
					duihuauser:userinfo.username,
					duihuauserid:userinfo.id,
					duihuauserrole:"校园用户",
					duihuauserimg:userinfo.xyyiliaoyhimg,
					duihuauseraddtime:this.getNowTime()
				}
				
				uni.request({
					url:"addYuyueduihuaactJson",
					method:"POST",
					data:yuyueduihua
				})
				this.message = ''
			},
		},
		onLoad(e) {
			this.userinfo = uni.getStorageSync("userinfo")
			this.duihuaid = e.duihuaid
			let timmer = uni.getStorageSync("timmer")
			if (timmer != null && timmer != undefined && timmer != "") {
				clearInterval(timmer)
			}
			timmer = setInterval(() => {
				uni.request({
					url: "yuyueduihuaListJson",
					method: "POST",
					success: (res) => {
						this.jilvs = res.data.yuyueduihuas.filter(t=>{
							return t.xyyiliaopaibanyuyueid == e.duihuaid
						})
						console.log(res.data.yuyueduihuas)
					},
					fail(res) {}
				})
			}, 2000)
			uni.setStorageSync("timmer", timmer)

		},
		onHide() {
			clearInterval(uni.getStorageSync("timmer"))
		},
		onReachBottom() {
			uni.showToast({
				title: '到底了',
				icon: 'none',
				duration: 1000
			})
		},
	}
</script>

<style>
	.page {
		width: 100vw;
		background-color: #f8f8f8;
	}

	.message-item {
		display: flex;
		margin: 15rpx 20rpx;
		margin-bottom: 30rpx;
		align-items: center;
	}

	.message-item.left {
		justify-content: flex-start;
	}

	.message-item.right {
		justify-content: flex-end;
	}

	.avatar {
		width: 80rpx;
		height: 80rpx;
		border-radius: 50%;
		object-fit: cover;
		border: 2px solid #ddd;
	}

	.message-content {
		display: flex;
		flex-direction: column;
		justify-content: center;
		margin-left: 10rpx;
		margin-right: 10rpx;
	}

	.message-text {
		font-size: 16px;
		color: #333;
		background-color: #f1f1f1;
		padding: 10rpx;
		border-radius: 8px;
		max-width: 70vw;
		word-wrap: break-word;
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	}

	.input-area {
		position: fixed;
		bottom: 0;
		width: 100vw;
		height: 100rpx;
		background-color: #fff;
		display: flex;
		align-items: center;
		padding: 0 20rpx;
		box-shadow: 0 -2px 5px rgba(0, 0, 0, 0.1);
	}

	.input-box {
		width: 70vw;
		height: 50rpx;
		padding: 10rpx 20rpx;
		background-color: #f5f5f5;
		border-radius: 25rpx;
		font-size: 14px;
		color: #333;
		border: none;
	}

	.send-btn {
		width: 20vw;
		height: 50rpx;
		line-height: 50rpx;
		text-align: center;
		background-color: #aaff7f;
		border-radius: 25rpx;
		color: white;
		font-size: 16px;
		margin-left: 10rpx;
		cursor: pointer;
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	}

	.send-btn:hover {
		background-color: #99e56b;
	}

	.send-btn:active {
		background-color: #8bc758;
	}

	.spacer {
		height: 100rpx;
	}
</style>