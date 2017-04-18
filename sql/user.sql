/*
Navicat MySQL Data Transfer

Source Server         : student
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-04-18 16:02:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('d0ff47d3-8892-4729-968e-e14f33be8336', 'admin', 'ISMvKXpXpadDiUoOSoAfww==');
INSERT INTO `user` VALUES ('8611b973-aca3-4311-9bc2-85d6aed1ddf3', 'lisi', 'kAFQmDzST7DWlj99KOF/cg==');
