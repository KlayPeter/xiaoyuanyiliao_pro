<script>
export default {
	onLaunch: function() {
		console.log('App Launch');
	},
	onShow: function() {
		console.log('App Show');
	},
	onHide: function() {
		console.log('App Hide');
	}
};
</script>

<style>
/* 解决头条小程序组件内引入字体不生效的问题 */
/* #ifdef MP-TOUTIAO */
@font-face {
	font-family: uniicons;
	src: url('/static/uni.ttf');
}
/* #endif */

/* ========== 全局设计体系 (校园医疗健康) ========== */
page {
	--color-primary: #0e7490;
	--color-primary-light: #cffafe;
	--color-accent: #0284c7;
	--color-bg: #f8fafc;
	--color-surface: #ffffff;
	--color-text: #0f172a;
	--color-text-secondary: #64748b;
	--color-border: #f1f5f9;
	--color-safe: #059669;
	--color-danger: #ef4444;
	--gradient-teal: linear-gradient(135deg, rgba(20, 184, 166, 0.9), rgba(14, 116, 144, 0.95));
	--gradient-blue: linear-gradient(135deg, #2563eb, #60a5fa);
	--gradient-emerald: linear-gradient(135deg, #059669, #34d399);
	--gradient-coral: linear-gradient(135deg, #e11d48, #fb7185);
	--gradient-amber: linear-gradient(135deg, #d97706, #fbbf24);
	--radius-sm: 12rpx;
	--radius-md: 24rpx;
	--radius-lg: 36rpx;
	--radius-full: 100rpx;
	--shadow-card: 0 8rpx 24rpx rgba(0,0,0,0.04);
	--shadow-float: 0 12rpx 40rpx rgba(0,0,0,0.08);
	font-family: -apple-system, 'PingFang SC', 'Helvetica Neue', sans-serif;
	background-color: var(--color-bg);
	color: var(--color-text);
}

/* 全局按钮重置 */
button {
	border-radius: var(--radius-full) !important;
	font-weight: 600 !important;
}

/* 全局列表卡片基础样式 */
.card-base {
	background: var(--color-surface);
	border-radius: var(--radius-md);
	box-shadow: var(--shadow-card);
	border: 1px solid var(--color-border);
	overflow: hidden;
}

/* uni-list 全局美化 */
.uni-list-item {
	border-radius: 16rpx !important;
}
</style>
