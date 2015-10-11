/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : smartshop

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2015-04-13 09:48:59
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
  `isDefault` bit(1) NOT NULL DEFAULT b'1' COMMENT '该地址是否为默认地址',
  `name` varchar(255) DEFAULT '' COMMENT '收货人姓名',
  `telephone` varchar(255) DEFAULT '' COMMENT '收货人电话',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='送货地址';

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '1', 'donghu', '', ' ', ' ');
INSERT INTO `address` VALUES ('3', '2', 'donghumingzhu', '', 'laowang', '12345');
INSERT INTO `address` VALUES ('4', '2', 'zhongjian', '', 'laowu', '1234');
INSERT INTO `address` VALUES ('5', '2', 'zhongjian1', '', ' ', ' ');
INSERT INTO `address` VALUES ('7', '3', 'hust', '', ' ', ' ');
INSERT INTO `address` VALUES ('8', '2', '湖北武汉市洪山区wuhan', '', 'laowang', '1592727');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('1', '2', '2', '2015-04-13 09:38:20');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '1', '3', '2015-04-01 20:29:57');
INSERT INTO `collect` VALUES ('2', '1', '4', '2015-04-02 20:30:10');
INSERT INTO `collect` VALUES ('3', '1', '5', '2015-04-03 20:30:21');
INSERT INTO `collect` VALUES ('4', '1', '11', '2015-04-04 20:30:32');
INSERT INTO `collect` VALUES ('5', '2', '4', '2015-04-05 20:30:49');
INSERT INTO `collect` VALUES ('6', '2', '3', '2015-04-06 20:52:02');
INSERT INTO `collect` VALUES ('7', '2', '5', '2015-04-08 20:52:16');
INSERT INTO `collect` VALUES ('9', '3', '3', '2015-04-10 16:06:52');

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
INSERT INTO `comment` VALUES ('1', '2', '1', '1', '老板不错', null, '2015-04-08 17:31:32', null);
INSERT INTO `comment` VALUES ('2', '2', '2', '2', '还不错吧，将就', null, '2015-04-09 17:31:58', null);
INSERT INTO `comment` VALUES ('3', '2', '3', '1', 'no ok', 'very good', '2015-04-10 15:43:18', '2015-04-10 15:54:20');

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
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`) USING BTREE,
  CONSTRAINT `image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', '2', 'xx', '2015-04-07 16:17:52');
INSERT INTO `image` VALUES ('5', '2', 'dfssxxxxxx', '2015-04-09 10:35:32');
INSERT INTO `image` VALUES ('6', '44', 'xddfdf', '2015-04-12 21:52:45');
INSERT INTO `image` VALUES ('7', '44', 'fdfd', '2015-04-12 21:52:55');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(255) NOT NULL COMMENT '订单号',
  `shop_id` int(11) NOT NULL COMMENT '卖家',
  `user_id` int(11) NOT NULL COMMENT '买家',
  `product_id` int(11) NOT NULL COMMENT '交易商品',
  `address` varchar(255) NOT NULL COMMENT '交易收货地址',
  `telephone` varchar(50) NOT NULL COMMENT '买家电话',
  `price` float NOT NULL COMMENT '交易价格',
  `order_time` datetime NOT NULL COMMENT '订单产生日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('2', '6199625661', '3', '2', '2', 'huazhongkejidaxue', '18627799561', '4505', '2015-04-11 16:22:58');

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
  `simple_description` varchar(255) DEFAULT NULL,
  `complex_description` varchar(255) DEFAULT NULL,
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shop_id` (`shop_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `shop_id` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `product_type` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', '3', 'iPhone6', '2', '4505', '全球最低价', null, '2015-04-06 17:25:06');
INSERT INTO `product` VALUES ('44', '3', 'Huynh', '1', '9999', null, null, '2015-04-12 21:32:02');
INSERT INTO `product` VALUES ('45', '3', 'Huynh', '1', '9999', null, null, '2015-04-12 21:34:16');
INSERT INTO `product` VALUES ('48', '3', '213', '1', '33131', null, null, '2015-04-12 21:44:09');
INSERT INTO `product` VALUES ('49', '3', '西服', '1', '8899', null, null, '2015-04-13 09:38:34');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- ----------------------------
-- Records of product_property
-- ----------------------------
INSERT INTO `product_property` VALUES ('3', '1', 'size', '2015-04-07 16:21:50');
INSERT INTO `product_property` VALUES ('4', '1', 'chicun', '2015-04-07 20:01:51');
INSERT INTO `product_property` VALUES ('6', '1', 'huynh11111', '2015-04-11 16:43:54');

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
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_property_value
-- ----------------------------
INSERT INTO `product_property_value` VALUES ('3', '2', '6');
INSERT INTO `product_property_value` VALUES ('38', '45', '3');
INSERT INTO `product_property_value` VALUES ('39', '48', '3');
INSERT INTO `product_property_value` VALUES ('40', '49', '3');

-- ----------------------------
-- Table structure for `product_type`
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '商品类型名称',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES ('1', '服装', '2015-04-07 15:49:34');
INSERT INTO `product_type` VALUES ('2', '手机', '2015-04-01 20:19:26');
INSERT INTO `product_type` VALUES ('3', '食品', '2015-04-06 20:19:44');
INSERT INTO `product_type` VALUES ('5', 'go', '2015-04-08 19:20:46');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='属性值表 对应具体商品';

-- ----------------------------
-- Records of property_value
-- ----------------------------
INSERT INTO `property_value` VALUES ('3', '3', '333', '2015-04-12 09:24:54');
INSERT INTO `property_value` VALUES ('5', '4', 'huynh', '2015-04-06 20:23:12');
INSERT INTO `property_value` VALUES ('6', '3', 'yang', '2015-04-13 20:23:25');
INSERT INTO `property_value` VALUES ('9', '3', '222', '2015-04-12 09:20:12');

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('3', '1', 'iPhone专卖店', '0', '2015-04-03 20:24:35', '卖iPhone');
INSERT INTO `shop` VALUES ('4', '1', '诺基亚专卖店', '1', '2015-04-03 20:25:38', '最便宜的iPhone4');
INSERT INTO `shop` VALUES ('5', '2', '韵苑书店', '3', '2015-04-03 20:25:44', '专卖各种书籍book');
INSERT INTO `shop` VALUES ('6', '2', '香港代购', '0', '2015-04-03 20:25:48', '代购苹果');
INSERT INTO `shop` VALUES ('7', '2', '联华超市', '4', '2015-04-03 20:25:53', '食品油盐酱醋food');
INSERT INTO `shop` VALUES ('8', '2', '安踏世家', '7', '2015-04-03 20:25:56', '水泥杀手anta');
INSERT INTO `shop` VALUES ('9', '2', '食品专卖', '2', '2015-04-03 20:26:05', 'food');
INSERT INTO `shop` VALUES ('10', '2', '牛仔裤品牌店', '2', '2015-04-03 20:26:19', '各种品牌牛仔裤');
INSERT INTO `shop` VALUES ('11', '2', '康师傅专卖', '1', '2015-04-03 20:26:28', '康师傅专卖');
INSERT INTO `shop` VALUES ('21', '2', '特步', '0', '2015-04-12 21:08:26', '专业运动鞋');

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '黄国宝', '123456', '18627799561', '2015-04-03 20:23:57', '');
INSERT INTO `user` VALUES ('2', 'yangjunlei', '123456', '13006106187', '2015-04-05 14:08:45', '');
INSERT INTO `user` VALUES ('3', 'hust', 'hustcs', '123456', '2015-04-10 13:30:17', '');
INSERT INTO `user` VALUES ('5', 'xiao', '123456', '15927276502', '2015-04-10 16:06:58', '');
INSERT INTO `user` VALUES ('26', 'LGK', '123', '123', '2015-04-12 18:37:03', '');
DROP TRIGGER IF EXISTS `set_register_time`;
DELIMITER ;;
CREATE TRIGGER `set_register_time` BEFORE INSERT ON `user` FOR EACH ROW BEGIN
set NEW.register_time = NOW();
END
;;
DELIMITER ;
