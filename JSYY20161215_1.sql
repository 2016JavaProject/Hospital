-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.29 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.5109
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 db_hospital 的数据库结构
DROP DATABASE IF EXISTS `db_hospital`;
CREATE DATABASE IF NOT EXISTS `db_hospital` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_hospital`;

-- 导出  表 db_hospital.t_apothecary 结构
DROP TABLE IF EXISTS `t_apothecary`;
CREATE TABLE IF NOT EXISTS `t_apothecary` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '药师姓名',
  `tel` varchar(11) DEFAULT NULL COMMENT '药师电话',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `dept` int(11) DEFAULT NULL COMMENT '部门',
  `deptName` varchar(50) NOT NULL COMMENT '部门名称',
  `comm` varchar(200) DEFAULT NULL COMMENT '状态：0、离职；1、空闲；2、忙碌；3、休班',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药师信息表';

-- 正在导出表  db_hospital.t_apothecary 的数据：~0 rows (大约)
DELETE FROM `t_apothecary`;
/*!40000 ALTER TABLE `t_apothecary` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_apothecary` ENABLE KEYS */;

-- 导出  表 db_hospital.t_cashier 结构
DROP TABLE IF EXISTS `t_cashier`;
CREATE TABLE IF NOT EXISTS `t_cashier` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `tel` varchar(11) DEFAULT NULL COMMENT '电话',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `dept` int(11) DEFAULT NULL COMMENT '部门',
  `deptName` varchar(50) NOT NULL COMMENT '部门名称',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门诊人员信息表';

-- 正在导出表  db_hospital.t_cashier 的数据：~0 rows (大约)
DELETE FROM `t_cashier`;
/*!40000 ALTER TABLE `t_cashier` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cashier` ENABLE KEYS */;

-- 导出  表 db_hospital.t_dept 结构
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE IF NOT EXISTS `t_dept` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- 正在导出表  db_hospital.t_dept 的数据：~0 rows (大约)
DELETE FROM `t_dept`;
/*!40000 ALTER TABLE `t_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_dept` ENABLE KEYS */;

-- 导出  表 db_hospital.t_doctor 结构
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE IF NOT EXISTS `t_doctor` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '医生姓名',
  `tel` varchar(50) DEFAULT NULL COMMENT '医生电话',
  `age` int(11) DEFAULT NULL COMMENT '医生年龄',
  `dept` int(11) DEFAULT NULL COMMENT '部门',
  `deptName` varchar(50) NOT NULL COMMENT '部门名称',
  `status` int(1) NOT NULL COMMENT '状态：1、空闲；2、忙碌；3、休班；0、离职',
  `comm` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生信息表';

-- 正在导出表  db_hospital.t_doctor 的数据：~0 rows (大约)
DELETE FROM `t_doctor`;
/*!40000 ALTER TABLE `t_doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_doctor` ENABLE KEYS */;

-- 导出  表 db_hospital.t_medicine 结构
DROP TABLE IF EXISTS `t_medicine`;
CREATE TABLE IF NOT EXISTS `t_medicine` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '药品名称',
  `price` float NOT NULL COMMENT '药品单价',
  `methods` int(11) NOT NULL COMMENT '计费方式：1、片；2、ml',
  `isEnabled` int(11) DEFAULT NULL COMMENT '药品是否有效：0、无效；1、有效',
  `updateTime` varchar(50) NOT NULL COMMENT '药品信息上次更新时间',
  `norms` int(11) NOT NULL COMMENT '药品规格：片/盒；ml/瓶',
  `num` int(11) NOT NULL COMMENT '库存量：盒/瓶',
  `specNum` float NOT NULL COMMENT '散装库存量',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品信息表';

-- 正在导出表  db_hospital.t_medicine 的数据：~3 rows (大约)
DELETE FROM `t_medicine`;
/*!40000 ALTER TABLE `t_medicine` DISABLE KEYS */;
INSERT INTO `t_medicine` (`id`, `name`, `price`, `methods`, `isEnabled`, `updateTime`, `norms`, `num`, `specNum`, `comm`) VALUES
	('1', '板蓝根', 10, 1, 1, '2016-12-14', 1, 1000, 0, NULL),
	('2', '风油精', 8, 1, 1, '2016-12-14', 1, 20, 0, NULL),
	('3', '999感冒灵', 28, 1, 0, '2016-12-14', 1, 50, 0, NULL);
/*!40000 ALTER TABLE `t_medicine` ENABLE KEYS */;

-- 导出  表 db_hospital.t_medicinerecord 结构
DROP TABLE IF EXISTS `t_medicinerecord`;
CREATE TABLE IF NOT EXISTS `t_medicinerecord` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `recordId` varchar(50) NOT NULL COMMENT '就诊信息ID',
  `medicineId` varchar(50) DEFAULT NULL COMMENT '用药ID',
  `medName` varchar(50) NOT NULL COMMENT '用药名称',
  `methods` int(11) NOT NULL COMMENT '用药计费方式：1、盒/瓶；2、片/ml',
  `num` float NOT NULL COMMENT '用药数量',
  `createTime` varchar(50) NOT NULL COMMENT '创建时间',
  `status` int(11) NOT NULL COMMENT '状态：1、等待中；2、正在执行；3、已完成',
  `comm` varchar(200) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='就诊用药信息表';

-- 正在导出表  db_hospital.t_medicinerecord 的数据：~0 rows (大约)
DELETE FROM `t_medicinerecord`;
/*!40000 ALTER TABLE `t_medicinerecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_medicinerecord` ENABLE KEYS */;

-- 导出  表 db_hospital.t_patient 结构
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE IF NOT EXISTS `t_patient` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '病人姓名',
  `tel` varchar(50) DEFAULT NULL COMMENT '病人电话',
  `age` int(11) DEFAULT NULL COMMENT '病人年龄',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='病人信息表';

-- 正在导出表  db_hospital.t_patient 的数据：~0 rows (大约)
DELETE FROM `t_patient`;
/*!40000 ALTER TABLE `t_patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_patient` ENABLE KEYS */;

-- 导出  表 db_hospital.t_record 结构
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE IF NOT EXISTS `t_record` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `patientId` varchar(50) NOT NULL COMMENT '病人ID',
  `doctorId` varchar(50) NOT NULL COMMENT '医生ID',
  `docFee` float NOT NULL COMMENT '医生诊费',
  `createTime` varchar(50) NOT NULL COMMENT '创建时间',
  `status` varchar(50) NOT NULL COMMENT '是否有效：1、等待中；2、正在执行；3、执行完成；0、无效',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='就诊信息表';

-- 正在导出表  db_hospital.t_record 的数据：~0 rows (大约)
DELETE FROM `t_record`;
/*!40000 ALTER TABLE `t_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_record` ENABLE KEYS */;

-- 导出  表 db_hospital.t_subscribe 结构
DROP TABLE IF EXISTS `t_subscribe`;
CREATE TABLE IF NOT EXISTS `t_subscribe` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `patientId` varchar(50) NOT NULL COMMENT '病人ID',
  `subscribeTime` varchar(50) NOT NULL COMMENT '预约时间',
  `subscribeDept` int(11) NOT NULL COMMENT '预约科室',
  `createTime` varchar(50) NOT NULL COMMENT '创建时间',
  `comm` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约信息表';

-- 正在导出表  db_hospital.t_subscribe 的数据：~0 rows (大约)
DELETE FROM `t_subscribe`;
/*!40000 ALTER TABLE `t_subscribe` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_subscribe` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
