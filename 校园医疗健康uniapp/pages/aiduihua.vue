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
	.ai-chat-page {
		display: flex;
		flex-direction: column;
		height: 100vh;
		background-color: #f5f5f5;
	}

	.ai-chat-header {
		padding: 12px 16px;
		background-color: #ffffff;
		border-bottom: 1px solid #e6e6e6;
	}

	.ai-chat-title {
		font-size: 18px;
		font-weight: 600;
		color: #333;
	}

	.ai-chat-subtitle {
		display: block;
		margin-top: 4px;
		font-size: 12px;
		color: #999;
	}

	.ai-chat-window {
		flex: 1;
		padding: 10px 10px 0 10px;
		box-sizing: border-box;
	}

	.ai-msg-item {
		display: flex;
		margin-bottom: 10px;
	}

	.ai-msg-left {
		flex-direction: row;
	}

	.ai-msg-right {
		flex-direction: row-reverse;
	}

	.ai-avatar {
		width: 32px;
		height: 32px;
		border-radius: 16px;
		background-color: #55aa7f;
		align-items: center;
		justify-content: center;
		display: flex;
		margin: 0 6px;
	}

	.ai-avatar-text {
		color: #ffffff;
		font-size: 16px;
	}

	.ai-avatar-text.user {
		background-color: transparent;
	}

	.ai-msg-bubble {
		max-width: 70%;
		padding: 8px 10px;
		border-radius: 6px;
		background-color: #ffffff;
		font-size: 14px;
		color: #333;
		line-height: 1.5;
	}

	.ai-msg-right .ai-msg-bubble {
		background-color: #55aa7f;
		color: #ffffff;
	}

	.ai-empty-tip {
		padding: 20px 10px;
		text-align: center;
		color: #999;
		font-size: 13px;
	}

	.ai-input-bar {
		display: flex;
		align-items: flex-end;
		padding: 8px 10px;
		box-sizing: border-box;
		background-color: #ffffff;
		border-top: 1px solid #e6e6e6;
	}

	.ai-input {
		flex: 1;
		min-height: 36px;
		max-height: 90px;
		border: 1px solid #d6d6d6;
		border-radius: 4px;
		padding: 6px 8px;
		font-size: 14px;
		background-color: #fafafa;
	}

	.ai-send-btn {
		margin-left: 8px;
		background-color: #55aa7f;
		color: #ffffff;
		font-size: 14px;
		padding: 0 16px;
		height: 36px;
		line-height: 36px;
		border-radius: 4px;
	}
</style>
