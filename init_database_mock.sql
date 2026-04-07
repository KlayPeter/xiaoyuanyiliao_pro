USE xiaoyuanyiliaojiankang;

UPDATE t_xyggao 
SET xyimg = 'https://images.unsplash.com/photo-1532938911079-1b06ac7ceec7?auto=format&fit=crop&w=150&q=80' 
WHERE xyimg IS NULL OR xyimg = '' OR xyimg = 'none.png';

UPDATE t_xytijianshixiang 
SET tijianimg = 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?auto=format&fit=crop&w=150&q=80' 
WHERE tijianimg IS NULL OR tijianimg = '' OR tijianimg = 'none.png';
USE xiaoyuanyiliaojiankang;

-- 1. Admin
DELETE FROM t_admin WHERE username = 'admin';
INSERT INTO t_admin (username, password) VALUES ('admin', '123456');

-- 2. Doctor (校园医生)
DELETE FROM t_xiaoyuanyisheng WHERE username = 'doctor';
INSERT INTO t_xiaoyuanyisheng (username, password, schoolyishengname, schoolyssex, schoolysage, schoolysphone, schoolysavaator, schoolysjianjie) VALUES 
('doctor', '123456', '张医生', '男', 45, '13811112222', 'https://api.dicebear.com/7.x/avataaars/svg?seed=doctor', '全科医生，擅长各类常见病。');

-- 3. User (校园用户)
DELETE FROM t_xyyiliaoyh WHERE username = 'user';
INSERT INTO t_xyyiliaoyh (username, password, xyyiliaoyhname, xyyiliaoyhsex, xyyiliaoyhage, xyyiliaoyhphone, xyyiliaoyhavaator) VALUES 
('user', '123456', '李同学', '男', 20, '13911112222', 'https://api.dicebear.com/7.x/avataaars/svg?seed=user');

-- Make sure we have 2-3 rows in:
-- t_xyyiliaopaiban (排班)
INSERT INTO t_xyyiliaopaiban (yuefen, xiaoyuanyisheng, xiaoyuanyishengid, remark) VALUES
('2026-04', '张医生', (SELECT id FROM t_xiaoyuanyisheng WHERE username = 'doctor' LIMIT 1), '周一至周五上午排班'),
('2026-05', '王医生', 2, '全天值班');

-- t_xyyiliaoyaoping (药品)
INSERT INTO t_xyyiliaoyaoping (drugname, shengchanchangjia, danwei, yaopingfenlei, kucun, price, tixingkucun, shuoming) VALUES
('复方板蓝根颗粒', '白云山药业', '袋', '感冒药', '100', '10.5', '20', '清热解毒，退风热感冒。'),
('云南白药创可贴', '云南白药集团', '盒', '外用药', '200', '15.0', '50', '止血，镇痛，消炎，愈创。');

-- t_xytijianshixiang (体检事项)
INSERT INTO t_xytijianshixiang (tijiant, tijiancontent, tijianzhuyi, tijianadress, tijiantime, tijianimg, xiaoyuanyisheng, xiaoyuanyishengid) VALUES
('期末健康常规体检', '基础内科检查、外科检查、血压测量', '检查前一天请勿熬夜', '校门诊部体检中心', '2026-06-10', 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?auto=format&fit=crop&w=150&q=80', '张医生', 1),
('春季传染病筛查', '呼吸道疾病筛查', '请携带口罩', '校门诊二楼', '2026-04-20', 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?auto=format&fit=crop&w=150&q=80', '王医生', 2);

-- t_xyggao (公告)
INSERT INTO t_xyggao (xytitle, xycontent, xyimg, xyaddtime) VALUES
('校园流感疫苗接种通知', '本周三下午开始在校医院进行免费流感疫苗接种，请大家带好校园卡。', 'https://images.unsplash.com/photo-1505751172876-fa1923c5c528?auto=format&fit=crop&w=150&q=80', '2026-04-07 10:00:00'),
('夜间急诊通道开放指引', '夜间请从校医院北门进入急诊区，有专职医生值班。', 'https://images.unsplash.com/photo-1505751172876-fa1923c5c528?auto=format&fit=crop&w=150&q=80', '2026-04-06 09:00:00');

-- 预约评价 t_yuyuepingjia
INSERT INTO t_yuyuepingjia (xiaoyuanyishengid, xiaoyuanyisheng, xyyiliaoyhid, xyyiliaoyh, pingjiafen, pingjiacontent, pjtime) VALUES
(1, '张医生', 1, '李同学', '5', '医生非常负责，解答很详细。', '2026-04-01 10:00:00'),
(2, '王医生', 1, '李同学', '4', '排队稍微有点久，但态度很好。', '2026-04-02 11:00:00');

-- 健康档案 t_jiankangdangan
INSERT INTO t_jiankangdangan (xyyiliaoyhid, xyyiliaoyh, height, weight, xueya, xinlv, xuexing, guominshi, jwbs, jiankangpingg) VALUES
(1, '李同学', '175cm', '65kg', '120/80', '75', 'O型', '无', '无', '身体健康，各项指标正常。'),
(2, '王同学', '168cm', '55kg', '110/70', '70', 'A型', '青霉素过敏', '无', '正常');

-- 病例记录 t_yhbinglijilv
INSERT INTO t_yhbinglijilv (xyyiliaoyhid, xyyiliaoyh, xiaoyuanyishengid, xiaoyuanyisheng, zhenduan, chufang, zhuyishixiang, jltime) VALUES
(1, '李同学', 1, '张医生', '普通感冒', '复方感冒灵颗粒 1盒', '多喝热水，注意休息。', '2026-04-05 09:30:00'),
(1, '李同学', 2, '王医生', '急性肠胃炎', '左氧氟沙星片 1盒', '清淡饮食', '2026-03-20 14:00:00');
USE xiaoyuanyiliaojiankang;

-- 3. User (校园用户)
DELETE FROM t_xyyiliaoyh WHERE username = 'user';
INSERT INTO t_xyyiliaoyh (username, password, xyyiliaoyhname, xyyiliaoyhsex, xyyiliaoyhage, xyyiliaoyhphone, xyyiliaoyhimg, college) VALUES 
('user', '123456', '李同学', '男', 20, '13911112222', 'https://api.dicebear.com/7.x/avataaars/svg?seed=user', '软件学院');

-- Make sure we have 2-3 rows in:
-- t_xyyiliaopaiban (排班)
-- Get the ID of doctor and another doctor if possible
INSERT INTO t_xyyiliaopaiban (yuefen, xiaoyuanyisheng, xiaoyuanyishengid, remark) VALUES
('2026-04', '张医生', 1, '周一至周五上午排班'),
('2026-05', '王医生', 2, '全天值班');

-- t_xyyiliaoyaoping (药品)
INSERT INTO t_xyyiliaoyaoping (drugname, shengchanchangjia, danwei, yaopingfenlei, kucun, price, tixingkucun, shuoming) VALUES
('复方板蓝根颗粒', '白云山药业', '袋', '感冒药', '100', '10.5', '20', '清热解毒，退风热感冒。'),
('云南白药创可贴', '云南白药集团', '盒', '外用药', '200', '15.0', '50', '止血，镇痛，消炎，愈创。');

-- t_xytijianshixiang (体检事项)
INSERT INTO t_xytijianshixiang (tijiant, tijiancontent, tijianzhuyi, tijianadress, tijiantime, tijianimg, xiaoyuanyisheng, xiaoyuanyishengid) VALUES
('期末健康常规体检', '基础内科检查、外科检查、血压测量', '检查前一天请勿熬夜', '校门诊部体检中心', '2026-06-10', 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?auto=format&fit=crop&w=150&q=80', '张医生', 1),
('春季传染病筛查', '呼吸道疾病筛查', '请携带口罩', '校门诊二楼', '2026-04-20', 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?auto=format&fit=crop&w=150&q=80', '王医生', 2);

-- t_xyggao (公告)
INSERT INTO t_xyggao (xytitle, xycontent, xyimg, xyaddtime) VALUES
('校园流感疫苗接种通知', '本周三下午开始在校医院进行免费流感疫苗接种，请大家带好校园卡。', 'https://images.unsplash.com/photo-1505751172876-fa1923c5c528?auto=format&fit=crop&w=150&q=80', '2026-04-07 10:00:00'),
('夜间急诊通道开放指引', '夜间请从校医院北门进入急诊区，有专职医生值班。', 'https://images.unsplash.com/photo-1505751172876-fa1923c5c528?auto=format&fit=crop&w=150&q=80', '2026-04-06 09:00:00');

-- 预约评价 t_yuyuepingjia
INSERT INTO t_yuyuepingjia (xiaoyuanyishengid, xiaoyuanyisheng, xyyiliaoyhid, xyyiliaoyh, pingjiafen, pingjiacontent, pjtime) VALUES
(1, '张医生', 1, '李同学', '5', '医生非常负责，解答很详细。', '2026-04-01 10:00:00'),
(2, '王医生', 1, '李同学', '4', '排队稍微有点久，但态度很好。', '2026-04-02 11:00:00');

-- 健康档案 t_jiankangdangan
INSERT INTO t_jiankangdangan (xyyiliaoyhid, xyyiliaoyh, height, weight, xueya, xinlv, xuexing, guominshi, jwbs, jiankangpingg) VALUES
(1, '李同学', '175cm', '65kg', '120/80', '75', 'O型', '无', '无', '身体健康，各项指标正常。'),
(2, '王同学', '168cm', '55kg', '110/70', '70', 'A型', '青霉素过敏', '无', '正常');

-- 病例记录 t_yhbinglijilv
INSERT INTO t_yhbinglijilv (xyyiliaoyhid, xyyiliaoyh, xiaoyuanyishengid, xiaoyuanyisheng, zhenduan, chufang, zhuyishixiang, jltime) VALUES
(1, '李同学', 1, '张医生', '普通感冒', '复方感冒灵颗粒 1盒', '多喝热水，注意休息。', '2026-04-05 09:30:00'),
(1, '李同学', 2, '王医生', '急性肠胃炎', '左氧氟沙星片 1盒', '清淡饮食', '2026-03-20 14:00:00');
USE xiaoyuanyiliaojiankang;

-- 预约评价 t_yuyuepingjia
INSERT INTO t_yuyuepingjia (xiaoyuanyishengid, xiaoyuanyisheng, xyyiliaoyhid, xyyiliaoyh, pjfenshu, pingjiaconten, pjtime) VALUES
(1, '张医生', 1, '李同学', '5分', '医生非常负责，解答很详细。', '2026-04-01 10:00:00'),
(2, '王医生', 1, '李同学', '4分', '排队稍微有点久，但态度很好。', '2026-04-02 11:00:00');

-- 健康档案 t_jiankangdangan
INSERT INTO t_jiankangdangan (xyyiliaoyhid, xyyiliaoyh, jiankanganame, tizhong, shengao, xueya, xuetang, xinlv, xuexing, bingshi, guominshi, jiankangstatus) VALUES
(1, '李同学', '李同学的基础生化档案', '65kg', '175cm', '120/80', '5.5', '75', 'O型', '无', '无', '身体健康，各项指标正常。'),
(2, '王同学', '王同学心肺基础检查', '55kg', '168cm', '110/70', '4.8', '70', 'A型', '无', '青霉素过敏', '心肺功能正常');

-- 病例记录 t_yhbinglijilv
INSERT INTO t_yhbinglijilv (xyyiliaoyhid, xyyiliaoyh, xiaoyuanyishengid, xiaoyuanyisheng, zhenduan, yongyao, zhusu, yonghutiwen, xinlv, xiuxijiany, jilvtime) VALUES
(1, '李同学', 1, '张医生', '普通感冒', '复方感冒灵颗粒 1盒', '咳嗽，流鼻涕，轻微发热', '37.8度', '85次/分', '多喝热水，注意休息。', '2026-04-05 09:30:00'),
(1, '李同学', 2, '王医生', '急性肠胃炎', '左氧氟沙星片 1盒', '腹泻，伴有恶心', '37.2度', '90次/分', '清淡饮食，近期尽量喝粥。', '2026-03-20 14:00:00');
USE xiaoyuanyiliaojiankang;

-- 预约评价 t_yuyuepingjia
INSERT INTO t_yuyuepingjia (xiaoyuanyishengid, xiaoyuanyisheng, xyyiliaoyhid, xyyiliaoyh, pingjiafenshu, pingjiacontent, pingjiatime) VALUES
(1, '张医生', 1, '李同学', '5分', '医生非常负责，解答很详细。', '2026-04-01 10:00:00'),
(2, '王医生', 1, '李同学', '4分', '排队稍微有点久，但态度很好。', '2026-04-02 11:00:00');

-- 健康档案 t_jiankangdangan
INSERT INTO t_jiankangdangan (xyyiliaoyhid, xyyiliaoyh, dangantitle, height, weight, bmi, zuoyanshili, youyanshili, feihuoliang, lidingtiaoyuan, yibaimi) VALUES
(1, '李同学', '李同学的基础生化档案', '175cm', '65kg', '21.2', '5.0', '5.1', '3500ml', '2.3m', '14.5s'),
(2, '王同学', '王同学心肺基础检查', '168cm', '55kg', '19.5', '4.8', '4.9', '2800ml', '1.9m', '16.0s');
USE xiaoyuanyiliaojiankang;

TRUNCATE TABLE t_yuyuepingjia;

INSERT INTO t_yuyuepingjia (xiaoyuanyishengid, xyyiliaoyhid, pingcontent, pingjiafenshu) VALUES 
(1, 2, '李医生非常负责，开的药很有效，两天就痊愈了，非常有耐心！', '5'),
(1, 3, '态度很好，医术精湛，感谢李大夫。', '4.5'),
(2, 4, '王医生问诊非常仔细，让人很有安全感，推荐同学去挂她的号！', '5'),
(2, 2, '总体来说还不错，排队稍微长了一点，但医生看得很仔细。', '4'),
(3, 3, '普通门诊，医生很专业，检查设备虽然一般但能准确判断病情。', '4.5'),
(4, 4, '这几天感冒发烧，吃了王医生的药就好多了，给王医生点赞。', '5'),
(5, 2, '赵医生比较忙，但很高效，没说几句话药就开了，目前在恢复中。', '3.8'),
(6, 3, '张医生非常随和，给我耐心讲解了如何预防类似疾病，满分！', '5');
USE xiaoyuanyiliaojiankang;

-- 插入一些校园医生
INSERT INTO t_xiaoyuanyisheng (username, password, schoolyishengname, schoolyssex, schoolysage, schoolysphone, schoolysavaator, schoolysjianjie) VALUES 
('doctor1', '123456', '李医生', '男', 45, '13800000001', 'none.png', '骨科专家，从事骨科临床工作二十年。'),
('doctor2', '123456', '王医生', '女', 38, '13800000002', 'none.png', '内科全科医生，擅长常见病的诊断。'),
('doctor3', '123456', '赵医生', '男', 51, '13800000003', 'none.png', '外科副主任医师。');

-- 获取上面插入的医生的ID (假设自增ID)
INSERT INTO t_xyyiliaopaiban (yuefen, xiaoyuanyisheng, xiaoyuanyishengid, remark, chuangjiantime)
SELECT '2026-04', schoolyishengname, id, '2026年4月份排班 - 上午班', '2026-04-07 10:00:00' FROM t_xiaoyuanyisheng WHERE username = 'doctor1';

INSERT INTO t_xyyiliaopaiban (yuefen, xiaoyuanyisheng, xiaoyuanyishengid, remark, chuangjiantime)
SELECT '2026-04', schoolyishengname, id, '2026年4月份排班 - 全天急诊', '2026-04-07 10:05:00' FROM t_xiaoyuanyisheng WHERE username = 'doctor2';

INSERT INTO t_xyyiliaopaiban (yuefen, xiaoyuanyisheng, xiaoyuanyishengid, remark, chuangjiantime)
SELECT '2026-05', schoolyishengname, id, '2026年5月份预排班', '2026-04-07 10:10:00' FROM t_xiaoyuanyisheng WHERE username = 'doctor3';

-- 插入一些药品数据
INSERT INTO t_xyyiliaoyaoping (yaopingbianhao, yaopingname, yaopingtype, chandi, guige, youxiaoyuefen, pic, chuangjiantime) VALUES
('YP001', '阿莫西林胶囊', '抗生素', '广州', '0.25g*50粒', '24个月', 'none.png', '2026-04-07 10:00:00'),
('YP002', '布洛芬缓释胶囊', '解热镇痛药', '北京', '0.3g*30粒', '36个月', 'none.png', '2026-04-07 10:00:00'),
('YP003', '复方感冒灵颗粒', '感冒药', '上海', '10g*9袋', '24个月', 'none.png', '2026-04-07 10:00:00');

-- 插入一些体检事项数据
INSERT INTO t_xytijianshixiang (xiangmubianhao, xytijianshixiangname, type, yisheng, zhuyishixiang, pic, chuangjiantime) VALUES
('TJ001', '常规全身体检', '常规体检', '王医生', '体检前需空腹8小时以上', 'none.png', '2026-04-07 10:00:00'),
('TJ002', '内科查体', '内科体检', '李医生', '无特殊注意事项', 'none.png', '2026-04-07 10:00:00'),
('TJ003', '口腔专项检查', '专科检查', '赵医生', '请在检查前刷牙', 'none.png', '2026-04-07 10:00:00');

-- 插入公告数据
INSERT INTO t_xyggao (title, content, pic, gaoTime) VALUES
('关于端午节全校医疗值班安排的通知', '各位同学、教职工：端午节期间，校医院安排24小时值班，具体排班表请至系统查看。', 'none.png', '2026-04-07 10:00:00'),
('春季传染病预防宣传指导', '请大家注意春季温差变化，保持寝室通风，勤洗手，如有不适及时就医。', 'none.png', '2026-04-05 08:30:00');
USE xiaoyuanyiliaojiankang;

-- 注意：前面的医生和排班可能已经部分插入，如果有需要可以加 IGNORE 或只插入新的表
-- 插入一些药品数据
INSERT INTO t_xyyiliaoyaoping (drugname, shengchanchangjia, danwei, yaopingfenlei, kucun, price, tixingkucun, shuoming) VALUES
('阿莫西林胶囊', '广州药厂', '盒', '抗生素', '300', '15.5', '50', '用于敏感菌所致的呼吸道感染、生殖泌尿期感染等。'),
('布洛芬缓释胶囊', '北京制药', '盒', '解热镇痛', '500', '21.0', '100', '用于缓解轻至中度疼痛如头痛。'),
('复方感冒灵颗粒', '上海药业', '盒', '感冒药', '200', '13.0', '30', '辛凉解表，清热解毒。用于风热感冒之发热。');

-- 插入一些体检事项数据
-- 获取之前插入的医生ID，由于这里可能不匹配，我们直接假设刚才医生成功了或者盲插1试试
INSERT INTO t_xytijianshixiang (title, shixiangcontent, tijiantime, tijianimg, xiaoyuanyisheng, xiaoyuanyishengid) VALUES
('新生入学常规全身体检', '包含内科、外科、眼科、耳鼻喉科常规检查', '2026-04-10', 'none.png', '李医生', 1),
('教职工心血管专科查体', '主要检查血压、心电图及相关血液指标', '2026-04-12', 'none.png', '王医生', 2),
('学生年度视力保护检查', '视力测试及散光检查，近视预防指导', '2026-04-15', 'none.png', '赵医生', 3);

-- 插入公告数据
INSERT INTO t_xyggao (xytitle, xycontent, xyimg, xyaddtime) VALUES
('关于端午节全校医疗值班安排的通知', '各位同学、教职工：端午节期间，校医院安排24小时值班，急诊照常开放。具体排班请至系统查看，祝大家端午安康！', 'none.png', '2026-04-07 10:00:00'),
('春季传染病预防与就诊须知', '请大家注意春季温差变化，保持寝室通风，勤洗手，如有发热咳嗽不适请佩戴口罩及时到校医院就医。', 'none.png', '2026-04-05 08:30:00');
USE xiaoyuanyiliaojiankang;

-- 插入一些体检事项数据
INSERT INTO t_xytijianshixiang (tijiant, tijiancontent, tijianzhuyi, tijianadress, tijiantime, tijianimg, xiaoyuanyisheng, xiaoyuanyishengid) VALUES
('新生入学常规全身体检', '包含内科、外科、眼科、耳鼻喉科常规检查', '体检前请空腹，带好有效证件。', '校医院一楼', '2026-04-10', 'none.png', '李医生', 1),
('教职工心血管专科查体', '主要检查血压、心电图及相关血液指标', '前一晚请勿饮酒，保证充足睡眠。', '校医院三楼', '2026-04-12', 'none.png', '王医生', 2),
('学生年度视力保护检查', '视力测试及散光检查，近视预防指导', '请携带原有眼镜', '校医院二楼眼科', '2026-04-15', 'none.png', '赵医生', 3);

-- 保证公告插入成功（如果之前没插进去）
INSERT INTO t_xyggao (xytitle, xycontent, xyimg, xyaddtime) VALUES
('关于端午节全校医疗值班安排的通知', '各位同学、教职工：端午节期间，校医院安排24小时值班，急诊照常开放。具体排班请至系统查看，祝大家端午安康！', 'none.png', '2026-04-07 10:00:00'),
('春季传染病预防与就诊须知', '请大家注意春季温差变化，保持寝室通风，勤洗手，如有发热咳嗽不适请佩戴口罩及时到校医院就医。', 'none.png', '2026-04-05 08:30:00');
USE xiaoyuanyiliaojiankang;

UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doctor1' WHERE username = 'doctor1';
UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doctor2' WHERE username = 'doctor2';
UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doctor3' WHERE username = 'doctor3';

-- Also update original doctors if they exist
UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doc' WHERE schoolysavaator = 'none.png' OR schoolysavaator = '';

-- Also for any users if there are user avatars, though the table schema doesn't show it right now.
-- Verify that image URL logic is correctly updated in t_xyyiliaoyaoping, t_xytijianshixiang, t_xyggao to valid placeholder images so they don't show randomly broken links if they open the tables.
UPDATE t_xyyiliaoyaoping SET pic = 'https://images.unsplash.com/photo-1584308666744-24d5e4fecc13?auto=format&fit=crop&w=150&q=80' WHERE pic = 'none.png';
UPDATE t_xytijianshixiang SET tijianimg = 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?auto=format&fit=crop&w=150&q=80' WHERE tijianimg = 'none.png';
UPDATE t_xyggao SET xyimg = 'https://images.unsplash.com/photo-1505751172876-fa1923c5c528?auto=format&fit=crop&w=150&q=80' WHERE xyimg = 'none.png';
USE xiaoyuanyiliaojiankang;

UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doctor1' WHERE username = 'doctor1';
UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doctor2' WHERE username = 'doctor2';
UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doctor3' WHERE username = 'doctor3';

-- Also update original doctors if they exist
UPDATE t_xiaoyuanyisheng SET schoolysavaator = 'https://api.dicebear.com/7.x/avataaars/svg?seed=doc' WHERE schoolysavaator = 'none.png' OR schoolysavaator = '';

UPDATE t_xytijianshixiang SET tijianimg = 'https://images.unsplash.com/photo-1579684385127-1ef15d508118?auto=format&fit=crop&w=150&q=80' WHERE tijianimg = 'none.png' OR tijianimg = '';
UPDATE t_xyggao SET xyimg = 'https://images.unsplash.com/photo-1505751172876-fa1923c5c528?auto=format&fit=crop&w=150&q=80' WHERE xyimg = 'none.png' OR xyimg = '';
