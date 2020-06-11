CREATE DATABASE  IF NOT EXISTS `dao_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dao_db`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: dao_db
-- ------------------------------------------------------
-- Server version	5.6.48-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_postal` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `rue` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` VALUES (1,75005,6,'Fustel','Paris'),(2,50670,8,'Orange','Montchamp'),(3,75005,6,'Fustel','Paris'),(4,50670,8,'Orange','Montchamp'),(5,75005,6,'Fustel','Paris'),(6,50670,8,'Orange','Montchamp'),(7,75005,6,'Fustel','Paris'),(8,50670,8,'Orange','Montchamp'),(9,75005,6,'Fustel','Paris'),(10,50670,8,'Orange','Montchamp'),(11,75005,6,'Fustel','Paris'),(12,50670,8,'Orange','Montchamp'),(13,75005,6,'Fustel','Paris'),(14,50670,8,'Orange','Montchamp'),(15,75005,6,'Fustel','Paris'),(16,50670,8,'Orange','Montchamp'),(17,75005,6,'Fustel','Paris'),(18,50670,8,'Orange','Montchamp'),(19,75005,6,'Fustel','Paris'),(20,50670,8,'Orange','Montchamp'),(21,75005,6,'Fustel','Paris'),(22,50670,8,'Orange','Montchamp'),(23,75005,6,'Fustel','Paris'),(24,50670,8,'Orange','Montchamp'),(25,75005,6,'Fustel','Paris'),(26,50670,8,'Orange','Montchamp'),(27,75005,6,'Fustel','Paris'),(28,50670,8,'Orange','Montchamp'),(29,75005,6,'Fustel','Paris'),(30,50670,8,'Orange','Montchamp'),(31,75005,6,'Fustel','Paris'),(32,50670,8,'Orange','Montchamp'),(33,75005,6,'Fustel','Paris'),(34,50670,8,'Orange','Montchamp'),(35,75005,6,'Fustel','Paris'),(36,50670,8,'Orange','Montchamp'),(37,75005,6,'Fustel','Paris'),(38,50670,8,'Orange','Montchamp'),(39,75005,6,'Fustel','Paris'),(40,50670,8,'Orange','Montchamp'),(41,75005,6,'Fustel','Paris'),(42,50670,8,'Orange','Montchamp'),(43,75005,6,'Fustel','Paris'),(44,50670,8,'Orange','Montchamp'),(45,75005,6,'Fustel','Paris'),(46,50670,8,'Orange','Montchamp'),(47,75005,6,'Fustel','Paris'),(48,50670,8,'Orange','Montchamp'),(49,75005,6,'Fustel','Paris'),(50,50670,8,'Orange','Montchamp'),(51,75005,6,'Fustel','Paris'),(52,50670,8,'Orange','Montchamp'),(53,75005,6,'Fustel','Paris'),(54,50670,8,'Orange','Montchamp'),(55,75005,6,'Fustel','Paris'),(56,50670,8,'Orange','Montchamp'),(57,75005,6,'Fustel','Paris'),(58,50670,8,'Orange','Montchamp');
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personne`
--

DROP TABLE IF EXISTS `personne`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_naissance` datetime NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK64wypb6go3kiegrp8ntdf7ywp` (`adresse_id`),
  CONSTRAINT `FK64wypb6go3kiegrp8ntdf7ywp` FOREIGN KEY (`adresse_id`) REFERENCES `adresse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personne`
--

LOCK TABLES `personne` WRITE;
/*!40000 ALTER TABLE `personne` DISABLE KEYS */;
INSERT INTO `personne` VALUES (1,'1990-06-06 00:00:00','BADAD','Cherif',1),(2,'1990-06-06 00:00:00','BLABLA','Jeanne',2),(3,'1990-06-06 00:00:00','Oulah','Oulah',2),(4,'1990-06-06 00:00:00','BADAD','Cherif',3),(5,'1990-06-06 00:00:00','BLABLA','Jeanne',4),(6,'1990-06-06 00:00:00','Oulah','Oulah',4),(7,'1990-06-06 00:00:00','BADAD','Cherif',5),(8,'1990-06-06 00:00:00','BLABLA','Jeanne',6),(9,'1990-06-06 00:00:00','Oulah','Oulah',6),(10,'1990-06-06 00:00:00','BADAD','Cherif',7),(11,'1990-06-06 00:00:00','BLABLA','Jeanne',8),(12,'1990-06-06 00:00:00','Oulah','Oulah',8),(13,'1990-06-06 00:00:00','BADAD','Cherif',9),(14,'1990-06-06 00:00:00','BLABLA','Jeanne',10),(15,'1990-06-06 00:00:00','Oulah','Oulah',10),(16,'1990-06-06 00:00:00','BADAD','Cherif',11),(17,'1990-06-06 00:00:00','BLABLA','Jeanne',12),(18,'1990-06-06 00:00:00','Oulah','Oulah',12),(19,'1990-06-06 00:00:00','BADAD','Cherif',13),(20,'1990-06-06 00:00:00','BLABLA','Jeanne',14),(21,'1990-06-06 00:00:00','Oulah','Oulah',14),(22,'1990-06-06 00:00:00','BADAD','Cherif',15),(23,'1990-06-06 00:00:00','BLABLA','Jeanne',16),(24,'1990-06-06 00:00:00','Oulah','Oulah',16),(25,'1990-06-06 00:00:00','BADAD','Cherif',17),(26,'1990-06-06 00:00:00','BLABLA','Jeanne',18),(27,'1990-06-06 00:00:00','Oulah','Oulah',18),(28,'1990-06-06 00:00:00','BADAD','Cherif',19),(29,'1990-06-06 00:00:00','BLABLA','Jeanne',20),(30,'1990-06-06 00:00:00','Oulah','Oulah',20),(31,'1990-06-06 00:00:00','BADAD','Cherif',21),(32,'1990-06-06 00:00:00','BLABLA','Jeanne',22),(33,'1990-06-06 00:00:00','Oulah','Oulah',22),(34,'1990-06-06 00:00:00','BADAD','Cherif',23),(35,'1990-06-06 00:00:00','BLABLA','Jeanne',24),(36,'1990-06-06 00:00:00','Oulah','Oulah',24),(37,'1990-06-06 00:00:00','BADAD','Cherif',25),(38,'1990-06-06 00:00:00','BLABLA','Jeanne',26),(39,'1990-06-06 00:00:00','Oulah','Oulah',26),(40,'1990-06-06 00:00:00','BADAD','Cherif',27),(41,'1990-06-06 00:00:00','BLABLA','Jeanne',28),(42,'1990-06-06 00:00:00','Oulah','Oulah',28),(43,'1990-06-06 00:00:00','BADAD','Cherif',29),(44,'1990-06-06 00:00:00','BLABLA','Jeanne',30),(45,'1990-06-06 00:00:00','Oulah','Oulah',30),(46,'1990-06-06 00:00:00','BADAD','Cherif',31),(47,'1990-06-06 00:00:00','BLABLA','Jeanne',32),(48,'1990-06-06 00:00:00','Oulah','Oulah',32),(49,'1990-06-06 00:00:00','BADAD','Cherif',33),(50,'1990-06-06 00:00:00','BLABLA','Jeanne',34),(51,'1990-06-06 00:00:00','Oulah','Oulah',34),(52,'1990-06-06 00:00:00','BADAD','Cherif',35),(53,'1990-06-06 00:00:00','BLABLA','Jeanne',36),(54,'1990-06-06 00:00:00','Oulah','Oulah',36),(55,'1990-06-06 00:00:00','BADAD','Cherif',37),(56,'1990-06-06 00:00:00','BLABLA','Jeanne',38),(57,'1990-06-06 00:00:00','Oulah','Oulah',38),(58,'1990-06-06 00:00:00','BADAD','Cherif',39),(59,'1990-06-06 00:00:00','BLABLA','Jeanne',40),(60,'1990-06-06 00:00:00','Oulah','Oulah',40),(61,'1990-06-06 00:00:00','BADAD','Cherif',41),(62,'1990-06-06 00:00:00','BLABLA','Jeanne',42),(63,'1990-06-06 00:00:00','Oulah','Oulah',42),(64,'1990-06-06 00:00:00','BADAD','Cherif',43),(65,'1990-06-06 00:00:00','BLABLA','Jeanne',44),(66,'1990-06-06 00:00:00','Oulah','Oulah',44),(67,'1990-06-06 00:00:00','BADAD','Cherif',45),(68,'1990-06-06 00:00:00','BLABLA','Jeanne',46),(69,'1990-06-06 00:00:00','Oulah','Oulah',46),(70,'1990-06-06 00:00:00','BADAD','Cherif',47),(71,'1990-06-06 00:00:00','BLABLA','Jeanne',48),(72,'1990-06-06 00:00:00','Oulah','Oulah',48),(73,'1990-06-06 00:00:00','BADAD','Cherif',49),(74,'1990-06-06 00:00:00','BLABLA','Jeanne',50),(75,'1990-06-06 00:00:00','Oulah','Oulah',50),(76,'1990-06-06 00:00:00','BADAD','Cherif',51),(77,'1990-06-06 00:00:00','BLABLA','Jeanne',52),(78,'1990-06-06 00:00:00','Oulah','Oulah',52),(79,'1990-06-06 00:00:00','BADAD','Cherif',53),(80,'1990-06-06 00:00:00','BLABLA','Jeanne',54),(81,'1990-06-06 00:00:00','Oulah','Oulah',54),(82,'1990-06-06 00:00:00','BADAD','Cherif',55),(83,'1990-06-06 00:00:00','BLABLA','Jeanne',56),(84,'1990-06-06 00:00:00','Oulah','Oulah',56),(85,'1990-06-06 00:00:00','BADAD','Cherif',57),(86,'1990-06-06 00:00:00','BLABLA','Jeanne',58),(87,'1990-06-06 00:00:00','Oulah','Oulah',58);
/*!40000 ALTER TABLE `personne` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dao_db'
--

--
-- Dumping routines for database 'dao_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-11 16:26:39
