<template>
	<view class="pretty-toast" :class="{'show': visible}">
		<view class="toast-content" :class="type">
			<text class="icon" v-if="type === 'success'">✓</text>
			<text class="icon" v-else-if="type === 'error'">✕</text>
			<text class="icon" v-else-if="type === 'warning'">!</text>
			<text class="message">{{ message }}</text>
		</view>
	</view>
</template>

<script>
	export default {
		name: "pretty-toast",
		data() {
			return {
				visible: false,
				message: '',
				type: 'info', // 'success', 'error', 'warning', 'info'
				timer: null
			};
		},
		methods: {
			show(options) {
				const { message = '', type = 'info', duration = 2000 } = options;
				this.message = message;
				this.type = type;
				this.visible = true;

				if (this.timer) {
					clearTimeout(this.timer);
				}

				this.timer = setTimeout(() => {
					this.visible = false;
				}, duration);
			}
		}
	}
</script>

<style scoped>
	.pretty-toast {
		position: fixed;
		top: 100rpx;
		left: 0;
		right: 0;
		display: flex;
		justify-content: center;
		pointer-events: none;
		z-index: 9999;
		opacity: 0;
		transform: translateY(-40rpx);
		transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
	}

	.pretty-toast.show {
		opacity: 1;
		transform: translateY(0);
	}

	.toast-content {
		display: flex;
		align-items: center;
		background: rgba(255, 255, 255, 0.9);
		backdrop-filter: blur(20px);
		-webkit-backdrop-filter: blur(20px);
		padding: 24rpx 40rpx;
		border-radius: 100rpx;
		box-shadow: 0 12rpx 32rpx rgba(0, 0, 0, 0.08);
		border: 1px solid rgba(255, 255, 255, 0.5);
	}

	.icon {
		display: flex;
		align-items: center;
		justify-content: center;
		width: 40rpx;
		height: 40rpx;
		border-radius: 50%;
		color: #fff;
		font-size: 24rpx;
		font-weight: bold;
		margin-right: 16rpx;
	}

	.success .icon { background: linear-gradient(135deg, #059669, #34d399); }
	.error .icon { background: linear-gradient(135deg, #e11d48, #fb7185); }
	.warning .icon { background: linear-gradient(135deg, #d97706, #fbbf24); }
	.info .icon { display: none; }

	.message {
		font-size: 28rpx;
		color: #0f172a;
		font-weight: 600;
	}
</style>
