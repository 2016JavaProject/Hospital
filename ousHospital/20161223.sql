-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.29 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 db_hospital_jason 的数据库结构
DROP DATABASE IF EXISTS `db_hospital_jason`;
CREATE DATABASE IF NOT EXISTS `db_hospital_jason` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_hospital_jason`;


-- 导出  表 db_hospital_jason.t_apothecary 结构
DROP TABLE IF EXISTS `t_apothecary`;
CREATE TABLE IF NOT EXISTS `t_apothecary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '药师姓名',
  `password` varchar(11) DEFAULT NULL COMMENT '密码',
  `tel` varchar(11) DEFAULT NULL COMMENT '药师电话',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `dept` int(11) DEFAULT NULL COMMENT '部门',
  `comm` varchar(200) DEFAULT NULL COMMENT '状态：0、离职；1、空闲；2、忙碌；3、休班',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='药师信息表';

-- 正在导出表  db_hospital_jason.t_apothecary 的数据：~7 rows (大约)
DELETE FROM `t_apothecary`;
/*!40000 ALTER TABLE `t_apothecary` DISABLE KEYS */;
INSERT INTO `t_apothecary` (`id`, `name`, `password`, `tel`, `age`, `dept`, `comm`) VALUES
	(1, 'test', NULL, NULL, NULL, NULL, NULL),
	(2, '华明玥', '123456', NULL, NULL, NULL, NULL),
	(3, 'test', NULL, NULL, NULL, NULL, NULL),
	(5, '李兴', '1234578', NULL, NULL, NULL, NULL),
	(6, '呼杰', '12345', NULL, NULL, NULL, NULL),
	(8, '张刚', '12345', NULL, NULL, NULL, NULL),
	(18, '鸟哥', '12345', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_apothecary` ENABLE KEYS */;


-- 导出  表 db_hospital_jason.t_dept 结构
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE IF NOT EXISTS `t_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- 正在导出表  db_hospital_jason.t_dept 的数据：~6 rows (大约)
DELETE FROM `t_dept`;
/*!40000 ALTER TABLE `t_dept` DISABLE KEYS */;
INSERT INTO `t_dept` (`id`, `name`) VALUES
	(1, '外科'),
	(2, '神经科'),
	(3, '眼科'),
	(4, '儿科'),
	(5, '妇科'),
	(7, '放射科');
/*!40000 ALTER TABLE `t_dept` ENABLE KEYS */;


-- 导出  表 db_hospital_jason.t_doctor 结构
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE IF NOT EXISTS `t_doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '医生姓名',
  `tel` varchar(50) DEFAULT NULL COMMENT '医生电话',
  `age` int(11) DEFAULT NULL COMMENT '医生年龄',
  `deptid` int(11) NOT NULL COMMENT '部门',
  `status` varchar(50) NOT NULL COMMENT '状态：1、空闲；2、忙碌；3、休班；0、离职',
  `comm` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_doctor_t_dept` (`deptid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COMMENT='医生信息表';

-- 正在导出表  db_hospital_jason.t_doctor 的数据：~8 rows (大约)
DELETE FROM `t_doctor`;
/*!40000 ALTER TABLE `t_doctor` DISABLE KEYS */;
INSERT INTO `t_doctor` (`id`, `name`, `tel`, `age`, `deptid`, `status`, `comm`, `password`) VALUES
	(12, 'jason', '123', 15, 7, '忙碌', NULL, '1234'),
	(13, 'tom', '', 15, 5, '空闲', NULL, '1234'),
	(19, 'alice', '', 45, 7, '空闲', NULL, '1234'),
	(26, 'Li', NULL, 59, 5, '空闲', NULL, NULL),
	(46, 'Trump', '', 59, 2, '离职', NULL, '1234'),
	(47, 'Hillary', '', 75, 4, '离职', NULL, '1234'),
	(90, 'kesha', '', 30, 2, '离职', NULL, '1234'),
	(97, 'kesha', '', 30, 7, '离职', NULL, NULL);
/*!40000 ALTER TABLE `t_doctor` ENABLE KEYS */;


-- 导出  表 db_hospital_jason.t_medicine 结构
DROP TABLE IF EXISTS `t_medicine`;
CREATE TABLE IF NOT EXISTS `t_medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '药品名称',
  `price` float DEFAULT NULL COMMENT '药品单价',
  `methods` int(11) DEFAULT NULL COMMENT '计费方式：1、片；2、ml',
  `saled` int(11) DEFAULT NULL COMMENT '卖出数量',
  `isEnabled` int(11) DEFAULT NULL COMMENT '药品是否有效：0、无效；1、有效',
  `updateTime` varchar(50) DEFAULT NULL COMMENT '药品信息上次更新时间',
  `norms` int(11) DEFAULT NULL COMMENT '药品规格：片/盒；ml/瓶',
  `stock` int(11) DEFAULT NULL COMMENT '库存量：盒/瓶',
  `specNum` float DEFAULT NULL COMMENT '散装库存量',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='药品信息表';

-- 正在导出表  db_hospital_jason.t_medicine 的数据：~6 rows (大约)
DELETE FROM `t_medicine`;
/*!40000 ALTER TABLE `t_medicine` DISABLE KEYS */;
INSERT INTO `t_medicine` (`id`, `name`, `price`, `methods`, `saled`, `isEnabled`, `updateTime`, `norms`, `stock`, `specNum`, `comm`) VALUES
	(1, '风油精', 12, NULL, 6, NULL, NULL, NULL, 15, NULL, NULL),
	(2, '云南白药', 16, NULL, 78, NULL, NULL, NULL, 30, NULL, NULL),
	(3, '西瓜霜', 96, NULL, 1, NULL, NULL, NULL, 5, NULL, NULL),
	(4, '无水酒精', 100, NULL, 6, NULL, NULL, NULL, 5, NULL, NULL),
	(5, '大云', 56, NULL, 30, NULL, NULL, NULL, 34, NULL, NULL),
	(6, '云田七', 4, NULL, 21, NULL, NULL, NULL, 84, NULL, NULL);
/*!40000 ALTER TABLE `t_medicine` ENABLE KEYS */;


-- 导出  表 db_hospital_jason.t_patient 结构
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE IF NOT EXISTS `t_patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) DEFAULT NULL COMMENT '病人姓名',
  `tel` varchar(50) DEFAULT NULL COMMENT '病人电话',
  `age` int(11) DEFAULT NULL COMMENT '病人年龄',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 COMMENT='病人信息表';

-- 正在导出表  db_hospital_jason.t_patient 的数据：~17 rows (大约)
DELETE FROM `t_patient`;
/*!40000 ALTER TABLE `t_patient` DISABLE KEYS */;
INSERT INTO `t_patient` (`id`, `name`, `tel`, `age`, `comm`) VALUES
	(2, '赵', NULL, NULL, NULL),
	(4, '钱', NULL, NULL, NULL),
	(6, '孙', NULL, NULL, NULL),
	(12, '李', NULL, NULL, NULL),
	(14, '王', NULL, NULL, NULL),
	(15, '刘', NULL, NULL, NULL),
	(16, '齐', NULL, NULL, NULL),
	(19, '石', NULL, NULL, NULL),
	(47, '唐', NULL, NULL, NULL),
	(78, 'test', NULL, NULL, NULL),
	(79, 'test2', NULL, NULL, NULL),
	(80, 'test3', NULL, NULL, NULL),
	(81, '王珊', NULL, NULL, NULL),
	(82, 'c陈红', NULL, NULL, NULL),
	(83, '吕国英', NULL, NULL, NULL),
	(84, '张海', NULL, NULL, NULL),
	(85, '路明', NULL, NULL, NULL),
	(86, '山田', NULL, NULL, NULL),
	(87, '王博', NULL, NULL, NULL),
	(88, '朱慧', NULL, NULL, NULL),
	(89, '王谁', NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_patient` ENABLE KEYS */;


-- 导出  表 db_hospital_jason.t_prescription 结构
DROP TABLE IF EXISTS `t_prescription`;
CREATE TABLE IF NOT EXISTS `t_prescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patientid` int(11) NOT NULL,
  `medicineid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_prescription_t_patient` (`patientid`),
  KEY `FK_t_prescription_t_medicine` (`medicineid`),
  CONSTRAINT `FK_t_prescription_t_medicine` FOREIGN KEY (`medicineid`) REFERENCES `t_medicine` (`id`),
  CONSTRAINT `FK_t_prescription_t_patient` FOREIGN KEY (`patientid`) REFERENCES `t_patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='药方';

-- 正在导出表  db_hospital_jason.t_prescription 的数据：~8 rows (大约)
DELETE FROM `t_prescription`;
/*!40000 ALTER TABLE `t_prescription` DISABLE KEYS */;
INSERT INTO `t_prescription` (`id`, `patientid`, `medicineid`, `num`) VALUES
	(19, 12, 2, 2),
	(20, 12, 2, 1),
	(21, 12, 2, 3),
	(22, 12, 2, 4),
	(23, 12, 2, 1),
	(25, 12, 4, 5),
	(26, 81, 2, 1),
	(27, 81, 2, 1);
/*!40000 ALTER TABLE `t_prescription` ENABLE KEYS */;


-- 导出  表 db_hospital_jason.t_record 结构
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE IF NOT EXISTS `t_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `patientId` int(11) DEFAULT NULL COMMENT '病人ID',
  `doctorId` int(11) DEFAULT NULL COMMENT '医生ID',
  `deptid` int(11) DEFAULT NULL COMMENT '科室',
  `Fee` float unsigned DEFAULT NULL COMMENT '医生诊费+药费',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(50) DEFAULT NULL COMMENT '是否有效：1、等待；2、看病；3、等待付费；0、完成一次看病',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_t_record_t_doctor` (`doctorId`),
  KEY `FK_t_record_t_dept` (`deptid`),
  KEY `FK_t_record_t_patient` (`patientId`),
  CONSTRAINT `FK_t_record_t_dept` FOREIGN KEY (`deptid`) REFERENCES `t_dept` (`id`),
  CONSTRAINT `FK_t_record_t_doctor` FOREIGN KEY (`doctorId`) REFERENCES `t_doctor` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_t_record_t_patient` FOREIGN KEY (`patientId`) REFERENCES `t_patient` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='就诊信息表';

-- 正在导出表  db_hospital_jason.t_record 的数据：~0 rows (大约)
DELETE FROM `t_record`;
/*!40000 ALTER TABLE `t_record` DISABLE KEYS */;
INSERT INTO `t_record` (`id`, `patientId`, `doctorId`, `deptid`, `Fee`, `createTime`, `status`, `comm`) VALUES
	(28, 85, 12, 7, 15, '2016-12-23 20:02:00', '0', NULL),
	(29, 86, 90, 2, 63, '2016-12-23 02:03:00', '0', NULL),
	(30, 87, 13, 5, 95, '2016-12-23 02:04:00', '0', NULL),
	(31, 88, 13, 5, 15, '2016-12-23 06:04:00', '0', NULL),
	(32, 89, 47, 4, 111, '2016-12-23 06:04:00', '0', NULL);
/*!40000 ALTER TABLE `t_record` ENABLE KEYS */;


-- 导出  表 db_hospital_jason.t_user 结构
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL COMMENT '1.管理员；2.医生；3.药师；4.院长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='管理员和院长账号';

-- 正在导出表  db_hospital_jason.t_user 的数据：~2 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `name`, `password`, `role`) VALUES
	(1, 'admin', 'admin', '管理员'),
	(2, 'leader', 'leader', '院长');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
