/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : hotel_ordering_system

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-23 14:41:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(100) NOT NULL COMMENT '酒店名 如XX酒店成都分店',
  `subbranch` varchar(50) NOT NULL COMMENT '分店号   如二分店',
  `star_level` varchar(20) DEFAULT NULL COMMENT '星级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `status` varchar(50) DEFAULT NULL COMMENT '状态 如已入住 未入住',
  `check_out_time` datetime DEFAULT NULL COMMENT '退房时间',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `time` date DEFAULT NULL COMMENT '所订购的时间 如订 2019:07:25日的酒店',
  `room_id` int(11) DEFAULT NULL,
  `check_in_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_room` (`room_id`),
  KEY `order_user` (`user_id`),
  CONSTRAINT `order_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `potence` varchar(50) DEFAULT NULL COMMENT '权限标记 如查看房间是 readRoom',
  `role_id` int(11) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`id`),
  KEY `role_permission` (`role_id`),
  CONSTRAINT `role_permission` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(80) NOT NULL COMMENT '角色名',
  `role_msg` varchar(255) DEFAULT NULL COMMENT '角色说明',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_user` (`user_id`),
  CONSTRAINT `role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_no` varchar(80) DEFAULT NULL COMMENT '门牌号',
  `status` varchar(50) DEFAULT NULL COMMENT '状态',
  `room_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_roomType` (`room_type_id`),
  KEY `room_no` (`room_no`),
  CONSTRAINT `room_roomType` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_type` varchar(255) NOT NULL COMMENT '房间类型',
  `price` varchar(50) DEFAULT NULL COMMENT '价格',
  `num` int(11) DEFAULT NULL COMMENT '该房型的数量，使用触发器维护该数值',
  `hotel_id` int(11) NOT NULL COMMENT '所属酒店（分店）',
  `desc` varchar(255) DEFAULT NULL COMMENT '房型描述',
  `desc_url` varchar(255) DEFAULT NULL COMMENT '描述图片的相对地址',
  `isrecommend` varchar(10) DEFAULT NULL COMMENT '是否推荐',
  `capacity` int(11) DEFAULT NULL COMMENT '该房型可住的人数 如单人间是1',
  PRIMARY KEY (`id`),
  KEY `roomType_hotel` (`hotel_id`),
  CONSTRAINT `roomType_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `service_msg` varchar(255) DEFAULT NULL COMMENT '服务说明',
  `time` datetime DEFAULT NULL COMMENT '呼叫服务的时间',
  `user_id` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL COMMENT '服务的处理状态',
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `service_user` (`user_id`),
  KEY `service_room` (`room_id`),
  CONSTRAINT `service_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `service_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `service_num` int(11) DEFAULT NULL,
  `new_user_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `day` (`day`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `username` varchar(50) NOT NULL COMMENT '用于登录的账号',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(50) NOT NULL COMMENT '用于加盐hash加密',
  `hotel` int(11) DEFAULT NULL COMMENT '所属酒店，一般客人该字段为空，工作人员才有',
  `isadmin` varchar(10) DEFAULT NULL COMMENT '是否是管理者的标记 1 是管理者；2是普通用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
DROP TRIGGER IF EXISTS `add_order`;
DELIMITER ;;
CREATE TRIGGER `add_order` AFTER INSERT ON `order` FOR EACH ROW INSERT INTO statistics (new_user_num,order_num,service_num,day) VALUE(0,1,0,date_format(new.order_time,'%Y-%m-%d')) ON DUPLICATE KEY UPDATE order_num=order_num+1
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `del_order`;
DELIMITER ;;
CREATE TRIGGER `del_order` AFTER DELETE ON `order` FOR EACH ROW begin
update statistics set order_num=order_num-1 where day=date_format(old.order_time,'%Y-%m-%d');
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `add_room`;
DELIMITER ;;
CREATE TRIGGER `add_room` AFTER INSERT ON `room` FOR EACH ROW begin

update room_type set num=num+1 where  id=new.room_type_id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `add_service`;
DELIMITER ;;
CREATE TRIGGER `add_service` AFTER INSERT ON `service` FOR EACH ROW begin
INSERT INTO statistics (new_user_num,order_num,service_num,day) VALUE(0,0,1,date_format(now(),'%Y-%m-%d')) ON DUPLICATE KEY UPDATE service_num=service_num+1;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `del_service`;
DELIMITER ;;
CREATE TRIGGER `del_service` AFTER DELETE ON `service` FOR EACH ROW begin
update statistics set service_num=service_num-1 where day=date_format(old.time,'%Y-%m-%d');
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `new_user`;
DELIMITER ;;
CREATE TRIGGER `new_user` AFTER INSERT ON `user` FOR EACH ROW begin
INSERT INTO statistics (new_user_num,order_num,service_num,day) VALUE(1,0,0,date_format(now(),'%Y-%m-%d')) ON DUPLICATE KEY UPDATE new_user_num=new_user_num+1;
end
;;
DELIMITER ;
