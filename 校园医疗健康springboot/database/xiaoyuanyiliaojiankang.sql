DROP database IF EXISTS `xiaoyuanyiliaojiankang`;

create database `xiaoyuanyiliaojiankang`;

use `xiaoyuanyiliaojiankang`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------

-- ----------------------------

-- Table structure for xiaoyuanyiliaojiankang

-- ----------------------------

    DROP TABLE IF EXISTS `t_admin`;

    CREATE TABLE `t_admin` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
        `username` varchar(255) DEFAULT NULL COMMENT '账号',
        `password` varchar(255) DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';
    DROP TABLE IF EXISTS `t_xiaoyuanyisheng`;

    CREATE TABLE `t_xiaoyuanyisheng` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '校园医生id',
        `username` varchar(255) DEFAULT NULL COMMENT '账号',
        `password` varchar(255) DEFAULT NULL COMMENT '密码',
        `schoolyishengname` varchar(255) DEFAULT NULL COMMENT '医生姓名',
        `schoolyssex` varchar(255) DEFAULT NULL COMMENT '医生性别',
        `schoolysage` varchar(255) DEFAULT NULL COMMENT '医生年龄',
        `schoolysphone` varchar(255) DEFAULT NULL COMMENT '医生联系电话',
        `schoolysavaator` varchar(255) DEFAULT NULL COMMENT '医生头像',
        `schoolysjianjie` varchar(2550) DEFAULT NULL COMMENT '医生简介',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园医生';
    DROP TABLE IF EXISTS `t_xyyiliaoyh`;

    CREATE TABLE `t_xyyiliaoyh` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '校园用户id',
        `username` varchar(255) DEFAULT NULL COMMENT '账号',
        `password` varchar(255) DEFAULT NULL COMMENT '密码',
        `xyyiliaoyhname` varchar(255) DEFAULT NULL COMMENT '校园用户昵称',
        `xyyiliaoyhsex` varchar(255) DEFAULT NULL COMMENT '用户性别',
        `xyyiliaoyhage` varchar(255) DEFAULT NULL COMMENT '用户年龄',
        `xyyiliaoyhphone` varchar(255) DEFAULT NULL COMMENT '用户电话',
        `xyyiliaoyhimg` varchar(255) DEFAULT NULL COMMENT '用户照片',
        `college` varchar(255) DEFAULT NULL COMMENT '学院',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园用户';
    DROP TABLE IF EXISTS `t_xyyiliaopaiban`;

    CREATE TABLE `t_xyyiliaopaiban` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '校园医疗排班id',
        `yuefen` varchar(255) DEFAULT NULL COMMENT '排班月份',
        `xiaoyuanyisheng` varchar(255) DEFAULT NULL COMMENT '校园医生',
        `xiaoyuanyishengid` int(11) DEFAULT NULL COMMENT '校园医生id',
        `remark` varchar(2550) DEFAULT NULL COMMENT '备注',
        `chuangjiantime` varchar(255) DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园医疗排班';
    DROP TABLE IF EXISTS `t_xyyiliaopaibanyuyue`;

    CREATE TABLE `t_xyyiliaopaibanyuyue` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约id',
        `jianyaowenti` varchar(255) DEFAULT NULL COMMENT '简要问题描述',
        `xiaoyuanyisheng` varchar(255) DEFAULT NULL COMMENT '校园医生',
        `xiaoyuanyishengid` int(11) DEFAULT NULL COMMENT '校园医生id',
        `xiaoyuanyishengimg` varchar(255) DEFAULT NULL COMMENT '校园医生照片',
        `xyyiliaoyh` varchar(255) DEFAULT NULL COMMENT '校园用户',
        `xyyiliaoyhid` int(11) DEFAULT NULL COMMENT '校园用户id',
        `xyyiliaoyhimg` varchar(255) DEFAULT NULL COMMENT '校园用户照片',
        `yuyuetime` varchar(255) DEFAULT NULL COMMENT '预约日期',
        `typea` varchar(255) DEFAULT NULL COMMENT '类型',
        `state` varchar(255) DEFAULT NULL COMMENT '状态',
        `addtime` varchar(255) DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园医疗排班预约';
    DROP TABLE IF EXISTS `t_guahaozixunjieguo`;

    CREATE TABLE `t_guahaozixunjieguo` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '挂号咨询结果id',
        `kaifangtime` varchar(255) DEFAULT NULL COMMENT '开方时间',
        `zhusu` varchar(2550) DEFAULT NULL COMMENT '用户症状描述',
        `yonghutiwen` varchar(255) DEFAULT NULL COMMENT '用户体温',
        `xinlv` varchar(255) DEFAULT NULL COMMENT '心率',
        `zhenduan` varchar(2550) DEFAULT NULL COMMENT '诊断结果',
        `xiuxijiany` varchar(2550) DEFAULT NULL COMMENT '休息建议',
        `yongyao` varchar(2550) DEFAULT NULL COMMENT '用药',
        `xiaoyuanyisheng` varchar(255) DEFAULT NULL COMMENT '校园医生',
        `xiaoyuanyishengid` int(11) DEFAULT NULL COMMENT '校园医生id',
        `xyyiliaoyh` varchar(255) DEFAULT NULL COMMENT '校园医疗用户',
        `xyyiliaoyhid` int(11) DEFAULT NULL COMMENT '校园医疗用户id',
        `xyyiliaopaibanyuyue` varchar(255) DEFAULT NULL COMMENT '排班预约',
        `xyyiliaopaibanyuyueid` int(11) DEFAULT NULL COMMENT '排班预约id',
        `price` varchar(255) DEFAULT NULL COMMENT '药品价格',
        `state` varchar(255) DEFAULT NULL COMMENT '状态',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='挂号咨询结果';
    DROP TABLE IF EXISTS `t_yhbinglijilv`;

    CREATE TABLE `t_yhbinglijilv` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
        `jilvtime` varchar(255) DEFAULT NULL COMMENT '记录时间',
        `zhusu` varchar(2550) DEFAULT NULL COMMENT '用户症状描述',
        `yonghutiwen` varchar(255) DEFAULT NULL COMMENT '用户体温',
        `xinlv` varchar(255) DEFAULT NULL COMMENT '心率',
        `zhenduan` varchar(2550) DEFAULT NULL COMMENT '诊断',
        `xiuxijiany` varchar(2550) DEFAULT NULL COMMENT '休息建议',
        `yongyao` varchar(2550) DEFAULT NULL COMMENT '用药',
        `xiaoyuanyisheng` varchar(255) DEFAULT NULL COMMENT '校园医生',
        `xiaoyuanyishengid` int(11) DEFAULT NULL COMMENT '校园医生id',
        `xyyiliaoyh` varchar(255) DEFAULT NULL COMMENT '校园用户',
        `xyyiliaoyhid` int(11) DEFAULT NULL COMMENT '校园用户id',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户病例记录';
    DROP TABLE IF EXISTS `t_yuyueduihua`;

    CREATE TABLE `t_yuyueduihua` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约对话id',
        `xyyiliaopaibanyuyue` varchar(255) DEFAULT NULL COMMENT '排班预约',
        `xyyiliaopaibanyuyueid` int(11) DEFAULT NULL COMMENT '排班预约id',
        `message` varchar(2550) DEFAULT NULL COMMENT '消息',
        `duihuauser` varchar(255) DEFAULT NULL COMMENT '对话用户',
        `duihuauserid` int(11) DEFAULT NULL COMMENT '对话用户id',
        `duihuauserrole` varchar(255) DEFAULT NULL COMMENT '对话角色',
        `duihuauserimg` varchar(255) DEFAULT NULL COMMENT '对话用户照片',
        `duihuauseraddtime` varchar(255) DEFAULT NULL COMMENT '发布时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约对话';
    DROP TABLE IF EXISTS `t_yuyuepingjia`;

    CREATE TABLE `t_yuyuepingjia` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约评价id',
        `xyyiliaopaibanyuyue` varchar(255) DEFAULT NULL COMMENT '医疗排班预约',
        `xyyiliaopaibanyuyueid` int(11) DEFAULT NULL COMMENT '医疗排班预约id',
        `pingcontent` varchar(2550) DEFAULT NULL COMMENT '评价内容',
        `type` varchar(255) DEFAULT NULL COMMENT '评价类型',
        `xyyiliaoyh` varchar(255) DEFAULT NULL COMMENT '校园用户',
        `xyyiliaoyhid` int(11) DEFAULT NULL COMMENT '校园用户id',
        `pingjiashijian` varchar(255) DEFAULT NULL COMMENT '评价时间',
        `xiaoyuanyisheng` varchar(255) DEFAULT NULL COMMENT '校园医生',
        `xiaoyuanyishengid` int(11) DEFAULT NULL COMMENT '校园医生id',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约评价';
    DROP TABLE IF EXISTS `t_xyyiliaoyaoping`;

    CREATE TABLE `t_xyyiliaoyaoping` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药品id',
        `drugname` varchar(255) DEFAULT NULL COMMENT '药品名称',
        `shengchanchangjia` varchar(255) DEFAULT NULL COMMENT '生产厂家',
        `danwei` varchar(255) DEFAULT NULL COMMENT '单位',
        `yaopingfenlei` varchar(255) DEFAULT NULL COMMENT '药品分类',
        `kucun` varchar(255) DEFAULT NULL COMMENT '库存',
        `price` varchar(255) DEFAULT NULL COMMENT '价格',
        `tixingkucun` varchar(255) DEFAULT NULL COMMENT '提醒库存',
        `shuoming` varchar(2550) DEFAULT NULL COMMENT '说明',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园医疗药品';
    DROP TABLE IF EXISTS `t_xytijianshixiang`;

    CREATE TABLE `t_xytijianshixiang` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '校园体检事项id',
        `tijiant` varchar(255) DEFAULT NULL COMMENT '体检标题',
        `tijiancontent` varchar(2550) DEFAULT NULL COMMENT '体检内容',
        `tijianzhuyi` varchar(2550) DEFAULT NULL COMMENT '体检注意事项',
        `tijianadress` varchar(2550) DEFAULT NULL COMMENT '体检位置',
        `tijiantime` varchar(255) DEFAULT NULL COMMENT '体检时间',
        `tijianimg` varchar(255) DEFAULT NULL COMMENT '封面',
        `xiaoyuanyisheng` varchar(255) DEFAULT NULL COMMENT '负责医生',
        `xiaoyuanyishengid` int(11) DEFAULT NULL COMMENT '负责医生id',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园体检事项';
    DROP TABLE IF EXISTS `t_tijianyhyuyue`;

    CREATE TABLE `t_tijianyhyuyue` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '体检预约id',
        `xytijianshixiang` varchar(255) DEFAULT NULL COMMENT '校园体检事项',
        `xytijianshixiangid` int(11) DEFAULT NULL COMMENT '校园体检事项id',
        `xyyiliaoyh` varchar(255) DEFAULT NULL COMMENT '校园医疗用户',
        `xyyiliaoyhid` int(11) DEFAULT NULL COMMENT '校园医疗用户id',
        `address` varchar(2550) DEFAULT NULL COMMENT '体检位置',
        `shijian` varchar(255) DEFAULT NULL COMMENT '体检时间',
        `img` varchar(255) DEFAULT NULL COMMENT '体检封面',
        `state` varchar(255) DEFAULT NULL COMMENT '状态',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='体检用户预约';
    DROP TABLE IF EXISTS `t_jiankangdangan`;

    CREATE TABLE `t_jiankangdangan` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '档案id',
        `shijian` varchar(255) DEFAULT NULL COMMENT '测试时间',
        `height` varchar(255) DEFAULT NULL COMMENT '身高',
        `weight` varchar(255) DEFAULT NULL COMMENT '体重',
        `bmi` varchar(255) DEFAULT NULL COMMENT 'bmi数值',
        `zuoyanshili` varchar(255) DEFAULT NULL COMMENT '左眼视力',
        `youyanshili` varchar(255) DEFAULT NULL COMMENT '右眼视力',
        `feihuoliang` varchar(255) DEFAULT NULL COMMENT '肺活量',
        `lidingtiaoyuan` varchar(255) DEFAULT NULL COMMENT '立定跳远成绩',
        `yibaimi` varchar(255) DEFAULT NULL COMMENT '一百米 成绩',
        `xyyiliaoyh` varchar(255) DEFAULT NULL COMMENT '校园医疗用户',
        `xyyiliaoyhid` int(11) DEFAULT NULL COMMENT '校园医疗用户id',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='健康档案';
    DROP TABLE IF EXISTS `t_xyggao`;

    CREATE TABLE `t_xyggao` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
        `xytitle` varchar(255) DEFAULT NULL COMMENT '公告标题',
        `xycontent` varchar(2550) DEFAULT NULL COMMENT '公告内容',
        `xyimg` varchar(255) DEFAULT NULL COMMENT '封面',
        `xyaddtime` varchar(255) DEFAULT NULL COMMENT '发布时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校园公告';
    DROP TABLE IF EXISTS `t_yiliaoyaopingtixing`;

    CREATE TABLE `t_yiliaoyaopingtixing` (

    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药品采购提醒id',
        `caigout` varchar(255) DEFAULT NULL COMMENT '提醒标题',
        `caigoucontent` varchar(255) DEFAULT NULL COMMENT '采购提醒内容',
        `addtime` varchar(255) DEFAULT NULL COMMENT '发布时间',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品采购提醒';




