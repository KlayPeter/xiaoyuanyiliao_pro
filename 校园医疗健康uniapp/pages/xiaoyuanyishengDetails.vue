<template>
  <view class="container">
	  <view class="hero-header">
		  <!-- 商品图片轮播 (加入容错处理与高品质占位图) -->
		  <swiper class="swiper" indicator-dots autoplay circular indicator-active-color="#2563eb">
		    <swiper-item>
		      <image 
				:src="xiaoyuanyisheng.schoolysavaator ? 'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+xiaoyuanyisheng.schoolysavaator : (xiaoyuanyisheng.schoolyssex == '女' ? '../static/medical_doctor_female.png' : '../static/medical_doctor.png')" 
				mode="aspectFill" 
				class="swiper-img" 
				@error="handleImageError"
			  ></image>
		    </swiper-item>
		  </swiper>
		  
		  <!-- 浮动信息卡片 -->
		  <view class="info-card glass-card">
		    <view class="doc-header">
				<text class="name">{{ xiaoyuanyisheng.schoolyishengname || '医生资料卡' }}</text>
				<text class="tag">🌟 专家医师</text>
			</view>
			
			<view class="doc-stats">
				<view class="stat-item">
					<text class="s-val">{{ xiaoyuanyisheng.schoolyssex || '-' }}</text>
					<text class="s-label">性别</text>
				</view>
				<view class="stat-divider"></view>
				<view class="stat-item">
					<text class="s-val">{{ xiaoyuanyisheng.schoolysage || '-' }}</text>
					<text class="s-label">年龄</text>
				</view>
				<view class="stat-divider"></view>
				<view class="stat-item">
					<text class="s-val" style="color:#059669">可预约</text>
					<text class="s-label">状态</text>
				</view>
			</view>
			
			<view class="contact-box">
				<view class="iconPhone">📞</view>
				<text>特设专线：{{ xiaoyuanyisheng.schoolysphone || '保密' }}</text>
			</view>
		  </view>
	  </view>

    <!-- 商品详情 -->
    <view class="description glass-card">
      <view class="sec-title">
		  <text class="decor"></text>
		  <text>医生简介及专长</text>
	  </view>
      <view class="content" v-html="xiaoyuanyisheng.schoolysjianjie || '<div style=\'text-align:center;padding:100rpx 0;color:#94a3b8\'><p style=\'font-size:32rpx;margin-bottom:20rpx\'>⚕️</p><p>医师暂未上传详细履历</p></div>'"></view>
    </view>

    <!-- 底部购买按钮 -->
    <view class="bottom-bar">
      <button @click="yuyue" class="buy-btn">立即预约该专家</button>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      yuyuepingjiaArr: [],
      xiaoyuanyisheng: {}, // 套餐详情
    };
  },
  methods: {
	  handleImageError() {
		  this.xiaoyuanyisheng.schoolysavaator = ''; // Clear broken URL to trigger fallback medical_doctor.png
	  },
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
              _this.xiaoyuanyisheng = res.data.xiaoyuanyisheng

            uni.request({
                url: "yuyuepingjiaListJson",
                success: (res) => {
                    this.yuyuepingjiaArr = res.data.yuyuepingjias.filter(t => t.xiaoyuanyishengid == this.xiaoyuanyisheng.id);
                }
            })
;
          }
      })
  },
};
</script>

<style scoped>
.container {
  background: #f8fafc url('/static/real_medical_bg.png') center/cover fixed no-repeat;
  min-height: 100vh;
  padding-bottom: 200rpx;
}

.hero-header {
	position: relative;
}

.swiper {
  width: 100%;
  height: 600rpx;
}
.swiper-img {
  width: 100%;
  height: 100%;
}

.glass-card {
	background: rgba(255, 255, 255, 0.95);
	backdrop-filter: blur(20px);
	border-radius: 32rpx;
	box-shadow: 0 8rpx 32rpx rgba(0, 0, 0, 0.05);
	border: 2rpx solid #ffffff;
}

.info-card {
	margin: -100rpx 32rpx 0;
	position: relative;
	z-index: 10;
	padding: 40rpx;
}

.doc-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 40rpx;
}
.name {
	font-size: 48rpx;
	font-weight: 800;
	color: #0f172a;
}
.tag {
	background: rgba(37, 99, 235, 0.1);
	color: #2563eb;
	padding: 10rpx 24rpx;
	border-radius: 100rpx;
	font-size: 26rpx;
	font-weight: 700;
}

.doc-stats {
	display: flex;
	align-items: center;
	justify-content: space-around;
	background: rgba(248, 250, 252, 0.6);
	border-radius: 20rpx;
	padding: 24rpx 0;
	margin-bottom: 32rpx;
}
.stat-item {
	display: flex;
	flex-direction: column;
	align-items: center;
}
.s-val { font-size: 36rpx; font-weight: 800; color: #0f172a; margin-bottom: 8rpx; }
.s-label { font-size: 24rpx; color: #64748b; }
.stat-divider { width: 2rpx; height: 60rpx; background: #e2e8f0; }

.contact-box {
	display: flex;
	align-items: center;
	background: rgba(16, 185, 129, 0.08);
	color: #059669;
	padding: 24rpx 32rpx;
	border-radius: 100rpx;
	font-size: 28rpx;
	font-weight: 600;
}
.iconPhone { margin-right: 16rpx; font-size: 32rpx; }

.description {
	margin: 32rpx;
	padding: 40rpx;
	min-height: 400rpx;
}
.sec-title {
	display: flex;
	align-items: center;
	font-size: 32rpx;
	font-weight: 700;
	color: #0f172a;
	margin-bottom: 32rpx;
}
.decor {
	width: 8rpx;
	height: 32rpx;
	background: #2563eb;
	border-radius: 8rpx;
	margin-right: 16rpx;
}

.content {
	color: #475569;
	font-size: 30rpx;
	line-height: 1.8;
}

.bottom-bar {
	position: fixed;
	bottom: 0;
	left: 0;
	right: 0;
	padding: 24rpx 40rpx 60rpx;
	background: rgba(255, 255, 255, 0.95);
	backdrop-filter: blur(20px);
	box-shadow: 0 -10rpx 30rpx rgba(0,0,0,0.06);
	z-index: 99;
}
.buy-btn {
	background: linear-gradient(135deg, #3b82f6, #2563eb);
	color: white;
	font-size: 32rpx;
	font-weight: 700;
	height: 90rpx;
	line-height: 90rpx;
	border-radius: 100rpx;
	box-shadow: 0 8rpx 20rpx rgba(37, 99, 235, 0.3);
}
</style>
