<template>
	<view class="container">
		<!-- Header Info -->
		<view class="student-header">
			<view class="avatar-wrap">
				<image class="avatar" v-if="userinfo" :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+userinfo.xyyiliaoyhimg"></image>
			</view>
			<view class="student-info">
				<view class="name">{{ userinfo ? userinfo.xyyiliaoyhname : '同学' }}</view>
				<view class="sno">学号：{{ userinfo ? userinfo.xuehao || '未填写' : '未填写' }}</view>
			</view>
			<view class="date-info" @click="goCalendar" style="display: flex; flex-direction: column; align-items: center; background: rgba(255,255,255,0.2); padding: 10rpx 20rpx; border-radius: 16rpx;">
				<uni-icons type="calendar" size="24" color="#fff"></uni-icons>
				<text style="font-size: 22rpx; color: #fff; margin-top: 4rpx;">体测日程</text>
			</view>
		</view>

		<!-- Tabs -->
		<view class="tabs">
			<view v-for="(grade, index) in availableGrades" :key="index" 
				class="tab" :class="{ active: currentTab === grade }"
				@click="switchTab(grade)">
				{{ grade }}
			</view>
		</view>

		<view v-if="currentRecord" class="metric-container">
			<!-- Total Score -->
			<view class="bento-box bg-red text-white score-card">
				<view class="s-header">
					<text class="s-title">年级得分</text>
					<text class="s-score">{{ currentRecord.zongfen || '0' }}分</text>
				</view>
				<view class="s-footer">
					<text class="s-status">状态:正常</text>
					<text class="s-level">{{ getLevel(currentRecord.zongfen) }}</text>
					<text class="s-ai" @click="askAI(currentRecord)">AI运动处方</text>
				</view>
			</view>

			<!-- Bento Grid -->
			<view class="bento-grid">
				<view class="bento-item bg-blue">
					<text class="m-title">身高/体重(厘米/千克)</text>
					<text class="m-val">{{ currentRecord.height || '-' }}/{{ currentRecord.weight || '-' }}</text>
					<view class="m-footer">
						<text class="m-score">{{ calcBmiScore(currentRecord.height, currentRecord.weight) }}分</text>
						<text class="m-tag tag-blue">正常</text>
					</view>
				</view>

				<view class="bento-item bg-teal">
					<text class="m-title">肺活量(毫升)</text>
					<text class="m-val">{{ currentRecord.feihuoliang || '-' }}</text>
					<view class="m-footer">
						<text class="m-score">{{ currentRecord.feihuoliang ? '78分' : '-' }}</text>
						<text class="m-tag tag-teal">及格</text>
					</view>
				</view>

				<view class="bento-item bg-orange">
					<text class="m-title">坐位体前屈(厘米)</text>
					<text class="m-val">{{ currentRecord.zuoweitiqianqu || '-' }}</text>
					<view class="m-footer">
						<text class="m-score">{{ currentRecord.zuoweitiqianqu ? '66分' : '-' }}</text>
						<text class="m-tag tag-orange">及格</text>
					</view>
				</view>

				<view class="bento-item bg-green">
					<text class="m-title">立定跳远(厘米)</text>
					<text class="m-val">{{ currentRecord.lidingtiaoyuan || '-' }}</text>
					<view class="m-footer">
						<text class="m-score">{{ currentRecord.lidingtiaoyuan ? '72分' : '-' }}</text>
						<text class="m-tag tag-green">及格</text>
					</view>
				</view>

				<view class="bento-item bg-pink">
					<text class="m-title">引体向上(个)</text>
					<text class="m-val">{{ currentRecord.yintixiangshang || '-' }}</text>
					<view class="m-footer">
						<text class="m-score">{{ currentRecord.yintixiangshang ? '0分' : '-' }}</text>
						<text class="m-tag tag-pink">不及格</text>
					</view>
				</view>

				<view class="bento-item bg-purple">
					<text class="m-title">50米跑(秒.毫秒)</text>
					<text class="m-val">{{ currentRecord.wushimi || '-' }}</text>
					<view class="m-footer">
						<text class="m-score">{{ currentRecord.wushimi ? '100分' : '-' }}</text>
						<text class="m-tag tag-purple">优秀</text>
					</view>
				</view>

				<view class="bento-item bg-rose">
					<text class="m-title">1000米跑(分.秒)</text>
					<text class="m-val">{{ currentRecord.yiqianmi || '-' }}</text>
					<view class="m-footer">
						<text class="m-score">{{ currentRecord.yiqianmi ? '85分' : '-' }}</text>
						<text class="m-tag tag-rose">良好</text>
					</view>
				</view>
			</view>
		</view>

		<view v-else class="empty-state">
			<text>该学年暂无体测数据</text>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				jiankangdangans: [],
				userinfo: null,
				currentTime: '',
				currentDate: '',
				currentTab: '一年级',
				availableGrades: ['一年级', '二年级', '三年级', '四年级']
			}
		},
		computed: {
			currentRecord() {
				return this.jiankangdangans.find(r => r.shijian === this.currentTab) || this.jiankangdangans[0] || null;
			}
		},
		methods: {
			askAI(record) {
				if (!record) return;
				const message = `你好，这是我的体测数据：身高${record.height}cm，体重${record.weight}kg，肺活量${record.feihuoliang}ml，50米${record.wushimi}s，1000米${record.yiqianmi}。请帮我生成一份AI运动处方和建议。`;
				uni.navigateTo({
					url: '/pages/aiduihua?initialMsg=' + encodeURIComponent(message)
				});
			},
			goCalendar() {
				uni.navigateTo({ url: '/pages/ticeCalendar' });
			},
			updateTime() {
				const now = new Date();
				this.currentTime = now.getHours() + ':' + (now.getMinutes() < 10 ? '0' : '') + now.getMinutes();
				this.currentDate = now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
			},
			switchTab(grade) {
				this.currentTab = grade;
			},
			getLevel(score) {
				if(!score) return '-';
				score = parseFloat(score);
				if(score >= 90) return '优秀';
				if(score >= 80) return '良好';
				if(score >= 60) return '及格';
				return '不及格';
			},
			calcBmiScore(h, w) {
				if(!h || !w) return '100';
				let meters = parseFloat(h) / 100;
				let bmi = parseFloat(w) / (meters * meters);
				if(bmi >= 18.5 && bmi <= 23.9) return '100';
				return '80';
			}
		},
		onLoad() {
			this.userinfo = uni.getStorageSync('userinfo');
			this.updateTime();
			setInterval(this.updateTime, 60000);

			let _this = this;
			uni.request({
				url: "xyyiliaoyhJiankangdanganListJson",
				success: res => {
					if(res.statusCode != 200) {
						uni.redirectTo({url: "/pages/login"});
						return;
					}
					_this.jiankangdangans = res.data.jiankangdangans || [];
					if(_this.jiankangdangans.length > 0) {
						// _this.currentTab = _this.jiankangdangans[0].shijian || '一年级'; // wait, keep default '一年级'
					}
				}
			})
		}
	}
</script>

<style scoped>
	.container {
		background-color: #f6f8fb;
		min-height: 100vh;
		box-sizing: border-box;
		overflow-x: hidden;
	}
	
	.student-header {
		display: flex;
		align-items: center;
		background: linear-gradient(120deg, #fcd34d, #f59e0b);
		padding: 30rpx 40rpx;
		color: #fff;
		border-radius: 0 0 32rpx 32rpx;
		margin-bottom: 20rpx;
	}
	
	.avatar-wrap {
		width: 100rpx;
		height: 100rpx;
		border-radius: 50%;
		background: rgba(255,255,255,0.3);
		padding: 4rpx;
		margin-right: 20rpx;
	}
	
	.avatar {
		width: 100%;
		height: 100%;
		border-radius: 50%;
	}
	
	.student-info {
		flex: 1;
	}
	
	.student-info .name {
		font-size: 32rpx;
		font-weight: bold;
		color: #1f2937;
	}
	
	.student-info .sno {
		font-size: 24rpx;
		color: #4b5563;
		margin-top: 6rpx;
	}
	
	.date-info {
		text-align: right;
		color: #b45309;
	}
	
	.date-info .time {
		font-size: 36rpx;
		font-weight: bold;
	}
	
	.date-info .date {
		font-size: 24rpx;
	}

	.tabs {
		display: flex;
		justify-content: space-around;
		background: #fff;
		padding: 20rpx 0;
		margin: 0 20rpx;
		border-radius: 16rpx;
		box-shadow: 0 4rpx 12rpx rgba(0,0,0,0.02);
	}

	.tab {
		font-size: 28rpx;
		color: #64748b;
		padding: 10rpx 0;
		position: relative;
	}

	.tab.active {
		color: #2563eb;
		font-weight: bold;
	}

	.tab.active::after {
		content: '';
		position: absolute;
		bottom: -4rpx;
		left: 50%;
		transform: translateX(-50%);
		width: 40rpx;
		height: 4rpx;
		background: #2563eb;
		border-radius: 2rpx;
	}

	.metric-container {
		padding: 20rpx;
	}

	.bento-box {
		border-radius: 24rpx;
		padding: 30rpx;
		margin-bottom: 20rpx;
		box-shadow: 0 4rpx 12rpx rgba(0,0,0,0.05);
	}

	.bg-red { background: linear-gradient(135deg, #e05e3f, #c0392b); }
	.bg-blue { background: linear-gradient(135deg, #4facfe, #00f2fe); }
	.bg-teal { background: #5dbfab; }
	.bg-orange { background: #e09f45; }
	.bg-green { background: #52a95c; }
	.bg-pink { background: #ce4a7e; }
	.bg-purple { background: #a652a6; }
	.bg-rose { background: #e66465; }

	.text-white { color: #fff; }

	.score-card .s-header {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin-bottom: 20rpx;
	}

	.score-card .s-title {
		font-size: 28rpx;
		opacity: 0.9;
	}

	.score-card .s-score {
		font-size: 48rpx;
		font-weight: bold;
	}

	.score-card .s-footer {
		display: flex;
		align-items: center;
		gap: 20rpx;
	}

	.score-card .s-status {
		font-size: 40rpx;
		font-weight: bold;
	}

	.score-card .s-level {
		font-size: 32rpx;
		font-weight: 500;
	}

	.score-card .s-ai {
		margin-left: auto;
		font-size: 26rpx;
		background: rgba(255,255,255,0.2);
		padding: 6rpx 20rpx;
		border-radius: 40rpx;
	}

	.bento-grid {
		display: grid;
		grid-template-columns: 1fr 1fr;
		gap: 20rpx;
	}

	.bento-item {
		border-radius: 20rpx;
		padding: 24rpx;
		color: #fff;
		display: flex;
		flex-direction: column;
		min-height: 180rpx;
	}

	.m-title {
		font-size: 24rpx;
		opacity: 0.9;
		margin-bottom: 12rpx;
	}

	.m-val {
		font-size: 36rpx;
		font-weight: bold;
		margin-bottom: auto;
	}

	.m-footer {
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin-top: 20rpx;
	}

	.m-score {
		font-size: 32rpx;
		font-weight: bold;
	}

	.m-tag {
		font-size: 22rpx;
		padding: 4rpx 16rpx;
		border-radius: 8rpx;
		background: transparent;
		border: 1px solid rgba(255,255,255,0.6);
	}

	.empty-state {
		text-align: center;
		color: #94a3b8;
		padding: 100rpx 0;
	}
</style>