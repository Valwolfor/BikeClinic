-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: motor_clinic
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `service_order`
--

DROP TABLE IF EXISTS `service_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `advance` varchar(255) NOT NULL,
  `advance_value` decimal(38,2) DEFAULT NULL,
  `date` datetime(6) NOT NULL,
  `diagnostic_desc` varchar(255) DEFAULT NULL,
  `documents` varchar(255) NOT NULL,
  `motorcycle_plate` varchar(6) NOT NULL,
  `reason` varchar(255) NOT NULL,
  `route_auth` tinyint(1) NOT NULL DEFAULT '0',
  `motorcycle_id` bigint NOT NULL,
  `status_id` bigint NOT NULL,
  `user_id_mech` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `status_id_UNIQUE` (`status_id`),
  KEY `fk_service_order_motorcycle1_idx` (`motorcycle_id`),
  KEY `fk_service_order_status1_idx` (`status_id`),
  KEY `fk_service_order_user1_idx` (`user_id_mech`),
  CONSTRAINT `fk_service_order_motorcycle1` FOREIGN KEY (`motorcycle_id`) REFERENCES `motorcycle` (`id`),
  CONSTRAINT `fk_service_order_status1` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`),
  CONSTRAINT `fk_service_order_user1` FOREIGN KEY (`user_id_mech`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_order`
--

LOCK TABLES `service_order` WRITE;
/*!40000 ALTER TABLE `service_order` DISABLE KEYS */;
INSERT INTO `service_order` (`id`, `advance`, `advance_value`, `date`, `diagnostic_desc`, `documents`, `motorcycle_plate`, `reason`, `route_auth`, `motorcycle_id`, `status_id`, `user_id_mech`) VALUES (30,'Yes',100.80,'2023-11-09 12:30:00.000000','SomeDiagnosticDescValue','Ninguno','ABC123','SomeReasonValue',0,101,66,311);
/*!40000 ALTER TABLE `service_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-12 18:32:32
