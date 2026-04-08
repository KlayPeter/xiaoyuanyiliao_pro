<template>
    <view class="container">
        <view class="banner" v-if="xyggao.xyimg">
            <image 
                class="banner-img" 
                :src="xyggao.xyimg && xyggao.xyimg.startsWith('http') ? xyggao.xyimg : 'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/' + xyggao.xyimg" 
                mode="aspectFill"
            ></image>
            <view class="banner-overlay">
                <view class="banner-tag">📢 校园公告</view>
            </view>
        </view>
        <!-- 无图时显示渐变头部 -->
        <view class="banner-fallback" v-else>
            <view class="banner-tag">📢 校园公告</view>
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

    .banner-overlay {
        position: absolute;
        bottom: 0;
        left: 0;
        right: 0;
        padding: 20rpx 28rpx;
        background: linear-gradient(to top, rgba(0,0,0,0.5), transparent);
        border-radius: 0 0 20rpx 20rpx;
    }

    .banner-tag {
        display: inline-block;
        background: rgba(255,255,255,0.2);
        border: 2rpx solid rgba(255,255,255,0.6);
        color: #fff;
        font-size: 24rpx;
        font-weight: 700;
        padding: 8rpx 20rpx;
        border-radius: 100rpx;
        backdrop-filter: blur(8px);
    }

    /* 无图时的渐变头部 */
    .banner-fallback {
        height: 200rpx;
        border-radius: 20rpx;
        margin-bottom: 20rpx;
        background: linear-gradient(135deg, #1e40af, #0891b2);
        display: flex;
        align-items: flex-end;
        padding: 24rpx 28rpx;
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
        color: #0f172a;
    }

    .article-text {
        font-size: 28rpx;
        color: #475569;
        margin-top: 25rpx;
        line-height: 1.8;
		min-height: 30vh;
        white-space: pre-wrap;
    }

    .article-time {
        font-size: 24rpx;
        color: #94a3b8;
        margin-top: 20rpx;
        text-align: right;
        display: block;
    }
</style>