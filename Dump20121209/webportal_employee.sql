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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_id` varchar(25) NOT NULL,
  `user_id` int(2) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city_id` int(11) NOT NULL,
  `email_id` varchar(25) NOT NULL,
  `mobile_no` varchar(20) NOT NULL,
  `emp_designation_id` int(11) NOT NULL,
  `basic_salary` int(25) DEFAULT NULL,
  `dateOfjoin` date NOT NULL,
  `dateOfbirth` date NOT NULL,
  `gender` bit(1) NOT NULL,
  `maritual_status` varchar(15) NOT NULL,
  `status` bit(1) NOT NULL,
  `photo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
REPLACE INTO `employee` VALUES ('20121101181541',104,'bharat','shah','plot no 305, sector 22',1,'bharat123@gmail.com','9879877890',4,12000,'2012-11-01','1989-02-01','','Unmarried','','20121101181541.jpg'),('20121112151126',105,'harsh','modi','naranpura saptak party plot near petrol pump',3,'harsh@modi@gmail.com','987890987',5,13000,'2012-10-12','1989-01-01','','Unmarried','','20121112151126.jpg'),('20121119150111',106,'hardik','patel','rampura chokadi ',4,'hardik@gmail.com','98789098',5,10000,'2012-11-09','2012-11-07','','Unmarried','','20121119150111.jpg'),('20121121101513',107,'kaushik','patel','plot no 306, kalol society',2,'kaushik@gmail.com','34678256783',5,12000,'2012-11-01','1991-03-07','','Unmarried','','20121121101513.jpg'),('20121121111501',108,'dipan','patel','sector 2',2,'dipan@gmail.com','987890987',5,10000,'2012-11-01','2012-11-01','','Unmarried','','20121121111501.jpg'),('20121124134838',109,'rohit','sadhu','plot no :305',2,'rohit@gmail.com','98768590590',4,12000,'2012-11-01','2012-11-01','','Unmarried','','20121124134838.jpg'),('20121124135117',110,'kailesh','patel','plot no :305',2,'kaileshpatel@gmail.com','98768590590',4,12000,'2012-11-01','2012-11-01','','0','','20121124135117.jpg'),('20121124135301',111,'kailesh','patel','plot no :305',2,'kaileshpatel@gmail.com','98768590590',4,12000,'2012-11-01','2012-11-01','','Unmarried','','20121124135301.jpg'),('20121124135605',112,'viral','patel','bapunagar',1,'viral@gmail.co.in','90789080',1,12000,'2012-11-15','2012-11-06','','Unmarried','','20121124135605.jpg'),('20121125152603',113,'dhaval','raval','sector 8',1,'dhavalkraval@gmail.com','9879032183',1,12000,'2012-11-01','2012-11-01','','Unmarried','','20121125152603.jpg'),('20121127192125',120,'pratik','patel','gandhinagar',1,'pratik@gmail.com','8889808908',4,10000,'2012-11-01','1989-01-02','','Unmarried','','20121127192125.jpg'),('20121128015413',121,'john','malik','fol som ,phase 2',5,'johnmalik@gmail.com','987890987',4,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128015413.jpg'),('20121128015531',122,'josheph','malik','san jose state university ,phase 2',6,'josephmalik@gmail.com','987890987',5,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128015531.jpg'),('20121128015641',123,'riddhi','patel','bapunagar, char rasta, plot 45',1,'josephmalik@gmail.com','987890987',5,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128015641.jpg'),('20121128015759',124,'rahuk','shah','paldi char rasta',1,'rahuk@gmail.com','987890987',5,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128015759.jpg'),('20121128015851',125,'raj','chopara','bt society ,naranpura',1,'rahuk@gmail.com','97342908402',5,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128015851.jpg'),('20121128015943',126,'nirmal','patel','raj pipda, nj coloni',1,'nirmal@gmail.com','97342908402',5,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128015943.jpg'),('20121128020040',127,'palak','patel','maninagar, palak society',1,'palak@gmail.com','97342908402',5,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128020040.jpg'),('20121128020129',128,'ankita','jani','maninagar, palak society',1,'ankita@gmail.com','97342908402',5,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128020129.jpg'),('20121128020230',129,'hiya','suthar','sector-22, plot 90',4,'hiyal@gmail.com','98789361623',4,11000,'2012-11-02','1989-01-02','','Unmarried','','20121128020230.jpg'),('20121128020314',130,'keyur','patel','sector-22, plot 90',4,'keyurl@gmail.com','956756778',3,19000,'2012-11-02','1989-01-02','','Unmarried','','20121128020314.jpg'),('20121128020401',131,'megha','raval','plot no 45, shreyash society',2,'meghal@gmail.com','956756778',4,19000,'2012-11-02','1989-01-02','','Unmarried','','20121128020401.jpg'),('20121128020730',133,'patthan','salaman','plot no 45, shreyash society',1,'patthan@gmail.com','956756778',5,10000,'2012-11-02','1989-01-02','','Unmarried','','20121128020730.jpg'),('20121128021519',134,'parth','patel','plot no 45, shreyash society',1,'nirmal@gmail.com','956756778',5,10000,'2012-11-02','1989-01-02','','Unmarried','','20121128021519.jpg'),('20121128022025',135,'apin','patel','rampura chokadi, lj hospital near',1,'apin@gmail.com','987654345',4,12000,'2012-11-16','2012-11-07','','Unmarried','','20121128022025.jpg');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
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
