/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : 127.0.0.1:3306
Source Database       : tiremusic2

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-09-30 09:04:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `albumid` int(10) NOT NULL AUTO_INCREMENT,
  `albumname` varchar(100) NOT NULL,
  `releasetime` datetime DEFAULT NULL,
  `albumtext` varchar(500) NOT NULL,
  `albumstate` int(1) DEFAULT NULL,
  PRIMARY KEY (`albumid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='专辑信息';

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('1', '叶惠美', '2004-06-19 17:10:47', '专辑《叶惠美》', '1');
INSERT INTO `album` VALUES ('2', '范特西', '2010-07-22 17:11:14', '专辑《范特西》', '1');
INSERT INTO `album` VALUES ('3', '七里香', '1990-03-16 17:11:31', '专辑《七里香》', '1');
INSERT INTO `album` VALUES ('4', '和自己对话 From M.E. To Myself', '2015-07-30 19:26:41', '专辑《和自己对话 From M.E. To Myself》', '1');
INSERT INTO `album` VALUES ('5', '无法长大', '2016-12-15 17:13:15', '专辑《无法长大》', '1');
INSERT INTO `album` VALUES ('6', '青年晚报', '2016-07-14 17:13:42', '专辑《青年晚报》', '1');
INSERT INTO `album` VALUES ('7', '敷衍', '2015-07-23 09:24:13', '专辑《敷衍》', '1');
INSERT INTO `album` VALUES ('8', 'The Best Of Best', '2011-06-16 09:25:18', '专辑《The Best Of Best》', '1');
INSERT INTO `album` VALUES ('9', '情菲得意', '2001-08-28 09:26:17', '专辑《情菲得意》', '1');
INSERT INTO `album` VALUES ('10', '再遇不到你这样的人', '2017-09-07 09:38:31', '专辑', '1');
INSERT INTO `album` VALUES ('11', 'Touch Of Love', '2017-03-09 09:38:57', '专辑', '1');
INSERT INTO `album` VALUES ('12', '盖亚', '2012-03-08 09:40:22', '专辑《盖亚》', '1');
INSERT INTO `album` VALUES ('13', '非主打忆莲', '2000-07-23 09:40:53', '专辑《非主打忆莲》', '1');
INSERT INTO `album` VALUES ('14', '夜色无边演唱会2005', '2005-12-28 09:41:18', '专辑《夜色无边演唱会2005》', '1');
INSERT INTO `album` VALUES ('15', '感觉完美', '2000-04-01 09:41:40', '专辑《感觉完美》', '1');
INSERT INTO `album` VALUES ('16', '宝贝说再见', '2011-07-28 09:42:51', '专辑《宝贝说再见》', '1');
INSERT INTO `album` VALUES ('17', '708090后', '2012-05-28 09:43:38', '专辑《708090后》', '1');
INSERT INTO `album` VALUES ('18', '《16届亚运会》候选会歌', '2000-02-18 09:43:59', '专辑《《16届亚运会》候选会歌》', '1');
INSERT INTO `album` VALUES ('19', 'The Best Sound Ever Reborn-爱的根源', '2010-10-28 09:44:28', '专辑《The Best Sound Ever Reborn-爱的根源》', '1');
INSERT INTO `album` VALUES ('20', '左麟右李', '2004-10-21 09:44:50', '专辑《左麟右李》', '1');
INSERT INTO `album` VALUES ('21', '谭咏麟魅力千禧演唱会', '2000-10-25 09:45:26', '专辑《谭咏麟魅力千禧演唱会》', '1');
INSERT INTO `album` VALUES ('22', '置身事外', '2009-06-24 09:46:15', '专辑《置身事外》', '1');
INSERT INTO `album` VALUES ('23', '超级星光pk宝典', '2008-10-15 09:46:36', '专辑《超级星光pk宝典》', '1');
INSERT INTO `album` VALUES ('24', '钻石金选集', '2017-07-14 09:47:02', '专辑《钻石金选集》', '1');
INSERT INTO `album` VALUES ('25', '花的微笑', '2017-09-04 09:48:14', '专辑《花的微笑》', '1');
INSERT INTO `album` VALUES ('26', '幸福时光', '2010-06-28 09:48:36', '专辑《幸福时光》', '1');
INSERT INTO `album` VALUES ('27', 'WOW3,LIVE,DVD', '2010-07-28 09:49:21', '专辑《WOW3,LIVE,DVD》', '1');
INSERT INTO `album` VALUES ('28', '3面夏娃', '2005-11-28 09:49:41', '专辑《3面夏娃》', '1');
INSERT INTO `album` VALUES ('29', '第五大道', '2003-06-28 09:50:07', '专辑《第五大道》', '1');
INSERT INTO `album` VALUES ('30', '萧亚轩首张同名专辑', '1999-11-28 09:50:29', '专辑《萧亚轩首张同名专辑》', '1');
INSERT INTO `album` VALUES ('31', '爱,在一起Together', '2013-06-14 09:51:27', '专辑《爱,在一起Together》', '1');

-- ----------------------------
-- Table structure for audition
-- ----------------------------
DROP TABLE IF EXISTS `audition`;
CREATE TABLE `audition` (
  `auditionid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  PRIMARY KEY (`auditionid`),
  KEY `FK_user_listener2` (`uid`),
  CONSTRAINT `FK_user_listener2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='歌曲试听信息';

-- ----------------------------
-- Records of audition
-- ----------------------------
INSERT INTO `audition` VALUES ('1', '1');
INSERT INTO `audition` VALUES ('2', '2');
INSERT INTO `audition` VALUES ('3', '3');
INSERT INTO `audition` VALUES ('4', '4');
INSERT INTO `audition` VALUES ('5', '5');
INSERT INTO `audition` VALUES ('6', '6');
INSERT INTO `audition` VALUES ('7', '7');
INSERT INTO `audition` VALUES ('8', '8');
INSERT INTO `audition` VALUES ('9', '9');
INSERT INTO `audition` VALUES ('10', '10');
INSERT INTO `audition` VALUES ('11', '11');
INSERT INTO `audition` VALUES ('12', '12');
INSERT INTO `audition` VALUES ('13', '13');
INSERT INTO `audition` VALUES ('14', '14');
INSERT INTO `audition` VALUES ('15', '15');
INSERT INTO `audition` VALUES ('16', '16');
INSERT INTO `audition` VALUES ('17', '17');
INSERT INTO `audition` VALUES ('18', '18');
INSERT INTO `audition` VALUES ('19', '19');
INSERT INTO `audition` VALUES ('20', '20');
INSERT INTO `audition` VALUES ('21', '21');
INSERT INTO `audition` VALUES ('22', '22');
INSERT INTO `audition` VALUES ('23', '23');
INSERT INTO `audition` VALUES ('24', '24');
INSERT INTO `audition` VALUES ('25', '25');
INSERT INTO `audition` VALUES ('26', '26');
INSERT INTO `audition` VALUES ('27', '27');
INSERT INTO `audition` VALUES ('28', '28');
INSERT INTO `audition` VALUES ('29', '29');
INSERT INTO `audition` VALUES ('30', '30');
INSERT INTO `audition` VALUES ('31', '31');
INSERT INTO `audition` VALUES ('32', '32');
INSERT INTO `audition` VALUES ('33', '33');
INSERT INTO `audition` VALUES ('34', '34');
INSERT INTO `audition` VALUES ('35', '35');
INSERT INTO `audition` VALUES ('36', '36');
INSERT INTO `audition` VALUES ('37', '37');
INSERT INTO `audition` VALUES ('38', '38');
INSERT INTO `audition` VALUES ('39', '39');
INSERT INTO `audition` VALUES ('40', '40');
INSERT INTO `audition` VALUES ('41', '41');
INSERT INTO `audition` VALUES ('42', '42');
INSERT INTO `audition` VALUES ('43', '43');
INSERT INTO `audition` VALUES ('44', '44');
INSERT INTO `audition` VALUES ('45', '45');
INSERT INTO `audition` VALUES ('46', '46');
INSERT INTO `audition` VALUES ('47', '47');
INSERT INTO `audition` VALUES ('48', '48');
INSERT INTO `audition` VALUES ('49', '49');
INSERT INTO `audition` VALUES ('50', '50');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(10) NOT NULL AUTO_INCREMENT,
  `songid` int(10) NOT NULL,
  `uid` int(10) NOT NULL,
  `commentcontent` varchar(200) DEFAULT NULL,
  `commenttime` datetime DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `FK_comment_song` (`songid`),
  KEY `FK_user_comment` (`uid`),
  CONSTRAINT `FK_comment_song` FOREIGN KEY (`songid`) REFERENCES `song` (`songid`),
  CONSTRAINT `FK_user_comment` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户评论歌曲';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '好歌', '2017-09-26 22:54:12');
INSERT INTO `comment` VALUES ('2', '1', '2', '很喜欢这首歌', '2017-09-26 22:54:23');
INSERT INTO `comment` VALUES ('3', '1', '3', '赞赞赞赞赞', '2017-09-26 22:54:34');
INSERT INTO `comment` VALUES ('4', '1', '4', '薛之谦好厉害', '2017-09-26 22:54:46');
INSERT INTO `comment` VALUES ('5', '1', '1', '这是一条评论', '2017-09-26 22:55:26');
INSERT INTO `comment` VALUES ('7', '1', '1', '好歌', '2017-09-27 11:18:52');
INSERT INTO `comment` VALUES ('8', '1', '1', '很喜欢这首歌', '2017-09-27 11:18:54');
INSERT INTO `comment` VALUES ('9', '1', '1', '赞赞赞赞赞', '2017-09-28 10:51:18');
INSERT INTO `comment` VALUES ('12', '1', '2', '66666666666', '2017-09-28 11:07:26');
INSERT INTO `comment` VALUES ('13', '2', '1', '薛之谦好厉害', '2017-09-28 11:08:01');
INSERT INTO `comment` VALUES ('14', '5', '1', '快使用双截棍', '2017-09-28 11:08:14');
INSERT INTO `comment` VALUES ('16', '1', '1', '23333333', '2017-09-28 11:42:26');
INSERT INTO `comment` VALUES ('17', '2', '1000000152', '厉害个毛', '2017-09-29 09:24:02');
INSERT INTO `comment` VALUES ('19', '16', '1000000153', '好听', '2017-09-29 09:41:17');
INSERT INTO `comment` VALUES ('20', '1', '1000000152', '好好听哦', '2017-09-29 10:26:14');
INSERT INTO `comment` VALUES ('21', '24', '1000000152', '超爱听这首歌', '2017-09-29 11:00:20');
INSERT INTO `comment` VALUES ('24', '1', '1', '逗比', '2017-09-29 12:20:46');

-- ----------------------------
-- Table structure for conform
-- ----------------------------
DROP TABLE IF EXISTS `conform`;
CREATE TABLE `conform` (
  `confirmid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  PRIMARY KEY (`confirmid`),
  KEY `FK_user_conformto2` (`uid`),
  CONSTRAINT `FK_user_conformto2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='关注信息';

-- ----------------------------
-- Records of conform
-- ----------------------------
INSERT INTO `conform` VALUES ('1', '1');
INSERT INTO `conform` VALUES ('2', '2');
INSERT INTO `conform` VALUES ('3', '3');
INSERT INTO `conform` VALUES ('4', '4');
INSERT INTO `conform` VALUES ('5', '5');
INSERT INTO `conform` VALUES ('6', '6');
INSERT INTO `conform` VALUES ('7', '7');
INSERT INTO `conform` VALUES ('8', '8');
INSERT INTO `conform` VALUES ('9', '9');
INSERT INTO `conform` VALUES ('10', '10');
INSERT INTO `conform` VALUES ('11', '11');
INSERT INTO `conform` VALUES ('12', '12');
INSERT INTO `conform` VALUES ('13', '13');
INSERT INTO `conform` VALUES ('14', '14');
INSERT INTO `conform` VALUES ('15', '15');
INSERT INTO `conform` VALUES ('16', '16');
INSERT INTO `conform` VALUES ('17', '17');
INSERT INTO `conform` VALUES ('18', '18');
INSERT INTO `conform` VALUES ('19', '19');
INSERT INTO `conform` VALUES ('20', '20');
INSERT INTO `conform` VALUES ('21', '21');
INSERT INTO `conform` VALUES ('22', '22');
INSERT INTO `conform` VALUES ('23', '23');
INSERT INTO `conform` VALUES ('24', '24');
INSERT INTO `conform` VALUES ('25', '25');
INSERT INTO `conform` VALUES ('26', '26');
INSERT INTO `conform` VALUES ('27', '27');
INSERT INTO `conform` VALUES ('28', '28');
INSERT INTO `conform` VALUES ('29', '29');
INSERT INTO `conform` VALUES ('30', '30');
INSERT INTO `conform` VALUES ('31', '31');
INSERT INTO `conform` VALUES ('32', '32');
INSERT INTO `conform` VALUES ('33', '33');
INSERT INTO `conform` VALUES ('34', '34');
INSERT INTO `conform` VALUES ('35', '35');
INSERT INTO `conform` VALUES ('36', '36');
INSERT INTO `conform` VALUES ('37', '37');
INSERT INTO `conform` VALUES ('38', '38');
INSERT INTO `conform` VALUES ('39', '39');
INSERT INTO `conform` VALUES ('40', '40');
INSERT INTO `conform` VALUES ('41', '41');
INSERT INTO `conform` VALUES ('42', '42');
INSERT INTO `conform` VALUES ('43', '43');
INSERT INTO `conform` VALUES ('44', '44');
INSERT INTO `conform` VALUES ('45', '45');
INSERT INTO `conform` VALUES ('46', '46');
INSERT INTO `conform` VALUES ('47', '47');
INSERT INTO `conform` VALUES ('48', '48');
INSERT INTO `conform` VALUES ('49', '49');
INSERT INTO `conform` VALUES ('50', '50');
INSERT INTO `conform` VALUES ('51', '1000000151');
INSERT INTO `conform` VALUES ('52', '1000000152');
INSERT INTO `conform` VALUES ('53', '1000000153');
INSERT INTO `conform` VALUES ('54', '1000000154');

-- ----------------------------
-- Table structure for download
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download` (
  `Downloadlistid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  PRIMARY KEY (`Downloadlistid`),
  KEY `FK_user_download1` (`uid`),
  CONSTRAINT `FK_user_download1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='歌曲下载信息';

-- ----------------------------
-- Records of download
-- ----------------------------
INSERT INTO `download` VALUES ('1', '1');
INSERT INTO `download` VALUES ('2', '2');
INSERT INTO `download` VALUES ('3', '3');
INSERT INTO `download` VALUES ('4', '4');
INSERT INTO `download` VALUES ('5', '5');
INSERT INTO `download` VALUES ('6', '6');
INSERT INTO `download` VALUES ('7', '7');
INSERT INTO `download` VALUES ('8', '8');
INSERT INTO `download` VALUES ('9', '9');
INSERT INTO `download` VALUES ('10', '10');
INSERT INTO `download` VALUES ('11', '11');
INSERT INTO `download` VALUES ('12', '12');
INSERT INTO `download` VALUES ('13', '13');
INSERT INTO `download` VALUES ('14', '14');
INSERT INTO `download` VALUES ('15', '15');
INSERT INTO `download` VALUES ('16', '16');
INSERT INTO `download` VALUES ('17', '17');
INSERT INTO `download` VALUES ('18', '18');
INSERT INTO `download` VALUES ('19', '19');
INSERT INTO `download` VALUES ('20', '20');
INSERT INTO `download` VALUES ('21', '21');
INSERT INTO `download` VALUES ('22', '22');
INSERT INTO `download` VALUES ('23', '23');
INSERT INTO `download` VALUES ('24', '24');
INSERT INTO `download` VALUES ('25', '25');
INSERT INTO `download` VALUES ('26', '26');
INSERT INTO `download` VALUES ('27', '27');
INSERT INTO `download` VALUES ('28', '28');
INSERT INTO `download` VALUES ('29', '29');
INSERT INTO `download` VALUES ('30', '30');
INSERT INTO `download` VALUES ('31', '31');
INSERT INTO `download` VALUES ('32', '32');
INSERT INTO `download` VALUES ('33', '33');
INSERT INTO `download` VALUES ('34', '34');
INSERT INTO `download` VALUES ('35', '35');
INSERT INTO `download` VALUES ('36', '36');
INSERT INTO `download` VALUES ('37', '37');
INSERT INTO `download` VALUES ('38', '38');
INSERT INTO `download` VALUES ('39', '39');
INSERT INTO `download` VALUES ('40', '40');
INSERT INTO `download` VALUES ('41', '41');
INSERT INTO `download` VALUES ('42', '42');
INSERT INTO `download` VALUES ('43', '43');
INSERT INTO `download` VALUES ('44', '44');
INSERT INTO `download` VALUES ('45', '45');
INSERT INTO `download` VALUES ('46', '46');
INSERT INTO `download` VALUES ('47', '47');
INSERT INTO `download` VALUES ('48', '48');
INSERT INTO `download` VALUES ('49', '49');
INSERT INTO `download` VALUES ('50', '50');

-- ----------------------------
-- Table structure for download_song
-- ----------------------------
DROP TABLE IF EXISTS `download_song`;
CREATE TABLE `download_song` (
  `Downloadlistid` int(10) NOT NULL,
  `songid` int(10) NOT NULL,
  PRIMARY KEY (`Downloadlistid`,`songid`),
  KEY `FK_download_song1` (`songid`),
  CONSTRAINT `FK_download_song1` FOREIGN KEY (`songid`) REFERENCES `song` (`songid`),
  CONSTRAINT `FK_download_song2` FOREIGN KEY (`Downloadlistid`) REFERENCES `download` (`Downloadlistid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个歌曲对应零或多个下载表\r\n一个下载表对应一或多个歌曲';

-- ----------------------------
-- Records of download_song
-- ----------------------------
INSERT INTO `download_song` VALUES ('1', '1');
INSERT INTO `download_song` VALUES ('3', '1');
INSERT INTO `download_song` VALUES ('1', '2');
INSERT INTO `download_song` VALUES ('2', '2');
INSERT INTO `download_song` VALUES ('1', '4');
INSERT INTO `download_song` VALUES ('2', '4');
INSERT INTO `download_song` VALUES ('3', '4');
INSERT INTO `download_song` VALUES ('4', '4');
INSERT INTO `download_song` VALUES ('1', '5');
INSERT INTO `download_song` VALUES ('2', '5');
INSERT INTO `download_song` VALUES ('3', '5');
INSERT INTO `download_song` VALUES ('4', '5');

-- ----------------------------
-- Table structure for master
-- ----------------------------
DROP TABLE IF EXISTS `master`;
CREATE TABLE `master` (
  `managerid` int(10) NOT NULL AUTO_INCREMENT,
  `managername` varchar(40) DEFAULT NULL,
  `managerpassword` varchar(40) NOT NULL,
  PRIMARY KEY (`managerid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='管理员信息';

-- ----------------------------
-- Records of master
-- ----------------------------
INSERT INTO `master` VALUES ('1', 'admin1', 'admin');
INSERT INTO `master` VALUES ('2', 'admin2', 'admin');
INSERT INTO `master` VALUES ('3', 'admin3', 'admin');
INSERT INTO `master` VALUES ('4', 'admin4', 'admin');
INSERT INTO `master` VALUES ('5', 'admin5', 'admin');

-- ----------------------------
-- Table structure for mv
-- ----------------------------
DROP TABLE IF EXISTS `mv`;
CREATE TABLE `mv` (
  `mvid` int(10) NOT NULL AUTO_INCREMENT,
  `songid` int(10) NOT NULL,
  `releasetime` datetime DEFAULT NULL,
  `downloadtimes` int(1) DEFAULT NULL,
  `frontimg` varchar(200) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  `mvname` varchar(200) DEFAULT NULL,
  `mvpustate` int(1) NOT NULL,
  `mvtext` varchar(500) DEFAULT NULL,
  `mvstate` int(11) NOT NULL,
  PRIMARY KEY (`mvid`),
  KEY `FK_song_mv` (`songid`),
  CONSTRAINT `FK_song_mv` FOREIGN KEY (`songid`) REFERENCES `song` (`songid`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='歌曲mv信息';

-- ----------------------------
-- Records of mv
-- ----------------------------
INSERT INTO `mv` VALUES ('1', '4', '2017-09-20 00:00:00', null, 'images/m40.jpg', '/tiremusic/mv/IWantYoutoKnow.mp4', 'tiremusic', '1', '好的MV', '1');
INSERT INTO `mv` VALUES ('2', '4', '2004-02-25 19:51:45', null, 'images/m41.jpg', '/tiremusic/mv/IWantYoutoKnow.mp4', 'mv名称2', '1', 'vvv', '1');
INSERT INTO `mv` VALUES ('3', '2', '2016-08-03 19:52:09', null, 'images/m42.jpg', '/tiremusic/mv/IWantYoutoKnow.mp4', 'mv名称3', '1', 'cc', '1');
INSERT INTO `mv` VALUES ('4', '2', '2017-09-20 16:46:29', null, 'images/m43.jpg', '/tiremusic/mv/IWantYoutoKnow.mp4', 'I want', '1', 'vvx', '1');
INSERT INTO `mv` VALUES ('36', '1', '2017-09-21 00:00:00', null, 'images/m42.jpg', 'http://localhost:8080/MV/金志文 - 远走高飞.mp4', '远走高飞', '1', '远走高飞', '1');
INSERT INTO `mv` VALUES ('39', '1', '2017-09-13 00:00:00', null, 'images/m42.jpg', 'http://localhost:8080/MV/Luis Fonsi,Daddy Yankee - Despacito.mp4', 'luis', '1', 'luis', '1');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `schoolid` int(10) NOT NULL AUTO_INCREMENT,
  `schoolname` varchar(50) NOT NULL,
  `schooltext` varchar(200) DEFAULT NULL,
  `schoolstate` int(11) NOT NULL,
  PRIMARY KEY (`schoolid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='歌曲流派信息';

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '流行', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('2', '摇滚', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('3', '民谣', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('4', '电子', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('5', '舞曲', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('6', '说唱', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('7', '轻音乐', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('8', '爵士', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('9', '乡村', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('10', 'R&B/Soul', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('11', '古典', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('12', '民族', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('13', '英伦', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('14', '金属', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('15', '朋克', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('16', '蓝调', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('17', '雷鬼', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('18', '世界音乐', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('19', '拉丁', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('20', '另类/独特', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('21', 'New Age', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('22', '古风', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('23', '后摇', '流行曲风，引领当代音乐新潮流', '1');
INSERT INTO `school` VALUES ('24', 'Bossa Nova', '流行曲风，引领当代音乐新潮流', '1');

-- ----------------------------
-- Table structure for sensitiveword
-- ----------------------------
DROP TABLE IF EXISTS `sensitiveword`;
CREATE TABLE `sensitiveword` (
  `swid` int(10) NOT NULL AUTO_INCREMENT,
  `swtext` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`swid`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sensitiveword
-- ----------------------------
INSERT INTO `sensitiveword` VALUES ('1', '李愚蠢');
INSERT INTO `sensitiveword` VALUES ('2', '中国猪');
INSERT INTO `sensitiveword` VALUES ('3', '台湾猪');
INSERT INTO `sensitiveword` VALUES ('4', '进化不完全的生命体');
INSERT INTO `sensitiveword` VALUES ('5', '震死他们');
INSERT INTO `sensitiveword` VALUES ('6', '贱人');
INSERT INTO `sensitiveword` VALUES ('7', '装b');
INSERT INTO `sensitiveword` VALUES ('8', '大sb');
INSERT INTO `sensitiveword` VALUES ('9', '傻逼');
INSERT INTO `sensitiveword` VALUES ('10', '傻b');
INSERT INTO `sensitiveword` VALUES ('11', '煞逼');
INSERT INTO `sensitiveword` VALUES ('12', '煞笔');
INSERT INTO `sensitiveword` VALUES ('13', '刹笔');
INSERT INTO `sensitiveword` VALUES ('14', '傻比');
INSERT INTO `sensitiveword` VALUES ('15', '沙比');
INSERT INTO `sensitiveword` VALUES ('16', '欠干');
INSERT INTO `sensitiveword` VALUES ('17', '婊子养的');
INSERT INTO `sensitiveword` VALUES ('18', '我日你');
INSERT INTO `sensitiveword` VALUES ('19', '我操');
INSERT INTO `sensitiveword` VALUES ('20', '我草');
INSERT INTO `sensitiveword` VALUES ('21', '卧艹');
INSERT INTO `sensitiveword` VALUES ('22', '卧槽');
INSERT INTO `sensitiveword` VALUES ('23', '爆你菊');
INSERT INTO `sensitiveword` VALUES ('24', '艹你');
INSERT INTO `sensitiveword` VALUES ('25', 'cao你');
INSERT INTO `sensitiveword` VALUES ('26', '你他妈');
INSERT INTO `sensitiveword` VALUES ('27', '真他妈');
INSERT INTO `sensitiveword` VALUES ('28', '别他吗');
INSERT INTO `sensitiveword` VALUES ('29', '草你吗');
INSERT INTO `sensitiveword` VALUES ('30', '草你丫');
INSERT INTO `sensitiveword` VALUES ('31', '操你妈');
INSERT INTO `sensitiveword` VALUES ('32', '擦你妈');
INSERT INTO `sensitiveword` VALUES ('33', '操你娘');
INSERT INTO `sensitiveword` VALUES ('34', '操他妈');
INSERT INTO `sensitiveword` VALUES ('35', '日你妈');
INSERT INTO `sensitiveword` VALUES ('36', '干你妈');
INSERT INTO `sensitiveword` VALUES ('37', '干你娘');
INSERT INTO `sensitiveword` VALUES ('38', '娘西皮');
INSERT INTO `sensitiveword` VALUES ('39', '狗操');
INSERT INTO `sensitiveword` VALUES ('40', '狗草');
INSERT INTO `sensitiveword` VALUES ('41', '狗杂种');
INSERT INTO `sensitiveword` VALUES ('42', '狗日的');
INSERT INTO `sensitiveword` VALUES ('43', '操你祖宗');
INSERT INTO `sensitiveword` VALUES ('44', '操你全家');
INSERT INTO `sensitiveword` VALUES ('45', '操你大爷');
INSERT INTO `sensitiveword` VALUES ('46', '妈逼');
INSERT INTO `sensitiveword` VALUES ('47', '你麻痹');
INSERT INTO `sensitiveword` VALUES ('48', '麻痹的');
INSERT INTO `sensitiveword` VALUES ('49', '妈了个逼');
INSERT INTO `sensitiveword` VALUES ('50', '马勒');
INSERT INTO `sensitiveword` VALUES ('51', '狗娘养');
INSERT INTO `sensitiveword` VALUES ('52', '贱比');
INSERT INTO `sensitiveword` VALUES ('53', '贱b');
INSERT INTO `sensitiveword` VALUES ('54', '下贱');
INSERT INTO `sensitiveword` VALUES ('55', '死全家');
INSERT INTO `sensitiveword` VALUES ('56', '全家死光');
INSERT INTO `sensitiveword` VALUES ('57', '全家不得好死');
INSERT INTO `sensitiveword` VALUES ('58', '全家死绝');
INSERT INTO `sensitiveword` VALUES ('59', '白痴');
INSERT INTO `sensitiveword` VALUES ('60', '无耻');
INSERT INTO `sensitiveword` VALUES ('61', 'sb');
INSERT INTO `sensitiveword` VALUES ('62', '杀b');
INSERT INTO `sensitiveword` VALUES ('63', '你吗b');
INSERT INTO `sensitiveword` VALUES ('64', '你妈的');
INSERT INTO `sensitiveword` VALUES ('65', '婊子');
INSERT INTO `sensitiveword` VALUES ('66', '贱货');
INSERT INTO `sensitiveword` VALUES ('67', '人渣');
INSERT INTO `sensitiveword` VALUES ('68', '混蛋');
INSERT INTO `sensitiveword` VALUES ('69', '媚外');
INSERT INTO `sensitiveword` VALUES ('70', '和弦');
INSERT INTO `sensitiveword` VALUES ('71', '兼职');
INSERT INTO `sensitiveword` VALUES ('72', '限量');
INSERT INTO `sensitiveword` VALUES ('73', '铃声');
INSERT INTO `sensitiveword` VALUES ('74', '性伴侣');
INSERT INTO `sensitiveword` VALUES ('75', '男公关');
INSERT INTO `sensitiveword` VALUES ('76', '火辣');
INSERT INTO `sensitiveword` VALUES ('77', '精子');
INSERT INTO `sensitiveword` VALUES ('78', '射精');
INSERT INTO `sensitiveword` VALUES ('79', '诱奸');
INSERT INTO `sensitiveword` VALUES ('80', '强奸');
INSERT INTO `sensitiveword` VALUES ('81', '做爱');
INSERT INTO `sensitiveword` VALUES ('82', '性爱');
INSERT INTO `sensitiveword` VALUES ('83', '发生关系');
INSERT INTO `sensitiveword` VALUES ('84', '按摩');
INSERT INTO `sensitiveword` VALUES ('85', '快感');
INSERT INTO `sensitiveword` VALUES ('86', '处男');
INSERT INTO `sensitiveword` VALUES ('87', '猛男');
INSERT INTO `sensitiveword` VALUES ('88', '少妇');
INSERT INTO `sensitiveword` VALUES ('89', '屌');
INSERT INTO `sensitiveword` VALUES ('90', '屁股');
INSERT INTO `sensitiveword` VALUES ('91', '下体');
INSERT INTO `sensitiveword` VALUES ('92', 'a片');
INSERT INTO `sensitiveword` VALUES ('93', '内裤');
INSERT INTO `sensitiveword` VALUES ('94', '浑圆');
INSERT INTO `sensitiveword` VALUES ('95', '咪咪');
INSERT INTO `sensitiveword` VALUES ('96', '发情');
INSERT INTO `sensitiveword` VALUES ('97', '刺激');
INSERT INTO `sensitiveword` VALUES ('98', '白嫩');
INSERT INTO `sensitiveword` VALUES ('99', '粉嫩');
INSERT INTO `sensitiveword` VALUES ('100', '兽性');
INSERT INTO `sensitiveword` VALUES ('101', '风骚');
INSERT INTO `sensitiveword` VALUES ('102', '呻吟');
INSERT INTO `sensitiveword` VALUES ('103', 'sm');
INSERT INTO `sensitiveword` VALUES ('104', '阉割');
INSERT INTO `sensitiveword` VALUES ('105', '高潮');
INSERT INTO `sensitiveword` VALUES ('106', '裸露');
INSERT INTO `sensitiveword` VALUES ('107', '不穿');
INSERT INTO `sensitiveword` VALUES ('108', '一丝不挂');
INSERT INTO `sensitiveword` VALUES ('109', '脱光');
INSERT INTO `sensitiveword` VALUES ('110', '干你');
INSERT INTO `sensitiveword` VALUES ('111', '干死');
INSERT INTO `sensitiveword` VALUES ('112', '我干');
INSERT INTO `sensitiveword` VALUES ('113', '中日没有不友好的');
INSERT INTO `sensitiveword` VALUES ('114', '木牛流马的污染比汽车飞机大');
INSERT INTO `sensitiveword` VALUES ('115', '他们嫌我挡了城市的道路');
INSERT INTO `sensitiveword` VALUES ('116', '当官靠后台');
INSERT INTO `sensitiveword` VALUES ('117', '警察我们是为人民服务的');
INSERT INTO `sensitiveword` VALUES ('118', '中石化说亏损');
INSERT INTO `sensitiveword` VALUES ('119', '做人不能太cctv了');
INSERT INTO `sensitiveword` VALUES ('120', '领导干部吃王八');
INSERT INTO `sensitiveword` VALUES ('121', '工商税务两条狼');
INSERT INTO `sensitiveword` VALUES ('122', '公检法是流氓');
INSERT INTO `sensitiveword` VALUES ('123', '公安把秩序搞乱');
INSERT INTO `sensitiveword` VALUES ('124', '剖腹一刀五千几');
INSERT INTO `sensitiveword` VALUES ('125', '读不起选个学校三万起');
INSERT INTO `sensitiveword` VALUES ('126', '父母下岗儿下地');
INSERT INTO `sensitiveword` VALUES ('127', '裙中性运动');

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `songid` int(10) NOT NULL AUTO_INCREMENT,
  `schoolid` int(10) NOT NULL,
  `songerid` int(10) NOT NULL,
  `uploadlistid` int(10) NOT NULL,
  `songname` varchar(100) NOT NULL,
  `frontimg` varchar(200) DEFAULT NULL,
  `songstate` int(1) DEFAULT NULL,
  `location` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`songid`),
  KEY `FK_song_school` (`schoolid`),
  KEY `FK_song_singer` (`songerid`),
  KEY `FK_song_update` (`uploadlistid`),
  CONSTRAINT `FK_song_school` FOREIGN KEY (`schoolid`) REFERENCES `school` (`schoolid`),
  CONSTRAINT `FK_song_singer` FOREIGN KEY (`songerid`) REFERENCES `songer` (`songerid`),
  CONSTRAINT `FK_song_update` FOREIGN KEY (`uploadlistid`) REFERENCES `upload` (`uploadlistid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='歌曲信息';

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('1', '1', '1', '1', '七里香', '', '1', 'http://localhost:8080/musiclist/周杰伦-七里香.mp3');
INSERT INTO `song` VALUES ('2', '1', '1', '1', '青花瓷', '', '1', 'http://localhost:8080/musiclist/周杰伦 - 青花瓷.mp3');
INSERT INTO `song` VALUES ('4', '1', '1', '1', '说好的幸福呢', '', '1', 'http://localhost:8080/musiclist/周杰伦 - 说好的幸福呢.mp3');
INSERT INTO `song` VALUES ('5', '1', '1', '1', '蜗牛', '', '1', 'http://localhost:8080/musiclist/周杰伦 - 蜗牛.mp3');
INSERT INTO `song` VALUES ('6', '1', '3', '1', '你的背包', '', '1', 'http://localhost:8080/musiclist/你的背包 - 陈奕迅.mp3');
INSERT INTO `song` VALUES ('7', '1', '3', '1', '一丝不挂', '', '1', 'http://localhost:8080/musiclist/陈奕迅-一丝不挂.mp3');
INSERT INTO `song` VALUES ('8', '1', '3', '1', '重口味', '', '1', 'http://localhost:8080/musiclist/陈奕迅 - 重口味 (The Headmaster Mix - Eason Chan vs The Great Almighty Alan Tam).mp3');
INSERT INTO `song` VALUES ('9', '1', '3', '1', '十年', '', '1', 'http://localhost:8080/musiclist/陈奕迅 - 十年(国语版).mp3');
INSERT INTO `song` VALUES ('10', '1', '3', '1', '爱情转移', '', '1', 'http://localhost:8080/musiclist/陈奕迅 - 爱情转移(爱情呼叫转移主题曲).mp3');
INSERT INTO `song` VALUES ('11', '1', '3', '1', 'K 歌之王', '', '1', 'http://localhost:8080/musiclist/陈奕迅 - K 歌之王.mp3');
INSERT INTO `song` VALUES ('12', '1', '20', '1', '城府', '', '1', 'http://localhost:8080/musiclist/许嵩 - 城府.mp3');
INSERT INTO `song` VALUES ('13', '2', '20', '1', '多余的解释', '', '1', 'http://localhost:8080/musiclist/许嵩 - 多余的解释.mp3');
INSERT INTO `song` VALUES ('14', '1', '20', '1', '灰色头像', '', '1', 'http://localhost:8080/musiclist/许嵩 - 灰色头像.mp3');
INSERT INTO `song` VALUES ('15', '1', '20', '1', '七号公园', '', '1', 'http://localhost:8080/musiclist/许嵩 - 七号公园.mp3');
INSERT INTO `song` VALUES ('16', '1', '20', '1', '认错', '', '1', 'http://localhost:8080/musiclist/许嵩 - 认错.mp3');
INSERT INTO `song` VALUES ('17', '11', '20', '1', '断桥残雪', '', '1', 'http://localhost:8080/musiclist/许嵩-断桥残雪.mp3');
INSERT INTO `song` VALUES ('18', '1', '30', '1', '逆战', null, '1', 'http://localhost:8080/musiclist/张杰 - 逆战.mp3');
INSERT INTO `song` VALUES ('19', '1', '30', '1', '我们都一样', '', '1', 'http://localhost:8080/musiclist/张杰-我们都一样.mp3');
INSERT INTO `song` VALUES ('20', '1', '30', '1', '最美的太阳', '', '1', 'http://localhost:8080/musiclist/张杰-最美的太阳.mp3');
INSERT INTO `song` VALUES ('21', '1', '30', '1', '着魔', '', '1', 'http://localhost:8080/musiclist/着魔 - 张杰.mp3');
INSERT INTO `song` VALUES ('22', '1', '30', '1', '第一夫人', '', '1', 'http://localhost:8080/musiclist/张杰 - 第一夫人.mp3');
INSERT INTO `song` VALUES ('23', '1', '30', '1', '何必在一起', '', '1', 'http://localhost:8080/musiclist/何必在一起 - 张杰.mp3');
INSERT INTO `song` VALUES ('24', '1', '3', '1', '谢谢侬', null, '1', 'http://localhost:8080/musiclist/陈奕迅 - 谢谢侬.mp3');
INSERT INTO `song` VALUES ('31', '1', '7', '57', '你把我灌醉', null, '1', 'http://localhost:8080/musiclist/邓紫棋 - 你把我灌醉.mp3');
INSERT INTO `song` VALUES ('32', '22', '46', '58', '无归', null, '1', 'http://localhost:8080/musiclist/叶里 - 无归.mp3');
INSERT INTO `song` VALUES ('33', '22', '30', '59', '剑心', null, '1', 'http://localhost:8080/musiclist/张杰 - 剑心.mp3');

-- ----------------------------
-- Table structure for songer
-- ----------------------------
DROP TABLE IF EXISTS `songer`;
CREATE TABLE `songer` (
  `songerid` int(10) NOT NULL AUTO_INCREMENT,
  `songername` varchar(100) NOT NULL,
  `songertext` varchar(500) DEFAULT NULL,
  `songerstate` int(11) NOT NULL,
  PRIMARY KEY (`songerid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='歌手信息';

-- ----------------------------
-- Records of songer
-- ----------------------------
INSERT INTO `songer` VALUES ('1', '周杰伦', '歌手周杰伦', '1');
INSERT INTO `songer` VALUES ('2', '林俊杰', '歌手', '1');
INSERT INTO `songer` VALUES ('3', '陈奕迅', '歌手', '1');
INSERT INTO `songer` VALUES ('4', '薛之谦', '歌手', '0');
INSERT INTO `songer` VALUES ('5', '赵雷', '歌手', '1');
INSERT INTO `songer` VALUES ('6', '王菲', '歌手', '1');
INSERT INTO `songer` VALUES ('7', '邓紫棋', '歌手', '1');
INSERT INTO `songer` VALUES ('8', '李荣浩', '歌手', '1');
INSERT INTO `songer` VALUES ('9', '张学友', '歌手', '1');
INSERT INTO `songer` VALUES ('10', '许巍', '歌手', '1');
INSERT INTO `songer` VALUES ('11', '孙燕姿', '歌手', '1');
INSERT INTO `songer` VALUES ('12', '王力宏', '歌手', '1');
INSERT INTO `songer` VALUES ('13', 'Beyond', '歌手', '1');
INSERT INTO `songer` VALUES ('14', '宋冬野', '歌手', '1');
INSERT INTO `songer` VALUES ('15', '朴树', '歌手', '1');
INSERT INTO `songer` VALUES ('16', '李健', '歌手', '1');
INSERT INTO `songer` VALUES ('17', '陈小春', '歌手', '1');
INSERT INTO `songer` VALUES ('18', '那英', '歌手', '1');
INSERT INTO `songer` VALUES ('19', '莫文蔚', '歌手', '1');
INSERT INTO `songer` VALUES ('20', '许嵩', '歌手', '1');
INSERT INTO `songer` VALUES ('21', '苏打绿', '歌手', '1');
INSERT INTO `songer` VALUES ('22', '谢安琪', '歌手', '1');
INSERT INTO `songer` VALUES ('23', '杨千嬅', '歌手', '1');
INSERT INTO `songer` VALUES ('24', '张国荣', '歌手', '1');
INSERT INTO `songer` VALUES ('25', '萧敬腾', '歌手', '1');
INSERT INTO `songer` VALUES ('26', '张靓颖', '歌手', '1');
INSERT INTO `songer` VALUES ('27', '张惠妹', '歌手', '1');
INSERT INTO `songer` VALUES ('28', '古巨基', '歌手', '1');
INSERT INTO `songer` VALUES ('29', '五月天', '歌手', '1');
INSERT INTO `songer` VALUES ('30', '张杰', '歌手', '1');
INSERT INTO `songer` VALUES ('31', '容祖儿', '歌手', '1');
INSERT INTO `songer` VALUES ('32', '蔡依林', '歌手', '1');
INSERT INTO `songer` VALUES ('33', '周传雄', '歌手', '1');
INSERT INTO `songer` VALUES ('34', '梁静茹', '歌手', '1');
INSERT INTO `songer` VALUES ('35', '李克勤', '歌手', '1');
INSERT INTO `songer` VALUES ('36', '逃跑计划', '歌手', '1');
INSERT INTO `songer` VALUES ('37', '陶喆', '歌手', '1');
INSERT INTO `songer` VALUES ('38', '张信哲', '歌手', '1');
INSERT INTO `songer` VALUES ('39', '刘德华', '歌手', '1');
INSERT INTO `songer` VALUES ('40', '方大同', '歌手', '1');
INSERT INTO `songer` VALUES ('41', '谭维维', '歌手', '1');
INSERT INTO `songer` VALUES ('42', '汪峰', '歌手', '1');
INSERT INTO `songer` VALUES ('43', '范玮琪', '歌手', '1');
INSERT INTO `songer` VALUES ('44', '萧亚轩', '歌手', '1');
INSERT INTO `songer` VALUES ('45', '石进', '歌手', '1');
INSERT INTO `songer` VALUES ('46', '张宇', '歌手', '1');
INSERT INTO `songer` VALUES ('47', '谭咏麟', '歌手', '1');
INSERT INTO `songer` VALUES ('48', '尧十三', '歌手', '1');
INSERT INTO `songer` VALUES ('49', '林忆莲', '歌手', '1');
INSERT INTO `songer` VALUES ('50', '庄心妍', '歌手', '1');

-- ----------------------------
-- Table structure for songlist
-- ----------------------------
DROP TABLE IF EXISTS `songlist`;
CREATE TABLE `songlist` (
  `songlistid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL,
  `songlistname` varchar(100) NOT NULL,
  PRIMARY KEY (`songlistid`),
  KEY `FK_songlist_user` (`uid`),
  CONSTRAINT `FK_songlist_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户歌单信息';

-- ----------------------------
-- Records of songlist
-- ----------------------------
INSERT INTO `songlist` VALUES ('1', '1', '我喜欢');
INSERT INTO `songlist` VALUES ('2', '2', '我喜欢');
INSERT INTO `songlist` VALUES ('3', '3', '我喜欢');
INSERT INTO `songlist` VALUES ('4', '4', '我喜欢');
INSERT INTO `songlist` VALUES ('5', '1', '我的歌单');
INSERT INTO `songlist` VALUES ('6', '1000000151', '我喜欢');
INSERT INTO `songlist` VALUES ('7', '1000000152', '我喜欢');
INSERT INTO `songlist` VALUES ('8', '1000000153', '我喜欢');
INSERT INTO `songlist` VALUES ('10', '1000000154', '我喜欢');
INSERT INTO `songlist` VALUES ('11', '1000000152', '我的歌单');

-- ----------------------------
-- Table structure for song_album
-- ----------------------------
DROP TABLE IF EXISTS `song_album`;
CREATE TABLE `song_album` (
  `songid` int(10) NOT NULL,
  `Albumid` int(10) NOT NULL,
  PRIMARY KEY (`songid`,`Albumid`),
  KEY `FK_song_album1` (`Albumid`),
  CONSTRAINT `FK_song_album1` FOREIGN KEY (`Albumid`) REFERENCES `album` (`albumid`),
  CONSTRAINT `FK_song_album2` FOREIGN KEY (`songid`) REFERENCES `song` (`songid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个歌曲对应零个或多个专辑\r\n一个专辑对应零个或多个歌曲';

-- ----------------------------
-- Records of song_album
-- ----------------------------
INSERT INTO `song_album` VALUES ('1', '1');
INSERT INTO `song_album` VALUES ('2', '4');
INSERT INTO `song_album` VALUES ('7', '5');
INSERT INTO `song_album` VALUES ('8', '5');
INSERT INTO `song_album` VALUES ('9', '5');
INSERT INTO `song_album` VALUES ('10', '5');
INSERT INTO `song_album` VALUES ('11', '5');
INSERT INTO `song_album` VALUES ('12', '5');
INSERT INTO `song_album` VALUES ('13', '5');
INSERT INTO `song_album` VALUES ('14', '5');
INSERT INTO `song_album` VALUES ('4', '6');
INSERT INTO `song_album` VALUES ('6', '7');
INSERT INTO `song_album` VALUES ('15', '8');
INSERT INTO `song_album` VALUES ('16', '8');
INSERT INTO `song_album` VALUES ('17', '8');
INSERT INTO `song_album` VALUES ('5', '9');
INSERT INTO `song_album` VALUES ('18', '9');
INSERT INTO `song_album` VALUES ('19', '9');
INSERT INTO `song_album` VALUES ('20', '11');
INSERT INTO `song_album` VALUES ('21', '15');
INSERT INTO `song_album` VALUES ('22', '17');
INSERT INTO `song_album` VALUES ('23', '18');
INSERT INTO `song_album` VALUES ('24', '27');

-- ----------------------------
-- Table structure for song_listen
-- ----------------------------
DROP TABLE IF EXISTS `song_listen`;
CREATE TABLE `song_listen` (
  `listenid` int(10) NOT NULL AUTO_INCREMENT,
  `auditionid` int(10) NOT NULL,
  `songid` int(10) NOT NULL,
  PRIMARY KEY (`listenid`),
  KEY `FK_song_listen1` (`songid`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COMMENT='一个歌曲对应零或多个试听表\r\n一个试听表对应一或多个歌曲';

-- ----------------------------
-- Records of song_listen
-- ----------------------------
INSERT INTO `song_listen` VALUES ('1', '1', '1');
INSERT INTO `song_listen` VALUES ('2', '1', '2');
INSERT INTO `song_listen` VALUES ('3', '1', '4');
INSERT INTO `song_listen` VALUES ('4', '1', '5');
INSERT INTO `song_listen` VALUES ('5', '2', '1');
INSERT INTO `song_listen` VALUES ('6', '2', '2');
INSERT INTO `song_listen` VALUES ('7', '2', '5');
INSERT INTO `song_listen` VALUES ('8', '3', '1');
INSERT INTO `song_listen` VALUES ('9', '3', '5');
INSERT INTO `song_listen` VALUES ('10', '4', '5');
INSERT INTO `song_listen` VALUES ('11', '6', '8');
INSERT INTO `song_listen` VALUES ('12', '25', '6');
INSERT INTO `song_listen` VALUES ('13', '15', '17');
INSERT INTO `song_listen` VALUES ('14', '15', '9');
INSERT INTO `song_listen` VALUES ('15', '47', '6');
INSERT INTO `song_listen` VALUES ('16', '47', '8');
INSERT INTO `song_listen` VALUES ('17', '9', '4');
INSERT INTO `song_listen` VALUES ('18', '15', '4');
INSERT INTO `song_listen` VALUES ('19', '36', '5');
INSERT INTO `song_listen` VALUES ('20', '0', '17');
INSERT INTO `song_listen` VALUES ('21', '0', '4');
INSERT INTO `song_listen` VALUES ('22', '0', '1');
INSERT INTO `song_listen` VALUES ('23', '0', '14');
INSERT INTO `song_listen` VALUES ('24', '1', '1');
INSERT INTO `song_listen` VALUES ('25', '1', '5');
INSERT INTO `song_listen` VALUES ('26', '1', '5');
INSERT INTO `song_listen` VALUES ('27', '1', '5');
INSERT INTO `song_listen` VALUES ('28', '1', '5');
INSERT INTO `song_listen` VALUES ('29', '1', '17');
INSERT INTO `song_listen` VALUES ('30', '1', '17');
INSERT INTO `song_listen` VALUES ('31', '1', '17');
INSERT INTO `song_listen` VALUES ('32', '1', '17');
INSERT INTO `song_listen` VALUES ('33', '1', '17');
INSERT INTO `song_listen` VALUES ('34', '1', '17');
INSERT INTO `song_listen` VALUES ('35', '1', '17');
INSERT INTO `song_listen` VALUES ('36', '1', '17');
INSERT INTO `song_listen` VALUES ('37', '1', '17');
INSERT INTO `song_listen` VALUES ('38', '1', '17');
INSERT INTO `song_listen` VALUES ('39', '1', '17');
INSERT INTO `song_listen` VALUES ('40', '1', '17');
INSERT INTO `song_listen` VALUES ('41', '1', '17');
INSERT INTO `song_listen` VALUES ('42', '1', '17');
INSERT INTO `song_listen` VALUES ('43', '1', '17');
INSERT INTO `song_listen` VALUES ('44', '1', '17');
INSERT INTO `song_listen` VALUES ('45', '0', '17');
INSERT INTO `song_listen` VALUES ('46', '2', '2');
INSERT INTO `song_listen` VALUES ('47', '2', '16');
INSERT INTO `song_listen` VALUES ('48', '2', '4');
INSERT INTO `song_listen` VALUES ('49', '2', '2');
INSERT INTO `song_listen` VALUES ('50', '2', '17');
INSERT INTO `song_listen` VALUES ('51', '2', '16');
INSERT INTO `song_listen` VALUES ('52', '2', '7');
INSERT INTO `song_listen` VALUES ('53', '2', '8');
INSERT INTO `song_listen` VALUES ('54', '1', '17');
INSERT INTO `song_listen` VALUES ('55', '1', '17');
INSERT INTO `song_listen` VALUES ('56', '1', '4');
INSERT INTO `song_listen` VALUES ('57', '1', '17');
INSERT INTO `song_listen` VALUES ('58', '1', '17');
INSERT INTO `song_listen` VALUES ('59', '1', '17');
INSERT INTO `song_listen` VALUES ('60', '0', '17');
INSERT INTO `song_listen` VALUES ('61', '2', '14');
INSERT INTO `song_listen` VALUES ('62', '1000000153', '5');
INSERT INTO `song_listen` VALUES ('63', '1000000153', '2');
INSERT INTO `song_listen` VALUES ('64', '1000000153', '16');
INSERT INTO `song_listen` VALUES ('65', '1000000152', '17');
INSERT INTO `song_listen` VALUES ('66', '1000000152', '1');
INSERT INTO `song_listen` VALUES ('67', '1000000152', '6');
INSERT INTO `song_listen` VALUES ('68', '1000000152', '6');
INSERT INTO `song_listen` VALUES ('69', '1000000152', '7');
INSERT INTO `song_listen` VALUES ('70', '1000000152', '8');
INSERT INTO `song_listen` VALUES ('71', '1000000152', '6');
INSERT INTO `song_listen` VALUES ('72', '1000000152', '2');
INSERT INTO `song_listen` VALUES ('73', '1000000152', '4');
INSERT INTO `song_listen` VALUES ('74', '1000000152', '1');
INSERT INTO `song_listen` VALUES ('75', '1000000152', '5');
INSERT INTO `song_listen` VALUES ('76', '1000000152', '1');
INSERT INTO `song_listen` VALUES ('77', '1000000152', '17');
INSERT INTO `song_listen` VALUES ('78', '1000000152', '16');
INSERT INTO `song_listen` VALUES ('79', '1000000152', '14');
INSERT INTO `song_listen` VALUES ('80', '1000000152', '17');
INSERT INTO `song_listen` VALUES ('81', '1000000152', '16');
INSERT INTO `song_listen` VALUES ('82', '1000000152', '15');
INSERT INTO `song_listen` VALUES ('83', '1000000152', '4');
INSERT INTO `song_listen` VALUES ('84', '1000000152', '1');
INSERT INTO `song_listen` VALUES ('85', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('86', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('87', '1000000152', '23');
INSERT INTO `song_listen` VALUES ('88', '1000000152', '22');
INSERT INTO `song_listen` VALUES ('89', '1000000152', '19');
INSERT INTO `song_listen` VALUES ('90', '1000000152', '20');
INSERT INTO `song_listen` VALUES ('91', '1000000152', '21');
INSERT INTO `song_listen` VALUES ('92', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('93', '1000000152', '1');
INSERT INTO `song_listen` VALUES ('94', '1000000152', '2');
INSERT INTO `song_listen` VALUES ('95', '1000000152', '4');
INSERT INTO `song_listen` VALUES ('96', '1000000152', '6');
INSERT INTO `song_listen` VALUES ('97', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('98', '1000000152', '17');
INSERT INTO `song_listen` VALUES ('99', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('100', '1000000152', '21');
INSERT INTO `song_listen` VALUES ('101', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('102', '1000000152', '19');
INSERT INTO `song_listen` VALUES ('103', '1', '24');
INSERT INTO `song_listen` VALUES ('104', '1', '23');
INSERT INTO `song_listen` VALUES ('105', '1', '22');
INSERT INTO `song_listen` VALUES ('106', '0', '21');
INSERT INTO `song_listen` VALUES ('107', '1', '1');
INSERT INTO `song_listen` VALUES ('108', '1', '2');
INSERT INTO `song_listen` VALUES ('109', '1', '4');
INSERT INTO `song_listen` VALUES ('110', '1', '5');
INSERT INTO `song_listen` VALUES ('111', '1', '6');
INSERT INTO `song_listen` VALUES ('112', '1', '7');
INSERT INTO `song_listen` VALUES ('113', '1', '8');
INSERT INTO `song_listen` VALUES ('114', '1', '9');
INSERT INTO `song_listen` VALUES ('115', '1', '10');
INSERT INTO `song_listen` VALUES ('116', '1', '11');
INSERT INTO `song_listen` VALUES ('117', '1', '12');
INSERT INTO `song_listen` VALUES ('118', '1', '13');
INSERT INTO `song_listen` VALUES ('119', '1', '14');
INSERT INTO `song_listen` VALUES ('120', '1', '15');
INSERT INTO `song_listen` VALUES ('121', '1', '16');
INSERT INTO `song_listen` VALUES ('122', '1', '17');
INSERT INTO `song_listen` VALUES ('123', '1', '18');
INSERT INTO `song_listen` VALUES ('124', '1', '19');
INSERT INTO `song_listen` VALUES ('125', '1', '20');
INSERT INTO `song_listen` VALUES ('126', '1', '21');
INSERT INTO `song_listen` VALUES ('127', '1', '22');
INSERT INTO `song_listen` VALUES ('128', '1', '23');
INSERT INTO `song_listen` VALUES ('129', '1', '24');
INSERT INTO `song_listen` VALUES ('130', '1', '24');
INSERT INTO `song_listen` VALUES ('131', '1', '23');
INSERT INTO `song_listen` VALUES ('132', '1', '21');
INSERT INTO `song_listen` VALUES ('133', '1', '17');
INSERT INTO `song_listen` VALUES ('134', '1', '16');
INSERT INTO `song_listen` VALUES ('135', '1', '13');
INSERT INTO `song_listen` VALUES ('136', '1', '12');
INSERT INTO `song_listen` VALUES ('137', '1', '21');
INSERT INTO `song_listen` VALUES ('138', '1', '17');
INSERT INTO `song_listen` VALUES ('139', '1', '13');
INSERT INTO `song_listen` VALUES ('140', '1', '12');
INSERT INTO `song_listen` VALUES ('141', '1', '22');
INSERT INTO `song_listen` VALUES ('142', '1', '24');
INSERT INTO `song_listen` VALUES ('143', '1', '23');
INSERT INTO `song_listen` VALUES ('144', '1', '21');
INSERT INTO `song_listen` VALUES ('145', '1', '19');
INSERT INTO `song_listen` VALUES ('146', '1', '1');
INSERT INTO `song_listen` VALUES ('147', '1', '2');
INSERT INTO `song_listen` VALUES ('148', '1', '4');
INSERT INTO `song_listen` VALUES ('149', '1', '5');
INSERT INTO `song_listen` VALUES ('150', '1', '6');
INSERT INTO `song_listen` VALUES ('151', '1', '7');
INSERT INTO `song_listen` VALUES ('152', '1', '10');
INSERT INTO `song_listen` VALUES ('153', '1', '26');
INSERT INTO `song_listen` VALUES ('154', '1', '26');
INSERT INTO `song_listen` VALUES ('155', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('156', '1000000152', '23');
INSERT INTO `song_listen` VALUES ('157', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('158', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('159', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('160', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('161', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('162', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('163', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('164', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('165', '1000000152', '22');
INSERT INTO `song_listen` VALUES ('166', '1000000152', '22');
INSERT INTO `song_listen` VALUES ('167', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('168', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('169', '1000000152', '26');
INSERT INTO `song_listen` VALUES ('170', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('171', '1000000152', '23');
INSERT INTO `song_listen` VALUES ('172', '1000000152', '22');
INSERT INTO `song_listen` VALUES ('173', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('174', '1000000152', '22');
INSERT INTO `song_listen` VALUES ('175', '1000000152', '23');
INSERT INTO `song_listen` VALUES ('176', '1000000152', '19');
INSERT INTO `song_listen` VALUES ('177', '1000000152', '21');
INSERT INTO `song_listen` VALUES ('178', '1000000152', '4');
INSERT INTO `song_listen` VALUES ('179', '1000000152', '2');
INSERT INTO `song_listen` VALUES ('180', '1000000152', '1');
INSERT INTO `song_listen` VALUES ('181', '1000000152', '10');
INSERT INTO `song_listen` VALUES ('182', '1000000152', '31');
INSERT INTO `song_listen` VALUES ('183', '1000000152', '31');
INSERT INTO `song_listen` VALUES ('184', '1000000152', '31');
INSERT INTO `song_listen` VALUES ('185', '1000000152', '24');
INSERT INTO `song_listen` VALUES ('186', '1000000152', '23');
INSERT INTO `song_listen` VALUES ('187', '1000000152', '20');
INSERT INTO `song_listen` VALUES ('188', '1000000152', '21');
INSERT INTO `song_listen` VALUES ('189', '1000000152', '22');
INSERT INTO `song_listen` VALUES ('190', '0', '1');
INSERT INTO `song_listen` VALUES ('191', '0', '2');
INSERT INTO `song_listen` VALUES ('192', '0', '4');
INSERT INTO `song_listen` VALUES ('193', '0', '5');
INSERT INTO `song_listen` VALUES ('194', '0', '6');
INSERT INTO `song_listen` VALUES ('195', '0', '6');
INSERT INTO `song_listen` VALUES ('196', '0', '7');
INSERT INTO `song_listen` VALUES ('197', '0', '8');
INSERT INTO `song_listen` VALUES ('198', '0', '9');
INSERT INTO `song_listen` VALUES ('199', '0', '10');
INSERT INTO `song_listen` VALUES ('200', '0', '11');
INSERT INTO `song_listen` VALUES ('201', '0', '12');
INSERT INTO `song_listen` VALUES ('202', '0', '13');
INSERT INTO `song_listen` VALUES ('203', '0', '14');
INSERT INTO `song_listen` VALUES ('204', '0', '15');
INSERT INTO `song_listen` VALUES ('205', '0', '16');
INSERT INTO `song_listen` VALUES ('206', '0', '17');
INSERT INTO `song_listen` VALUES ('207', '0', '18');
INSERT INTO `song_listen` VALUES ('208', '0', '19');
INSERT INTO `song_listen` VALUES ('209', '0', '20');
INSERT INTO `song_listen` VALUES ('210', '0', '21');
INSERT INTO `song_listen` VALUES ('211', '0', '22');
INSERT INTO `song_listen` VALUES ('212', '0', '23');
INSERT INTO `song_listen` VALUES ('213', '0', '24');
INSERT INTO `song_listen` VALUES ('214', '0', '31');
INSERT INTO `song_listen` VALUES ('215', '1000000152', '32');
INSERT INTO `song_listen` VALUES ('216', '1000000152', '33');

-- ----------------------------
-- Table structure for song_songlist
-- ----------------------------
DROP TABLE IF EXISTS `song_songlist`;
CREATE TABLE `song_songlist` (
  `songlistid` int(10) NOT NULL,
  `songid` int(10) NOT NULL,
  PRIMARY KEY (`songlistid`,`songid`),
  KEY `FK_song_songlist2` (`songid`),
  CONSTRAINT `FK_song_songlist1` FOREIGN KEY (`songlistid`) REFERENCES `songlist` (`songlistid`),
  CONSTRAINT `FK_song_songlist2` FOREIGN KEY (`songid`) REFERENCES `song` (`songid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个歌曲对应零或多个歌单\r\n一个歌单对应零或多个歌曲';

-- ----------------------------
-- Records of song_songlist
-- ----------------------------
INSERT INTO `song_songlist` VALUES ('1', '1');
INSERT INTO `song_songlist` VALUES ('3', '1');
INSERT INTO `song_songlist` VALUES ('5', '1');
INSERT INTO `song_songlist` VALUES ('7', '1');
INSERT INTO `song_songlist` VALUES ('1', '2');
INSERT INTO `song_songlist` VALUES ('2', '2');
INSERT INTO `song_songlist` VALUES ('7', '2');
INSERT INTO `song_songlist` VALUES ('1', '4');
INSERT INTO `song_songlist` VALUES ('2', '4');
INSERT INTO `song_songlist` VALUES ('3', '4');
INSERT INTO `song_songlist` VALUES ('7', '4');
INSERT INTO `song_songlist` VALUES ('1', '5');
INSERT INTO `song_songlist` VALUES ('2', '5');
INSERT INTO `song_songlist` VALUES ('3', '5');
INSERT INTO `song_songlist` VALUES ('7', '6');
INSERT INTO `song_songlist` VALUES ('7', '7');
INSERT INTO `song_songlist` VALUES ('8', '16');
INSERT INTO `song_songlist` VALUES ('1', '17');
INSERT INTO `song_songlist` VALUES ('5', '17');
INSERT INTO `song_songlist` VALUES ('7', '17');
INSERT INTO `song_songlist` VALUES ('5', '23');
INSERT INTO `song_songlist` VALUES ('1', '24');
INSERT INTO `song_songlist` VALUES ('5', '24');
INSERT INTO `song_songlist` VALUES ('7', '24');

-- ----------------------------
-- Table structure for upload
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `uploadlistid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) DEFAULT NULL,
  `managerid` int(10) DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `uploadtime` datetime DEFAULT NULL,
  PRIMARY KEY (`uploadlistid`),
  KEY `FK_master_upload` (`managerid`),
  KEY `FK_upload_user1` (`uid`),
  CONSTRAINT `FK_master_upload` FOREIGN KEY (`managerid`) REFERENCES `master` (`managerid`),
  CONSTRAINT `FK_upload_user1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='歌曲上传信息';

-- ----------------------------
-- Records of upload
-- ----------------------------
INSERT INTO `upload` VALUES ('1', '1', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('2', '2', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('3', '3', null, '0', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('4', '4', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('5', '5', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('6', '6', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('7', '7', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('8', '8', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('9', '9', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('10', '10', null, '0', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('11', '11', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('12', '12', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('13', '13', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('14', '14', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('15', '15', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('16', '16', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('17', '17', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('18', '18', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('19', '19', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('20', '20', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('21', '21', null, '0', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('22', '22', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('23', '23', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('24', '24', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('25', '25', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('26', '26', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('27', '27', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('28', '28', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('29', '29', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('30', '30', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('31', '31', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('32', '32', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('33', '33', null, '0', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('34', '34', null, '0', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('35', '35', null, '0', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('36', '36', null, '0', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('37', '37', null, '0', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('38', '38', null, '0', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('39', '39', null, '0', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('40', '40', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('41', '41', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('42', '42', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('43', '43', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('44', '44', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('45', '45', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('46', '46', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('47', '47', null, '1', '2014-08-06 19:45:38');
INSERT INTO `upload` VALUES ('48', '48', null, '1', '2015-08-05 19:46:10');
INSERT INTO `upload` VALUES ('49', '49', null, '1', '2007-02-15 19:45:10');
INSERT INTO `upload` VALUES ('50', '50', null, '1', '2012-09-12 19:45:23');
INSERT INTO `upload` VALUES ('51', '1', null, '1', '2017-09-29 00:00:00');
INSERT INTO `upload` VALUES ('52', '1', null, '1', '2017-09-29 00:00:00');
INSERT INTO `upload` VALUES ('53', '1', null, '0', '2017-09-29 00:00:00');
INSERT INTO `upload` VALUES ('54', '1', null, '0', '2017-09-29 00:00:00');
INSERT INTO `upload` VALUES ('55', '1', null, '0', '2017-09-29 00:00:00');
INSERT INTO `upload` VALUES ('56', '1', null, '0', '2017-09-29 00:00:00');
INSERT INTO `upload` VALUES ('57', '1000000152', null, '1', '2017-09-29 00:00:00');
INSERT INTO `upload` VALUES ('58', '1000000152', null, '1', '2017-09-30 00:00:00');
INSERT INTO `upload` VALUES ('59', '1000000152', null, '1', '2017-09-30 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `downloadlistid` int(10) DEFAULT NULL,
  `uploadlistid` int(10) DEFAULT NULL,
  `confirmid` int(10) DEFAULT NULL,
  `auditionid` int(10) DEFAULT NULL,
  `uname` varchar(50) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `upassword` varchar(40) NOT NULL,
  `uaddress` varchar(50) DEFAULT NULL,
  `uemail` varchar(40) NOT NULL,
  `utelephone` varchar(20) NOT NULL,
  `uidnumber` varchar(20) NOT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  `ustate` int(1) NOT NULL,
  `logindate` datetime DEFAULT NULL,
  `usersex` int(1) DEFAULT NULL,
  `userbirthday` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `FK_upload_user2` (`uploadlistid`),
  KEY `FK_user_conformto1` (`confirmid`),
  KEY `FK_user_download2` (`downloadlistid`),
  KEY `FK_user_listener1` (`auditionid`),
  CONSTRAINT `FK_upload_user2` FOREIGN KEY (`uploadlistid`) REFERENCES `upload` (`uploadlistid`),
  CONSTRAINT `FK_user_conformto1` FOREIGN KEY (`confirmid`) REFERENCES `conform` (`confirmid`),
  CONSTRAINT `FK_user_download2` FOREIGN KEY (`downloadlistid`) REFERENCES `download` (`Downloadlistid`),
  CONSTRAINT `FK_user_listener1` FOREIGN KEY (`auditionid`) REFERENCES `audition` (`auditionid`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000155 DEFAULT CHARSET=utf8 COMMENT='用户信息';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', 'userss', '张三', 'user1', '中国', '123@123.com', '15321564897', '63322252115556600000', 'http://localhost:8080/img/1.png', '1', '2017-09-22 19:30:00', '0', '2017-02-25 00:00:00');
INSERT INTO `user` VALUES ('2', '2', '2', '2', '2', 'user2', '李四', 'user2', '中国大陆', '1235456@qwd.co', '16322554456', '64546468464351300000', 'http://localhost:8080/img/1.png', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:12');
INSERT INTO `user` VALUES ('3', '3', '3', '3', '3', 'user3', '王五', 'user3', '香港', '956@qwdq.com', '15343843438', '5646864534643350000', 'http://localhost:8080/img/1.png', '1', '2015-05-13 19:32:01', '1', '1990-02-01 19:32:11');
INSERT INTO `user` VALUES ('4', '4', '4', '4', '4', 'user4', '马六', 'user4', '泰国', '98464@56.com', '15646834684', '45433435434334300000', 'http://localhost:8080/img/1.png', '1', '2012-03-15 19:33:19', '0', '1904-06-16 19:33:33');
INSERT INTO `user` VALUES ('5', '5', '5', '5', '5', 'user5', '用户六', 'user5', '泰国', '123@124.com', '15657973955', '63322252115556600000', 'http://localhost:8080/img/1.png', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('6', '6', '6', '6', '6', 'user6', '用户七', 'user6', '泰国', '1235457@qwd.co', '15657683789', '64546468464351300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('7', '7', '7', '7', '7', 'user7', '用户八', 'user7', '香港', '957@qwdq.com', '15657393623', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('8', '8', '8', '8', '8', 'user8', '用户九', 'user8', '香港', '98464@57.com', '15657103457', '64546468464351300000', '', '0', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('9', '9', '9', '9', '9', 'user9', '用户十', 'user9', '香港', '123@125.com', '15656813292', '5646864534643350000', '', '0', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('10', '10', '10', '10', '10', 'user10', '用户十一', 'user10', '香港', '1235458@qwd.co', '15656523126', '45433435434334300000', '', '0', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('11', '11', '11', '11', '11', 'user11', '用户十二', 'user11', '香港', '958@qwdq.com', '15656232960', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('12', '12', '12', '12', '12', 'user12', '用户十三', 'user12', '香港', '98464@58.com', '15655942795', '64546468464351300000', '', '0', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('13', '13', '13', '13', '13', 'user13', '用户十四', 'user13', '香港', '123@126.com', '15655652629', '63322252115556600000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('14', '14', '14', '14', '14', 'user14', '用户十五', 'user14', '中国大陆', '1235459@qwd.co', '15655362463', '64546468464351300000', '', '0', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('15', '15', '15', '15', '15', 'user15', '用户十六', 'user15', '中国大陆', '959@qwdq.com', '15655072298', '5646864534643350000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('16', '16', '16', '16', '16', 'user16', '用户十七', 'user16', '中国大陆', '98464@59.com', '15654782132', '45433435434334300000', '', '0', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('17', '17', '17', '17', '17', 'user17', '用户十八', 'user17', '中国大陆', '123@127.com', '15654491966', '63322252115556600000', '', '0', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('18', '18', '18', '18', '18', 'user18', '用户十九', 'user18', '中国大陆', '1235460@qwd.co', '15654201800', '64546468464351300000', '', '0', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('19', '19', '19', '19', '19', 'user19', '用户二十', 'user19', '中国大陆', '960@qwdq.com', '15653911635', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('20', '20', '20', '20', '20', 'user20', '用户二十一', 'user20', '中国大陆', '98464@60.com', '15653621469', '64546468464351300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('21', '21', '21', '21', '21', 'user21', '用户二十二', 'user21', '中国', '123@128.com', '15653331303', '5646864534643350000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('22', '22', '22', '22', '22', 'user22', '用户二十三', 'user22', '中国', '1235461@qwd.co', '15653041138', '45433435434334300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('23', '23', '23', '23', '23', 'user23', '用户二十四', 'user23', '中国', '961@qwdq.com', '15652750972', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('24', '24', '24', '24', '24', 'user24', '用户二十五', 'user24', '中国', '98464@61.com', '15652460806', '64546468464351300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('25', '25', '25', '25', '25', 'user25', '用户二十六', 'user25', '中国', '123@129.com', '15652170641', '63322252115556600000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('26', '26', '26', '26', '26', 'user26', '用户二十七', 'user26', '中国', '1235462@qwd.co', '15651880475', '64546468464351300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('27', '27', '27', '27', '27', 'user27', '用户二十八', 'user27', '中国', '962@qwdq.com', '15651590309', '5646864534643350000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('28', '28', '28', '28', '28', 'user28', '用户二十九', 'user28', '美国', '98464@62.com', '15651300143', '45433435434334300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('29', '29', '29', '29', '29', 'user29', '用户三十', 'user29', '美国', '123@130.com', '15651009978', '63322252115556600000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('30', '30', '30', '30', '30', 'user30', '用户三十一', 'user30', '美国', '1235463@qwd.co', '15650719812', '64546468464351300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('31', '31', '31', '31', '31', 'user31', '用户三十二', 'user31', '美国', '963@qwdq.com', '15650429646', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('32', '32', '32', '32', '32', 'user32', '用户三十三', 'user32', '美国', '98464@63.com', '15650139481', '64546468464351300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('33', '33', '33', '33', '33', 'user33', '用户三十四', 'user33', '美国', '123@131.com', '15649849315', '5646864534643350000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('34', '34', '34', '34', '34', 'user34', '用户三十五', 'user34', '德国', '1235464@qwd.co', '15649559149', '45433435434334300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('35', '35', '35', '35', '35', 'user35', '用户三十六', 'user35', '德国', '964@qwdq.com', '15649268984', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('36', '36', '36', '36', '36', 'user36', '用户三十七', 'user36', '德国', '98464@64.com', '15648978818', '64546468464351300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('37', '37', '37', '37', '37', 'user37', '用户三十八', 'user37', '德国', '123@132.com', '15648688652', '63322252115556600000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('38', '38', '38', '38', '38', 'user38', '用户三十九', 'user38', '德国', '1235465@qwd.co', '15648398486', '64546468464351300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('39', '39', '39', '39', '39', 'user39', '用户四十', 'user39', '德国', '965@qwdq.com', '15648108321', '5646864534643350000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('40', '40', '40', '40', '40', 'user40', '用户四十一', 'user40', '德国', '98464@65.com', '15647818155', '45433435434334300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('41', '41', '41', '41', '41', 'user41', '用户四十二', 'user41', '意大利', '123@133.com', '15647527989', '63322252115556600000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('42', '42', '42', '42', '42', 'user42', '用户四十三', 'user42', '意大利', '1235466@qwd.co', '15647237824', '64546468464351300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('43', '43', '43', '43', '43', 'user43', '用户四十四', 'user43', '意大利', '966@qwdq.com', '15646947658', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('44', '44', '44', '44', '44', 'user44', '用户四十五', 'user44', '意大利', '98464@66.com', '15646657492', '64546468464351300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('45', '45', '45', '45', '45', 'user45', '用户四十六', 'user45', '意大利', '123@134.com', '15646367327', '5646864534643350000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('46', '46', '46', '46', '46', 'user46', '用户四十七', 'user46', '意大利', '1235467@qwd.co', '15646077161', '45433435434334300000', '', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('47', '47', '47', '47', '47', 'user47', '用户四十八', 'user47', '意大利', '967@qwdq.com', '15645786995', '63322252115556600000', '', '1', '2015-05-13 19:32:00', '1', '1990-02-01 19:32:00');
INSERT INTO `user` VALUES ('48', '48', '48', '48', '48', 'user48', '用户四十九', 'user48', '意大利', '98464@67.com', '15645496829', '64546468464351300000', '', '1', '2012-03-15 19:33:00', '0', '1904-06-16 19:33:00');
INSERT INTO `user` VALUES ('49', '49', '49', '49', '49', 'user49', '用户五十', 'user49', '意大利', '123@135.com', '15645206664', '63322252115556600000', '', '1', '2017-09-22 19:30:00', '1', '2017-02-25 19:30:00');
INSERT INTO `user` VALUES ('50', '50', '50', '50', '50', 'user50', '用户五十一', 'user50', '意大利', '1235468@qwd.co', '15644916498', '64546468464351300000', 'http://localhost:8080/img/1.png', '1', '2015-07-24 19:31:00', '0', '2004-06-25 19:31:00');
INSERT INTO `user` VALUES ('1000000151', null, null, null, null, 'lishugen', '李树根', 'a123456', '重庆市', '937383636@qq.com', '18874215948', '500221199011033654', 'http://localhost:8080/img/111.jpg', '1', '2017-09-29 00:00:00', '0', '2017-09-29 00:00:00');
INSERT INTO `user` VALUES ('1000000152', null, null, null, null, 'liaozhihong', '廖志鸿', 'lzh1994', '重庆市长寿区', '937383636@qq.com', '18875018228', '500221199412093816', 'http://localhost:8080/img/DSC01975.JPG', '1', '2017-09-29 00:00:00', '0', '2017-09-01 00:00:00');
INSERT INTO `user` VALUES ('1000000153', null, null, null, null, 'pengbichong', '彭必冲', 'p123456', '重庆市渝中区', '1528641447@qq.com', '18523212390', '500234199412084970', 'http://localhost:8080/img/3.png', '1', '2017-09-29 00:00:00', '0', '1994-12-08 00:00:00');
INSERT INTO `user` VALUES ('1000000154', null, null, null, null, 'guowenhao', '郭文浩', 'aaaaaa', '重庆市', '937383636@qq.com', '18874596854', '500221995478548547', 'http://localhost:8080/img/1.png', '1', '2017-09-29 00:00:00', '0', '2017-09-01 00:00:00');

-- ----------------------------
-- Table structure for user_conformfrom
-- ----------------------------
DROP TABLE IF EXISTS `user_conformfrom`;
CREATE TABLE `user_conformfrom` (
  `confirmid` int(10) NOT NULL,
  `uid` int(10) NOT NULL,
  PRIMARY KEY (`confirmid`,`uid`),
  KEY `FK_user_conformfrom1` (`uid`),
  CONSTRAINT `FK_user_conformfrom1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `FK_user_conformfrom2` FOREIGN KEY (`confirmid`) REFERENCES `conform` (`confirmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个用户被多张关注表关注\r\n一个关注表对应多个被注用户';

-- ----------------------------
-- Records of user_conformfrom
-- ----------------------------
