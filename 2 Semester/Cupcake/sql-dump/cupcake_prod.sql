CREATE DATABASE  IF NOT EXISTS `cupcake` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cupcake`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cupcake
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `cupcake_bottoms`
--

DROP TABLE IF EXISTS `cupcake_bottoms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cupcake_bottoms` (
  `cupcake_bottom_id` int NOT NULL AUTO_INCREMENT,
  `cupcake_bottom_name` varchar(45) NOT NULL,
  `cupcake_bottom_price` double NOT NULL,
  PRIMARY KEY (`cupcake_bottom_id`),
  UNIQUE KEY `cupcake_bottom_id_UNIQUE` (`cupcake_bottom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupcake_bottoms`
--

LOCK TABLES `cupcake_bottoms` WRITE;
/*!40000 ALTER TABLE `cupcake_bottoms` DISABLE KEYS */;
INSERT INTO `cupcake_bottoms` VALUES (1,'Chocolate',5),(2,'Vanilla',5),(3,'Nutmeg',5),(4,'Pistacio',6),(5,'Almond',7);
/*!40000 ALTER TABLE `cupcake_bottoms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupcake_tops`
--

DROP TABLE IF EXISTS `cupcake_tops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cupcake_tops` (
  `cupcake_top_id` int NOT NULL AUTO_INCREMENT,
  `cupcake_top_name` varchar(45) NOT NULL,
  `cupcake_top_price` double NOT NULL,
  PRIMARY KEY (`cupcake_top_id`),
  UNIQUE KEY `cupcake_top_id_UNIQUE` (`cupcake_top_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupcake_tops`
--

LOCK TABLES `cupcake_tops` WRITE;
/*!40000 ALTER TABLE `cupcake_tops` DISABLE KEYS */;
INSERT INTO `cupcake_tops` VALUES (1,'Chocolate',5),(2,'Blueberry',5),(3,'Raspberry',5),(4,'Crispy',6),(5,'Strawberry',6),(6,'Rum/Raisin',7),(7,'Orange',8),(8,'Lemon',8),(9,'Blue Cheese',9);
/*!40000 ALTER TABLE `cupcake_tops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupcakes`
--

DROP TABLE IF EXISTS `cupcakes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cupcakes` (
  `cupcake_id` int NOT NULL AUTO_INCREMENT,
  `cupcake_bottom_id` int NOT NULL,
  `cupcake_top_id` int NOT NULL,
  `cupcake_price` double NOT NULL,
  PRIMARY KEY (`cupcake_id`),
  UNIQUE KEY `product_id_UNIQUE` (`cupcake_id`),
  KEY `fk_cupcakes_cupcake_bottoms1_idx` (`cupcake_bottom_id`),
  KEY `fk_cupcakes_cupcake_tops1_idx` (`cupcake_top_id`),
  CONSTRAINT `fk_cupcakes_cupcake_bottoms1` FOREIGN KEY (`cupcake_bottom_id`) REFERENCES `cupcake_bottoms` (`cupcake_bottom_id`),
  CONSTRAINT `fk_cupcakes_cupcake_tops1` FOREIGN KEY (`cupcake_top_id`) REFERENCES `cupcake_tops` (`cupcake_top_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupcakes`
--

LOCK TABLES `cupcakes` WRITE;
/*!40000 ALTER TABLE `cupcakes` DISABLE KEYS */;
/*!40000 ALTER TABLE `cupcakes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `users_user_id` int NOT NULL,
  `cupcake_bot` int NOT NULL,
  `cupcake_top` int NOT NULL,
  `amount` int NOT NULL,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_orders_users_idx` (`users_user_id`),
  KEY `fk_order_cupcake_top_idx` (`cupcake_top`),
  KEY `fk_order_cupcake_bot_idx` (`cupcake_bot`),
  CONSTRAINT `fk_order_cupcake_bot` FOREIGN KEY (`cupcake_bot`) REFERENCES `cupcake_bottoms` (`cupcake_bottom_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_cupcake_top` FOREIGN KEY (`cupcake_top`) REFERENCES `cupcake_tops` (`cupcake_top_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orders_users` FOREIGN KEY (`users_user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (13,3925696,5,1,1,1,'2021-11-15 20:15:01'),(14,3629684,5,1,1,1,'2021-11-15 20:16:46'),(15,9266919,5,5,5,2,'2021-11-15 20:17:15'),(19,7051213,5,1,1,1,'2021-11-15 22:56:32'),(20,7051213,5,1,5,1,'2021-11-15 22:56:32'),(21,3474960,5,2,2,5,'2021-11-15 23:00:56'),(22,3474960,5,1,4,5,'2021-11-15 23:00:56'),(23,9630576,1,5,8,5,'2021-11-16 16:17:08'),(24,9630576,1,1,4,3,'2021-11-16 16:17:08'),(30,5606677,5,2,3,5,'2021-11-18 07:00:22'),(31,3462547,1,2,4,6,'2021-11-18 08:25:37'),(32,3462547,1,1,3,5,'2021-11-18 08:25:37'),(33,3462547,1,2,2,8,'2021-11-18 08:25:37');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  `balance` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'barbie@world.dk','jensen','customer',34),(2,'ken@world.com','jensen','customer',107),(3,'robin@gotham.com','batman','employee',0),(5,'test@test.com','123','customer',288),(6,'admin','123','employee',12);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-18 12:29:41
