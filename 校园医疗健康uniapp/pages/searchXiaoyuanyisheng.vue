<template>
	<view class="container">

	<!-- 	<uni-search-bar @confirm="searchXiaoyuanyisheng" @cancel="cancelSearch()" :focus="true" v-model="search"
			placeholder="请输入搜索内容(按下回车键搜索)"></uni-search-bar> -->

		<view class="month-filter" v-if="months.length">
			<picker disabled="" mode="selector" :range="months" >
				<view class="month-filter-inner">
					当前排班月份：{{ selectedMonth || '全部' }}
				</view>
			</picker>
		</view>

		<view class="liebiao">
			<view class="liebiao-item" v-for="item in xiaoyuanyishengs" :key="item.id"
				@click="xiaoyuanyishengDetails(item.id)">
				<view class="liebiao-item-com1">
					<image :src="'http://127.0.0.1:8080/xiaoyuanyiliaojiankang/static/upload/'+item.schoolysavaator" class="img"></image>
				</view>
				<view class="liebiao-item-com2">
					<view class="title">{{ item.schoolyishengname }}</view>
					<view class="xiaowenzi">联系电话:<view class="pingfen">{{ item.schoolysphone }}</view>
					</view>
					<view class="xiaowenzi">性别：{{item.schoolyssex}}</view>
				</view>
				<view class="liebiao-item-com3">
					<view class="btn">详细</view>
				</view>
			</view>

		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				// 当前页面展示的医生列表（经过月份和搜索筛选）
				xiaoyuanyishengs: [],
				// 原始全部医生数据
				allXiaoyuanyishengs: [],
				// 排班数据
				xyyiliaopaibans: [],
				// 搜索关键字
				search: "",
				// 可选的排班月份列表
				months: [],
				// 当前选中的月份
				selectedMonth: ''
			}
		},
		methods: {
			xiaoyuanyishengDetails(id) {
				uni.setStorageSync("paibanyue",this.selectedMonth)
				uni.navigateTo({
					url: "xiaoyuanyishengDetails?id=" + id
				})
			},
			searchXiaoyuanyisheng() {
				// 前端根据搜索关键字和当前月份进行筛选
				this.applyFilter()
			},
			cancelSearch(){
				this.search =  ""
				this.applyFilter()
			},
			onMonthChange(e) {
				const index = e.detail.value
				this.selectedMonth = this.months[index] || ''
				this.applyFilter()
			},
			getCurrentMonthString() {
				const date = new Date()
				const y = date.getFullYear()
				const m = date.getMonth() + 1
				const mm = m < 10 ? ('0' + m) : m
				return y + '-' + mm
			},
			initDataFromResponse(data) {
				// 保存原始数据
				this.allXiaoyuanyishengs = data.xiaoyuanyishengs || []
				this.xyyiliaopaibans = data.xyyiliaopaibans || []

				// 生成月份列表
				const set = new Set()
				this.xyyiliaopaibans.forEach(pb => {
					if (pb.yuefen) {
						set.add(pb.yuefen)
					}
				})
				this.months = Array.from(set)

				// 默认选中当前月份（如果在排班中存在），否则选中第一个
				if (!this.selectedMonth) {
					const cur = this.getCurrentMonthString()
					if (this.months.includes(cur)) {
						this.selectedMonth = cur
					} else {
						this.selectedMonth = this.months[0] || ''
					}
				}

				this.applyFilter()
			},
			applyFilter() {
				let list = this.allXiaoyuanyishengs.slice()

				// 按月份过滤排班医生
				if (this.selectedMonth) {
					const ids = new Set()
					this.xyyiliaopaibans.forEach(pb => {
						if (pb.yuefen === this.selectedMonth && pb.xiaoyuanyishengid != null) {
							ids.add(pb.xiaoyuanyishengid)
						}
					})
					list = list.filter(doc => ids.has(doc.id))
				}

				// 关键字搜索（姓名 / 电话 / 简介）
				if (this.search && this.search.trim() !== '') {
					const kw = this.search.trim().toLowerCase()
					list = list.filter(doc => {
						const name = (doc.schoolyishengname || '').toLowerCase()
						const phone = (doc.schoolysphone || '').toLowerCase()
						const jianjie = (doc.schoolysjianjie || '').toLowerCase()
						return name.indexOf(kw) !== -1 ||
							phone.indexOf(kw) !== -1 ||
							jianjie.indexOf(kw) !== -1
					})
				}

				this.xiaoyuanyishengs = list
			}
		},
		onShow(e) {
			let _this = this;
			uni.request({
				url: "searchXiaoyuanyishengJson",
				success(res){
					_this.initDataFromResponse(res.data)
				}
			})
		},
		onReachBottom() {
			uni.showToast({
				title: '到底了',
				icon: 'none',
				duration: 1000
			})
		},
	}
</script>

<style>
	page {
		background-color: #f5f5f5;
	}

	.month-filter {
		background-color: #ffffff;
		padding: 8px 12px;
		border-bottom: 1px solid #e6e6e6;
	}

	.month-filter-inner {
		font-size: 14px;
		color: #333;
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