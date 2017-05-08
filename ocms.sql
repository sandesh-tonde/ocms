/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : ocms

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-05-08 12:53:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `branch`
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `available_seats` int(11) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `seats` int(11) DEFAULT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES ('1', '119', 'Computer', '120');
INSERT INTO `branch` VALUES ('2', '120', 'Information Technology', '120');
INSERT INTO `branch` VALUES ('3', '120', 'Electronics and telecommunication', '120');
INSERT INTO `branch` VALUES ('4', '120', 'Mechanical', '120');
INSERT INTO `branch` VALUES ('5', '120', 'Civil', '120');
INSERT INTO `branch` VALUES ('6', '120', 'Electrical', '120');

-- ----------------------------
-- Table structure for `documents`
-- ----------------------------
DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents` (
  `documents_id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`documents_id`),
  KEY `FK383D52B863129B76` (`user_id`),
  CONSTRAINT `FK383D52B863129B76` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of documents
-- ----------------------------
INSERT INTO `documents` VALUES ('1', '/resources/uploads/1.pdf', 'marklist', '1', 'Approve');
INSERT INTO `documents` VALUES ('5', '/resources/uploads/3da8ea21-4b7f-451b-b5ab-7882054c41f3.pdf', 'test', '1', 'Varification Pending');
INSERT INTO `documents` VALUES ('12', '/resources/uploads/5ef8eaf9-cfb3-46d2-8919-cc6fb5a6be41.pdf', 'rest', '1', 'Varification Pending');

-- ----------------------------
-- Table structure for `preference`
-- ----------------------------
DROP TABLE IF EXISTS `preference`;
CREATE TABLE `preference` (
  `preference_id` int(11) NOT NULL AUTO_INCREMENT,
  `result` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `option1` int(11) DEFAULT NULL,
  `option2` int(11) DEFAULT NULL,
  `option3` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`preference_id`),
  KEY `FKA8FCBCDBA064F82` (`option3`),
  KEY `FKA8FCBCDBA064F80` (`option1`),
  KEY `FKA8FCBCDBA064F81` (`option2`),
  KEY `FKA8FCBCDB11B975DC` (`user_id`),
  CONSTRAINT `FKA8FCBCDB11B975DC` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKA8FCBCDBA064F80` FOREIGN KEY (`option1`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `FKA8FCBCDBA064F81` FOREIGN KEY (`option2`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `FKA8FCBCDBA064F82` FOREIGN KEY (`option3`) REFERENCES `branch` (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of preference
-- ----------------------------
INSERT INTO `preference` VALUES ('1', 'Computer', null, '1', '2', '3', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `councelling_date` datetime DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `eamil` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL,
  `seat_no` varchar(255) DEFAULT NULL,
  `session_time` int(11) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'pune', '25', 'pune', '2017-05-05 15:18:33', 'India', 'mehul@gmail.com', '2017-05-07 15:18:55', '0987654321', 'mehul', 'mehul', '5', '21', '20', '2017-05-02 14:19:10', 'mehul', 'student');
INSERT INTO `user` VALUES ('2', null, null, null, null, null, null, null, null, null, 'admin', null, null, null, null, 'admin', 'admin');
INSERT INTO `user` VALUES ('3', 'ww', '21', '21', '2017-05-08 12:24:47', '22', '22', '2017-05-09 12:24:52', '22', 'xxx', 'xxx', '2', '2', '22', '2017-05-08 12:25:35', 'xxx', 'student');
