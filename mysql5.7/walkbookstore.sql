/*
Navicat MySQL Data Transfer

Source Server         : mysql57
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : walkbookstore

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-05-08 08:35:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `id` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'UUID',
  `client_id` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `resource_ids` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `client_secret` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `scope` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `authorized_grant_types` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `authorities` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL COMMENT 'token存活时长,单位秒',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT '刷新秘钥存活时长,单位秒',
  `additional_information` varchar(4096) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `autoapprove` varchar(256) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_deleted` int(11) NOT NULL COMMENT '作废标记（1作废，0未作废）',
  `sort_no` int(11) NOT NULL COMMENT '序号（从0开始）',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建者(登录账号)',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  `last_modified_by` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者(登录账号)',
  `version` int(11) NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('1', 'webapp', 'web,app,oauth2-resource', 'webapp', 'all', 'password,refresh_token', null, null, '7200', '7200', null, 'true', '0', '0', '2019-05-24 09:42:42', '0', null, null, '0');

-- ----------------------------
-- Table structure for t_info_activemq
-- ----------------------------
DROP TABLE IF EXISTS `t_info_activemq`;
CREATE TABLE `t_info_activemq` (
  `mq_id` varchar(40) NOT NULL,
  `mq_message` varchar(2048) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`mq_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_info_activemq
-- ----------------------------
INSERT INTO `t_info_activemq` VALUES ('active2020040122260044033', '{\"goodsId\":\"sp2020040122255794717\",\"isbn\":\"978-7-5101-3686-7\",\"goodsName\":\"演员的自我修养3\",\"oneClassifyId\":\"2\",\"twoClassifyId\":\"3\",\"goodsInventory\":0,\"goodsOriginalCost\":26.90,\"goodsPrice\":30.50,\"goodsStateId\":0,\"goodsViewNum\":0,\"goodsSales\":0,\"isDelete\":0,\"createUser\":\"1\"}', '2020-04-01 22:26:00', '1');
INSERT INTO `t_info_activemq` VALUES ('active2020040122575122032', '{\"goodsId\":\"sp2020040122574910300\",\"isbn\":\"978-7-5101-3686-8\",\"goodsName\":\"演员的自我修养4\",\"oneClassifyId\":\"2\",\"twoClassifyId\":\"3\",\"goodsInventory\":0,\"goodsOriginalCost\":26.90,\"goodsPrice\":30.50,\"goodsStateId\":0,\"goodsViewNum\":0,\"goodsSales\":0,\"isDelete\":0,\"createUser\":\"1\"}', '2020-04-01 22:57:51', '1');

-- ----------------------------
-- Table structure for t_info_area_level
-- ----------------------------
DROP TABLE IF EXISTS `t_info_area_level`;
CREATE TABLE `t_info_area_level` (
  `area_id` varchar(40) NOT NULL COMMENT '区域的id',
  `area_name` varchar(40) NOT NULL COMMENT '名称',
  `parent_area` int(1) NOT NULL COMMENT '1表示省级，2表示市，3表示区/县级',
  `parent_level_id` varchar(40) DEFAULT NULL COMMENT '上一级的id，省级的上一级是全0',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`area_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='省市区名称，包含直辖市';

-- ----------------------------
-- Records of t_info_area_level
-- ----------------------------
INSERT INTO `t_info_area_level` VALUES ('0', '天河区', '3', '1', '0', '2020-04-16 17:11:06', '1', '2020-04-16 17:11:17', '', '0');
INSERT INTO `t_info_area_level` VALUES ('1', '广州市', '2', '123', '0', '2020-04-16 17:12:09', '1', '2020-04-16 17:12:13', null, '0');
INSERT INTO `t_info_area_level` VALUES ('123', '广东省', '1', '0', '0', '2020-04-16 17:11:39', '1', '2020-04-16 17:11:44', null, '0');
INSERT INTO `t_info_area_level` VALUES ('2', '潮州市', '2', '123', '0', '2020-05-03 15:08:19', '1', '2020-05-03 15:08:23', null, '0');
INSERT INTO `t_info_area_level` VALUES ('3', '枫溪区', '3', '2', '0', '2020-05-03 15:08:47', '1', '2020-05-03 15:08:52', null, '0');
INSERT INTO `t_info_area_level` VALUES ('4', '汕头市', '2', '123', '0', '2020-05-04 21:54:03', '1', '2020-05-04 21:54:09', null, '0');
INSERT INTO `t_info_area_level` VALUES ('5', '金平区', '3', '4', '0', '2020-05-04 21:54:36', '1', '2020-05-04 21:54:40', null, '0');
INSERT INTO `t_info_area_level` VALUES ('6', '揭阳市', '2', '123', '0', '2020-05-06 10:23:57', '1', '2020-05-06 10:24:02', null, '0');
INSERT INTO `t_info_area_level` VALUES ('7', '榕城区', '3', '6', '0', '2020-05-06 10:24:29', '1', '2020-05-06 10:24:34', null, '0');

-- ----------------------------
-- Table structure for t_info_client
-- ----------------------------
DROP TABLE IF EXISTS `t_info_client`;
CREATE TABLE `t_info_client` (
  `user_id` varchar(40) NOT NULL COMMENT '客户对应的用户编号',
  `invite_code` varchar(64) DEFAULT NULL COMMENT '门店邀请码，一个客户只能有一个邀请码',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='客户信息表';

-- ----------------------------
-- Records of t_info_client
-- ----------------------------
INSERT INTO `t_info_client` VALUES ('2020040917100463608', '1', '0', '2020-04-12 15:35:11', '1', '2020-04-12 15:35:13', '1', '0');

-- ----------------------------
-- Table structure for t_info_driver
-- ----------------------------
DROP TABLE IF EXISTS `t_info_driver`;
CREATE TABLE `t_info_driver` (
  `driver_id` varchar(40) NOT NULL COMMENT '司机编号（也是用户编号）',
  `user_id` varchar(40) NOT NULL COMMENT '店长编号',
  `province_name` varchar(20) DEFAULT NULL COMMENT '司机负责的省的名称',
  `city_name` varchar(20) DEFAULT NULL COMMENT '司机负责的市的名称',
  `area_name` varchar(20) DEFAULT NULL COMMENT '司机负责区的名称',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`driver_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='司机信息表';

-- ----------------------------
-- Records of t_info_driver
-- ----------------------------
INSERT INTO `t_info_driver` VALUES ('2020042710143719591', '2020041615571659234', '123', '2', '3', '0', '2020-04-27 10:14:37', '1', '2020-05-02 11:59:11', '2020041615571659234', '1');
INSERT INTO `t_info_driver` VALUES ('2020050519213383348', '0', '123', '4', '5', '0', '2020-05-05 19:21:33', '2020050421523502560', '2020-05-05 19:21:33', null, '0');
INSERT INTO `t_info_driver` VALUES ('2020050610522346023', '0', '123', '6', '7', '0', '2020-05-06 10:52:23', '2020042209400417295', '2020-05-06 10:52:23', null, '0');

-- ----------------------------
-- Table structure for t_info_evaluate_image
-- ----------------------------
DROP TABLE IF EXISTS `t_info_evaluate_image`;
CREATE TABLE `t_info_evaluate_image` (
  `image_id` varchar(40) NOT NULL COMMENT '图片编号',
  `evaluate_id` varchar(40) NOT NULL COMMENT '评价编号',
  `image_path` varchar(512) DEFAULT NULL COMMENT '图片的路径',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='客户评价上传的图片';

-- ----------------------------
-- Records of t_info_evaluate_image
-- ----------------------------

-- ----------------------------
-- Table structure for t_info_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_info_goods`;
CREATE TABLE `t_info_goods` (
  `goods_id` varchar(40) NOT NULL COMMENT '商品编号',
  `isbn` varchar(40) DEFAULT NULL COMMENT '书号 13位字母数字加5为字符',
  `goods_name` varchar(128) DEFAULT NULL COMMENT '书名',
  `one_classify_id` varchar(64) DEFAULT NULL COMMENT '一级分类的名称',
  `two_classify_id` varchar(64) DEFAULT NULL COMMENT '二级分类的名称',
  `goods_describe` varchar(4096) DEFAULT NULL COMMENT '商品介绍',
  `supplier_name` varchar(40) DEFAULT NULL COMMENT '进货商家的名称(要是有时间写过供货商表，这里就改成编号)',
  `goods_inventory` int(10) DEFAULT NULL COMMENT '库存',
  `goods_original_cost` double DEFAULT NULL COMMENT '成本价',
  `goods_price` double DEFAULT NULL COMMENT '在售价',
  `goods_advertise` varchar(4096) DEFAULT NULL COMMENT '广告词',
  `goods_image_path` varchar(512) DEFAULT NULL COMMENT '商品图片路径',
  `goods_shelf_time` datetime DEFAULT NULL COMMENT '上架时间',
  `goods_state_id` varchar(2) DEFAULT NULL COMMENT '0表示售罄，1表示在售，2表示已下架，3表示未发布',
  `goods_views_num` int(12) DEFAULT NULL COMMENT '浏览量',
  `goods_author` varchar(40) DEFAULT NULL COMMENT '作者',
  `goods_press` varchar(512) DEFAULT NULL COMMENT '出版社',
  `goods_sales` int(255) DEFAULT NULL COMMENT '销售量',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `goods_evaluate_score` double(4,0) DEFAULT NULL,
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='库存书籍的信息存储表';

-- ----------------------------
-- Records of t_info_goods
-- ----------------------------
INSERT INTO `t_info_goods` VALUES ('2020041012102569960', '978-7-5101-3686-10', '韭菜的自我修养', '2020041311231338868', '2020041411231338868', '股市韭菜', 'a股', null, '10', '20', '读癌股品人生', 'https://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200424150324741234.jpg', '2020-04-30 11:07:32', '1', '40', 'agu', 'a股出版社', '26', '0', '2020-04-10 12:10:25', '1', '2020-05-06 09:24:22', '1', '16', null);
INSERT INTO `t_info_goods` VALUES ('2020043013101442844', '9787540477516', '武则天正传（纪念典藏版）', '2020041311231338868', '2020041411231338868', '武则天：中国有史以来，空前成功的一个女强人 林语堂逝世40周年纪念典藏版。', '潮州书店', '100', '32', '29.2', '武则天：中国有史以来，空前成功的一个女强人 林语堂逝世40周年纪念典藏版。', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200430130317907614.png', '2020-05-06 09:39:08', '1', null, '林语堂', '湖南文艺出版社', '0', '0', '2020-04-30 13:10:14', '1', '2020-05-06 09:43:51', '1', '2', null);
INSERT INTO `t_info_goods` VALUES ('2020050318304990632', '9787213095399', '当你学会独处', '2020050318230104890', '2020050318233253027', '当代文学大家周国平半生哲思与创作精华，一本让人学会与自我和解的心灵之书，写给每一个孤独的行路人。独处是灵魂生长的必要空间，在独处时，我们从他人和喧嚣中抽身出来，回到了自己。', '浙江人民出版社', '94', '46', '38.8', '当代文学大家周国平半生哲思与创作精华，一本让人学会与自我和解的心灵之书，写给每一个孤独的行路人。独处是灵魂生长的必要空间，在独处时，我们从他人和喧嚣中抽身出来，回到了自己。', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503183047136587.png', '2020-05-06 09:39:14', '1', null, '周国平', '浙江人民出版社', '1', '0', '2020-05-03 18:30:50', '1', '2020-05-06 00:50:22', '1', '7', '4');
INSERT INTO `t_info_goods` VALUES ('2020050318344461788', '9787551816991', '诗经', '2020050318230104890', '2020050318321820983', '它不仅是经典，更是一部流传2500多年的唯美诗集。全篇305首，骆玉明解注，随文注音，无障碍阅读。203幅细井徇彩色手绘原稿，230种名物简介。集学术价值、艺术价值于一体，可诵、可赏、易解。果麦出品', '潮州书店', '100', '138', '95.2', '（韩寒推荐，全三册注音插图版）', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503183443431858.png', '2020-05-06 09:39:17', '1', null, '骆玉明(解注)，果麦文化 出品', '三秦出版社', '0', '0', '2020-05-03 18:34:44', '1', '2020-05-06 09:51:12', '2020042209400417295', '2', null);
INSERT INTO `t_info_goods` VALUES ('2020050318385557191', '23413230', '毛泽东选集', '2020050318352019761', '2020050318355126828', '《*选集(套装全4册)(普及本)》包括了*同志在中国革命各个时期中的重要著作。几年前各地方曾经出过几种不同版本的《*选集》，都是没有经过著者审查的，体例颇为杂乱，文字亦有错讹，有些重要的著作又没有收进去。现在的这部选集，是按照中国共产党成立后所经历的各个历史时期并且按照著作年月次序而编辑的。这部选集尽可能地搜集了一些为各地方过去印行的集子还没有包括在内的重要著作。选集中的各篇著人，都经著者校阅过，其中有些地方著者曾作了一些文字上的修正，也有个别的文章曾作了一些内容上的补充和修改。', '潮州书店', '95', '81', '63.9', '（全四册，32开）', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503183854512324.png', '2020-05-06 09:39:19', '1', null, '毛泽东', '国家出版社', '5', '0', '2020-05-03 18:38:55', '1', '2020-05-05 20:02:08', null, '2', null);
INSERT INTO `t_info_goods` VALUES ('2020050318410564967', '9787101080759', '孙子兵法', '2020050318352019761', '2020050318360463701', '《孙子兵法》十三篇涉及军事理论、实践各个方面，内容博大精深，思想深邃富瞻，逻辑缜密严谨，既是我国古代军事文化遗产中的瑰宝，又是我国优秀传统文化的重要组成部分。本书以杨炳安先生的《十一家注孙子校理》为底本，吸取古今整理、注释、校勘的优秀成果，对《孙子兵法》全文进行注译，每篇逐一题解，资料丰富，解说详尽，尤其是将孙子思想放在先秦诸子、先秦文化的大背景下加以阐发，颇多新论。这是一部学习、研读《孙子兵法》的优秀读本。', '潮州书店', '100', '26', '20.5', '（中华经典名著全本全注全译丛书）', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503184102443448.png', '2020-05-06 09:39:22', '1', null, '陈曦 ', '中华书局', '0', '0', '2020-05-03 18:41:05', '1', '2020-05-04 00:36:55', null, '2', null);
INSERT INTO `t_info_goods` VALUES ('2020050318444837637', '9787115514042', '迪士尼幼儿英语单词学习书', '2020050318422781840', '2020050318424294727', '26个超大可触字母单词书，343个幼小衔接基础词汇小词典，适合中国宝宝的中英双语启蒙书。', '潮州书店', '95', '128', '101.1', '26个超大可触字母单词书，343个幼小衔接基础词汇小词典，适合中国宝宝的中英双语启蒙书。', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503184447089811.png', '2020-05-06 09:39:25', '1', null, '迪士尼 ', '人民邮电出版社', '2', '0', '2020-05-03 18:44:48', '1', '2020-05-06 00:47:42', null, '3', '5');
INSERT INTO `t_info_goods` VALUES ('2020050318473137738', '9787555269830', '英语单词情境认知大书', '2020050318422781840', '2020050318424294727', '畅销十多年，中英双语对照版，涵盖日常八大主题，情景式学习，浸入式记忆，1200个日常单词，掌握小学英语必背词汇。扫码听音频，轻松伴读。', '潮州书店', '96', '128', '111.4', '畅销十多年，中英双语对照版，涵盖日常八大主题，情景式学习，浸入式记忆，1200个日常单词，掌握小学英语必背词汇。扫码听音频，轻松伴读。', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503184730256456.png', '2020-05-06 09:39:28', '1', null, '儿童英语研究小组', '青岛出版社', '3', '0', '2020-05-03 18:47:31', '1', '2020-05-06 00:48:05', null, '1', null);
INSERT INTO `t_info_goods` VALUES ('2020050318491066009', '9787531580669', '星光的速度', '2020050318422781840', '2020050318425899073', '一眼即懂的天文物理书，入选 英国 2019年 图书设计和制作大奖短名单、奥利地2019年年度科学书籍长名单、2017年博洛尼亚儿童插画大展', '潮州书店', '96', '138', '95.2', '一眼即懂的天文物理书，入选 英国 2019年 图书设计和制作大奖短名单、奥利地2019年年度科学书籍长名单、2017年博洛尼亚儿童插画大展', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503184809903118.png', '2020-05-06 09:39:31', '1', null, '(英)科林·斯图尔特', '辽宁少年儿童出版社', '0', '0', '2020-05-03 18:49:10', '1', '2020-05-06 00:51:02', null, '5', '3');
INSERT INTO `t_info_goods` VALUES ('2020050610473134013', '9787544276986', '你当像鸟飞往你的山', '2020050318230104890', '2020050610462884726', '17岁前从未上过学的女孩，如何成为剑桥大学博士？我们要背叛多少曾经，才能找到真正的自我！《纽约时报》 等数十家媒体一致公推“年度图书”，作者获选《时代周刊》年度影响力人物！这本书比你听说的还要好！', '新华书店', '100', '59', '50.2', '（比尔·盖茨年度特别推荐，登顶《纽约时报》畅销榜80 周！多一个人读到这个真实故事，就多一个人勇敢做自己！）', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200506104729680178.png', '2020-05-06 10:47:31', '2', null, '作者', '出版社', null, '0', '2020-05-06 10:47:31', '1', '2020-05-06 10:47:59', '2020042209400417295', '2', '4');

-- ----------------------------
-- Table structure for t_info_goods_classify
-- ----------------------------
DROP TABLE IF EXISTS `t_info_goods_classify`;
CREATE TABLE `t_info_goods_classify` (
  `classify_id` varchar(40) NOT NULL COMMENT '分类的编号',
  `classify_name` varchar(64) DEFAULT NULL COMMENT '分类的名称',
  `classify_parent` varchar(40) DEFAULT NULL COMMENT '分类的父级编号',
  `classify_comment` varchar(512) DEFAULT NULL COMMENT '备注',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `rank` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='书籍的分类信息存储表';

-- ----------------------------
-- Records of t_info_goods_classify
-- ----------------------------
INSERT INTO `t_info_goods_classify` VALUES ('2020041311231338868', '传记', '0', '存传记类', '0', '2020-04-13 11:23:13', '1', '2020-04-14 09:41:39', '1', '2', null);
INSERT INTO `t_info_goods_classify` VALUES ('2020041411231338868', '名人传记', '2020041311231338868', '都是名人的传记', '0', '2020-04-14 09:02:53', '1', '2020-04-14 09:41:39', '1', '3', null);
INSERT INTO `t_info_goods_classify` VALUES ('2020050318230104890', '文学', '0', '存放文学书', '0', '2020-05-03 18:23:01', '1', '2020-05-03 18:23:01', null, '0', '1');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318233253027', '中国现当代随笔', '2020050318230104890', '存放中国现当代随笔书', '0', '2020-05-03 18:23:32', '1', '2020-05-03 18:23:32', null, '0', '2');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318321820983', '中国古诗词', '2020050318230104890', '中国古诗词书', '0', '2020-05-03 18:32:18', '1', '2020-05-03 18:32:18', null, '0', '2');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318352019761', '人文社科', '0', '人文社科', '0', '2020-05-03 18:35:20', '1', '2020-05-03 18:35:20', null, '0', '1');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318355126828', '政治', '2020050318352019761', '政治', '0', '2020-05-03 18:35:51', '1', '2020-05-03 18:35:51', null, '0', '2');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318360463701', '军事', '2020050318352019761', '军事', '0', '2020-05-03 18:36:04', '1', '2020-05-03 18:36:04', null, '0', '2');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318422781840', '童书', '0', '童书', '0', '2020-05-03 18:42:27', '1', '2020-05-03 18:42:27', null, '0', '1');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318424294727', '少儿英语', '2020050318422781840', '少儿英语', '0', '2020-05-03 18:42:43', '1', '2020-05-03 18:42:43', null, '0', '2');
INSERT INTO `t_info_goods_classify` VALUES ('2020050318425899073', '科普', '2020050318422781840', '科普', '0', '2020-05-03 18:42:59', '1', '2020-05-03 18:43:07', '1', '1', '2');
INSERT INTO `t_info_goods_classify` VALUES ('2020050610462884726', '外国随笔', '2020050318230104890', '外国随笔', '0', '2020-05-06 10:46:28', '1', '2020-05-06 10:46:28', null, '0', '2');
INSERT INTO `t_info_goods_classify` VALUES ('gc2020032923520912512', '经典名著', '0', '各国经典名著', '0', '2020-03-29 23:52:12', '1', '2020-03-29 23:52:12', '1', '0', null);
INSERT INTO `t_info_goods_classify` VALUES ('gc2020033016110043259', '中国经典', 'gc2020032923520912512', '中国历史经典名著', '0', '2020-03-30 16:11:03', '1', '2020-03-30 16:11:03', '1', '0', null);

-- ----------------------------
-- Table structure for t_info_goods_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `t_info_goods_evaluate`;
CREATE TABLE `t_info_goods_evaluate` (
  `evaluate_id` varchar(40) NOT NULL COMMENT '评价编号',
  `evaluate_score` int(1) NOT NULL COMMENT '评分，1-5颗星星',
  `evaluate_content` varchar(1024) NOT NULL COMMENT '评价内容',
  `user_id` varchar(40) DEFAULT NULL COMMENT '评价的客户的编号',
  `goods_id` varchar(40) DEFAULT NULL COMMENT '评价的书是那本',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`evaluate_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='客户评价商品的信息存储表';

-- ----------------------------
-- Records of t_info_goods_evaluate
-- ----------------------------
INSERT INTO `t_info_goods_evaluate` VALUES ('2020042309400458958', '1', '坑钱玩意', '2020042209400417295', '2020041012102569960', '0', '2020-04-24 11:16:36', '1', '2020-04-24 11:18:21', null, '0', null);
INSERT INTO `t_info_goods_evaluate` VALUES ('2020050411313321714', '4', '真好看', '2020050316101232243', '2020050318304990632', '0', '2020-05-04 11:31:33', '2020050316101232243', '2020-05-04 11:31:33', '2020050316101232243', '0', '2020050400373024432');
INSERT INTO `t_info_goods_evaluate` VALUES ('2020050600205801018', '5', '非常好看', '2020050519403243875', '2020050318444837637', '0', '2020-05-06 00:20:58', '2020050519403243875', '2020-05-06 00:20:58', '2020050519403243875', '0', '2020050600193904740');
INSERT INTO `t_info_goods_evaluate` VALUES ('2020050602105182495', '2', '还行', '2020050519403243875', '2020050318491066009', '0', '2020-05-06 02:10:51', '2020050519403243875', '2020-05-06 02:10:51', '2020050519403243875', '0', '2020050602095841370');
INSERT INTO `t_info_goods_evaluate` VALUES ('2020050602115465295', '4', '1234', '2020050519403243875', '2020050318491066009', '0', '2020-05-06 02:11:54', '2020050519403243875', '2020-05-06 02:11:54', '2020050519403243875', '0', '2020050602111853222');
INSERT INTO `t_info_goods_evaluate` VALUES ('2020050610572172332', '4', '好看', '2020050610543590151', '2020050610473134013', '0', '2020-05-06 10:57:21', '2020050610543590151', '2020-05-06 10:57:21', '2020050610543590151', '0', '2020050610553452013');

-- ----------------------------
-- Table structure for t_info_hot_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_info_hot_goods`;
CREATE TABLE `t_info_hot_goods` (
  `hot_goods_id` varchar(40) NOT NULL DEFAULT '' COMMENT '热门商品编号',
  `hot_goods_num` int(8) NOT NULL COMMENT '排序，默认按浏览量多的在前',
  `goods_id` varchar(40) DEFAULT NULL COMMENT '商品编号',
  `start_time` datetime DEFAULT NULL COMMENT '有效期开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '有效期结束时间',
  `is_delete` int(1) NOT NULL COMMENT '删除标记',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` varchar(40) NOT NULL COMMENT '创建者',
  `update_time` datetime NOT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) NOT NULL COMMENT '版本号',
  PRIMARY KEY (`hot_goods_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='热门商品信息存储表';

-- ----------------------------
-- Records of t_info_hot_goods
-- ----------------------------
INSERT INTO `t_info_hot_goods` VALUES ('2020041012102569960', '0', '2020041012102569960', null, null, '0', '2020-04-16 10:57:14', '1', '2020-04-16 16:38:16', '1', '2');
INSERT INTO `t_info_hot_goods` VALUES ('2020050317185156783', '1', '2020043013101442844', null, null, '1', '2020-05-03 17:18:51', '1', '2020-05-03 17:38:41', '1', '2');
INSERT INTO `t_info_hot_goods` VALUES ('2020050610560853452', '1', '2020050318385557191', null, null, '0', '2020-05-06 10:56:08', '1', '2020-05-06 10:56:08', null, '0');

-- ----------------------------
-- Table structure for t_info_order
-- ----------------------------
DROP TABLE IF EXISTS `t_info_order`;
CREATE TABLE `t_info_order` (
  `order_id` varchar(40) NOT NULL COMMENT '订单的编号，编码有关下单时间',
  `store_id` varchar(40) DEFAULT NULL COMMENT '门店编号',
  `order_all_cost` double DEFAULT NULL COMMENT '订单总价',
  `order_state_id` int(1) DEFAULT NULL COMMENT '0表示已下单，1订单取消，2申请退货，3已取货，4表示已完成未评价，5已完成已评价',
  `pay_time` datetime DEFAULT NULL COMMENT '确认付款时间，全0表示未付款',
  `reduced_all_price` double DEFAULT NULL COMMENT '优惠金额',
  `order_comment` varchar(256) DEFAULT NULL COMMENT '订单备注',
  `recipient_name` varchar(40) DEFAULT NULL COMMENT '收件人姓名',
  `recipient_phone` varchar(15) DEFAULT NULL COMMENT '收件人电话',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `total_count` varchar(255) DEFAULT NULL,
  `pay_status` int(1) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL COMMENT '下订单人id',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='订单管理的表';

-- ----------------------------
-- Records of t_info_order
-- ----------------------------
INSERT INTO `t_info_order` VALUES ('2020050523455595153', '2020050421552209776', '38.8', '0', '2020-05-05 23:45:55', null, null, null, null, '0', '2020-05-05 23:45:55', '2020050519403243875', '2020-05-05 23:45:55', null, '0', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600193904740', '2020050421552209776', '101.1', '5', '2020-05-06 00:19:39', null, null, null, null, '0', '2020-05-06 00:19:39', '2020050519403243875', '2020-05-06 00:20:58', null, '4', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600463677743', '2020050421552209776', '95.2', '0', '2020-05-06 00:46:36', null, null, null, null, '0', '2020-05-06 00:46:36', '2020050519403243875', '2020-05-06 00:46:36', null, '0', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600471556592', '2020050421552209776', '101.1', '0', '2020-05-06 00:47:15', null, null, null, null, '0', '2020-05-06 00:47:15', '2020050519403243875', '2020-05-06 00:47:15', null, '0', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600474210667', '2020050421552209776', '101.1', '0', '2020-05-06 00:47:42', null, null, null, null, '0', '2020-05-06 00:47:42', '2020050519403243875', '2020-05-06 00:47:42', null, '0', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600480597972', '2020050421552209776', '111.4', '0', '2020-05-06 00:48:05', null, null, null, null, '0', '2020-05-06 00:48:05', '2020050519403243875', '2020-05-06 00:48:05', null, '0', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600483075686', '2020050421552209776', '116.39999999999999', '0', '2020-05-06 00:48:30', null, null, null, null, '0', '2020-05-06 00:48:30', '2020050519403243875', '2020-05-06 00:48:30', null, '0', '3', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600491336177', '2020050421552209776', '116.39999999999999', '1', '2020-05-06 00:49:13', null, null, null, null, '0', '2020-05-06 00:49:13', '2020050519403243875', '2020-05-06 00:49:51', '2020050519403243875', '1', '3', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600495872061', '2020050421552209776', '77.6', '0', '2020-05-06 00:49:58', null, null, null, null, '0', '2020-05-06 00:49:58', '2020050519403243875', '2020-05-06 00:49:58', null, '0', '2', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600501948841', '2020050421552209776', '116.39999999999999', '1', '2020-05-06 00:50:19', null, null, null, null, '0', '2020-05-06 00:50:19', '2020050519403243875', '2020-05-06 00:50:21', '2020050519403243875', '1', '3', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050600502838860', '2020050421552209776', '285.6', '2', '2020-05-06 00:50:28', null, null, null, null, '0', '2020-05-06 00:50:28', '2020050519403243875', '2020-05-06 09:47:06', '1', '2', '3', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050601331432253', '2020050421552209776', '196.3', '4', '2020-05-06 01:33:14', null, null, null, null, '0', '2020-05-06 01:33:14', '2020050519403243875', '2020-05-06 01:37:09', '2020050519403243875', '3', '2', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050602095841370', '2020050421552209776', '95.2', '5', '2020-05-06 02:09:58', null, null, null, null, '0', '2020-05-06 02:09:58', '2020050519403243875', '2020-05-06 02:10:51', null, '4', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050602111853222', '2020050421552209776', '95.2', '5', '2020-05-06 02:11:18', null, null, null, null, '0', '2020-05-06 02:11:18', '2020050519403243875', '2020-05-06 02:11:54', null, '4', '1', '0', '2020050519403243875');
INSERT INTO `t_info_order` VALUES ('2020050610553452013', '2020050610513437822', '50.2', '5', '2020-05-06 10:55:34', null, null, null, null, '0', '2020-05-06 10:55:34', '2020050610543590151', '2020-05-06 10:57:21', null, '4', '1', '0', '2020050610543590151');
INSERT INTO `t_info_order` VALUES ('2020050610575745021', '2020050610513437822', '159.1', '0', '2020-05-06 10:57:57', null, null, null, null, '0', '2020-05-06 10:57:57', '2020050610543590151', '2020-05-06 10:57:57', null, '0', '2', '0', '2020050610543590151');

-- ----------------------------
-- Table structure for t_info_order_deepen
-- ----------------------------
DROP TABLE IF EXISTS `t_info_order_deepen`;
CREATE TABLE `t_info_order_deepen` (
  `order_goods_id` varchar(40) NOT NULL COMMENT '订单详情编号',
  `order_id` varchar(40) NOT NULL COMMENT '订单的编号，编码有关下单时间',
  `goods_id` varchar(40) DEFAULT NULL COMMENT '商品编号',
  `goods_count` int(7) DEFAULT NULL COMMENT '书的数量',
  `reduced_price` double DEFAULT NULL COMMENT '优惠金额',
  `the_goods_all_price` double DEFAULT NULL COMMENT '这种书的总价',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_goods_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='订单详情表';

-- ----------------------------
-- Records of t_info_order_deepen
-- ----------------------------
INSERT INTO `t_info_order_deepen` VALUES ('2020050601331452818', '2020050601331432253', '2020050318491066009', '1', null, '95.2', '0', '2020-05-06 01:33:16', '2020050519403243875', '2020-05-06 01:33:16', null, '0', '2020050519403243875');
INSERT INTO `t_info_order_deepen` VALUES ('2020050601331452896', '2020050601331432253', '2020050318444837637', '1', null, '101.1', '0', '2020-05-06 01:33:16', '2020050519403243875', '2020-05-06 01:33:16', null, '0', '2020050519403243875');
INSERT INTO `t_info_order_deepen` VALUES ('2020050602095844348', '2020050602095841370', '2020050318491066009', '1', null, '95.2', '0', '2020-05-06 02:09:58', '2020050519403243875', '2020-05-06 02:09:58', null, '0', '2020050519403243875');
INSERT INTO `t_info_order_deepen` VALUES ('2020050602111853719', '2020050602111853222', '2020050318491066009', '1', null, '95.2', '0', '2020-05-06 02:11:18', '2020050519403243875', '2020-05-06 02:11:18', null, '0', '2020050519403243875');
INSERT INTO `t_info_order_deepen` VALUES ('2020050610553466494', '2020050610553452013', '2020050610473134013', '1', null, '50.2', '0', '2020-05-06 10:55:34', '2020050610543590151', '2020-05-06 10:55:34', null, '0', '2020050610543590151');
INSERT INTO `t_info_order_deepen` VALUES ('2020050610575745517', '2020050610575745021', '2020050318491066009', '1', null, '95.2', '0', '2020-05-06 10:57:57', '2020050610543590151', '2020-05-06 10:57:57', null, '0', '2020050610543590151');
INSERT INTO `t_info_order_deepen` VALUES ('2020050610575745599', '2020050610575745021', '2020050318385557191', '1', null, '63.9', '0', '2020-05-06 10:57:57', '2020050610543590151', '2020-05-06 10:57:57', null, '0', '2020050610543590151');

-- ----------------------------
-- Table structure for t_info_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_info_shopping_cart`;
CREATE TABLE `t_info_shopping_cart` (
  `shop_cart_id` varchar(40) NOT NULL COMMENT '购物车编号',
  `user_id` varchar(40) NOT NULL COMMENT '用户账号对应的编号',
  `goods_id` varchar(40) DEFAULT NULL COMMENT '商品编号',
  `cart_goods_count` int(7) DEFAULT NULL COMMENT '书的数量',
  `cart_all_price` double DEFAULT NULL COMMENT '这类书的总价',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`shop_cart_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='客户的购物车信息存储表';

-- ----------------------------
-- Records of t_info_shopping_cart
-- ----------------------------
INSERT INTO `t_info_shopping_cart` VALUES ('20200506001721763260', '2020050519403243875', '2020050318491066009', '1', null, '1', '2020-05-06 00:17:21', '2020050519403243875', '2020-05-06 00:46:36', '2020050519403243875', '1');
INSERT INTO `t_info_shopping_cart` VALUES ('20200506001731407079', '2020050519403243875', '2020050318444837637', '1', null, '1', '2020-05-06 00:17:31', '2020050519403243875', '2020-05-06 00:19:39', '2020050519403243875', '1');
INSERT INTO `t_info_shopping_cart` VALUES ('20200506002119983775', '2020050519403243875', '2020050318444837637', '1', null, '1', '2020-05-06 00:21:19', '2020050519403243875', '2020-05-06 00:47:15', '2020050519403243875', '1');
INSERT INTO `t_info_shopping_cart` VALUES ('20200506003117250115', '2020050519403243875', '2020050318473137738', '1', null, '1', '2020-05-06 00:31:17', '2020050519403243875', '2020-05-06 00:48:06', '2020050519403243875', '1');
INSERT INTO `t_info_shopping_cart` VALUES ('20200506005135238229', '2020050519403243875', '2020050318491066009', '1', null, '1', '2020-05-06 00:51:35', '2020050519403243875', '2020-05-06 01:33:17', '2020050519403243875', '1');
INSERT INTO `t_info_shopping_cart` VALUES ('20200506005141235310', '2020050519403243875', '2020050318444837637', '1', null, '1', '2020-05-06 00:51:41', '2020050519403243875', '2020-05-06 01:33:17', '2020050519403243875', '1');
INSERT INTO `t_info_shopping_cart` VALUES ('20200506105746148779', '2020050610543590151', '2020050318491066009', '1', null, '1', '2020-05-06 10:57:46', '2020050610543590151', '2020-05-06 10:57:57', '2020050610543590151', '1');
INSERT INTO `t_info_shopping_cart` VALUES ('20200506105751790754', '2020050610543590151', '2020050318385557191', '1', null, '1', '2020-05-06 10:57:51', '2020050610543590151', '2020-05-06 10:57:57', '2020050610543590151', '1');

-- ----------------------------
-- Table structure for t_info_slideshow_home
-- ----------------------------
DROP TABLE IF EXISTS `t_info_slideshow_home`;
CREATE TABLE `t_info_slideshow_home` (
  `slideshow_id` varchar(40) NOT NULL COMMENT '图片编号',
  `slideshow_num` int(8) NOT NULL COMMENT '排序',
  `slideshow_path` varchar(512) DEFAULT NULL COMMENT '图片路径',
  `start_time` datetime DEFAULT NULL COMMENT '有效期开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '有效期结束时间',
  `goods_id` varchar(40) NOT NULL COMMENT '商品编号',
  `slideshow_state_id` int(10) DEFAULT NULL COMMENT '0表示图片已禁用，1表示启用',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` varchar(10) DEFAULT NULL COMMENT '版本号',
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`slideshow_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='首页轮播图表';

-- ----------------------------
-- Records of t_info_slideshow_home
-- ----------------------------
INSERT INTO `t_info_slideshow_home` VALUES ('2020050114213924273', '1', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200501142131893466.png', '2020-05-01 00:00:00', '2020-05-03 00:00:00', '2020043013101442844', '1', '0', '2020-05-01 14:21:39', '1', '2020-05-01 21:56:06', '2020042209400417295', '6', null);
INSERT INTO `t_info_slideshow_home` VALUES ('2020050114394309292', '2', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200501143937516930.jpg', '2020-05-01 00:00:00', '2020-05-10 00:00:00', '2020041012102569960', '1', '0', '2020-05-01 14:39:43', '1', '2020-05-01 19:43:07', '2020042209400417295', '4', null);
INSERT INTO `t_info_slideshow_home` VALUES ('2020050610492384500', '3', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200506104913846550.png', '2020-05-06 00:00:00', '2020-05-09 00:00:00', '2020050610473134013', '1', '0', '2020-05-06 10:49:23', '1', '2020-05-06 10:49:23', null, '0', null);

-- ----------------------------
-- Table structure for t_info_store
-- ----------------------------
DROP TABLE IF EXISTS `t_info_store`;
CREATE TABLE `t_info_store` (
  `store_id` varchar(40) NOT NULL COMMENT '门店编号',
  `user_id` varchar(255) DEFAULT NULL COMMENT '店长的用户编号',
  `driver_id` varchar(40) DEFAULT NULL COMMENT '司机编号(用户编号)',
  `store_name` varchar(64) DEFAULT NULL COMMENT '门店名称',
  `phone` varchar(15) DEFAULT NULL COMMENT '门长联系电话',
  `business_code` varchar(16) DEFAULT NULL COMMENT '营业执照编码',
  `address` varchar(512) DEFAULT NULL COMMENT '详细地址',
  `invite_code` varchar(64) DEFAULT NULL COMMENT '邀请码',
  `province_id` varchar(20) DEFAULT NULL COMMENT '省名称',
  `city_id` varchar(20) NOT NULL COMMENT '对应的市的名称',
  `area_id` varchar(20) NOT NULL COMMENT '区/县的名称',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`store_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='门店信息表';

-- ----------------------------
-- Records of t_info_store
-- ----------------------------
INSERT INTO `t_info_store` VALUES ('2020041710501958712', '2020041615571659234', null, '行走书店', '110', '120', '潮安县', 'YQM001', '0', '0', '1', '0', '2020-04-17 10:50:19', '1', '2020-04-17 16:21:25', '1', '2');
INSERT INTO `t_info_store` VALUES ('2020050315231764638', '2020050315062816444', null, '潮州书店', '13074214558', '110', '枫溪车头', '754791', '123', '2', '3', '0', '2020-05-03 15:23:17', '1', '2020-05-03 15:37:08', '1', '2');
INSERT INTO `t_info_store` VALUES ('2020050421552209776', '2020050421523502560', null, '汕头书店', '130', '120', '苏宁广场', '393023', '123', '4', '5', '0', '2020-05-04 21:55:22', '1', '2020-05-04 21:55:22', null, '0');
INSERT INTO `t_info_store` VALUES ('2020050610513437822', '2020050610453236661', null, '揭阳书店', '130', '12000', '揭东大', '226999', '123', '6', '7', '0', '2020-05-06 10:51:34', '1', '2020-05-06 10:51:46', '1', '1');

-- ----------------------------
-- Table structure for t_sys_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_customer`;
CREATE TABLE `t_sys_customer` (
  `customer_id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL,
  `invitation_code` varchar(64) DEFAULT NULL,
  `is_delete` int(1) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `create_user` varchar(64) DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  `update_user` varchar(64) DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_customer
-- ----------------------------
INSERT INTO `t_sys_customer` VALUES ('2020042209400417413', '2020042209400417295', 'YQM001', '0', '2020-04-22', '2020042209400417295', '2020-04-22', '2020042209400417295', '0');
INSERT INTO `t_sys_customer` VALUES ('2020042314353138214', '2020041615571659234', 'YQM001', '0', '2020-04-24', '2020042417172843728', '2020-04-28', '2020042314353138214', '2');
INSERT INTO `t_sys_customer` VALUES ('2020050316101232438', '2020050316101232243', '754791', '0', '2020-05-03', '2020050316101232243', '2020-05-03', '2020050316101232243', '0');
INSERT INTO `t_sys_customer` VALUES ('2020050519403243972', '2020050519403243875', '393023', '0', '2020-05-05', '2020050519403243875', '2020-05-05', '2020050519403243875', '1');
INSERT INTO `t_sys_customer` VALUES ('2020050610543591881', '2020050610543590151', '226999', '0', '2020-05-06', '2020050610543590151', '2020-05-06', '2020050610543590151', '0');

-- ----------------------------
-- Table structure for t_sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dictionary`;
CREATE TABLE `t_sys_dictionary` (
  `id` varchar(40) NOT NULL COMMENT 'UUID',
  `dict_value` varchar(40) DEFAULT NULL COMMENT '字段值',
  `dict_name` varchar(64) DEFAULT NULL COMMENT '字段名称',
  `dict_type` varchar(64) DEFAULT NULL COMMENT '字段类型',
  `parent_code` varchar(40) DEFAULT NULL COMMENT '父级代码，标注上一级',
  `public_type` int(11) DEFAULT NULL COMMENT '公用类型，字段值',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `sort_num` int(11) NOT NULL COMMENT '序号',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='字典表';

-- ----------------------------
-- Records of t_sys_dictionary
-- ----------------------------
INSERT INTO `t_sys_dictionary` VALUES ('0', '6', 'hotGoodsShowNumber', null, '', null, null, '0', '0', null, null, '2020-04-16 16:33:12', '1', '1');

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `menu_id` varchar(40) NOT NULL COMMENT '菜单编号',
  `menu_name` varchar(40) DEFAULT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) DEFAULT NULL COMMENT '菜单路由，多级菜单中体现',
  `menu_comment` varchar(256) DEFAULT NULL COMMENT '菜单备注',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `is_manager` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单表';

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------
INSERT INTO `t_sys_menu` VALUES ('2020040923295061794', '用户管理', '/user-manage', '用户管理', '0', '2020-04-09 23:29:50', '1', '2020-04-29 23:10:29', '2020042209400417295', '5', '0');
INSERT INTO `t_sys_menu` VALUES ('2020041010141872948', '菜单管理', '/menu-manage', '管理全系统菜单', '0', '2020-04-10 10:14:18', '1', '2020-04-10 10:20:36', '1', '1', '0');
INSERT INTO `t_sys_menu` VALUES ('2020042214573212871', '商品管理', '/comm-manage', null, '0', '2020-04-22 14:57:32', '1', '2020-04-22 14:57:32', null, '0', '0');
INSERT INTO `t_sys_menu` VALUES ('2020042214575645574', '首页轮播图管理', '/home-pic-manage', null, '0', '2020-04-22 14:57:56', '1', '2020-04-22 14:57:56', null, '0', '0');
INSERT INTO `t_sys_menu` VALUES ('2020042214581671099', '商品分类管理', '/comm-classify-manage', null, '0', '2020-04-22 14:58:16', '1', '2020-04-22 14:58:16', null, '0', '0');
INSERT INTO `t_sys_menu` VALUES ('2020042214583765632', '客户管理', '/client-manage', null, '0', '2020-04-22 14:58:37', '1', '2020-04-22 14:58:37', null, '0', '1');
INSERT INTO `t_sys_menu` VALUES ('2020042214590268372', '热门商品管理', '/hot-comm-manage', null, '0', '2020-04-22 14:59:02', '1', '2020-04-22 14:59:02', null, '0', '0');
INSERT INTO `t_sys_menu` VALUES ('2020042214591619301', '门店管理', '/shop-info-manage', null, '0', '2020-04-22 14:59:16', '1', '2020-04-22 14:59:16', null, '0', '1');
INSERT INTO `t_sys_menu` VALUES ('2020042214592948592', '司机管理', '/driver-info-manage', null, '0', '2020-04-22 14:59:29', '1', '2020-04-22 14:59:29', null, '0', '1');
INSERT INTO `t_sys_menu` VALUES ('2020042214594463095', '订单管理', '/order-manage', null, '0', '2020-04-22 14:59:44', '1', '2020-04-22 14:59:44', null, '0', '1');
INSERT INTO `t_sys_menu` VALUES ('2020050609462938932', 'test', '/test', '', '1', '2020-05-06 09:46:29', '1', '2020-05-06 09:46:33', '1', '1', null);
INSERT INTO `t_sys_menu` VALUES ('2020050610455677048', 'test', 'test', '', '0', '2020-05-06 10:45:56', '1', '2020-05-06 10:45:56', null, '0', null);

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `user_id` varchar(40) NOT NULL COMMENT '用户编码',
  `user_acct` varchar(40) DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `user_name` varchar(40) DEFAULT NULL COMMENT '用户姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别 男1女0',
  `phone` varchar(40) NOT NULL COMMENT '用户手机号',
  `mail` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `idcard` varchar(40) DEFAULT NULL COMMENT '身份证',
  `role_id` varchar(5) DEFAULT NULL COMMENT '角色 超级管理员0，管理员1，店长2，司机3，客户4',
  `is_delete` int(1) DEFAULT NULL COMMENT '删除标记，1是0否',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(40) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  `update_user` varchar(40) DEFAULT NULL COMMENT '更改者',
  `version` int(10) DEFAULT NULL COMMENT '版本号',
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('2020041615571659234', 'dianzhang', '$2a$10$QW17MwSnfc512.hmlONFxeHtoLjW6f8mZEeWL1cTghR2M0hYpoaam', 'dianzhang', '0', '13076478390', '605057758@qq.com', '445101199810090808', '2', '0', '2020-04-16 15:57:16', '1', '2020-04-30 10:38:24', '1', '4', 'tengxunyun');
INSERT INTO `t_sys_user` VALUES ('2020042209400417295', 'admin', '$2a$10$mHdS8BdR/4/WaTZ0ATV0WONXk5gE1Ot2hEM0asnveNd.i7DzGyJ8m', 'admin', '0', '13074214554', '605057753@qq.com', '445121', '0', '0', '2020-04-22 09:40:04', '2020042209400417295', '2020-04-22 22:26:16', '2020042209400417295', '2', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200422114713086077.jpg');
INSERT INTO `t_sys_user` VALUES ('2020042314353138214', 'guke', '$2a$10$SWC4ucizOx223PhLHFN2teBhlzed.RDEfBg0T8EYQNTfFSjNEjxRW', 'linxianghang', '0', '13055', '6050', '445121199906162555', '4', '0', '2020-04-23 14:35:31', '1', '2020-04-23 14:35:31', null, '0', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200422114713086077.jpg');
INSERT INTO `t_sys_user` VALUES ('2020042710143719591', 'siji', '$2a$10$Q7qX/EOpCCALRKH8ebyX2esDJc/LmghToaG.nuyu0eygp7cY9uRA6', '19700', '0', '13076541', '605', '445191199505050606', '3', '0', '2020-04-27 10:14:37', '1', '2020-05-02 11:59:11', '2020041615571659234', '1', null);
INSERT INTO `t_sys_user` VALUES ('2020043010375537585', 'guanliyuan', '$2a$10$IhvYpD8/CcZPFwKLgmFEbu7XyoIksRkyt0abx21hkTEC6lH0N0aSu', 'guanliyuan', '1', '13690048331', '136900@qq.com', '445191199710080907', '1', '0', '2020-04-30 10:37:55', '1', '2020-04-30 10:37:55', null, '0', '');
INSERT INTO `t_sys_user` VALUES ('2020050315062816444', 'czsd', '$2a$10$FIm7XFIB1nZfFRS3RLhSU.dcG6t4uWbvlKA8IOH.DosFenbFNrviS', '店长', '1', '13074542111', '5050', '445121199712030630', '2', '0', '2020-05-03 15:06:28', '1', '2020-05-03 15:06:28', null, '0', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200503150620893423.jpg');
INSERT INTO `t_sys_user` VALUES ('2020050316101232243', 'yonghu', '$2a$10$DP4MQFYCGf1a7uu7QgDAnOp/2SWcuwA3S20dNxc7t8Fr.5FXVEs.C', '用户', '1', '130', '60', '445181199805050101', '4', '0', '2020-05-03 16:10:12', '2020050316101232243', '2020-05-03 16:10:12', null, '0', null);
INSERT INTO `t_sys_user` VALUES ('2020050421523502560', 'stsd', '$2a$10$tIhbFV4DoP.J8jfWkQIiQOIeP.aUqVV50scdC3guWtfPXXIyqss/O', '汕头书店', '0', '13074214554', '1025@qq.com', '445121199705162010', '2', '0', '2020-05-04 21:52:35', '1', '2020-05-04 21:52:35', null, '0', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200504215232148075.jpg');
INSERT INTO `t_sys_user` VALUES ('2020050519213383348', 'stsdsj', '$2a$10$sSmmgFb/LGady1Al7xhFT.4z7oeYPZSRlfLzTQ55Wl1NR/ZFPqXm6', '汕头书店司机', null, '130', null, '445111199805192010', '3', '0', '2020-05-05 19:21:34', '2020050421523502560', '2020-05-05 19:21:34', null, '0', '');
INSERT INTO `t_sys_user` VALUES ('2020050519403243875', 'stsdyh', '$2a$10$S6HTbXdDCtJLVtet.OBmReI8m1oTb5gBjjXd.XZXGzR8KKnnSwAhG', '汕头书店用户', '0', '13055869', '60505@qq.com', '445121199505162020', '4', '0', '2020-05-05 19:40:32', '2020050519403243875', '2020-05-05 19:40:32', null, '0', null);
INSERT INTO `t_sys_user` VALUES ('2020050608513692593', '60505889', '$2a$10$MzNsFvEq1yA/EodOzKZY1udCVxo/A774ws8m/QqZO4z/EWvdKuXfO', 'test', '0', '13076478390', '7070', '445181199805050606', '2', '1', '2020-05-06 08:51:37', '1', '2020-05-06 08:54:28', '1', '1', '');
INSERT INTO `t_sys_user` VALUES ('2020050610453236661', 'jysddz', '$2a$10$xm2XVwRBRY9QOBDIbwGGYexAW6TugE9kaG0eTSKNjaJJ/Rge2jHh.', '揭阳书店', '0', '140', '605057753@qq.com', '445181199805050606', '2', '0', '2020-05-06 10:45:32', '1', '2020-05-06 10:45:42', '1', '1', 'http://walkbookstore-1301706845.cos.ap-guangzhou.myqcloud.com/20200506104529050782.jpg');
INSERT INTO `t_sys_user` VALUES ('2020050610522346023', 'jysdsj', '$2a$10$XtxKWiJ/XaN7fP7IwBUf7.h40DoLmanCx.kpfrFkqZiKv669I8KMi', '揭阳书店司机', null, '13055', null, '445181199705060506', '3', '0', '2020-05-06 10:52:23', '2020042209400417295', '2020-05-06 10:52:23', null, '0', '');
INSERT INTO `t_sys_user` VALUES ('2020050610543590151', 'jysdyh', '$2a$10$jEGbwFbS2a.fqJ1eoxW63Oez6D3VSadrTHi8LPoJdTcDvmK9y81T2', '揭阳书店用户', '0', '1500000000', '50505@qq.com', '445171199709090909', '4', '0', '2020-05-06 10:54:36', '2020050610543590151', '2020-05-06 10:54:36', null, '0', null);
