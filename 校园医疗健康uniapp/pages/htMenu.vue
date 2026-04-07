<template>
	<view>
		<view style="height: 25vh;background-color: #55aa7f;display: flex;align-items: center;">
			<view style="display: flex;flex-direction: row;padding-left: 8vw;align-items: center;">
				<image v-if="userinfo != undefined"
					:src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+userinfo.xyyiliaoyhimg"
					style="height:100rpx;width: 100rpx;margin: 20rpx;border-radius: 50%;object-fit: contain;border: #FFFFFF 2px solid;box-shadow: 2px;">
				</image>
				<view style="display: flex;flex-direction: column;color: white;">
					<view style="font-size: 30rpx;margin-bottom: 5rpx;word-spacing: 10rpx;">{{userinfo.xyyiliaoyhname}}
					</view>
					<view style="font-size: 25rpx;">{{userinfo.xyyiliaoyhphone}}</view>
				</view>
			</view>
		</view>

		<view class="" style="margin-top: 5px;background-color: #FFFFFF;padding: 10px;color: RGB(97,97,97);">


			<uni-list v-if="role == '校园用户'">
				<uni-list-item title="个人中心" @click="urlto('xyyiliaoyhIndex')" thumb="/static/应用管理.png"></uni-list-item>
				<!-- <uni-list-item title="添加校园医疗排班预约" @click="urlto('xyyiliaoyhAddXyyiliaopaibanyuyue')"
											   thumb="/static/add.png"></uni-list-item> -->
				<uni-list-item title="我的校园医疗排班预约" @click="urlto('xyyiliaoyhXyyiliaopaibanyuyueList')"
					thumb="/static/应用管理.png"></uni-list-item>
				<!-- <uni-list-item title="添加挂号咨询结果" @click="urlto('xyyiliaoyhAddGuahaozixunjieguo')"
											   thumb="/static/add.png"></uni-list-item> -->
				<uni-list-item title="我的挂号咨询结果" @click="urlto('xyyiliaoyhGuahaozixunjieguoList')"
					thumb="/static/应用管理.png"></uni-list-item>
				<!-- 	<uni-list-item title="添加用户病例记录" @click="urlto('xyyiliaoyhAddYhbinglijilv')"
											   thumb="/static/add.png"></uni-list-item> -->
				<uni-list-item title="我的用户病例记录" @click="urlto('xyyiliaoyhYhbinglijilvList')"
					thumb="/static/应用管理.png"></uni-list-item>
				<!-- <uni-list-item title="添加预约评价" @click="urlto('xyyiliaoyhAddYuyuepingjia')"
											   thumb="/static/add.png"></uni-list-item> -->
				<uni-list-item title="我的预约评价" @click="urlto('xyyiliaoyhYuyuepingjiaList')"
					thumb="/static/应用管理.png"></uni-list-item>
				<!-- <uni-list-item title="添加体检用户预约" @click="urlto('xyyiliaoyhAddTijianyhyuyue')"
											   thumb="/static/add.png"></uni-list-item> -->
				<uni-list-item title="我的体检用户预约" @click="urlto('xyyiliaoyhTijianyhyuyueList')"
					thumb="/static/应用管理.png"></uni-list-item>
				<!-- <uni-list-item title="添加健康档案" @click="urlto('xyyiliaoyhAddJiankangdangan')"
											   thumb="/static/add.png"></uni-list-item> -->
				<uni-list-item title="我的健康档案" @click="urlto('xyyiliaoyhJiankangdanganList')"
					thumb="/static/应用管理.png"></uni-list-item>
				<uni-list-item title="AI对话" @click="urlto('aiduihua')"
					thumb="/static/应用管理.png"></uni-list-item>
				<uni-list-item title="退出系统" @click="logout"></uni-list-item>
			</uni-list>

		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				role: '',
				userinfo: null
			}
		},
		methods: {
			urlto(url) {
				uni.navigateTo({
					url: url
				})
			},
			logout() {
				uni.clearStorage();
				uni.request({
					url: "logoutJson",
				})
				uni.navigateTo({
					url: '/pages/login'
				})
			},
		},
		onLoad(e) {

		},
		onShow() {
			let _this = this;
			this.userinfo = uni.getStorageSync("userinfo")
			uni.getStorage({
				key: 'role',
				success(res) {
					_this.role = res.data;
				},
				fail(res) {
					uni.redirectTo({
						url: "/pages/login"
					})
				}
			})
		}
	}
</script>

<style>
	page {
		background-color: RGB(231, 231, 233);
	}

	.an {
		text-align: center;
		padding: 5px;
	}
</style>