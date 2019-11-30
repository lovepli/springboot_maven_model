/*
 Navicat MySQL Data Transfer

 Source Server         : mysql_localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost
 Source Database       : socks

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : utf-8

 Date: 11/10/2019 00:22:18 AM
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin'), ('2', 'jack', 'jack123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
