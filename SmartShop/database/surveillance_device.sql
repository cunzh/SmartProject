/*
Navicat MySQL Data Transfer

Source Server         : lgk
Source Server Version : 50173
Source Host           : 192.168.0.15:3306
Source Database       : surveillance_device

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-04-13 12:36:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `net_camera`
-- ----------------------------
DROP TABLE IF EXISTS `net_camera`;
CREATE TABLE `net_camera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL COMMENT '摄像机编号',
  `name` varchar(255) DEFAULT '' COMMENT '摄像机名',
  `location` varchar(255) DEFAULT '' COMMENT '地理位置',
  `recoder_id` int(11) DEFAULT NULL COMMENT '录像机id',
  `recoder_channel` int(11) DEFAULT NULL COMMENT '录像机通道',
  `username` varchar(255) DEFAULT '' COMMENT '用户名',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`id`),
  KEY `recoder_id` (`recoder_id`),
  CONSTRAINT `net_camera_ibfk_1` FOREIGN KEY (`recoder_id`) REFERENCES `net_recoder` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of net_camera
-- ----------------------------
INSERT INTO `net_camera` VALUES ('1', '1', '摄像机1', '实验室', '1', '1', 'admin', '4321');

-- ----------------------------
-- Table structure for `net_recoder`
-- ----------------------------
DROP TABLE IF EXISTS `net_recoder`;
CREATE TABLE `net_recoder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(255) DEFAULT NULL COMMENT '录像机编号',
  `name` varchar(255) DEFAULT '' COMMENT '录像机名',
  `ip_adress` char(16) DEFAULT '' COMMENT 'ip 地址',
  `port` int(11) DEFAULT '554' COMMENT '端口号',
  `username` varchar(255) DEFAULT '' COMMENT '用户名',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `model` varchar(255) DEFAULT '' COMMENT '型号',
  `channel_number` int(11) DEFAULT '16' COMMENT '通道数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='网络录像机';

-- ----------------------------
-- Records of net_recoder
-- ----------------------------
INSERT INTO `net_recoder` VALUES ('1', '1', '录像机1', '192.168.0.200', '554', 'admin', '4321', 'SRN-167x', '16');
