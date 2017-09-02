/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : resume_ms

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-09-03 01:09:38
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'gds', '111');
INSERT INTO `user` VALUES ('2', 'zhangsan', '111');
INSERT INTO `user` VALUES ('3', 'lisi', '111');

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(3) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `nation` varchar(10) DEFAULT NULL,
  `zzmm` varchar(10) DEFAULT NULL,
  `hight` float(4,1) DEFAULT NULL,
  `major` varchar(20) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `cet` varchar(10) DEFAULT NULL,
  `computer` varchar(10) DEFAULT NULL,
  `expt1` date DEFAULT NULL,
  `expc1` varchar(20) DEFAULT NULL,
  `expe1` varchar(100) DEFAULT NULL,
  `expt2` date DEFAULT NULL,
  `expc2` varchar(20) DEFAULT NULL,
  `expe2` varchar(100) DEFAULT NULL,
  `expt3` date DEFAULT NULL,
  `expc3` varchar(20) DEFAULT NULL,
  `expe3` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `host` varchar(10) DEFAULT NULL,
  `selfevaluation` text,
  PRIMARY KEY (`id`),
  CONSTRAINT `resume_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('1', '郭文浩', '男', '1996-07-01', '汉族', '党员', '180.0', '计算机科学与技术', '重庆交通大学', '专业英语八级', '中级软件设计师', '2016-06-01', '腾讯', '我也不知道干了啥', '2017-01-01', '华为', '还是不知道干了啥', '2017-08-01', '中软国际', '在这里学习高大上的技术', '重庆市南岸区重庆交通大学知园', '18581485921', '1842297753@qq.com', '400074', '一个活泼开朗英俊潇洒的帅小伙');
INSERT INTO `resume` VALUES ('2', '张三', '男', '1995-02-03', '汉族', '团员', '159.5', '通信工程', '重庆交通大学', '大学英语四级', '计算级二级', '2016-05-01', '滴滴', '开车', null, '', '', null, '', '', '重庆市南岸区重庆交通大学知园', '18322221111', '18322221111@qq.com', '', '一个哈皮');
INSERT INTO `resume` VALUES ('3', '李四', '女', '1998-11-11', '回族', '群众', '171.5', '物联网', '重庆交通大学', '', '', '2016-07-01', '美团', '送外卖', null, '', '', null, '', '', '重庆市南岸区重庆交通大学知园', '18588887777', '18588887777@qq.com', '', '一个美女');
