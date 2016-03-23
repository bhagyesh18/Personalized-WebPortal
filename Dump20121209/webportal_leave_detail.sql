CREATE DATABASE  IF NOT EXISTS `webportal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `webportal`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: webportal
-- ------------------------------------------------------
-- Server version	5.5.25a

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `leave_detail`
--

DROP TABLE IF EXISTS `leave_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_detail` (
  `leavedetail_id` int(2) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `emp_id` varchar(25) NOT NULL,
  `leavetype_id` int(2) NOT NULL,
  `leave_reason` varchar(150) NOT NULL,
  `leave_permission` bit(1) NOT NULL,
  `leave_start_date` date NOT NULL,
  `leave_end_date` date NOT NULL,
  `total_leave_days` int(2) NOT NULL,
  PRIMARY KEY (`leavedetail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_detail`
--

LOCK TABLES `leave_detail` WRITE;
/*!40000 ALTER TABLE `leave_detail` DISABLE KEYS */;
REPLACE INTO `leave_detail` VALUES (03,'20121101181541',1,'mohram','\0','2012-11-01','2012-11-22',21),(04,'20121119150111',1,'nnmn','','2012-11-01','2012-11-02',1),(05,'20121121101513',1,'uitut','','2012-11-01','2012-11-02',1),(06,'20121121111501',2,'asdad','','2012-11-08','2012-11-15',7),(07,'20121124135605',1,'ramjaan','\0','2012-11-01','2012-11-02',1),(08,'20121101181541',1,'mohram','','2012-11-02','2012-11-08',6),(09,'20121101181541',1,'sister marriage','','2012-11-08','2012-11-10',2),(10,'20121128015851',1,'marriage','\0','2012-11-01','2012-11-16',15),(11,'20121128015851',1,'sagai','\0','2012-11-23','2012-11-24',1),(12,'20121128015641',1,'freind marriege','','2012-11-14','2012-11-16',2),(13,'20121128015641',1,'shopping','\0','2012-11-16','2012-11-17',1),(14,'20121128015943',1,'sister marriege','\0','2012-11-15','2012-11-17',2),(15,'20121128015943',1,'freinds marriage','','2012-11-29','2012-11-30',1),(16,'20121128020314',1,'marriage','','2012-11-22','2012-11-23',1),(17,'20121128020314',1,'hsopital check up','\0','2012-11-14','2012-11-15',1),(18,'20121128015531',1,'kite festival','\0','2013-01-01','2013-01-10',9),(19,'20121128015531',1,'kite festival','\0','2013-01-01','2013-01-07',6),(20,'20121128015531',1,'kite festival','\0','2013-01-01','2013-01-04',3),(21,'20121128022025',1,'brother engagement','','2012-12-07','2012-12-27',20),(22,'20121128022025',1,'brother engagement','','2012-12-07','2012-12-17',10),(23,'20121128022025',1,'brother engagement','','2012-12-07','2012-12-17',10),(24,'20121128022025',1,'brother engagement','\0','2012-12-07','2012-12-14',7),(25,'20121121101513',1,'marrige','\0','2012-11-07','2012-11-29',22),(26,'20121121101513',1,'marrige','\0','2012-11-07','2012-11-21',14),(27,'20121121101513',2,'dangue','\0','2012-10-03','2012-10-05',2),(28,'20121119150111',2,'dangue','\0','2012-11-01','2012-11-03',2),(29,'20121121111501',2,'fever','\0','2012-11-01','2012-11-02',1),(30,'20121121111501',1,'sister marriage','\0','2012-11-29','2012-11-30',1),(31,'20121121111501',1,'sister marriage','\0','2012-11-29','2012-12-01',2),(32,'20121124134838',2,'fever','\0','2012-11-07','2012-11-15',8),(33,'20121124134838',1,'marriage','\0','2012-11-30','2012-12-01',1),(34,'20121128015759',2,'dangue','\0','2012-11-08','2012-11-09',1),(35,'20121101181541',1,'i have to be present at passport office for renew passport','\0','2012-11-08','2012-11-09',1);
/*!40000 ALTER TABLE `leave_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-09 20:46:06
