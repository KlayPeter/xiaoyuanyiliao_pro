<template>
	<view class="ai-chat-page">
		<view class="ai-chat-header">
			<text class="ai-chat-title">AI 医生问诊</text>
			<text class="ai-chat-subtitle">说明：本功能为智能问诊建议，不能替代线下就医。</text>
		</view>

		<scroll-view scroll-y class="ai-chat-window" :scroll-into-view="scrollIntoViewId">
			<view v-for="(item, index) in messages" :key="index" :id="'msg-' + index"
				:class="['ai-msg-item', item.role === 'user' ? 'ai-msg-right' : 'ai-msg-left']">
				<view class="ai-avatar" v-if="item.role === 'assistant'">
					<text class="ai-avatar-text">医</text>
				</view>
				<view class="ai-avatar" v-else>
					<text class="ai-avatar-text user">我</text>
				</view>
				<view class="ai-msg-bubble">
					<rich-text :nodes="item.htmlContent || formatMarkdown(item.content)"></rich-text>
				</view>
			</view>

			<view v-if="!messages.length" class="ai-empty-tip">
				<text>请描述你的症状，例如：“头痛两天伴随发热，需要挂什么科？”</text>
			</view>
		</scroll-view>

		<view class="ai-input-bar">
			<textarea v-model="inputMessage" class="ai-input" placeholder="请详细描述你的症状、持续时间、伴随症状等"
				auto-height :maxlength="-1" :disabled="loading" />
			<button class="ai-send-btn" :loading="loading" :disabled="loading || !inputMessage.trim()"
				@click="sendMessage">发送</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				inputMessage: '',
				loading: false,
				messages: [],
				scrollIntoViewId: ''
			}
		},
		onLoad(options) {
			if (options.initialMsg) {
				this.inputMessage = decodeURIComponent(options.initialMsg);
				// give vue slightly time to render before auto sending
				setTimeout(() => {
					this.sendMessage();
				}, 300);
			}
		},
		methods: {
			formatMarkdown(md) {
				if (!md) return '';

				// 先简单转义，再做一些常用的 markdown 转 html
				let text = md.replace(/&/g, '&amp;')
					.replace(/</g, '&lt;')
					.replace(/>/g, '&gt;');

				// 加粗 **text**
				text = text.replace(/\*\*(.+?)\*\*/g, '<strong>$1</strong>');
				// 斜体 *text*
				text = text.replace(/(?:^|[\s])\*(.+?)\*(?:[\s]|$)/g, (m, p1) => ' <em>' + p1 + '</em> ');

				const lines = text.split('\n');
				let html = '';
				let inList = false;

				lines.forEach(line => {
					if (/^\s*[-*]\s+/.test(line)) {
						// 无序列表
						if (!inList) {
							html += '<ul>';
							inList = true;
						}
						html += '<li>' + line.replace(/^\s*[-*]\s+/, '') + '</li>';
					} else {
						if (inList) {
							html += '</ul>';
							inList = false;
						}
						if (line.trim() !== '') {
							html += '<p>' + line + '</p>';
						}
					}
				});

				if (inList) {
					html += '</ul>';
				}

				return html;
			},
			scrollToBottom() {
				const lastIndex = this.messages.length - 1;
				if (lastIndex >= 0) {
					this.scrollIntoViewId = 'msg-' + lastIndex;
				}
			},
			sendMessage() {
				if (!this.inputMessage.trim() || this.loading) {
					return;
				}

				const content = this.inputMessage.trim();
				this.inputMessage = '';

				// 先把用户消息加入本地对话
				this.messages.push({
					role: 'user',
					content: content,
					htmlContent: this.formatMarkdown(content)
				});
				this.$nextTick(() => {
					this.scrollToBottom();
				});

				this.loading = true;
				const _this = this;

				uni.request({
					url: 'chat?message='+content,
					method: 'POST',
					success(res) {
						const aiText = typeof res.data === 'string' ? res.data : (res.data.content || JSON.stringify(res.data));
						_this.messages.push({
							role: 'assistant',
							content: aiText,
							htmlContent: _this.formatMarkdown(aiText)
						});
						_this.$nextTick(() => {
							_this.scrollToBottom();
						});
					},
					fail() {
						_this.messages.push({
							role: 'assistant',
							content: '抱歉，AI 医生暂时无法回答，请稍后重试或联系人工医生。',
							htmlContent: _this.formatMarkdown('抱歉，AI 医生暂时无法回答，请稍后重试或联系人工医生。')
						});
					},
					complete() {
						_this.loading = false;
					}
				});
			}
		}
	}
</script>

<style>
	page {
		height: 100%;
		background-color: #f8fafc;
	}

	.ai-chat-page {
		position: absolute;
		top: 0; bottom: 0; left: 0; right: 0;
		display: flex;
		flex-direction: column;
	}

	.ai-chat-header {
		padding: 16px 20px;
		background-color: #ffffff;
		border-bottom: 1px solid #e2e8f0;
		z-index: 10;
		flex-shrink: 0;
	}

	.ai-chat-title {
		font-size: 18px;
		font-weight: bold;
		color: #0f172a;
	}

	.ai-chat-subtitle {
		display: block;
		margin-top: 4px;
		font-size: 12px;
		color: #94a3b8;
	}

	.ai-chat-window {
		flex: 1;
		height: 0;
		padding: 30rpx 20rpx;
		box-sizing: border-box;
	}

	.ai-msg-item {
		display: flex;
		margin-bottom: 40rpx;
		width: 100%;
	}

	.ai-msg-left {
		flex-direction: row;
		justify-content: flex-start;
	}

	.ai-msg-right {
		flex-direction: row-reverse;
		justify-content: flex-start;
	}

	.ai-avatar {
		width: 80rpx;
		height: 80rpx;
		border-radius: 50%;
		background: #0284c7;
		display: flex;
		align-items: center;
		justify-content: center;
		margin: 0 20rpx;
		flex-shrink: 0;
	}

	.ai-avatar-text {
		color: #ffffff;
		font-size: 32rpx;
		font-weight: bold;
	}

	.ai-avatar-text.user {
		color: #ffffff;
	}

	.ai-msg-bubble {
		max-width: 65%;
		padding: 24rpx 32rpx;
		border-radius: 24rpx;
		font-size: 30rpx;
		line-height: 1.6;
		word-break: break-all;
	}

	.ai-msg-left .ai-msg-bubble {
		background-color: #ffffff;
		color: #333333;
		border-top-left-radius: 4rpx;
		box-shadow: 0 4rpx 16rpx rgba(0,0,0,0.04);
	}

	.ai-msg-right .ai-msg-bubble {
		background: linear-gradient(135deg, #0e7490, #0284c7);
		color: #ffffff;
		border-top-right-radius: 4rpx;
		box-shadow: 0 4rpx 16rpx rgba(14, 165, 233, 0.2);
	}

	.ai-empty-tip {
		padding: 40rpx 20rpx;
		text-align: center;
		color: #94a3b8;
		font-size: 26rpx;
	}

	.ai-input-bar {
		display: flex;
		align-items: flex-end;
		padding: 20rpx 20rpx calc(20rpx + env(safe-area-inset-bottom)) 20rpx;
		background-color: #f1f5f9;
		border-top: 1px solid #e2e8f0;
		width: 100%;
		box-sizing: border-box;
		flex-shrink: 0;
	}

	.ai-input {
		flex: 1;
		min-height: 76rpx;
		max-height: 200rpx;
		background-color: #ffffff;
		border-radius: 38rpx;
		padding: 18rpx 32rpx;
		font-size: 30rpx;
		box-sizing: border-box;
		border: 1px solid #e2e8f0;
	}

	.ai-send-btn {
		margin-left: 20rpx;
		width: 140rpx;
		height: 76rpx;
		line-height: 76rpx;
		background: linear-gradient(135deg, #0e7490, #0284c7);
		color: #ffffff;
		border-radius: 38rpx;
		font-size: 28rpx;
		padding: 0;
		flex-shrink: 0;
		box-shadow: 0 4rpx 12rpx rgba(14, 165, 233, 0.2);
	}
	
	.ai-send-btn[disabled] {
		background: #cbd5e1;
		box-shadow: none;
	}
</style>
