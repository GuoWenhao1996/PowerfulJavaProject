/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : db_phonebookms

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-09-07 11:53:53
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `telephone` varchar(11) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `url` varchar(200) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin1', 'admin1', '小白', '18888888888', '18811312@qq.com', '重庆市南岸区啦啦啦啦啦', '/PhoneBookMS/img/default.png');
INSERT INTO `user` VALUES ('2', 'hahaha', 'hahaha', '哈哈哈', '1331111222', '131312312@qq.com', '四川省成都市天府广场', '/PhoneBookMS/img/default2.png');

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `telephone` varchar(11) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `uid` (`uid`),
  CONSTRAINT `friend_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES ('1', '张三', '1994-06-15', '13111111112', '1', '87126351236', '123@132.com', '重庆市南岸区学府大道', '1');
INSERT INTO `friend` VALUES ('2', '李四', '1996-12-20', '13111111112', '2', '12356781123', '12322222222222@132.com', '重庆市南岸区学府大道', '1');
INSERT INTO `friend` VALUES ('3', '王五', '1992-02-10', '13211112222', '2', '13123124', '122223111@132.com', '重庆市沙坪坝区西科公寓', '1');
INSERT INTO `friend` VALUES ('4', '赵六', '1989-02-22', '13211221122', '2', '123678345', '121233@132.com', '重庆市沙坪坝区西科公寓', '1');
INSERT INTO `friend` VALUES ('5', '田七', '1997-10-22', '13888888888', '2', '1235685', '121121233@132.com', '重庆市江北区', '1');
INSERT INTO `friend` VALUES ('6', '刘德华', '1999-06-08', '13666666666', '1', '123132', '123132@qq.com', '重庆市江北区', '1');
INSERT INTO `friend` VALUES ('7', '周星驰', '1970-01-13', '13444444444', '1', '181818181', '181818181@qq.com', '重庆市江北区', '2');
INSERT INTO `friend` VALUES ('8', '张学友', '1975-02-11', '13222220000', '1', '1235685111', '1235685111@qq.com', '重庆市江北区', '2');
INSERT INTO `friend` VALUES ('9', '薛之谦', '1980-02-13', '18234566543', '1', '1321123888', '1321123888@qq.com', '重庆市沙坪坝区西科公寓', '1');
INSERT INTO `friend` VALUES ('10', '刘亦菲', '1990-03-15', '17211112222', '2', '17211112222', '17211112222@qq.com', '重庆市沙坪坝区西科公寓', '1');
INSERT INTO `friend` VALUES ('11', '郭文浩', '1996-07-16', '18765432121', '1', '181122122', '181122122@qq.com', '重庆市南岸区学府大道', '1');
INSERT INTO `friend` VALUES ('12', '刘诗诗', '1985-07-17', '13111113333', '2', '13111113333', '13111113333@qq.com', '重庆市沙坪坝区西科公寓', '1');
INSERT INTO `friend` VALUES ('13', '汪涵', '1975-01-14', '18966665555', '1', '18966665555', '18966665555@qq.com', '重庆市江北区', '1');
INSERT INTO `friend` VALUES ('14', '周星驰', '1970-02-05', '18666666666', '1', '18666666666', '18666666666@qq.com', '重庆市南岸区', '1');
INSERT INTO `friend` VALUES ('15', '张无忌', null, '18798798711', '1', '', '', '', '1');
INSERT INTO `friend` VALUES ('16', 'Bob', '1978-03-15', '18112121212', '1', '', '', '', '1');
INSERT INTO `friend` VALUES ('17', '张三丰', '1820-02-08', '18777777777', '1', '', '', '武当山', '1');
INSERT INTO `friend` VALUES ('18', '灭绝师太', '1800-08-06', '13434343434', '2', '', '', '峨眉山', '1');
INSERT INTO `friend` VALUES ('19', '周芷若', '1990-11-08', '13433334444', '2', '', '', '峨眉山', '1');
INSERT INTO `friend` VALUES ('20', '张三三', '2017-08-28', '13434343434', '1', '', '', '1111111', '1');
INSERT INTO `friend` VALUES ('21', '周杰伦1', '2017-09-06', '18666666666', '1', '', '', '111111', '1');
INSERT INTO `friend` VALUES ('22', '周星驰3', '2017-09-06', '18712311231', '1', '', '', '123', '1');
INSERT INTO `friend` VALUES ('23', '周杰伦4', '2017-09-24', '18712311231', '1', '12222', '', 'ddsdsdsd', '1');
INSERT INTO `friend` VALUES ('24', '周杰伦2', '2017-09-03', '18666666666', '1', '18666666666', '18666666666@qq.com', '18666666666', '1');
INSERT INTO `friend` VALUES ('25', '周杰伦5', '2017-08-29', '13434343434', '1', '12222', '18666666666@qq.com', '111111', '1');
INSERT INTO `friend` VALUES ('26', '灭绝师太2', '2017-08-28', '18112121212', '2', '18666666666', '18666666666@qq.com', '111213', '1');
INSERT INTO `friend` VALUES ('27', '张无忌1', '2017-08-27', '13434343434', '1', '12222', '18666666666@qq.com', '1', '1');
