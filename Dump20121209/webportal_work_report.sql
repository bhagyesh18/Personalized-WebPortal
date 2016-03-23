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
-- Table structure for table `work_report`
--

DROP TABLE IF EXISTS `work_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work_report` (
  `report_id` int(2) NOT NULL AUTO_INCREMENT,
  `emp_id` varchar(25) NOT NULL,
  `report_date` date NOT NULL,
  `work_description` varchar(150) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_report`
--

LOCK TABLES `work_report` WRITE;
/*!40000 ALTER TABLE `work_report` DISABLE KEYS */;
REPLACE INTO `work_report` VALUES (1,'20121119150111','2012-11-28','done work 40%. \nproject stuff: bt soultion\nconsult hemal',''),(2,'20121119150111','2012-11-28','done 60%\nconsult :  jani sir',''),(3,'20121124134838','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done',''),(4,'20121124135117','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done',''),(5,'20121124135117','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done',''),(6,'20121124135117','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done',''),(7,'20121124135301','2012-11-28','consulted :suthar ankiat\nwork done 90%\nwell done',''),(8,'20121124135301','2012-11-28','consulted :suthar ankiat\nwork done 98%\nwell done',''),(9,'20121124135605','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done',''),(10,'20121124135605','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done',''),(11,'20121128015413','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done',''),(12,'20121128015413','2012-11-28','consulted :bhagyesh\nwork done 90%\nwell done',''),(13,'20121128015759','2012-11-28','consulted :hemal suther\nwork done 90%\nwell done','');
/*!40000 ALTER TABLE `work_report` ENABLE KEYS */;
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
