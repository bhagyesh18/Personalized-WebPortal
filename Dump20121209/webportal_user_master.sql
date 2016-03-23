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
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_master` (
  `user_id` int(5) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(15) NOT NULL,
  `user_role_id` int(2) NOT NULL,
  `security_question` varchar(50) NOT NULL,
  `security_answer` varchar(50) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
REPLACE INTO `user_master` VALUES (101,'admin','admin123',1,'nationality','indian',''),(102,'taha','cwpltnhstb',2,'nationality','indian',''),(103,'bhagyesh','bhagyesh123',2,'nationality','indian',''),(104,'bharat','bharat',3,'nation','india',''),(105,'harsh','harsh123',3,'nationality','india',''),(106,'hardik','hardik',3,'pet name','html',''),(107,'kaushik','123',3,'nation','indian',''),(108,'dipan','dipan',3,'nation','indian',''),(109,'rohit','rohit123',3,'nation','india',''),(110,'kailesh','kailesh',3,'nation','india',''),(111,'kailesh1','kailesh',3,'nation','india',''),(112,'viral','viral',3,'nation','indian',''),(113,'dhaval','dhaval',3,'nation','india',''),(120,'pratik','pratik',3,'nation','indian',''),(121,'john','john',3,'nation','usa',''),(122,'josheph','josheph',3,'nation','usa',''),(123,'riddhi','riddhi',3,'nation','india',''),(124,'rahul','rahul',3,'nation','india',''),(125,'raj','raj',3,'nation','india',''),(126,'nirmal','nirmal',3,'nation','india',''),(127,'palak','palak',3,'nation','india',''),(128,'ankita','ankita',3,'nation','india',''),(129,'hiya','hiya',3,'nation','india',''),(130,'keyu','keyur',3,'nation','india',''),(131,'megha','megha',3,'nation','india',''),(133,'pathan','patthan',3,'nation','india',''),(134,'parth','parth',3,'nation','india',''),(135,'apin','apin',3,'nation','india','');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
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
