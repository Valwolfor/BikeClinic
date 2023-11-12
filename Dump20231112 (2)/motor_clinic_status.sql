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
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brake_fluid` varchar(255) NOT NULL,
  `brakes` varchar(255) NOT NULL,
  `chain` varchar(255) NOT NULL,
  `chassis` varchar(255) NOT NULL,
  `clutch` varchar(255) NOT NULL,
  `clutch_fluid` varchar(255) NOT NULL,
  `coolant` varchar(255) NOT NULL,
  `engine` varchar(255) NOT NULL,
  `exhaust` varchar(255) NOT NULL,
  `foot_pegs` varchar(255) NOT NULL,
  `front_tire` varchar(255) NOT NULL,
  `fuel` varchar(255) NOT NULL,
  `horn` varchar(255) NOT NULL,
  `indicators` varchar(255) NOT NULL,
  `indicators_desc` varchar(255) NOT NULL,
  `lights_good` varchar(255) NOT NULL,
  `mileage` varchar(255) NOT NULL,
  `mirrors` varchar(255) NOT NULL,
  `oil` varchar(255) NOT NULL,
  `oil_level` varchar(255) NOT NULL,
  `rear_tire` varchar(255) NOT NULL,
  `tank` varchar(255) NOT NULL,
  `throttle` varchar(255) NOT NULL,
  `transmission` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`id`, `brake_fluid`, `brakes`, `chain`, `chassis`, `clutch`, `clutch_fluid`, `coolant`, `engine`, `exhaust`, `foot_pegs`, `front_tire`, `fuel`, `horn`, `indicators`, `indicators_desc`, `lights_good`, `mileage`, `mirrors`, `oil`, `oil_level`, `rear_tire`, `tank`, `throttle`, `transmission`) VALUES (66,'SomeBrakeFluidValue','SomeBrakesValue','SomeChainValue','SomeChassisValue','SomeClutchValue','SomeClutchFluidValue','SomeCoolantValue','SomeEngineValue','SomeExhaustValue','SomeFootPegsValue','SomeFrontTireValue','SomeFuelValue','SomeHornValue','SomeIndicatorsValue','SomeIndicatorsDescValue','SomeLightsGoodValue','SomeMileageValue','SomeMirrorsValue','SomeOilValue','SomeOilLevelValue','SomeRearTireValue','SomeTankValue','SomeThrottleValue','SomeTransmissionValue');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-12 18:32:33
