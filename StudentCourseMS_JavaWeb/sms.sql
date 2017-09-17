/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : sms

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-09-17 23:14:47
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `tb_login` VALUES ('2', '1401010001', '111', '1', '1');
INSERT INTO `tb_login` VALUES ('3', '222', '222', '-1', '2');
INSERT INTO `tb_login` VALUES ('4', '1401010002', '1401010002', '0', '1');
INSERT INTO `tb_login` VALUES ('5', '1401010003', '111', '1', '1');
INSERT INTO `tb_login` VALUES ('6', '1701010001', '111', '1', '1');
INSERT INTO `tb_login` VALUES ('8', '1404010001', '111', '1', '1');
INSERT INTO `tb_login` VALUES ('9', '1701010002', '1701010002', '-1', '1');
INSERT INTO `tb_login` VALUES ('10', '1701010003', '1701010003', '-1', '1');
INSERT INTO `tb_login` VALUES ('11', '1701010004', '1701010004', '-1', '1');
INSERT INTO `tb_login` VALUES ('12', '1702020001', '1702020001', '-1', '1');
INSERT INTO `tb_login` VALUES ('13', '1702020002', '1702020002', '-1', '1');
INSERT INTO `tb_login` VALUES ('14', '1704030001', '1704030001', '-1', '1');
INSERT INTO `tb_login` VALUES ('15', '1704030002', '1704030002', '-1', '1');
INSERT INTO `tb_login` VALUES ('16', '1701020001', '1701020001', '-1', '1');
INSERT INTO `tb_login` VALUES ('17', '1701020002', '1701020002', '-1', '1');
INSERT INTO `tb_login` VALUES ('19', '1701030001', '1701030001', '-1', '1');
INSERT INTO `tb_login` VALUES ('20', '1701030002', '1701030002', '-1', '1');
INSERT INTO `tb_login` VALUES ('21', '1701040001', '1701040001', '-1', '1');
INSERT INTO `tb_login` VALUES ('23', '1701040002', '1701040002', '-1', '1');


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
INSERT INTO `tb_depart` VALUES ('1', '01', '信息科学与工程学院');
INSERT INTO `tb_depart` VALUES ('2', '02', '土木建筑学院');
INSERT INTO `tb_depart` VALUES ('3', '03', '数学与统计学院');
INSERT INTO `tb_depart` VALUES ('4', '04', '外国语学院');

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
  KEY `pro_deptid` (`pro_deptid`),
  CONSTRAINT `tb_profess_ibfk_1` FOREIGN KEY (`pro_deptid`) REFERENCES `tb_depart` (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_profess
-- ----------------------------
INSERT INTO `tb_profess` VALUES ('1', '01', '计算机科学与技术', '1', '1');
INSERT INTO `tb_profess` VALUES ('2', '02', '通信工程', '1', '1');
INSERT INTO `tb_profess` VALUES ('3', '03', '电子信息工程', '1', '1');
INSERT INTO `tb_profess` VALUES ('4', '04', '物联网工程', '1', '1');
INSERT INTO `tb_profess` VALUES ('5', '01', '建筑设计', '2', '1');
INSERT INTO `tb_profess` VALUES ('6', '02', '工程造价', '2', '1');
INSERT INTO `tb_profess` VALUES ('7', '03', '建筑安全', '2', '1');
INSERT INTO `tb_profess` VALUES ('8', '01', '会计', '3', '1');
INSERT INTO `tb_profess` VALUES ('9', '02', '金融', '3', '1');
INSERT INTO `tb_profess` VALUES ('10', '01', '英语专业', '4', '1');
INSERT INTO `tb_profess` VALUES ('11', '02', '俄语专业', '4', '1');
INSERT INTO `tb_profess` VALUES ('12', '03', '韩语专业', '4', '1');
INSERT INTO `tb_profess` VALUES ('13', '04', '法语专业', '4', '1');
INSERT INTO `tb_profess` VALUES ('14', '05', '德语专业', '4', '1');
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
INSERT INTO `tb_menu` VALUES ('1', '学生管理', '', '0');
INSERT INTO `tb_menu` VALUES ('2', '教师管理', '', '0');
INSERT INTO `tb_menu` VALUES ('3', '课程管理', null, '0');
INSERT INTO `tb_menu` VALUES ('4', '系统安全', '', '0');
INSERT INTO `tb_menu` VALUES ('15', '菜单管理', '/sms/view/menuManage.jsp', '4');
INSERT INTO `tb_menu` VALUES ('16', '角色管理', '/sms/view/roleManage.jsp', '4');
INSERT INTO `tb_menu` VALUES ('30', '修改密码', '/sms/view/updatepassword.jsp', '4');
INSERT INTO `tb_menu` VALUES ('31', '查询学生', '/sms/view/queryStudent.jsp', '1');
INSERT INTO `tb_menu` VALUES ('32', '学生信息维护', '/sms/view/studentManage.jsp', '1');
INSERT INTO `tb_menu` VALUES ('33', '查询教师', '', '2');
INSERT INTO `tb_menu` VALUES ('34', '教师信息维护', '', '2');
INSERT INTO `tb_menu` VALUES ('35', '查询课程', '', '3');
INSERT INTO `tb_menu` VALUES ('36', '课程信息维护', '', '3');
INSERT INTO `tb_menu` VALUES ('37', '选择课程', '', '3');
INSERT INTO `tb_menu` VALUES ('38', '查看选课信息', '', '3');
INSERT INTO `tb_menu` VALUES ('39', '查看成绩信息', '', '3');
INSERT INTO `tb_menu` VALUES ('40', '查看任教课程信息', '', '3');
INSERT INTO `tb_menu` VALUES ('41', '查看学生选课信息', '', '3');
INSERT INTO `tb_menu` VALUES ('42', '管理成绩信息', '', '3');

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
INSERT INTO `tb_power` VALUES ('283', '1', '3');
INSERT INTO `tb_power` VALUES ('284', '1', '37');
INSERT INTO `tb_power` VALUES ('285', '1', '38');
INSERT INTO `tb_power` VALUES ('286', '1', '39');
INSERT INTO `tb_power` VALUES ('287', '1', '4');
INSERT INTO `tb_power` VALUES ('288', '1', '30');
INSERT INTO `tb_power` VALUES ('289', '2', '3');
INSERT INTO `tb_power` VALUES ('290', '2', '40');
INSERT INTO `tb_power` VALUES ('291', '2', '41');
INSERT INTO `tb_power` VALUES ('292', '2', '42');
INSERT INTO `tb_power` VALUES ('293', '2', '4');
INSERT INTO `tb_power` VALUES ('294', '2', '30');
INSERT INTO `tb_power` VALUES ('295', '3', '1');
INSERT INTO `tb_power` VALUES ('296', '3', '31');
INSERT INTO `tb_power` VALUES ('297', '3', '32');
INSERT INTO `tb_power` VALUES ('298', '3', '2');
INSERT INTO `tb_power` VALUES ('299', '3', '33');
INSERT INTO `tb_power` VALUES ('300', '3', '34');
INSERT INTO `tb_power` VALUES ('301', '3', '3');
INSERT INTO `tb_power` VALUES ('302', '3', '35');
INSERT INTO `tb_power` VALUES ('303', '3', '36');
INSERT INTO `tb_power` VALUES ('304', '3', '4');
INSERT INTO `tb_power` VALUES ('305', '3', '15');
INSERT INTO `tb_power` VALUES ('306', '3', '16');
INSERT INTO `tb_power` VALUES ('307', '3', '30');



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



-- ----------------------------
-- Table structure for tb_students
-- ----------------------------
DROP TABLE IF EXISTS `tb_students`;
CREATE TABLE `tb_students` (
  `s_id` int(10) NOT NULL auto_increment,
  `s_no` varchar(10) default NULL,
  `s_name` varchar(20) NOT NULL,
  `s_zip` char(18) default NULL,
  `s_indate` datetime NOT NULL,
  `s_state` int(11) default NULL,
  `s_dep_no` int(5) default NULL,
  `s_pro_id` int(10) default NULL,
  PRIMARY KEY  (`s_id`),
  UNIQUE KEY `s_zip` (`s_zip`),
  UNIQUE KEY `s_no` USING BTREE (`s_no`),
  KEY `s_dep_no` (`s_dep_no`),
  KEY `s_pro_id` (`s_pro_id`),
  CONSTRAINT `tb_students_ibfk_1` FOREIGN KEY (`s_no`) REFERENCES `tb_login` (`username`),
  CONSTRAINT `tb_students_ibfk_2` FOREIGN KEY (`s_dep_no`) REFERENCES `tb_depart` (`dep_id`),
  CONSTRAINT `tb_students_ibfk_3` FOREIGN KEY (`s_pro_id`) REFERENCES `tb_profess` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_students
-- ----------------------------
INSERT INTO `tb_students` VALUES ('1', '1401010001', '郭文浩', '140000000000000000', '2014-09-01 00:00:00', '1', '1', '1');
INSERT INTO `tb_students` VALUES ('2', '1401010002', '张三', '500000000000000001', '2014-09-01 00:00:00', '0', '1', '1');
INSERT INTO `tb_students` VALUES ('3', '1401010003', '李四', '500000000000000002', '2014-09-01 00:00:00', '1', '1', '1');
INSERT INTO `tb_students` VALUES ('4', '1701010001', '王五', '500000000000000003', '2017-09-01 00:00:00', '1', '1', '1');
INSERT INTO `tb_students` VALUES ('5', '1404010001', '赵六六', '500000000000000004', '2014-09-01 00:00:00', '1', '4', '10');
INSERT INTO `tb_students` VALUES ('6', '1701010002', '田七', '500000000000000005', '2017-09-01 00:00:00', '1', '1', '1');
INSERT INTO `tb_students` VALUES ('7', '1701010003', '薛之谦', '500000000000000006', '2017-09-01 00:00:00', '1', '1', '1');
INSERT INTO `tb_students` VALUES ('8', '1701010004', '杨迪', '500000000000000007', '2017-09-01 00:00:00', '1', '1', '1');
INSERT INTO `tb_students` VALUES ('9', '1702020001', '钱枫', '500000000000000008', '2017-09-01 00:00:00', '1', '2', '6');
INSERT INTO `tb_students` VALUES ('10', '1702020002', '田源', '500000000000000009', '2017-09-01 00:00:00', '1', '2', '6');
INSERT INTO `tb_students` VALUES ('11', '1704030001', '郭雪芙', '500000000000000010', '2017-09-01 00:00:00', '1', '4', '12');
INSERT INTO `tb_students` VALUES ('12', '1704030002', '沈梦辰', '500000000000000011', '2017-09-01 00:00:00', '1', '4', '12');
INSERT INTO `tb_students` VALUES ('13', '1701020001', '张无忌', '500000000000000012', '2017-09-01 00:00:00', '1', '1', '2');
INSERT INTO `tb_students` VALUES ('14', '1701020002', '张三丰', '500000000000000013', '2017-09-01 00:00:00', '1', '1', '2');
INSERT INTO `tb_students` VALUES ('15', '1701030001', '灭绝师太', '500000000000000014', '2017-09-01 00:00:00', '1', '1', '3');
INSERT INTO `tb_students` VALUES ('16', '1701030002', '周芷若', '500000000000000015', '2017-09-01 00:00:00', '1', '1', '3');
INSERT INTO `tb_students` VALUES ('17', '1701040001', '杨过', '500000000000000016', '2017-09-01 00:00:00', '1', '1', '4');
INSERT INTO `tb_students` VALUES ('18', '1701040002', '小龙女', '500000000000000017', '2017-09-01 00:00:00', '1', '1', '4');
