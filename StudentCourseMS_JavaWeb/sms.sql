/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : sms

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-09-15 02:36:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_depart
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart` (
  `dep_id` int(5) NOT NULL auto_increment,
  `dep_no` varchar(20) default NULL,
  `dep_name` varchar(20) NOT NULL,
  PRIMARY KEY  (`dep_id`),
  UNIQUE KEY `dep_no` (`dep_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_depart
-- ----------------------------

-- ----------------------------
-- Table structure for tb_profess
-- ----------------------------
DROP TABLE IF EXISTS `tb_profess`;
CREATE TABLE `tb_profess` (
  `pro_id` int(10) NOT NULL auto_increment,
  `pro_no` varchar(20) default NULL,
  `pro_name` varchar(50) NOT NULL,
  `pro_deptid` int(5) default NULL,
  `pro_state` char(1) NOT NULL,
  PRIMARY KEY  (`pro_id`),
  UNIQUE KEY `pro_no` (`pro_no`),
  KEY `pro_deptid` (`pro_deptid`),
  CONSTRAINT `tb_profess_ibfk_1` FOREIGN KEY (`pro_deptid`) REFERENCES `tb_depart` (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_profess
-- ----------------------------

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course` (
  `c_id` int(10) NOT NULL auto_increment,
  `c_no` varchar(20) default NULL,
  `c_name` varchar(50) NOT NULL,
  `c_pro_id` int(10) default NULL,
  PRIMARY KEY  (`c_id`),
  UNIQUE KEY `c_no` (`c_no`),
  KEY `c_pro_id` (`c_pro_id`),
  CONSTRAINT `tb_course_ibfk_1` FOREIGN KEY (`c_pro_id`) REFERENCES `tb_profess` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_course
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `rid` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY  (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '学生');
INSERT INTO `tb_role` VALUES ('2', '教师');
INSERT INTO `tb_role` VALUES ('3', '管理员');

-- ----------------------------
-- Table structure for tb_login
-- ----------------------------
DROP TABLE IF EXISTS `tb_login`;
CREATE TABLE `tb_login` (
  `id` int(10) NOT NULL auto_increment,
  `username` varchar(10) default NULL,
  `password` varchar(20) NOT NULL,
  `state` int(1) default NULL,
  `usertype` int(1) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `usertype` (`usertype`),
  CONSTRAINT `tb_login_ibfk_1` FOREIGN KEY (`usertype`) REFERENCES `tb_role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_login
-- ----------------------------
INSERT INTO `tb_login` VALUES ('1', 'admin', 'admin', '1', '3');
INSERT INTO `tb_login` VALUES ('2', '111', '111', '1', '1');
INSERT INTO `tb_login` VALUES ('3', '222', '222', '1', '2');


-- ----------------------------
-- Table structure for tb_teachers
-- ----------------------------
DROP TABLE IF EXISTS `tb_teachers`;
CREATE TABLE `tb_teachers` (
  `t_id` int(5) NOT NULL auto_increment,
  `t_no` varchar(10) default NULL,
  `t_name` varchar(20) NOT NULL,
  `t_zip` char(18) default NULL,
  `t_date` date NOT NULL,
  `t_depno` int(5) default NULL,
  PRIMARY KEY  (`t_id`),
  UNIQUE KEY `t_zip` (`t_zip`),
  KEY `t_no` (`t_no`),
  KEY `t_depno` (`t_depno`),
  CONSTRAINT `tb_teachers_ibfk_1` FOREIGN KEY (`t_no`) REFERENCES `tb_login` (`username`),
  CONSTRAINT `tb_teachers_ibfk_2` FOREIGN KEY (`t_depno`) REFERENCES `tb_depart` (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teachers
-- ----------------------------

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `cl_id` int(10) NOT NULL auto_increment,
  `cl_c_no` int(10) default NULL,
  `cl_t_no` int(10) default NULL,
  PRIMARY KEY  (`cl_id`),
  KEY `cl_c_no` (`cl_c_no`),
  KEY `cl_t_no` (`cl_t_no`),
  CONSTRAINT `tb_class_ibfk_1` FOREIGN KEY (`cl_c_no`) REFERENCES `tb_course` (`c_id`),
  CONSTRAINT `tb_class_ibfk_2` FOREIGN KEY (`cl_t_no`) REFERENCES `tb_teachers` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_class
-- ----------------------------


-- ----------------------------
-- Table structure for tb_courseinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_courseinfo`;
CREATE TABLE `tb_courseinfo` (
  `co_id` int(10) NOT NULL auto_increment,
  `co_c_id` int(10) default NULL,
  `co_redit` int(2) NOT NULL,
  `co_time` int(2) NOT NULL,
  `co_date` date NOT NULL,
  `co_state` char(1) default NULL,
  `co_cstu` int(10) NOT NULL,
  PRIMARY KEY  (`co_id`),
  KEY `co_c_id` (`co_c_id`),
  CONSTRAINT `tb_courseinfo_ibfk_1` FOREIGN KEY (`co_c_id`) REFERENCES `tb_course` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_courseinfo
-- ----------------------------

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `mid` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `url` varchar(200) default NULL,
  `parentid` int(11) NOT NULL,
  PRIMARY KEY  (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', '学生管理', null, '0');
INSERT INTO `tb_menu` VALUES ('2', '教师管理', null, '0');
INSERT INTO `tb_menu` VALUES ('3', '课程管理', null, '0');
INSERT INTO `tb_menu` VALUES ('4', '系统管理', null, '0');
INSERT INTO `tb_menu` VALUES ('5', '增加学生', 'http://gwhcool.cn:8080', '1');
INSERT INTO `tb_menu` VALUES ('6', '查询学生', 'http://gwhcool.cn:8080', '1');
INSERT INTO `tb_menu` VALUES ('7', '修改学生', 'http://gwhcool.cn:8080', '1');
INSERT INTO `tb_menu` VALUES ('8', '增加教师', 'http://www.baidu.com', '2');
INSERT INTO `tb_menu` VALUES ('9', '查询教师', 'http://www.baidu.com', '2');
INSERT INTO `tb_menu` VALUES ('10', '修改教师', 'http://www.baidu.com', '2');
INSERT INTO `tb_menu` VALUES ('11', '增加课程', null, '3');
INSERT INTO `tb_menu` VALUES ('12', '查询课程', null, '3');
INSERT INTO `tb_menu` VALUES ('13', '修改课程', null, '3');
INSERT INTO `tb_menu` VALUES ('14', '增加选课', null, '3');
INSERT INTO `tb_menu` VALUES ('15', '菜单管理', '/sms/view/menuManage.jsp', '4');
INSERT INTO `tb_menu` VALUES ('16', '角色管理', '/sms/view/roleManage.jsp', '4');

-- ----------------------------
-- Table structure for tb_power
-- ----------------------------
DROP TABLE IF EXISTS `tb_power`;
CREATE TABLE `tb_power` (
  `pid` int(11) NOT NULL auto_increment,
  `rid` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  PRIMARY KEY  (`pid`),
  KEY `rid` (`rid`),
  KEY `mid` (`mid`),
  CONSTRAINT `tb_power_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `tb_role` (`rid`),
  CONSTRAINT `tb_power_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `tb_menu` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_power
-- ----------------------------
INSERT INTO `tb_power` VALUES ('38', '2', '1');
INSERT INTO `tb_power` VALUES ('39', '2', '6');
INSERT INTO `tb_power` VALUES ('40', '2', '2');
INSERT INTO `tb_power` VALUES ('41', '2', '9');
INSERT INTO `tb_power` VALUES ('42', '2', '10');
INSERT INTO `tb_power` VALUES ('43', '2', '3');
INSERT INTO `tb_power` VALUES ('44', '2', '11');
INSERT INTO `tb_power` VALUES ('45', '2', '12');
INSERT INTO `tb_power` VALUES ('46', '2', '13');
INSERT INTO `tb_power` VALUES ('47', '2', '14');
INSERT INTO `tb_power` VALUES ('56', '1', '1');
INSERT INTO `tb_power` VALUES ('57', '1', '6');
INSERT INTO `tb_power` VALUES ('58', '1', '7');
INSERT INTO `tb_power` VALUES ('59', '1', '2');
INSERT INTO `tb_power` VALUES ('60', '1', '9');
INSERT INTO `tb_power` VALUES ('61', '1', '3');
INSERT INTO `tb_power` VALUES ('62', '1', '12');
INSERT INTO `tb_power` VALUES ('63', '1', '14');
INSERT INTO `tb_power` VALUES ('64', '3', '1');
INSERT INTO `tb_power` VALUES ('65', '3', '5');
INSERT INTO `tb_power` VALUES ('66', '3', '6');
INSERT INTO `tb_power` VALUES ('67', '3', '7');
INSERT INTO `tb_power` VALUES ('68', '3', '2');
INSERT INTO `tb_power` VALUES ('69', '3', '8');
INSERT INTO `tb_power` VALUES ('70', '3', '9');
INSERT INTO `tb_power` VALUES ('71', '3', '10');
INSERT INTO `tb_power` VALUES ('72', '3', '3');
INSERT INTO `tb_power` VALUES ('73', '3', '11');
INSERT INTO `tb_power` VALUES ('74', '3', '12');
INSERT INTO `tb_power` VALUES ('75', '3', '13');
INSERT INTO `tb_power` VALUES ('76', '3', '14');
INSERT INTO `tb_power` VALUES ('77', '3', '4');
INSERT INTO `tb_power` VALUES ('78', '3', '15');
INSERT INTO `tb_power` VALUES ('79', '3', '16');


-- ----------------------------
-- Table structure for tb_students
-- ----------------------------
DROP TABLE IF EXISTS `tb_students`;
CREATE TABLE `tb_students` (
  `s_id` int(10) NOT NULL auto_increment,
  `s_no` varchar(10) default NULL,
  `s_name` varchar(20) NOT NULL,
  `s_zip` char(18) default NULL,
  `s_indate` date NOT NULL,
  `s_dep_no` int(5) default NULL,
  `s_pro_id` int(10) default NULL,
  PRIMARY KEY  (`s_id`),
  UNIQUE KEY `s_zip` (`s_zip`),
  KEY `s_no` (`s_no`),
  KEY `s_dep_no` (`s_dep_no`),
  KEY `s_pro_id` (`s_pro_id`),
  CONSTRAINT `tb_students_ibfk_1` FOREIGN KEY (`s_no`) REFERENCES `tb_login` (`username`),
  CONSTRAINT `tb_students_ibfk_2` FOREIGN KEY (`s_dep_no`) REFERENCES `tb_depart` (`dep_id`),
  CONSTRAINT `tb_students_ibfk_3` FOREIGN KEY (`s_pro_id`) REFERENCES `tb_profess` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_students
-- ----------------------------

-- ----------------------------
-- Table structure for tb_result
-- ----------------------------
DROP TABLE IF EXISTS `tb_result`;
CREATE TABLE `tb_result` (
  `re_id` int(10) NOT NULL auto_increment,
  `re_s_no` int(10) default NULL,
  `re_c_no` int(10) default NULL,
  `re_score` double(3,1) NOT NULL,
  PRIMARY KEY  (`re_id`),
  KEY `re_s_no` (`re_s_no`),
  KEY `re_c_no` (`re_c_no`),
  CONSTRAINT `tb_result_ibfk_1` FOREIGN KEY (`re_s_no`) REFERENCES `tb_students` (`s_id`),
  CONSTRAINT `tb_result_ibfk_2` FOREIGN KEY (`re_c_no`) REFERENCES `tb_course` (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_result
-- ----------------------------
