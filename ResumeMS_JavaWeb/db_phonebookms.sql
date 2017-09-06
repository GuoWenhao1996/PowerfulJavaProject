/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : db_phonebookms

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-09-06 01:10:01
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
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin1', 'admin1', '小白', '18888888888', '18811312@qq.com', '重庆市南岸区啦啦啦啦啦');
INSERT INTO `user` VALUES ('2', 'hahaha', 'hahaha', '哈哈哈', '1331111222', '131312312@qq.com', '四川省成都市天府广场');


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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

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