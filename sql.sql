/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.49 : Database - myforum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`myforum` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `myforum`;

/*Table structure for table `login_log` */

DROP TABLE IF EXISTS `login_log`;

CREATE TABLE `login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登陆时间',
  `ip` varchar(30) NOT NULL COMMENT '登陆IP',
  `device` varchar(200) DEFAULT NULL COMMENT '设备',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `login_log` */

insert  into `login_log`(`id`,`user_id`,`login_time`,`ip`,`device`) values (1,18,'2019-08-26 12:29:15','0:0:0:0:0:0:0:1',NULL),(2,20,'2019-08-26 12:30:04','0:0:0:0:0:0:0:1',NULL),(3,18,'2019-08-26 18:17:00','0:0:0:0:0:0:0:1',NULL),(4,18,'2019-08-26 19:23:45','0:0:0:0:0:0:0:1',NULL),(5,18,'2019-08-26 19:25:23','0:0:0:0:0:0:0:1',NULL),(6,18,'2019-08-26 19:27:49','0:0:0:0:0:0:0:1',NULL),(7,18,'2019-08-26 19:36:05','0:0:0:0:0:0:0:1',NULL),(8,18,'2019-08-26 19:41:57','0:0:0:0:0:0:0:1',NULL),(9,18,'2019-08-26 19:43:41','0:0:0:0:0:0:0:1',NULL),(10,18,'2019-08-26 19:45:34','0:0:0:0:0:0:0:1',NULL),(11,18,'2019-08-26 20:03:42','0:0:0:0:0:0:0:1',NULL),(12,21,'2019-08-26 20:04:26','0:0:0:0:0:0:0:1',NULL);

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回复id',
  `topic_id` int(11) NOT NULL COMMENT '主题id',
  `reply_user_id` int(11) NOT NULL COMMENT '用户id',
  `content` text CHARACTER SET utf8mb4 NOT NULL COMMENT '回复内容',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `device` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '设备',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `reply` */

insert  into `reply`(`id`,`topic_id`,`reply_user_id`,`content`,`create_time`,`update_time`,`device`) values (52,13,18,'确实','2019-08-26 00:03:29','2019-08-26 00:03:29',NULL),(56,26,18,'测试事务回滚。','2019-08-26 00:24:01','2019-08-26 00:24:01',NULL),(60,33,18,'66666666','2019-08-26 00:32:09','2019-08-26 00:32:09',NULL),(61,32,18,'666','2019-08-26 00:32:17','2019-08-26 00:32:17',NULL),(62,34,18,'没啥好聊的','2019-08-26 00:42:03','2019-08-26 00:42:03',NULL),(67,48,18,'如果正常回滚，则不能删除此回复','2019-08-26 19:39:47','2019-08-26 19:39:47',NULL),(70,48,18,'...','2019-08-26 19:46:13','2019-08-26 19:46:13',NULL),(71,48,21,'完事了','2019-08-26 20:04:44','2019-08-26 20:04:44',NULL),(73,51,21,'gg','2019-08-26 20:06:13','2019-08-26 20:06:13',NULL);

/*Table structure for table `tab` */

DROP TABLE IF EXISTS `tab`;

CREATE TABLE `tab` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '板块id',
  `tab_name` varchar(50) NOT NULL COMMENT '板块名',
  `tab_name_en` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `tab` */

insert  into `tab`(`id`,`tab_name`,`tab_name_en`) values (1,'学习','study'),(2,'音乐','music'),(3,'足球','football'),(4,'电影','movie');

/*Table structure for table `topic` */

DROP TABLE IF EXISTS `topic`;

CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  `user_id` int(11) NOT NULL COMMENT '发帖人id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `title` varchar(200) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `click` int(11) NOT NULL DEFAULT '0' COMMENT '点击量',
  `tab_id` tinyint(4) NOT NULL COMMENT '发布板块',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `topic` */

insert  into `topic`(`id`,`user_id`,`create_time`,`update_time`,`title`,`content`,`click`,`tab_id`) values (13,18,'2019-08-25 20:23:37','2019-08-26 19:45:44','皇马的球好无聊','现在',19,3),(14,18,'2019-08-25 20:26:09','2019-08-26 19:27:57','尤文的更难看','，，，',10,3),(26,18,'2019-08-25 21:55:30','2019-08-26 18:34:39','测试事务','11',29,1),(32,19,'2019-08-26 00:27:06','2019-08-26 20:04:49','啥情况','????',13,3),(33,20,'2019-08-26 00:31:10','2019-08-26 13:59:07','sorry','',5,3),(34,18,'2019-08-26 00:41:54','2019-08-26 12:30:32','聊聊周杰伦吧','',3,2),(48,18,'2019-08-26 19:39:23','2019-08-26 20:04:44','测试删帖回滚','',9,1),(51,21,'2019-08-26 20:05:54','2019-08-26 20:06:13','发一个试试','',5,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户唯一ID',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone_num` varchar(15) DEFAULT NULL COMMENT '手机号',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `credit` int(11) NOT NULL COMMENT '积分',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像url',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户类型,0为普通用户,1为管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`phone_num`,`create_time`,`update_time`,`credit`,`avatar`,`type`) values (18,'ddd','698D51A19D8A121CE581499D7B701668','scutpeiliang@163.com','8611111111111','2019-08-24 21:23:43','2019-08-26 19:42:45',220,'d8993ce4-d341-47a2-9907-de7fd3605fb1.jpg',0),(19,'c罗','27C3D392DDC1F890D759E89878BE163D','scutpeiliang@163.com','8611111111111','2019-08-26 00:26:37','2019-08-26 00:27:36',10,'092a2b52-a3dc-440d-b4dc-08fd486191fe.jpg',0),(20,'皇家马戏团','ED2539FE892D2C52C42A440354E8E3D5','scutpeiliang@163.com','8611111111111','2019-08-26 00:30:33','2019-08-26 00:31:23',10,'19b61860-aac5-4f13-9f83-31e80f5d40a7.jpg',0),(21,'路人甲','698D51A19D8A121CE581499D7B701668','hhh@1.com','8655','2019-08-26 20:04:17','2019-08-26 20:05:54',10,'avatar-default-5.png',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
