import Vue from 'vue'
import App from './App'

uni.addInterceptor("request", {
	invoke(args) {
		args.url = "http://localhost:8080/xiaoyuanyiliaojiankang/" + args.url
		//如果平台是web 就得设置withCredentials = true
		//如果平台不是web，就从缓存里面拿到cookie并设置
		console.log(uni.getSystemInfoSync().uniPlatform)
		let platForm = uni.getSystemInfoSync().uniPlatform
		if (platForm == "web" || platForm == "h5") {
			args.withCredentials = true			
		} else {
			var cookie = uni.getStorageSync("cookie")
			if(cookie){
				console.log("获取cookie",cookie)
				args.header = {
					"cookie": cookie
				}
			}
		}
	},
	success(res) {
		// 响应包含cookies就缓存
		console.log(res.cookies)
		if(res.cookies != undefined && res.cookies.length > 0){
			uni.setStorage({
				key:"cookie",
				data: res.cookies[0]
			})
		}
	
	}
	
})
uni.addInterceptor("uploadFile", {
	invoke(args) {
		args.url = "http://localhost:8080/xiaoyuanyiliaojiankang/" + args.url
		//如果平台是web 就得设置withCredentials = true
		//如果平台不是web，就从缓存里面拿到cookie并设置
		console.log(uni.getSystemInfoSync().uniPlatform)
		let platForm = uni.getSystemInfoSync().uniPlatform
		if (platForm == "web" || platForm == "h5") {
			args.withCredentials = true
		} else {
			var cookie = uni.getStorageSync("cookie")
			if(cookie){
				console.log("获取cookie",cookie)
				args.header = {
					"cookie": cookie
				}
			}
		}
	},
	success(res) {
		// 响应包含cookies就缓存
		console.log(res.cookies)
		if(res.cookies != undefined && res.cookies.length > 0){
			uni.setStorage({
				key:"cookie",
				data: res.cookies[0]
			})
		}
	
	}
	
})
uni.addInterceptor("downloadFile", {
	invoke(args) {
		args.url = "http://localhost:8080/xiaoyuanyiliaojiankang/" + args.url
		//如果平台是web 就得设置withCredentials = true
		//如果平台不是web，就从缓存里面拿到cookie并设置
		console.log(uni.getSystemInfoSync().uniPlatform)
		let platForm = uni.getSystemInfoSync().uniPlatform
		if (platForm == "web" || platForm == "h5") {
			args.withCredentials = true
		} else {
			var cookie = uni.getStorageSync("cookie")
			if(cookie){
				console.log("获取cookie",cookie)
				args.header = {
					"cookie": cookie
				}
			}
		}
	},
	success(res) {
		// 响应包含cookies就缓存
		console.log(res.cookies)
		if(res.cookies != undefined && res.cookies.length > 0){
			uni.setStorage({
				key:"cookie",
				data: res.cookies[0]
			})
		}
	
	}
	
})

Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
	...App
})
app.$mount()