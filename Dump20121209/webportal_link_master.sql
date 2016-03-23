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
-- Table structure for table `link_master`
--

DROP TABLE IF EXISTS `link_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `link_master` (
  `link_id` int(2) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) NOT NULL,
  `link_url` varchar(255) NOT NULL,
  `link_description` varchar(255) NOT NULL,
  `link_page` varchar(255) NOT NULL,
  `link_position` varchar(10) NOT NULL,
  `link_status` bit(1) NOT NULL,
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_master`
--

LOCK TABLES `link_master` WRITE;
/*!40000 ALTER TABLE `link_master` DISABLE KEYS */;
REPLACE INTO `link_master` VALUES (1,'Registration','registration.zul','resigistion form of employee','userpage.zul','menu',''),(2,'Leave Approval','Leaveapproval.zul','leave approval page','userpage.zul','menu',''),(3,'Email','emial.zul','email page','userpage.zul','menu',''),(4,'Manage Reports','manage_reports.zul','manage emp reports','userpage.zul','menu',''),(5,'Manage Salary','Manage_salary.zul','manage emp Salary','userpage.zul','menu',''),(6,'Payslip','payslip.zul','retrive payslip','userpage.zul','meuu',''),(7,'Leave Request','Leave_request.zul','leave request to HR','userpage.zul','menu',''),(8,'Submit Report','Submit_Report.zul','submit report to Hr','userpage.zul','menu',''),(9,'Profile','Emp_profile.zul','manage emp profile','userpage.zul','menu',''),(10,'Add Links','add_links.zul','Admin manages links','userpage.zul','menu',''),(11,'Designation','emp_designation_zul','add designation and view','userpage.zul','menu',''),(12,'Manage max Leaves','max_leaves','adjust max leaves','userpage.zul','menu',''),(13,'Employee Details','grid_employee.zul','view all employess','userpage.zul','menu',''),(14,'Leave Details','grid_leave_details.zul','view all employee\'s leaves ','userpage.zul ','menu',''),(15,'change Password','changed_password','change password','userpage.zul','menu',''),(16,'Check Leaves','Leave-balance.zul','check balance','userpage.zul','menu',''),(17,'Salary Detail','grid_salary.zul','all month salary','userpage.zul','menu',''),(18,'Check Leave Status','check_Leave_req_status.zul','check staus of request','userpage.zul','menu',''),(19,'Make Employee Absent','make_emp_Absent.zul','make absent leave','userpage.zul','menu',''),(20,'Send message','send_message.zul','send message','userpage.zul','menu',''),(21,'Show Message','show_messages.zul','show all messaged','userpage.zul','menu',''),(22,'Show Reports','show_daily_reports.zul','show All reports','userpage.zul','menu','');
/*!40000 ALTER TABLE `link_master` ENABLE KEYS */;
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
