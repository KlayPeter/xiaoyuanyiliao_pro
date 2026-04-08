<template>
	<view class="calendar-container">
		<view class="page-header" :style="{ paddingTop: statusBarHeight + 'px' }">
			<view class="nav-bar">
				<view class="back-btn" @click="goBack">
					<uni-icons type="arrowleft" size="24" color="#fff"></uni-icons>
					<text class="back-text">返回</text>
				</view>
				<text class="title">体测日程表</text>
			</view>
			<text class="subtitle">各学院测试与补测时间安排</text>
		</view>

		<view class="calendar-card">
			<uni-calendar 
				:insert="true" 
				:lunar="false" 
				:selected="selectedDates"
				@change="onDateChange"
			/>
		</view>

		<view class="schedule-list">
			<view class="list-title">当日安排</view>
			<view v-if="currentEvents.length > 0">
				<view v-for="(event, index) in currentEvents" :key="index" class="event-card">
					<view class="event-time">
						<text class="dot" :class="event.type === '补测' ? 'dot-red' : 'dot-blue'"></text>
						<text>{{ event.time }}</text>
					</view>
					<view class="event-body">
						<view class="event-title">{{ event.title }}</view>
						<view class="event-desc">{{ event.desc }}</view>
						<view class="event-tag" :class="event.type === '补测' ? 'tag-red' : 'tag-blue'">{{ event.type }}</view>
					</view>
				</view>
			</view>
			<view v-else class="empty-event">
				<text>今日无体测安排 ~</text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				// Mock data for scheduling
				allEvents: [
					{ date: '2026-04-10', time: '08:00 - 12:00', title: '信息工程学院', desc: '地点：田径场 | 要求：携带一卡通', type: '正常测试' },
					{ date: '2026-04-12', time: '14:00 - 17:00', title: '机械工程学院', desc: '地点：田径场 | 要求：携带一卡通', type: '正常测试' },
					{ date: '2026-04-18', time: '09:00 - 11:30', title: '全校补测专场', desc: '地点：田径场 | 注意：限因病请假或成绩不合格者', type: '补测' },
					{ date: '2026-04-20', time: '08:30 - 12:00', title: '经济管理学院', desc: '地点：风雨操场', type: '正常测试' }
				],
				selectedDates: [],
				currentEvents: [],
				statusBarHeight: 20
			}
		},
		onLoad() {
			// Populate uni-calendar selected
			this.selectedDates = this.allEvents.map(e => {
				return {
					date: e.date,
					info: e.type,
					color: e.type === '补测' ? '#e11d48' : '#2563eb'
				}
			});
			// Default today events
			this.updateCurrentEvents(this.formatDate(new Date()));
			const sysInfo = uni.getSystemInfoSync();
			this.statusBarHeight = sysInfo.statusBarHeight || 20;
		},
		methods: {
			goBack() {
				uni.navigateBack();
			},
			formatDate(date) {
				const y = date.getFullYear();
				const m = (date.getMonth()+1).toString().padStart(2, '0');
				const d = date.getDate().toString().padStart(2, '0');
				return `${y}-${m}-${d}`;
			},
			onDateChange(e) {
				this.updateCurrentEvents(e.fulldate);
			},
			updateCurrentEvents(dateStr) {
				this.currentEvents = this.allEvents.filter(e => e.date === dateStr);
			}
		}
	}
</script>

<style scoped>
	.calendar-container {
		background: #f8fafc;
		min-height: 100vh;
		padding-bottom: 40rpx;
		box-sizing: border-box;
		overflow-x: hidden;
	}
	.page-header {
		background: linear-gradient(135deg, #1e3a8a, #2563eb);
		padding: 0 30rpx 60rpx;
		color: #fff;
	}
	.nav-bar {
		display: flex;
		align-items: center;
		height: 88rpx;
		position: relative;
	}
	.back-btn {
		position: absolute;
		left: -20rpx;
		top: 0;
		bottom: 0;
		display: flex;
		align-items: center;
		padding: 0 20rpx;
		z-index: 10;
	}
	.back-text {
		color: #fff;
		font-size: 32rpx;
		margin-left: 4rpx;
	}
	.title {
		font-size: 36rpx;
		font-weight: bold;
		flex: 1;
		text-align: center;
	}
	.subtitle {
		font-size: 26rpx;
		opacity: 0.8;
		display: block;
		margin-top: 20rpx;
	}
	.calendar-card {
		margin: -40rpx 30rpx 30rpx;
		border-radius: 20rpx;
		overflow: hidden;
		box-shadow: 0 10rpx 30rpx rgba(0,0,0,0.1);
	}
	.schedule-list {
		padding: 0 30rpx;
	}
	.list-title {
		font-size: 32rpx;
		font-weight: bold;
		color: #334155;
		margin-bottom: 20rpx;
		padding-left: 10rpx;
		border-left: 8rpx solid #2563eb;
	}
	.event-card {
		background: #fff;
		border-radius: 16rpx;
		padding: 30rpx;
		margin-bottom: 20rpx;
		box-shadow: 0 4rpx 12rpx rgba(0,0,0,0.03);
	}
	.event-time {
		font-size: 28rpx;
		color: #64748b;
		margin-bottom: 16rpx;
		display: flex;
		align-items: center;
	}
	.dot {
		width: 16rpx;
		height: 16rpx;
		border-radius: 50%;
		display: inline-block;
		margin-right: 12rpx;
	}
	.dot-blue { background: #2563eb; }
	.dot-red { background: #e11d48; }
	
	.event-body {
		position: relative;
	}
	.event-title {
		font-size: 32rpx;
		font-weight: bold;
		color: #0f172a;
		margin-bottom: 8rpx;
	}
	.event-desc {
		font-size: 26rpx;
		color: #475569;
	}
	.event-tag {
		position: absolute;
		right: 0;
		top: 50%;
		transform: translateY(-50%);
		font-size: 22rpx;
		padding: 6rpx 16rpx;
		border-radius: 30rpx;
	}
	.tag-blue { background: #eff6ff; color: #2563eb; border: 1px solid #bfdbfe; }
	.tag-red { background: #fff1f2; color: #e11d48; border: 1px solid #fecdd3; }
	
	.empty-event {
		text-align: center;
		padding: 60rpx 0;
		color: #94a3b8;
		font-size: 28rpx;
	}
</style>
