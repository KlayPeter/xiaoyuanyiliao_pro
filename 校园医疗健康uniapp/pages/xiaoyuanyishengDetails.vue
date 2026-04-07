<template>
  <view class="container">

    <!-- 商品图片轮播 -->
    <swiper  class="swiper" indicator-dots autoplay circular>
      <swiper-item  >
        <image :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+xiaoyuanyisheng.schoolysavaator" mode="aspectFill" class="swiper-img"></image>
      </swiper-item>
    </swiper>

    <!-- 商品信息 -->
    <view class="info">
      <view class="name">{{ xiaoyuanyisheng.schoolyishengname }}</view>
      <view class="price">联系电话：{{ xiaoyuanyisheng.schoolysphone }}</view>
      <view class="xiaoyuanyishengtype">性别：{{ xiaoyuanyisheng.schoolyssex }}</view>
	<view class="xiaoyuanyishengtype">年龄：{{ xiaoyuanyisheng.schoolysage }}</view>
	</view>

    <!-- 商品详情 -->
    <view class="description">
      <view class="title">简介</view>
      <view class="content" v-html="xiaoyuanyisheng.schoolysjianjie"></view>
    </view>

    <!-- 底部购买按钮 -->
    <view class="bottom-bar">
      <button @click="yuyue" class="buy-btn" size="mini">预约</button>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      xiaoyuanyisheng: {}, // 套餐详情
    };
  },
  methods: {
      yuyue(){
		  let userinfo = uni.getStorageSync("userinfo")
		  if(userinfo==null || userinfo == undefined || userinfo == ""){
			  uni.showToast({
					icon:"error",
					title:"请先登录"
			  })
			  return
		  }
		  uni.setStorageSync("xiaoyuanyisheng",this.xiaoyuanyisheng)
		  
		 uni.navigateTo({
		 	url:"/pages/xyyiliaoyhAddXyyiliaopaibanyuyue"
		 })
		 
	  }
  },
  onLoad(e) {
  
      let _this = this;
      uni.request({
          url: "xiaoyuanyishengDetailsJson?id=" + e.id,
          success(res) {
              _this.xiaoyuanyisheng = res.data.xiaoyuanyisheng;
          }
      })
  },
};
</script>

<style scoped>
.container {
  background: #f8f8f8;
  min-height: 100vh;
}
.nav {
  display: flex;
  align-items: center;
  padding: 20rpx;
  background: #fff;
  font-size: 30rpx;
  border-bottom: 1px solid #eee;
}
.back {
  flex: 1;
  color: #007aff;
}
.title {
  flex: 2;
  text-align: center;
  font-weight: bold;
}
.swiper {
  width: 100%;
  height: 400rpx;
}
.swiper-img {
  width: 100%;
  height: 100%;
}
.info {
  padding: 20rpx;
  background: #fff;
}
.name {
  font-size: 36rpx;
  font-weight: bold;
}
.price {
  color: red;
  font-size: 30rpx;
  margin-top: 10rpx;
}
.xiaoyuanyishengtype {
  color: #666;
  font-size: 24rpx;
  margin-top: 10rpx;
}
.description, .notice {
  background: #fff;
  padding: 20rpx;
  margin-top: 10rpx;
}
.title {
  font-size: 28rpx;
  font-weight: bold;
}
.content {
  color: #666;
  font-size: 24rpx;
  margin-top: 10rpx;
}
.bottom-bar {
  position: fixed;
  bottom: 0;
  width: 100%;
  padding: 5rpx;
  background: #fff;
  text-align: center;
}
.buy-btn {
  width: 80%;
  background: #007aff;
  color: white;
  font-size: 20rpx;
  padding: 16rpx;
  border-radius: 50rpx;
}
</style>
