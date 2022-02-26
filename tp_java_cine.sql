-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: tp_java_cine
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

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
-- Table structure for table `butaca_funcion`
--

DROP TABLE IF EXISTS `butaca_funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `butaca_funcion` (
  `numero` int NOT NULL,
  `nro_sala` int NOT NULL,
  `cod_pelicula` int NOT NULL,
  `fecha_hora_funcion` datetime NOT NULL,
  `estado` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`numero`,`nro_sala`,`cod_pelicula`,`fecha_hora_funcion`),
  KEY `fk_butaca_funcion_funcion_idx` (`nro_sala`,`cod_pelicula`,`fecha_hora_funcion`),
  CONSTRAINT `fk_butaca_funcion_funcion` FOREIGN KEY (`nro_sala`, `cod_pelicula`, `fecha_hora_funcion`) REFERENCES `funcion` (`numero_sala`, `codigo_pelicula`, `fecha_hora`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `butaca_funcion`
--

LOCK TABLES `butaca_funcion` WRITE;
/*!40000 ALTER TABLE `butaca_funcion` DISABLE KEYS */;
INSERT INTO `butaca_funcion` VALUES (1,1,2,'2022-10-10 20:00:00','1'),(1,1,3,'2022-02-08 20:00:00','0'),(1,2,4,'2022-02-09 21:30:00','0'),(2,1,2,'2022-10-10 20:00:00','1'),(2,1,3,'2022-02-08 20:00:00','0'),(2,2,4,'2022-02-09 21:30:00','1'),(3,1,2,'2022-10-10 20:00:00','0'),(3,1,3,'2022-02-08 20:00:00','0'),(3,2,4,'2022-02-09 21:30:00','0'),(4,1,2,'2022-10-10 20:00:00','0'),(4,1,3,'2022-02-08 20:00:00','0'),(4,2,4,'2022-02-09 21:30:00','0'),(5,1,2,'2022-10-10 20:00:00','0'),(5,1,3,'2022-02-08 20:00:00','0'),(5,2,4,'2022-02-09 21:30:00','0'),(6,1,2,'2022-10-10 20:00:00','0'),(6,1,3,'2022-02-08 20:00:00','0'),(6,2,4,'2022-02-09 21:30:00','0'),(7,1,2,'2022-10-10 20:00:00','0'),(7,1,3,'2022-02-08 20:00:00','0'),(7,2,4,'2022-02-09 21:30:00','0'),(8,1,2,'2022-10-10 20:00:00','0'),(8,1,3,'2022-02-08 20:00:00','0'),(8,2,4,'2022-02-09 21:30:00','0'),(9,1,2,'2022-10-10 20:00:00','0'),(9,1,3,'2022-02-08 20:00:00','0'),(9,2,4,'2022-02-09 21:30:00','0'),(10,1,2,'2022-10-10 20:00:00','0'),(10,1,3,'2022-02-08 20:00:00','0'),(10,2,4,'2022-02-09 21:30:00','0'),(11,1,2,'2022-10-10 20:00:00','0'),(11,1,3,'2022-02-08 20:00:00','0'),(11,2,4,'2022-02-09 21:30:00','0'),(12,1,2,'2022-10-10 20:00:00','0'),(12,1,3,'2022-02-08 20:00:00','0'),(12,2,4,'2022-02-09 21:30:00','0'),(13,1,2,'2022-10-10 20:00:00','0'),(13,1,3,'2022-02-08 20:00:00','0'),(13,2,4,'2022-02-09 21:30:00','0'),(14,1,2,'2022-10-10 20:00:00','0'),(14,1,3,'2022-02-08 20:00:00','0'),(14,2,4,'2022-02-09 21:30:00','0'),(15,1,2,'2022-10-10 20:00:00','0'),(15,1,3,'2022-02-08 20:00:00','0'),(15,2,4,'2022-02-09 21:30:00','0'),(16,1,2,'2022-10-10 20:00:00','0'),(16,1,3,'2022-02-08 20:00:00','0'),(16,2,4,'2022-02-09 21:30:00','0'),(17,1,2,'2022-10-10 20:00:00','0'),(17,1,3,'2022-02-08 20:00:00','0'),(17,2,4,'2022-02-09 21:30:00','0'),(18,1,2,'2022-10-10 20:00:00','0'),(18,1,3,'2022-02-08 20:00:00','0'),(18,2,4,'2022-02-09 21:30:00','0'),(19,1,2,'2022-10-10 20:00:00','0'),(19,1,3,'2022-02-08 20:00:00','0'),(19,2,4,'2022-02-09 21:30:00','0'),(20,1,2,'2022-10-10 20:00:00','0'),(20,1,3,'2022-02-08 20:00:00','0'),(20,2,4,'2022-02-09 21:30:00','0'),(21,1,2,'2022-10-10 20:00:00','0'),(21,1,3,'2022-02-08 20:00:00','0'),(21,2,4,'2022-02-09 21:30:00','0'),(22,1,2,'2022-10-10 20:00:00','0'),(22,1,3,'2022-02-08 20:00:00','0'),(22,2,4,'2022-02-09 21:30:00','0'),(23,1,2,'2022-10-10 20:00:00','0'),(23,1,3,'2022-02-08 20:00:00','0'),(23,2,4,'2022-02-09 21:30:00','0'),(24,1,2,'2022-10-10 20:00:00','0'),(24,1,3,'2022-02-08 20:00:00','0'),(24,2,4,'2022-02-09 21:30:00','0'),(25,1,2,'2022-10-10 20:00:00','0'),(25,1,3,'2022-02-08 20:00:00','0'),(25,2,4,'2022-02-09 21:30:00','0'),(26,1,2,'2022-10-10 20:00:00','0'),(26,1,3,'2022-02-08 20:00:00','0'),(26,2,4,'2022-02-09 21:30:00','0'),(27,1,2,'2022-10-10 20:00:00','0'),(27,1,3,'2022-02-08 20:00:00','0'),(27,2,4,'2022-02-09 21:30:00','0'),(28,1,2,'2022-10-10 20:00:00','0'),(28,1,3,'2022-02-08 20:00:00','0'),(28,2,4,'2022-02-09 21:30:00','0'),(29,1,2,'2022-10-10 20:00:00','0'),(29,1,3,'2022-02-08 20:00:00','0'),(29,2,4,'2022-02-09 21:30:00','0'),(30,1,2,'2022-10-10 20:00:00','0'),(30,1,3,'2022-02-08 20:00:00','0'),(30,2,4,'2022-02-09 21:30:00','0'),(31,1,2,'2022-10-10 20:00:00','0'),(31,1,3,'2022-02-08 20:00:00','0'),(31,2,4,'2022-02-09 21:30:00','0'),(32,1,2,'2022-10-10 20:00:00','0'),(32,1,3,'2022-02-08 20:00:00','0'),(32,2,4,'2022-02-09 21:30:00','0'),(33,1,2,'2022-10-10 20:00:00','0'),(33,1,3,'2022-02-08 20:00:00','0'),(33,2,4,'2022-02-09 21:30:00','0'),(34,1,2,'2022-10-10 20:00:00','0'),(34,1,3,'2022-02-08 20:00:00','0'),(34,2,4,'2022-02-09 21:30:00','0'),(35,1,2,'2022-10-10 20:00:00','0'),(35,1,3,'2022-02-08 20:00:00','0'),(35,2,4,'2022-02-09 21:30:00','0'),(36,1,2,'2022-10-10 20:00:00','0'),(36,1,3,'2022-02-08 20:00:00','0'),(36,2,4,'2022-02-09 21:30:00','0'),(37,1,2,'2022-10-10 20:00:00','0'),(37,1,3,'2022-02-08 20:00:00','0'),(37,2,4,'2022-02-09 21:30:00','0'),(38,1,2,'2022-10-10 20:00:00','0'),(38,1,3,'2022-02-08 20:00:00','0'),(38,2,4,'2022-02-09 21:30:00','0'),(39,1,2,'2022-10-10 20:00:00','0'),(39,1,3,'2022-02-08 20:00:00','0'),(39,2,4,'2022-02-09 21:30:00','0'),(40,1,2,'2022-10-10 20:00:00','0'),(40,1,3,'2022-02-08 20:00:00','0'),(40,2,4,'2022-02-09 21:30:00','0'),(41,1,2,'2022-10-10 20:00:00','0'),(41,1,3,'2022-02-08 20:00:00','0'),(41,2,4,'2022-02-09 21:30:00','0'),(42,1,2,'2022-10-10 20:00:00','0'),(42,1,3,'2022-02-08 20:00:00','0'),(42,2,4,'2022-02-09 21:30:00','0'),(43,1,2,'2022-10-10 20:00:00','0'),(43,1,3,'2022-02-08 20:00:00','0'),(43,2,4,'2022-02-09 21:30:00','0'),(44,1,2,'2022-10-10 20:00:00','0'),(44,1,3,'2022-02-08 20:00:00','0'),(44,2,4,'2022-02-09 21:30:00','0'),(45,1,2,'2022-10-10 20:00:00','0'),(45,1,3,'2022-02-08 20:00:00','0'),(45,2,4,'2022-02-09 21:30:00','0'),(46,1,2,'2022-10-10 20:00:00','0'),(46,1,3,'2022-02-08 20:00:00','0'),(46,2,4,'2022-02-09 21:30:00','0'),(47,1,2,'2022-10-10 20:00:00','0'),(47,1,3,'2022-02-08 20:00:00','0'),(47,2,4,'2022-02-09 21:30:00','0'),(48,1,2,'2022-10-10 20:00:00','0'),(48,1,3,'2022-02-08 20:00:00','0'),(48,2,4,'2022-02-09 21:30:00','0');
/*!40000 ALTER TABLE `butaca_funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificacion` (
  `codigo_calificacion` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`codigo_calificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
INSERT INTO `calificacion` VALUES (2,'+13 (Apta para mayores de 13)'),(3,'+16 (Apta para mayores de 16 anios) '),(4,'+18 (Apta para mayores de 18 anios) '),(5,'ATP (Apta para todo publico)');
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dni` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `apellido` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `edad` int NOT NULL,
  `telefono` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `habilitado` tinyint NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('123','raul','perez','rp@gmail.com','123456',38,'35654',0),('42185113','Marisol','Torres','marisooltorrees@gmail.com','m7EZN7pLMASWL59',22,'3412472671',0),('456','juan','gomez','jg@gmail.com','123456',22,'1547856',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costo_entrada`
--

DROP TABLE IF EXISTS `costo_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `costo_entrada` (
  `fecha_desde` date NOT NULL,
  `costo` double NOT NULL,
  PRIMARY KEY (`fecha_desde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costo_entrada`
--

LOCK TABLES `costo_entrada` WRITE;
/*!40000 ALTER TABLE `costo_entrada` DISABLE KEYS */;
INSERT INTO `costo_entrada` VALUES ('2022-01-20',500),('2022-01-21',600),('2022-01-25',400),('2022-02-01',500);
/*!40000 ALTER TABLE `costo_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `numero_butaca` int NOT NULL,
  `nro_sala` int NOT NULL,
  `cod_pelicula` int NOT NULL,
  `fecha_hora_funcion` datetime NOT NULL,
  `total` double NOT NULL,
  `dni` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`numero_butaca`,`nro_sala`,`cod_pelicula`,`fecha_hora_funcion`),
  KEY `fk_entrada_butaca_idx` (`numero_butaca`,`nro_sala`,`cod_pelicula`,`fecha_hora_funcion`),
  KEY `fk_entrada_cliente` (`dni`),
  CONSTRAINT `fk_entrada_butaca` FOREIGN KEY (`numero_butaca`, `nro_sala`, `cod_pelicula`, `fecha_hora_funcion`) REFERENCES `butaca_funcion` (`numero`, `nro_sala`, `cod_pelicula`, `fecha_hora_funcion`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_entrada_cliente` FOREIGN KEY (`dni`) REFERENCES `cliente` (`dni`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,1,2,'2022-10-10 20:00:00',500,'123'),(2,1,2,'2022-10-10 20:00:00',500,'123'),(2,2,4,'2022-02-09 21:30:00',500,'123');
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcion` (
  `codigo_pelicula` int NOT NULL AUTO_INCREMENT,
  `fecha_hora` datetime NOT NULL,
  `numero_sala` int NOT NULL,
  PRIMARY KEY (`codigo_pelicula`,`fecha_hora`,`numero_sala`),
  KEY `fk_funcion_sala_idx` (`numero_sala`),
  CONSTRAINT `fk_funcion_pelicula` FOREIGN KEY (`codigo_pelicula`) REFERENCES `pelicula` (`codigo`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_funcion_sala` FOREIGN KEY (`numero_sala`) REFERENCES `sala` (`numero`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES (2,'2022-10-10 20:00:00',1),(3,'2022-02-08 20:00:00',1),(4,'2022-02-09 21:30:00',2);
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `idGenero` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Drama'),(2,'Romance'),(3,'Accion'),(4,'Terror'),(5,'Suspenso'),(6,'Comedia');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `sinopsis` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `director` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `duracion` double NOT NULL,
  `portada` varchar(900) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `fecha_estreno` date DEFAULT NULL,
  `codigo_calificacion` int DEFAULT NULL,
  `id_genero` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_pelicula_calificacion_idx` (`codigo_calificacion`),
  KEY `fk_pelicula_genero_idx` (`id_genero`),
  CONSTRAINT `fk_pelicula_calificacion` FOREIGN KEY (`codigo_calificacion`) REFERENCES `calificacion` (`codigo_calificacion`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_pelicula_genero` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`idGenero`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (2,'titanic','relata la relacin de Jack Dawson y Rose DeWitt Bukater, dos venes que se conocen y se enamoran a bordo del transatlntico RMS Titanic en su viaje inaugural desde Southampton, Inglaterra a Nueva York, EE. UU., en abril de 1912.','James Cameron',45,'https://live.staticflickr.com/65535/51559548200_b22b26fbb3_m.jpg','1984-06-26',2,1),(3,'EL juego del miedo','Adam y Lawrence se despiertan encadenados en un sucio baÃ±o con un cadÃ¡ver entre ellos. Su secuestrador es un loco conocido como Jigsaw cuyo juego consiste en forzar a sus cautivos a herirse a si mismos o a otros con tal de permanecer vivos','Pepito',92,'https://live.staticflickr.com/65535/51558623296_51e3dfdb58_m.jpg','2021-05-05',5,6),(4,'El conjuro','Narra los encuentros sobrenaturales que viviÃ³ la familia Perron en su casa de Rhode Island a principios de los 70. Ed y Lorraine Warren, investigadores de renombre en el mundo de los fenÃ³menos paranormales, acuden a la llamada de una familia aterrorizada por la presencia en su granja de un ser maligno.','Juan Jose',90,'https://live.staticflickr.com/65535/51558856383_43594a7227_m.jpg','2021-10-02',3,4),(22,'SPIDER-MAN: NO WAY HOME','Tras descubrirse la identidad secreta de Peter Parker como Spider-Man, la vida del joven se vuelve una locura. Peter decide pedirle ayuda al Doctor Extraño para recuperar su vida. Pero algo sale mal y provoca una fractura en el multiverso.','Jon Watts',90,'https://i0.wp.com/hipertextual.com/wp-content/uploads/2021/11/spider-man-sin-camino-a-casa.jpg?fit=2160%2C1432&ssl=1','2022-02-23',2,3);
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `numero` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,'pantalla 3d con 6 reflectores de sonido'),(2,'pantalla 3d con 4 reflectores de sonido'),(12,'pantalla 3d con 10 reflectores de sonido');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tp_java_cine'
--
/*!50003 DROP PROCEDURE IF EXISTS `obtener_costo_actual` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`marisol`@`localhost` PROCEDURE `obtener_costo_actual`()
BEGIN
drop temporary table if exists ultimo;
	create temporary table ultimo
	select max(fecha_desde) ultima
	from costo_entrada
	where fecha_desde <= current_date;

	select ce.costo, u.ultima
	from costo_entrada ce
	inner join ultimo u
	on ce.fecha_desde=u.ultima;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-25 21:45:25
