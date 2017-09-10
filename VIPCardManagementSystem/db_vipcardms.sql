/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : db_vipcardms

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-09-11 01:24:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cardtype
-- ----------------------------
DROP TABLE IF EXISTS `cardtype`;
CREATE TABLE `cardtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cardtype
-- ----------------------------
INSERT INTO `cardtype` VALUES ('0', '管理员');
INSERT INTO `cardtype` VALUES ('1', '临时卡');
INSERT INTO `cardtype` VALUES ('2', '青铜会员');
INSERT INTO `cardtype` VALUES ('3', '白银会员');
INSERT INTO `cardtype` VALUES ('4', '黄金会员');
INSERT INTO `cardtype` VALUES ('5', '铂金会员');
INSERT INTO `cardtype` VALUES ('6', '钻石会员');



-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `telephone` varchar(11) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `creditcard` varchar(20) NOT NULL,
  `count` int(11) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  `cardid` varchar(20) NOT NULL,
  `jointime` datetime DEFAULT NULL,
  `leavetime` datetime DEFAULT NULL,
  `money` double(16,2) DEFAULT NULL,
  `cardtype` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `cardid` (`cardid`),
  KEY `cardtype` (`cardtype`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`cardtype`) REFERENCES `cardtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', 'admin', 'admin', '管理员', '1', null, '0', null, '0', '0', '2017-09-11 01:16:21', '0', null, null, '0.00', '0');
INSERT INTO `user` VALUES ('1', '郭大帅哥', '111', '郭文浩', '1', '重庆市南岸区学府大道', '18588886666', '1842297753@qq.com', '6220288888', '145700', '2017-09-11 01:13:36', '201709100001', '2017-09-10 00:57:10', null, '103394.00', '6');
INSERT INTO `user` VALUES ('2', '小龙女', '222', '刘亦菲', '2', '重庆市江北区', '18877776666', '18877776666@qq.com', '6220277777', '21150', '2017-09-11 00:18:45', '201709100002', '2017-09-10 16:39:21', null, '6149.00', '5');
INSERT INTO `user` VALUES ('3', '过儿', '222', '杨过', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '0', '2017-09-10 16:41:53', '201709100003', '2017-09-10 16:41:47', '2017-09-10 17:48:13', '0.00', '1');
INSERT INTO `user` VALUES ('4', '张三', '222', '张三', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '6550', '2017-09-11 00:19:54', '201709100004', '2017-09-10 16:41:47', null, '1899.00', '4');
INSERT INTO `user` VALUES ('5', '李四', '222', '李四', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '5000', '2017-09-11 00:20:24', '201709100005', '2017-09-10 16:41:47', null, '5000.00', '4');
INSERT INTO `user` VALUES ('6', '王五', '222', '王五', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '5000', '2017-09-11 00:20:34', '201709100006', '2017-09-10 16:41:47', null, '5000.00', '4');
INSERT INTO `user` VALUES ('7', '赵六', '222', '赵六', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '5000', '2017-09-11 00:20:43', '201709100007', '2017-09-10 16:41:47', null, '5000.00', '4');
INSERT INTO `user` VALUES ('8', '田七', '222', '田七', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '1050', '2017-09-11 00:20:51', '201709100008', '2017-09-10 16:41:47', null, '1050.00', '4');
INSERT INTO `user` VALUES ('9', '周八', '222', '周八', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '400', '2017-09-11 00:21:12', '201709100009', '2017-09-10 16:41:47', null, '400.00', '3');
INSERT INTO `user` VALUES ('10', '张无忌', '222', '张无忌', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '50', '2017-09-11 00:22:50', '201709100010', '2017-09-10 16:41:47', null, '50.00', '2');
INSERT INTO `user` VALUES ('11', '张三丰', '222', '张三丰', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '0', '2017-09-10 16:41:53', '201709100011', '2017-09-10 16:41:47', null, '0.00', '1');
INSERT INTO `user` VALUES ('12', '刘德华', '222', '刘德华', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '0', '2017-09-10 16:41:53', '201709100012', '2017-09-10 16:41:47', null, '0.00', '1');
INSERT INTO `user` VALUES ('13', '张学友', '222', '张学友', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '50', '2017-09-11 00:24:17', '201709100013', '2017-09-10 16:41:47', null, '50.00', '2');
INSERT INTO `user` VALUES ('14', '薛之谦', '222', '薛之谦', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '124600', '2017-09-11 00:27:37', '201709100014', '2017-09-10 16:41:47', null, '23774.00', '6');
INSERT INTO `user` VALUES ('15', '钱枫', '222', '钱枫', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '100', '2017-09-11 00:24:34', '201709100015', '2017-09-10 16:41:47', null, '100.00', '3');
INSERT INTO `user` VALUES ('16', '郭雪芙', '222', '郭雪芙', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '1000', '2017-09-11 00:24:42', '201709100016', '2017-09-10 16:41:47', null, '1000.00', '4');
INSERT INTO `user` VALUES ('17', '杨迪', '222', '杨迪', '1', '重庆市江北区', '18866667777', '18866667777@qq.com', '6220266666', '105000', '2017-09-11 00:28:26', '201709100017', '2017-09-10 16:41:47', null, '105000.00', '6');
INSERT INTO `user` VALUES ('18', '深夜', '222', '不告诉你', '2', '重庆市沙坪坝区西永西科公寓', '18765433456', '18765433456@qq.com', '622202123456', '0', '2017-09-11 01:16:01', '201709110001', '2017-09-11 01:15:48', null, '0.00', '1');

-- ----------------------------
-- Table structure for addlog
-- ----------------------------
DROP TABLE IF EXISTS `addlog`;
CREATE TABLE `addlog` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `money` double(6,2) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`aid`),
  KEY `uid` (`uid`),
  CONSTRAINT `addlog_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addlog
-- ----------------------------
INSERT INTO `addlog` VALUES ('1', '2017-09-10 23:19:53', '5000.00', '1');
INSERT INTO `addlog` VALUES ('2', '2017-09-10 23:20:15', '1000.00', '1');
INSERT INTO `addlog` VALUES ('3', '2017-09-10 23:20:22', '50.00', '1');
INSERT INTO `addlog` VALUES ('4', '2017-09-10 23:20:23', '5000.00', '1');
INSERT INTO `addlog` VALUES ('5', '2017-09-10 23:22:21', '500.00', '1');
INSERT INTO `addlog` VALUES ('6', '2017-09-10 23:27:29', '5000.00', '1');
INSERT INTO `addlog` VALUES ('7', '2017-09-10 23:27:31', '5000.00', '1');
INSERT INTO `addlog` VALUES ('8', '2017-09-10 23:27:33', '5000.00', '1');
INSERT INTO `addlog` VALUES ('9', '2017-09-10 23:27:33', '5000.00', '1');
INSERT INTO `addlog` VALUES ('10', '2017-09-10 23:27:33', '5000.00', '1');
INSERT INTO `addlog` VALUES ('11', '2017-09-10 23:27:34', '5000.00', '1');
INSERT INTO `addlog` VALUES ('12', '2017-09-10 23:27:34', '5000.00', '1');
INSERT INTO `addlog` VALUES ('13', '2017-09-10 23:27:34', '5000.00', '1');
INSERT INTO `addlog` VALUES ('14', '2017-09-10 23:27:35', '5000.00', '1');
INSERT INTO `addlog` VALUES ('15', '2017-09-10 23:27:35', '5000.00', '1');
INSERT INTO `addlog` VALUES ('16', '2017-09-10 23:27:35', '5000.00', '1');
INSERT INTO `addlog` VALUES ('17', '2017-09-10 23:27:36', '5000.00', '1');
INSERT INTO `addlog` VALUES ('18', '2017-09-10 23:27:37', '5000.00', '1');
INSERT INTO `addlog` VALUES ('19', '2017-09-10 23:27:37', '5000.00', '1');
INSERT INTO `addlog` VALUES ('20', '2017-09-10 23:28:34', '5000.00', '1');
INSERT INTO `addlog` VALUES ('21', '2017-09-10 23:28:35', '5000.00', '1');
INSERT INTO `addlog` VALUES ('22', '2017-09-10 23:28:37', '5000.00', '1');
INSERT INTO `addlog` VALUES ('23', '2017-09-10 23:28:39', '5000.00', '1');
INSERT INTO `addlog` VALUES ('24', '2017-09-10 23:28:44', '5000.00', '1');
INSERT INTO `addlog` VALUES ('25', '2017-09-11 00:08:02', '5000.00', '1');
INSERT INTO `addlog` VALUES ('26', '2017-09-11 00:11:52', '5000.00', '1');
INSERT INTO `addlog` VALUES ('27', '2017-09-11 00:12:03', '5000.00', '1');
INSERT INTO `addlog` VALUES ('28', '2017-09-11 00:12:21', '50.00', '1');
INSERT INTO `addlog` VALUES ('29', '2017-09-11 00:12:37', '5000.00', '1');
INSERT INTO `addlog` VALUES ('30', '2017-09-11 00:15:09', '5000.00', '1');
INSERT INTO `addlog` VALUES ('31', '2017-09-11 00:16:29', '50.00', '2');
INSERT INTO `addlog` VALUES ('32', '2017-09-11 00:16:35', '50.00', '2');
INSERT INTO `addlog` VALUES ('33', '2017-09-11 00:16:36', '50.00', '2');
INSERT INTO `addlog` VALUES ('34', '2017-09-11 00:16:40', '500.00', '2');
INSERT INTO `addlog` VALUES ('35', '2017-09-11 00:16:41', '500.00', '2');
INSERT INTO `addlog` VALUES ('36', '2017-09-11 00:16:43', '1000.00', '2');
INSERT INTO `addlog` VALUES ('37', '2017-09-11 00:16:44', '1000.00', '2');
INSERT INTO `addlog` VALUES ('38', '2017-09-11 00:16:44', '1000.00', '2');
INSERT INTO `addlog` VALUES ('39', '2017-09-11 00:16:45', '1000.00', '2');
INSERT INTO `addlog` VALUES ('40', '2017-09-11 00:16:45', '1000.00', '2');
INSERT INTO `addlog` VALUES ('41', '2017-09-11 00:16:47', '5000.00', '2');
INSERT INTO `addlog` VALUES ('42', '2017-09-11 00:19:19', '5000.00', '2');
INSERT INTO `addlog` VALUES ('43', '2017-09-11 00:19:57', '5000.00', '4');
INSERT INTO `addlog` VALUES ('44', '2017-09-11 00:20:26', '5000.00', '5');
INSERT INTO `addlog` VALUES ('45', '2017-09-11 00:20:38', '5000.00', '6');
INSERT INTO `addlog` VALUES ('46', '2017-09-11 00:20:45', '5000.00', '7');
INSERT INTO `addlog` VALUES ('47', '2017-09-11 00:20:53', '50.00', '8');
INSERT INTO `addlog` VALUES ('48', '2017-09-11 00:20:55', '100.00', '8');
INSERT INTO `addlog` VALUES ('49', '2017-09-11 00:20:59', '200.00', '8');
INSERT INTO `addlog` VALUES ('50', '2017-09-11 00:21:00', '200.00', '8');
INSERT INTO `addlog` VALUES ('51', '2017-09-11 00:21:00', '200.00', '8');
INSERT INTO `addlog` VALUES ('52', '2017-09-11 00:21:02', '200.00', '8');
INSERT INTO `addlog` VALUES ('53', '2017-09-11 00:21:02', '100.00', '8');
INSERT INTO `addlog` VALUES ('54', '2017-09-11 00:21:17', '200.00', '9');
INSERT INTO `addlog` VALUES ('55', '2017-09-11 00:22:55', '50.00', '10');
INSERT INTO `addlog` VALUES ('56', '2017-09-11 00:24:21', '50.00', '13');
INSERT INTO `addlog` VALUES ('57', '2017-09-11 00:24:36', '100.00', '15');
INSERT INTO `addlog` VALUES ('58', '2017-09-11 00:24:46', '1000.00', '16');
INSERT INTO `addlog` VALUES ('59', '2017-09-11 00:25:00', '5000.00', '14');
INSERT INTO `addlog` VALUES ('60', '2017-09-11 00:25:28', '5000.00', '14');
INSERT INTO `addlog` VALUES ('61', '2017-09-11 00:25:29', '5000.00', '14');
INSERT INTO `addlog` VALUES ('62', '2017-09-11 00:25:30', '5000.00', '14');
INSERT INTO `addlog` VALUES ('63', '2017-09-11 00:25:31', '5000.00', '14');
INSERT INTO `addlog` VALUES ('64', '2017-09-11 00:25:33', '5000.00', '14');
INSERT INTO `addlog` VALUES ('65', '2017-09-11 00:25:35', '5000.00', '14');
INSERT INTO `addlog` VALUES ('66', '2017-09-11 00:25:36', '5000.00', '14');
INSERT INTO `addlog` VALUES ('67', '2017-09-11 00:25:36', '5000.00', '14');
INSERT INTO `addlog` VALUES ('68', '2017-09-11 00:25:37', '5000.00', '14');
INSERT INTO `addlog` VALUES ('69', '2017-09-11 00:25:45', '5000.00', '14');
INSERT INTO `addlog` VALUES ('70', '2017-09-11 00:27:40', '5000.00', '14');
INSERT INTO `addlog` VALUES ('71', '2017-09-11 00:27:41', '5000.00', '14');
INSERT INTO `addlog` VALUES ('72', '2017-09-11 00:27:41', '5000.00', '14');
INSERT INTO `addlog` VALUES ('73', '2017-09-11 00:27:42', '5000.00', '14');
INSERT INTO `addlog` VALUES ('74', '2017-09-11 00:27:42', '5000.00', '14');
INSERT INTO `addlog` VALUES ('75', '2017-09-11 00:27:43', '5000.00', '14');
INSERT INTO `addlog` VALUES ('76', '2017-09-11 00:27:48', '50.00', '14');
INSERT INTO `addlog` VALUES ('77', '2017-09-11 00:27:48', '50.00', '14');
INSERT INTO `addlog` VALUES ('78', '2017-09-11 00:27:48', '50.00', '14');
INSERT INTO `addlog` VALUES ('79', '2017-09-11 00:27:49', '50.00', '14');
INSERT INTO `addlog` VALUES ('80', '2017-09-11 00:27:49', '50.00', '14');
INSERT INTO `addlog` VALUES ('81', '2017-09-11 00:27:49', '50.00', '14');
INSERT INTO `addlog` VALUES ('82', '2017-09-11 00:27:49', '50.00', '14');
INSERT INTO `addlog` VALUES ('83', '2017-09-11 00:27:49', '50.00', '14');
INSERT INTO `addlog` VALUES ('84', '2017-09-11 00:27:49', '50.00', '14');
INSERT INTO `addlog` VALUES ('85', '2017-09-11 00:27:49', '50.00', '14');
INSERT INTO `addlog` VALUES ('86', '2017-09-11 00:27:50', '50.00', '14');
INSERT INTO `addlog` VALUES ('87', '2017-09-11 00:27:50', '50.00', '14');
INSERT INTO `addlog` VALUES ('88', '2017-09-11 00:27:50', '50.00', '14');
INSERT INTO `addlog` VALUES ('89', '2017-09-11 00:27:50', '50.00', '14');
INSERT INTO `addlog` VALUES ('90', '2017-09-11 00:27:50', '50.00', '14');
INSERT INTO `addlog` VALUES ('91', '2017-09-11 00:27:50', '50.00', '14');
INSERT INTO `addlog` VALUES ('92', '2017-09-11 00:27:51', '50.00', '14');
INSERT INTO `addlog` VALUES ('93', '2017-09-11 00:27:51', '50.00', '14');
INSERT INTO `addlog` VALUES ('94', '2017-09-11 00:27:51', '50.00', '14');
INSERT INTO `addlog` VALUES ('95', '2017-09-11 00:27:51', '50.00', '14');
INSERT INTO `addlog` VALUES ('96', '2017-09-11 00:28:08', '5000.00', '14');
INSERT INTO `addlog` VALUES ('97', '2017-09-11 00:28:28', '5000.00', '17');
INSERT INTO `addlog` VALUES ('98', '2017-09-11 00:28:28', '5000.00', '17');
INSERT INTO `addlog` VALUES ('99', '2017-09-11 00:28:28', '5000.00', '17');
INSERT INTO `addlog` VALUES ('100', '2017-09-11 00:28:28', '5000.00', '17');
INSERT INTO `addlog` VALUES ('101', '2017-09-11 00:28:29', '5000.00', '17');
INSERT INTO `addlog` VALUES ('102', '2017-09-11 00:28:29', '5000.00', '17');
INSERT INTO `addlog` VALUES ('103', '2017-09-11 00:28:29', '5000.00', '17');
INSERT INTO `addlog` VALUES ('104', '2017-09-11 00:28:29', '5000.00', '17');
INSERT INTO `addlog` VALUES ('105', '2017-09-11 00:28:29', '5000.00', '17');
INSERT INTO `addlog` VALUES ('106', '2017-09-11 00:28:29', '5000.00', '17');
INSERT INTO `addlog` VALUES ('107', '2017-09-11 00:28:29', '5000.00', '17');
INSERT INTO `addlog` VALUES ('108', '2017-09-11 00:28:30', '5000.00', '17');
INSERT INTO `addlog` VALUES ('109', '2017-09-11 00:28:30', '5000.00', '17');
INSERT INTO `addlog` VALUES ('110', '2017-09-11 00:28:30', '5000.00', '17');
INSERT INTO `addlog` VALUES ('111', '2017-09-11 00:28:30', '5000.00', '17');
INSERT INTO `addlog` VALUES ('112', '2017-09-11 00:28:30', '5000.00', '17');
INSERT INTO `addlog` VALUES ('113', '2017-09-11 00:28:30', '5000.00', '17');
INSERT INTO `addlog` VALUES ('114', '2017-09-11 00:28:31', '5000.00', '17');
INSERT INTO `addlog` VALUES ('115', '2017-09-11 00:28:31', '5000.00', '17');
INSERT INTO `addlog` VALUES ('116', '2017-09-11 00:28:31', '5000.00', '17');
INSERT INTO `addlog` VALUES ('117', '2017-09-11 00:28:31', '5000.00', '17');



-- ----------------------------
-- Table structure for costlog
-- ----------------------------
DROP TABLE IF EXISTS `costlog`;
CREATE TABLE `costlog` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `money` double(6,2) NOT NULL,
  `desc` varchar(200) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `costlog_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of costlog
-- ----------------------------
INSERT INTO `costlog` VALUES ('1', '2017-09-11 00:01:04', '1.00', '欧洲10国', '1');
INSERT INTO `costlog` VALUES ('2', '2017-09-11 00:01:39', '1000.00', '九寨沟7日游', '1');
INSERT INTO `costlog` VALUES ('3', '2017-09-11 00:06:30', '8000.00', '三亚7日游', '1');
INSERT INTO `costlog` VALUES ('4', '2017-09-11 00:07:49', '8000.00', '三亚7日游', '1');
INSERT INTO `costlog` VALUES ('5', '2017-09-11 00:08:12', '1000.00', '九寨沟7日游', '1');
INSERT INTO `costlog` VALUES ('6', '2017-09-11 00:08:40', '8000.00', '三亚7日游', '1');
INSERT INTO `costlog` VALUES ('7', '2017-09-11 00:09:18', '1.00', '欧洲10国', '1');
INSERT INTO `costlog` VALUES ('8', '2017-09-11 00:09:21', '1.00', '欧洲10国', '1');
INSERT INTO `costlog` VALUES ('9', '2017-09-11 00:09:24', '1000.00', '九寨沟7日游', '1');
INSERT INTO `costlog` VALUES ('10', '2017-09-11 00:09:49', '1000.00', '九寨沟7日游', '1');
INSERT INTO `costlog` VALUES ('11', '2017-09-11 00:09:52', '100.00', '重庆两江夜景', '1');
INSERT INTO `costlog` VALUES ('12', '2017-09-11 00:09:56', '1.00', '欧洲10国', '1');
INSERT INTO `costlog` VALUES ('13', '2017-09-11 00:11:57', '100.00', '重庆两江夜景', '1');
INSERT INTO `costlog` VALUES ('14', '2017-09-11 00:12:29', '1.00', '欧洲10国', '1');
INSERT INTO `costlog` VALUES ('15', '2017-09-11 00:12:33', '1.00', '欧洲10国', '1');
INSERT INTO `costlog` VALUES ('16', '2017-09-11 00:16:59', '8000.00', '三亚7日游', '2');
INSERT INTO `costlog` VALUES ('17', '2017-09-11 00:18:54', '1000.00', '九寨沟7日游', '2');
INSERT INTO `costlog` VALUES ('18', '2017-09-11 00:19:05', '1000.00', '九寨沟7日游', '2');
INSERT INTO `costlog` VALUES ('19', '2017-09-11 00:19:06', '1.00', '欧洲10国', '2');
INSERT INTO `costlog` VALUES ('20', '2017-09-11 00:20:01', '1000.00', '九寨沟7日游', '4');
INSERT INTO `costlog` VALUES ('21', '2017-09-11 00:20:03', '1000.00', '九寨沟7日游', '4');
INSERT INTO `costlog` VALUES ('22', '2017-09-11 00:20:04', '1000.00', '九寨沟7日游', '4');
INSERT INTO `costlog` VALUES ('23', '2017-09-11 00:20:05', '100.00', '重庆两江夜景', '4');
INSERT INTO `costlog` VALUES ('24', '2017-09-11 00:20:08', '1.00', '欧洲10国', '4');
INSERT INTO `costlog` VALUES ('25', '2017-09-11 00:25:40', '8000.00', '三亚7日游', '14');
INSERT INTO `costlog` VALUES ('26', '2017-09-11 00:25:41', '8000.00', '三亚7日游', '14');
INSERT INTO `costlog` VALUES ('27', '2017-09-11 00:25:42', '8000.00', '三亚7日游', '14');
INSERT INTO `costlog` VALUES ('28', '2017-09-11 00:25:43', '8000.00', '三亚7日游', '14');
INSERT INTO `costlog` VALUES ('29', '2017-09-11 00:25:44', '8000.00', '三亚7日游', '14');
INSERT INTO `costlog` VALUES ('30', '2017-09-11 00:27:54', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('31', '2017-09-11 00:27:54', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('32', '2017-09-11 00:27:54', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('33', '2017-09-11 00:27:54', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('34', '2017-09-11 00:27:54', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('35', '2017-09-11 00:27:55', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('36', '2017-09-11 00:27:55', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('37', '2017-09-11 00:27:55', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('38', '2017-09-11 00:27:55', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('39', '2017-09-11 00:27:55', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('40', '2017-09-11 00:27:55', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('41', '2017-09-11 00:27:55', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('42', '2017-09-11 00:27:56', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('43', '2017-09-11 00:27:56', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('44', '2017-09-11 00:27:56', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('45', '2017-09-11 00:27:56', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('46', '2017-09-11 00:27:56', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('47', '2017-09-11 00:27:56', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('48', '2017-09-11 00:27:56', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('49', '2017-09-11 00:27:57', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('50', '2017-09-11 00:27:57', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('51', '2017-09-11 00:27:58', '1000.00', '九寨沟7日游', '14');
INSERT INTO `costlog` VALUES ('52', '2017-09-11 00:27:58', '100.00', '重庆两江夜景', '14');
INSERT INTO `costlog` VALUES ('53', '2017-09-11 00:27:59', '8000.00', '三亚7日游', '14');
INSERT INTO `costlog` VALUES ('54', '2017-09-11 00:27:59', '1000.00', '九寨沟7日游', '14');
INSERT INTO `costlog` VALUES ('55', '2017-09-11 00:28:00', '100.00', '重庆两江夜景', '14');
INSERT INTO `costlog` VALUES ('56', '2017-09-11 00:28:00', '8000.00', '三亚7日游', '14');
INSERT INTO `costlog` VALUES ('57', '2017-09-11 00:28:00', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('58', '2017-09-11 00:28:01', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('59', '2017-09-11 00:28:01', '1000.00', '九寨沟7日游', '14');
INSERT INTO `costlog` VALUES ('60', '2017-09-11 00:28:02', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('61', '2017-09-11 00:28:02', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('62', '2017-09-11 00:28:02', '1.00', '欧洲10国', '14');
INSERT INTO `costlog` VALUES ('63', '2017-09-11 00:28:02', '8000.00', '三亚7日游', '14');

