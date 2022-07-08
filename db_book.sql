/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.13 : Database - db_book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_book`;

/*Table structure for table `t_audit` */

DROP TABLE IF EXISTS `t_audit`;

CREATE TABLE `t_audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `classification` varchar(10) NOT NULL COMMENT '0管理员，1用户',
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `class` varchar(20) DEFAULT NULL,
  `college` varchar(20) DEFAULT NULL,
  `studentID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_audit` */

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `bookTypeId` int(11) DEFAULT NULL,
  `bookDesc` varchar(1000) DEFAULT NULL,
  `inStock` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bookTypeId` (`bookTypeId`),
  CONSTRAINT `t_book_ibfk_1` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`bookName`,`author`,`sex`,`price`,`bookTypeId`,`bookDesc`,`inStock`) values (1,'Java基础入门','XX','女',100,1,'Java从入门到入土',3),(3,'建筑工程学','XX','男',99,2,'建筑工程学书籍',0),(5,'树犹如此','白先勇','男',39,5,'       《树犹如此》是白先勇的散文自选集，主要收录他回忆个人经历、亲友交往的文章。其中纪念亡友的《树犹如此》将至深痛楚沉淀六年，被称为“以血泪、以人间最纯真的感情去完成的生命之歌”。另收两篇写友人的新作：画家奚淞修佛之旅《寻找那一棵菩提树》，救助上万艾滋孤儿的杜聪《修菩萨行》。可见白先勇近年心中所系。\n      书中作品多成于白先勇“五十知天命”之后，董桥曾“惊讶他已然像自在、放下的老僧，任由一朵落花在他的掌心默默散发瞬息灿烂”。写至友王国祥、三姊先明，平实中蕴藏波澜壮阔，人间悲悯。桂林、上海、南京、台北，文化乡愁叠加，难觅归处。在倾注心血和青春的同人杂志《现代文学》，白先勇以文会友，情笃一生。他也关心年轻人的成长困境，艾滋病患的挣扎和勇气。生命繁华之欢喜，伤逝消亡之不舍，白先勇的天真执着和无可奈何，在散文中化为真实的有情世界。',2);

/*Table structure for table `t_booktype` */

DROP TABLE IF EXISTS `t_booktype`;

CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookTypeName` varchar(20) DEFAULT NULL,
  `bookTypeDesc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_booktype` */

insert  into `t_booktype`(`id`,`bookTypeName`,`bookTypeDesc`) values (1,'计算机类','计算机相关图书'),(2,'建筑类',NULL),(4,'测试类别','这是一个测试类别，哈哈哈'),(5,'中国文学','中国文学是指中国的当地中文文学，历史延续了数千年，从最早有记载的政府档案到明代为娱乐广大有文化的中国人而兴起的成熟的白话小说集。');

/*Table structure for table `t_borrow` */

DROP TABLE IF EXISTS `t_borrow`;

CREATE TABLE `t_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `bookName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookId` (`bookId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_borrow_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `t_book` (`id`),
  CONSTRAINT `t_borrow_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_borrow` */

insert  into `t_borrow`(`id`,`userId`,`bookId`,`bookName`) values (3,1,5,'树犹如此');

/*Table structure for table `t_history` */

DROP TABLE IF EXISTS `t_history`;

CREATE TABLE `t_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `bookName` varchar(20) NOT NULL,
  `borrow` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_history` */

insert  into `t_history`(`id`,`userName`,`bookName`,`borrow`) values (1,'student1','Java基础入门','已还'),(2,'student2','测试用例','已还'),(3,'student1','树犹如此','未还');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `classification` varchar(10) NOT NULL COMMENT '0管理员，1用户',
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `class` varchar(20) DEFAULT NULL,
  `college` varchar(20) DEFAULT NULL,
  `studentID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`userName`,`password`,`classification`,`name`,`sex`,`class`,`college`,`studentID`) values (1,'student1','123456','1','学生1','男','2020级','计算机学院','2020205000'),(2,'admin','123456','0',NULL,NULL,NULL,NULL,NULL),(3,'student2','123456','1','学生2','女','2020级','建筑学院','2020341xxx');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
