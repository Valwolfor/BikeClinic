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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `type_id` varchar(255) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKr9okrktxscw3omxi1wm7cg18u` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('CC',306),('CC',316),('CC',317),('CC',318),('CC',319);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorcycle`
--

DROP TABLE IF EXISTS `motorcycle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motorcycle` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `chassis_id` varchar(255) NOT NULL,
  `engine_id` varchar(255) NOT NULL,
  `model` varchar(255) DEFAULT NULL,
  `plate` varchar(255) NOT NULL,
  `registration_year` varchar(255) NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `engine_id_UNIQUE` (`engine_id`),
  UNIQUE KEY `plate_UNIQUE` (`plate`),
  UNIQUE KEY `chassis_id_UNIQUE` (`chassis_id`),
  KEY `FK4tu7obo3gxky2p31gfb5xx98x` (`customer_id`),
  CONSTRAINT `FK4tu7obo3gxky2p31gfb5xx98x` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorcycle`
--

LOCK TABLES `motorcycle` WRITE;
/*!40000 ALTER TABLE `motorcycle` DISABLE KEYS */;
INSERT INTO `motorcycle` VALUES (101,'Ducati','C345','E345','Panigale','MNO346','2022',306),(110,'Pollito','CH324929493','EG21349329','Veloz','MGH34K','2021',316),(111,'Pollote','CH324912312','EG213493123123','Fuerte','FDG34K','2020',317),(122,'Rum Rum','CH32492949334534','EG21323434543','3000','MGT34T','2024',318),(123,'No Falla','CH32491221312','EG21349123s1','Hasta el KM','HER34Y','2006',319);
/*!40000 ALTER TABLE `motorcycle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contact_number` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=320 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (306,'987654321','nuevoemail@example.com','Pepito','Pata'),(309,'666666666','admin@example.com','Admin','LastName6'),(311,'666666666','mechanic@example.com','Mecha','LastName6'),(313,'3111111111','mechanic2@example.com','Veloz','Llave Floja'),(314,'3222222222','mechanic3@example.com','Lento','Llave Oxidada'),(315,'3333333333','mechanic4@example.com','Mala Mano','Falla Motor'),(316,'3233233232','tipo@example','Maraco','Suave Clitch'),(317,'3222222222','custumer4@example.com','Maranita','Llanta Dura'),(318,'323123234','custumer5@example.com','Pablito Camilo','Gato Jaramillo  '),(319,'3121212121','customer6@example.com','Tipo','Definitivo Final');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `product_value` decimal(38,2) NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id_product`),
  UNIQUE KEY `product_name_UNIQUE` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (23,'Kit de Herramientas',145000.00,16),(26,'Bujía ',14500.00,4),(27,'Aceite',42000.00,3),(28,'Lubricante Premium',25000.00,10),(29,'Kit de Empaques generico',15000.00,10),(30,'Liquido refrigerante',25000.00,5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record_serv_prod`
--

DROP TABLE IF EXISTS `record_serv_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record_serv_prod` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_approved` tinyint(1) NOT NULL DEFAULT '0',
  `product_id` int NOT NULL,
  `service_id` int NOT NULL,
  `order_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmolr3cwn53d12mpqc643q8c5v` (`product_id`),
  KEY `FKd81mp8mqsk08ntl0ioqsb0hit` (`service_id`),
  KEY `FK8g3wi821i94w9id532xkn0p34` (`order_id`),
  CONSTRAINT `FK8g3wi821i94w9id532xkn0p34` FOREIGN KEY (`order_id`) REFERENCES `service_order` (`id`),
  CONSTRAINT `FKd81mp8mqsk08ntl0ioqsb0hit` FOREIGN KEY (`service_id`) REFERENCES `service` (`id_service`),
  CONSTRAINT `FKmolr3cwn53d12mpqc643q8c5v` FOREIGN KEY (`product_id`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_serv_prod`
--

LOCK TABLES `record_serv_prod` WRITE;
/*!40000 ALTER TABLE `record_serv_prod` DISABLE KEYS */;
INSERT INTO `record_serv_prod` VALUES (4,0,23,14,30),(12,1,23,18,34),(13,1,28,18,35),(14,1,28,19,35),(15,1,23,14,35),(16,0,26,17,35),(17,1,26,17,36),(19,1,23,18,37),(20,1,26,17,37),(21,1,27,20,37),(23,1,29,21,37),(24,1,28,19,38),(25,1,23,18,38),(27,1,23,14,39),(28,1,26,17,39),(29,1,27,20,39),(30,1,29,21,39),(31,1,28,19,39),(34,0,26,17,40),(35,0,29,18,40),(36,1,27,20,40),(37,1,28,19,40);
/*!40000 ALTER TABLE `record_serv_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `id_service` int NOT NULL AUTO_INCREMENT,
  `service_detail` varchar(255) DEFAULT NULL,
  `service_name` varchar(255) NOT NULL,
  `service_value` decimal(38,2) NOT NULL,
  PRIMARY KEY (`id_service`),
  UNIQUE KEY `service_name_UNIQUE` (`service_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (14,'Detallazo azul','Kit de Herramientas',30000.00),(17,'Se remplaza la bujía por una funcional.\n','Cambio bujía',5000.00),(18,'Limpieza y calibración de frenos clutch ','Mantenimiento general',25000.00),(19,'Puede usarse grasa o lubricante especial según cliente. Se lubrican partes indicadas','Lubricación de componente',3000.00),(20,'Se retira el viejo y se llena con el aceite de eleción. Acme.inc preferiblemente','Cambio de Aceite',3500.00),(21,'Se retira empaques viejo y colocan los nuevos comprovando que no haya filtraciones','Cambio de empaques',25000.00),(22,'Se vacía el liquido existente y renueva con el elegido.','Cambio de Liquido refrigerante',500.00);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

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
  `date` date NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_order`
--

LOCK TABLES `service_order` WRITE;
/*!40000 ALTER TABLE `service_order` DISABLE KEYS */;
INSERT INTO `service_order` VALUES (30,'Yes',100.80,'2023-11-09','SomeDiagnosticDescValue','Ninguno','ABC123','SomeReasonValue',0,101,66,311),(34,'True',0.00,'2023-12-03','General','','MGH34K','2',1,110,74,313),(35,'True',0.00,'2023-12-03','Para viaje','','FDG34K','2',1,111,76,314),(36,'True',1233.00,'2023-12-04','Todo mal',', ','MGT34T','Reparación',1,122,88,314),(37,'True',0.00,'2023-12-04','Todo mal','','MGT34T','Reparación',1,122,90,313),(38,'False',0.00,'2023-12-04','Cadena suena extraño','','MGT34T','Mantenimiento',0,122,91,314),(39,'False',0.00,'2023-12-05','Salvar lo que se pueda','Tarjeta propiedad','HER34Y','Reparación',0,123,96,313),(40,'False',0.00,'2023-12-05','Básico',' ','MGH34K','Mantenimiento',0,110,97,313);
/*!40000 ALTER TABLE `service_order` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (66,'SomeBrakeFluidValue','SomeBrakesValue','SomeChainValue','SomeChassisValue','SomeClutchValue','SomeClutchFluidValue','SomeCoolantValue','SomeEngineValue','SomeExhaustValue','SomeFootPegsValue','SomeFrontTireValue','SomeFuelValue','SomeHornValue','SomeIndicatorsValue','SomeIndicatorsDescValue','SomeLightsGoodValue','SomeMileageValue','SomeMirrorsValue','SomeOilValue','SomeOilLevelValue','SomeRearTireValue','SomeTankValue','SomeThrottleValue','SomeTransmissionValue'),(74,'Apto','Aptos','Apto','Apto','Apto','No presenta','No presenta','Apto','Apto','Apto','Apto','1/2','Apto','Apto','','','10000','Aptos','Bueno','Lleno','Apto','Apto','Apto','Apto'),(75,'Apto','Aptos','No apto','Apto','Apto','No presenta','Presenta','Apto','Apto','Apto','Apto','1/2','Deteriorado','Apto','','','25000','Aptos','Regular','Medio','Apto','Apto','Apto','Apto'),(76,'Apto','Aptos','Apto','Apto','Apto','No presenta','Presenta','Apto','Apto','Apto','Apto','1/2','Apto','Apto','','','15000','Aptos','Regular','Medio','Apto','Apto','Apto','Apto'),(88,'Apto','Aptos','Apto','Apto','Apto','Presenta','Presenta','Apto','Apto','Apto','Apto','1/2','Apto','Apto','','','1122','Aptos','Bueno','Lleno','Apto','Apto','Apto','Apto'),(89,'No apto','No aptos','Apto','No apto','No apto','Presenta','Presenta','No apto','Apto','Apto','Apto','1/4','Deteriorado','No apto','','','12333','Deteriorados','Regular','Malo','No apto','Deteriorado','Apto','Apto'),(90,'Apto','No aptos','No apto','Apto','No apto','No presenta','No presenta','Apto','Apto','Apto','Apto','1/2','Deteriorado','No apto','','','12333','Aptos','Regular','Malo','Apto','Deteriorado','Apto','Apto'),(91,'Apto','Aptos','No apto','Apto','Apto','Presenta','Presenta','Apto','Apto','Apto','Apto','1/4','Apto','Apto','','','1223455','Aptos','Bueno','Lleno','Apto','Apto','Apto','Apto'),(94,'Apto','Aptos','Apto','No apto','Apto','No presenta','Presenta','No apto','Apto','Apto','Apto','1/4','Deteriorado','No apto','En rojo todo','Farola, Stop','1212','Aptos','Regular','Malo','Apto','Deteriorado','Apto','No apto'),(96,'No apto','No aptos','No apto','Apto','No apto','No presenta','No presenta','Apto','Apto','Apto','Apto','1/4','Apto','No apto','En rojo todo','Direcionales','59000','Deteriorados','Regular','Medio','No apto','Deteriorado','Apto','Apto'),(97,'Apto','No aptos','No apto','Apto','No apto','No presenta','No presenta','Apto','Apto','Apto','Apto','3/4','Apto','Apto',' ','Farola, Stop, Direcionales','25000','Aptos','Regular','Medio','Apto','Apto','Apto','Apto');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `password` varchar(255) NOT NULL,
  `roles` set('MECHANIC','ASSISTANT','ADMIN') NOT NULL DEFAULT 'ASSISTANT',
  `status` enum('ACTIVE','INACTIVE') NOT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `password_UNIQUE` (`password`),
  CONSTRAINT `FKrfqycm0yt2on7769pb3frk32r` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin','ADMIN','ACTIVE',309),('mecha','MECHANIC','ACTIVE',311),('mecha2','ASSISTANT','ACTIVE',313),('mecha3','ASSISTANT','ACTIVE',314),('mecha4','ASSISTANT','ACTIVE',315);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `roles` set('MECHANIC','ASSISTANT','ADMIN') DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  CONSTRAINT `user_roles_chk_1` CHECK ((`roles` between 0 and 2))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (309,NULL,'ADMIN'),(311,NULL,'MECHANIC'),(313,NULL,'MECHANIC'),(314,NULL,'MECHANIC'),(315,NULL,'MECHANIC');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-05 16:56:08
