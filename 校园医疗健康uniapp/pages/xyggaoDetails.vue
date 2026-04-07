<template>
    <view class="container">
        <view class="banner">
            <image class="banner-img" :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+xyggao.xyimg" mode="aspectFill"></image>
            <view class="banner-title"></view>
        </view>
        <view class="article-meta">
            <view class="article-author">{{xyggao.xytitle}}</view>
            <view class="article-text">{{xyggao.xycontent}}</view>
            <text class="article-time">{{xyggao.xyaddtime}}</text>
        </view>
    </view>
</template>

<script>
    export default {
       	data() {
			return {
				xyggao: {}
			}
		},
		methods: {

		},
		onLoad(e) {

			let _this = this;
			uni.request({
				url: "xyggaoDetailsJson?id=" + e.id,
				success(res) {
					_this.xyggao = res.data.xyggao;
				}
			})
		}
    }
</script>

<style>
    .container {
        padding: 0 20rpx;
        background-color: #f4f4f4;
		min-height: 100vh;
    }

    .banner {
        height: 380rpx;
        overflow: hidden;
        position: relative;
        border-radius: 20rpx;
        margin-bottom: 20rpx;
    }

    .banner-img {
        width: 100%;
        height: 100%;
        border-radius: 20rpx;
    }

    .banner-title {
        position: absolute;
        bottom: 20rpx;
        left: 20rpx;
        color: white;
        font-size: 30rpx;
        font-weight: bold;
        line-height: 40rpx;
        width: 80%;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.6);
        z-index: 11;
    }

    .article-meta {
        background-color: white;
        border-radius: 10rpx;
        padding: 20rpx;
        box-shadow: 0 5rpx 15rpx rgba(0, 0, 0, 0.1);
        margin-bottom: 20rpx;
    }

    .article-author {
        font-size: 28rpx;
        font-weight: 600;
        color: #333;
    }

    .article-text {
        font-size: 26rpx;
        color: #666;
        margin-top: 25rpx;
        line-height: 1.5;
		min-height: 30vh;
    }

    .article-time {
        font-size: 24rpx;
        color: #999;
        margin-top: 10rpx;
        text-align: right;
    }
</style>