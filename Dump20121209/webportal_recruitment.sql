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
-- Table structure for table `recruitment`
--

DROP TABLE IF EXISTS `recruitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruitment` (
  `recruitment_id` varchar(25) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `middle_name` varchar(100) NOT NULL,
  `mother_name` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `grad_course` varchar(100) NOT NULL,
  `grad_institute` varchar(100) NOT NULL,
  `grad_year` varchar(25) NOT NULL,
  `grad_percentage` float NOT NULL,
  `post_grad_course` varchar(100) DEFAULT NULL,
  `post_grad_institute` varchar(100) DEFAULT NULL,
  `post_grad_year` varchar(10) DEFAULT NULL,
  `post_grad_percentage` float DEFAULT NULL,
  `under_grad_course` varchar(100) NOT NULL,
  `under_grad_institute` varchar(100) NOT NULL,
  `under_grad_year` varchar(10) NOT NULL,
  `under_grad_percentage` float NOT NULL,
  `status` varchar(50) NOT NULL,
  `resume_text` varchar(255) DEFAULT NULL,
  `resume_file_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`recruitment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment`
--

LOCK TABLES `recruitment` WRITE;
/*!40000 ALTER TABLE `recruitment` DISABLE KEYS */;
REPLACE INTO `recruitment` VALUES ('20121126142016','123','narendra','patel','s','urmilaben','1','2012-11-08','bca','hl','2010',8908,'hkll','hklkhl','2010',8908,'hklhklh','lkhllh','2006',8989,'1','narendra_2012-11-08.jpg','narendra_2012-11-08.pdf');
/*!40000 ALTER TABLE `recruitment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-09 20:46:05
