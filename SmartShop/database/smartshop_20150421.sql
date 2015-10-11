/*
Navicat MySQL Data Transfer

Source Server         : zhongjian
Source Server Version : 50624
Source Host           : 61.183.216.130:3306
Source Database       : smartshop

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-04-21 10:58:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '地址对应的用户',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `isDefault` bit(1) NOT NULL DEFAULT b'0' COMMENT '该地址是否为默认地址',
  `name` varchar(255) DEFAULT '' COMMENT '收货人姓名',
  `telephone` varchar(255) DEFAULT '' COMMENT '收货人电话',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8 COMMENT='送货地址';

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('24', '28', '湖北省武汉市洪山区珞瑜路华中科技大学', '', '黄国宝', '18627799562');
INSERT INTO `address` VALUES ('25', '28', '江苏省南京市 秦淮区 中华路9号', '', '黄国宝', '18627799562');
INSERT INTO `address` VALUES ('26', '28', '湖北省武汉市洪山区珞瑜路华中科技大学', '', '黄国宝', '18627799562');
INSERT INTO `address` VALUES ('27', '28', '湖北省武汉市洪山区珞瑜路华中科技大学', '', '黄国宝', '18627799562');
INSERT INTO `address` VALUES ('28', '28', '江苏省南京市 秦淮区 中华路9号', '', '黄国宝', '18627799562');
INSERT INTO `address` VALUES ('39', '28', '江苏省南京市 秦淮区 中华路9号', '', '黄国宝', '18627799562');
INSERT INTO `address` VALUES ('40', '28', '江苏省南京市 秦淮区 中华路9号', '', '黄国宝', '123');
INSERT INTO `address` VALUES ('43', '28', 'hust', '', 'test', '18627799562');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `num` int(11) NOT NULL DEFAULT '1',
  `product_description` varchar(255) NOT NULL DEFAULT '无' COMMENT '商品类别属性价格等',
  `total_price` float NOT NULL DEFAULT '0',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('22', '28', '168', '10', '金龙鱼海洋鱼油调和油1.8l 36.8元', '36.8', '2015-04-19 21:05:18');
INSERT INTO `cart` VALUES ('25', '28', '171', '2', '王老吉凉茶310ML 3.9元', '3.9', '2015-04-20 10:19:55');
INSERT INTO `cart` VALUES ('26', '28', '170', '1', '黑人炭丝深洁牙刷2支特惠装 11.7元', '11.7', '2015-04-20 10:59:06');
INSERT INTO `cart` VALUES ('27', '28', '173', '2', '爱之佳大号垃圾袋55*60cm（1*50） 14.9元', '14.9', '2015-04-20 18:50:29');

-- ----------------------------
-- Table structure for `collect`
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `collect_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `collect_ibfk_2` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('15', '28', '24', '2015-04-20 10:58:14');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '评论的商品',
  `user_id` int(11) NOT NULL COMMENT '评论人',
  `comment_type_id` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL COMMENT '评论内容',
  `append` varchar(255) DEFAULT NULL COMMENT '追加评价',
  `time` datetime NOT NULL COMMENT '评论时间',
  `append_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `user_id_foreign` (`user_id`),
  KEY `comment_type_id` (`comment_type_id`),
  CONSTRAINT `comment_type_id` FOREIGN KEY (`comment_type_id`) REFERENCES `comment_type` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `comment_type`
-- ----------------------------
DROP TABLE IF EXISTS `comment_type`;
CREATE TABLE `comment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_type
-- ----------------------------
INSERT INTO `comment_type` VALUES ('1', '好评');
INSERT INTO `comment_type` VALUES ('2', '中评');
INSERT INTO `comment_type` VALUES ('3', '差评');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`) USING BTREE,
  CONSTRAINT `image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('74', '168', '../images/product/jinlongyu/1234567.png', '2015-04-17 17:20:54');
INSERT INTO `image` VALUES ('75', '168', '../images/product/jinlongyu/12345678.png', '2015-04-17 17:20:54');
INSERT INTO `image` VALUES ('76', '169', '../images/product/haitian500ml/1691100224155_1000.jpg', '2015-04-17 18:49:50');
INSERT INTO `image` VALUES ('77', '169', '../images/product/haitian500ml/1691100224156_1000.jpg', '2015-04-17 18:49:50');
INSERT INTO `image` VALUES ('78', '170', '../images/product/heiren/1701100235198_1000.jpg', '2015-04-17 18:53:10');
INSERT INTO `image` VALUES ('79', '170', '../images/product/heiren/17020150417185134.jpg', '2015-04-17 18:53:10');
INSERT INTO `image` VALUES ('80', '171', '../images/product/wanglaoji/1711100230382_1000.jpg', '2015-04-17 18:54:23');
INSERT INTO `image` VALUES ('81', '171', '../images/product/wanglaoji/1711100230383_1000.jpg', '2015-04-17 18:54:23');
INSERT INTO `image` VALUES ('83', '173', '../images/product/aizhijia/1731100222461_1000.jpg', '2015-04-17 18:58:41');
INSERT INTO `image` VALUES ('84', '173', '../images/product/xuehua/1731100222462_1000.jpg', '2015-04-17 18:58:41');
INSERT INTO `image` VALUES ('85', '174', '../images/product/xuehua/1741100208647_1000.jpg', '2015-04-17 19:00:34');
INSERT INTO `image` VALUES ('86', '174', '../images/product/xuehua/1741100208648_1000.jpg', '2015-04-17 19:00:34');
INSERT INTO `image` VALUES ('87', '174', '../images/product/xuehua/1741100208649_400.jpg', '2015-04-17 19:00:34');
INSERT INTO `image` VALUES ('89', '176', '../images/product/xinxin/1761100186573_1000.jpg', '2015-04-17 19:03:08');
INSERT INTO `image` VALUES ('90', '177', '../images/product/baiyun/1771100150439_1000.jpg', '2015-04-17 19:05:58');
INSERT INTO `image` VALUES ('91', '177', '../images/product/baiyun/1771100150440_1000.jpg', '2015-04-17 19:05:58');
INSERT INTO `image` VALUES ('92', '178', '../images/product/aizhijia/1781100200078_1000.jpg', '2015-04-17 19:07:47');
INSERT INTO `image` VALUES ('93', '178', '../images/product/aizhijia/1781100200079_1000.jpg', '2015-04-17 19:07:47');
INSERT INTO `image` VALUES ('94', '178', '../images/product/shuita/1781100200080_1000.jpg', '2015-04-17 19:07:47');
INSERT INTO `image` VALUES ('95', '179', '../images/product/shuita/1791100220228_400.jpg', '2015-04-17 19:09:42');
INSERT INTO `image` VALUES ('96', '180', '../images/product/jinlongyu/1801100186569_1000.jpg', '2015-04-17 19:11:27');
INSERT INTO `image` VALUES ('97', '180', '../images/product/jinlongyu/1801100226074_1000.jpg', '2015-04-17 19:11:27');
INSERT INTO `image` VALUES ('98', '180', '../images/product/jinlongyu/1801100226075_1000.jpg', '2015-04-17 19:11:27');
INSERT INTO `image` VALUES ('99', '181', '../images/product/aizhijia/1811100223161_1000.jpg', '2015-04-17 19:13:10');
INSERT INTO `image` VALUES ('100', '181', '../images/product/aizhijia/1811100223162_1000.jpg', '2015-04-17 19:13:10');
INSERT INTO `image` VALUES ('101', '181', '../images/product/aizhijia/1811100223163_1000.jpg', '2015-04-17 19:13:10');
INSERT INTO `image` VALUES ('102', '182', '../images/product/aizhijia/1821100215043_1000.jpg', '2015-04-17 19:15:10');
INSERT INTO `image` VALUES ('103', '183', '../images/product//hangao/1831100219409_1000.jpg', '2015-04-17 19:17:32');
INSERT INTO `image` VALUES ('104', '183', '../images/product/hangao/1831100219410_1000.jpg', '2015-04-17 19:17:32');
INSERT INTO `image` VALUES ('105', '184', '../images/product/nongfu/1841100201788_1000.jpg', '2015-04-17 19:19:28');
INSERT INTO `image` VALUES ('106', '184', '../images/product/nongfu/1841100201789_1000.jpg', '2015-04-17 19:19:28');
INSERT INTO `image` VALUES ('107', '184', '../images/product/nongfu/1841100201791_1000.jpg', '2015-04-17 19:19:28');
INSERT INTO `image` VALUES ('108', '184', '../images/product/nongfu/1841100201792_1000.jpg', '2015-04-17 19:19:28');
INSERT INTO `image` VALUES ('109', '185', '../images/product/baiwei/1851100222210_1000.jpg', '2015-04-17 19:22:01');
INSERT INTO `image` VALUES ('110', '185', '../images/product/baiwei/1851100222211_1000.jpg', '2015-04-17 19:22:01');
INSERT INTO `image` VALUES ('111', '186', '../images/product/yunnan/1861100236146_1000.jpg', '2015-04-17 19:25:57');
INSERT INTO `image` VALUES ('112', '186', '../images/product/yunnan/1861100236147_1000.jpg', '2015-04-17 19:25:57');
INSERT INTO `image` VALUES ('113', '187', '../images/product/xinxin/1871100186631_1000.jpg', '2015-04-17 19:28:19');
INSERT INTO `image` VALUES ('114', '187', '../images/product/xinxin/1871100186633_1000.jpg', '2015-04-17 19:28:19');
INSERT INTO `image` VALUES ('115', '187', '../images/product/xinxin/1871100186634_1000.jpg', '2015-04-17 19:28:19');
INSERT INTO `image` VALUES ('116', '189', '../images/product/qingyang/1891100236201_1000.jpg', '2015-04-17 19:31:52');
INSERT INTO `image` VALUES ('117', '189', '../images/product/qingyang/1891100236202_1000.jpg', '2015-04-17 19:31:52');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(255) NOT NULL COMMENT '订单号',
  `shop_id` int(11) NOT NULL COMMENT '卖家',
  `user_id` int(11) NOT NULL COMMENT '买家',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '交易收货地址',
  `telephone` varchar(50) NOT NULL DEFAULT '' COMMENT '买家电话',
  `total_price` float NOT NULL DEFAULT '0' COMMENT '交易价格',
  `order_time` datetime NOT NULL COMMENT '订单产生日期',
  `recipient` varchar(255) NOT NULL DEFAULT '' COMMENT '收件人',
  `receipt_state` int(11) DEFAULT '0' COMMENT '收货状态',
  `confirmed` bit(1) DEFAULT b'0' COMMENT '是否已经接收',
  PRIMARY KEY (`id`),
  KEY `order_number` (`order_number`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('36', '3985401873', '24', '2', 'huazhongkeji', '13006106187', '0', '2015-04-19 17:13:48', '', '0', '');
INSERT INTO `orders` VALUES ('37', '5654646553', '24', '2', 'huazhongkeji', '13006106187', '5.1', '2015-04-19 17:19:10', '', '0', '');
INSERT INTO `orders` VALUES ('38', '1303173797', '24', '2', 'huake', '13006106187', '88.9', '2015-04-20 13:02:55', 'yangjunlei', '0', '');
INSERT INTO `orders` VALUES ('39', '3465985674', '24', '2', 'huake', '13006106187', '88.9', '2015-04-20 13:08:45', 'yangjunlei', '0', '');
INSERT INTO `orders` VALUES ('40', '7704270727', '24', '2', 'huake', '13006106187', '88.9', '2015-04-20 13:10:58', 'yangjunlei', '0', '');
INSERT INTO `orders` VALUES ('41', '2045418368', '24', '2', 'huake', '13006106187', '130.8', '2015-04-20 14:31:51', 'yangjunlei', '0', '');
INSERT INTO `orders` VALUES ('42', '2839965618', '24', '2', 'huake', '13006106187', '130.8', '2015-04-20 14:33:20', 'yangjunlei', '0', '');
INSERT INTO `orders` VALUES ('43', '8012729369', '24', '28', '湖北省武汉市洪山区珞瑜路华中科技大学', '18627799562', '375.8', '2015-04-20 17:32:42', '黄国宝', '0', '');
INSERT INTO `orders` VALUES ('44', '4806063007', '24', '28', '湖北省武汉市洪山区珞瑜路华中科技大学', '18627799562', '5.1', '2015-04-20 18:29:50', '黄国宝', '0', '');
INSERT INTO `orders` VALUES ('45', '1134699199', '24', '28', '湖北省武汉市洪山区珞瑜路华中科技大学', '18627799562', '417.3', '2015-04-20 20:10:25', '黄国宝', '0', '');

-- ----------------------------
-- Table structure for `orders_product`
-- ----------------------------
DROP TABLE IF EXISTS `orders_product`;
CREATE TABLE `orders_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(255) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL DEFAULT '',
  `number` int(11) NOT NULL DEFAULT '1',
  `price` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `order_number` (`order_number`),
  CONSTRAINT `orders_product_ibfk_1` FOREIGN KEY (`order_number`) REFERENCES `orders` (`order_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders_product
-- ----------------------------
INSERT INTO `orders_product` VALUES ('7', '3985401873', '169', '海天铁强化老抽酱油500ml', '1', '5.1');
INSERT INTO `orders_product` VALUES ('8', '5654646553', '169', '海天铁强化老抽酱油500ml', '1', '5.1');
INSERT INTO `orders_product` VALUES ('9', '3465985674', '168', '金1鱼海洋鱼油调和油', '2', '36.8');
INSERT INTO `orders_product` VALUES ('10', '3465985674', '169', 'hai海天铁强化老抽酱油500ml', '3', '5.1');
INSERT INTO `orders_product` VALUES ('11', '7704270727', '168', '金1鱼海洋鱼油调和油', '2', '36.8');
INSERT INTO `orders_product` VALUES ('12', '7704270727', '169', 'hai海天铁强化老抽酱油500ml', '3', '5.1');
INSERT INTO `orders_product` VALUES ('13', '2045418368', '168', '金1鱼海洋鱼油调和油', '3', '36.8');
INSERT INTO `orders_product` VALUES ('14', '2045418368', '169', 'hai海天铁强化老抽酱油500ml', '4', '5.1');
INSERT INTO `orders_product` VALUES ('15', '2839965618', '168', '金1鱼海洋鱼油调和油', '3', '36.8');
INSERT INTO `orders_product` VALUES ('16', '2839965618', '169', 'hai海天铁强化老抽酱油500ml', '4', '5.1');
INSERT INTO `orders_product` VALUES ('17', '8012729369', '168', '金1鱼海洋鱼油调和油', '10', '36.8');
INSERT INTO `orders_product` VALUES ('18', '8012729369', '171', '王老吉凉茶310ML', '2', '3.9');
INSERT INTO `orders_product` VALUES ('19', '4806063007', '169', 'hai海天铁强化老抽酱油500ml', '1', '5.1');
INSERT INTO `orders_product` VALUES ('20', '1134699199', '168', '金1鱼海洋鱼油调和油', '10', '36.8');
INSERT INTO `orders_product` VALUES ('21', '1134699199', '170', '黑人炭丝深洁牙刷2支特惠装', '1', '11.7');
INSERT INTO `orders_product` VALUES ('22', '1134699199', '171', '王老吉凉茶310ML', '2', '3.9');
INSERT INTO `orders_product` VALUES ('23', '1134699199', '173', '爱之佳大号垃圾袋', '2', '14.9');

-- ----------------------------
-- Table structure for `orders_property_value`
-- ----------------------------
DROP TABLE IF EXISTS `orders_property_value`;
CREATE TABLE `orders_property_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(255) NOT NULL,
  `property_value` varchar(255) NOT NULL DEFAULT '',
  `property` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `order_number` (`order_number`),
  CONSTRAINT `orders_property_value_ibfk_1` FOREIGN KEY (`order_number`) REFERENCES `orders` (`order_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders_property_value
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL COMMENT '所在店铺',
  `name` varchar(255) NOT NULL COMMENT '商品名',
  `type_id` int(11) NOT NULL COMMENT '商品类型',
  `price` float NOT NULL,
  `simple_description` varchar(255) NOT NULL DEFAULT '',
  `complex_description` varchar(255) NOT NULL DEFAULT '',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shop_id` (`shop_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `shop_id` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `product_type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('168', '24', '金1鱼海洋鱼油调和油', '4', '36.8', '金龙鱼海洋鱼油调和油1.8l', '【品牌 】：金龙鱼\r\n【产品名称 】：金龙鱼海洋鱼油调和油1.8l\r\n【产地 】：广东省深圳市\r\n【包装 】：瓶\r\n【国产/进口 】：国产\r\n【类型 】：调和油', '2015-04-17 17:20:55');
INSERT INTO `product` VALUES ('169', '24', 'hai海天铁强化老抽酱油500ml', '8', '5.1', '海天铁强化老抽酱油500ml', '【品牌 】：海天\r\n【产地 】：广东省佛山市\r\n【品名 】：海天铁强化老抽酱油500ml\r\n【包装 】：瓶\r\n【国产/进口 】：国产', '2015-04-17 18:49:50');
INSERT INTO `product` VALUES ('170', '24', '黑人炭丝深洁牙刷2支特惠装', '11', '11.7', '黑人炭丝深洁牙刷2支特惠装', '【产品名称】：黑人炭丝深洁牙刷2支特惠装\r\n【商品品牌】：黑人 \r\n【商品产地】：广东省中山市\r\n【产品规格】：2支装\r\n【包装方式】：盒装\r\n【商品类型】：牙刷套装', '2015-04-17 18:53:11');
INSERT INTO `product` VALUES ('171', '24', '王老吉凉茶310ML', '5', '3.9', '王老吉凉茶310ML', '【商品名称】：王老吉凉茶310ML\r\n【品牌】：王老吉\r\n【规格】：310ml\r\n【包装】：听装\r\n【产地】：广州\r\n【成分】：水、白砂糖、仙草、鸡蛋花、菊花、金银花、甘草等\r\n【国产/进口】：国产\r\n【保质期】：24个月\r\n【储藏方法】：常温或冷藏', '2015-04-17 18:54:23');
INSERT INTO `product` VALUES ('173', '24', '爱之佳大号垃圾袋', '6', '14.9', '爱之佳大号垃圾袋55*60cm（1*50）', '【品牌 】：爱之佳\r\n【产品名称 】：爱之佳大号垃圾袋55*60cm（1*50）\r\n【产地 】：湖北省武汉市\r\n【类型 】：垃圾袋', '2015-04-17 18:58:41');
INSERT INTO `product` VALUES ('174', '24', '雪花啤酒清爽8度', '9', '2.5', '雪花啤酒清爽8度330ml', '【商品名称】：雪花啤酒清爽8度330ml\r\n【商品产地】：湖北省天门市\r\n【贮存条件】：5℃-25℃干燥避光贮运\r\n【产品规格】：330ml\r\n【保 质 期】：360天\r\n【产品配料】：水、麦芽、大米、淀粉、酒花', '2015-04-17 19:00:34');
INSERT INTO `product` VALUES ('176', '24', '心相印茶语系列软抽', '7', '15', '心相印茶语系列软抽200抽*3盒', '产品名称：心相印茶语系列软抽200抽*3盒\r\n品牌	：心相印\r\n产地	：福建省晋江市\r\n保质期：3年\r\n成分	：原生木浆\r\n香型	：茶香\r\n层数	：2层\r\n规格	：200抽', '2015-04-17 19:03:08');
INSERT INTO `product` VALUES ('177', '24', '白云边珍藏十二年42度', '9', '118', '白云边珍藏十二年42度500ml', '【品名】：白云边珍藏十二年500ml\r\n【配料表】：水、小麦、高粱等\r\n【储藏方法】：常温保存\r\n【净含量】：500ml \r\n【酒精度】：42%vol\r\n【加工工艺】：纯粮固态发酵', '2015-04-17 19:05:59');
INSERT INTO `product` VALUES ('178', '24', '爱之佳经济装保鲜膜', '6', '15', '爱之佳经济装保鲜膜30*10000cm', '【产品名称】：爱之佳经济装保鲜膜30*10000cm \r\n【商品材质】：PE\r\n【保  质  期】：5年\r\n【商品规格】：30*10000cm \r\n【商品特色】：\r\n1．保鲜膜覆盖食品器皿，免受细菌感染。\r\n2．包裹食品，方便保存（例如：三明治）。 　　\r\n3．把以保鲜膜覆盖的汤碗冷藏，可隔去汤里的油。 ', '2015-04-17 19:07:48');
INSERT INTO `product` VALUES ('179', '24', '水塔老陈醋', '8', '6.6', '水塔老陈醋420ml', '【品牌 】：水塔\r\n【产品名称 】：水塔老陈醋420ml\r\n【产地 】：山西省太原市\r\n【国产/进口 】：国产\r\n【类型 】：陈醋', '2015-04-17 19:09:43');
INSERT INTO `product` VALUES ('180', '24', '金龙鱼优质东北大米', '4', '37.9', '金龙鱼优质东北大米5kg', '【商品品牌】：金龙鱼\r\n【商品名称】：金龙鱼优质东北大米5kg\r\n【商品含量】：5kg\r\n【商品配料】：粳米\r\n【保  质  期】：12个月\r\n【储存条件】：请置于阴凉干燥处，避免阳光直接照射，拆包后请尽快食用。', '2015-04-17 19:11:28');
INSERT INTO `product` VALUES ('181', '24', '爱之佳5136一次性圆竹筷', '6', '5.5', '爱之佳5136一次性圆竹筷（1*30）', '【品牌 】：爱之佳\r\n【产品名称 】：爱之佳5136一次性圆竹筷（1*30）\r\n【产地 】：湖北省武汉市\r\n【类型 】：一次性餐具/纸杯', '2015-04-17 19:13:11');
INSERT INTO `product` VALUES ('182', '24', '爱之佳一次性塑料炫碗500ml', '6', '4.2', '爱之佳一次性塑料炫碗500ml（1*20）', '【品牌 】：爱之佳\r\n【产品名称 】：爱之佳一次性塑料炫碗500ml（1*20）\r\n【产地 】：湖北省武汉市\r\n【类型 】：一次性餐具/纸杯', '2015-04-17 19:15:10');
INSERT INTO `product` VALUES ('183', '24', '汉高纯正白砂糖', '8', '10', '汉高纯正白砂糖800g', '【品牌 】：汉高\r\n【产品名称 】：汉高纯正白砂糖800g\r\n【产地 】：湖北省武汉市\r\n【类型 】：白砂糖\r\n【包装 】：袋\r\n【国产/进口 】：国产', '2015-04-17 19:17:32');
INSERT INTO `product` VALUES ('184', '24', '农夫山泉饮用天然水', '5', '1.8', '农夫山泉饮用天然水550ml', '【商品品牌】：农夫山泉\r\n【产品名称】：农夫山泉饮用天然水550ml\r\n【商品厂名】：农夫山泉股份有限公司\r\n【商品产地】： 湖北十堰\r\n【保  质  期】：2年\r\n【商品规格】：550ml\r\n【商品成份】：天然水\r\n【储藏方法】：常温', '2015-04-17 19:19:29');
INSERT INTO `product` VALUES ('185', '24', '百威啤酒', '9', '7', '百威啤酒330ml', '品牌：百威\r\n产地：湖北省武汉市\r\n产地：国产\r\n产品名称：百威啤酒330ml\r\n保质期：12个月\r\n包装：听装\r\n规格	330ml', '2015-04-17 19:22:02');
INSERT INTO `product` VALUES ('186', '24', '云南白药金口健口清新激爽橘玫牙膏', '11', '18.8', '云南白药金口健口清新激爽橘玫牙膏105g', '品牌	：云南白药\r\n产品名称：云南白药金口健口清新激爽橘玫牙膏105g\r\n产地	：云南省昆明市\r\n类型	：成人牙膏\r\n功能	：牙龈护理\r\n成分	：碳酸钙、水、山梨醇、水合硅石、丙二醇等\r\n规格	：105g\r\n保质期：36个月', '2015-04-17 19:25:57');
INSERT INTO `product` VALUES ('187', '24', '心相印茶语系列三层手帕纸', '7', '9.9', '心相印茶语系列三层手帕纸18包C1718', '产品名称	：心相印茶语系列三层手帕纸18包C1718\r\n品牌	：心相印\r\n产地	：湖南\r\n保质期：3年\r\n成分	：原生木浆\r\n香型：茶香\r\n规格	：18包', '2015-04-17 19:28:19');
INSERT INTO `product` VALUES ('189', '24', '清扬男士活炭净爽洗发露', '11', '44.9', '清扬男士活炭净爽洗发露400ml', '品牌	：清扬\r\n产地	：安徽省合肥市\r\n保质期：见瓶底\r\n类型	：洗发水\r\n功能	：滋养去屑\r\n发质	：油性', '2015-04-17 19:31:53');

-- ----------------------------
-- Table structure for `product_property`
-- ----------------------------
DROP TABLE IF EXISTS `product_property`;
CREATE TABLE `product_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_type_id` int(11) NOT NULL COMMENT '所属商品类型',
  `name` varchar(255) NOT NULL COMMENT '商品属性名称如：款式',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_type_id` (`product_type_id`),
  CONSTRAINT `product_type_id` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- ----------------------------
-- Records of product_property
-- ----------------------------
INSERT INTO `product_property` VALUES ('11', '10', 'qqq', '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for `product_property_value`
-- ----------------------------
DROP TABLE IF EXISTS `product_property_value`;
CREATE TABLE `product_property_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `property_value_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_property_value_ibfk_2` (`property_value_id`),
  KEY `product_property_value_ibfk_1` (`product_id`),
  CONSTRAINT `product_property_value_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `product_property_value_ibfk_2` FOREIGN KEY (`property_value_id`) REFERENCES `property_value` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_property_value
-- ----------------------------

-- ----------------------------
-- Table structure for `product_type`
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) NOT NULL COMMENT '商品类型名称',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('4', '米面粮油', '2015-04-17 12:15:27');
INSERT INTO `product_type` VALUES ('5', '饮料饮品', '2015-04-17 12:17:52');
INSERT INTO `product_type` VALUES ('6', '一次性用品', '2015-04-17 12:18:03');
INSERT INTO `product_type` VALUES ('7', '纸制品', '2015-04-17 12:18:12');
INSERT INTO `product_type` VALUES ('8', '厨房调料', '2015-04-17 12:18:38');
INSERT INTO `product_type` VALUES ('9', '酒类', '2015-04-17 12:19:25');
INSERT INTO `product_type` VALUES ('10', '清洁剂', '2015-04-17 12:19:38');
INSERT INTO `product_type` VALUES ('11', '洗漱用品', '2015-04-17 12:19:51');

-- ----------------------------
-- Table structure for `property_value`
-- ----------------------------
DROP TABLE IF EXISTS `property_value`;
CREATE TABLE `property_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_property_id` int(11) NOT NULL COMMENT '所属商品属性',
  `name` varchar(255) NOT NULL COMMENT '具体属性值如：外衣',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_property_id` (`product_property_id`),
  CONSTRAINT `product_property_id` FOREIGN KEY (`product_property_id`) REFERENCES `product_property` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='属性值表 对应具体商品';

-- ----------------------------
-- Records of property_value
-- ----------------------------
INSERT INTO `property_value` VALUES ('34', '11', 'yang', '2015-04-21 10:20:53');

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '开店人',
  `name` varchar(255) NOT NULL COMMENT '店铺名称',
  `level` int(11) NOT NULL DEFAULT '0' COMMENT '店铺等级',
  `time` datetime NOT NULL COMMENT '开店日期',
  `description` varchar(255) DEFAULT NULL COMMENT '店铺描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('24', '2', '中百商网', '0', '2015-04-17 13:15:34', '中百商网是中百控股集团股份有限公司旗下购物网站。中百集团是以连锁超市为 主的一家大型商业集团，国家商务部重点培育的全国20家大型流通企业之一，连续五年蝉联中国企业500强，连续十年进入全国零售连锁经营30强。');

-- ----------------------------
-- Table structure for `shop_collect`
-- ----------------------------
DROP TABLE IF EXISTS `shop_collect`;
CREATE TABLE `shop_collect` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_collect
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `type` bit(1) DEFAULT b'0' COMMENT '用户类型，0表示买家，1表示卖家',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '黄国宝', '123456', '18627799561', '2015-04-03 20:23:57', '');
INSERT INTO `user` VALUES ('2', 'yangjunlei', '123456', '13006106188', '2015-04-05 14:08:45', '');
INSERT INTO `user` VALUES ('28', 'test', '123456', '18627799562', '2015-04-13 16:37:36', '');
INSERT INTO `user` VALUES ('33', 'zjzn', '000000', '12345612345', '2015-04-17 13:51:28', '');
DROP TRIGGER IF EXISTS `set_time`;
DELIMITER ;;
CREATE TRIGGER `set_time` BEFORE INSERT ON `image` FOR EACH ROW BEGIN
set NEW.datetime = NOW();
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `order_time`;
DELIMITER ;;
CREATE TRIGGER `order_time` BEFORE INSERT ON `orders` FOR EACH ROW BEGIN
set NEW.order_time = NOW();
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `insert_before`;
DELIMITER ;;
CREATE TRIGGER `insert_before` BEFORE INSERT ON `property_value` FOR EACH ROW BEGIN
set new.datetime = NOW();
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `set_register_time`;
DELIMITER ;;
CREATE TRIGGER `set_register_time` BEFORE INSERT ON `user` FOR EACH ROW BEGIN
set NEW.register_time = NOW();
END
;;
DELIMITER ;
