<template>
	<view>
		<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000" class="lunbo">
			<swiper-item>
				<view class="swiper-item">
					<image src="../static/医疗.jpg" style="width: 100%;"></image>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="swiper-item">
					<image src="../static/医疗2.jpg" style="width: 100%;"></image>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="swiper-item">
					<image src="../static/医疗3.jpg" style="width: 100%;"></image>
				</view>
			</swiper-item>
		</swiper>

		<view>
			<view class="fenlei">
				<view class="fenlei-item active">校园体检事项最新推荐</view>
			</view>
			<view class="liebiao">
				<view class="liebiao-item" v-for="item in xytijianshixiangs" @click="xytijianshixiangDetails(item.id)"
					:key="item.id">
					<view class="liebiao-item-com1">
						<image :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.tijianimg"
							class="img"></image>
					</view>
					<view class="liebiao-item-com2">
						<view class="title">{{item.tijiant}}</view>
						<view class="xiaowenzi">时间:<view class="pingfen">{{item.tijiantime}}</view>
						</view>
						<view class="xiaowenzi">位置：{{item.tijianadress}}</view>
					</view>
					<view class="liebiao-item-com3">
						<view class="btn">详细</view>
					</view>
				</view>
			</view>
		</view>
		<view>
			<view class="fenlei">
				<view class="fenlei-item active">校园公告最新推荐</view>
			</view>
			<view class="liebiao">
				<view class="liebiao-item" v-for="item in xyggaos" @click="xyggaoDetails(item.id)" :key="item.id">
					<view class="liebiao-item-com1">
						<image :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.xyimg"
							class="img"></image>
					</view>
					<view class="liebiao-item-com2">
						<view class="title">{{item.xytitle}}</view>
						<view class="xiaowenzi">发布时间:<view class="pingfen">{{item.xyaddtime}}</view>
						</view>
						<view class="xiaowenzi">内容：{{item.xycontent}}</view>
					</view>
					<view class="liebiao-item-com3">
						<view class="btn">详细</view>
					</view>
				</view>
			</view>
		</view>






	</view>
</template>

<script>
	export default {
		data() {
			return {
				xiaoyuanyishengs: [],
				xytijianshixiangs: [],
				xyggaos: [],

			}
		},
		methods: {
			xiaoyuanyishengDetails(id) {
				uni.navigateTo({
					url: "/pages/xiaoyuanyishengDetails?id=" + id
				})
			},
			xytijianshixiangDetails(id) {
				uni.navigateTo({
					url: "/pages/xytijianshixiangDetails?id=" + id
				})
			},
			xyggaoDetails(id) {
				uni.navigateTo({
					url: "/pages/xyggaoDetails?id=" + id
				})
			},
		},
		onReady() {
			let _this = this;
			uni.request({
				url: "indexJson",
				success: res => {
					console.log(res.data)
					_this.xiaoyuanyishengs = res.data.xiaoyuanyishengs;
					_this.xytijianshixiangs = res.data.xytijianshixiangs;
					_this.xyggaos = res.data.xyggaos;
				}
			})
		}
	}
</script>

<style>
	#top {
		background-color: #55aa7f;
		color: white;
		height: 50px;
		text-align: center;
		line-height: 50px;
		font-size: 18px;
		font-family: 'Times New Roman', Times, serif;
	}

	.tuijian {
		padding: 10px;
	}

	.show-item {
		width: 85px;
		display: inline-block;
		margin-right: 15px;
	}

	.show-item .pic {
		width: 85px;
		height: 115px;
	}

	.show-item .wenzi {
		margin: 0;
		font-size: 13px;
		color: #222;
		margin-bottom: 3px;
		text-align: center;
		text-overflow: ellipsis;
		overflow: hidden;
		white-space: nowrap;
		font-weight: bold;
	}

	.title {
		margin: 0;
		font-size: 14px;
		color: #333;
		margin-bottom: 12px;
	}

	.fenlei {
		border-bottom: 1px solid #e6e6e6;
		border-top: 1px solid #e6e6e6;
		height: 45px;
		line-height: 45px;
		padding: 0 10px;
	}

	.fenlei-item.active {
		color: #000000;
		border-bottom: 3px solid red;
	}

	.fenlei-item {
		padding: 0 10px;
		font-weight: bold;
		color: #666;
		display: inline-block;
	}

	.leftscore {
		background-color: #007AFF;
	}

	.scroll-view_H {
		white-space: nowrap;
		width: 100%;
		display: none;
	}

	.scroll-view_H.active {
		display: block;
	}

	.liebiao .liebiao-item {
		border-bottom: 1px solid #e6e6e6;
		padding: 10px;
		height: 100px;
	}

	.liebiao .liebiao-item .liebiao-item-com1 {
		float: left;
		width: 20%;
	}

	.liebiao .liebiao-item .liebiao-item-com2 {
		float: left;
		width: 45%;
		margin-left: 5%;
	}

	.liebiao .liebiao-item .liebiao-item-com4 {
		float: left;
		width: 65%;
		margin-left: 5%;
	}

	.liebiao .xiaowenzi {
		font-size: 13px;
		color: #666;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}

	.liebiao .liebiao-item .liebiao-item-com3 {
		float: left;
		width: 25%;
		margin-left: 5%;
		display: flex;
		align-items: center;
		justify-content: center;
		height: 100px;
	}

	.liebiao .btn {
		width: 47px;
		height: 27px;
		line-height: 28px;
		text-align: center;
		box-sizing: border-box;
		background-color: #55aa7f;
		color: #fff;
		border-radius: 4px;
		white-space: nowrap;
		font-size: 12px;
		cursor: pointer;
	}

	.liebiao .liebiao-item .liebiao-item-com1 .img {
		width: 100%;
		height: 100px;
	}

	.liebiao .liebiao-item .title {
		font-size: 17px;
		color: #333;
		font-weight: 700;
		padding-right: 5px;
		flex-shrink: 1;
	}

	.liebiao .pingfen {
		font-weight: 700;
		color: #faaf00;
		font-size: 15px;
		display: inline-block;
	}
</style>